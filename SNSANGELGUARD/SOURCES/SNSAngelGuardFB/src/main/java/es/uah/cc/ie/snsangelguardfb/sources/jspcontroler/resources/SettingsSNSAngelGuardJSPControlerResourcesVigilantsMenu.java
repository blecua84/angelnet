/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources;

/**
 * Clase que gestiona los recursos de idioma para la pesta?a del menu de vigilantes.
 * 
 * @author tote
 */
public class SettingsSNSAngelGuardJSPControlerResourcesVigilantsMenu {

    /** Icono entrada/salida */
    public final String ON_OUT_ICON = "../SNSAngelGuardFB/resources/settingsSNSAngelGuard/vigilantsMenu/icono2_mini.gif";
    
    /** Icono cuando se ha seleccionado la pesta?a */
    public final String ON_CLICK_ICON = "../SNSAngelGuardFB/resources/settingsSNSAngelGuard/vigilantsMenu/icono2_mini.gif";
    
    /** HTML estatus */
    public final String HTML_STATUS_CONTENT = "";
    
    /** URL a la pagina a la que hace referencia */
    public final String DESTINY_URL_JSP = "../SNSAngelGuardFB/settingsSNSAngelGuard_Vigilants.jsp";
    
    /** Datos de llamada */
    public final String DATA = "";

    /** Titulo de la pesta?a */
    private String title;

    public String getTitle() {
        return title;
    }

    /**
     * Constructor de clase.
     * 
     * @param title 
     */
    public SettingsSNSAngelGuardJSPControlerResourcesVigilantsMenu(String title) {
        this.title = title;
    }
}
