/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources;

/**
 * Clase que controla la opci?n de la pesta?a de angeles en el menu de la pagina de configuracion.
 * @author tote
 */
public class SettingsSNSAngelGuardJSPControlerResourcesAngelsMenu {

    /** URL al icono de la pesta?a cuando se pasa el puntero del raton */
    public final String ON_OUT_ICON = "../SNSAngelGuardFB/resources/settingsSNSAngelGuard/angelsMenu/icono_mini.gif";
    
     /** URL al icono de la pesta?a cuando se pulsa sobre esta */
    public final String ON_CLICK_ICON = "../SNSAngelGuardFB/resources/settingsSNSAngelGuard/angelsMenu/icono_mini.gif";
    
    /** Estatus HTML */
    public final String HTML_STATUS_CONTENT = "";
    
    /** URL de destino */
    public final String DESTINY_URL_JSP = "../SNSAngelGuardFB/settingsSNSAngelGuard_Angels.jsp";
    
    /** Titulo de la pesta?a */
    private String title;
    
    /** Datos de los angeles */
    private String dataAngels;

    public String getDataAngels() {
        return dataAngels;
    }

    public String getTitle() {
        return title;
    }

    /**
     * Constructor de clase.
     * 
     * @param title
     * @param angels 
     */
    public SettingsSNSAngelGuardJSPControlerResourcesAngelsMenu(String title, String angels) {
        this.title = title;
        this.dataAngels = angels;
    }
}
