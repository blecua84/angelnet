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
 * Informacion almacenada en Facebook correspondiente al perfil de usuario de
 * la aplicacion.
 *
 * @author tote
 */
public class InfoUser extends GenericDataFacebook {

    @Facebook("uid")
    String uid;

    @Facebook("sex")
    String sex;

    @Facebook("religion")
    String religion;

    @Facebook("relationship_status")
    String relationshipStatus;

    @Facebook("political")
    String political;

    @Facebook("activities")
    String activities;

    @Facebook("interests")
    String interests;

    @Facebook("is_app_user")
    String isAppUser;

    @Facebook("music")
    String music;

    @Facebook("tv")
    String tv;

    @Facebook("movies")
    String movies;

    @Facebook("books")
    String books;

    @Facebook("about_me")
    String aboutMe;

    @Facebook("status")
    String status;

    @Facebook("quotes")
    String quotes;


    
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    
    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getIsAppUser() {
        return isAppUser;
    }

    public void setIsAppUser(String isAppUser) {
        this.isAppUser = isAppUser;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    @Override
    public JSONObject toJson(){
        JSONObject json = null;
        try {
            json = new JSONObject();
            
            json.put("uid", this.uid);
            json.put("sex", this.sex);
            json.put("religion", this.religion);
            if (this.relationshipStatus == null){
                json.put("relationship_status", "");
            }else{
                json.put("relationship_status", this.relationshipStatus);
            }
            json.put("political", this.political);
            json.put("activities", this.activities);
            json.put("interests", this.interests);
            json.put("is_app_user", this.isAppUser);
            json.put("music", this.music);
            json.put("tv", this.tv);
            json.put("movies", this.movies);
            json.put("books", this.books);
            json.put("about_me", this.aboutMe);
            
            if(this.status == null){
                json.put("status", "");
            }else{
                json.put("status", this.status);
            }
            json.put("quotes", this.quotes);
            
            return json;
        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
}
