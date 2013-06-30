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
 * Informacion del codigo del idioma configurado en Facebook.
 * 
 * @author tote
 */
public class LocaleUserFacebook extends GenericDataFacebook {
    
    @Facebook("uid")
    String uid;

    @Facebook("locale")
    String locale;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    } 

    @Override
    public JSONObject toJson() {
        JSONObject json = null;
        
        try {    
            json = new JSONObject();

            json.put("uid", this.uid);
            json.put("locale", this.locale);
            return json;
        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
}
