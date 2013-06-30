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
 * Informacion de los comentarios a un post en Facebook.
 * 
 * @author tote
 */
public class StreamCommentsFacebook extends GenericDataFacebook{

    @Facebook("xid")
    String xid;

    @Facebook("object_id")
    String objectId;

    @Facebook("post_id")
    String postId;

    @Facebook("fromid")
    String fromId;

    @Facebook("time")
    String time;

    @Facebook("text")
    String text;

    @Facebook("id")
    String id;

    @Facebook("username")
    String username;

    @Facebook("reply_xid")
    String replyXid;

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getReplyXid() {
        return replyXid;
    }

    public void setReplyXid(String replyXid) {
        this.replyXid = replyXid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public JSONObject toJson(){

        JSONObject json = null;

        try {

            json = new JSONObject();
            json.put("xid", this.xid);
            json.put("objectId", this.objectId);
            json.put("postId", this.postId);
            json.put("fromid", this.fromId);
            json.put("timeComment", this.time);
            json.put("text", this.text);
            json.put("id", this.id);
            json.put("username", this.username);
            json.put("replyXid", this.replyXid);

            return json;
        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
}
