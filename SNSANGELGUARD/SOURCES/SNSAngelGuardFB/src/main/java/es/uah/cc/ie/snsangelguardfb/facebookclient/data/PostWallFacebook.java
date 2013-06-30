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
 * Informacion correspondiente a una entrada en el muro de Facebook.
 * 
 * @author tote
 */
public class PostWallFacebook extends GenericDataFacebook{

    @Facebook("post_id")
    String postId;

    @Facebook("viewer_id")
    String viewerId;

    @Facebook("app_id")
    String appId;

    @Facebook("source_id")
    String sourceId;

    @Facebook("updated_time")
    String updatedTime;

    @Facebook("created_time")
    String createdTime;

    @Facebook("filter_key")
    String filterKey;

    @Facebook("attribution")
    String attribution;

    @Facebook("actor_id")
    String actorId;

    @Facebook("target_id")
    String targetId;

    @Facebook("message")
    String message;

    @Facebook("app_data")
    String appData;

    @Facebook("attachment")
    String attachment;

    @Facebook("type")
    String type;

    @Facebook("permalink")
    String permalink;

    @Facebook("xid")
    String xid;

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getAppData() {
        return appData;
    }

    public void setAppData(String appData) {
        this.appData = appData;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getFilterKey() {
        return filterKey;
    }

    public void setFilterKey(String filterKey) {
        this.filterKey = filterKey;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getViewerId() {
        return viewerId;
    }

    public void setViewerId(String viewerId) {
        this.viewerId = viewerId;
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

            json.put("postId", this.postId);
            json.put("appId", this.appId);
            json.put("createdTime", this.createdTime);
            json.put("xid", this.xid);
            json.put("targetId", this.targetId);
            json.put("attachment", this.attachment);
            json.put("type", this.type);
            json.put("viewerId", this.viewerId);
            json.put("sourceId", this.sourceId);
            json.put("message", this.message);
            json.put("permalink", this.permalink);
            json.put("actorId", this.actorId);
            json.put("appData", this.appData);
            json.put("filterKey", this.filterKey);
            json.put("attribution", this.attribution);
            json.put("updatedTime", this.updatedTime);

            return json;
        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }

}
