/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.entity;

import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import es.uah.cc.ie.snsangelguardfb.exception.CodeException;
import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;
import es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.GenericJSPControler;
import es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources.SettingsSNSAngelGuardJSPControlerResourcesAngels;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;

/**
 * Clase que controla el flujo de informacion en la pagina settingsSNSAngelGuard_Angels.jsp
 * 
 * @author josejavierblecuadepedro1
 */
public class SettingsSNSAngelGuardJSPControler_Angels extends GenericJSPControler {
    
    
    /** Logger Class */
    private static Logger logger = Logger.getLogger(SettingsSNSAngelGuardJSPControler.class);
    
    /** Manager principal de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
   
    /** Recursos de idioma de la pagina */
    private SettingsSNSAngelGuardJSPControlerResourcesAngels jspResources;
    
    /** Atributo request de la sesion */
    private HttpServletRequest request;
    
    /** Atributo response de la sesion */
    private HttpServletResponse response;
   
    /** Angeles elegidos */
    private String hdAngels;
    
    /** Angeles elegidos de Otros Contactos */
    private String hdAngelsEd;
    
    /** Angeles elegidos de contactos de Google */
    private String hdAngelsGoogleSelected;

    /** Lista de angeles para el filtro de control de lenguaje */
    private String hdLstAngelsFltWall;
    
    /** Lista de angeles para el filtro de control de amistades */
    private String hdLstAngelsFltFriends;
    
    /** Lista de angeles para el filtro de control de privacidad */
    private String hdLstAngelsFltPriv;
    
    /** Lista de angeles para el filtro de control de visitas */
    private String hdLstAngelsFltVist;

    /** Indicador de si esta activo el filtro de control de lenguaje */
    private String hdActiveFltWall;
    
    /** Indicador de si esta activo el filtro de control de amistades */
    private String hdActiveFltFriends;
    
    /** Indicador de si esta activo el filtro de control de privacidad */
    private String hdActiveFltPriv;
    
    /** Indicador de si esta activo el filtro de control de visitas */
    private String hdActiveFltVist;

    /** Frecuencia elegida para el filtro de control de lenguaje */
    private String hdFrecFltWall;
    
    /** Frecuencia elegida para el filtro de control de amistades */
    private String hdFrecFltFriends;
    
    /** Frecuencia elegida para el filtro de control de privacidad */
    private String hdFrecFltPriv;
    
    /** Frecuencia elegida para el filtro de control de visitas */
    private String hdFrecFltVist;
    
