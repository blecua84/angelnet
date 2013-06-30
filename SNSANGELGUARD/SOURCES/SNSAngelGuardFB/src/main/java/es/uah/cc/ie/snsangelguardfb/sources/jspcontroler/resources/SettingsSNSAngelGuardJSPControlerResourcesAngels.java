/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources;

import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;

/**
 * Clase que contiene los recursos de idioma para la pagina de seleccion de angeles.
 * 
 * @author tote
 */
public class SettingsSNSAngelGuardJSPControlerResourcesAngels {

    /** Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
    
    /** Titulos para el contenedor de amigos de Facebook */
    private String[] arrayContacts;
    
    /** Titulos para los contenedores de Google y Otros Contactos */
    private String arrayAltAngels;
    
    /** Titulo del nombre del contenedor de Otros Contactos*/
    private String nameContact;
    
    /** Titulo para el email del contenedor de Otros Contactos */
    private String emailContact;
    
    /** Mensajes de aviso para la pagina */
    private String[] warnings;
    
    /** Mensaje de confirmacion de angel */
    private String confirm;
    
    /** Mensaje de borrado de un angel */
    private String delete;

    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    public String[] getArrayContacts() {
        return arrayContacts;
    }

    public void setArrayContacts(String[] arrayContacts) {
        this.arrayContacts = arrayContacts;
    }

    public String getArrayAltAngels() {
        return arrayAltAngels;
    }

    public void setArrayAltAngels(String arrayAltAngels) {
        this.arrayAltAngels = arrayAltAngels;
    }

    public String getNameContact() {
        return nameContact;
    }

    public void setNameContact(String nameContact) {
        this.nameContact = nameContact;
    }

    public String getEmailContact() {
        return emailContact;
    }

    public void setEmailContact(String emailContact) {
        this.emailContact = emailContact;
    }

    public String[] getWarnings() {
        return warnings;
    }

    public void setWarnings(String[] warnings) {
        this.warnings = warnings;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }
    
    /**
     * Constructor de clase.
     * 
     * @param snsObject 
     */
    public SettingsSNSAngelGuardJSPControlerResourcesAngels(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
        
        this.arrayContacts = this.snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleFriendsImportSettAng());
        this.arrayAltAngels = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getAltContactsAngelsEd();
        this.nameContact = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTxtNameTutorSettAng();
        this.emailContact = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTxtEmailTutorSettAng();

        this.warnings = this.snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getWarnings());
        this.confirm = this.warnings[6];
        this.delete = this.warnings[5];
    }
}
