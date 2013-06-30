/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.jspcontroler.resources;

import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;

/**
 * Clase de recursos de la pagina settingsSNSAngelGuard_Vigilants.jsp
 * 
 * @author josejavierblecuadepedro1
 */
public class SettingsSNSAngelGuardJSPControlerResourcesVigilants {
    
    /** Clase Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
    
    /** Titulo de la pagina */
    private String titleSettVig;
    
    /** Titulo del contenedor de filtros */
    private String titleVigilantSettVig;
    
    /** Titulo del contenedor de angeles para seleccion de frecuencia */
    private String titleVigFrecSettVig;
    
    /** Titulos para las pesta?as del contenedor de los contactos de Facebook  */
    private String titleFbList;
    
    /** Titulo para cada contacto de Facebook */
    private String titleAngelSettAng;
    
    /** Titulos de los filtros disponibles */
    private String[] arrayVig;
    
    /** Descripcion para cada filtro */
    private String[] arrayDes;
    
    /** Titulos del contenedor de seleccion de frecuencia */
    private String[] arrayFrc;
    
    /** Titulo del contenedor de angeles */
    private String titleVigAngSettVig;

    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    public String getTitleSettVig() {
        return titleSettVig;
    }

    public void setTitleSettVig(String titleSettVig) {
        this.titleSettVig = titleSettVig;
    }

    public String getTitleVigilantSettVig() {
        return titleVigilantSettVig;
    }

    public void setTitleVigilantSettVig(String titleVigilantSettVig) {
        this.titleVigilantSettVig = titleVigilantSettVig;
    }

    public String getTitleVigFrecSettVig() {
        return titleVigFrecSettVig;
    }

    public void setTitleVigFrecSettVig(String titleVigFrecSettVig) {
        this.titleVigFrecSettVig = titleVigFrecSettVig;
    }
    
    public String getTitleFbList() {
        return titleFbList;
    }

    public void setTitleFbList(String titleFbList) {
        this.titleFbList = titleFbList;
    }

    public String getTitleAngelSettAng() {
        return titleAngelSettAng;
    }

    public void setTitleAngelSettAng(String titleAngelSettAng) {
        this.titleAngelSettAng = titleAngelSettAng;
    }

    public String[] getArrayVig() {
        return arrayVig;
    }

    public void setArrayVig(String[] arrayVig) {
        this.arrayVig = arrayVig;
    }

    public String[] getArrayDes() {
        return arrayDes;
    }

    public void setArrayDes(String[] arrayDes) {
        this.arrayDes = arrayDes;
    }

    public String[] getArrayFrc() {
        return arrayFrc;
    }

    public void setArrayFrc(String[] arrayFrc) {
        this.arrayFrc = arrayFrc;
    }

    public String getTitleVigAngSettVig() {
        return titleVigAngSettVig;
    }

    public void setTitleVigAngSettVig(String titleVigAngSettVig) {
        this.titleVigAngSettVig = titleVigAngSettVig;
    }
    

    /**
     * Constructor de clase.
     * 
     * @param snsObject 
     */
    public SettingsSNSAngelGuardJSPControlerResourcesVigilants(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
        this.titleSettVig = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleSettVig();
        this.titleVigilantSettVig = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleVigilantSettVig();
        this.titleVigFrecSettVig = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleVigFrecSettVig();
        this.titleSettVig = snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleSettVig();
        this.titleFbList = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleFbListSettAng();
        this.titleAngelSettAng = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getSubTitleAngelSettAng();
        this.arrayVig = this.snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleVigSettVig());
        this.arrayDes = this.snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleVigDescriptionSettVig());
        this.arrayFrc = this.snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleVigFrecSelectSettVig());
        this.titleVigAngSettVig = this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleVigAngSettVig();
    }
    
    
}
