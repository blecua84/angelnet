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
 * Informacion correspondiente a cada amigo en Facebook.
 * 
 * @author tote
 */
public class FriendsFacebook extends GenericDataFacebook{

    @Facebook("uid")
    String uid;

    @Facebook("name")
    String name;

    @Facebook("birthday_date")
    String birthdayDate;

    @Facebook("pic_square")
    String picSquare;

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPicSquare() {
        return picSquare;
    }

    public void setPicSquare(String picSquare) {
        this.picSquare = picSquare;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = null;

        try {

            json = new JSONObject();
            json.put("userUid", this.uid);
            json.put("userName", this.name);
            json.put("userBirthday", "");
            json.put("userPic", this.picSquare);

        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
        }

        return json;
    }
}
