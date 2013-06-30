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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "user_settings")
@NamedQueries({
    @NamedQuery(name = "UserSettings.findAll", query = "SELECT u FROM UserSettings u"),
    @NamedQuery(name = "UserSettings.findByUid", query = "SELECT u FROM UserSettings u WHERE u.uid = :uid"),
    @NamedQuery(name = "UserSettings.findByUserName", query = "SELECT u FROM UserSettings u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserSettings.findByUserEmail", query = "SELECT u FROM UserSettings u WHERE u.userEmail = :userEmail"),
    @NamedQuery(name = "UserSettings.findByLegalAccepted", query = "SELECT u FROM UserSettings u WHERE u.legalAccepted = :legalAccepted"),
    @NamedQuery(name = "UserSettings.findByLastCheck", query = "SELECT u FROM UserSettings u WHERE u.lastCheck = :lastCheck"),
    @NamedQuery(name = "UserSettings.findByUidPublic", query = "SELECT u FROM UserSettings u WHERE u.uidPublic = :uidPublic"),
    @NamedQuery(name = "UserSettings.findByAppActivated", query = "SELECT u FROM UserSettings u WHERE u.appActivated = :appActivated"),
    @NamedQuery(name = "UserSettings.findByUserSession", query = "SELECT u FROM UserSettings u WHERE u.userSession = :userSession"),
    @NamedQuery(name = "UserSettings.findByBackupCheck", query = "SELECT u FROM UserSettings u WHERE u.backupCheck = :backupCheck")})
public class UserSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "uid")
    private String uid;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "legal_accepted")
    private String legalAccepted;
    @Column(name = "last_check")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCheck;
    @Column(name = "uid_public")
    private String uidPublic;
    @Column(name = "app_activated")
    private String appActivated;
    @Column(name = "user_session")
    private String userSession;
    @Basic(optional = false)
    @Column(name = "backup_check")
    @Temporal(TemporalType.TIMESTAMP)
    private Date backupCheck;
    @JoinTable(name = "user_settings_has_settings_angels", joinColumns = {
        @JoinColumn(name = "user_settings_uid", referencedColumnName = "uid")}, inverseJoinColumns = {
        @JoinColumn(name = "settings_angels_uid_angel", referencedColumnName = "uid_angel")})
    @ManyToMany
    private Collection<SettingsAngels> settingsAngelsCollection;
    @JoinColumn(name = "locale_settings_id_locale", referencedColumnName = "id_locale")
    @ManyToOne(optional = false)
    private LocaleSettings localeSettings;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userSettings")
    private SettingsfltFriends settingsfltFriends;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userSettings")
    private SettingsfltPriv settingsfltPriv;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userSettings")
    private SettingsfltWall settingsfltWall;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userSettings")
    private SettingsfltVist settingsfltVist;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userSettings")
    private User user;

    public UserSettings() {
    }

    public UserSettings(String uid) {
        this.uid = uid;
    }

    public UserSettings(String uid, Date backupCheck) {
        this.uid = uid;
        this.backupCheck = backupCheck;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getLegalAccepted() {
        return legalAccepted;
    }

    public void setLegalAccepted(String legalAccepted) {
        this.legalAccepted = legalAccepted;
    }

    public Date getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(Date lastCheck) {
        this.lastCheck = lastCheck;
    }

    public String getUidPublic() {
        return uidPublic;
    }

    public void setUidPublic(String uidPublic) {
        this.uidPublic = uidPublic;
    }

    public String getAppActivated() {
        return appActivated;
    }

    public void setAppActivated(String appActivated) {
        this.appActivated = appActivated;
    }

    public String getUserSession() {
        return userSession;
    }

    public void setUserSession(String userSession) {
        this.userSession = userSession;
    }

    public Date getBackupCheck() {
        return backupCheck;
    }

    public void setBackupCheck(Date backupCheck) {
        this.backupCheck = backupCheck;
    }

    public Collection<SettingsAngels> getSettingsAngelsCollection() {
        return settingsAngelsCollection;
    }

    public void setSettingsAngelsCollection(Collection<SettingsAngels> settingsAngelsCollection) {
        this.settingsAngelsCollection = settingsAngelsCollection;
    }

    public LocaleSettings getLocaleSettings() {
        return localeSettings;
    }

    public void setLocaleSettings(LocaleSettings localeSettings) {
        this.localeSettings = localeSettings;
    }

    public SettingsfltFriends getSettingsfltFriends() {
        return settingsfltFriends;
    }

    public void setSettingsfltFriends(SettingsfltFriends settingsfltFriends) {
        this.settingsfltFriends = settingsfltFriends;
    }

    public SettingsfltPriv getSettingsfltPriv() {
        return settingsfltPriv;
    }

    public void setSettingsfltPriv(SettingsfltPriv settingsfltPriv) {
        this.settingsfltPriv = settingsfltPriv;
    }

    public SettingsfltWall getSettingsfltWall() {
        return settingsfltWall;
    }

    public void setSettingsfltWall(SettingsfltWall settingsfltWall) {
        this.settingsfltWall = settingsfltWall;
    }

    public SettingsfltVist getSettingsfltVist() {
        return settingsfltVist;
    }

    public void setSettingsfltVist(SettingsfltVist settingsfltVist) {
        this.settingsfltVist = settingsfltVist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uid != null ? uid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSettings)) {
            return false;
        }
        UserSettings other = (UserSettings) object;
        if ((this.uid == null && other.uid != null) || (this.uid != null && !this.uid.equals(other.uid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.UserSettings[uid=" + uid + "]";
    }
}
