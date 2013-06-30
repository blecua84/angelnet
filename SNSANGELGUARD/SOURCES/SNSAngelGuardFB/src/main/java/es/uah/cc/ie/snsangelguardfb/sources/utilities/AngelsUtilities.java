/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.utilities;

import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.facebookclient.data.DatesAngelsFacebook;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Clase sin entidad propia que realiza tareas de utilidad con los angeles de un usuario.
 *
 * @author tote
 */
public class AngelsUtilities {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(AngelsUtilities.class);

    /** Manager principal de la aplicacion */
    private SNSAngelGuardFBManager snsObject;

    /** Array con todos los angeles del usuario */
    private String[][] arrayAngels;

    /** Array con los angeles seleccionados de un usuario */
    private String[][] arrayAngelsSelected;

    /**
     * Constructor de la clase.
     *
     * @param snsObject SNSAngelGuardFBManager
     */
    public AngelsUtilities(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
        this.arrayAngels = null;
        this.arrayAngelsSelected = null;
    }

    /**
     * Obtiene el array de ?ngeles.
     *
     * @return String[][] con todos los ?ngeles del usuario.
     */
    public String[][] getArrayAngels() {
        return arrayAngels;
    }

    /**
     * Establece el array de ?ngeles del usuario.
     *
     * @param arrayAngels String[][] con todos los ?ngeles del usuario.
     */
    public void setArrayAngels(String[][] arrayAngels) {
        this.arrayAngels = arrayAngels;
    }

    /**
     * Obtiene el array de ?ngeles seleccionados de un usuario.
     *
     * @return String[][] array de ?ngeles seleccionados.
     */
    public String[][] getArrayAngelsSelected() {
        return arrayAngelsSelected;
    }

    /**
     * Establece el array de ?ngeles seleccionados de un usuario.
     *
     * @param arrayAngelsSelected String[][] array de ?ngeles seleccionados.
     */
    public void setArrayAngelsSelected(String[][] arrayAngelsSelected) {
        this.arrayAngelsSelected = arrayAngelsSelected;
    }

    /**
     * Obtiene de Facebook todos los datos de un angel.
     *
     * @param angelUid Identificador del ?ngel.
     * @return String[] con todos los datos del ?ngel.
     */
    public String[] getAngelDates(String angelUid) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelDates: Inicio getAngelDates...");

        String[] angelArray = new String[4];

        String query = "SELECT uid,email,name,pic_square FROM user WHERE uid=" + angelUid + ";";
        List<DatesAngelsFacebook> datesAngelsList = this.snsObject.getFacebookQueryClient().executeQuery(query, DatesAngelsFacebook.class);

        if(!datesAngelsList.isEmpty()){
            System.out.println(datesAngelsList.get(0).toJson().toString());
            angelArray[0] = getEmailUserSNSAngelGuard(datesAngelsList.get(0).getUid());
            angelArray[1] = datesAngelsList.get(0).getName().replace("'", "");
            angelArray[2] = datesAngelsList.get(0).getPicSquare();
            angelArray[3] = "F";
        }else{
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelDates: Fin getAngelDates con resultado nulo...");
            return null;
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelDates: Fin getAngelDates con resultado ok...");
        return angelArray;
    }

