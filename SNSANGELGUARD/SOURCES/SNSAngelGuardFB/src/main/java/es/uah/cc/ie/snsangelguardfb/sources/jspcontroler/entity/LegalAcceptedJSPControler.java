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
import es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources.LegalAcceptedJSPControlerResources;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.openide.util.Exceptions;

/**
 * Clase que controla el flujo de ejecucion de la clase java legalAccepted.jsp
 *
 * @author tote
 */
public class LegalAcceptedJSPControler extends GenericJSPControler{

    /** Logger Class */
    private static Logger logger = Logger.getLogger(LegalAcceptedJSPControler.class);

    /** Clase Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;

    /** Recursos de idioma para la pangina legalAccepted.jsp */
    private LegalAcceptedJSPControlerResources jspResources;

    /** request de la sesi?n */
    private HttpServletRequest request;

    /** response de la sesi?n */
    private HttpServletResponse response;

    /**
     * Constructor de clase. Recibe como par?metros el contexto de la aplicacion.
     *
     * @param request: HttpServletRequest
     * @param response: HttpServletResponse
     *
     * @author tote
     */
    public LegalAcceptedJSPControler(HttpServletRequest request, HttpServletResponse response) throws InterDataBaseException, InterProcessException, InterEmailException {
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

    /**
     * Obtiene el objeto manager de la aplicaci?n.
     *
     * @return SNSAngelGuardFBManager
     */
    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    /**
     * Establece el objeto manager de la aplicaci?n.
     *
     * @param snsObject SNSAngelGuardFBManager
     */
    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Obtiene los recursos de idioma para la p?gina jsp.
     *
     * @return LegalAcceptedJSPControlerResources
     */
    public LegalAcceptedJSPControlerResources getJspResources() {
        return jspResources;
    }

    @Override
    public void process() throws InterDataBaseException, InterProcessException, InterEmailException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - process: Inicio process...");

        try {
            this.snsObject.logSession(request, response);

            // Cargamos los recursos de idioma de la pagina
            this.jspResources = new LegalAcceptedJSPControlerResources(this.snsObject);
        } catch (Exception e) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - process: Excepcion capturada GenericException: " + e.getMessage());
            logger.fatal(e);
            this.snsObject.getExceptionManager().initControlException(e);
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - process: Fin process...");
    }
}