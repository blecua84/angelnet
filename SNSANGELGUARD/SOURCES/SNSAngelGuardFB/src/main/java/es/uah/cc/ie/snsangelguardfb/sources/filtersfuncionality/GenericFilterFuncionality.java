/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.filtersfuncionality;

import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

/**
 * Controla la ejecucion de todos los filtros definidos en la aplicacion.
 *
 * @author tote
 */
public class GenericFilterFuncionality {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(GenericFilterFuncionality.class);

    /** Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;

    /**
     * Constructor de clase
     * 
     * @param snsObject: Clase Manager de la aplicacion
     */
    public GenericFilterFuncionality(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Obtiene el objeto manager de la aplicaci?n.
     *
     * @return SNSAngelGuardFBManager
     */
    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    /**
     * Establece en el objeto actual el objeto manager de la aplicaci?n.
     *
     * @param snsObject SNSAngelGuardFBManager Manager de la aplicaci?n.
     */
    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Comprueba si el usuario tiene activo el filtro desFilter
     *
     * @param desFilter: Tipo de filtro a comprobar
     * @return
     *  - true: Si el filtro est? activo
     *  - false: Si el filtro no est? activo
     */
    public boolean isActiveFilter(String desFilter) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isActiveFilter: Comprobando si el filtro " + desFilter + " est? activo...");
        boolean activeFilter = false;

        if (desFilter.equals("fltFriends")) {
            activeFilter = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltFriends().getActive().equals("1");
        } else if (desFilter.equals("fltWall")) {
            activeFilter = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltWall().getActive().equals("1");
        } else if (desFilter.equals("fltPriv")) {
            activeFilter = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltPriv().getActive().equals("1");
        } else if (desFilter.equals("fltVist")) {
            activeFilter = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getActive().equals("1");
        } 

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isActiveFilter: Filtro " + desFilter + " activo: " + activeFilter);

        return activeFilter;
    }

