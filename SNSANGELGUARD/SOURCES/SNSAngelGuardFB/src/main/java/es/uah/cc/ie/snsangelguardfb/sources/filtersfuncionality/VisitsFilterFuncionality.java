package es.uah.cc.ie.snsangelguardfb.sources.filtersfuncionality;

import es.uah.cc.ie.snsangelguardfb.facebookclient.data.FacebookUrlStadistics;
import es.uah.cc.ie.snsangelguardfb.facebookclient.data.FriendsFacebook;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openide.util.Exceptions;

/**
 * Clase que realiza la ejecucion del filtro de visitas.
 * 
 * @author tote
 */
public class VisitsFilterFuncionality {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(VisitsFilterFuncionality.class);

    /** Clase Manager de la aplicaci?n */
    private SNSAngelGuardFBManager snsObject;

    /** Array que contiene todos los titulos utilizados por el filtro para incluir en los correos de informes. */
    private String[] titleOptions;

    /**
     * Constructor de clase.
     *
     * @param snsObject Manager de la aplicaci?n.
     */
    public VisitsFilterFuncionality(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Obtiene el manager de la aplicaci?n asociado a la clase.
     *
     * @return SNSAngelGuardFBManager
     */
    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    /**
     * Establece en el objeto el manager de la aplicaci?n.
     *
     * @param snsObject Manager de la aplicaci?n desde donde se referncia el objeto.
     */
    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Realiza el chequeo del filtro de visitas devolviendo el informe generado
     * por los siguientes metodos privados:
     * - getMutualFriends: Devolvera una lista con los primeros diez contactos
     * con los que mas contactos compartimos en Facebook.
     * - getNotMutualFriends: Devolvera una lista con los primeros diez contactos
     * con los que menos contactos compartimos en Facebook.
     * - getRankingPostFriends: Devolvera una lista de los amigos que mas post,
     * incluyendo entradas en el muro y comentarios, han escrito en nuestro muro.
     * Podr? lanzar excepciones del tipo JSONExcpetion.
     *
     * @param firstCheck Fecha hasta la que se realizar? el filtro de visitas.
     *
     * @return Informe en formato HTML que ser? incluido en el email de notificaci?n
     * a los ?ngeles que hayan sido configurados por el usuario de la aplicaci?n.
     */
    public String checkVisitFilter(boolean firstCheck) throws JSONException{
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkVisitFilter: Inicio checkVisitFilter...");
        this.titleOptions = this.snsObject.getStringUtilities().stringToArray(this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleVisitsFilterOptions());
        
        String result = getMutualFriends() + getNotMutualFriends() + getRankingPostFriends(firstCheck);
        
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - checkVisitFilter: Fin checkVisitFilter...");
        return result;
    }

    /**
     * Devolvera una lista con los primeros diez contactos con los que mas contactos
     * compartimos en Facebook. Cada entrada de la lista contendra la foto del contacto
     * actual en Facebook, su nombre y el numero de amigos en comun.
     *
     * @return Lista en formato HTML.
     */
    private String getMutualFriends(){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getMutualFriends: Inicio getMutualFriends...");
        String resultado = "";

        try {

            String query = "SELECT name,pic_square,mutual_friend_count FROM user WHERE uid in (SELECT uid1 FROM friend WHERE uid2=me()) ORDER BY mutual_friend_count DESC ";

            List<FacebookUrlStadistics> visits = this.snsObject.getFacebookQueryClient().executeQuery(query, FacebookUrlStadistics.class);

            int longComm = (visits.size() <= 10 ) ? visits.size() : 10;

            resultado = "<table><tr><td width=\"95%\"><br><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color: #3b5998;margin:5px;\">"
                    + this.titleOptions[0]
                    + "</div><hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /></td></tr><tr><td><table width=\"97%\">";

            for(int i = 0; i < longComm; i++){

                resultado = resultado + "<tr>"
                                            + "<td width=100px><img src='" + visits.get(i).toJson().getString("pic_square") + "'/></td>"
                                            + "<td width='286px'>" + visits.get(i).toJson().getString("name") + "</td>"
                                            + "<td width='286px'>" + visits.get(i).toJson().getString("mutual_friend_count") + "</td>"
                                      + "</tr>";
            }

            resultado = resultado + "</table></tr></td></table>";
        } catch (JSONException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getMutualFriends: Excepcion capturada JSONException: " + ex.getMessage());
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getMutualFriends: Fin getMutualFriends...");
        return resultado;
    }

    /**
     * Devolvera una lista con los primeros diez contactos con los que menos contactos
     * compartimos en Facebook. Cada entrada de la lista contendra la foto del contacto
     * actual en Facebook, su nombre y el numero de amigos en comun.
     *
     * @return Lista en formato HTML con el resultado de la operaci?n.
     */
    private String getNotMutualFriends(){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNotMutualFriends: Inicio getNotMutualFriends...");
        String resultado = "";

        try {

            String query = "SELECT name,pic_square,mutual_friend_count FROM user WHERE uid in (SELECT uid1 FROM friend WHERE uid2=me()) ORDER BY mutual_friend_count ASC ";

            List<FacebookUrlStadistics> visits = this.snsObject.getFacebookQueryClient().executeQuery(query, FacebookUrlStadistics.class);

            int longComm = (visits.size() <= 10 ) ? visits.size() : 10;

            resultado = "<table><tr><td width=\"95%\"><br><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color: #3b5998;margin:5px;\">"
                    + this.titleOptions[1]
                    + "</div><hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /></td></tr><tr><td><table width=\"97%\">";

            for(int i = 0; i < longComm; i++){

                resultado = resultado + "<tr>"
                                            + "<td width=100px><img src='" + visits.get(i).toJson().getString("pic_square") + "'/></td>"
                                            + "<td width='286px'>" + visits.get(i).toJson().getString("name") + "</td>"
                                            + "<td width='286px'>" + visits.get(i).toJson().getString("mutual_friend_count") + "</td>"
                                      + "</tr>";
            }

            resultado = resultado + "</table></tr></td></table>";
        } catch (JSONException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNotMutualFriends: Excepcion capturada JSONException: " + ex.getMessage());
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getNotMutualFriends: Fin getNotMutualFriends...");

        return resultado;
    }

    /**
     * Devuelve el numero de comentarios a un determinado post indicado por el
     * parametro de entrada postId que ha hecho un determinado amigo, indicado
     * por el parametro de entrada uidFriend.
     *
     * @param uidFriend Amigo de Facebook.
     * @param postId Entrada en el muro de un usuario.
     * @return Numero de comentarios de un amigo a un comentario.
     */
    private int getCommentsNumberPost(String uidFriend, String postId, boolean firstCheck){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getCommentsNumberPost: Inicio busqueda de comentarios de " + uidFriend + " en el post " + postId + "...");
        int countPost = 0;
        String commentsPost = null;
        try {
            if (firstCheck) {
                commentsPost = this.snsObject.getClient().userFacebook_getComentsPostById(String.class, "\"" + postId + "\"");
            } else {
                Date lastCheck = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getLastCheck();
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getCommentsNumberPost: Buscando comentarios al post " + postId + " hasta la fecha de actualizaci?n: " + formateador.format(lastCheck));
                commentsPost = this.snsObject.getClient().userFacebook_getComentsPostByTime(String.class, "\"" + postId + "\"", "'" + formateador.format(lastCheck) + "'");
            }

            if (commentsPost != null) {
                JSONArray jsonCommentsPost = null;
                try{
                    jsonCommentsPost = (new JSONObject(commentsPost)).getJSONArray("commentFacebook");
                } catch(JSONException e){
                    jsonCommentsPost = new JSONArray();
                    jsonCommentsPost.put(new JSONObject(commentsPost));
                }
                
                for (int i = 0; i < jsonCommentsPost.length(); i++) {
                    try {
                        if (jsonCommentsPost.getJSONObject(i).getString("fromid").equals(uidFriend)) {
                            countPost++;
                        }
                    } catch (JSONException ex) {
                        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getCommentsNumberPost: No existen comentarios para el post: " + postId);
                        logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getCommentsNumberPost: Excepcion capturada JSONException: " + ex.getMessage());
                    }
                }
            }
        } catch (JSONException ex) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getCommentsNumberPost: No existen comentarios para el post: " + postId);
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getCommentsNumberPost: Excepcion capturada JSONException: " + ex.getMessage());
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getCommentsNumberPost: Fin busqueda de comentarios de " + uidFriend + " en el post " + postId + " con el resultado de " + countPost + " comentarios encontrados...");
        return countPost;
    }

    /**
     * Comprueba si el identificador de un amigo esta contenido en el array de amigos
     * que han escrito en el muro del usuario. Podra lanzar excepciones del tipo JSONException.
     * 
     * @param friendsWithPostArray JSONArray con todos los amigos que han escrito comentarios en el muro del usuario.
     * @param actorId Identificador de un amigo.
     * @return false si no est? en el array y true en caso contrario.
     * @throws JSONException 
     */
    public boolean isInArrayPost(JSONArray friendsWithPostArray, String actorId) throws JSONException{
        boolean isInArray = false;
        
        for(int i=0; i < friendsWithPostArray.length() ; i++){
            if(friendsWithPostArray.get(i).equals(actorId)){
                isInArray = true;
                break;
            }
        }
        
        return isInArray;
    }
    
    /** 
     * Obtiene un JSONArray con todos los amigos que han escrito en el muro del usuario. Podr? lanzar excepciones del tipo JSONException.
     * 
     * @param postStreamArray Comentarios de los amigos en base de datos.
     * @return JSONArray con los identificadores de los amigos que han publicado comentarios en el muro del usuario.
     * @throws JSONException 
     */
    public JSONArray getFriendsWithPost(JSONArray postStreamArray) throws JSONException{
        JSONArray friendsWithPostArray = new JSONArray();
        int cont = 0;
        
        for(int i=0; i < postStreamArray.length(); i++){
            if(!isInArrayPost(friendsWithPostArray, postStreamArray.getJSONObject(i).getString("actorId"))){
                friendsWithPostArray.put(cont, postStreamArray.getJSONObject(i).getString("actorId"));
                cont++;
            }
        }
        
        return friendsWithPostArray;
    }
    
    /**
     * Obtiene una lista con los diez amigos que mas comentarios y entradas en el
     * muro del usuario han realizado hasta una fecha determinada. Si el chequeo se realiza
     * por primera vez, tomara todos los comentarios del muro del usuario. Si no es asi,
     * tomara todos los comentarios realizados hasta la fecha indicada por el filtro de visitas.
     * Podr? lanzar excepciones del tipo JSONException.
     *
     * @param firstCheck Indica si es el primer chequeo en el filtro que se realiza.
     * @return Lista en formato HTML del ranking de amigos con mas interacciones en el muro del usuario.
     */
    private String getRankingPostFriends(boolean firstCheck) throws JSONException{
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getRankingPostFriends: Inicio getRankingPostFriends...");
        String resultado = "";
        Long uidLong = (new Double(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid().toString())).longValue();
        String userFacebook = null;

        if (firstCheck) {
            userFacebook = this.snsObject.getClient().userFacebook_getStreamFacebookByUid(String.class, "'" + uidLong.toString() + "'");
        } else {
            Date lastCheck = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getLastCheck();
            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getRankingPostFriends: Buscando entradas en el muro de Facebook hasta la fecha de actualizaci?n: " + formateador.format(lastCheck));
            userFacebook = this.snsObject.getClient().userFacebook_getStreamFacebookByUpdatedTime(String.class, "\"" + this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + "\"", "'" + formateador.format(lastCheck) + "'");
        }

        if (userFacebook != null) {
            JSONArray jsonUserStreamFacebook = (new JSONObject(userFacebook)).getJSONArray("streamFacebook");
            JSONArray friendsWithPostArray = getFriendsWithPost(jsonUserStreamFacebook);
            JSONArray jsonCountElementsStream = new JSONArray();

            for (int i = 0; i < friendsWithPostArray.length(); i++) {
                JSONArray postsOfFriendArray = null;

                try {
                    JSONObject postsOfFriends = new JSONObject();
                    try {

                        if (firstCheck) {
                            postsOfFriends = new JSONObject(this.snsObject.getClient().streamFacebook_getStreamPostByActorId(String.class, "'" + uidLong.toString() + "'", "'" + friendsWithPostArray.get(i).toString() + "'"));
                            postsOfFriendArray = postsOfFriends.getJSONArray("streamFacebook");
                        } else {
                            Date lastCheck = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getLastCheck();
                            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                            postsOfFriends = new JSONObject(this.snsObject.getClient().streamFacebook_getStreamPostByActorIdAndUpdateTime(String.class, "'" + uidLong.toString() + "'", "'" + friendsWithPostArray.get(i).toString() + "'", "'" + formateador.format(lastCheck) + "'"));
                            postsOfFriendArray = postsOfFriends.getJSONArray("streamFacebook");
                        }
                    } catch (JSONException e) {
                        postsOfFriendArray = new JSONArray();
                        postsOfFriendArray.put(postsOfFriends.getJSONObject("streamFacebook"));
                    }
                    
                    int countNumberStream = postsOfFriendArray.length();

                    for (int j = 0; j < postsOfFriendArray.length(); j++) {
                        countNumberStream = countNumberStream + getCommentsNumberPost(friendsWithPostArray.getString(i), postsOfFriendArray.getJSONObject(j).getString("postId"), firstCheck);
                    }

                    if (!friendsWithPostArray.getString(i).equals(uidLong.toString())) {
                        JSONObject itemCount = new JSONObject();
                        itemCount.put("actorId", friendsWithPostArray.getString(i));
                        itemCount.put("numbersOfPost", countNumberStream);
                        jsonCountElementsStream.put(itemCount);
                    }
                } catch (JSONException e) {
                    logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getRankingPostFriends: No existen comentarios para el amigo: " + friendsWithPostArray.getString(i));
                    logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getRankingPostFriends: Excepcion capturada JSONException: " + e.getMessage());
                }

            }

//            for (int i = 0; i < jsonUserStreamFacebook.length(); i++) {
//                JSONObject jsonStream = jsonUserStreamFacebook.getJSONObject(i);
//                int countNumberStream = 0;
//
//                for (int j = 0; j < jsonUserStreamFacebook.length(); j++) {
//                    if (jsonUserStreamFacebook.getJSONObject(j).getString("actorId").equals(jsonStream.getString("actorId"))) {
//                        countNumberStream++;
//                    }
//                    countNumberStream = countNumberStream + getCommentsNumberPost(jsonStream.getString("actorId"), jsonStream.getString("postId"), firstCheck);
//                    
//                }
//
//                if (!jsonStream.getString("actorId").equals(uidLong.toString())) {
//                    JSONObject itemCount = new JSONObject();
//                    itemCount.put("actorId", jsonStream.getString("actorId"));
//                    itemCount.put("numbersOfPost", countNumberStream);
//                    jsonCountElementsStream.put(itemCount);
//                }
//            }

//            for (int i = 0; i < jsonUserStreamFacebook.length(); i++) {
//                JSONObject jsonStream = jsonUserStreamFacebook.getJSONObject(i);
//                int countNumberStream = 0;
//                
//                if(firstCheck){
//                    countNumberStream = this.snsObject.getClient().streamFacebook_getNumberStreamPostActorId(Integer.class, "'" + uidLong.toString() + "'", "'" + jsonStream.getString("actorId") + "'");
//                }else{
//                    Date lastCheck = this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getFltVist().getLastCheck();
//                    SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//                    countNumberStream = this.snsObject.getClient().streamFacebook_getNumberStreamPostActorIdByUpdatedTime(Integer.class, "'" + uidLong.toString() + "'", jsonStream.getString("actorId"), "'" + formateador.format(lastCheck) + "'");
//                }
//                
//                countNumberStream = countNumberStream + getCommentsNumberPost(jsonStream.getString("actorId"), jsonStream.getString("postId"), firstCheck);
//                
//                if (!jsonStream.getString("actorId").equals(uidLong.toString())) {
//                    JSONObject itemCount = new JSONObject();
//                    itemCount.put("actorId", jsonStream.getString("actorId"));
//                    itemCount.put("numbersOfPost", countNumberStream);
//                    jsonCountElementsStream.put(itemCount);
//                }
//            }

            HashMap<String, Integer> orderPost = shortMap(parseJsonArrayToMap(jsonCountElementsStream));
            List<String> lstKey = new ArrayList<String>(orderPost.keySet());
            List<Integer> lstVal = new ArrayList<Integer>(orderPost.values());

            int longComm = (orderPost.size() <= 10) ? orderPost.size() : 10;

            resultado = "<table><tr><td width=\"95%\"><br><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color: #3b5998;margin:5px;\">"
                    + this.titleOptions[2]
                    + "</div><hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /></td></tr><tr><td><table width=\"97%\">";

            for (int i = 0; i < longComm; i++) {
                String query = "SELECT uid,name,birthday_date,pic_square FROM user WHERE uid=" + lstKey.get(i);

                List<FriendsFacebook> friendsFacebookList = this.snsObject.getFacebookQueryClient().executeQuery(query, FriendsFacebook.class);

                resultado = resultado + "<tr>"
                        + "<td width=100px><img src='" + friendsFacebookList.get(0).getPicSquare() + "'/></td>"
                        + "<td width='286px'>" + friendsFacebookList.get(0).getName() + "</td>"
                        + "<td width='286px'>" + lstVal.get(i) + "</td>"
                        + "</tr>";
            }

            resultado = resultado + "</table></tr></td></table>";
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getRankingPostFriends: Fin getRankingPostFriends...");
        return resultado;
    }

    /**
     * Convierte un JSONArray en un HashMap para proceder a su posterior ordenacion.
     *
     * @param jsonArray JSONArray con los valores de la lista.
     * @return HashMap con los valores del JSONArray.
     */
    private HashMap<String,Integer> parseJsonArrayToMap(JSONArray jsonArray){
        HashMap<String, Integer> mapArray = new HashMap<String, Integer>();

        for(int i = 0; i < jsonArray.length(); i++){
            try {
                mapArray.put(jsonArray.getJSONObject(i).getString("actorId"), Integer.parseInt(jsonArray.getJSONObject(i).getString("numbersOfPost")));
            } catch (JSONException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
        
        return mapArray;
    }

    /**
     * Ordena un HashMap en orden descendente de mayor a menor.
     *
     * @param map HashMap sin ordenar.
     * @return HashMap ordenado.
     */
    private HashMap<String, Integer> shortMap(HashMap<String, Integer> map) {

        LinkedHashMap newMap = new LinkedHashMap();
        ArrayList values = new ArrayList(map.values());
        Collections.sort(values, Collections.reverseOrder());
        Iterator it = values.iterator();
        Object tmp = 0;
        while (it.hasNext()) {
            tmp = it.next();
            for (Map.Entry k : map.entrySet()) {
                if (tmp == k.getValue()) {
                    newMap.put(k.getKey(), k.getValue());
                }
            }
        }

        return newMap;
    }
}
