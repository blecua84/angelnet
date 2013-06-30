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
 * Informacion extendida del usuario de Facebook.
 * 
 * @author tote
 */
public class InfoUserFacebook extends GenericDataFacebook {

    @Facebook("uid")
    String uid;

    @Facebook("first_name")
    String firstName;

    @Facebook("middle_name")
    String middleName;

    @Facebook("last_name")
    String lastName;

    @Facebook("name")
    String name;

    @Facebook("pic_small")
    String picSmall;

    @Facebook("pic_big")
    String picBig;

    @Facebook("pic_square")
    String picSquare;

    @Facebook("pic")
    String pic;

    @Facebook("profile_update_time")
    String profileUpdateTime;

    @Facebook("birthday")
    String birthday;

    @Facebook("birthday_date")
    String birthdayDate;

    @Facebook("significant_other_id")
    String signigicantOtherId;

    @Facebook("hs_info")
    String hsInfo;

    @Facebook("notes_count")
    String notesCount;

    @Facebook("wall_count")
    String wallCount;

    @Facebook("online_presence")
    String onlinePresence;

    @Facebook("locale")
    String locale;

    @Facebook("proxied_email")
    String proxiedEmail;

    @Facebook("profile_url")
    String profileUrl;

    @Facebook("email_hashes")
    String emailHashes;

    @Facebook("pic_small_with_logo")
    String picSmallWithLogo;

    @Facebook("pic_big_with_logo")
    String picBigWithLogo;

    @Facebook("pic_square_with_logo")
    String picSquareWithLogo;

    @Facebook("pic_with_logo")
    String picWithLogo;

    @Facebook("allowed_restrictions")
    String allowedRestrictions;

    @Facebook("verified")
    String verified;

    @Facebook("profile_blurb")
    String profileBlurb;

    @Facebook("username")
    String username;

    @Facebook("website")
    String website;

    @Facebook("is_blocked")
    String isBlocked;

    @Facebook("contact_email")
    String contactEmail;

    @Facebook("email")
    String email;

    @Facebook("meeting_for")
    String meetingFor;

    @Facebook("meeting_sex")
    String meetingSex;


    
    public String getAllowedRestrictions() {
        return allowedRestrictions;
    }

