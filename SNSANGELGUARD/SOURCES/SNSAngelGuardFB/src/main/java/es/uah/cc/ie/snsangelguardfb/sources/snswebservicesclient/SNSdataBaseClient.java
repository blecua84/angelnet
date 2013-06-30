/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.snswebservicesclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.core.MultivaluedMap;

/** Jersey REST client generated for REST resource:SNSdataBaseIntegratorServer [userSettingss/]<br>
 *  USAGE:<pre>
 *        SNSdataBaseClientPrueba client = new SNSdataBaseClientPrueba();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 *  </pre>
 * @author tote
 */
public class SNSdataBaseClient {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "SNSdataBaseIntegratorServer/resources/";
    
    public SNSdataBaseClient(String context) {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(context + BASE_URI);
    }

    /**
     * @param responseType Class representing the response
     * @param optionalQueryParams List of optional query parameters in the form of "param_name=param_value",...<br>
     * List of optional query parameters:
     * <LI>max [OPTIONAL, DEFAULT VALUE: "10"]
     * <LI>start [OPTIONAL, DEFAULT VALUE: "0"]
     * <LI>query [OPTIONAL, DEFAULT VALUE: "SELECT e FROM UserSettings e"]
     * <LI>expandLevel [OPTIONAL, DEFAULT VALUE: "1"]
     * @return response object (instance of responseType class)
     */
    public <T> T userSettings_getEntities(Class<T> responseType) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT e FROM UserSettings e"};
        return webResource.path("userSettingss").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userSettings_getUserByUidPublic(Class<T> responseType, String uidPublic) throws UniformInterfaceException, UnsupportedEncodingException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "10", "1", "SELECT e FROM UserSettings e WHERE e.uidPublic = " + uidPublic};
        return webResource.path("userSettingss").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userSettings_setUpdateTime(Class<T> responseType, String uid, String mode, String oauthToken) {
        String[] queryParamNames = new String[]{"mode", "oauthToken"};
        String[] queryParamValues = new String[]{mode, oauthToken};
        return webResource.path("userSettingss").path(uid).queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType);
    }

    /**
     * @param responseType Class representing the response
     * @param requestEntity request data
     * @return response object (instance of responseType class)
     */
    public <T> T userSettings_setNewEntityUserSettings(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("userSettingss").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T userSettings_getUserSettingsByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("userSettingss").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userSettings_setNewAngelsCollectionByUid(Class<T> responseType, String uidAngel, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsAngelss").path(uidAngel).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T localeSettings_getLocaleSettingsByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("localeSettingss").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T settingsFltWall_getUserByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltWalls").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T settingsFltWall_setNewUser(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsfltWalls").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T settingsFltWall_setFilterByUid(Class<T> responseType, String uid, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsfltWalls").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T settingsFltWall_setLastCheckByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltWalls").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType);
    }

    public <T> T settingsFltWall_getAngelsCollectionByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltWalls").path(uid).path("settingsAngelsCollection").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T settingsFltFriends_getUserByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltFriendss").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T settingsFltFriends_setNewUser(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsfltFriendss").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T settingsFltFriends_setFilterByUid(Class<T> responseType, String uid, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsfltFriendss").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T settingsFltFriends_setLastCheckByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltFriendss").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType);
    }

    public <T> T settingsFltFriends_getAngelsCollectionByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltFriendss").path(uid).path("settingsAngelsCollection").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T settingsFltPriv_getUserByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltPrivs").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T settingsFltPriv_setNewUser(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsfltPrivs").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T settingsFltPriv_setFilterByUid(Class<T> responseType, String uid, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsfltPrivs").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T settingsFltPriv_setLastCheckByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltPrivs").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType);
    }

    public <T> T settingsFltPriv_getAngelsCollectionByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltPrivs").path(uid).path("settingsAngelsCollection").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T settingsFltVist_getUserByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltVists").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T settingsFltVist_setNewUser(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsfltVists").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T settingsFltVist_setFilterByUid(Class<T> responseType, String uid, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsfltVists").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T settingsFltVist_setLastCheckByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltVists").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType);
    }

    public <T> T settingsFltVist_getAngelsCollectionByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("settingsfltVists").path(uid).path("settingsAngelsCollection").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T settingsAngels_setAngelByUid(Class<T> responseType, String uid, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsAngelss").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public void settingsAngels_delAngelByUid(String uid) throws UniformInterfaceException {
        webResource.path("settingsAngelss").path(uid).accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).delete();
    }

    public <T> T settingsAngels_setNewAngel(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("settingsAngelss").accept(javax.ws.rs.core.MediaType.TEXT_XML, javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T settingsAngels_getAngelsByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT e FROM SettingsAngels e WHERE e.userPropAngel = " + uid};
        return webResource.path("settingsAngelss").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T user_getEntities(Class<T> responseType) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT e FROM User e"};
        return webResource.path("users").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T user_getUserByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("users").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T user_setNewUser(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("users").accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T user_setUserByUid(Class<T> responseType, Object requestEntity, String uid) throws UniformInterfaceException {
        return webResource.path("users").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T userFacebook_getEntities(Class<T> responseType) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT e FROM UserFacebook e"};
        return webResource.path("userFacebooks").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_setNewUserFacebook(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("userFacebooks").accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T userFacebook_getUserFacebookByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        return webResource.path("userFacebooks").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_setUserFacebookByUid(Class<T> responseType, Object requestEntity, String uid) throws UniformInterfaceException {
        return webResource.path("userFacebooks").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T userFacebook_setNewStreamComentsByUid(Class<T> responseType, Object requestEntity, String uid) throws UniformInterfaceException {
        return webResource.path("userFacebooks").path(uid).path("streamFacebookCollection").accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    // Devuelve de la tabla StreamFacebook el comentario referenciado por el campo "postId"
    public <T> T userFacebook_getStreamComentByUid(Class<T> responseType, String postId) throws UniformInterfaceException {
        return webResource.path("streamFacebooks").path(postId).queryParam("postId", postId).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_setStreamComentsByUid(Class<T> responseType, Object requestEntity, String postId, String updatedTime, String createdTime) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"updatedTime", "createdTime"};
        String[] queryParamValues = new String[]{updatedTime, createdTime};
        return (T) webResource.path("streamFacebooks").path(postId).queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T userFacebook_setComentsPost(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("commentFacebooks").accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T userFacebook_getComentsPostById(Class<T> responseType, String postId) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT c FROM CommentFacebook c WHERE c.postId = " + postId};
        return webResource.path("commentFacebooks").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_getComentsPostByTime(Class<T> responseType, String postId, String time) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT c FROM CommentFacebook c WHERE c.postId = " + postId + " AND c.timeComment > " + time};
        return webResource.path("commentFacebooks").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_getStreamFacebookByUid(Class<T> responseType, String uid) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT s FROM StreamFacebook s WHERE s.sourceId = " + uid};
        return webResource.path("streamFacebooks").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_getStreamFacebookByUpdatedTime(Class<T> responseType, String uid, String updatedTime) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT s FROM StreamFacebook s WHERE s.sourceId = " + uid + " AND s.updatedTime > " + updatedTime};
        return webResource.path("streamFacebooks").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_getFriendsFacebookByUidCollection(Class<T> responseType, String uid) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel",};
        String[] queryParamValues = new String[]{"0", "10000", "1"};

        return webResource.path("userFacebooks").path(uid).path("friendsFacebookCollection").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_isNewFriendsFacebookByUid(Class<T> responseType, String friendUid) throws UniformInterfaceException {
        return webResource.path("friendsFacebooks").path(friendUid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_getFriendsFacebookByUid(Class<T> responseType, String uid, String friendUid) throws UniformInterfaceException {
        return webResource.path("userFacebooks").path(uid).path("friendsFacebookCollection").path(friendUid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userFacebook_setNewFriendFacebook(Class<T> responseType, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("friendsFacebooks").accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    public <T> T userFacebook_setFriendsFacebookByUid(Class<T> responseType, Object requestEntity, String uid) throws UniformInterfaceException {
        return webResource.path("friendsFacebooks").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(responseType, requestEntity);
    }

    public <T> T userFacebook_getFriendFacebookByUid(Class<T> responseType, Object requestEntity, String uidFriend) throws UniformInterfaceException {
        return webResource.path("friendsFacebooks").path(uidFriend).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
       
    public <T> T streamFacebook_getStreamPostByActorId(Class<T> responseType, String uid, String actorId){
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT s FROM StreamFacebook s WHERE s.sourceId = " + uid + " AND s.actorId = " + actorId};
        return webResource.path("streamFacebooks").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }
    
    public <T> T streamFacebook_getStreamPostByActorIdAndUpdateTime(Class<T> responseType, String uid, String actorId, String updatedTime){
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "1000", "1", "SELECT s FROM StreamFacebook s WHERE s.sourceId = " + uid + " AND s.actorId = " + actorId + " AND s.updatedTime > " + updatedTime};
        return webResource.path("streamFacebooks").queryParams(getQParams(queryParamNames, queryParamValues)).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T userOpenSocial_getEntities(Class<T> responseType) throws UniformInterfaceException {
        String[] queryParamNames = new String[]{"start", "max", "expandLevel", "query"};
        String[] queryParamValues = new String[]{"0", "15", "1", "SELECT s FROM UserOpensocial s"};
        return webResource.path("useropenSocials").queryParams(getQParams(queryParamNames, queryParamValues)).get(responseType);
    }

    public <T> T userOpenSocial_setUserOpenSocialByUid(Class<T> responseType, String uid, Object requestEntity) throws UniformInterfaceException {
        return webResource.path("useropenSocials").path(uid).accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(responseType, requestEntity);
    }

    private MultivaluedMap getQParams(String[] paramNames, String[] paramValues) {
        MultivaluedMap<String, String> qParams = new com.sun.jersey.api.representation.Form();
        for (int i = 0; i < paramNames.length; i++) {

            if (paramValues[i] != null) {
                qParams.add(paramNames[i], paramValues[i]);
            }
        }
        return qParams;
    }

    public void close() {
        client.destroy();
    }
}