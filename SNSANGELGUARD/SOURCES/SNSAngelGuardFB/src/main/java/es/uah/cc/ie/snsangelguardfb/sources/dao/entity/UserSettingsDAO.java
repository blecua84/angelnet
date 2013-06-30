/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.dao.entity;

import bsh.ParseException;
import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import es.uah.cc.ie.snsangelguardfb.sources.dao.UserSettingsDaoManager;
import es.uah.cc.ie.snsangelguardfb.sources.utilities.JSONUtilities;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openide.util.Exceptions;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.encoders.UrlBase64;
import org.codehaus.jettison.json.JSONArray;

/**
 * Gestiona toda la informacion de la tabla userSettings para la configuracion
 * de la aplicacion para un determinado usuario.
 *
 * @author tote
 */
public class UserSettingsDAO {
   
    /** Clave unica privada para la generacion del cifrado de la clave publica de acceso */
    private static final String CF_64 = "JJMAGICFBNANYANG";
    
    /** Logger Class */
    private static Logger logger = Logger.getLogger(UserSettingsDAO.class);

    /** Clase Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
    
    /** Manager del objeto UserSettingsDAO */ 
    private UserSettingsDaoManager manager;
    
    /** Identificador ?nico en base de datos */
    private String uid;
    
    /** Nombre del usuario */
    private String userName;
    
    /** Email del usuario */
    private String userEmail;
    
    /** Indicador de aceptacion del acuerdo legal */
    private Boolean legalAccepted;
    
    /** Fecha que muestra el ultimo acceso del usuario a la aplicacion */
    private Date lastCheck;
    
    /** Identificador publico cifrado de acceso a la aplicacion */
    private String uidPublic;
    
    /** Indicador de activacion de la aplicacion */
    private Boolean appActivated;
    
    /** Token de acceso a Facebook */
    private String userSession;
    
    /** Identificador del idioma en base de datos. Relacionado con la tabla locale\_settings */
    private String localeSettings;
    
    /** Fecha del ultimo backup de informacion offline */
    private Date backupCheck;
    
    /** Objeto para el filtro de control de lenguaje */
    private UserSettings_SettingsFilterDAO fltWall;
    
    /** Objeto para el filtro de control de amistades */
    private UserSettings_SettingsFilterDAO fltFriends;
    
    /** Objeto para el filtro de control de privacidad */
    private UserSettings_SettingsFilterDAO fltPriv;
    
    /** Objeto para el filtro de control de visitas */
    private UserSettings_SettingsFilterDAO fltVist;
    
    /** Campo que almacena los angeles seleccionados en la aplicacion separados por el caracter ; */
    private String angelsSelected = "";

    /**
     * Constructor sin parametros.
     */
    public UserSettingsDAO() {
    }

    /**
     * Constructor de clase. Inicializara el identificador del usuario, su nombre, su email y el objeto manager de la aplicacion.
     * 
     * @param uid
     * @param userName
     * @param userEmail
     * @param snsObject 
     */
    public UserSettingsDAO(String uid, String userName, String userEmail, SNSAngelGuardFBManager snsObject) {
        this.uid = uid;
        this.userName = userName;
        this.userEmail = userEmail;
        this.snsObject = snsObject;
    }

    /**
     * Constructor de clase. Recibir? todos los atributos por par?metro y cargar?, en base a estos, todos los filtros del usuario mediante el metodo loadFullFuntionalityFilter.
     * 
     * @param manager
     * @param uid
     * @param userName
     * @param userEmail
     * @param legalAccepted
     * @param lastCheck
     * @param uidPublic
     * @param appActivated
     * @param userSession
     * @param backupCheck
     * @param snsObject 
     */
    public UserSettingsDAO(UserSettingsDaoManager manager, String uid, String userName, String userEmail, Boolean legalAccepted, Date lastCheck, String uidPublic, Boolean appActivated, String userSession, Date backupCheck, SNSAngelGuardFBManager snsObject) {
        this.manager = manager;
        this.uid = uid;
        this.userName = userName;
        this.userEmail = userEmail;
        this.legalAccepted = legalAccepted;
        this.lastCheck = lastCheck;
        this.uidPublic = uidPublic;
        this.appActivated = appActivated;
        this.userSession = userSession;
        this.backupCheck = backupCheck;
        this.fltWall = new UserSettings_SettingsFilterDAO(manager);
        this.fltFriends = new UserSettings_SettingsFilterDAO(manager);
        this.fltPriv = new UserSettings_SettingsFilterDAO(manager);
        this.fltVist = new UserSettings_SettingsFilterDAO(manager);
        this.snsObject = snsObject;

        // Cargamos todos los filtros con la informacion de la base de datos
        this.loadFullFuntionalityFilter();
    }

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the legalAccepted
     */
    public Boolean isLegalAccepted() {
        return legalAccepted;
    }

    /**
     * @param legalAccepted the legalAccepted to set
     */
    public void setLegalAccepted(Boolean legalAccepted) {
        this.legalAccepted = legalAccepted;
    }

    /**
     * @return the lastCheck
     */
    public Date getLastCheck() {
        return lastCheck;
    }

    /**
     * @param lastCheck the lastCheck to set
     */
    public void setLastCheck(Date lastCheck) {
        this.lastCheck = lastCheck;
    }

    /**
     * @return the uidPublicLocal
     */
    public String getUidPublic() {
        return uidPublic;
    }

    /**
     * @param uidPublicLocal the uidPublicLocal to set
     */
    public void setUidPublic(String uidPublic) {
        this.uidPublic = uidPublic;
    }

    /**
     * @return the appActivated
     */
    public Boolean isAppActivated() {
        return appActivated;
    }

    /**
     * @param appActivated the appActivated to set
     */
    public void setAppActivated(Boolean appActivated) {
        this.appActivated = appActivated;
    }

    /**
     * @return the userSession
     */
    public String getUserSession() {
        return userSession;
    }

    /**
     * @param userSession the userSession to set
     */
    public void setUserSession(String userSession) {
        this.userSession = userSession;
    }

    /**
     * @return the localeSettings
     */
    public String getLocaleSettings() {
        return localeSettings;
    }

    /**
     * @param localeSettings the localeSettings to set
     */
    public void setLocaleSettings(String localeSettings) {
        this.localeSettings = localeSettings;
    }

    /**
     * @return the backupCheck
     */
    public Date getBackupCheck() {
        return backupCheck;
    }

    /**
     * @param backupCheck the backupCheck to set
     */
    public void setBackupCheck(Date backupCheck) {
        this.backupCheck = backupCheck;
    }

    /**
     * @return the fltWall
     */
    public UserSettings_SettingsFilterDAO getFltWall() {
        return fltWall;
    }

    /**
     * @param fltWall the fltWall to set
     */
    public void setFltWall(UserSettings_SettingsFilterDAO fltWall) {
        this.fltWall = fltWall;
    }

    /**
     * @return the fltFriends
     */
    public UserSettings_SettingsFilterDAO getFltFriends() {
        return fltFriends;
    }

    /**
     * @param fltFriends the fltFriends to set
     */
    public void setFltFriends(UserSettings_SettingsFilterDAO fltFriends) {
        this.fltFriends = fltFriends;
    }

    /**
     * @return the fltPriv
     */
    public UserSettings_SettingsFilterDAO getFltPriv() {
        return fltPriv;
    }

    /**
     * @param fltPriv the fltPriv to set
     */
    public void setFltPriv(UserSettings_SettingsFilterDAO fltPriv) {
        this.fltPriv = fltPriv;
    }

    /**
     * @return the fltVist
     */
    public UserSettings_SettingsFilterDAO getFltVist() {
        return fltVist;
    }

    /**
     * @param fltVist the fltVist to set
     */
    public void setFltVist(UserSettings_SettingsFilterDAO fltVist) {
        this.fltVist = fltVist;
    }

