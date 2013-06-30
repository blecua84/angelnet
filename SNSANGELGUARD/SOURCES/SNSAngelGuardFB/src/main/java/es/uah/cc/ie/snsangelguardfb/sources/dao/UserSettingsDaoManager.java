/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.dao;

import bsh.ParseException;
import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;
import com.restfb.Parameter;
import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;
import es.uah.cc.ie.snsangelguardfb.facebookclient.data.InfoUser;
import es.uah.cc.ie.snsangelguardfb.facebookclient.data.InfoCurrentUser;
import es.uah.cc.ie.snsangelguardfb.facebookclient.data.InfoUserFacebook;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import es.uah.cc.ie.snsangelguardfb.sources.dao.entity.UserSettingsDAO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchProviderException;
import java.util.Date;
import java.util.List;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Clase Manager que controla toda la gestion de base de datos referente a las
 * operaciones de un usuario en la aplicacion.
 *
 * @author tote
 */
public class UserSettingsDaoManager {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(UserSettingsDaoManager.class);
    
    /** Manager principal de la aplicacion */
    private SNSAngelGuardFBManager snsObject;

    /** Objeto DAO que almacena los datos de un usuario de la aplicacion */
    private UserSettingsDAO userSettingsDAO;

    /**
     * Constructor de clase. Inicializa los datos del Manager de la aplicacion y
     * de los datos de usuario.
     *
     * @param snsObject
     */
    public UserSettingsDaoManager(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
        this.userSettingsDAO = new UserSettingsDAO();
    }

    /**
     * Obtiene el Manager principal de la aplicacion.
     *
     * @return SNSAngelGuardFBManager
     */
    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    /**
     * Establece el Manager principal de la aplicacion en la instancia de la
     * clase.
     *
     * @param snsObject SNSAngelGuardFBManager
     */
    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Obtiene la instancia de la clase que almacena los datos del usuario de
     * la aplicacion.
     *
     * @return UserSettingsDAO
     */
    public UserSettingsDAO getUserSettingsDAO() {
        return userSettingsDAO;
    }

    /**
     * Establece la instancia de la clase que almacena los datos del usuario de
     * la aplicacion.
     *
     * @param userSettingsDAO UserSettingsDAO
     */
    public void setUserSettingsDAO(UserSettingsDAO userSettingsDAO) {
        this.userSettingsDAO = userSettingsDAO;
    }

