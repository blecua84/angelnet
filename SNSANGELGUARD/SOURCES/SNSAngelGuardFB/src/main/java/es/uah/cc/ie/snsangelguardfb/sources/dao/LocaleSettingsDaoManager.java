/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.dao;

import com.restfb.Parameter;
import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.facebookclient.data.LocaleUserFacebook;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import es.uah.cc.ie.snsangelguardfb.sources.dao.entity.LocaleSettingsDAO;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Manager que controla todos los recursos de idioma que se utilizan en la
 * aplicacion realizando para ello todas las operaciones de base de datos
 * necesarias.
 * 
 * @author tote
 */
public class LocaleSettingsDaoManager {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(LocaleSettingsDaoManager.class);

    /** Manager de la aplicaci?n */
    private SNSAngelGuardFBManager snsObject;

    /** Recursos cargados de idioma */
    private LocaleSettingsDAO localeSettingsDao;

    /**
     * Constructor de clase
     *
     * @param snsObject Manager del sistema.
     */
    public LocaleSettingsDaoManager(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
        this.localeSettingsDao = new LocaleSettingsDAO();
    }

    /**
     * Obtiene el Manager de la aplicaci?n.
     *
     * @return SNSAngelGuardFBManager
     */
    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    /**
     * Establece el Manager de la aplicaci?n.
     *
     * @param snsObject Manager del sistema.
     */
    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Obtiene la clase donde se almacenan los recursos de idioma.
     *
     * @return LocaleSettingsDAO
     */
    public LocaleSettingsDAO getLocaleSettingsDao() {
        return localeSettingsDao;
    }

    /**
     * Establece la clase donde se almacenan los recursos de idioma.
     *
     * @param localeSettingsDao
     */
    public void setLocaleSettingsDao(LocaleSettingsDAO localeSettingsDao) {
        this.localeSettingsDao = localeSettingsDao;
    }

    /**
     * Obtiene los recursos de idioma para un usuario en modo offline.
     *
     * @return JSONObject con los recursos de idioma para un usuario.
     * @throws JSONException
     */
    public JSONObject getJsonLocaleSettingsOffLine() throws JSONException{
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettingsOffLine: Inicio getJsonLocaleSettingsOffLine...");
        JSONObject locale = null;
        Long uidLong = (new Double(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid().toString())).longValue();

        String userSettings = this.snsObject.getClient().userFacebook_getUserFacebookByUid(String.class, uidLong.toString());
        JSONObject jsonUserSettings = new JSONObject(userSettings);

        String idLocale = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getIdLocale(jsonUserSettings.getString("locale"));
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettingsOffLine: Idioma del usuario: " + jsonUserSettings.getString("locale"));
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettingsOffLine: Codigo de idioma del usuario: " + idLocale);

        String strLocale = this.snsObject.getClient().localeSettings_getLocaleSettingsByUid(String.class, idLocale);
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettingsOffLine: Recursos de idioma obtenidos!!");
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettingsOffLine: Obtenemos objeto json con los recursos de idioma...");
        locale = new JSONObject(strLocale);
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettingsOffLine: Objeto json con los recursos de idioma obtenido!!");

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettingsOffLine: Fin getJsonLocaleSettingsOffLine...");
        return locale;
    }