    /**
     * @return the snsObject
     */
    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    /**
     * @param snsObject the snsObject to set
     */
    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Obtiene el identificador de idioma de la tabla locale\_settings dependiendo del idioma del perfil de Facebook del usuario. Pordr? lanzar excepciones del tipo JSONException.
     *
     * @param locale Codigo de idioma de Facebook.
     * @return Identificador del indice de la base de datos SNS para el idioma.
     * @throws JSONException
     */
    public String getIdLocale(String locale) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getIdLocale: Inicio getIdLocale...");
        if (locale.substring(0, 2).equals("es")) {
            this.setLocaleSettings("00000002");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getIdLocale: Fin getIdLocale...");
            return "00000002";
        } else {
            this.setLocaleSettings("00000001");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getIdLocale: Fin getIdLocale...");
            return "00000001";
        }

    }

    /**
     * Obtiene en un objeto JSON todos los recursos de idioma para un perfil de
     * Facebook.
     *
     * @param codLocale Identificador de base de datos del idioma concreto.
     * @return JSONObject
     */
    public JSONObject getJSONLocale(String codLocale) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJSONLocale: Inicio getJSONLocale...");
        String locale = this.snsObject.getClient().localeSettings_getLocaleSettingsByUid(String.class, codLocale);
        JSONObject jsonLocale = null;

        if (!locale.equals("{}") && !locale.contains("error_code")) {
            try {
                jsonLocale = new JSONObject(locale);
                jsonLocale.put("userSettingsCollection", "");
                return jsonLocale;
            } catch (JSONException ex) {
                Exceptions.printStackTrace(ex);
                return jsonLocale;
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJSONLocale: Fin getJSONLocale...");
        return jsonLocale;
    }

    /**
     * @return the angelsSelected
     */
    public String getAngelsSelected() {
        return angelsSelected;
    }

    /**
     * @param angelsSelected the angelsSelected to set
     */
    public void setAngelsSelected(String angelsSelected) {
        this.angelsSelected = angelsSelected;
    }


    /**
     * Obtiene una cadena de texto cifrada en Base64 utilizando el algoritmo AES a partir de la cadena de entrada. Podr? lanzar excepciones del tipo org.bouncycastle.crypto.DataLengthException,
     * java.lang.IllegalStateException o org.bouncycastle.crypto.InvalidCipherTextException.
     *
     * @param textoEnClaro Texto en claro que deseamos cifrar
     * @param clave Clave a utilizar en el proceso de cifrado
     * @return Cadena con el texto cifrado, codificada en Base64
     * @throws org.bouncycastle.crypto.DataLengthException
     * @throws java.lang.IllegalStateException
     * @throws org.bouncycastle.crypto.InvalidCipherTextException
     */
    public static String cifrar(String textoEnClaro)
            throws DataLengthException,
            IllegalStateException,
            InvalidCipherTextException {
        // Obtenemos los valores binarios del texto en claro y la clave
        byte[] textoEnClaroB = textoEnClaro.getBytes();
        byte[] claveB = CF_64.getBytes();
        // Instanciamos un motor de cifrado para el algoritmo AES
        BlockCipher engine = new AESEngine();
        // Creamos el cifrador con padding y en modo CBC
        BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));
        // Inicializamos el cifrador en modo cifrado
        cipher.init(true, new KeyParameter(claveB));
        // Instanciamos el vector de bytes para almacenar el criptograma
        byte[] criptograma = new byte[cipher.getOutputSize(textoEnClaroB.length)];
        // Procesa todos los bytes del texto en claro
        int temp = cipher.processBytes(textoEnClaroB, 0, textoEnClaroB.length, criptograma, 0);
        // Finaliza el proceso de cifrado
        cipher.doFinal(criptograma, temp);
        // Codifica el criptograma en Base64
        String criptogramaB64 = new String(UrlBase64.encode(criptograma));
        return criptogramaB64;
    }

    /**
     * Descifra una cadena de texto cifrada en Base64 utilizando el algoritmo AES. Podr? lanzar excepciones del tipo org.bouncycastle.crypto.DataLengthException,
     * java.lang.IllegalStateException o org.bouncycastle.crypto.InvalidCipherTextException.
     * 
     * @param criptogramaB64 Criptograma con el texto cifrado, codificado en Base64
     * @param clave Clave a utilizar en el proceso de descifrado
     * @return Texto en claro resultante del proceso de descifrado
     * @throws org.bouncycastle.crypto.DataLengthException
     * @throws java.lang.IllegalStateException
     * @throws org.bouncycastle.crypto.InvalidCipherTextException
     */
    public static String descifrar(String criptogramaB64)
            throws DataLengthException,
            IllegalStateException,
            InvalidCipherTextException {
        // Obtenemos los valores binarios del criptograma y la clave
        byte[] criptogramaB = UrlBase64.decode(criptogramaB64.getBytes());
        byte[] claveB = CF_64.getBytes();
        // Instanciamos un motor de cifrado para el algoritmo AES
        BlockCipher engine = new AESEngine();
        // Creamos el cifrador con padding y en modo CBC
        BufferedBlockCipher cipher = new PaddedBufferedBlockCipher(new CBCBlockCipher(engine));
        // Inicializamos el cifrador en modo cifrado
        cipher.init(false, new KeyParameter(claveB));
        // Instanciamos el vector de bytes para almacenar el texto en claro
        byte[] textoEnClaro = new byte[cipher.getOutputSize(criptogramaB.length)];
        // Procesa todos los bytes del criptograma
        int temp = cipher.processBytes(criptogramaB, 0, criptogramaB.length, textoEnClaro, 0);
        // Finaliza el proceso de descifrado
        cipher.doFinal(textoEnClaro, temp);
        return new String(textoEnClaro);
    }

    /**
     * Crea un objeto JSONObject a partir de los atributos de la clase y lo persiste en base de datos mediante el servicio web userSettings\_setNewEntityUserSettings, despu?s lo retorna como resultado.
     * Puede lanzar excepciones de los tipos JSONException, DataLengthException, IllegalStateException, InvalidCipherTextException, UnsupportedEncodingException, 
     * UniformInterfaceException, IOException, NoSuchProviderException, MessagingException, InterDataBaseException, InterProcessException o InterEmailException.
     * 
     * @param request
     * @param response
     * @return
     * @throws JSONException
     * @throws DataLengthException
     * @throws IllegalStateException
     * @throws InvalidCipherTextException
     * @throws UnsupportedEncodingException
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws InterDataBaseException
     * @throws InterProcessException
     * @throws InterEmailException 
     */
    public JSONObject getNewInstanceUS(HttpServletRequest request, HttpServletResponse response) throws JSONException, DataLengthException, IllegalStateException, InvalidCipherTextException, UnsupportedEncodingException, UniformInterfaceException, IOException, NoSuchProviderException, MessagingException, InterDataBaseException, InterProcessException, InterEmailException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewInstanceUS: Inicio getNewInstanceUS...");
        Long uidLong = (new Double(this.getUid())).longValue();
        String uidPublicLocal = "";
        HttpSession sesion = request.getSession(false);
        this.setLegalAccepted(true);

        JSONObject newInstance = new JSONObject();
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewInstanceUS: UID convertida a Long: " + uidLong);
        newInstance.put("uid", uidLong);
        newInstance.put("userName", this.getUserName());
        newInstance.put("userEmail", this.getUserEmail());
        if (this.isLegalAccepted()) {
            newInstance.put("legalAccepted", "1");
        } else {
            newInstance.put("legalAccepted", "0");
        }
        newInstance.put("lastCheck", "");
        newInstance.put("backupCheck", "");
        uidPublicLocal = UserSettingsDAO.cifrar(uidLong.toString());
        this.setUidPublic(uidPublicLocal);
        newInstance.put("uidPublic", this.getUidPublic());
        if (this.isAppActivated()) {
            newInstance.put("appActivated", "1");
        } else {
            newInstance.put("appActivated", "0");
        }
        newInstance.put("userSession", this.getUserSession());
        JSONObject jsonLocale = getJSONLocale(this.getLocaleSettings());
        JSONObject codeLocale = new JSONObject();
        
        codeLocale.put("uri", jsonLocale.get("uri"));
        newInstance.put("localeSettings", codeLocale);
