/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.entity;

import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.GenericJSPControler;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.openide.util.Exceptions;

/**
 * Clase de control de la pagina index.jsp.
 * 
 * @author tote
 */
public class IndexJSPControler extends GenericJSPControler{

    /** Logger class  */
    private static Logger logger = Logger.getLogger(IndexJSPControler.class);
    
    /** Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
    
    /** Atributo request de la sesion */
    private HttpServletRequest request;
    
    /** Atributo response de la sesion */
    private HttpServletResponse response;
    
    /** URL de destino de la pagina */
    private String pathDestino;
    
    /** Mensaje loading de guardado */
    private String loaderSave;
    
    /** Mensaje loading de espera */
    private String loaderWait;

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

    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    public String getPathDestino() {
        return pathDestino;
    }

    public void setPathDestino(String pathDestino) {
        this.pathDestino = pathDestino;
    }

    public String getLoaderSave() {
        return loaderSave;
    }

    public void setLoaderSave(String loaderSave) {
        this.loaderSave = loaderSave;
    }

    public String getLoaderWait() {
        return loaderWait;
    }

    public void setLoaderWait(String loaderWait) {
        this.loaderWait = loaderWait;
    }


    /**
     * Constructor de clase.
     * 
     * @param request
     * @param response 
     */
    public IndexJSPControler(HttpServletRequest request, HttpServletResponse response) throws InterDataBaseException, InterProcessException, InterEmailException {
        try {
            HttpSession session = request.getSession(true);
            this.snsObject = SNSAngelGuardFBManager.getSessionInstance(request);
            this.request = request;
            this.response = response;
        } catch (FileNotFoundException ex) {
            this.snsObject.getExceptionManager().initControlException(ex);
        } catch (IOException ex) {
            this.snsObject.getExceptionManager().initControlException(ex);
        }
    }

    /**
     * Este metodo iniciara sesion en Facebook, y determinara la pagina siguiente en funcion de si es un 
     * usuario nuevo de la aplicacion o no. Podr? lanzar excepciones del tipo InterDataBaseException, InterProcessException o InterEmailException.
     * 
     * @throws InterDataBaseException
     * @throws InterProcessException
     * @throws InterEmailException 
     */
    public void process() throws InterDataBaseException, InterProcessException, InterEmailException{
        String destino = "";
        
        try {
            this.snsObject.getLoginFacebook(request, response);
            if (this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUserSession() != null) {
                this.request.setAttribute("users_AppPermissionDisabled", "1");


                this.snsObject.getUserSettingsDaoManager().loadSettings();

                String[] strBtn = this.snsObject.getStringUtilities().stringToArray(this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getWarnings());
                this.loaderSave = strBtn[3];
                this.loaderWait = strBtn[4];

                
                
                if (this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() != null) {
                    
                    if (this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().isLegalAccepted()) {
                        // Actualizamos la user_token junto con la hora de entrada a la aplicaci?n.
                        this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().updateLastCheckUS();
                        
                        this.pathDestino = "/settingsSNSAngelGuard.jsp?newConection=1&ok=0";
                    } else {
                        
                        this.pathDestino = "/legalAccepted.jsp";
                    }
                    response.sendRedirect(request.getContextPath() + this.pathDestino);
                }
            }
        } catch (Exception ex) {
            this.getSnsObject().getExceptionManager().initControlException(ex);
        } 
    }
}