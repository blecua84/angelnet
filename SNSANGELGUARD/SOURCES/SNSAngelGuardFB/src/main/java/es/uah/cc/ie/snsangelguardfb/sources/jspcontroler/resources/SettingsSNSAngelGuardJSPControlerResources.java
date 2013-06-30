/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources;

import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;

/**
 * Contiene todos los recursos de idioma necesarios para cargar la pagina settingsSNSAngelGuard.jsp
 * 
 * @author tote
 */
public class SettingsSNSAngelGuardJSPControlerResources {

    /** URL a la pagina de ayuda */
    public final String DESTINY_JSP_HELP = "../SNSAngelGuardFB/helpMe.jsp";
    
    /** URL a la pesta?a inicial que se cargara por defecto */
    public final String DESTINY_JSP_INIT = "../SNSAngelGuardFB/settingsSNSAngelGuard_Angels.jsp";

    /** Clase manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
    
    /** Angeles */
    private String angels;
    
    /** Recursos de idioma para el menu de las pesta?as */
    private SettingsSNSAngelGuardJSPControlerResourcesJQueryMenuResources jspResourcesJQueryMenu;
    
    /** Recursos de idioma para la pesta?a de angeles */
    private SettingsSNSAngelGuardJSPControlerResourcesAngelsMenu jspResourcesAngelsMenu;
    
    /** Recursos de idioma para la pesta?a de vigilantes */
    private SettingsSNSAngelGuardJSPControlerResourcesVigilantsMenu jspResourcesVigilantsMenu;
    
    /** Mensajes de carga entre paginas */
    private String[] menLoader;
    
    /** Titulo de la pagina */
    private String titleSettings;
    
    /** Titulos de las pesta?as de la pagina */
    private String[] localeMenu;
    
    /** Titulo para el enlace a la ayuda */
    private String[] titleHelp;
    
    /** Titulo para el contenedor de angeles de Facebook */
    private String titleFbList;
    
    /** Titulo para los contenedos de angeles de Google y otros contactos */
    private String titleAngelSettAng;
    
    /** Titulo del nombre del angel en el contenedor de otros contactos */
    private String nameTutor;
    
    /** Titulo para el email del angel en el contenedor de otros contactos */
    private String emailTutor;
    
    /** Mensaje de confirmacion */
    private String mensaje;
    
    /** Mensaje de guardado */
    private String menSave;
    
    /** Mensaje de espera entre cargas de paginas */
    private String menWait;
    
    /** Titulo para el boton guardar */
    private String btnSaveSettings;

    public String getBtnSaveSettings() {
        return btnSaveSettings;
    }

    public String[] getMenLoader() {
        return menLoader;
    }

    public String getEmailTutor() {
        return emailTutor;
    }

    public String getNameTutor() {
        return nameTutor;
    }

    public String getTitleSettings() {
        return titleSettings;
    }

    public String getAngels(){
        return angels;
    }

    public SettingsSNSAngelGuardJSPControlerResourcesAngelsMenu getJspResourcesAngelsMenu() {
        return jspResourcesAngelsMenu;
    }

    public SettingsSNSAngelGuardJSPControlerResourcesJQueryMenuResources getJspResourcesJQueryMenu() {
        return jspResourcesJQueryMenu;
    }

    public SettingsSNSAngelGuardJSPControlerResourcesVigilantsMenu getJspResourcesVigilantsMenu() {
        return jspResourcesVigilantsMenu;
    }

    public String[] getLocaleMenu() {
        return localeMenu;
    }

    public String getMenSave() {
        return menSave;
    }

    public String getMenWait() {
        return menWait;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getTitleAngelSettAng() {
        return titleAngelSettAng;
    }

    public String getTitleFbList() {
        return titleFbList;
    }

    public String[] getTitleHelp() {
        return titleHelp;
    }

    /**
     * Constructor de clase.
     * 
     * @param snsObject
     * @param angels 
     */
    public SettingsSNSAngelGuardJSPControlerResources(SNSAngelGuardFBManager snsObject, String angels) {
        this.snsObject = snsObject;
        this.angels = angels;

        // Cargamos los recursos de idioma
        loadResourcesSettings();
    }

    /**
     * Carga los recursos de idioma.
     */
    public void loadResourcesSettings() {
        this.titleSettings = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleSettings();
        this.localeMenu = snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleMenSettings());
        this.titleHelp = snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getHelpMe());
        this.titleFbList = snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleFbListSettAng();
        this.titleAngelSettAng = snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getSubTitleAngelSettAng();
        this.nameTutor = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTxtNameTutorSettAng();
        this.emailTutor = snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTxtEmailTutorSettAng();
        this.btnSaveSettings = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getBtnSaveCheckSettings();
        this.menLoader = snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getWarnings());
        this.mensaje = menLoader[1];
        this.menSave = menLoader[2];
        this.menWait = menLoader[4];

        loadMenus();
    }

    public void loadMenus(){
        this.jspResourcesJQueryMenu = new SettingsSNSAngelGuardJSPControlerResourcesJQueryMenuResources(this.localeMenu[0]);
        this.jspResourcesAngelsMenu = new SettingsSNSAngelGuardJSPControlerResourcesAngelsMenu(this.localeMenu[1], this.angels);
        this.jspResourcesVigilantsMenu = new SettingsSNSAngelGuardJSPControlerResourcesVigilantsMenu(this.localeMenu[2]);
    }
}
