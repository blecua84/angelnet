package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.entity;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import es.uah.cc.ie.snsangelguardfb.sources.dao.entity.UserSettings_SettingsFilterDAO;
import es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.GenericJSPControler;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.openide.util.Exceptions;

/**
 * Controla la ejecucion de la pagina checkNow.jsp
 * 
 * @author tote
 */
public class CheckNowJSPControler extends GenericJSPControler{

    /** Logger Class */
    private static Logger logger = Logger.getLogger(CheckNowJSPControler.class);

    /** Clase Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;

    /** Atributo request de la sesion */
    private HttpServletRequest request;

    /** Atributo response de la sesion */
    private HttpServletResponse response;

    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }
    
    

   /**
    * Constructor de clase.
    *
    * @param snsObject SNSAngelGuardFBManager
    * @param request HttpServletRequest
    * @param response HttpServletResponse
    */
    public CheckNowJSPControler(HttpServletRequest request, HttpServletResponse response) throws InterDataBaseException, InterProcessException, InterEmailException {
        try {
            this.snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
            this.request = request;
            this.response = response;
        } catch (FileNotFoundException ex) {
            this.snsObject.getExceptionManager().initControlException(ex);
        } catch (IOException ex) {
            this.snsObject.getExceptionManager().initControlException(ex);
        }
    }


    @Override
    public void process() throws InterDataBaseException, InterProcessException, InterEmailException {
        try {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - process: Inicio process...");

            this.snsObject.logSession(request, response);

            // Cargamos la informaci?n de los filtros en la aplicaci?n
            loadFilters();

            // Actualizamos la informaci?n del usuario y volvemos a la p?gina de configuraci?n
            updateInformationAndReturn();
        } catch (Exception e) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateInformationAndReturn: Excepcion capturada GenericException: " + e.getMessage());
            logger.fatal(e);
            this.snsObject.getExceptionManager().initControlException(e);
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - process: Fin process...");
    }

    /**
     * Carga la informacion de los filtros obtenida de la pagina de configuracion
     * para, posteriormente, ser guardada en la base de datos. Podr? lanzar excepciones del tipo UnsupportedEncodingException.
     * 
     * @throws UnsupportedEncodingException 
     */
    private void loadFilters() throws UnsupportedEncodingException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Inicio loadFilters...");
        request.setCharacterEncoding("UTF-8");
        HttpSession sesion = request.getSession(false);

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Amigos elegidos como angeles: " + sesion.getAttribute("hdAngels"));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Angeles seleccionados de Google: " + request.getParameter("hdAngelsGoogleSelected"));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Angeles ED: " + request.getParameter("hdAngelsEd"));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Lista de Angeles del filtro de control de lenguaje: " + request.getParameter("hdLstAngelsFltWall"));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Lista de Angeles del filtro de control de amigos: " + request.getParameter("hdLstAngelsFltFriends"));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Lista de Angeles del filtro de control de privacidad: " + request.getParameter("hdLstAngelsFltPriv"));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Lista de Angeles del filtro de control de visitas: " + request.getParameter("hdLstAngelsFltVist"));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Filtro de control de lenguaje activo: " + ("1".equals(request.getParameter("hdActiveFltWall")) ? true : false));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Filtro de control de amigos activo: " + ("1".equals(request.getParameter("hdActiveFltFriends")) ? true : false));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Filtro de control de privacidad activo: " + ("1".equals(request.getParameter("hdActiveFltPriv")) ? true : false));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Filtro de control de visitas activo: " + ("1".equals(request.getParameter("hdActiveFltVist")) ? true : false));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Frecuencia del filtro de control de lenguaje: " + getStrFrecuencyFilter(request.getParameter("hdFrecFltWall")));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Frecuencia del filtro de control de amigos: " + getStrFrecuencyFilter(request.getParameter("hdFrecFltFriends")));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Frecuencia del filtro de control de privacidad: " + getStrFrecuencyFilter(request.getParameter("hdFrecFltPriv")));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Frecuencia del filtro de control de visitas: " + getStrFrecuencyFilter(request.getParameter("hdFrecFltVist")));

        // Cargamos todas las variables obtenidas de la p?gina de configuraci?n de la aplicaci?n

        String hdLstAngelsFltWall = request.getParameter("hdLstAngelsFltWall");
        String hdLstAngelsFltFriends = request.getParameter("hdLstAngelsFltFriends");
        String hdLstAngelsFltPriv = request.getParameter("hdLstAngelsFltPriv");
        String hdLstAngelsFltVist = request.getParameter("hdLstAngelsFltVist");
        String hdActiveFltWall = request.getParameter("hdActiveFltWall");
        String hdActiveFltFriends = request.getParameter("hdActiveFltFriends");
        String hdActiveFltPriv = request.getParameter("hdActiveFltPriv");
        String hdActiveFltVist = request.getParameter("hdActiveFltVist");
        String hdFrecFltWall = request.getParameter("hdFrecFltWall");
        String hdFrecFltFriends = request.getParameter("hdFrecFltFriends");
        String hdFrecFltPriv = request.getParameter("hdFrecFltPriv");
        String hdFrecFltVist = request.getParameter("hdFrecFltVist");

        Long uidLong = (new Double(snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid())).longValue();

        // Cargamos la configuraci?n del filtro de control de lenguaje
        UserSettings_SettingsFilterDAO fltWall = new UserSettings_SettingsFilterDAO(snsObject.getUserSettingsDaoManager(), uidLong, hdFrecFltWall, hdLstAngelsFltWall, hdActiveFltWall, uidLong, new Date());
        snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setFltWall(fltWall);

        // Cargamos la configuraci?n del filtro de control de amigos
        UserSettings_SettingsFilterDAO fltFriends = new UserSettings_SettingsFilterDAO(snsObject.getUserSettingsDaoManager(), uidLong, hdFrecFltFriends, hdLstAngelsFltFriends, hdActiveFltFriends, uidLong, new Date());
        snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setFltFriends(fltFriends);

        // Cargamos la configuraci?n del filtro de control de privacidad
        UserSettings_SettingsFilterDAO fltPriv = new UserSettings_SettingsFilterDAO(snsObject.getUserSettingsDaoManager(), uidLong, hdFrecFltPriv, hdLstAngelsFltPriv, hdActiveFltPriv, uidLong, new Date());
        snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setFltPriv(fltPriv);

        // Cargamos la configuraci?n del filtro de control de visitas
        UserSettings_SettingsFilterDAO fltVist = new UserSettings_SettingsFilterDAO(snsObject.getUserSettingsDaoManager(), uidLong, hdFrecFltVist, hdLstAngelsFltVist, hdActiveFltVist, uidLong, new Date());
        snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setFltVist(fltVist);


        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilters: Fin loadFilters...");
    }

