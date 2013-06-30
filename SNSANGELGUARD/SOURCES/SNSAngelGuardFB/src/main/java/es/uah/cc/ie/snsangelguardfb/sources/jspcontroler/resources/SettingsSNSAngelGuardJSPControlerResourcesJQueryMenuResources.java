/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources;

/**
 * Controla los recursos del menu de selecci?n de pesta?as de la p?gina principal.
 * 
 * @author tote
 */
public class SettingsSNSAngelGuardJSPControlerResourcesJQueryMenuResources {

    /** Caption class */
    public final String CAPTION_CLASS = "CaptionClass";
    
    /** Clase cuando no est? seleccionada la pesta?a */
    public final String ON_OUT_CLASS = "onOutClass";
    
    /** Clase seleccionada cuando el puntero se situa sobre la pesta?a */
    public final String ON_OVER_CLASS = "onOverClass";
    
    /** Clase seleccionada al clicar sobre la pesta?a */
    public final String ON_CLICK_CLASS = "onClickClass";
    
    /** HS out class */
    public final String HS_OUT_CLASS = "hscOutClass";
    
    /** HS click class */
    public final String HS_CLICK_CLASS = "hscClickClass";
    
    /** Path de la imagen loading que sale al clicar sobre una pesta?a */
    public final String PATH_IMAGE_LOADING_MENU = "../SNSAngelGuardFB/resources/settingsSNSAngelGuard/jQueryMenu/Loading.gif";
    
    /** Contenedor ajax de la pagina */
    public final String AJAX_CONTENT = "ajaxContent";

    /** Titulo del menu */
    private String title;

    public String getTitle() {
        return title;
    }
 
    /**
     * Constructor de clase.
     * 
     * @param title 
     */
    public SettingsSNSAngelGuardJSPControlerResourcesJQueryMenuResources(String title) {
        this.title = title;
    }
}