    public void setAllowedRestrictions(String allowedRestrictions) {
        this.allowedRestrictions = allowedRestrictions;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailHashes() {
        return emailHashes;
    }

    public void setEmailHashes(String emailHashes) {
        this.emailHashes = emailHashes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHsInfo() {
        return hsInfo;
    }

    public void setHsInfo(String hsInfo) {
        this.hsInfo = hsInfo;
    }

    public String getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(String isBlocked) {
        this.isBlocked = isBlocked;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getMeetingFor() {
        return meetingFor;
    }

    public void setMeetingFor(String meetingFor) {
        this.meetingFor = meetingFor;
    }

    public String getMeetingSex() {
        return meetingSex;
    }

    public void setMeetingSex(String mettingSex) {
        this.meetingSex = mettingSex;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotesCount() {
        return notesCount;
    }

    public void setNotesCount(String notesCount) {
        this.notesCount = notesCount;
    }

    public String getOnlinePresence() {
        return onlinePresence;
    }

    public void setOnlinePresence(String onlinePresence) {
        this.onlinePresence = onlinePresence;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPicBig() {
        return picBig;
    }

    public void setPicBig(String picBig) {
        this.picBig = picBig;
    }

    public String getPicBigWithLogo() {
        return picBigWithLogo;
    }

    public void setPicBigWithLogo(String picBigWithLogo) {
        this.picBigWithLogo = picBigWithLogo;
    }

    public String getPicSmall() {
        return picSmall;
    }

    public void setPicSmall(String picSmall) {
        this.picSmall = picSmall;
    }

    public String getPicSmallWithLogo() {
        return picSmallWithLogo;
    }

    public void setPicSmallWithLogo(String picSmallWithLogo) {
        this.picSmallWithLogo = picSmallWithLogo;
    }

    public String getPicSquare() {
        return picSquare;
    }

    public void setPicSquare(String picSquare) {
        this.picSquare = picSquare;
    }

    public String getPicSquareWithLogo() {
        return picSquareWithLogo;
    }

    public void setPicSquareWithLogo(String picSquareWithLogo) {
        this.picSquareWithLogo = picSquareWithLogo;
    }

    public String getPicWithLogo() {
        return picWithLogo;
    }

    public void setPicWithLogo(String picWithLogo) {
        this.picWithLogo = picWithLogo;
    }

    public String getProfileBlurb() {
        return profileBlurb;
    }

    public void setProfileBlurb(String profileBlurb) {
        this.profileBlurb = profileBlurb;
    }

    public String getProfileUpdateTime() {
        return profileUpdateTime;
    }

    public void setProfileUpdateTime(String profileUpdateTime) {
        this.profileUpdateTime = profileUpdateTime;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getProxiedEmail() {
        return proxiedEmail;
    }

    public void setProxiedEmail(String proxiedEmail) {
        this.proxiedEmail = proxiedEmail;
    }

    public String getSignigicantOtherId() {
        return signigicantOtherId;
    }

    public void setSignigicantOtherId(String signigicantOtherId) {
        this.signigicantOtherId = signigicantOtherId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getVerified() {
        return verified;
    }

    public void setVerified(String verified) {
        this.verified = verified;
    }

    public String getWallCount() {
        return wallCount;
    }

    public void setWallCount(String wallCount) {
        this.wallCount = wallCount;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        try {

            json.put("idUserFacebook", this.uid);
            json.put("firstName", this.firstName);
            json.put("middleName", this.middleName);
            json.put("lastName", this.lastName);
            json.put("name", this.name);
            json.put("picSmall", this.picSmall);
            json.put("picBig", this.picBig);
            json.put("picSquare", this.picSquare);
            json.put("pic", this.pic);
            json.put("profileUpdateTime", this.profileUpdateTime);
            json.put("birthday", this.birthday);
            json.put("birthdayDate", this.birthdayDate);

            if(this.signigicantOtherId != null){
                json.put("significantOtherId", this.signigicantOtherId);
            }else{
                json.put("significantOtherId", "");
            }
            
            String strInfo = this.hsInfo;
            if (strInfo != null) {
                JSONObject hs = new JSONObject(strInfo);
                json.put("hs1Name", hs.get("hs1_name"));
                try {
                    json.put("hs1Id", hs.get("hs1_id"));
                } catch (JSONException e) {
                    json.put("hs1Id", "");
                }
                json.put("hs2Name", hs.get("hs2_name"));
                try {
                    json.put("hs2Id", hs.get("hs2_id"));
                } catch (JSONException e) {
                    json.put("hs2Id", "");
                }
                try {
                    json.put("gradYear", hs.get("grad_year"));
                } catch (JSONException e) {
                    json.put("gradYear", "");
                }
            } else {
                json.put("hs1Name", "");
                try {
                    json.put("hs1Id", "");
                } catch (JSONException e) {
                    json.put("hs1Id", "");
                }
                json.put("hs2Name", "");
                try {
                    json.put("hs2Id", "");
                } catch (JSONException e) {
                    json.put("hs2Id", "");
                }
                try {
                    json.put("gradYear", "");
                } catch (JSONException e) {
                    json.put("gradYear", "");
                }
            }

            json.put("notesCount", this.notesCount);
            json.put("wallCount", this.wallCount);
            json.put("onlinePresence", this.onlinePresence);
            json.put("locale", this.locale);
            json.put("proxiedEmail", this.proxiedEmail);
            json.put("profileUrl", this.profileUrl);
            json.put("emailHashes", this.emailHashes);
            json.put("picSmallWithLogo", this.picSmallWithLogo);
            json.put("picBigWithLogo", this.picBigWithLogo);
            json.put("picSquareWithLogo", this.picSmallWithLogo);
            json.put("picWithLogo", this.picWithLogo);
            json.put("allowedRestrictions", this.allowedRestrictions);
            json.put("verified", this.verified);
            json.put("profileBlurb", this.profileBlurb);
            json.put("username", this.username);
            json.put("website", this.website);
            json.put("isBlocked", this.isBlocked);
            json.put("contactEmail", this.contactEmail);
            json.put("email", this.email);

            String metting = "";
            if (!this.meetingFor.equals("") && !this.meetingFor.equals("{}") && !this.meetingFor.equals("[]")) {
                metting = this.meetingFor.substring(2, this.meetingFor.length() - 2);
            }
            json.put("meetingForFacebook", metting);

            if (!this.meetingSex.equals("") && !this.meetingSex.equals("{}") && !this.meetingSex.equals("[]")) {
                metting = this.meetingSex.substring(2, this.meetingSex.length() - 2);
            }
            json.put("meetingSexFacebook", metting);
            
            return json;
        } catch (JSONException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
}