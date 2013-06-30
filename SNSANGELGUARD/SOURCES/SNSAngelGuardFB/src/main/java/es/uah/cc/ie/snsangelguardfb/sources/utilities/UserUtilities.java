/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.snsangelguardfb.sources.utilities;

import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Clases de utilidad para un usuario de la aplicacion.
 * 
 * @author tote
 */
public class UserUtilities {

    /** Manager de la aplicacion */
    private SNSAngelGuardFBManager snsObject;

    /**
     * Constructor de clase.
     * 
     * @param snsObject 
     */
    public UserUtilities(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    public SNSAngelGuardFBManager getSnsObject() {
        return snsObject;
    }

    public void setSnsObject(SNSAngelGuardFBManager snsObject) {
        this.snsObject = snsObject;
    }

    /**
     * Obtiene la url de la imagen de un contacto de Facebook. Podra lanzar excepciones del tipo JSONException.
     * 
     * @param uid: Id del contacto de Facebook
     * @return url con la ruta de la imagen del contacto de Facebook
     * @throws JSONException
     */
    public String getImgUser(String uid) throws JSONException {
        String respuesta = this.snsObject.getClient().userFacebook_getUserFacebookByUid(String.class, uid);
        JSONObject jsonUserFacebook = new JSONObject(respuesta);

        return jsonUserFacebook.getString("picSquare");
    }
}
