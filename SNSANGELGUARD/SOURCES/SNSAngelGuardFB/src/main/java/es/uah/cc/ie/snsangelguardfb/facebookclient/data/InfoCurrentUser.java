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
 * Informacion de Facebook correspondiente al usuario conectado actualmente.
 * 
 * @author tote
 */
public class InfoCurrentUser extends GenericDataFacebook {

    @Facebook("uid")
    String uid;
    
    @Facebook("name")
    String name;

    @Facebook("email")
    String email;

    
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = null;

        try {

            json = new JSONObject();
            json.put("uid", this.uid);
            json.put("name", this.name);
            json.put("email", this.email);

        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
        }

        return json;
    }
}