/**
     * Actualiza la informacion del usuario y vuelve a la pagina de configuracion de la aplicacion. Podra lanzar excepciones del
     * tipo UniformInterfaceException, IOException, JSONException, NoSuchProviderException, MessagingException, MySQLIntegrityConstraintViolationException, InterDataBaseException, InterProcessException o InterEmailException.
     * 
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws JSONException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws MySQLIntegrityConstraintViolationException
     * @throws InterDataBaseException
     * @throws InterProcessException
     * @throws InterEmailException 
     */
    public void updateInformationAndReturn() throws UniformInterfaceException, IOException, JSONException, NoSuchProviderException, MessagingException, MySQLIntegrityConstraintViolationException, InterDataBaseException, InterProcessException, InterEmailException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateInformationAndReturn: Inicio updateInformationAndReturn...");

        snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setAppActivated(true);
        snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setLegalAccepted(true);
        snsObject.getUserSettingsDaoManager().getUserSettingsDAO().updateLastCheckUS();

        String activeFilters = request.getParameter("hdActiveFltWall") + ";" + request.getParameter("hdActiveFltFriends")
                + ";" + request.getParameter("hdActiveFltPriv") + ";" + request.getParameter("hdActiveFltVist");


        snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setAngelsUserSettings(activeFilters, snsObject.isNewConnection());

        snsObject.getUserSettingsDaoManager().getUserInfo(false);

        // Cerramos la conexi?n con la Base de Datos
        snsObject.getLocaleSettingsDaoManager().getSnsObject().cerrarConexionSNS();

        // Volvemos a la pagina de configuraci?n
        response.sendRedirect(request.getContextPath() + "/settingsSNSAngelGuard.jsp?newConection=1&ok=1");
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateInformationAndReturn: Fin updateInformationAndReturn...");
    }

    /**
     * Obtiene la descripcion de la frecuencia definida para un filtro.
     * 
     * @param frec Frecuencia definida por el usuario.
     * @return Descripci?n de la frecuencia definida por el usuario.
     */
    private String getStrFrecuencyFilter(String frec) {
        int intFrec = Integer.parseInt(frec);
        String strFrec = "";

        switch (intFrec) {
            case 0:
                strFrec = "Cada dia";
                break;
            case 1:
                strFrec = "Cada semana";
                break;
            case 2:
                strFrec = "Cada quince dias";
                break;
            case 3:
                strFrec = "Cada mes";
                break;
            case 4:
                strFrec = "Cada dos meses";
                break;
            case 5:
                strFrec = "Cada seis meses";
                break;
            case 6:
                strFrec = "Cada a?o";
                break;

        }

        return strFrec;
    }
}
