/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.utilities;

import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Clase de utilidad para objetos JSONObject.
 * 
 * @author tote
 */
public class JSONUtilities {

    /** Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;

    /** 
     * Constructor de clase.
     * 
     * @param snsObject 
     */
    public JSONUtilities(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Convierte una cadena de texto a JSONArray. Puede lanzar excepciones del tipo JSONException.
     * 
     * @param strValue
     * @return
     * @throws JSONException 
     */
    public JSONArray getJSONArray(String strValue) throws JSONException {
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

        return jsonArray;
    }

    /**
     * Convierte una cadena de texto en la que hay en formato JSONObject varios objetos y devuelve un JSONObject con todos ellos.
     * Puede lanzar excepciones del tipo JSONException.
     * 
     * @param strValue
     * @return
     * @throws JSONException 
     */
    public JSONObject getJSONColection(String strValue) throws JSONException {
        JSONObject jsonObject = null;

        if (!strValue.equals("{}") && !strValue.equals("[]") && !strValue.equals("[{}]") && !strValue.contains("error_code")) {
            if (strValue.substring(0, 1).equals("[") && strValue.substring(strValue.length() - 1, strValue.length()).equals("]")) {
                String auxValue = strValue.substring(1, strValue.length() - 1);
                strValue = "{" + auxValue + "}";
            }

            jsonObject = new JSONObject(strValue);
        }
        return jsonObject;
    }

    /**
     * Convierte una cadena de texto sin formatear en un objeto JSONObject. Puede lanzar excepciones del tipo JSONException.
     * 
     * @param strValue
     * @return
     * @throws JSONException 
     */
    public static JSONObject getJSONObject(String strValue) throws JSONException {
        JSONObject jsonObject = null;

        if (!strValue.equals("{}") && !strValue.equals("[]") && !strValue.equals("[{}]") && !strValue.contains("error_code")) {
            if (strValue.substring(0, 1).equals("[") && strValue.substring(strValue.length() - 1, strValue.length()).equals("]")) {
                String auxValue = strValue.substring(1, strValue.length() - 1);
                strValue = auxValue;
            }

            jsonObject = new JSONObject(strValue);
        }
        return jsonObject;
    }

    /**
     * Convierte una cadena de texto formateada a JSON en un objeto JSONObject. Puede lanzar excepciones del tipo JSONException.
     * 
     * @param strValue
     * @return
     * @throws JSONException 
     */
    public static JSONObject completStrToJSONObject(String strValue) throws JSONException {
        JSONObject json = null;
        String aux = strValue;

        if (!strValue.equals("{}")  && !strValue.contains("error_code")) {
            if (strValue.substring(0, 1).equals("{")) {
                aux = strValue.substring(1, strValue.length());
            }
            if (strValue.substring(strValue.length() - 1, strValue.length()).equals("}")){
                aux = aux.substring(0, aux.length() - 1);
            }

            String[] partJson = aux.split(",");
            json = new JSONObject();

            for(int i = 0; i < partJson.length; i++){
                if(partJson[i].contains("user_id") || partJson[i].contains("oauth_token")){
                    String auxValue = partJson[i];
                    auxValue = auxValue.replaceAll("\"", "");
                    String[] val = auxValue.split(":");
                    if(val.length >= 2){
                        json.put(val[0], val[1]);
                    }
                }
            }
        }
        
        return json;
    }

}