//        newInstance.put("localeSettings", this.getLocaleSettings());
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewInstanceUS: Nueva objeto a base de datos: " + newInstance.toString());
        try {
            this.snsObject.getClient().userSettings_setNewEntityUserSettings(String.class, newInstance);
            //this.putNewAngels(true);
            //this.getNewAngels();
            this.initDBnewFilter("fltWall");
            this.initDBnewFilter("fltFriends");
            this.initDBnewFilter("fltPriv");
            this.initDBnewFilter("fltVist");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewInstanceUS: Fin getNewInstanceUS...");
        } catch (Exception e) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewInstanceUS: Excepcion capturada Exception: " + e.getMessage());
            this.snsObject.getExceptionManager().initControlException(e);         
        }
        
        return newInstance;
    }

    /**
     * Devuelve un array de un String.
     *
     * @param activeFilter
     * @return String[]
     */
    public String[] getArrayActiveFilter(String activeFilter){
        return activeFilter.split(";");
    }

    /**
     * Persiste en base de datos los angeles definidos por un usuario. Puede lanzar excepciones del tipo throws JSONException, NoSuchProviderException, MessagingException, UniformInterfaceException o IOException.
     * 
     * @param activeFilter
     * @param newConnection
     * @throws JSONException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws UniformInterfaceException
     * @throws IOException 
     */
    public void setAngelsUserSettings(String activeFilter, boolean newConnection) throws JSONException, NoSuchProviderException, MessagingException, UniformInterfaceException, IOException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setAngelsUserSettings: Inicio setAngelsUserSettings...");
        this.putNewAngels(false);
        if(!newConnection){
            this.deleteAngelsRelationship();
            this.deleteOlderAngels();
        }
        this.getNewAngels();

        String[] arrActiveFilter = getArrayActiveFilter(activeFilter);

        this.putNewInstanceFilter("fltWall", arrActiveFilter[0]);
        this.putNewInstanceFilter("fltFriends", arrActiveFilter[1]);
        this.putNewInstanceFilter("fltPriv", arrActiveFilter[2]);
        this.putNewInstanceFilter("fltVist", arrActiveFilter[3]);
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setAngelsUserSettings: Fin setAngelsUserSettings...");
    }

    /**
     * Actualiza la informacion de un determinado filtro. Puede lanzar excepciones del tipo
     * JSONException, UnsupportedEncodingException, UniformInterfaceException, IOException, NoSuchProviderException o MessagingException.
     *
     * @param desFilter
     * @param activeFilter
     * @throws JSONException
     * @throws UnsupportedEncodingException
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws MessagingException
     */
    public void setAngelsUserSettingsByFilter(String desFilter, String activeFilter) throws JSONException, UnsupportedEncodingException, UniformInterfaceException, IOException, NoSuchProviderException, MessagingException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setAngelsUserSettingsByFilter: Inicio setAngelsUserSettingsByFilter...");
        this.putNewAngels(false);
        this.deleteAngelsRelationship();
        this.deleteOlderAngels();
        this.getNewAngels();
        this.putNewInstanceFilter(desFilter, activeFilter);
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setAngelsUserSettingsByFilter: Fin setAngelsUserSettingsByFilter...");
    }

    /**
     * Actualiza los angeles para un determinado filtro. Puede lanzar excepciones del tipo JSONException.
     *
     * @param jsonAngel
     * @param modo
     * @param des
     * @throws JSONException
     */
    public void setCollectionAngels(JSONObject jsonAngel, int modo, String des) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setCollectionAngels: Inicio setCollectionAngels...");
        JSONObject jsonCollection = null;
        JSONArray aux = null;
        JSONObject jsonUri = null;
        Long uidLong = (new Double(this.getUid())).longValue();

        switch (modo) {
            case 1:
                try{
                    jsonCollection = jsonAngel.getJSONObject("userSettingsCollection");
                    aux = jsonCollection.getJSONArray("userSettings");
                    jsonUri = new JSONObject();

                    jsonUri.put("uri", this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/settingsAngelss/" + jsonAngel.getString("uidAngel") + "/userSettingsCollection/" + uidLong + "/");
                    aux.put(jsonUri);
                    jsonCollection.put("userSettings", aux);

                    jsonAngel.put("userSettingsCollection", jsonCollection);
                } catch(JSONException e){
                    // Si no existen m?s angeles relacionados.
                    jsonUri = new JSONObject();
                    jsonUri.put("uri", this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/settingsAngelss/" + jsonAngel.getString("uidAngel") + "/userSettingsCollection/" + uidLong + "/");
                    
                    JSONObject jsonUriUserSettings = new JSONObject();
                    jsonUriUserSettings.put("userSettings", jsonUri);
                    
                    jsonAngel.put("userSettingsCollection", jsonUriUserSettings);
                }
                break;
            case 2:
                try{
                    jsonCollection = jsonAngel.getJSONObject("settings" + des + "Collection");
                    aux = jsonCollection.getJSONArray("settings" + des);
                    jsonUri = new JSONObject();

                    jsonUri.put("uri", this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/settingsAngelss/" + jsonAngel.getString("uidAngel") + "/settings" + des + "Collection/" + uidLong + "/");
                    aux.put(jsonUri);
                    jsonCollection.put("settings" + des, aux);

                    jsonAngel.put("settings" + des + "Collection", jsonCollection);
                } catch(JSONException e){
                    // Si no existen m?s angeles relacionados.
                    jsonUri = new JSONObject();
                    jsonUri.put("uri", this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/settingsAngelss/" + jsonAngel.getString("uidAngel") + "/settings" + des + "Collection/" + uidLong + "/");
                    
                    JSONObject jsonUriUserSettings = new JSONObject();
                    jsonUriUserSettings.put("settings" + des, jsonUri);
                    
                    jsonAngel.put("settings" + des + "Collection", jsonUriUserSettings);
                }
                break;
        }
        try {
            this.snsObject.getClient().userSettings_setNewAngelsCollectionByUid(String.class, jsonAngel.getString("uidAngel"), jsonAngel);
        } catch (Exception e) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setCollectionAngels: Excepcion capturada Exception: " + e.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setCollectionAngels: Fin setCollectionAngels...");
    }

    /**
     * Obtiene los nuevos angeles para un determinado filtro. Puede lanzar excepciones del tipo JSONException.
     *
     * @throws JSONException
     */
    public void getNewAngels() throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewAngels: Inicio getNewAngels...");
        String respuesta = "";
        JSONObject jsonRespuesta = null;
        JSONObject jsonAngel = null;
        JSONArray jsonArrayAngels = null;
        Long uidLong = (new Double(this.getUid())).longValue();
        respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uidLong + "\"");
        jsonRespuesta = new JSONObject(respuesta);
        jsonArrayAngels = this.snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels"));

        for (int i = 0; i < jsonArrayAngels.length(); i++) {
            jsonAngel = jsonArrayAngels.getJSONObject(i);
            setCollectionAngels(jsonAngel, 1, "");
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewAngels: Fin getNewAngels...");
    }

    /**
     * Elimina las relaciones existentes entre un angel eliminado de la configuracion
     * del usuario y los diferentes filtros existentes. Puede lanzar excepciones del tipo JSONException.
     *
     * @throws JSONException
     */
    public void deleteAngelsRelationship() throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteAngelsRelationship: Inicio deleteAngelsRelationship...");
        String respuesta = "";
        JSONObject jsonRespuesta = null;
        JSONObject jsonAngel = null;
        JSONArray jsonArrayAngels = null;
        Long uidLong = (new Double(this.getUid())).longValue();
        respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uidLong + "\"");
        jsonRespuesta = new JSONObject(respuesta);
        jsonArrayAngels = this.snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels"));

        for (int i = 0; i < jsonArrayAngels.length(); i++) {
            jsonAngel = jsonArrayAngels.getJSONObject(i);

            if (!jsonAngel.getString("uidAngel").equals("")) {
                jsonAngel = deleteCollection(jsonAngel, "fltWall", 2);
                jsonAngel = deleteCollection(jsonAngel, "fltFriends", 2);
                jsonAngel = deleteCollection(jsonAngel, "fltPriv", 2);
                jsonAngel = deleteCollection(jsonAngel, "fltVist", 2);
                jsonAngel = deleteCollection(jsonAngel, "", 1);

                try {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteAngelsRelationship: Relacion eliminada: " + jsonAngel.toString());
                    this.snsObject.getClient().userSettings_setNewAngelsCollectionByUid(String.class, jsonAngel.getString("uidAngel"), jsonAngel);
                } catch (Exception e) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteAngelsRelationship: Excepcion capturada Exception: " + e.getMessage());
                }
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteAngelsRelationship: Fin deleteAngelsRelationship...");
    }

    /**
     * Borra del objeto angel la relaci?n que le un?a a un filtro.
     *
     * @param jsonAngel
     * @param des
     * @param mode
     * @return
     * @throws JSONException
     */
    public JSONObject deleteCollection(JSONObject jsonAngel, String des, int mode) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteCollection: Inicio deleteCollection...");
        JSONObject jsonUri = null;

        switch (mode) {
            case 1:
                jsonUri = new JSONObject();
                jsonUri.put("uri", this.manager.getSnsObject().getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/settingsAngelss/" + jsonAngel.getString("uidAngel") + "/userSettingsCollection/");
                jsonAngel.put("userSettingsCollection", jsonUri);
                break;
            case 2:
                jsonUri = new JSONObject();
                jsonUri.put("uri", this.manager.getSnsObject().getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/settingsAngelss/" + jsonAngel.getString("uidAngel") + "/settings" + des + "Collection/");
                jsonAngel.put("settings" + des + "Collection", jsonUri);
                break;
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteCollection: Fin deleteCollection...");
        return jsonAngel;
    }

    /**
     * Inicializa como no activo los angeles seleccionados nuevos en base de
     * datos. Puede lanzar excepciones del tipo JSONException.
     *
     * @throws JSONException
     */
    public void setNotActiveAngels() throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNotActiveAngels: Inicio setNotActiveAngels...");
        String respuesta = "";
        JSONObject jsonRespuesta = null;
        JSONObject jsonAngel = null;
        JSONArray jsonArrayAngels = null;
        Long uidLong = (new Double(this.getUid())).longValue();
        respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uidLong + "\"");
        jsonRespuesta = new JSONObject(respuesta);
        jsonArrayAngels = snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels"));

        for (int i = 0; i < jsonArrayAngels.length(); i++) {
            jsonAngel = jsonArrayAngels.getJSONObject(i);
            if (!isActiveAngel(jsonAngel)) {
                jsonAngel.put("acceptAngel", "0");
                try {
                    this.snsObject.getClient().userSettings_setNewAngelsCollectionByUid(String.class, jsonAngel.getString("uidAngel"), jsonAngel);
                } catch (Exception e) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteAngelsRelationship: Excepcion capturada Exception: " + e.getMessage());
                }
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNotActiveAngels: Fin setNotActiveAngels...");
    }

    /**
     * Comprueba si un angel esta activo para empezar a enviarle informes. Si est? activo retornar? el valor true, y false en cualquier otro caso. Puede lanzar excepciones del tipo JSONException.
     * 
     * @param jsonAngel
     * @return
     * @throws JSONException
     */
    public boolean isActiveAngel(JSONObject jsonAngel) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isActiveAngel: Inicio isActiveAngel...");
        boolean active = true;
        JSONObject jsonSettings = jsonAngel.getJSONObject("userSettingsCollection");

        if (jsonSettings.getString("userSettings").equals("")) {
            active = false;
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isActiveAngel: Fin isActiveAngel...");
        return active;
    }

    /**
     * Comprueba si un angel esta seleccionado por un usuario. Devolver? true en caso de encontrarse seleccionado, false en caso contrario.
     * 
     * @param angelsSelected
     * @param angel
     * @return
     */
    public boolean isSelectedArray(String angelsSelected, String angel) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isSelectedArray: Inicio isSelectedArray...");
        boolean seleccionado = false;

        if (!angelsSelected.equals("") && angelsSelected != null) {
            String[] arrayAngels = angelsSelected.split((";"));

            for (int i = 0; i < arrayAngels.length; i++) {
                if (angel.equals(arrayAngels[i])) {
                    seleccionado = true;
                    break;
                }
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isSelectedArray: Fin isSelectedArray...");
        return seleccionado;
    }

    /**
     * Obtiene un JSONArray con los datos de los angeles definidos en la aplicacion. Puede lanzar excepciones del tipo JSONException.
     *
     * @param arrayAngels
     * @return
     * @throws JSONException
     */
    public JSONArray getAngels(String[][] arrayAngels) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngels: Inicio getAngels...");
        String[] arrayAngelsSelected = this.getAngelsSelected().split(";");
        JSONArray jsonAngelsFilter = new JSONArray();
        JSONObject jsonDatesAngel = null;
        Long uidLong = (new Double(this.getUid())).longValue();

        for (int i = 0; i < arrayAngelsSelected.length; i++) {
            for (int j = 0; j < arrayAngels.length; j++) {
                if (arrayAngelsSelected[i].equals(arrayAngels[j][0])) {
                    jsonDatesAngel = new JSONObject();
                    jsonDatesAngel.put("idAngel", arrayAngels[j][0]);
                    jsonDatesAngel.put("nameAngel", arrayAngels[j][1]);
                    jsonDatesAngel.put("imgAngel", arrayAngels[j][2]);
                    jsonDatesAngel.put("typeAngel", arrayAngels[j][3]);
                    jsonDatesAngel.put("acceptAngel", "0");
                    jsonDatesAngel.put("userPropAngel", uidLong);
                    jsonDatesAngel.put("confirmAngel", "0");

                    jsonAngelsFilter.put(jsonDatesAngel);
                }
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngels: Fin getAngels...");
        return jsonAngelsFilter;
    }

    /**
     * Obtiene los angeles seleccionados para cada filtro definido.
     *
     * @param arrayAngels
     * @param angelsFilter
     */
    public void gelAngelsUserFilter(String[][] arrayAngels, String angelsFilter) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - gelAngelsUserFilter: Inicio gelAngelsUserFilter...");
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - gelAngelsUserFilter: Angeles definidos en los filtros: " + angelsFilter);
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - gelAngelsUserFilter: Numero de angeles definidos: " + arrayAngels.length);

        try{
            if (!angelsFilter.equals("") && angelsFilter != null) {
                String[] arrayAngelsFilter = angelsFilter.split(";");

                for (int i = 0; i < arrayAngelsFilter.length; i++) {
                    for (int j = 0; j < arrayAngels.length; j++) {
                        if (arrayAngelsFilter[i].equals(arrayAngels[j][0])) {
                            if (!isSelectedArray(this.angelsSelected, arrayAngelsFilter[i])) {
                                if (this.getAngelsSelected().equals("")) {
                                    this.setAngelsSelected(arrayAngelsFilter[i] + ";");
                                } else {
                                    this.setAngelsSelected(this.getAngelsSelected() + arrayAngelsFilter[i] + ";");
                                }
                            }
                        }
                    }
                }
            }
        }catch(NullPointerException e){
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - gelAngelsUserFilter: Excepcion capturada NullPointerException: " + e.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - gelAngelsUserFilter: Fin gelAngelsUserFilter...");
    }

    /**
     * Almacena en base de datos los nuevos angeles para un nuevo usuario de la
     * aplicacion.
     *
     * @param angels
     */
    public void putNewAngelsNewUser(JSONArray angels){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsNewUser: Inicio putNewAngelsNewUser...");
        try {
            for (int i = 0; i < angels.length(); i++) {
                this.snsObject.getClient().settingsAngels_setNewAngel(String.class, angels.getJSONObject(i));
                JSONObject newAngel = findAngel(angels.getJSONObject(i));
                snsObject.getEmailObject().sendMailConfirmationAngel(newAngel, this.getUidPublic());
            }
        } catch (UnsupportedEncodingException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsNewUser: Excepcion capturada UnsupportedEncodingException: " + ex.getMessage());
        } catch (UniformInterfaceException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsNewUser: Excepcion capturada UniformInterfaceException: " + ex.getMessage());
        } catch (IOException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsNewUser: Excepcion capturada IOException: " + ex.getMessage());
        } catch (java.security.NoSuchProviderException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsNewUser: Excepcion capturada java.security.NoSuchProviderException: " + ex.getMessage());
        } catch (MessagingException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsNewUser: Excepcion capturada MessagingException: " + ex.getMessage());
        } catch (JSONException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsNewUser: Excepcion capturada JSONException: " + ex.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsNewUser: Fin putNewAngelsNewUser...");
    }

    /**
     * Inserta los nuevos angeles en la base de datos para un usuario ya existente.
     *
     * @param jsonRespuesta
     * @param angels
     */
    public void putNewAngelsUser(JSONObject jsonRespuesta, JSONArray angels){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsUser: Fin putNewAngelsUser...");
        JSONObject jsonAngel = null;
        JSONObject jsonAngelDB = null;
        JSONArray jsonArrayDB = null;
        boolean isAngelNew = false;

        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsUser: No es una nueva conexi?n...");
        try {
            jsonArrayDB = snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels"));

            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsUser: Angeles actuales: " + jsonArrayDB.toString());

            for (int i = 0; i < angels.length(); i++) {
                isAngelNew = true;
                // Angel nuevo
                jsonAngel = angels.getJSONObject(i);
                for (int j = 0; j < jsonArrayDB.length(); j++) {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsUser: Buscando " + j);
                    // Angel en la BD
                    jsonAngelDB = jsonArrayDB.getJSONObject(j);
                    if (jsonAngelDB.getString("idAngel").equals(jsonAngel.getString("idAngel"))) {
                        isAngelNew = false;
                        break;
                    }
                }
                if (isAngelNew) {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsUser: Nuevo angel...");
                    this.snsObject.getClient().settingsAngels_setNewAngel(String.class, jsonAngel);
                    jsonAngel = findAngel(jsonAngel);
                    if (!jsonAngel.toString().equals("{}")) {
                        try {
                            try {
                                snsObject.getEmailObject().sendMailConfirmationAngel(jsonAngel, this.getUidPublic());
                            } catch (UnsupportedEncodingException ex) {
                                Exceptions.printStackTrace(ex);
                            } catch (UniformInterfaceException ex) {
                                Exceptions.printStackTrace(ex);
                            } catch (IOException ex) {
                                Exceptions.printStackTrace(ex);
                            } catch (MessagingException ex) {
                                Exceptions.printStackTrace(ex);
                            }
                        } catch (java.security.NoSuchProviderException ex) {
                            Exceptions.printStackTrace(ex);
                        }
                    }
                }
            }
            setToDelOlderAngels(angels);
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsUser: Fin putNewAngelsUser...");
        } catch (JSONException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngelsUser: Excepcion capturada JSONException: " + ex.getMessage());
        }

    }

    /**
     * Inserta los nuevos angeles en la base de datos y los devuelve como retorno en un JSONArray. Puede lanzar excepciones del tipo
     * JSONException, UnsupportedEncodingException, UniformInterfaceException, IOException, NoSuchProviderException o MessagingException.
     *
     * @param inicio
     * @return
     * @throws JSONException
     * @throws UnsupportedEncodingException
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws MessagingException
     */
    public JSONArray putNewAngels(boolean inicio) throws JSONException, UnsupportedEncodingException, UniformInterfaceException, IOException, NoSuchProviderException, MessagingException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngels: Inicio putNewAngels...");
        this.gelAngelsUserFilter(this.snsObject.getAngelsUtilities().getArrayAngelsSelected(), this.getFltWall().getAngels());
        this.gelAngelsUserFilter(this.snsObject.getAngelsUtilities().getArrayAngelsSelected(), this.getFltFriends().getAngels());
        this.gelAngelsUserFilter(this.snsObject.getAngelsUtilities().getArrayAngelsSelected(), this.getFltPriv().getAngels());
        this.gelAngelsUserFilter(this.snsObject.getAngelsUtilities().getArrayAngelsSelected(), this.getFltVist().getAngels());

        JSONArray angels = this.getAngels(this.snsObject.getAngelsUtilities().getArrayAngelsSelected());
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngels: Nuevos angeles: " + angels.toString());

        String respuesta = "";
        JSONObject jsonRespuesta = null;

        Long uidLong = (new Double(this.getUid())).longValue();
        respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uidLong + "\"");
        jsonRespuesta = new JSONObject(respuesta);
        
        if (!existAnyAngel(jsonRespuesta, "settingsAngels")) {
            putNewAngelsNewUser(angels);
        } else {
            putNewAngelsUser(jsonRespuesta, angels);
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewAngels: Fin putNewAngels...");
        return angels;
    }

    /**
     * Indica si un angel esta almacenado en base de datos, devolviendo el JSONObject con la informacion de la base de datos
     * o un nuevo JSONObject vacio que indica que el usuario no ha sido encontrado. Puede lanzar excepciones del tipo JSONException.
     *
     * @param jsonAngel
     * @return
     * @throws JSONException
     */
    public JSONObject findAngel(JSONObject jsonAngel) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - findAngel: Fin findAngel...");
        Long uidLong = (new Double(this.getUid())).longValue();
        String respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uidLong + "\"");
        JSONObject jsonRespuesta = new JSONObject(respuesta);
        JSONArray jsonArrayDB = snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels"));
        JSONObject jsonAngelDB = null;
        boolean encontrado = false;
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - findAngel: Angeles actuales tras el nuevo angel: " + jsonArrayDB.toString());

        for (int i = 0; i < jsonArrayDB.length(); i++) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - findAngel: Buscando " + i);
            // Angel en la BD
            jsonAngelDB = jsonArrayDB.getJSONObject(i);
            if (jsonAngelDB.getString("idAngel").equals(jsonAngel.getString("idAngel"))) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - findAngel: Angel encontrado...");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - findAngel: Fin findAngel...");
            return jsonAngelDB;
        } else {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - findAngel: Angel no encontrado...");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - findAngel: Fin findAngel...");
            return new JSONObject();
        }
    }

    /**
     * Prepara la lista de angeles no seleccionados para ser borrados en base de datos. Puede lanzar excepciones del tipo JSONException.
     * 
     * @param angels
     * @throws JSONException
     */
    public void setToDelOlderAngels(JSONArray angels) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setToDelOlderAngels: Inicio setToDelOlderAngels...");
        Long uidLong = (new Double(this.getUid())).longValue();
        String respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uidLong + "\"");
        JSONObject jsonRespuesta = new JSONObject(respuesta);
        JSONObject jsonAngel = null;
        JSONObject jsonAngelDB = null;
        JSONArray jsonArrayDB = snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels"));
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setToDelOlderAngels: Angeles actuales a borrar: " + jsonArrayDB.toString());
        boolean isNotSelected = true;

        for (int i = 0; i < jsonArrayDB.length(); i++) {
            isNotSelected = true;
            // Angel nuevo
            jsonAngelDB = jsonArrayDB.getJSONObject(i);
            for (int j = 0; j < angels.length(); j++) {
                // Angel en la BD
                jsonAngel = angels.getJSONObject(j);
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setToDelOlderAngels: Buscando para borrar " + jsonAngel.toString());
                if (jsonAngel.getString("idAngel").equals(jsonAngelDB.getString("idAngel"))) {
                    isNotSelected = false;
                    break;
                }
            }
            if (isNotSelected) {

                jsonAngelDB.put("acceptAngel", "0");
                jsonAngelDB.put("confirmAngel", "1");
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setToDelOlderAngels: Angel no seleccionado: " + jsonAngelDB.toString());
                try {
                    this.snsObject.getClient().settingsAngels_setAngelByUid(String.class, jsonAngelDB.getString("uidAngel"), jsonAngelDB);
                } catch (Exception e) {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setToDelOlderAngels: Angel actualizado...");
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setToDelOlderAngels: Excepcion capturada Exception: " + e.getMessage());
                }
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setToDelOlderAngels: Fin setToDelOlderAngels...");
    }

    /**
     * Elimina los angeles eliminados desde la aplicacion. Puede lanzar excepciones del tipo NoSuchProviderException, MessagingException, UniformInterfaceException o IOException.
     *
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws UniformInterfaceException
     * @throws IOException
     */
    public void deleteOlderAngels() throws NoSuchProviderException, MessagingException, UniformInterfaceException, IOException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteOlderAngels: Inicio deleteOlderAngels...");
        try {
            Long uidLong = (new Double(this.getUid())).longValue();
            String respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uidLong + "\"");
            JSONObject jsonRespuesta = new JSONObject(respuesta);
            JSONObject jsonAngelDB = null;
            if (jsonRespuesta.getString("settingsAngels") != null) {
                JSONArray jsonArrayDB = snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels"));
                for (int i = 0; i < jsonArrayDB.length(); i++) {
                    jsonAngelDB = jsonArrayDB.getJSONObject(i);
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteOlderAngels: Angel a borrar. Inicio " + i + ": " + jsonAngelDB.toString());
                    if (jsonAngelDB.getString("acceptAngel").equals("0") && jsonAngelDB.getString("confirmAngel").equals("1")) {
                        // Borrar Angel TEST RESTFUL
                        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteOlderAngels: Angel a borrar: " + jsonAngelDB.toString());
                        try {
                            this.snsObject.getClient().settingsAngels_delAngelByUid(jsonAngelDB.getString("uidAngel"));
                            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteOlderAngels: Angel borrado: " + jsonAngelDB.getString("uidAngel"));
                            // Enviar correo de confirmaci??n angel borrado
                            snsObject.getEmailObject().sendMailDeleteAngel(jsonAngelDB, this.getUidPublic());
                        } catch (Exception e) {
                            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteOlderAngels: Excepcion con angel: " + jsonAngelDB.getString("uidAngel"));
                            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteOlderAngels: Excepcion capturada Exception: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (JSONException ex) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteOlderAngels: No existe ninguna relaci?n para borrar...");
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteOlderAngels: Excepcion capturada JSONException: " + ex.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - deleteOlderAngels: Fin deleteOlderAngels...");
    }

    /**
     * Almacena los angeles seleccionado para un determinado filtro. Puede lanzar excepciones del tipo JSONException.
     *
     * @param angelsFilter
     * @param des
     * @throws JSONException
     */
    public void putAngelsFilter(JSONArray angelsFilter, String des) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putAngelsFilter: Inicio putAngelsFilter...");
        String respuesta = "";
        JSONObject jsonRespuesta = null;
        JSONObject jsonAngel = null;
        JSONArray jsonArrayAngels = null;
        Long uidLong = (new Double(this.getUid())).longValue();
        respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uidLong + "\"");
        jsonRespuesta = new JSONObject(respuesta);
        jsonArrayAngels = this.snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels"));

        for (int j = 0; j < angelsFilter.length(); j++) {
            for (int i = 0; i < jsonArrayAngels.length(); i++) {
                jsonAngel = jsonArrayAngels.getJSONObject(i);
                if (angelsFilter.getJSONObject(j).getString("idAngel").equals(jsonAngel.getString("idAngel"))) {
                    setCollectionAngels(jsonAngel, 2, des);
                }
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putAngelsFilter: Fin putAngelsFilter...");
    }

    /**
     * Inicializa la base de datos para un nuevo filtro no seleccionado.
     * 
     * @param des
     */
    public void initDBnewFilter(String des){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - initDBnewFilter: Inicio initDBnewFilter para filtro " + des + "...");
        JSONObject newInstanceFilter = null;

        if (des.equals("fltWall")) {
            try {
                newInstanceFilter = this.getFltWall().getObjectFilter(des);
                this.snsObject.getClient().settingsFltWall_setNewUser(String.class, newInstanceFilter);
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - initDBnewFilter: Excepcion capturada JSONException: " + ex.getMessage());
            }
        } else if (des.equals("fltFriends")) {
            try {
                newInstanceFilter = this.getFltFriends().getObjectFilter(des);
                this.snsObject.getClient().settingsFltFriends_setNewUser(String.class, newInstanceFilter);
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - initDBnewFilter: Excepcion capturada JSONException: " + ex.getMessage());
            }
        } else if (des.equals("fltPriv")) {
            try {
                newInstanceFilter = this.getFltPriv().getObjectFilter(des);
                this.snsObject.getClient().settingsFltPriv_setNewUser(String.class, newInstanceFilter);
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - initDBnewFilter: Excepcion capturada JSONException: " + ex.getMessage());
            }
        } else if (des.equals("fltVist")) {
            try {
                newInstanceFilter = this.getFltVist().getObjectFilter(des);
                this.snsObject.getClient().settingsFltVist_setNewUser(String.class, newInstanceFilter);
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - initDBnewFilter: Excepcion capturada JSONException: " + ex.getMessage());
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - initDBnewFilter: Fin initDBnewFilter para filtro " + des + "...");
    }

    /**
     * Almacena en base de datos un nuevo filtro definido. Puede lanzar excepciones del tipo JSONException.
     * 
     * @param des
     * @param activeFilter
     * @return
     * @throws JSONException
     */
    public JSONObject putNewInstanceFilter(String des, String activeFilter) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceFilter: Inicio putNewInstanceFilter para filtro " + des + "...");
        JSONObject newInstanceFilter = null;
        JSONArray jsonAngFilter = null;
        Long uidLong = (new Double(this.getUid())).longValue();

        if (des.equals("fltWall")) {
            newInstanceFilter = this.getFltWall().getObjectFilter(des);
            try {
                this.snsObject.getClient().settingsFltWall_setFilterByUid(String.class, uidLong.toString(), newInstanceFilter);
            } catch (UniformInterfaceException e) {
                if (e.getResponse().getStatus() == 204) {
                    jsonAngFilter = this.getFltWall().getAngelsFilter(this.snsObject.getAngelsUtilities().getArrayAngelsSelected());
                    putAngelsFilter(jsonAngFilter, "fltWall");
                } else {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceFilter: Excepcion capturada UniformInterfaceException: " + e.getMessage());
                }
            }
        } else if (des.equals("fltFriends")) {
            newInstanceFilter = this.getFltFriends().getObjectFilter(des);
            try {
                this.snsObject.getClient().settingsFltFriends_setFilterByUid(String.class, uidLong.toString(), newInstanceFilter);
            } catch (UniformInterfaceException e) {
                if (e.getResponse().getStatus() == 204) {
                    jsonAngFilter = this.getFltFriends().getAngelsFilter(this.snsObject.getAngelsUtilities().getArrayAngelsSelected());
                    putAngelsFilter(jsonAngFilter, "fltFriends");
                }else {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceFilter: Excepcion capturada UniformInterfaceException: " + e.getMessage());
                }
            }
        } else if (des.equals("fltPriv")) {
            newInstanceFilter = this.getFltPriv().getObjectFilter(des);
            try {
                this.snsObject.getClient().settingsFltPriv_setFilterByUid(String.class, uidLong.toString(), newInstanceFilter);
            } catch (UniformInterfaceException e) {
                if (e.getResponse().getStatus() == 204) {
                    jsonAngFilter = this.getFltPriv().getAngelsFilter(this.snsObject.getAngelsUtilities().getArrayAngelsSelected());
                    putAngelsFilter(jsonAngFilter, "fltPriv");
                }else {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceFilter: Excepcion capturada UniformInterfaceException: " + e.getMessage());
                }
            }
        } else if (des.equals("fltVist")) {
            newInstanceFilter = this.getFltVist().getObjectFilter(des);
            try {
                this.snsObject.getClient().settingsFltVist_setFilterByUid(String.class, uidLong.toString(), newInstanceFilter);
            } catch (UniformInterfaceException e) {
                if (e.getResponse().getStatus() == 204) {
                    jsonAngFilter = this.getFltVist().getAngelsFilter(this.snsObject.getAngelsUtilities().getArrayAngelsSelected());
                    putAngelsFilter(jsonAngFilter, "fltVist");
                }
                else {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceFilter: Excepcion capturada UniformInterfaceException: " + e.getMessage());
                }
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceFilter: Fin putNewInstanceFilter para filtro " + des + "...");
        return newInstanceFilter;
    }

    /**
     * Formatea en un String los angeles seleccionados en la aplicacion. Puede lanzar excepciones del tipo JSONException.
     *
     * @param jsonAngels
     * @param desTypeAngel
     * @param des
     * @return
     * @throws JSONException
     */
    public String formatJsonLstAngel(JSONArray jsonAngels, String desTypeAngel, String des) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - formatJsonLstAngel: Inicio formatJsonLstAngel...");
        JSONObject jsonAngel = null;
        JSONObject aux = null;
        String angels = "";

        for (int i = 0; i < jsonAngels.length(); i++) {
            jsonAngel = jsonAngels.getJSONObject(i);

            if (jsonAngel.getString("typeAngel").equals(desTypeAngel)) {
                aux = new JSONObject();
                aux.put("nameAngel" + des, jsonAngel.getString("nameAngel"));
                aux.put("emailAngel" + des, jsonAngel.getString("idAngel"));
                if (i == 0) {
                    angels = aux.toString() + ";";
                } else {
                    angels += aux.toString() + ";";
                }
            }
        }

        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - formatJsonLstAngel: Angeles definidos anteriormente para el filtro " + des + ": " + angels);

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - formatJsonLstAngel: Fin formatJsonLstAngel...");
        return angels;
    }

    /**
     * Indica si hay algun angel definido para los diferentes tipos de angeles de
     * la aplicacion. Enviar? el valor true en caso afirmativo y false en caso contrario.
     *
     * @param jsonAngels
     * @param typeTable
     * @return
     */
    public boolean existAnyAngel(JSONObject jsonAngels, String typeTable){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - existAnyAngel: Inicio existAnyAngel...");
        boolean result = false;

        try{
            String strAngels = jsonAngels.getString(typeTable);

            if(strAngels != null){
                result = true;
            }
        }catch(Exception e){
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - existAnyAngel: No hay angeles definidos...");
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - existAnyAngel: Excepcion capturada Exception: " + e.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - existAnyAngel: Fin existAnyAngel...");
        return result;
    }

    /**
     * Obtiene todos los angeles definidos por un usuario para sus diferentes filtros. Puede lanzar excepciones del tipo JSONException.
     * 
     * @param desTypeAngel
     * @return
     * @throws JSONException
     */
    public String getAngelsUser(String desTypeAngel) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsUser: Inicio getAngelsUser...");
        Long uidLong = (new Double(this.getUid())).longValue();
        String strListAngels = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uidLong + "\"");
        String angels = "";

        if (!strListAngels.equals("") && !strListAngels.equals("{}") && existAnyAngel(new JSONObject(strListAngels),"settingsAngels")) {
            JSONObject jsonAngel = null;
            JSONObject jsonAngels = new JSONObject(strListAngels);
            JSONArray jsonArrayAngels = this.snsObject.getJsonUtilities().getJSONArray(jsonAngels.getString("settingsAngels"));

            if (desTypeAngel.equals("G")) {
                angels = formatJsonLstAngel(jsonArrayAngels, desTypeAngel, "GoogleSelected");
            } else if (desTypeAngel.equals("O")) {
                angels = formatJsonLstAngel(jsonArrayAngels, desTypeAngel, "Ed");
            } else {
                for (int i = 0; i < jsonArrayAngels.length(); i++) {
                    jsonAngel = jsonArrayAngels.getJSONObject(i);

                    if (jsonAngel.getString("typeAngel").equals(desTypeAngel)) {
                        if (i == 0) {
                            angels = jsonAngel.getString("idAngel") + ";";
                        } else {
                            angels += jsonAngel.getString("idAngel") + ";";
                        }
                    }
                }
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsUser: Angeles definidos de Facebook: " + angels);
            }
        }
        
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsUser: Fin getAngelsUser...");
        return angels;
    }

    /**
     * Obtiene de un String de base de datos un JSONArray de objetos JSON. Puede lanzar excepciones del tipo JSONException.
     * 
     * @param strValue
     * @return
     * @throws JSONException
     */
    public JSONArray getJSONArray(String strValue) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJSONArray: Inicio getJSONArray...");
        JSONArray jsonArray = null;

        if ((!strValue.equals("{}")) && (!strValue.contains("error_code"))) {
            if (!strValue.substring(0, 1).equals("[") && !strValue.substring(strValue.length() - 1, strValue.length()).equals("]")) {
                String auxValue = "[" + strValue + "]";
                strValue = auxValue;
            }

            jsonArray = new JSONArray(strValue);
        } else {
            jsonArray = new JSONArray();
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJSONArray: Fin getJSONArray...");
        return jsonArray;
    }

    /**
     * Obtiene los angeles para un filtro determinado.
     *
     * @param des Identificador del filtro.
     * @return String separado por ; con los angeles definidos para el filtro.
     */
    public String getAngelsFilter(String des) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsFilter: Inicio getAngelsFilter...");
        String angels = "";

        if (des.equals("fltWall")) {
            angels = this.getFltWall().getAngels();
        } else if (des.equals("fltFriends")) {
            angels = this.getFltFriends().getAngels();
        } else if (des.equals("fltPriv")) {
            angels = this.getFltPriv().getAngels();
        } else if (des.equals("fltVist")) {
            angels = this.getFltVist().getAngels();
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsFilter: Fin getAngelsFilter...");
        return angels;
    }

    /**
     * Carga toda la funcionalidad de la aplicacion para los filtros definidos.
     * 
     */
    private void loadFullFuntionalityFilter(){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFullFuntionalityFilter: Inicio loadFullFuntionalityFilter...");
        loadFilter("fltWall");
        loadFilter("fltFriends");
        loadFilter("fltVist");
        loadFilter("fltPriv");
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFullFuntionalityFilter: Fin loadFullFuntionalityFilter...");
    }

    /**
     * Carga desde base de datos todas las caracteristicas de un determinado filtro.
     *
     * @param des Identificador de filtro.
     * @throws JSONException
     */
    public void loadFilter(String des) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Inicio loadFilter para " + des);
        JSONObject jsonFilter = null;
        JSONObject jsonAngels = null;
        JSONArray jsonArrayAngels = null;
        Long uidLong = (new Double(this.getUid())).longValue();

        if (des.equals("fltWall")) {
            try {
                jsonFilter = new JSONObject(this.snsObject.getClient().settingsFltWall_getUserByUid(String.class, uidLong.toString()));
                jsonAngels = new JSONObject(this.snsObject.getClient().settingsFltWall_getAngelsCollectionByUid(String.class, uidLong.toString()));
                try {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Angeles para el filtro " + des + " cargados");
                    try {
                        jsonArrayAngels = this.getJSONArray(jsonAngels.getString("settingsAngels"));
                    } catch (Exception e) {
                        logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada JSONException: " + e.getMessage());
                    }
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Array de angeles: " + jsonArrayAngels.toString());
                } catch (Exception e) {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: No existen angeles definidos para el filtro " + des);
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada Exception: " + e.getMessage());
                }
                try {
                    this.getFltWall().loadSettingsFilter(jsonFilter, jsonArrayAngels, des);
                } catch (ParseException ex) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada ParseException: " + ex.getMessage());
                } catch (java.text.ParseException ex) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada java.text.ParseException: " + ex.getMessage());
                }
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada JSONException: " + ex.getMessage());
            }
        } else if (des.equals("fltFriends")) {
            try {
                jsonFilter = new JSONObject(this.snsObject.getClient().settingsFltFriends_getUserByUid(String.class, uidLong.toString()));
                jsonAngels = new JSONObject(this.snsObject.getClient().settingsFltFriends_getAngelsCollectionByUid(String.class, uidLong.toString()));
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Angeles para el filtro " + des + " cargados");
                try {
                    jsonArrayAngels = this.getJSONArray(jsonAngels.getString("settingsAngels"));
                } catch (Exception e) {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: No existen angeles definidos para el filtro " + des);
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada Exception: " + e.getMessage());
                }
                try {
                    this.getFltFriends().loadSettingsFilter(jsonFilter, jsonArrayAngels, des);
                } catch (ParseException ex) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada ParseException: " + ex.getMessage());
                } catch (java.text.ParseException ex) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada java.text.ParseException: " + ex.getMessage());
                }
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada JSONException: " + ex.getMessage());
            }
        } else if (des.equals("fltPriv")) {
            try {
                jsonFilter = new JSONObject(this.snsObject.getClient().settingsFltPriv_getUserByUid(String.class, uidLong.toString()));
                jsonAngels = new JSONObject(this.snsObject.getClient().settingsFltPriv_getAngelsCollectionByUid(String.class, uidLong.toString()));
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Angeles para el filtro " + des + " cargados");
                try {
                    jsonArrayAngels = this.getJSONArray(jsonAngels.getString("settingsAngels"));
                } catch (Exception e) {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: No existen angeles definidos para el filtro " + des);
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada Exception: " + e.getMessage());
                }
                try {
                    this.getFltPriv().loadSettingsFilter(jsonFilter, jsonArrayAngels, des);
                } catch (ParseException ex) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada ParseException: " + ex.getMessage());
                } catch (java.text.ParseException ex) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada java.text.ParseException: " + ex.getMessage());
                }
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada JSONException: " + ex.getMessage());
            }
        } else if (des.equals("fltVist")) {
            try {
                jsonFilter = new JSONObject(this.snsObject.getClient().settingsFltVist_getUserByUid(String.class, uidLong.toString()));
                jsonAngels = new JSONObject(this.snsObject.getClient().settingsFltVist_getAngelsCollectionByUid(String.class, uidLong.toString()));
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Angeles para el filtro " + des + " cargados");
                try {
                    jsonArrayAngels = this.getJSONArray(jsonAngels.getString("settingsAngels"));
                } catch (Exception e) {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: No existen angeles definidos para el filtro " + des);
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada Exception: " + e.getMessage());
                }
                try {
                    this.getFltVist().loadSettingsFilter(jsonFilter, jsonArrayAngels, des);
                } catch (ParseException ex) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada ParseException: " + ex.getMessage());
                } catch (java.text.ParseException ex) {
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada java.text.ParseException: " + ex.getMessage());
                }
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Excepcion capturada JSONException: " + ex.getMessage());
            }
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadFilter: Fin loadFilter para " + des);
    }

    /**
     * Actualiza un filtro con la nueva informacion y lo retorna al sistema. Puede lanzar excepciones del tipo JSONException.
     *
     * @param desFilter Identificador de filtro.
     * @return
     * @throws JSONException
     */
    public JSONObject updateFilter(String desFilter) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Inicio updateFilter para " + desFilter);
        JSONObject jsonFilter = null;
        Long uidLong = (new Double(this.getUid())).longValue();

        if (desFilter.equals("fltWall")) {
            jsonFilter = this.getFltWall().getObjectFilter(desFilter);
            try {
                this.snsObject.getClient().settingsFltWall_setFilterByUid(String.class, uidLong.toString(), jsonFilter);
            } catch (Exception e) {
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Filtro " + desFilter + " actualizado");
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Excepcion capturada Exception: " + e.getMessage());
            }
            jsonFilter = new JSONObject(this.snsObject.getClient().settingsFltWall_getUserByUid(String.class, uidLong.toString()));

        } else if (desFilter.equals("fltFriends")) {
            jsonFilter = this.getFltFriends().getObjectFilter(desFilter);
            try {
                this.snsObject.getClient().settingsFltFriends_setFilterByUid(String.class, uidLong.toString(), jsonFilter);
            } catch (Exception e) {
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Filtro " + desFilter + " actualizado");
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Excepcion capturada Exception: " + e.getMessage());
            }
            jsonFilter = new JSONObject(this.snsObject.getClient().settingsFltFriends_getUserByUid(String.class, uidLong.toString()));
        } else if (desFilter.equals("fltPriv")) {
            jsonFilter = this.getFltPriv().getObjectFilter(desFilter);
            try {
                this.snsObject.getClient().settingsFltPriv_setFilterByUid(String.class, uidLong.toString(), jsonFilter);
            } catch (Exception e) {
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Filtro " + desFilter + " actualizado");
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Excepcion capturada Exception: " + e.getMessage());
            }
            jsonFilter = new JSONObject(this.snsObject.getClient().settingsFltPriv_getUserByUid(String.class, uidLong.toString()));
        } else if (desFilter.equals("fltVist")) {
            jsonFilter = this.getFltVist().getObjectFilter(desFilter);
            try {
               this.snsObject.getClient().settingsFltVist_setFilterByUid(String.class, uidLong.toString(), jsonFilter);
            } catch (Exception e) {
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Filtro " + desFilter + " actualizado");
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Excepcion capturada Exception: " + e.getMessage());
            }
            jsonFilter = new JSONObject(this.snsObject.getClient().settingsFltVist_getUserByUid(String.class, uidLong.toString()));
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFilter: Fin updateFilter para " + desFilter);
        return jsonFilter;
    }

    /**
     * Actualiza la fecha de utimo chequeo para un filtro determinado.
     *
     * @param desFilter Identificador de filtro.
     * @param uid Identificador de usuario al que pertenece el filtro.
     */
    public void setLastCheckFilter(String desFilter, String uid) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setLastCheckFilter: Inicio setLastCheckFilter para " + desFilter);
        Long uidLong = (new Double(uid)).longValue();

        if (desFilter.equals("fltWall")) {
            this.snsObject.getClient().settingsFltWall_setLastCheckByUid(String.class, uidLong.toString());
        } else if (desFilter.equals("fltFriends")) {
            this.snsObject.getClient().settingsFltFriends_setLastCheckByUid(String.class, uidLong.toString());
        } else if (desFilter.equals("fltPriv")) {
            this.snsObject.getClient().settingsFltPriv_setLastCheckByUid(String.class, uidLong.toString());
        } else if (desFilter.equals("fltVist")) {
            this.snsObject.getClient().settingsFltVist_setLastCheckByUid(String.class, uidLong.toString());
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setLastCheckFilter: Fin setLastCheckFilter para " + desFilter);
    }

    /**
     * Gets user ID of the current user logged in.
     * @param request
     * @param response
     */
    public void updateUserID(HttpServletRequest request, HttpServletResponse response) throws UniformInterfaceException, IOException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateUserID: Inicio updateUserID...");
        HttpSession session = request.getSession(false);
        String format = "";

        try {
            for (int j = 0; j < 10; j++) {
                format = SNSAngelGuardFBManager.getFacebookClient().users_getLoggedInUser(String.class, request, "format=json");

                if (!format.contains("error_code") && !format.contains("{}")) {
                    break;
                } else if (j == 9) {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateUserID: El formato del atributo UID no es permitido...");
                }
            }
            try {
                if (Double.parseDouble(format) > 0) {
                    this.uid = format;
                    SNSAngelGuardFBManager.getLogger().info(this.uid + ": UID ACCEPTED: " + format);
                }
            } catch (Exception e) {
                logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateUserID: Formato no aceptado...");
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateUserID: Excepcion capturada Exception: " + e.getMessage());
                this.uid = null;
            }

        } catch (Exception ex) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateUserID: Error creando UID");
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateUserID: Excepcion capturada Exception: " + ex.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateUserID: Fin updateUserID...");
    }

    /**
     * Actualiza la fecha en la que un usuario se conecta a la aplicacion y realiza
     * un guardado de informacion. Puede lanzar excepciones del tipo UniformInterfaceException, IOException o JSONException.
     *
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws JSONException
     */
    public void updateLastCheckUS() throws UniformInterfaceException, IOException, JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateLastCheckUS: Inicio updateLastCheckUS...");
        try {
            Long uidLong = (new Double(this.getUid())).longValue();
            this.snsObject.getClient().userSettings_setUpdateTime(String.class, uidLong.toString(), "1", this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUserSession());
        } catch (UniformInterfaceException e) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateLastCheckUS: Fecha LastCheck actualizada...");
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateLastCheckUS: Excepcion capturada UniformInterfaceException: " + e.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateLastCheckUS: Fin updateLastCheckUS...");
    }

    /**
     * Actualiza la fecha en la que se realiza el ultimo backup de informacion del usuario.
     */
    public void updateBackUpCheckUS() {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateBackUpCheckUS: Inicio updateBackUpCheckUS...");
        try {
            Long uidLong = (new Double(this.getUid())).longValue();
            this.snsObject.getClient().userSettings_setUpdateTime(String.class, uidLong.toString(), "0", this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUserSession());
        } catch (UniformInterfaceException e) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateLastCheckUS: Fecha BackUpCheck actualizada...");
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateLastCheckUS: Excepcion capturada UniformInterfaceException: " + e.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateBackUpCheckUS: Fin updateBackUpCheckUS...");
    }

    /**
     * Obtiene toda la informacion de la base de datos de todos los usuarios de la aplicacion y la retorna en un objeto JSONArray.
     * Su utilidad basica radica en los procesos offline de informacion. Puede lanzar excepciones del tipo JSONException.
     *
     * @param snsObjectManager
     * @return
     * @throws JSONException
     */
    public JSONArray getEntitiesUserSettings(SNSAngelGuardFBManager snsObjectManager) throws JSONException {
        logger.info("Proceso OffLine - getEntitiesUserSettings: Inicio getEntitiesUserSettings...");
        JSONObject jsonUsers = null;
        JSONArray arrayUsers = null;
        String usersClient = snsObjectManager.getClient().userSettings_getEntities(String.class);
        logger.debug("Proceso OffLine - getEntitiesUserSettings: Entidades de la aplicaci?n: " + usersClient);

        if (!usersClient.equals("{}") && (!usersClient.contains("error_code"))) {
            logger.debug("Proceso OffLine - getEntitiesUserSettings: Existen usuarios en la aplicaci?n...");
            try {
                jsonUsers = new JSONObject(usersClient);
                arrayUsers = snsObjectManager.getJsonUtilities().getJSONArray(jsonUsers.getString("userSettings"));
            } catch (Exception e) {
                logger.debug("Proceso OffLine - getEntitiesUserSettings: No existen usuarios en la aplicaci?n...");
                logger.error("Proceso OffLine - getEntitiesUserSettings: Excepcion capturada Exception: " + e.getMessage());
            }
        }

        logger.info("Proceso OffLine - getEntitiesUserSettings: Fin getEntitiesUserSettings...");
        return arrayUsers;
    }

    /**
     * Obtiene una entidad de la tabla UserSettings a partir de su uidPublica y lo retorna como un JSONObject. Puede lanzar excepciones del tipo
     * InterDataBaseException, InterProcessException o InterEmailException.
     * 
     * @param snsObjectOff
     * @param uidPublic
     * @return
     * @throws JSONException
     * @throws UnsupportedEncodingException
     */
    public JSONObject getJsonUserByUidPublic(SNSAngelGuardFBManager snsObjectOff, String uidPublic) throws InterDataBaseException, InterProcessException, InterEmailException{
        JSONObject jsonGeneral = null;
        JSONObject jsonUser = null;
        try {
            logger.info("Proceso OffLine - getJsonUserByUidPublic: Inicio getJsonUserByUidPublic...");
            String respuesta = snsObjectOff.getClient().userSettings_getUserByUidPublic(String.class, "\"" + uidPublic + "\"");
            jsonGeneral = new JSONObject(respuesta);

            logger.info("Proceso OffLine - getJsonUserByUidPublic: Fin getJsonUserByUidPublic...");
            jsonUser = JSONUtilities.getJSONObject(jsonGeneral.getString("userSettings"));
        } catch (JSONException e) {
            logger.error("Proceso OffLine - getJsonUserByUidPublic: Excepcion capturada JSONException: " + e.getMessage());
            this.snsObject.getExceptionManager().initControlException(e);
        } catch (UniformInterfaceException ex) {
            logger.error("Proceso OffLine - getJsonUserByUidPublic: Excepcion capturada UniformInterfaceException: " + ex.getMessage());
            this.snsObject.getExceptionManager().initControlException(ex);
        } catch (UnsupportedEncodingException ex) {
            logger.error("Proceso OffLine - getJsonUserByUidPublic: Excepcion capturada UnsupportedEncodingException: " + ex.getMessage());
            this.snsObject.getExceptionManager().initControlException(ex);
        }

        return jsonUser;
    }
}
