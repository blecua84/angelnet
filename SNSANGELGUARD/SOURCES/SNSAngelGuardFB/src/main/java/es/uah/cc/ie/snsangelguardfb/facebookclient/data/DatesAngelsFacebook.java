/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.facebookclient.data;

import com.restfb.Facebook;
import es.uah.cc.ie.snsangelguardfb.facebookclient.GenericDataFacebook;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.openide.util.Exceptions;

/**
 * Informacion de Facebook correspondiente a los angeles de la aplicacion.
 * 
 * @author tote
 */
public class DatesAngelsFacebook extends GenericDataFacebook {
    @Facebook("uid")
    String uid;

    @Facebook("email")
    String email;

    @Facebook("name")
    String name;

    @Facebook("pic_square")
    String picSquare;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicSquare() {
        return picSquare;
    }

    public void setPicSquare(String picSquare) {
        this.picSquare = picSquare;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public JSONObject toJson() {
        try {
            JSONObject json = null;
            json = new JSONObject();
            json.put("uid", this.uid);
            json.put("name", this.name);
            json.put("email", this.email);
            json.put("picSquare", this.picSquare);
            return json;
        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
}
