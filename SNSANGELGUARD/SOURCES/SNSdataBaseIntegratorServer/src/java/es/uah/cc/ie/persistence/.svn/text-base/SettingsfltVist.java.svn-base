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
@Table(name = "settings_fltVist")
@NamedQueries({
    @NamedQuery(name = "SettingsfltVist.findAll", query = "SELECT s FROM SettingsfltVist s"),
    @NamedQuery(name = "SettingsfltVist.findByUserSettingsUid", query = "SELECT s FROM SettingsfltVist s WHERE s.userSettingsUid = :userSettingsUid"),
    @NamedQuery(name = "SettingsfltVist.findByFrecfltVist", query = "SELECT s FROM SettingsfltVist s WHERE s.frecfltVist = :frecfltVist"),
    @NamedQuery(name = "SettingsfltVist.findByActivefltVist", query = "SELECT s FROM SettingsfltVist s WHERE s.activefltVist = :activefltVist")})
public class SettingsfltVist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_settings_uid")
    private String userSettingsUid;
    @Basic(optional = false)
    @Column(name = "frec_fltVist")
    private String frecfltVist;
    @Basic(optional = false)
    @Column(name = "active_fltVist")
    private String activefltVist;
    @Column(name = "last_check")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCheck;
    @ManyToMany(mappedBy = "settingsfltVistCollection")
    private Collection<SettingsAngels> settingsAngelsCollection;
    @JoinColumn(name = "user_settings_uid", referencedColumnName = "uid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserSettings userSettings;

    public SettingsfltVist() {
    }

    public SettingsfltVist(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public SettingsfltVist(String userSettingsUid, String frecfltVist, String activefltVist) {
        this.userSettingsUid = userSettingsUid;
        this.frecfltVist = frecfltVist;
        this.activefltVist = activefltVist;
    }

    public String getUserSettingsUid() {
        return userSettingsUid;
    }

    public void setUserSettingsUid(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public String getFrecfltVist() {
        return frecfltVist;
    }

    public void setFrecfltVist(String frecfltVist) {
        this.frecfltVist = frecfltVist;
    }

    public String getActivefltVist() {
        return activefltVist;
    }

    public void setActivefltVist(String activefltVist) {
        this.activefltVist = activefltVist;
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
        if (!(object instanceof SettingsfltVist)) {
            return false;
        }
        SettingsfltVist other = (SettingsfltVist) object;
        if ((this.userSettingsUid == null && other.userSettingsUid != null) || (this.userSettingsUid != null && !this.userSettingsUid.equals(other.userSettingsUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.SettingsfltVist[userSettingsUid=" + userSettingsUid + "]";
    }
}
