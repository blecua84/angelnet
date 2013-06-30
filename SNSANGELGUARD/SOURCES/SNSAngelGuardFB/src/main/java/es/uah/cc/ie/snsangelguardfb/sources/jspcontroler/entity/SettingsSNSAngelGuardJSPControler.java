/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.entity;

import es.uah.cc.ie.snsangelguardfb.exception.CodeException;
import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import es.uah.cc.ie.snsangelguardfb.sources.dao.entity.UserSettings_SettingsFilterDAO;
import es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.GenericJSPControler;
import es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources.SettingsSNSAngelGuardJSPControlerResources;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;

/**
 * Clase que controla la ejecucion de la pagina principal de la aplicacion.
 * 
 * @author tote
 */
public class SettingsSNSAngelGuardJSPControler extends GenericJSPControler {
    
    /** Logger Class */
    private static Logger logger = Logger.getLogger(SettingsSNSAngelGuardJSPControler.class);
    
    /** Manager principal de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
    
    /** Recursos de la pagina */
    private SettingsSNSAngelGuardJSPControlerResources jspResources;
    
    /** Atributo request de la sesion */
    private HttpServletRequest request;
    
    /** Atributo response de la sesion */
    private HttpServletResponse response;
    
    /** Indicador de nueva conexion */
    private String newConection;
    
    /** Resultado de la operacion */
    private String resultSave;
    
    /** Angeles del usuario */
    private String[][] angels;

    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    public SettingsSNSAngelGuardJSPControlerResources getJspResources() {
        return jspResources;
    }

    public String getNewConection() {
        return newConection;
    }

    public String getResultSave() {
        return resultSave;
    }

    public String[][] getAngels() {
        return angels;
    }

    /**
     * Constructor de clase. Al obtener par?metros del objeto request, podr? lanzar excepciones del tipo InterDataBaseException, InterProcessException o InterEmailException.
     * @param request
     * @param response
     * @throws InterDataBaseException
     * @throws InterProcessException
     * @throws InterEmailException 
     */
    public SettingsSNSAngelGuardJSPControler(HttpServletRequest request, HttpServletResponse response) throws InterDataBaseException, InterProcessException, InterEmailException{
        try {
            // Cargamos el objeto manager de la aplicacion
            this.snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
            request.setCharacterEncoding("UTF-8");
            this.request = request;
            this.response = response;
            
            // Cargamos el log
            this.snsObject.logSession(request, response);
            this.newConection = request.getParameter("newConection");
            this.resultSave = (request.getParameter("ok").equals("1") ? "1" : "0");
            this.angels = null;
        } catch (Exception ex) {
            logger.error(CodeException.UKNOWN_ERROR, ex);
            this.snsObject.getExceptionManager().initControlException(ex);
        }
    }

    public void process() throws InterDataBaseException, InterProcessException, InterEmailException {
        
        try {
            if (this.newConection.equals("0")) {
                // Nuevo usuario en la aplicacion
                this.snsObject.setInicio(true);
                String uid = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid();

                Long uidLong = (new Double(uid)).longValue();

                UserSettings_SettingsFilterDAO fltWall = new UserSettings_SettingsFilterDAO(this.snsObject.getUserSettingsDaoManager(), uidLong, "3", "", "0", uidLong, new Date());
                this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setFltWall(fltWall);

                UserSettings_SettingsFilterDAO fltFriends = new UserSettings_SettingsFilterDAO(this.snsObject.getUserSettingsDaoManager(), uidLong, "3", "", "0", uidLong, new Date());
                this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setFltFriends(fltFriends);

                UserSettings_SettingsFilterDAO fltPriv = new UserSettings_SettingsFilterDAO(this.snsObject.getUserSettingsDaoManager(), uidLong, "3", "", "0", uidLong, new Date());
                this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setFltPriv(fltPriv);

                UserSettings_SettingsFilterDAO fltVist = new UserSettings_SettingsFilterDAO(this.snsObject.getUserSettingsDaoManager(), uidLong, "3", "", "0", uidLong, new Date());
                this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setFltVist(fltVist);

                this.snsObject.setInicio(true);

                this.angels = this.snsObject.getAngelsUtilities().getAngels();
                this.snsObject.getAngelsUtilities().setArrayAngels(this.angels);
                
                // Cargamos los recursos de idioma
                loadResources();

                this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setAppActivated(true);
                this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setLegalAccepted(true);
                this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setLastCheck(new Date());
                this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().setBackupCheck(new Date());
                this.snsObject.getUserSettingsDaoManager().putNewInstanceUS(this.request, this.response);
                this.snsObject.getUserSettingsDaoManager().getUserInfo(true);


            } else {
                // Cargamos la pagina con la informaci?n de la base de datos
                // Cargamos la configuraci?n en pantalla despu?s de acceder a la DB
                // METODOS PARA CARGAR LA CONFIGURACION RECUPERADA
                this.snsObject.setInicio(true);
                //this.snsObject.getFriendsFilterFuncionality().getUserFriends();
                Long uidLong = (new Double(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid())).longValue();
                this.snsObject.getClient().userFacebook_getUserFacebookByUid(String.class, uidLong.toString());
                JSONArray jsonFriendsFacebook = this.snsObject.getUserSettingsDaoManager().getFacebookFriendsDB(uidLong.toString());
                this.angels = snsObject.getAngelsUtilities().getAngelsDB(jsonFriendsFacebook);
                this.snsObject.getAngelsUtilities().setArrayAngels(this.angels);
                
                // Cargamos los recursos de idioma
                loadResources();
            }



        } catch (Exception ex) {
            logger.error(CodeException.UKNOWN_ERROR, ex);
            this.snsObject.getExceptionManager().initControlException(ex);
        } 
    }

    /**
     * Carga los recursos de idioma.
     */
    public void loadResources(){
        // Cargamos los recursos de idioma
        this.jspResources = new SettingsSNSAngelGuardJSPControlerResources(this.snsObject, this.snsObject.getStringUtilities().arrayToString(this.angels));
    }
}
