/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "settings_fltFriends")
@NamedQueries({
    @NamedQuery(name = "SettingsfltFriends.findAll", query = "SELECT s FROM SettingsfltFriends s"),
    @NamedQuery(name = "SettingsfltFriends.findByUserSettingsUid", query = "SELECT s FROM SettingsfltFriends s WHERE s.userSettingsUid = :userSettingsUid"),
    @NamedQuery(name = "SettingsfltFriends.findByFrecfltFriends", query = "SELECT s FROM SettingsfltFriends s WHERE s.frecfltFriends = :frecfltFriends"),
    @NamedQuery(name = "SettingsfltFriends.findByActivefltFriends", query = "SELECT s FROM SettingsfltFriends s WHERE s.activefltFriends = :activefltFriends")})
public class SettingsfltFriends implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_settings_uid")
    private String userSettingsUid;
    @Basic(optional = false)
    @Column(name = "frec_fltFriends")
    private String frecfltFriends;
    @Basic(optional = false)
    @Column(name = "active_fltFriends")
    private String activefltFriends;
    @Column(name = "last_check")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCheck;
    @ManyToMany(mappedBy = "settingsfltFriendsCollection")
    private Collection<SettingsAngels> settingsAngelsCollection;
    @JoinColumn(name = "user_settings_uid", referencedColumnName = "uid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserSettings userSettings;

    public SettingsfltFriends() {
    }

    public SettingsfltFriends(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public SettingsfltFriends(String userSettingsUid, String frecfltFriends, String activefltFriends) {
        this.userSettingsUid = userSettingsUid;
        this.frecfltFriends = frecfltFriends;
        this.activefltFriends = activefltFriends;
    }

    public String getUserSettingsUid() {
        return userSettingsUid;
    }

    public void setUserSettingsUid(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public String getFrecfltFriends() {
        return frecfltFriends;
    }

    public void setFrecfltFriends(String frecfltFriends) {
        this.frecfltFriends = frecfltFriends;
    }

    public String getActivefltFriends() {
        return activefltFriends;
    }

    public void setActivefltFriends(String activefltFriends) {
        this.activefltFriends = activefltFriends;
    }

    public Date getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(Date lastCheck) {
        this.lastCheck = lastCheck;
    }

    public Collection<SettingsAngels> getSettingsAngelsCollection() {
        return settingsAngelsCollection;
    }

    public void setSettingsAngelsCollection(Collection<SettingsAngels> settingsAngelsCollection) {
        this.settingsAngelsCollection = settingsAngelsCollection;
    }

    public UserSettings getUserSettings() {
        return userSettings;
    }

    public void setUserSettings(UserSettings userSettings) {
        this.userSettings = userSettings;
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
        if (!(object instanceof SettingsfltFriends)) {
            return false;
        }
        SettingsfltFriends other = (SettingsfltFriends) object;
        if ((this.userSettingsUid == null && other.userSettingsUid != null) || (this.userSettingsUid != null && !this.userSettingsUid.equals(other.userSettingsUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.SettingsfltFriends[userSettingsUid=" + userSettingsUid + "]";
    }

}
