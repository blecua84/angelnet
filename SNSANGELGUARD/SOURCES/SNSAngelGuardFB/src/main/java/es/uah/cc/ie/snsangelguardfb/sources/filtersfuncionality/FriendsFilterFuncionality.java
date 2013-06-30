package es.uah.cc.ie.snsangelguardfb.sources.filtersfuncionality;

import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.exception.InterDataBaseException;
import es.uah.cc.ie.snsangelguardfb.exception.InterEmailException;
import es.uah.cc.ie.snsangelguardfb.exception.InterProcessException;
import es.uah.cc.ie.snsangelguardfb.facebookclient.data.FriendsFacebook;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.util.List;
import javax.mail.MessagingException;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Clase que controla la ejecucion el filtro de amigos.
 *
 * @author tote
 */
public class FriendsFilterFuncionality {
    
    /** Maxima diferencia de edad permitida para los contactos */
    private static final int MAX_AGE_LIMITED = 5;

    /** Logger Class */
    private static Logger logger = Logger.getLogger(FriendsFilterFuncionality.class);

    /** Clase Manager de la aplicaci?n */
    private SNSAngelGuardFBManager snsObject;

    /**
     * Constructor de clase. Inicializa su atributo manager de la aplicacion.
     *
     * @param snsObject SNSAngelGuardFBManager Manager de la aplicaci?n.
     */
    public FriendsFilterFuncionality(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Obtiene el objeto manager de la aplicaci?n.
     *
     * @return SNSAngelGuardFBManager
     */
    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    /**
     * Establece el objeto manager de la aplicaci?n.
     *
     * @param snsObject SNSAngelGuardFBManager
     */
    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Convierte una URI obtenida para un friendFacebook desde servidor al
     * formato correcto para volver a ser introducida en la relacion.
     *
     * @param strURI URI obtenida de servidor.
     * @param strUidFriend UID del friendFacebook con la que se va a asociar.
     * @return URI asociada al friendFacebook.
     */
    public String getURIConverted(String strURI, String strUidFriend){
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getURIConverted: Reemplazando valor URI: " + strURI);
        strURI = strURI.replace("friendsFacebooks/userFacebookCollection/", "friendsFacebooks/" + strUidFriend + "/userFacebookCollection/");
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getURIConverted: Nuevo valor URI: " + strURI);

        return strURI;
    }

    /**
     * Convierte un array de objetos JSON con URIs obtenidas desde servidor en
     * un array de objetos JSON con URIs preparadas para volver a ser relacionadas. Podr? lanzar excepciones del tipo JSONException.
     *
     * @param jsonArrayUserFacebook Array JSON de objetos de servidor.
     * @param strUidFriend UID del friendFacebook con la que se va a asociar.
     * @return Array JSON con los objetos preparados para ser relacionados.
     * @throws JSONException
     */
    public JSONArray convertURIServerToURIUserFacebook(JSONArray jsonArrayUserFacebook, String strUidFriend) throws JSONException{
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - convertURIServerToURIUserFacebook: Inicio convertURIServerToURIUserFacebook para amigo: " + strUidFriend);
        JSONArray jsonArrayNewUserFacebook = new JSONArray();

        for(int i = 0; i < jsonArrayUserFacebook.length(); i++){
            JSONObject jsonUriUserFacebook = jsonArrayUserFacebook.getJSONObject(i);
            String strUri = getURIConverted(jsonUriUserFacebook.getString("uri"), strUidFriend);

            jsonUriUserFacebook.put("uri", strUri);
            jsonArrayNewUserFacebook.put(jsonUriUserFacebook);
        }

        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - convertURIServerToURIUserFacebook: Fin convertURIServerToURIUserFacebook para amigo: " + strUidFriend);
        return jsonArrayNewUserFacebook;
    }

    /**
     * Incluye a un amigo en la relacion con un usuario de Facebook.
     *
     * @param jsonFriend Datos de un amigo de Facebook.
     */
    public void setCollectionFriendsFacebook(JSONObject jsonFriend){
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setCollectionFriendsFacebook: Inicio setCollectionFriendsFacebook...");
        JSONObject jsonUri = null;
        JSONObject jsonUserFacebook = null;
        JSONObject jsonAux = null;
        JSONObject jsonCollection = new JSONObject();
        Long uidLong = (new Double(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid())).longValue();

     try {
            String collection = this.snsObject.getClient().userFacebook_isNewFriendsFacebookByUid(String.class, jsonFriend.getString("userUid"));
            System.out.println(collection);
            jsonAux = new JSONObject(collection);
            JSONArray aux = new JSONArray();
            jsonCollection = jsonAux.getJSONObject("userFacebookCollection");
            try {
                //Si es un array
                aux = jsonCollection.getJSONArray("userFacebook");

                // Convertimos todas las URI del array al formato permitido
                aux = convertURIServerToURIUserFacebook(aux, jsonFriend.getString("userUid"));

                jsonUri = new JSONObject();
                jsonUri.put("uri", this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/friendsFacebooks/" + jsonFriend.getString("userUid") + "/userFacebookCollection/" + uidLong + "/");
                aux.put(jsonUri);
                jsonCollection.put("userFacebook", aux);
                jsonFriend.put("userFacebookCollection", jsonCollection);
            } catch (JSONException ex) {
                if(jsonCollection.length() > 1){
                    // Si unicamente hay un usuario enlazado con este friendFacebook
                    jsonUserFacebook = jsonCollection.getJSONObject("userFacebook");
                    aux.put(jsonUserFacebook);
                    
                    // Convertimos todas las URI del array al formato permitido
                    aux = convertURIServerToURIUserFacebook(aux, jsonFriend.getString("userUid"));

                    // Introducimos la nueva URI del friendFacebook que no estaba relacionado con el usuario de Facebook
                    jsonUri = new JSONObject();
                    jsonUri.put("uri", this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/friendsFacebooks/" + jsonFriend.getString("userUid") + "/userFacebookCollection/" + uidLong + "/");
                    aux.put(jsonUri);

                    jsonCollection.put("userFacebook", aux);
                    jsonFriend.put("userFacebookCollection", jsonCollection);
                }else{
                    // Si no tiene usuarios enlazados con el friendFacebook
                    jsonUri = new JSONObject();
                    jsonUri.put("uri", this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSdataBaseIntegratorServer/resources/friendsFacebooks/" + jsonFriend.getString("userUid") + "/userFacebookCollection/" + uidLong + "/");
                    JSONObject jsonUriUserFacebook = new JSONObject();
                    jsonUriUserFacebook.put("userFacebook", jsonUri);
                    jsonFriend.put("userFacebookCollection", jsonUriUserFacebook);
                }
            }

        } catch (JSONException ex) {}
        try {
            this.snsObject.getClient().userFacebook_setFriendsFacebookByUid(String.class, jsonFriend, jsonFriend.getString("userUid"));
        } catch (JSONException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setCollectionFriendsFacebook: Excepcion capturada JSONException: " + ex.getMessage());
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setCollectionFriendsFacebook: Fin setCollectionFriendsFacebook...");
    }

    /**
     * Relaciona un nuevo amigo con el conjunto de amigos del usuario en la base de datos SocialNetwork. 
     * Podra lanzar excepciones del tipo JSONException, InterDataBaseException, InterProcessException o InterEmailException.
     *
     * @param jsonFriendFacebook Nuevo amigo de Facebook.
     * @throws JSONException
     */
    public void updateRelationshipNewFriend(JSONObject jsonFriendFacebook) throws JSONException, InterDataBaseException, InterProcessException, InterEmailException{
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateRelationshipNewFriend: Inicio updateRelationshipNewFriend...");
        try {
            setCollectionFriendsFacebook(jsonFriendFacebook);
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateRelationshipNewFriend: Nuevo amigo " + jsonFriendFacebook.getString("userUid") + " relacionado en base de datos con " + this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid());
        } catch (UniformInterfaceException e) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateRelationshipNewFriend: Excepcion capturada UniformInterfaceException: " + e.getMessage());
            logger.fatal(e);
            this.snsObject.getExceptionManager().initControlException(e);
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - updateRelationshipNewFriend: Fin updateRelationshipNewFriend...");
    }

    /**
     * Obtiene de Facebook todos los datos necesarios para almacenar un nuevo amigo en la base de datos. 
     * Podr? lanzar excepciones del tipo UniformInterfaceException, IOException, JSONException, InterDataBaseException, InterProcessException o InterEmailException.
     *
     * @param friendUid Identificador del amigo del usuario en Facebook.
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws JSONException
     */
    public void getNewFriend(String friendUid) throws UniformInterfaceException, IOException, JSONException, InterDataBaseException, InterProcessException, InterEmailException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewFriend: Inicio getNewFriend para el amigo: " + friendUid);

        String query = "SELECT uid,name,birthday_date,pic_square FROM user WHERE uid=" + friendUid;
        
        List<FriendsFacebook> friendsFacebookList = this.snsObject.getFacebookQueryClient().executeQuery(query, FriendsFacebook.class);

        if (!friendsFacebookList.isEmpty()) {
            JSONObject jsonFriendFacebook = friendsFacebookList.get(0).toJson();
            try {
                jsonFriendFacebook.put("userBirthday", this.snsObject.getDateTimeUtilities().formatearFecha(friendsFacebookList.get(0).getBirthdayDate()));

                if (isNewInFriendsFacebook(jsonFriendFacebook)) {
                    this.snsObject.getClient().userFacebook_setNewFriendFacebook(String.class, jsonFriendFacebook);
                    updateRelationshipNewFriend(jsonFriendFacebook);
                }else if(isNewFriend(jsonFriendFacebook)){
                    updateRelationshipNewFriend(jsonFriendFacebook);
                }
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewFriend: Excepcion capturada JSONException: " + ex.getMessage());
                logger.fatal(ex);
            }
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNewFriend: Fin getNewFriend para el amigo: " + friendUid);
    }

    /**
     * Obtiene todos los amigos de un usuario en Facebook y los almacena en la base de datos SocialNetwork.
     * Podr? lanzar excepciones del tipo UniformInterfaceException, IOException, InterDataBaseException, InterProcessException o InterEmailException.
     * 
     * @throws UniformInterfaceException
     * @throws IOException
     */
    public void getUserFriends() throws UniformInterfaceException, IOException, InterDataBaseException, InterProcessException, InterEmailException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserFriends: Inicio getUserFriends...");

        //Se obtienen los amigos del usuario
        List<String> myFriends = this.snsObject.getFacebookRestClient().executeForList("friends.get", String.class);

        for(int j = 0; j < myFriends.size(); j++){
            try {
                this.getNewFriend(myFriends.get(j));
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserFriends: Excepcion capturada JSONException: " + ex.getMessage());
                logger.fatal(ex);
                this.snsObject.getExceptionManager().initControlException(ex);
            }
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getUserFriends: Fin getUserFriends...");
    }

    /**
     * Comprueba si un amigo de un usuario ya esta almacenado en la coleccion de amigos de la base de datos SocialNetwork.
     * Podr? lanzar excepciones del tipo JSONException.
     *
     * @param friend Datos del amigo de Facebook.
     * @return boolean
     * @throws JSONException
     */
    public boolean isNewFriend(JSONObject friend) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isNewFriend: Inicio isNewFriend para el amigo: " + friend.getString("userUid"));
        try {
            Long uidLong = (new Double(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid())).longValue();
            String result = this.snsObject.getClient().userFacebook_getFriendsFacebookByUid(String.class, uidLong.toString(), friend.getString("userUid"));

            if(result.contains("userFacebookCollection/" + uidLong.toString())){
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isNewFriend: El amigo " + friend.getString("userUid") + " existe en la coleccion de amigos del usuario...");
                return false;
            }else{
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isNewFriend: El amigo " + friend.getString("userUid") + " no existe en la coleccion de amigos del usuario...");
                return true;
            }
        } catch (Exception e) {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isNewFriend: El amigo " + friend.getString("userUid") + " no existe en la base de datos...");
            return true;
        }
    }

    /**
     * Comprueba si un amigo del usuario es nuevo dentro de la base de datos. Podr? lanzar excepciones del tipo JSONException.
     *
     * @param friend Datos del nuevo amigo.
     * @return boolean
     * @throws JSONException
     */
    public boolean isNewInFriendsFacebook(JSONObject friend) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isNewInFriendsFacebook: Inicio isNewInFriendsFacebook para el amigo: " + friend.getString("userUid"));
        try {
            this.snsObject.getClient().userFacebook_isNewFriendsFacebookByUid(String.class, friend.getString("userUid"));
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isNewInFriendsFacebook: El amigo " + friend.getString("userUid") + " existe en la base de datos...");
            return false;
        } catch (Exception e) {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isNewInFriendsFacebook: El amigo " + friend.getString("userUid") + " no existe en la base de datos...");
            return true;
        }
    }

    /**
     * Realiza el chequeo del filtro. Mandara una lista, en formato HTML, con todos los amigos
     * que tengan una edad mayor a cinco anios de diferencia con el usuario o no hayan especificado
     * su edad. Podr? lanzar excepciones del tipo UniformInterfaceException, IOException, NoSuchProviderException, MessagingException o JSONException.
     *
     * @return Lista en formato HTML con el resultado del filtro.
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws JSONException
     */
    public String checkFriends() throws UniformInterfaceException, IOException, NoSuchProviderException, MessagingException, JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFriends: Inicio checkFriends...");
        String informe = "";
        String menDB[] = this.snsObject.getStringUtilities().stringToArray(this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getMailNotification());
        Long uidLong = (new Double(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid().toString())).longValue();

        JSONObject jsonUserFacebook = new JSONObject(this.snsObject.getClient().userFacebook_getUserFacebookByUid(String.class, uidLong.toString()));
        String userBirthday = jsonUserFacebook.getString("birthdayDate");
        int intFecUser = Integer.parseInt(userBirthday.substring(6, userBirthday.length()));


        JSONArray jsonFriendsFacebook = this.snsObject.getUserSettingsDaoManager().getFacebookFriendsDB(uidLong.toString());

        for (int i = 0; i < jsonFriendsFacebook.length(); i++) {
            JSONObject jsonFriend = jsonFriendsFacebook.getJSONObject(i);

            if (jsonFriend.get("userBirthday").toString().contains("00-00-")) {
                informe += jsonFriend.getString("userName") + menDB[6] + " <br>";
            } else if (isAgeLimit(intFecUser, jsonFriend.getString("userBirthday").substring(6, jsonFriend.getString("userBirthday").length()))) {
                informe += jsonFriend.getString("userName") + menDB[7] + this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUserName() + ". <br>";
            }
        }

        if (informe.equals("")) {
            informe = menDB[8];
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkFriends: Fin checkFriends...");
        return informe;
    }

    /**
     * Comprueba si la edad de un amigo de Facebook tiene una diferencia mayor de cinco anios
     * a la del usuario o no ha especificado su edad. Podr? lanzar excepciones del tipo UniformInterfaceException, IOException o JSONException.
     *
     * @param birthdayUser Fecha de nacimiento del usuario.
     * @param anio A?o de nacimiento del amigo de Facebook.
     * @return boolean
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws JSONException
     */
    public boolean isAgeLimit(int birthdayUser, String anio) throws UniformInterfaceException, IOException, JSONException {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isAgeLimit: Usuario nacido en fecha: " + birthdayUser);
            int intFecFriend = Integer.parseInt(anio);
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isAgeLimit: Amigo  nacido en el a?o: " + intFecFriend);

            return ((intFecFriend < birthdayUser) && (intFecFriend < birthdayUser - MAX_AGE_LIMITED));

    }
}
