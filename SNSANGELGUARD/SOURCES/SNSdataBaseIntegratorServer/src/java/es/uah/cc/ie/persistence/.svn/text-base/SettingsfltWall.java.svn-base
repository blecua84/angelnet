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
@Table(name = "settings_fltWall")
@NamedQueries({
    @NamedQuery(name = "SettingsfltWall.findAll", query = "SELECT s FROM SettingsfltWall s"),
    @NamedQuery(name = "SettingsfltWall.findByUserSettingsUid", query = "SELECT s FROM SettingsfltWall s WHERE s.userSettingsUid = :userSettingsUid"),
    @NamedQuery(name = "SettingsfltWall.findByFrecfltWall", query = "SELECT s FROM SettingsfltWall s WHERE s.frecfltWall = :frecfltWall"),
    @NamedQuery(name = "SettingsfltWall.findByActivefltWall", query = "SELECT s FROM SettingsfltWall s WHERE s.activefltWall = :activefltWall")})
public class SettingsfltWall implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_settings_uid")
    private String userSettingsUid;
    @Basic(optional = false)
    @Column(name = "frec_fltWall")
    private String frecfltWall;
    @Basic(optional = false)
    @Column(name = "active_fltWall")
    private String activefltWall;
    @Column(name = "last_check")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCheck;
    @ManyToMany(mappedBy = "settingsfltWallCollection")
    private Collection<SettingsAngels> settingsAngelsCollection;
    @JoinColumn(name = "user_settings_uid", referencedColumnName = "uid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserSettings userSettings;

    public SettingsfltWall() {
    }

    public SettingsfltWall(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public SettingsfltWall(String userSettingsUid, String frecfltWall, String activefltWall) {
        this.userSettingsUid = userSettingsUid;
        this.frecfltWall = frecfltWall;
        this.activefltWall = activefltWall;
    }

    public String getUserSettingsUid() {
        return userSettingsUid;
    }

    public void setUserSettingsUid(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public String getFrecfltWall() {
        return frecfltWall;
    }

    public void setFrecfltWall(String frecfltWall) {
        this.frecfltWall = frecfltWall;
    }

    public String getActivefltWall() {
        return activefltWall;
    }

    public void setActivefltWall(String activefltWall) {
        this.activefltWall = activefltWall;
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
        if (!(object instanceof SettingsfltWall)) {
            return false;
        }
        SettingsfltWall other = (SettingsfltWall) object;
        if ((this.userSettingsUid == null && other.userSettingsUid != null) || (this.userSettingsUid != null && !this.userSettingsUid.equals(other.userSettingsUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.SettingsfltWall[userSettingsUid=" + userSettingsUid + "]";
    }
}
