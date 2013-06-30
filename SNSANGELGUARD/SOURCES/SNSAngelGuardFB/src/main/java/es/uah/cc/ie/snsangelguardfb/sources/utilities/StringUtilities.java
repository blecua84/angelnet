/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.utilities;

import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;

/**
 * Clase de utilidad para cadenas de texto de tipo String.
 * 
 * @author tote
 */
public class StringUtilities {

    /** Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;

    /** 
     * Constructor de clase.
     * 
     * @param snsObject 
     */
    public StringUtilities(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /** 
     * Formatea una cadena de parametros separada por el caracter ; en una cadena de parametros con el formato (..,..,..).
     * 
     * @param order
     * @param params
     * @return 
     */
    public String formatParams(String order, String params) {
        String[] arrayParams = params.split(";");

        String result = order + "(";

        for (int i = 0; i < arrayParams.length; i++) {
            SNSAngelGuardFBManager.getLogger().info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + ": PARAMETRO " + i + ": " + arrayParams[i]);
            result += arrayParams[i] + ',';
            SNSAngelGuardFBManager.getLogger().info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + ": RESULT: " + result);
        }

        if (result.substring(result.length() - 1, result.length()).equals(",")) {
            result = result.substring(0, result.length() - 1) + ");";
        } else if (result.substring(result.length() - 1, result.length()).equals("(")) {
            result += ");";
        }

        return result;
    }

    /**
     * Convierte un array de dos dimensiones en una cadena de texo con formato de JSONArray.
     * 
     * @param angels
     * @return 
     */
    public String arrayToString(String[][] angels) {
        String[][] array = angels;

        StringBuilder buff = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                buff.append(";");
            }
            buff.append("[");
            for (int j = 0; j < array[i].length; j++) {
                if (j > 0) {
                    buff.append(",");
                }
                buff.append(array[i][j]);
            }
            buff.append("]");
        }
        buff.append("]");
        String javascript = buff.toString();
        return javascript;
    }


    /**
     * Convierte una cadena de parametros separados por el caracter ; en un array de una dimension.
     * 
     * @param cadena
     * @return 
     */
    public String[] stringToArray(String cadena) {
        String[] arrayString = cadena.split(";");

        return arrayString;
    }
}
