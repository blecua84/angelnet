/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "user_facebook")
@NamedQueries({
    @NamedQuery(name = "UserFacebook.findAll", query = "SELECT u FROM UserFacebook u"),
    @NamedQuery(name = "UserFacebook.findByIdUserFacebook", query = "SELECT u FROM UserFacebook u WHERE u.idUserFacebook = :idUserFacebook"),
    @NamedQuery(name = "UserFacebook.findByFirstName", query = "SELECT u FROM UserFacebook u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "UserFacebook.findByMiddleName", query = "SELECT u FROM UserFacebook u WHERE u.middleName = :middleName"),
    @NamedQuery(name = "UserFacebook.findByLastName", query = "SELECT u FROM UserFacebook u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "UserFacebook.findByName", query = "SELECT u FROM UserFacebook u WHERE u.name = :name"),
    @NamedQuery(name = "UserFacebook.findByPicSmall", query = "SELECT u FROM UserFacebook u WHERE u.picSmall = :picSmall"),
    @NamedQuery(name = "UserFacebook.findByPicBig", query = "SELECT u FROM UserFacebook u WHERE u.picBig = :picBig"),
    @NamedQuery(name = "UserFacebook.findByPicSquare", query = "SELECT u FROM UserFacebook u WHERE u.picSquare = :picSquare"),
    @NamedQuery(name = "UserFacebook.findByPic", query = "SELECT u FROM UserFacebook u WHERE u.pic = :pic"),
    @NamedQuery(name = "UserFacebook.findByProfileUpdateTime", query = "SELECT u FROM UserFacebook u WHERE u.profileUpdateTime = :profileUpdateTime"),
    @NamedQuery(name = "UserFacebook.findByBirthday", query = "SELECT u FROM UserFacebook u WHERE u.birthday = :birthday"),
    @NamedQuery(name = "UserFacebook.findByBirthdayDate", query = "SELECT u FROM UserFacebook u WHERE u.birthdayDate = :birthdayDate"),
    @NamedQuery(name = "UserFacebook.findBySignificantOtherId", query = "SELECT u FROM UserFacebook u WHERE u.significantOtherId = :significantOtherId"),
    @NamedQuery(name = "UserFacebook.findByHs1Name", query = "SELECT u FROM UserFacebook u WHERE u.hs1Name = :hs1Name"),
    @NamedQuery(name = "UserFacebook.findByHs2Name", query = "SELECT u FROM UserFacebook u WHERE u.hs2Name = :hs2Name"),
    @NamedQuery(name = "UserFacebook.findByGradYear", query = "SELECT u FROM UserFacebook u WHERE u.gradYear = :gradYear"),
    @NamedQuery(name = "UserFacebook.findByHs1Id", query = "SELECT u FROM UserFacebook u WHERE u.hs1Id = :hs1Id"),
    @NamedQuery(name = "UserFacebook.findByHs2Id", query = "SELECT u FROM UserFacebook u WHERE u.hs2Id = :hs2Id"),
    @NamedQuery(name = "UserFacebook.findByNotesCount", query = "SELECT u FROM UserFacebook u WHERE u.notesCount = :notesCount"),
    @NamedQuery(name = "UserFacebook.findByWallCount", query = "SELECT u FROM UserFacebook u WHERE u.wallCount = :wallCount"),
    @NamedQuery(name = "UserFacebook.findByOnlinePresence", query = "SELECT u FROM UserFacebook u WHERE u.onlinePresence = :onlinePresence"),
    @NamedQuery(name = "UserFacebook.findByLocale", query = "SELECT u FROM UserFacebook u WHERE u.locale = :locale"),
    @NamedQuery(name = "UserFacebook.findByProxiedEmail", query = "SELECT u FROM UserFacebook u WHERE u.proxiedEmail = :proxiedEmail"),
    @NamedQuery(name = "UserFacebook.findByProfileUrl", query = "SELECT u FROM UserFacebook u WHERE u.profileUrl = :profileUrl"),
    @NamedQuery(name = "UserFacebook.findByEmailHashes", query = "SELECT u FROM UserFacebook u WHERE u.emailHashes = :emailHashes"),
    @NamedQuery(name = "UserFacebook.findByPicSmallWithLogo", query = "SELECT u FROM UserFacebook u WHERE u.picSmallWithLogo = :picSmallWithLogo"),
    @NamedQuery(name = "UserFacebook.findByPicBigWithLogo", query = "SELECT u FROM UserFacebook u WHERE u.picBigWithLogo = :picBigWithLogo"),
    @NamedQuery(name = "UserFacebook.findByPicSquareWithLogo", query = "SELECT u FROM UserFacebook u WHERE u.picSquareWithLogo = :picSquareWithLogo"),
    @NamedQuery(name = "UserFacebook.findByPicWithLogo", query = "SELECT u FROM UserFacebook u WHERE u.picWithLogo = :picWithLogo"),
    @NamedQuery(name = "UserFacebook.findByAllowedRestrictions", query = "SELECT u FROM UserFacebook u WHERE u.allowedRestrictions = :allowedRestrictions"),
    @NamedQuery(name = "UserFacebook.findByVerified", query = "SELECT u FROM UserFacebook u WHERE u.verified = :verified"),
    @NamedQuery(name = "UserFacebook.findByProfileBlurb", query = "SELECT u FROM UserFacebook u WHERE u.profileBlurb = :profileBlurb"),
    @NamedQuery(name = "UserFacebook.findByUsername", query = "SELECT u FROM UserFacebook u WHERE u.username = :username"),
    @NamedQuery(name = "UserFacebook.findByWebsite", query = "SELECT u FROM UserFacebook u WHERE u.website = :website"),
    @NamedQuery(name = "UserFacebook.findByIsBlocked", query = "SELECT u FROM UserFacebook u WHERE u.isBlocked = :isBlocked"),
    @NamedQuery(name = "UserFacebook.findByContactEmail", query = "SELECT u FROM UserFacebook u WHERE u.contactEmail = :contactEmail"),
    @NamedQuery(name = "UserFacebook.findByEmail", query = "SELECT u FROM UserFacebook u WHERE u.email = :email")})
public class UserFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_user_facebook")
    private String idUserFacebook;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PIC_SMALL")
    private String picSmall;
    @Column(name = "PIC_BIG")
    private String picBig;
    @Column(name = "PIC_SQUARE")
    private String picSquare;
    @Column(name = "PIC")
    private String pic;
    @Column(name = "PROFILE_UPDATE_TIME")
    @Temporal(TemporalType.TIME)
    private Date profileUpdateTime;
    @Column(name = "BIRTHDAY")
    private String birthday;
    @Column(name = "BIRTHDAY_DATE")
    private String birthdayDate;
    @Column(name = "SIGNIFICANT_OTHER_ID")
    private String significantOtherId;
    @Column(name = "HS1_NAME")
    private String hs1Name;
    @Column(name = "HS2_NAME")
    private String hs2Name;
    @Column(name = "GRAD_YEAR")
    private Integer gradYear;
    @Column(name = "HS1_ID")
    private String hs1Id;
    @Column(name = "HS2_ID")
    private String hs2Id;
    @Column(name = "NOTES_COUNT")
    private Integer notesCount;
    @Column(name = "WALL_COUNT")
    private Integer wallCount;
    @Column(name = "ONLINE_PRESENCE")
    private String onlinePresence;
    @Column(name = "LOCALE")
    private String locale;
    @Column(name = "PROXIED_EMAIL")
    private String proxiedEmail;
    @Column(name = "PROFILE_URL")
    private String profileUrl;
    @Column(name = "EMAIL_HASHES")
    private String emailHashes;
    @Column(name = "PIC_SMALL_WITH_LOGO")
    private String picSmallWithLogo;
    @Column(name = "PIC_BIG_WITH_LOGO")
    private String picBigWithLogo;
    @Column(name = "PIC_SQUARE_WITH_LOGO")
    private String picSquareWithLogo;
    @Column(name = "PIC_WITH_LOGO")
    private String picWithLogo;
    @Column(name = "ALLOWED_RESTRICTIONS")
    private String allowedRestrictions;
    @Column(name = "VERIFIED")
    private Boolean verified;
    @Column(name = "PROFILE_BLURB")
    private String profileBlurb;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "WEBSITE")
    private String website;
    @Column(name = "IS_BLOCKED")
    private Boolean isBlocked;
    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MEETING_SEX")
    private String meetingSexFacebook;
    @Column(name = "MEETING_FOR")
    private String meetingForFacebook;
    @ManyToMany(mappedBy = "userFacebookCollection")
    private Collection<LocationFacebook> locationFacebookCollection;
    @ManyToMany(mappedBy = "userFacebookCollection")
    private Collection<FamilyFacebook> familyFacebookCollection;
    @ManyToMany(mappedBy = "userFacebookCollection")
    private Collection<FriendsFacebook> friendsFacebookCollection;
    @ManyToMany(mappedBy = "userFacebookCollection")
    private Collection<StreamFacebook> streamFacebookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFacebook")
    private Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFacebook")
    private Collection<AffiliationsFacebook> affiliationsFacebookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFacebook")
    private Collection<EducationHistoryFacebook> educationHistoryFacebookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFacebook")
    private Collection<WorkHistoryFacebook> workHistoryFacebookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userFacebook")
    private Collection<User> userCollection;

    public UserFacebook() {
    }

    public UserFacebook(String idUserFacebook) {
        this.idUserFacebook = idUserFacebook;
    }

    public String getIdUserFacebook() {
        return idUserFacebook;
    }

    public void setIdUserFacebook(String idUserFacebook) {
        this.idUserFacebook = idUserFacebook;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicSmall() {
        return picSmall;
    }

    public void setPicSmall(String picSmall) {
        this.picSmall = picSmall;
    }

    public String getPicBig() {
        return picBig;
    }

    public void setPicBig(String picBig) {
        this.picBig = picBig;
    }

    public String getPicSquare() {
        return picSquare;
    }

    public void setPicSquare(String picSquare) {
        this.picSquare = picSquare;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Date getProfileUpdateTime() {
        return profileUpdateTime;
    }

    public void setProfileUpdateTime(Date profileUpdateTime) {
        this.profileUpdateTime = profileUpdateTime;
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

    public String getSignificantOtherId() {
        return significantOtherId;
    }

    public void setSignificantOtherId(String significantOtherId) {
        this.significantOtherId = significantOtherId;
    }

    public String getHs1Name() {
        return hs1Name;
    }

    public void setHs1Name(String hs1Name) {
        this.hs1Name = hs1Name;
    }

    public String getHs2Name() {
        return hs2Name;
    }

    public void setHs2Name(String hs2Name) {
        this.hs2Name = hs2Name;
    }

    public Integer getGradYear() {
        return gradYear;
    }

    public void setGradYear(Integer gradYear) {
        this.gradYear = gradYear;
    }

    public String getHs1Id() {
        return hs1Id;
    }

    public void setHs1Id(String hs1Id) {
        this.hs1Id = hs1Id;
    }

    public String getHs2Id() {
        return hs2Id;
    }

    public void setHs2Id(String hs2Id) {
        this.hs2Id = hs2Id;
    }

    public Integer getNotesCount() {
        return notesCount;
    }

    public void setNotesCount(Integer notesCount) {
        this.notesCount = notesCount;
    }

    public Integer getWallCount() {
        return wallCount;
    }

    public void setWallCount(Integer wallCount) {
        this.wallCount = wallCount;
    }

    public String getOnlinePresence() {
        return onlinePresence;
    }

    public void setOnlinePresence(String onlinePresence) {
        this.onlinePresence = onlinePresence;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getProxiedEmail() {
        return proxiedEmail;
    }

    public void setProxiedEmail(String proxiedEmail) {
        this.proxiedEmail = proxiedEmail;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getEmailHashes() {
        return emailHashes;
    }

    public void setEmailHashes(String emailHashes) {
        this.emailHashes = emailHashes;
    }

    public String getPicSmallWithLogo() {
        return picSmallWithLogo;
    }

    public void setPicSmallWithLogo(String picSmallWithLogo) {
        this.picSmallWithLogo = picSmallWithLogo;
    }

    public String getPicBigWithLogo() {
        return picBigWithLogo;
    }

    public void setPicBigWithLogo(String picBigWithLogo) {
        this.picBigWithLogo = picBigWithLogo;
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

    public String getAllowedRestrictions() {
        return allowedRestrictions;
    }

    public void setAllowedRestrictions(String allowedRestrictions) {
        this.allowedRestrictions = allowedRestrictions;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public String getProfileBlurb() {
        return profileBlurb;
    }

    public void setProfileBlurb(String profileBlurb) {
        this.profileBlurb = profileBlurb;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
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

    public Collection<LocationFacebook> getLocationFacebookCollection() {
        return locationFacebookCollection;
    }

    public void setLocationFacebookCollection(Collection<LocationFacebook> locationFacebookCollection) {
        this.locationFacebookCollection = locationFacebookCollection;
    }

    public Collection<FamilyFacebook> getFamilyFacebookCollection() {
        return familyFacebookCollection;
    }

    public void setFamilyFacebookCollection(Collection<FamilyFacebook> familyFacebookCollection) {
        this.familyFacebookCollection = familyFacebookCollection;
    }

    public Collection<FriendsFacebook> getFriendsFacebookCollection() {
        return friendsFacebookCollection;
    }

    public void setFriendsFacebookCollection(Collection<FriendsFacebook> friendsFacebookCollection) {
        this.friendsFacebookCollection = friendsFacebookCollection;
    }

    public Collection<StreamFacebook> getStreamFacebookCollection() {
        return streamFacebookCollection;
    }

    public void setStreamFacebookCollection(Collection<StreamFacebook> streamFacebookCollection) {
        this.streamFacebookCollection = streamFacebookCollection;
    }

    public Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection() {
        return locationfacebookhasuserfacebookCURRENTLOCATIONCollection;
    }

    public void setLocationfacebookhasuserfacebookCURRENTLOCATIONCollection(Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollection) {
        this.locationfacebookhasuserfacebookCURRENTLOCATIONCollection = locationfacebookhasuserfacebookCURRENTLOCATIONCollection;
    }

    public String getMeetingSexFacebook() {
        return meetingSexFacebook;
    }

    public void setMeetingSexFacebook(String meetingSexFacebook) {
        this.meetingSexFacebook = meetingSexFacebook;
    }

    public String getMeetingForFacebook() {
        return meetingForFacebook;
    }

    public void setMeetingForFacebook(String meetingForFacebook) {
        this.meetingForFacebook = meetingForFacebook;
    }

    public Collection<AffiliationsFacebook> getAffiliationsFacebookCollection() {
        return affiliationsFacebookCollection;
    }

    public void setAffiliationsFacebookCollection(Collection<AffiliationsFacebook> affiliationsFacebookCollection) {
        this.affiliationsFacebookCollection = affiliationsFacebookCollection;
    }

    public Collection<EducationHistoryFacebook> getEducationHistoryFacebookCollection() {
        return educationHistoryFacebookCollection;
    }

    public void setEducationHistoryFacebookCollection(Collection<EducationHistoryFacebook> educationHistoryFacebookCollection) {
        this.educationHistoryFacebookCollection = educationHistoryFacebookCollection;
    }

    public Collection<WorkHistoryFacebook> getWorkHistoryFacebookCollection() {
        return workHistoryFacebookCollection;
    }

    public void setWorkHistoryFacebookCollection(Collection<WorkHistoryFacebook> workHistoryFacebookCollection) {
        this.workHistoryFacebookCollection = workHistoryFacebookCollection;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserFacebook != null ? idUserFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserFacebook)) {
            return false;
        }
        UserFacebook other = (UserFacebook) object;
        if ((this.idUserFacebook == null && other.idUserFacebook != null) || (this.idUserFacebook != null && !this.idUserFacebook.equals(other.idUserFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.UserFacebook[idUserFacebook=" + idUserFacebook + "]";
    }

}
