/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources;

import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;

/**
 * Clase que carga los recursos de idioma que se van a mostrar en la pagina.
 *
 * @author tote
 */
public class LegalAcceptedJSPControlerResources {

    /** Pagina de destino */
    public final String DESTINY_REDIRECT_JPS = "settingsSNSAngelGuard.jsp";
    
    /** URL al icono de la parte izquierda superior */
    public final String PATH_IMAGE_ICONO_LEFT = "../SNSAngelGuardFB/resources/legalAccepted/iconoLeft.gif";
    
    /** URL al icono de la parte derecha superior */
    public final String PATH_IMAGE_ICONO_RIGHT = "../SNSAngelGuardFB/resources/legalAccepted/iconoRight.gif";
    
    /** URL a la imagen de carga entre p?ginas */
    public final String PATH_IMAGE_LOADING = "../SNSAngelGuardFB/resources/legalAccepted/load.gif";

    /** Clase manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
    
    /** Titulo de la pagina */
    private String title;
    
    /** Introducion al acuerdo legal */
    private String acceptingTerms;
    
    /** Texto informativo del acuerdo legal */
    private String legalAccepted;
    
    /** Menaje de guardado de informacion */
    private String loaderSave;
    
    /** Mensaje de espera de la carga entre p?ginas */
    private String loaderWait;
    
    /** Titulo del boton cancelar */
    private String titleBtnCancel;
    
    /** Titulo del boton aceptar */
    private String titleBtnIAgree;

    public String getAcceptingTerms() {
        return acceptingTerms;
    }

    public String getLegalAccepted() {
        return legalAccepted;
    }

    public String getLoaderSave() {
        return loaderSave;
    }

    public String getLoaderWait() {
        return loaderWait;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleBtnCancel() {
        return titleBtnCancel;
    }

    public String getTitleBtnIAgree() {
        return titleBtnIAgree;
    }

    /**
     * Constructor de la clase de recursos.
     *
     * @param snsObject: Clase manager donde se encuentra el contexto de la aplicacion.
     *
     * @author tote
     */
    public LegalAcceptedJSPControlerResources(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;

        loadResources();
    }


    /**
     * Carga los recursos de idioma.
     *
     * @author tote
     */
    private void loadResources(){
        // Cargamos el titulo de la pagina
        this.title = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleAT();

        // Cargamos el subtitulo de la pagina
        this.acceptingTerms = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getAcceptingTerms();

        // Cargamos el acuerdo legal de la aplicacion
        this.legalAccepted = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getLegalAccepted();

        // Cargamos los mensajes de espera
        String[] strBtn = this.snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getWarnings());
        this.loaderSave = strBtn[3];
        this.loaderWait = strBtn[4];

        // Cargamos el titulo del boton aceptar
        this.titleBtnIAgree = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnAgreeAT();

        // Cargamos el titulo del boton cancelar
        this.titleBtnCancel = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnCancelAT();
    }
}