    /**
     * Carga los recursos de idioma en modo offline en el atributo
     * localeSettingsDao.
     */
    public void loadLocaleSettingsOffLine() {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettingsOffLine: Inicio loadLocaleSettingsOffLine...");
        try {
            // SE CARGA EL IDIOMA DEL USUARIO
            JSONObject jsonLocale = getJsonLocaleSettingsOffLine();
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettingsOffLine: Recursos obtenidos!!");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettingsOffLine: Cargamos recursos en el atributo localeSettingsDao...");
            this.localeSettingsDao = new LocaleSettingsDAO(jsonLocale.getString("idLocale"), jsonLocale.getString("acceptingTerms"),
                    jsonLocale.getString("legalAccepted"), jsonLocale.getString("btnAgreeAT"), jsonLocale.getString("btnCancelAT"),
                    jsonLocale.getString("titleAT"), jsonLocale.getString("titleSettings"),
                    jsonLocale.getString("titleMenSettings"), jsonLocale.getString("btnSaveCheckSettings"), jsonLocale.getString("titleSettAng"),
                    jsonLocale.getString("titleFriendsContentSettAng"), jsonLocale.getString("titleFriendsImportSettAng"), jsonLocale.getString("txtNameTutorSettAng"),
                    jsonLocale.getString("txtEmailTutorSettAng"), jsonLocale.getString("btnImportSettAng"), jsonLocale.getString("titleFbListSettAng"),
                    jsonLocale.getString("subTitleAngelSettAng"), jsonLocale.getString("titleSettVig"), jsonLocale.getString("titleVigilantSettVig"),
                    jsonLocale.getString("titleVigSettVig"), jsonLocale.getString("titleVigDescriptionSettVig"), jsonLocale.getString("titleVigFrecSettVig"),
                    jsonLocale.getString("titleVigFrecSelectSettVig"), jsonLocale.getString("titleVigAngSettVig"), jsonLocale.getString("titleAngConfirm"),
                    jsonLocale.getString("desInfoAngConfirm"), jsonLocale.getString("aceptConfAngConfirm"), jsonLocale.getString("cancelConfAngConfirm"),
                    jsonLocale.getString("infoAngGuard"), jsonLocale.getString("titleAngUser"), jsonLocale.getString("nameUserAngUser"), jsonLocale.getString("btnCloseAngUser"),
                    jsonLocale.getString("titleGoogleCont"), jsonLocale.getString("titleContGoogleCont"), jsonLocale.getString("btnLogGoogleCont"),
                    jsonLocale.getString("titleNameContactGoogleCont"), jsonLocale.getString("titleEmailContactGoogleCont"), jsonLocale.getString("btnAceptGoogleCont"), jsonLocale.getString("btnCancelGoogleCont"),
                    jsonLocale.getString("helpMe"), jsonLocale.getString("warnings"), jsonLocale.getString("titleInformationMessage"), jsonLocale.getString("informationMessage"), jsonLocale.getString("mailDelete"),
                    jsonLocale.getString("mailNotification"), jsonLocale.getString("altContactsAngelsEd"), jsonLocale.getString("titleVisitsFilterOptions"));
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettingsOffLine: Recursos en el atributo localeSettingsDao cargados!!");
        } catch (Exception ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettingsOffLine: Excepcion capturada Exception: " + ex.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettingsOffLine: Fin loadLocaleSettingsOffLine...");
    }

    /**
     * Obtiene los recursos de idioma en modo online para un usuario.
     *
     * @return JSONObject con los recursos de idioma para un usuario.
     * @throws JSONException
     * @throws UniformInterfaceException
     * @throws IOException
     */
    public JSONObject getJsonLocaleSettings() throws JSONException, UniformInterfaceException, IOException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettings: Inicio getJsonLocaleSettings...");
        Long uidLong = (new Double(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid().toString())).longValue();

        List<LocaleUserFacebook> idiomaClienteList = this.snsObject.getFacebookRestClient().executeForList("Users.getInfo", LocaleUserFacebook.class, Parameter.with("uids", uidLong), Parameter.with("fields", "locale"));
        
        String idiomaCliente =  idiomaClienteList.get(0).getLocale();

        String idLocale = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getIdLocale(idiomaCliente);
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettings: Idioma del usuario: " + idiomaCliente);
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettings: Codigo de idioma del usuario: " + idLocale);

        String locale = this.snsObject.getClient().localeSettings_getLocaleSettingsByUid(String.class, idLocale);
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettings: Recursos de idioma obtenidos!!");

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonLocaleSettings: Fin getJsonLocaleSettings...");
        return new JSONObject(locale);
    }

    /**
     * Carga los recursos de idioma en modo online en el atributo
     * localeSettingsDao.
     */
    public void loadLocaleSettings() {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettings: Inicio loadLocaleSettings...");
        try {
            // SE CARGA EL IDIOMA DEL USUARIO
            JSONObject jsonLocale = getJsonLocaleSettings();
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettings: Recursos obtenidos!!");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettings: Cargamos recursos en el atributo localeSettingsDao...");
            this.localeSettingsDao = new LocaleSettingsDAO(jsonLocale.getString("idLocale"), jsonLocale.getString("acceptingTerms"),
                    jsonLocale.getString("legalAccepted"), jsonLocale.getString("btnAgreeAT"), jsonLocale.getString("btnCancelAT"),
                    jsonLocale.getString("titleAT"), jsonLocale.getString("titleSettings"),
                    jsonLocale.getString("titleMenSettings"), jsonLocale.getString("btnSaveCheckSettings"), jsonLocale.getString("titleSettAng"),
                    jsonLocale.getString("titleFriendsContentSettAng"), jsonLocale.getString("titleFriendsImportSettAng"), jsonLocale.getString("txtNameTutorSettAng"),
                    jsonLocale.getString("txtEmailTutorSettAng"), jsonLocale.getString("btnImportSettAng"), jsonLocale.getString("titleFbListSettAng"),
                    jsonLocale.getString("subTitleAngelSettAng"), jsonLocale.getString("titleSettVig"), jsonLocale.getString("titleVigilantSettVig"),
                    jsonLocale.getString("titleVigSettVig"), jsonLocale.getString("titleVigDescriptionSettVig"), jsonLocale.getString("titleVigFrecSettVig"),
                    jsonLocale.getString("titleVigFrecSelectSettVig"), jsonLocale.getString("titleVigAngSettVig"), jsonLocale.getString("titleAngConfirm"),
                    jsonLocale.getString("desInfoAngConfirm"), jsonLocale.getString("aceptConfAngConfirm"), jsonLocale.getString("cancelConfAngConfirm"),
                    jsonLocale.getString("infoAngGuard"), jsonLocale.getString("titleAngUser"), jsonLocale.getString("nameUserAngUser"), jsonLocale.getString("btnCloseAngUser"),
                    jsonLocale.getString("titleGoogleCont"), jsonLocale.getString("titleContGoogleCont"), jsonLocale.getString("btnLogGoogleCont"),
                    jsonLocale.getString("titleNameContactGoogleCont"), jsonLocale.getString("titleEmailContactGoogleCont"), jsonLocale.getString("btnAceptGoogleCont"), jsonLocale.getString("btnCancelGoogleCont"),
                    jsonLocale.getString("helpMe"), jsonLocale.getString("warnings"), jsonLocale.getString("titleInformationMessage"), jsonLocale.getString("informationMessage"), jsonLocale.getString("mailDelete"),
                    jsonLocale.getString("mailNotification"), jsonLocale.getString("altContactsAngelsEd"), jsonLocale.getString("titleVisitsFilterOptions"));
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettings: Recursos en el atributo localeSettingsDao cargados!!");
        } catch (Exception ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettings: Excepci?n capturada Exception: " + ex.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadLocaleSettings: Fin loadLocaleSettings...");
    }
}