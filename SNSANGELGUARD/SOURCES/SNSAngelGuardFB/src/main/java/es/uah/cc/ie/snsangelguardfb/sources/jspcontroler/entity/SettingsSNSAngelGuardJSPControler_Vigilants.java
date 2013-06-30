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
import es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources.SettingsSNSAngelGuardJSPControlerResourcesVigilants;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;

/**
 * Clase que controla el flujo de informacion en la pagina settingsSNSAngelGuard_Vigilants.jsp
 * 
 * @author josejavierblecuadepedro1
 */
public class SettingsSNSAngelGuardJSPControler_Vigilants extends GenericJSPControler{
    
    /** Logger Class */
    private static Logger logger = Logger.getLogger(SettingsSNSAngelGuardJSPControler.class);
    
    /** Manager principal de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
    
    /** Recursos de idioma */
    private SettingsSNSAngelGuardJSPControlerResourcesVigilants jspResources;
    
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
    
    /** Array bidimensional de angeles */
    private String[][] arrayAngels;

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        SettingsSNSAngelGuardJSPControler_Vigilants.logger = logger;
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

    public SettingsSNSAngelGuardJSPControlerResourcesVigilants getJspResources() {
        return jspResources;
    }

    public void setJspResources(SettingsSNSAngelGuardJSPControlerResourcesVigilants jspResources) {
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

    public String[][] getArrayAngels() {
        return arrayAngels;
    }

    public void setArrayAngels(String[][] arrayAngels) {
        this.arrayAngels = arrayAngels;
    }
    
    /**
     * Constructor de clase. Podra lanzar excepciones del tipo InterDataBaseException, InterEmailException o InterProcessException.
     * @param request
     * @param response
     * @throws InterDataBaseException
     * @throws InterEmailException
     * @throws InterProcessException 
     */
    public SettingsSNSAngelGuardJSPControler_Vigilants(HttpServletRequest request, HttpServletResponse response) throws InterDataBaseException, InterEmailException, InterProcessException {
        try {
            this.snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
            this.snsObject.logSession(request, response);
            request.setCharacterEncoding("UTF-8");
            this.snsObject.setInicio(false);
            
            this.request = request;
            this.response = response;
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
            this.hdAngels = URLDecoder.decode(request.getParameter("hdAngels"),"UTF-8");
            this.hdAngelsEd = URLDecoder.decode(request.getParameter("hdAngelsEd"),"UTF-8");
            this.hdAngelsAux = URLDecoder.decode(request.getParameter("hdAngelsAux"),"UTF-8");
            this.hdAngelsGoogleSelected = URLDecoder.decode(request.getParameter("hdAngelsGoogleSelected"),"UTF-8");
            this.hdLstAngelsFltWall = URLDecoder.decode(request.getParameter("hdLstAngelsFltWall"),"UTF-8");
            this.hdLstAngelsFltFriends = URLDecoder.decode(request.getParameter("hdLstAngelsFltFriends"),"UTF-8");
            this.hdLstAngelsFltPriv = URLDecoder.decode(request.getParameter("hdLstAngelsFltPriv"),"UTF-8");
            this.hdLstAngelsFltVist = URLDecoder.decode(request.getParameter("hdLstAngelsFltVist"),"UTF-8");
            this.hdActiveFltWall = URLDecoder.decode(request.getParameter("hdActiveFltWall"),"UTF-8");
            this.hdActiveFltFriends = URLDecoder.decode(request.getParameter("hdActiveFltFriends"),"UTF-8");
            this.hdActiveFltPriv = URLDecoder.decode(request.getParameter("hdActiveFltPriv"),"UTF-8");
            this.hdActiveFltVist = URLDecoder.decode(request.getParameter("hdActiveFltVist"),"UTF-8");
            this.hdFrecFltWall = URLDecoder.decode(request.getParameter("hdFrecFltWall"),"UTF-8");
            this.hdFrecFltFriends = URLDecoder.decode(request.getParameter("hdFrecFltFriends"),"UTF-8");
            this.hdFrecFltPriv = URLDecoder.decode(request.getParameter("hdFrecFltPriv"),"UTF-8");
            this.hdFrecFltVist = URLDecoder.decode(request.getParameter("hdFrecFltVist"),"UTF-8");

            this.snsObject.getAngelsUtilities().getAngelsSelected(hdAngels);
            this.snsObject.getAngelsUtilities().joinAngels(hdAngelsGoogleSelected,hdAngelsEd);
            this.arrayAngels = snsObject.getAngelsUtilities().getArrayAngelsSelected();
            
            loadResources();
        } catch (UnsupportedEncodingException ex) {
            logger.error(CodeException.UNSUPPORTED_ENCODING, ex);
            this.snsObject.getExceptionManager().initControlException(ex);
        } catch (JSONException ex) {
            logger.error(CodeException.JSON_EXCEPTION, ex);
            this.snsObject.getExceptionManager().initControlException(ex);
        }
    }
    
    /**
     * Carga los recursos de idioma.
     */
    public void loadResources(){
        // Cargamos los recursos de idioma
        this.jspResources = new SettingsSNSAngelGuardJSPControlerResourcesVigilants(this.snsObject);
    }
}
