/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserSettingsUid", query = "SELECT u FROM User u WHERE u.userSettingsUid = :userSettingsUid"),
    @NamedQuery(name = "User.findBySex", query = "SELECT u FROM User u WHERE u.sex = :sex"),
    @NamedQuery(name = "User.findByReligion", query = "SELECT u FROM User u WHERE u.religion = :religion"),
    @NamedQuery(name = "User.findByRelationshipStatus", query = "SELECT u FROM User u WHERE u.relationshipStatus = :relationshipStatus"),
    @NamedQuery(name = "User.findByPolitical", query = "SELECT u FROM User u WHERE u.political = :political"),
    @NamedQuery(name = "User.findByActivities", query = "SELECT u FROM User u WHERE u.activities = :activities"),
    @NamedQuery(name = "User.findByInterests", query = "SELECT u FROM User u WHERE u.interests = :interests"),
    @NamedQuery(name = "User.findByIsAppUser", query = "SELECT u FROM User u WHERE u.isAppUser = :isAppUser"),
    @NamedQuery(name = "User.findByMusic", query = "SELECT u FROM User u WHERE u.music = :music"),
    @NamedQuery(name = "User.findByTv", query = "SELECT u FROM User u WHERE u.tv = :tv"),
    @NamedQuery(name = "User.findByMovies", query = "SELECT u FROM User u WHERE u.movies = :movies"),
    @NamedQuery(name = "User.findByBooks", query = "SELECT u FROM User u WHERE u.books = :books"),
    @NamedQuery(name = "User.findByAboutMe", query = "SELECT u FROM User u WHERE u.aboutMe = :aboutMe"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status"),
    @NamedQuery(name = "User.findByQuotes", query = "SELECT u FROM User u WHERE u.quotes = :quotes")})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_settings_uid")
    private String userSettingsUid;
    @Column(name = "SEX")
    private String sex;
    @Column(name = "RELIGION")
    private String religion;
    @Column(name = "RELATIONSHIP_STATUS")
    private String relationshipStatus;
    @Column(name = "POLITICAL")
    private String political;
    @Column(name = "ACTIVITIES")
    private String activities;
    @Column(name = "INTERESTS")
    private String interests;
    @Column(name = "IS_APP_USER")
    private Boolean isAppUser;
    @Column(name = "MUSIC")
    private String music;
    @Column(name = "TV")
    private String tv;
    @Column(name = "MOVIES")
    private String movies;
    @Column(name = "BOOKS")
    private String books;
    @Column(name = "ABOUT_ME")
    private String aboutMe;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "QUOTES")
    private String quotes;
    @JoinColumn(name = "user_settings_uid", referencedColumnName = "uid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserSettings userSettings;
    @JoinColumn(name = "user_openSocial_id_user_openSocial", referencedColumnName = "id_user_openSocial")
    @ManyToOne(optional = false)
    private UseropenSocial useropenSocial;
    @JoinColumn(name = "user_facebook_id_user_facebook", referencedColumnName = "id_user_facebook")
    @ManyToOne(optional = false)
    private UserFacebook userFacebook;

    public User() {
    }

    public User(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public String getUserSettingsUid() {
        return userSettingsUid;
    }

    public void setUserSettingsUid(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getRelationshipStatus() {
        return relationshipStatus;
    }

    public void setRelationshipStatus(String relationshipStatus) {
        this.relationshipStatus = relationshipStatus;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public Boolean getIsAppUser() {
        return isAppUser;
    }

    public void setIsAppUser(Boolean isAppUser) {
        this.isAppUser = isAppUser;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getMovies() {
        return movies;
    }

    public void setMovies(String movies) {
        this.movies = movies;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(UserSettings userSettings) {
        this.userSettings = userSettings;
    }

    public UseropenSocial getUseropenSocial() {
        return useropenSocial;
    }

    public void setUseropenSocial(UseropenSocial useropenSocial) {
        this.useropenSocial = useropenSocial;
    }

    public UserFacebook getUserFacebook() {
        return userFacebook;
    }

    public void setUserFacebook(UserFacebook userFacebook) {
        this.userFacebook = userFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userSettingsUid != null ? userSettingsUid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userSettingsUid == null && other.userSettingsUid != null) || (this.userSettingsUid != null && !this.userSettingsUid.equals(other.userSettingsUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.User[userSettingsUid=" + userSettingsUid + "]";
    }

}