    /**
     * Carga los datos de un usuario en el atributo userSettingsDAO a partir de
     * un objeto json. Podr? lanzar excepciones del tipo JSONException, ParseException o
     * bsh.ParseException.
     *
     * @param user JSONObject con los datos del usuario.
     * @throws JSONException
     * @throws ParseException
     * @throws bsh.ParseException
     */
    public void loadUser(JSONObject user) throws JSONException, ParseException, bsh.ParseException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUser: Inicio loadUser...");
        this.snsObject.getUserSettingsDaoManager().setUserSettingsDAO(this.userSettingsDAO = new UserSettingsDAO(this, user.getString("uid"), user.getString("userName"),
                user.getString("userEmail"), user.getString("legalAccepted").equals("1"), this.snsObject.getDateTimeUtilities().formatTime(user.getString("lastCheck").replace("T", " ")),
                user.getString("uidPublic"), user.getString("appActivated").equals("1"),
                user.getString("userSession"), this.snsObject.getDateTimeUtilities().formatTime(user.getString("backupCheck").replace("T", " ")), this.snsObject));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUser: Fin loadUser...");
    }

    /**
     * Carga los datos de un usuario de la aplicacion, tanto los datos
     * registrados como sus preferencias a la hora de la ejecucion. Si no est? registrado,
     * llamar? al metodo setNewUserConnected() para almacenar sus datos en la base de datos. Podr? lanzar excepciones
     * del tipo ParseException, JSONException o bsh.ParseException.
     *
     * @throws ParseException
     * @throws JSONException
     * @throws bsh.ParseException
     */
    public void loadSettings() throws ParseException, JSONException, bsh.ParseException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadSettings: Inicio loadSettings...");
        if (this.userSettingsDAO.getUid() == null) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadSettings: Error en UID de usuario: UID Nulo");
            return;
        }

        JSONObject jsonObject = new JSONObject();

        try {
            Long uidLong = (new Double(this.userSettingsDAO.getUid())).longValue();
            jsonObject = this.snsObject.getClient().userSettings_getUserSettingsByUid(JSONObject.class, uidLong.toString());
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadSettings: Datos del usuario: " + jsonObject.toString());
            this.snsObject.setNewConnection(false);
        } catch (Exception e) {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadSettings: Este usuario no existe en la base de datos. Usuario nuevo");
            this.snsObject.setNewConnection(true);
        }

        if (this.snsObject.isNewConnection()) {
            setNewUserConnected();
            this.userSettingsDAO.setLegalAccepted(false);
        } else {
            try {
                loadUserConnected(jsonObject);
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadSettings: Error al cargar los datos de usuario. Excepcion: " + ex.getMessage());
            }
        }

        // Cargamos el idioma del usuario
        this.snsObject.getLocaleSettingsDaoManager().loadLocaleSettings();

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadSettings: Fin loadSettings...");
    }

    /**
     * Carga el usuario conectado con su informaci?n almacenada en el objeto JSONObject en el atributo userSettingsDAO. Llamar? al m?todo loadUser 
     * e inicializar? el atributo del objeto de la clase SNSAngelGuardFBManager newConnection al valor false. Mostrar? en el log toda la informaci?n 
     * del usuario conectado. Podr? lanzar excepciones del tipo JSONException, ParseException, bsh.ParseException.
     *
     * @param settings JSONObject con los datos del usuario.
     * @throws JSONException
     * @throws ParseException
     * @throws bsh.ParseException
     */
    public void loadUserConnected(JSONObject settings) throws JSONException, ParseException, bsh.ParseException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Inicio loadUserConnected...");
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Datos de Usuario obtenidos de la base de datos: " + settings);
        loadUser(settings);

        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: UID Usuario: " + this.userSettingsDAO.getUid());
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Email Usuario: " + this.userSettingsDAO.getUserEmail());
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Nombre Usuario: " + this.userSettingsDAO.getUserName());
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Acuerdo Legal Aceptado: " + this.userSettingsDAO.isLegalAccepted());
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Aplicacion Activada: " + this.userSettingsDAO.isAppActivated());
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Ultimo acceso a la aplicacion: " + new Date(this.userSettingsDAO.getLastCheck().getTime()));
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Recursos de idioma del usuario obtenidos");
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Sesion de Facebook del usuario: " + this.userSettingsDAO.getUserSession());

        this.snsObject.setNewConnection(false);
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - loadUserConnected: Fin loadUserConnected...");

    }

    /**
     * Obtiene la informaci?n del nuevo usuario de la aplicacion conectado a Facebook y la carga en el objeto userSettingsDAO. Podr? lanzar excepciones del tipo ParseException.
     * 
     * @throws ParseException
     */
    public void setNewUserConnected() throws ParseException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNewUserConnected: Inicio setNewUserConnected...");
        try {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNewUserConnected: Obteniendo informacion del usuario en Facebook...");
            Long uidLong = (new Double(this.userSettingsDAO.getUid())).longValue();
            List<InfoCurrentUser> jsonUserInfo = this.snsObject.getFacebookRestClient().executeForList("Users.getInfo", InfoCurrentUser.class, Parameter.with("uids", uidLong), Parameter.with("fields", "name,email"));
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNewUserConnected: Informacion del usuario en Facebook obtenida!!");

            InfoCurrentUser info = jsonUserInfo.get(0);
            String uid = info.getUid();
            String name = info.getName();
            String email = info.getEmail();

            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNewUserConnected: Informacion de perfil de Facebook del usuario:");
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNewUserConnected: Nombre:  " + name);
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNewUserConnected: Email: " + email);

            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNewUserConnected: Creando nuevo objeto UserSettingsDAO...");
            this.userSettingsDAO = new UserSettingsDAO(uid, name, email, this.snsObject);
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNewUserConnected: Nuevo objeto UserSettingsDAO creado!!");

        } catch (UniformInterfaceException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid()+ " - setNewUserConnected: Excepcion capturada UniformInterfaceException: " + ex.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setNewUserConnected: Fin setNewUserConnected...");
    }

    /**
     * Almacena una nueva instancia del usuario en la base de datos accediendo al m?todo getNewInstance del atributo userSettingsDAO. Podr? lanzar excepciones del tipo JSONException, 
     * ParseException, UniformInterfaceException, IOException, DataLengthException, IllegalStateException, InvalidCipherTextException, UnsupportedEncodingException, NoSuchProviderException
     * o MessagingException.
     * 
     * @param request
     * @param response
     * @throws JSONException
     * @throws ParseException
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws DataLengthException
     * @throws IllegalStateException
     * @throws InvalidCipherTextException
     * @throws UnsupportedEncodingException
     * @throws NoSuchProviderException
     * @throws MessagingException
     */
    public void putNewInstanceUS(HttpServletRequest request, HttpServletResponse response) throws JSONException, ParseException, UniformInterfaceException, IOException, DataLengthException, IllegalStateException, InvalidCipherTextException, UnsupportedEncodingException, NoSuchProviderException, MessagingException, javax.mail.NoSuchProviderException, InterDataBaseException, InterProcessException, InterEmailException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceUS: Inicio putNewInstanceUS...");
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceUS: Almacenando usuario en la base de datos...");
        this.userSettingsDAO.getNewInstanceUS(request, response);
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceUS: Usuario almacenado en la base de datos correctamente!!");
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - putNewInstanceUS: Fin putNewInstanceUS...");
    }

    /**
     * Obtiene los datos de un usuario de la aplicacion de la base de datos mediante el metodo userSettings\_getUserSettingsByUID del cliente de la base de datos
     * y los carga en el atributo userSettingsDAO mediante el m?todo loadUser. Podr? lanzar excepciones del tipo JSONException, ParseException o bsh.ParseException.
     * 
     * @throws JSONException
     * @throws ParseException
     * @throws bsh.ParseException
     */
    public void getUserInfoSimple() throws JSONException, ParseException, bsh.ParseException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfoSimple: Inicio getUserInfoSimple...");
        JSONObject jsonUserInfo = null;

        try {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfoSimple: Obteniendo los datos del usuario en la base de datos...");
            jsonUserInfo = this.snsObject.getClient().userSettings_getUserSettingsByUid(JSONObject.class, this.userSettingsDAO.getUid());
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfoSimple: Datos del usuario obtenidos correctamente!!");
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfoSimple: Datos del usuario: " + jsonUserInfo);
        } catch (Exception e) {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfoSimple: El usuario introducido no existe en la base de datos...");
        }
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfoSimple: Cargando el usuario en la aplicacion...");
        loadUser(jsonUserInfo);
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfoSimple: Usuario cargado correctamente en la aplicacion!!");
        this.snsObject.setNewConnection(false);
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfoSimple: Fin getUserInfoSimple...");
    }

    /**
     * Recibe un objeto JSONObject con la informaci?n del usuario y actualiza la fecha y la hora de la ultima vez que el usuario se conecto a
     * la aplicacion en el campo lastCheck de la tabla user\_settings cuando se realiza una confirmaci?n de un ?ngel. Llamar? al m?todo updateLastCheckUS del atributo userSettingsDAO. Puede lanzar excepciones del tipo
     * ParseException, JSONException, MySQLIntegrityConstraintViolationException, NoSuchProviderException, FileNotFoundException, MessagingException o bsh.ParseException.
     *
     * @param jsonUser Datos del usuario.
     * @throws ParseException
     * @throws JSONException
     * @throws MySQLIntegrityConstraintViolationException
     * @throws NoSuchProviderException
     * @throws FileNotFoundException
     * @throws MessagingException
     * @throws bsh.ParseException
     */
    public void checkAngelConfirmation(JSONObject jsonUser) throws ParseException, JSONException, MySQLIntegrityConstraintViolationException, NoSuchProviderException, FileNotFoundException, MessagingException, bsh.ParseException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkAngelConfirmation: Inicio checkAngelConfirmation...");
        this.loadUserConnected(jsonUser);

        if (this.userSettingsDAO.isAppActivated()) {
            try {
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkAngelConfirmation: Actualizando fecha de ultima conexi?n...");
                this.userSettingsDAO.updateLastCheckUS();
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkAngelConfirmation: Fecha de ultima conexi?n actualizada!!");
            } catch (UniformInterfaceException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid()+ " - checkAngelConfirmation: Excepci?n capturada UniformInterfaceException: " + ex.getMessage());
            } catch (IOException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid()+ " - checkAngelConfirmation: Excepci?n capturada IOException: " + ex.getMessage());
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkAngelConfirmation: Fin checkAngelConfirmation...");
    }

    /**
     * Actualiza la informacion de Facebook de un usuario ya existente en la aplicacion en
     * la base de datos. Recibir? en un objeto JSONObject la nueva informaci?n del usuario y su identificador dentro de la base de datos. Devolver? un objeto 
     * JSONObject con la informaci?n ya persistida en la base de datos.
     * 
     * @param newFacebookUserInfo Informacion nueva del usuario en Facebook.
     * @param uidFacebookUser UID del usuario.
     * @return JSONObject con la informacion de Facebook del usuario.
     */
    public JSONObject updateFacebookUserInfo(JSONObject newFacebookUserInfo, String uidFacebookUser){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFacebookUserInfo: Inicio updateFacebookUserInfo...");
        JSONObject serverFacebookUserInfo = newFacebookUserInfo;

        String facebookUserInfo = this.snsObject.getClient().userFacebook_getUserFacebookByUid(String.class, uidFacebookUser);
        try {
            serverFacebookUserInfo = new JSONObject(facebookUserInfo);
            serverFacebookUserInfo.put("firstName", newFacebookUserInfo.getString("firstName"));
            serverFacebookUserInfo.put("middleName", newFacebookUserInfo.getString("middleName"));
            serverFacebookUserInfo.put("lastName", newFacebookUserInfo.getString("lastName"));
            serverFacebookUserInfo.put("name", newFacebookUserInfo.getString("name"));
            serverFacebookUserInfo.put("picSmall", newFacebookUserInfo.getString("picSmall"));
            serverFacebookUserInfo.put("picBig", newFacebookUserInfo.getString("picBig"));
            serverFacebookUserInfo.put("picSquare", newFacebookUserInfo.getString("picSquare"));
            serverFacebookUserInfo.put("pic", newFacebookUserInfo.getString("pic"));
            serverFacebookUserInfo.put("profileUpdateTime", newFacebookUserInfo.getString("profileUpdateTime"));
            serverFacebookUserInfo.put("birthday", newFacebookUserInfo.getString("birthday"));
            serverFacebookUserInfo.put("birthdayDate", newFacebookUserInfo.getString("birthdayDate"));
            serverFacebookUserInfo.put("significantOtherId", newFacebookUserInfo.getString("significantOtherId"));
            serverFacebookUserInfo.put("gradYear", newFacebookUserInfo.getString("gradYear"));
            serverFacebookUserInfo.put("wallCount", newFacebookUserInfo.getString("wallCount"));
            serverFacebookUserInfo.put("locale", newFacebookUserInfo.getString("locale"));
            serverFacebookUserInfo.put("proxiedEmail", newFacebookUserInfo.getString("proxiedEmail"));
            serverFacebookUserInfo.put("profileUrl", newFacebookUserInfo.getString("profileUrl"));
            serverFacebookUserInfo.put("emailHashes", newFacebookUserInfo.getString("emailHashes"));
            serverFacebookUserInfo.put("picSmallWithLogo", newFacebookUserInfo.getString("picSmallWithLogo"));
            serverFacebookUserInfo.put("picBigWithLogo", newFacebookUserInfo.getString("picBigWithLogo"));
            serverFacebookUserInfo.put("picSquareWithLogo", newFacebookUserInfo.getString("picSquareWithLogo"));
            serverFacebookUserInfo.put("picWithLogo", newFacebookUserInfo.getString("picWithLogo"));
            serverFacebookUserInfo.put("allowedRestrictions", newFacebookUserInfo.getString("allowedRestrictions"));
            serverFacebookUserInfo.put("verified", newFacebookUserInfo.getString("verified"));
            serverFacebookUserInfo.put("profileBlurb", newFacebookUserInfo.getString("profileBlurb"));
            serverFacebookUserInfo.put("username", newFacebookUserInfo.getString("username"));
            serverFacebookUserInfo.put("website", newFacebookUserInfo.getString("website"));
            serverFacebookUserInfo.put("isBlocked", newFacebookUserInfo.getString("isBlocked"));
            serverFacebookUserInfo.put("contactEmail", newFacebookUserInfo.getString("contactEmail"));
            serverFacebookUserInfo.put("email", newFacebookUserInfo.getString("email"));
            serverFacebookUserInfo.put("meetingSexFacebook", newFacebookUserInfo.getString("meetingSexFacebook"));
            
        } catch (JSONException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid()+ " - updateFacebookUserInfo: Excepcion capturada JSONException: " + ex.getMessage());
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateFacebookUserInfo: Fin updateFacebookUserInfo...");
        return serverFacebookUserInfo;
    }

    /**
     * Almacena en base de datos informacion conjunta del perfil de Facebook
     * y el perfil de Open Social del usuario de la aplicacion, junto con su
     * informacion comun, que sera almacenada en la tabla User. Recibe por par?metro un objeto boolean que indica si es la primera vez que accede a la aplicacion.
     * Podr? lanzar excepciones del tipo UniformInterfaceException, IOException, JSONException o MySQLIntegrityContraintViolationException.
     *
     * @param firstCheck Indica si es la primera vez que se recoge informacion
     * del usuario.
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws JSONException
     * @throws MySQLIntegrityConstraintViolationException
     */
    public void getUserInfo(boolean firstCheck) throws UniformInterfaceException, IOException, JSONException, MySQLIntegrityConstraintViolationException, InterDataBaseException, InterProcessException, InterEmailException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Inicio getUserInfo...");

        Long uidLong = (new Double(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid())).longValue();
        List<InfoUser> jsonUserInfo = this.snsObject.getFacebookRestClient().executeForList("Users.getInfo", InfoUser.class, Parameter.with("uids", uidLong), Parameter.with("fields", "sex,religion,relationship_status,political,activities,interests,is_app_user,music,tv,movies,books,about_me,status,quotes"));
        JSONObject jsonInfoUser = jsonUserInfo.get(0).toJson();
        JSONObject userFacebook = null;

        // Obtenemos la informaci?n del usuario de facebook
        if(firstCheck){
            userFacebook = getUserFacebook();
        }else{
            userFacebook = updateFacebookUserInfo(getUserFacebook(),uidLong.toString());
        }
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Informacion de Facebook del usuario: " + userFacebook.toString());

        // Obtenemos la informaci?n del usuario de OpenSocial
        JSONObject userOpenSocial = this.getEmptyUserOpenSocial();

        // Obtenemos la informaci?n de usuario com?n a facebook y OpenSocial
        JSONObject user = this.getUser(jsonInfoUser, userFacebook, userOpenSocial);

        if(firstCheck){
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Almacenando informacion de Facebook...");
            this.snsObject.getClient().userFacebook_setNewUserFacebook(String.class, userFacebook);
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Informacion de Facebook almacenada!!");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Almacenando informacion de usuario...");
            this.snsObject.getClient().user_setNewUser(String.class, user);
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Informacion de usuario almacenada!!");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Obteniendo informacion del muro del usuario en Facebook...");
            this.snsObject.getWallFilterFuncionality().getPostWall();
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Informacion del muro del usuario en Facebook obtenida!!");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Obteniendo amigos de Facebook...");
            this.snsObject.getFriendsFilterFuncionality().getUserFriends();
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Amigos de Facebook obtenidos!!");
        }else{
            try {
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Actualizando informacion de Facebook...");
                setUserFacebook_UserSettings(userFacebook, this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid());
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Informacion de Facebook actualizada!!");
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Actualizando informacion de usuario...");
                setUser_UserSettings(user, this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid());
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Informacion de usuario actualizada!!");
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Actualizando informacion del muro del usuario en Facebook...");
                this.snsObject.getWallFilterFuncionality().updatePostWall();
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Informacion del muro del usuario en Facebook actualizada!!");
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Actualizando amigos de Facebook...");
                this.snsObject.getFriendsFilterFuncionality().getUserFriends();
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Amigos de Facebook actualizados!!");
            } catch (Exception e) {
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Informacion actualizada en base de datos!!");
            }
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserInfo: Fin getUserInfo...");
    }

    /**
     * Actualiza la informacion de Facebook de un usuario de la aplicacion. Recibir? un objeto JSONObject con la informacion obtenida de Facebook para ser
     * almacenada en la tabla user\_facebook y su identificador interno de base de datos.
     *
     * @param userFacebook Informacion del perfil de Facebook del usuario.
     * @param uid UID de identificacion del usuario.
     */
    public void setUserFacebook_UserSettings(JSONObject userFacebook, String uid) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setUserFacebook_UserSettings: Inicio setUserFacebook_UserSettings...");
        try {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setUserFacebook_UserSettings: Actualizando informacion del perfil de Facebook...");
            Long uidLong = (new Double(uid)).longValue();
            this.snsObject.getClient().userFacebook_setUserFacebookByUid(String.class, userFacebook, uidLong.toString());
        } catch (UniformInterfaceException e) {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setUserFacebook_UserSettings: Informacion del perfil de Facebook actualizada!!");
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setUserFacebook_UserSettings: Fin setUserFacebook_UserSettings...");
    }

    /**
     * Actualiza la informacion personal del usuario de la aplicacion, es decir,
     * la informacion comun a Facebook y OpenSocial y la informacion especifica
     * de los anterioes. Recibir? un objeto JSONObject con la informacion que va a ser almacenada en la tabla user y su identificador interno de base de datos.
     *
     * @param user JSONObject con la informaci?n del usuario.
     * @param uid String con el identificador UID del usuario.
     */
    public void setUser_UserSettings(JSONObject user, String uid) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setUser_UserSettings: Inicio setUser_UserSettings...");
        try {
            Long uidLong = (new Double(uid)).longValue();
            this.snsObject.getClient().user_setUserByUid(String.class, user, "\"" + uidLong + "\"");
        } catch (UniformInterfaceException e) {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setUserFacebook_UserSettings: Informacion del perfil del usuario actualizada!!");
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setUser_UserSettings: Fin setUser_UserSettings...");
    }

    /**
     * Obtiene toda la informacion de Facebook asociada al perfil del usuario. Podr? lanzar excepciones del tipo UniformInterfaceException, IOException o JSONException.
     *
     * @return JSONObject con la informaci?n de perfil de Facebook.
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws JSONException
     */
    public JSONObject getUserFacebook() throws UniformInterfaceException, IOException, JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserFacebook: Inicio getUserFacebook...");
        String campos = "first_name,middle_name,last_name,name,pic_small,pic_big,pic_square,pic,profile_update_time,birthday,birthday_date,significant_other_id,hs_info,notes_count,wall_count,online_presence,locale,proxied_email,profile_url,email_hashes,pic_small_with_logo,pic_big_with_logo,pic_square_with_logo,pic_with_logo,allowed_restrictions,verified,profile_blurb,username,website,is_blocked,contact_email,email,meeting_for,meeting_sex";
        //String userFacebook = this.snsObject.execFbInst(18);
        Long uidLong = (new Double(this.userSettingsDAO.getUid())).longValue();
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserFacebook: Conectando a Facebook para obtener la informacion del perfil de Facebook del usuario...");
        List<InfoUserFacebook> infoUserFacebook = this.snsObject.getFacebookRestClient().executeForList("Users.getInfo", InfoUserFacebook.class, Parameter.with("uids", uidLong), Parameter.with("fields", campos));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserFacebook: Informacion del perfil de Facebook del usuario obtenida!!");
        JSONObject jsonInfoUserFacebook = infoUserFacebook.get(0).toJson();

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserFacebook: Fin getUserFacebook...");
        return jsonInfoUserFacebook;
    }

    /**
     * Genera un objeto JSON vacio con los campos de informacion necesarios para
     * generar un objeto OpenSocial nulo. Podr? lanzar una excepcion del tipo JSONException.
     *
     * @return JSONObject con objeto OpenSocial nulo.
     * @throws JSONException
     */
    public JSONObject getEmptyUserOpenSocial() throws JSONException{
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getEmptyUserOpenSocial: Inicio getEmptyUserOpenSocial...");
        JSONObject userOpenSocial = new JSONObject();

        userOpenSocial.put("iduseropenSocial", "0000000000");
        userOpenSocial.put("age", "");
        userOpenSocial.put("bodytypeBuild", "");
        userOpenSocial.put("bodytypeEyeColor", "");
        userOpenSocial.put("bodytypeHairColor", "");
        userOpenSocial.put("bodytypeHeight", "");
        userOpenSocial.put("bodytypeWeight", "");
        userOpenSocial.put("cars", "");
        userOpenSocial.put("children", "");
        userOpenSocial.put("addressopenSocialCURRENTLOCATION", "0000000000");
        userOpenSocial.put("dateOfBirth", "");
        userOpenSocial.put("drinkeropenSocialidDrinkeropenSocial", "1");
        userOpenSocial.put("ethnicity", "");
        userOpenSocial.put("fashion", "");
        userOpenSocial.put("food", "");
        userOpenSocial.put("genderopenSocialidGenderopenSocial", "1");
        userOpenSocial.put("happiestWhen", "");
        userOpenSocial.put("heroes", "");
        userOpenSocial.put("humor", "");
        userOpenSocial.put("jobInterests", "");
        userOpenSocial.put("languagesSpoken", "");
        userOpenSocial.put("livingArrangement", "");
        userOpenSocial.put("lookingForopenSocialidLookingForopenSocial", "1");
        userOpenSocial.put("presenceopenSocialidPresenceopenSocial", "1");
        userOpenSocial.put("nickname", "");
        userOpenSocial.put("pets", "");
        userOpenSocial.put("profileUrl", "");
        userOpenSocial.put("romance", "");
        userOpenSocial.put("scaredOf", "");
        userOpenSocial.put("smokeropenSocialidSmokeropenSocial", "1");
        userOpenSocial.put("sports", "");
        userOpenSocial.put("tags", "");
        userOpenSocial.put("thumbnailUrl", "");
        userOpenSocial.put("timeZone", "");
        userOpenSocial.put("turnsOffs", "");
        userOpenSocial.put("turnsOns", "");
        userOpenSocial.put("urls", "");

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getEmptyUserOpenSocial: Fin getEmptyUserOpenSocial...");

        return userOpenSocial;
    }

    /**
     * Obtiene en un objeto JSON todos los datos comunes a los perfiles de
     * Facebook y OpenSocial. Lo genera a partir de un objeto JSONObject con la informacion de la tabla user, un JSONObject con la informacion de la tabla
     * user\_facebook y otro JSONObject con la informacion de la tabla user\_openSocial. Podr? lanzar una excepcion del tipo JSONException.
     *
     * @param userAux Informaci?n de usuario.
     * @param userFacebook Informaci?n de Facebook.
     * @param userOpenSocial Informaci?n de OpenSocial.
     * @return
     * @throws JSONException
     */
    public JSONObject getUser(JSONObject userAux, JSONObject userFacebook, JSONObject userOpenSocial) throws JSONException{
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUser: Inicio getUser...");
        JSONObject user = new JSONObject();

        user.put("userSettingsUid", userAux.get("uid"));
        user.put("sex", userAux.get("sex"));
        user.put("religion", userAux.get("religion"));
        user.put("relationshipStatus", userAux.get("relationship_status"));
        user.put("political", userAux.get("political"));
        user.put("activities", userAux.get("activities"));
        user.put("interests", userAux.get("interests"));
        user.put("isAppUser", userAux.get("is_app_user"));
        user.put("music", userAux.get("music"));
        user.put("tv", userAux.get("tv"));
        user.put("movies", userAux.get("movies"));
        user.put("books", userAux.get("books"));
        user.put("aboutMe", userAux.get("about_me"));
        user.put("status", userAux.get("status"));
        user.put("quotes", userAux.get("quotes"));
        user.put("userFacebook", userFacebook);
        user.put("useropenSocial", userOpenSocial);

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUser: Fin getUser...");
        return user;
    }

    /**
     * Obtiene todos los amigos de Facebook almacenados en la base de datos para
     * un determinado usuario de la apliacion a partir del identificador de un usuario indicado en el par?metro de entrada de tipo String.
     *
     * @param uidLong UID del usuario de la aplicacion.
     * @return JSONArray con todos los datos de los amigos de Facebook.
     */
    public JSONArray getFacebookFriendsDB(String uidLong){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getFacebookFriendsDB: Inicio getFacebookFriendsDB...");
        try {
            String clientAngels = this.snsObject.getClient().userFacebook_getFriendsFacebookByUidCollection(String.class, uidLong);
            JSONObject jsonObject = new JSONObject(clientAngels);
            JSONArray jsonFriendsFacebook = this.snsObject.getJsonUtilities().getJSONArray(jsonObject.getString("friendsFacebook"));

            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getFacebookFriendsDB: Fin getFacebookFriendsDB...");
            return jsonFriendsFacebook;
        } catch (JSONException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getFacebookFriendsDB: Excepcion capturada JSONException: " + ex.getMessage());
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getFacebookFriendsDB: Fin con errores getFacebookFriendsDB...");
            return null;
        }
    }
}
