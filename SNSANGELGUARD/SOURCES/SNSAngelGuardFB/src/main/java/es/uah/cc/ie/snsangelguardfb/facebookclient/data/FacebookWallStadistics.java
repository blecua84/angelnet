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
 * Informacion adicional de un comentario en Facebook.
 * 
 * @author tote
 */
public class FacebookWallStadistics extends GenericDataFacebook{

    @Facebook("actor_id")
    String actorId;

    @Facebook("target_id")
    String targetId;

    @Facebook("likes")
    String likes;

    @Facebook("comments")
    String comments;

    @Override
    public JSONObject toJson() {
        try {
            JSONObject json = null;
            json = new JSONObject();

            json.put("actor_id", this.actorId);
            json.put("target_id", this.targetId);
            json.put("likes", this.likes);
            json.put("comments", this.comments);
            return json;
        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

}
