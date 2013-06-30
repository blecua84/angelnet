/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.facebookclient;

import org.codehaus.jettison.json.JSONObject;

/**
 * Clase gen?rica de parseo de datos de Facebook.
 * 
 * @author tote
 */
public abstract class GenericDataFacebook {

    /**
     * Parsea todos los datos de la clase a un objeto JSON.
     * 
     * @return JSONObject con todos los datos obtenidos. 
     */
    public abstract JSONObject toJson();
}
