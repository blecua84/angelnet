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
 * Informacion de un perfil de Facebook correspondiente a sus estadisticas.
 * 
 * @author tote
 */
public class FacebookUrlStadistics extends GenericDataFacebook {

    @Facebook("name")
    String name;

    @Facebook("pic_square")
    String picSquare;

    @Facebook("friend_count")
    String friendCount;

    @Facebook("mutual_friend_count")
    String mutualFriendCount;

    @Override
    public JSONObject toJson() {
        try {
            JSONObject json = null;
            json = new JSONObject();

            json.put("name", this.name);
            json.put("pic_square", this.picSquare);
            json.put("friend_count", this.friendCount);
            json.put("mutual_friend_count", this.mutualFriendCount);
            return json;
        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

}