    /** Lista de angeles auxiliar */
    private String hdAngelsAux;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        SettingsSNSAngelGuardJSPControler_Angels.logger = logger;
    }

    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public SettingsSNSAngelGuardJSPControlerResourcesAngels getJspResources() {
        return jspResources;
    }

    public void setJspResources(SettingsSNSAngelGuardJSPControlerResourcesAngels jspResources) {
        this.jspResources = jspResources;
    }

    public String getHdAngels() {
        return hdAngels;
    }

    public void setHdAngels(String hdAngels) {
        this.hdAngels = hdAngels;
    }

    public String getHdAngelsEd() {
        return hdAngelsEd;
    }

    public void setHdAngelsEd(String hdAngelsEd) {
        this.hdAngelsEd = hdAngelsEd;
    }

    public String getHdAngelsGoogleSelected() {
        return hdAngelsGoogleSelected;
    }

    public void setHdAngelsGoogleSelected(String hdAngelsGoogleSelected) {
        this.hdAngelsGoogleSelected = hdAngelsGoogleSelected;
    }

    public String getHdLstAngelsFltWall() {
        return hdLstAngelsFltWall;
    }

    public void setHdLstAngelsFltWall(String hdLstAngelsFltWall) {
        this.hdLstAngelsFltWall = hdLstAngelsFltWall;
    }

    public String getHdLstAngelsFltFriends() {
        return hdLstAngelsFltFriends;
    }

    public void setHdLstAngelsFltFriends(String hdLstAngelsFltFriends) {
        this.hdLstAngelsFltFriends = hdLstAngelsFltFriends;
    }

    public String getHdLstAngelsFltPriv() {
        return hdLstAngelsFltPriv;
    }

    public void setHdLstAngelsFltPriv(String hdLstAngelsFltPriv) {
        this.hdLstAngelsFltPriv = hdLstAngelsFltPriv;
    }

    public String getHdLstAngelsFltVist() {
        return hdLstAngelsFltVist;
    }

    public void setHdLstAngelsFltVist(String hdLstAngelsFltVist) {
        this.hdLstAngelsFltVist = hdLstAngelsFltVist;
    }

    public String getHdActiveFltWall() {
        return hdActiveFltWall;
    }

    public void setHdActiveFltWall(String hdActiveFltWall) {
        this.hdActiveFltWall = hdActiveFltWall;
    }

    public String getHdActiveFltFriends() {
        return hdActiveFltFriends;
    }

    public void setHdActiveFltFriends(String hdActiveFltFriends) {
        this.hdActiveFltFriends = hdActiveFltFriends;
    }

    public String getHdActiveFltPriv() {
        return hdActiveFltPriv;
    }

    public void setHdActiveFltPriv(String hdActiveFltPriv) {
        this.hdActiveFltPriv = hdActiveFltPriv;
    }

    public String getHdActiveFltVist() {
        return hdActiveFltVist;
    }

    public void setHdActiveFltVist(String hdActiveFltVist) {
        this.hdActiveFltVist = hdActiveFltVist;
    }

    public String getHdFrecFltWall() {
        return hdFrecFltWall;
    }

    public void setHdFrecFltWall(String hdFrecFltWall) {
        this.hdFrecFltWall = hdFrecFltWall;
    }

    public String getHdFrecFltFriends() {
        return hdFrecFltFriends;
    }

    public void setHdFrecFltFriends(String hdFrecFltFriends) {
        this.hdFrecFltFriends = hdFrecFltFriends;
    }

    public String getHdFrecFltPriv() {
        return hdFrecFltPriv;
    }

    public void setHdFrecFltPriv(String hdFrecFltPriv) {
        this.hdFrecFltPriv = hdFrecFltPriv;
    }

    public String getHdFrecFltVist() {
        return hdFrecFltVist;
    }

    public void setHdFrecFltVist(String hdFrecFltVist) {
        this.hdFrecFltVist = hdFrecFltVist;
    }

    public String getHdAngelsAux() {
        return hdAngelsAux;
    }

    public void setHdAngelsAux(String hdAngelsAux) {
        this.hdAngelsAux = hdAngelsAux;
    }
    
    /**
     * Constructor de clase. Podra lanzar excepciones del tipo InterDataBaseException, InterProcessException o InterEmailException.
     * 
     * @param request
     * @param response
     * @throws InterDataBaseException
     * @throws InterProcessException
     * @throws InterEmailException 
     */
    public SettingsSNSAngelGuardJSPControler_Angels(HttpServletRequest request, HttpServletResponse response) throws InterDataBaseException, InterProcessException, InterEmailException {
        try {    
            //Obtenemos la conexi?n a Facebook
            this.snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
            snsObject.logSession(request, response);
            this.request = request;
            this.response = response;
            this.request.setCharacterEncoding("UTF-8");
        } catch (IOException ex) {
            logger.error(CodeException.IO_EXCEPTION, ex);
            this.snsObject.getExceptionManager().initControlException(ex);
        } catch (JSONException ex) {
            logger.error(CodeException.JSON_EXCEPTION, ex);
            this.snsObject.getExceptionManager().initControlException(ex);
        }
         
    }
    
    @Override
    public void process() throws InterDataBaseException, InterProcessException, InterEmailException {
        try {
            this.hdAngels = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getAngelsUser("F");
            this.hdAngelsEd = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getAngelsUser("O");
            this.hdAngelsGoogleSelected = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getAngelsUser("G");

            this.hdLstAngelsFltWall = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltWall().getAngels();
            this.hdLstAngelsFltFriends = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltFriends().getAngels();
            this.hdLstAngelsFltPriv = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltPriv().getAngels();
            this.hdLstAngelsFltVist = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getAngels();

            this.hdActiveFltWall = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltWall().getActive();
            this.hdActiveFltFriends = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltFriends().getActive();
            this.hdActiveFltPriv = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltPriv().getActive();
            this.hdActiveFltVist = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getActive();

            this.hdFrecFltWall = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltWall().getFrec();
            this.hdFrecFltFriends = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltFriends().getFrec();
            this.hdFrecFltPriv = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltPriv().getFrec();
            this.hdFrecFltVist = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getFrec();
            this.hdAngelsAux = snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getAngelsUser("F");


            if (!snsObject.isInicio()) {
                this.hdAngels = request.getParameter("hdAngels");
                this.hdAngelsEd = request.getParameter("hdAngelsEd");
                this.hdAngelsGoogleSelected = request.getParameter("hdAngelsGoogleSelected");
                this.hdLstAngelsFltWall = request.getParameter("hdLstAngelsFltWall");
                this.hdLstAngelsFltFriends = request.getParameter("hdLstAngelsFltFriends");
                this.hdLstAngelsFltPriv = request.getParameter("hdLstAngelsFltPriv");
                this.hdLstAngelsFltVist = request.getParameter("hdLstAngelsFltVist");
                this.hdActiveFltWall = request.getParameter("hdActiveFltWall");
                this.hdActiveFltFriends = request.getParameter("hdActiveFltFriends");
                this.hdActiveFltPriv = request.getParameter("hdActiveFltPriv");
                this.hdActiveFltVist = request.getParameter("hdActiveFltVist");
                this.hdFrecFltWall = request.getParameter("hdFrecFltWall");
                this.hdFrecFltFriends = request.getParameter("hdFrecFltFriends");
                this.hdFrecFltPriv = request.getParameter("hdFrecFltPriv");
                this.hdFrecFltVist = request.getParameter("hdFrecFltVist");
                this.hdAngelsAux = request.getParameter("hdAngelsAux");
            }
        } catch (JSONException ex) {
            logger.error(CodeException.JSON_EXCEPTION, ex);
            this.snsObject.getExceptionManager().initControlException(ex);
        }
        
        loadResources();
    }
   
    
    /**
     * Carga los recursos de idioma.
     */
    public void loadResources(){
        // Cargamos los recursos de idioma
        this.jspResources = new SettingsSNSAngelGuardJSPControlerResourcesAngels(this.snsObject);
    }
    
}
