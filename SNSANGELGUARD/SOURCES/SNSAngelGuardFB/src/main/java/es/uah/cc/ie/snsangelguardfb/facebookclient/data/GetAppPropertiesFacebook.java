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
 * Informacion de Facebook correspondiente a la aplicacion.
 * 
 * @author tote
 */
public class GetAppPropertiesFacebook extends GenericDataFacebook {

    @Facebook("app_id")
    String appId;

    @Facebook("publish_action")
    String publishAction;

    @Facebook("uninstall_url")
    String uninstallUrl;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getPublishAction() {
        return publishAction;
    }

    public void setPublishAction(String publishAction) {
        this.publishAction = publishAction;
    }

    public String getUninstallUrl() {
        return uninstallUrl;
    }

    public void setUninstallUrl(String uninstallUrl) {
        this.uninstallUrl = uninstallUrl;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = null;

        try {

            json = new JSONObject();
            json.put("appId", this.appId);
            json.put("publishAction", this.publishAction);
            json.put("uninstallUrl", this.uninstallUrl);

        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
        }

        return json;
    }
}