    /**
     * Obtiene el email de un amigo de Facebook unicamente si este esta dado de alta como
     * usuario de la aplicacion.
     *
     * @param uid Identificador del usuario
     * @return El email del usuario en caso correcto o null en caso contrario.
     */
    private String getEmailUserSNSAngelGuard(String uid){
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getEmailUserSNSAngelGuard: Inicio getEmailUserSNSAngelGuard...");
        try {
            JSONObject jsonObject;
            try {
                Long uidLong = (new Double(uid)).longValue();
                jsonObject = this.snsObject.getClient().userSettings_getUserSettingsByUid(JSONObject.class, uidLong.toString());
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getEmailUserSNSAngelGuard: Email usuario: " + jsonObject.getString("userEmail"));
                this.snsObject.setNewConnection(false);
            } catch (Exception e) {
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getEmailUserSNSAngelGuard: El usuario " + uid + " no existe en la aplicaci?n como usuario");
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getEmailUserSNSAngelGuard: Fin getEmailUserSNSAngelGuard con resultado nulo...");
                return null;
            }
            return jsonObject.getString("userEmail");
        } catch (JSONException ex) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getEmailUserSNSAngelGuard: Excepcion capturada JSONException: " + ex.getMessage());
            logger.fatal(ex);
            return null;
        }
    }

    /**
     * Obtiene de un String separado por ; todos los angeles seleccionados y los
     * almacena en la variable arrayAngelsSelected.
     *
     * @param angelsSelected String con los ?ngeles seleccionados.
     * @throws JSONException
     */
    public void getAngelsSelected(String angelsSelected) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsSelected: Inicio getAngelsSelected...");
        String[][] arrayAng = this.getArrayAngels();
        String[][] newArray = null;
        String[] arrayAnSel = null;

        if (!angelsSelected.equals("")) {
            arrayAnSel = angelsSelected.split(";");
            newArray = new String[arrayAnSel.length][4];

            for (int i = 0; i < arrayAnSel.length; i++) {
                for (int j = 0; j < arrayAng.length; j++) {
                    if (arrayAnSel[i].equals(arrayAng[j][0])) {
                        newArray[i] = arrayAng[j];
                    }
                }
            }
        }
        this.setArrayAngelsSelected(newArray);
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsSelected: Fin getAngelsSelected...");
    }

    /**
     * Devuelve una lista con el numero de angeles seleccionados indicado por el
     * parametro de entrada longArray.
     *
     * @param longArray Numero de ?ngeles a seleccionar.
     * @return Lista con los ?ngeles seleccionados determinado por el numero longArray.
     */
    public String[][] copyAngel(int longArray) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - copyAngel: Inicio copyAngel...");
        String[][] arrayHdAngels = new String[longArray][3];
        String[][] lstAngel = this.getArrayAngelsSelected();
        String[] vacio = new String[4];

        vacio[0] = "";
        vacio[1] = "";
        vacio[2] = "";
        vacio[3] = "";

        int longArrayAngels = lstAngel.length;

        for (int i = 0; i < longArrayAngels; i++) {
            if (lstAngel[i] != null) {
                arrayHdAngels[i] = lstAngel[i];
            } else {
                arrayHdAngels[i] = vacio;
            }
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - copyAngel: Fin copyAngel...");
        return arrayHdAngels;
    }

    /**
     * Une en una sola lista los angeles de diferente topologia, tales como Ed o Google.
     *
     * @param newAngels Angeles seleccionados por el usuario.
     * @param des Tipo de Angel
     * @param Type Abreviatura del tipo de angel.
     * @throws JSONException
     */
    public void genericJoinListAngel(String newAngels, String des, String Type) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - genericJoinListAngel: Inicio genericJoinListAngel...");
        if (!newAngels.equals("")) {
            String[] arrayNewAngels = newAngels.split(";");
            int longInicio = 0;
            int longArray = 0;
            String[][] arrayHdAngels = null;

            try {
                longInicio = this.getArrayAngelsSelected().length;

                longArray = arrayNewAngels.length + this.getArrayAngelsSelected().length;
                arrayHdAngels = copyAngel(longArray);
            } catch (Exception ex) {
                longArray = arrayNewAngels.length;
                arrayHdAngels = new String[longArray][4];
            }

            JSONObject jsonAngel = null;

            for (int i = 0; i < arrayNewAngels.length; i++) {

                jsonAngel = new JSONObject(arrayNewAngels[i]);
                String[] datesArray = new String[4];

                datesArray[0] = jsonAngel.getString("emailAngel" + des);
                datesArray[1] = jsonAngel.getString("nameAngel" + des);
                datesArray[2] = "../SNSAngelGuardFB/resources/perfilStandar.gif";
                datesArray[3] = Type;

                arrayHdAngels[longInicio + i] = datesArray;
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - genericJoinListAngel: Datos del array en la posicion " + (longInicio + i) + ": " + arrayHdAngels[longInicio + i][0] + "," + arrayHdAngels[longInicio + i][1] + "," + arrayHdAngels[longInicio + i][2] + "," + arrayHdAngels[longInicio + i][3]);

            }

            for (int j = 0; j < longArray; j++) {
                System.out.println(arrayHdAngels[j][0] + ',' + arrayHdAngels[j][1] + ',' + arrayHdAngels[j][2] + "," + arrayHdAngels[j][3]);
            }

            this.setArrayAngelsSelected(arrayHdAngels);
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - genericJoinListAngel: Fin genericJoinListAngel...");
    }

    /**
     * Une los angeles Ed y Google en una sola lista.
     *
     * @param angelsGoogle
     * @param angelsEd
     * @throws JSONException
     */
    public void joinAngels(String angelsGoogle, String angelsEd) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - joinAngels: Inicio joinAngels...");
        genericJoinListAngel(angelsGoogle, "GoogleSelected", "G");
        genericJoinListAngel(angelsEd, "Ed", "O");
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - joinAngels: Fin joinAngels...");
    }

    /**
     * Obtiene de Facebook todos los amigos para mostrarlos por pantalla como angeles a seleccionar.
     * Podra lanzar excepciones del tipo UniformInterfaceException, IOException o JSONException.
     *
     * @return Lista con todos los amigos de Facebook.
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws JSONException
     */
    public String[][] getAngels() throws UniformInterfaceException, IOException, JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngels: Inicio getAngels...");
        String lstFriends = "";

        //lstFriends = this.snsObject.execFbInst(1);
        List<String> myFriends = this.snsObject.getFacebookRestClient().executeForList("friends.get", String.class);
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngels: Numero de amigos en Facebook: " + myFriends.size());
        String[] datesArray = new String[4];

        if (myFriends != null) {
            String[][] angelsDates = new String[myFriends.size()][4];
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngels: Numero de Angeles: " + myFriends.size());

            for (int i = 0; i < myFriends.size(); i++) {
                datesArray = getAngelDates(myFriends.get(i));
                if (datesArray != null) {
                    angelsDates[i] = datesArray;
                }
            }

            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngels: Fin getAngels...");
            return angelsDates;
        } else {
           logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngels: Fin getAngels con resultado nulo...");
           return null;
        }
    }

    /**
     * Obtiene todos los datos de un angel almacenado en la base de datos y los
     * almacena a un array de String desde un JSONObject.
     *
     * @param jsonAngel JSONObject con todos los datos de un angel.
     * @return String[] con los datos del angel.
     */
     public String[] getAngelDatesDB(JSONObject jsonAngel) {
         logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelDatesDB: Inicio getAngelDatesDB...");

        String[] angelArray = new String[4];

        if(jsonAngel != null){
            try {
                angelArray[0] = getEmailUserSNSAngelGuard(jsonAngel.getString("userUid"));
                angelArray[1] = jsonAngel.getString("userName").replace("'", "");
                angelArray[2] = jsonAngel.getString("userPic");
                angelArray[3] = "F";
            } catch (JSONException ex) {
                logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelDatesDB: Excepcion capturada JSONException: " + ex.getMessage());
                logger.fatal(ex);
            }
        }else{
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelDatesDB: Fin getAngelDatesDB con resultado nulo...");
            return null;
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelDatesDB: Fin getAngelDatesDB...");
        return angelArray;
    }

     /**
      * Obtiene todos los amigos de Facebook almacenados en la base de datos y los formatea
      * a un array de String[][] para ser mostrados por pantalla. Podra lanzar excepciones del tipo
      * UniformInterfaceException, IOException o JSONException.
      *
      * @param jsonFriendsFacebook
      * @return String[][]
      * @throws UniformInterfaceException
      * @throws IOException
      * @throws JSONException
      */
    public String[][] getAngelsDB(JSONArray jsonFriendsFacebook) throws UniformInterfaceException, IOException, JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsDB: Inicio getAngelsDB...");
        String[] datesArray = new String[4];

        if (jsonFriendsFacebook != null) {
            String[][] angelsDates = new String[jsonFriendsFacebook.length()][4];
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsDB: Numero de angeles: " + jsonFriendsFacebook.length());

            for (int i = 0; i < jsonFriendsFacebook.length(); i++) {
                datesArray = getAngelDatesDB(jsonFriendsFacebook.getJSONObject(i));
                if (datesArray != null) {
                    angelsDates[i] = datesArray;
                }
            }
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsDB: Fin getAngelsDB...");
            return angelsDates;
        } else {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getAngelsDB: Fin getAngelsDB con resultado nulo...");
            return null;
        }
    }

    /**
     * Indica si un amigo de facebook esta dentro de los seleccionados como angeles del usuario.
     *
     * @param angels
     * @param idAngel
     * @return
     */
    public boolean isAngelSelect(String[] angels, String idAngel) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isAngelSelect: Inicio isAngelSelect para el ?ngel: " + idAngel);
        for (int i = 0; i < angels.length; i++) {
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isAngelSelect: Angel elegido: " + idAngel);
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isAngelSelect: Angel actual: " + angels[i]);
            if (angels[i].equals(idAngel)) {
                logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isAngelSelect: El amigo " + idAngel + " est? seleccionado como angel del usuario");
                return true;
            }
        }

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - isAngelSelect: El amigo " + idAngel + " no est? seleccionado como angel del usuario");
        return false;
    }
    
    /**
     * Obtiene un JSONArray con la lista de los angeles elegidos. Puede lanzar exceptiones del tipo JSONException o IOException.
     * @param angels
     * @param lstAngels
     * @param txtNameAngels
     * @return
     * @throws JSONException
     * @throws IOException
     */
    public JSONArray loadAngelFile(String[][] angels, String lstAngels, String txtNameAngels) throws JSONException, IOException {
        JSONArray angelsArray = new JSONArray();
        String[] angelsSelec = lstAngels.split(";");

        int cont = 0;

        for (int i = 0; i < angels.length; i++) {
            if (isAngelSelect(angelsSelec, angels[i][0])) {
                SNSAngelGuardFBManager.getLogger().info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + ": ELEGIDO: " + angels[i][0]);
                angelsArray.put(cont, angels[i][1]);
                cont++;
            }
        }

        if (!txtNameAngels.equals("")) {
            angelsArray.put(cont, txtNameAngels);
        }

        return angelsArray;
    }

    /**
     * Obtiene los datos de un angel en un objeto JSON de la base de datos en el caso en el que existiera. Podra lanzar excepciones del tipo JSONException.
     * 
     * @param idAngel
     * @param uid
     * @return
     * @throws JSONException
     */
    public JSONObject getJsonAngel(String idAngel, String uid) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonAngel: Inicio getJsonAngel para el angel: " + idAngel + "...");
        String respuesta = "";
        JSONObject jsonRespuesta = null;
        JSONObject jsonAngel = null;
        JSONObject jsonAngelFinal = null;
        JSONArray jsonArrayAngels = null;
        boolean encontrado = false;

        respuesta = this.snsObject.getClient().settingsAngels_getAngelsByUid(String.class, "\"" + uid + "\"");
       logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonAngel: Respuesta de base de datos: " + respuesta);
        jsonRespuesta = new JSONObject(respuesta);
        jsonArrayAngels = this.snsObject.getJsonUtilities().getJSONArray(jsonRespuesta.getString("settingsAngels"));
        logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonAngel: Angel Buscado: " + idAngel);
        for (int i = 0; i < jsonArrayAngels.length(); i++) {
            jsonAngel = jsonArrayAngels.getJSONObject(i);
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonAngel: Angel " + i + ": " + jsonAngel.getString("uidAngel"));
            if (jsonAngel.getString("uidAngel").equals(idAngel)) {
                encontrado = true;
                jsonAngelFinal = jsonAngel;
                break;
            }
        }

        if (!encontrado) {
            jsonAngelFinal = new JSONObject();
        }
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getJsonAngel: Fin getJsonAngel para el angel: " + idAngel + " - Datos: " + jsonAngelFinal.toString());
        return jsonAngelFinal;
    }

    /**
     * Actualiza en base de datos la informacion de un angel. Puede lanzar excepciones del tipo JSONException.
     * 
     * @param jsonAngel
     * @throws JSONException
     */
    public void setJsonAngel(JSONObject jsonAngel) throws JSONException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setJsonAngel: Inicio setJsonAngel para el angel: " + jsonAngel.getString("uidAngel") + "...");
        try {
            this.snsObject.getClient().userSettings_setNewAngelsCollectionByUid(String.class, jsonAngel.getString("uidAngel"), jsonAngel);
        } catch (Exception e) {
            logger.error(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setJsonAngel: Excepcion capturada Exception: " + e.getMessage());
            logger.fatal(e);
        }
        
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - setJsonAngel: Fin setJsonAngel para el angel: " + jsonAngel.getString("uidAngel") + "...");
    }

}