    /**
     * Pasa el filtro desFilter a cada uno de los angeles definidos para desFilter
     * por el usuario si cumplen las siguientes condiciones:
     *  - El filtro esta activo
     *  - El filtro tiene definido algun angel para su actividad.
     *  - El tiempo transcurrido desde la ultima comprobacion es superior al
     * tiempo definido por el usuario.
     *
     * @param request: Sesion web
     * @param desFilter: Tipo de filtro
     * @param uidAngel: Identificador del angel a comprobar.
     * @param mode: Angel activo
     * @param firstCheck: Indica si es la primera comprobacion
     * @return Resultado del paso del filtro
     *
     * @throws JSONException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws ParseException
     * @throws bsh.ParseException
     */
    public String checkFilter(HttpServletRequest request, String desFilter, String mode, boolean firstCheck) throws Exception{
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFilter: Inicio checkFilter para el filtro " + desFilter + "...");
        JSONObject jsonFilter = null;
        boolean isAnyAngel = false;
        boolean isActiveFilter = false;
        boolean isTimeToCheck = true;
        String result = "";
        String angels = "";

        this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().loadFilter(desFilter);
        try {
            isActiveFilter = this.isActiveFilter(desFilter);
        } catch (Exception e) {
            isActiveFilter = false;
        }

        angels = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getAngelsFilter(desFilter);
        if(angels != null){
            if (!angels.equals("")) {
                isAnyAngel = true;
            }
        }else{
            isAnyAngel = false;
        }

        if (mode.equals("1")) {
            isTimeToCheck = checkFilterToday(desFilter);
        }

        if (isAnyAngel && isActiveFilter && isTimeToCheck) {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFilter: Ejecutamos el filtro " + desFilter + " para obtener la informaci?n...");
            jsonFilter = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().updateFilter(desFilter);
            result = getResultCheckFilter(request, desFilter, firstCheck, jsonFilter);
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFilter: Filtro " + desFilter + " ejecutado!");
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFilter: Fin checkFilter para el filtro " + desFilter + "...");
        return result;
    }

    /**
     * Realiza el chequeo del filtro desFilter.
     *
     * @param request: Sesion Web
     * @param desFilter: Tipo de filtro
     * @param firstCheck: Indica si es la primera vez que se pasa el filtro
     * @param jsonFilter: Descripcion del filtro
     * @return Devuelve el resultado del chequeo del filtro desFilter
     *
     * @throws FileNotFoundException
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws ParseException
     * @throws bsh.ParseException
     */
    public String getResultCheckFilter(HttpServletRequest request, String desFilter, boolean firstCheck, JSONObject jsonFilter) throws Exception{
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getResultCheckFilter: Inicio getResultCheckFilter para el filtro " + desFilter + "...");
        String result = "";
        
        if (desFilter.equals("fltWall")) {
            result = this.snsObject.getWallFilterFuncionality().checkPostWall(request, firstCheck, jsonFilter);
        } else if (desFilter.equals("fltFriends")) {
            result = this.snsObject.getFriendsFilterFuncionality().checkFriends();
        } else if (desFilter.equals("fltPriv")) {
            result = "Filtro en construccion";
        } else if (desFilter.equals("fltVist")) {
            result = this.snsObject.getVisitsFilterFuncionality().checkVisitFilter(firstCheck);
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getResultCheckFilter: Fin getResultCheckFilter para el filtro " + desFilter + "...");
        return result;
    }

    /**
     * Realiza el chequeo inicial de todos los filtros disponibles en la aplicacion,
     * mandando un email al angel correspondiente con el resultado del chequeo. Puede lanzar excepciones del tipo
     * InterDataBaseException, InterProcessException o InterEmailException.
     *
     * @param request: Sesion Web
     * @param jsonAngel: JSON con informacion del angel al que se le va a notificar el chequeo.
     *
     * @throws JSONException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws ParseException
     * @throws bsh.ParseException
     */
    public void firstCheckAngelConfirmation(HttpServletRequest request, JSONObject jsonAngel) throws InterDataBaseException, InterProcessException, InterEmailException{
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - firstCheckAngelConfirmation: Inicio firstCheckAngelConfirmation...");

        try {
            String resultFltWall = this.checkFilter(request, "fltWall", "0", true);
            String resultFltFriends = this.checkFilter(request, "fltFriends", "0", true);
            String resultFltPriv = this.checkFilter(request, "fltPriv", "0", true);
            String resultFltVist = this.checkFilter(request, "fltVist", "0", true);

            // Mandamos email de confirmacion
            this.snsObject.getEmailObject().sendEmailCheck(resultFltWall, resultFltFriends, resultFltPriv, resultFltVist, jsonAngel);
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - firstCheckAngelConfirmation: Fin firstCheckAngelConfirmation...");
        } catch (Exception ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - firstCheckAngelConfirmation: Excepcion capturada Exception: " + ex.getMessage());
            this.snsObject.getExceptionManager().initControlException(ex);
        }
    }

    /**
     * Metodo que realiza los chequeos correspondientes fuera de sesion. Es el
     * metodo utilizado para hacer los chequeos en el momento del backup diario. Puede lanzar excepciones del tipo
     * InterDataBaseException, InterProcessException o InterEmailException.
     *
     * @param request: Sesion Web asociada a cada usuario, sin la cual no podemos acceder a las utilidades de Facebook.
     * @param angelsUser: JSONArray que contiene la informacion de los angeles definidos por el usuario y a quienes se les enviar?n las notificaciones.
     * 
     * @throws JSONException
     * @throws FileNotFoundException
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws ParseException
     * @throws bsh.ParseException
     */
    public void checkUserSettingsOffLine(HttpServletRequest request, JSONArray angelsUser) throws InterDataBaseException, InterProcessException, InterEmailException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkUserSettingsOffLine: Inicio checkUserSettingsOffLine...");
        
            try {
                String resultFltWall = this.checkFilter(request, "fltWall", "1", false);
                String resultFltFriends = this.checkFilter(request, "fltFriends", "1", false);
                String resultFltPriv = this.checkFilter(request, "fltPriv", "1", false);
                String resultFltVist = this.checkFilter(request, "fltVist", "1", false);

                /** Para cada angel definido por el usuario realizamos el envio de la informaci?n */
                for (int j = 0; j < angelsUser.length(); j++) {
                    JSONObject jsonAngel = angelsUser.getJSONObject(j);
                    if (jsonAngel.getString("acceptAngel").equals("1")) {
                        this.snsObject.getEmailObject().sendEmailCheck(resultFltWall, resultFltFriends, resultFltPriv, resultFltVist, jsonAngel);
                    }
                }
            } catch (Exception ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkUserSettingsOffLine: Excepcion capturada Exception: " + ex.getMessage());
                this.snsObject.getExceptionManager().initControlException(ex);
            }
        
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkUserSettingsOffLine: Fin checkUserSettingsOffLine...");
    }

    /**
     * Indica si el filtro desFilter se debe pasar hoy. Puede lanzar excepciones del tipo Exception.
     * @param desFilter: Tipo de filtro a pasar.
     * @return
     *  - true: Si le corresponde ser ejecutado hoy.
     *  - false: Si no le corresponde ser ejecutado hoy.
     *
     * @throws JSONException
     * @throws ParseException
     */
    public boolean checkFilterToday(String desFilter) throws Exception {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFilterToday: Inicio checkFilterToday...");
        long proxCheck = 0;
        Date lastCheck = null;

        if (desFilter.equals("fltWall")) {
            lastCheck = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltWall().getLastCheck();
            proxCheck = this.snsObject.getDateTimeUtilities().getNextCheckTime(Integer.parseInt(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltWall().getFrec()), lastCheck);
        } else if (desFilter.equals("fltFriends")) {
            lastCheck = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltFriends().getLastCheck();
            proxCheck = this.snsObject.getDateTimeUtilities().getNextCheckTime(Integer.parseInt(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltFriends().getFrec()), lastCheck);
        } else if (desFilter.equals("fltPriv")) {
            lastCheck = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltPriv().getLastCheck();
            proxCheck = this.snsObject.getDateTimeUtilities().getNextCheckTime(Integer.parseInt(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltPriv().getFrec()), lastCheck);
        } else if (desFilter.equals("fltVist")) {
            lastCheck = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getLastCheck();
            proxCheck = this.snsObject.getDateTimeUtilities().getNextCheckTime(Integer.parseInt(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getFrec()), lastCheck);
        }

        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFilterToday: Proximo chequeo a realizar en fecha: " + new Date(proxCheck) + ", Ultimo chequeo realizado en fecha: " + new Date(lastCheck.getTime()));
        Calendar timeNow = Calendar.getInstance();

        if (proxCheck > timeNow.getTimeInMillis()) {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFilterToday: Fin checkFilterToday. No se realizar? el chequeo para el filtro " + desFilter);
            return false;
        } else {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFilterToday: Fin checkFilterToday. Se realizar? el chequeo para el filtro " + desFilter);
            return true;
        }
    }
}
