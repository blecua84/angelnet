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
@Table(name = "settings_fltPriv")
@NamedQueries({
    @NamedQuery(name = "SettingsfltPriv.findAll", query = "SELECT s FROM SettingsfltPriv s"),
    @NamedQuery(name = "SettingsfltPriv.findByUserSettingsUid", query = "SELECT s FROM SettingsfltPriv s WHERE s.userSettingsUid = :userSettingsUid"),
    @NamedQuery(name = "SettingsfltPriv.findByFrecfltPriv", query = "SELECT s FROM SettingsfltPriv s WHERE s.frecfltPriv = :frecfltPriv"),
    @NamedQuery(name = "SettingsfltPriv.findByActivefltPriv", query = "SELECT s FROM SettingsfltPriv s WHERE s.activefltPriv = :activefltPriv")})
public class SettingsfltPriv implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "user_settings_uid")
    private String userSettingsUid;
    @Basic(optional = false)
    @Column(name = "frec_fltPriv")
    private String frecfltPriv;
    @Basic(optional = false)
    @Column(name = "active_fltPriv")
    private String activefltPriv;
    @Column(name = "last_check")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastCheck;
    @ManyToMany(mappedBy = "settingsfltPrivCollection")
    private Collection<SettingsAngels> settingsAngelsCollection;
    @JoinColumn(name = "user_settings_uid", referencedColumnName = "uid", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private UserSettings userSettings;

    public SettingsfltPriv() {
    }

    public SettingsfltPriv(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public SettingsfltPriv(String userSettingsUid, String frecfltPriv, String activefltPriv) {
        this.userSettingsUid = userSettingsUid;
        this.frecfltPriv = frecfltPriv;
        this.activefltPriv = activefltPriv;
    }

    public String getUserSettingsUid() {
        return userSettingsUid;
    }

    public void setUserSettingsUid(String userSettingsUid) {
        this.userSettingsUid = userSettingsUid;
    }

    public String getFrecfltPriv() {
        return frecfltPriv;
    }

    public void setFrecfltPriv(String frecfltPriv) {
        this.frecfltPriv = frecfltPriv;
    }

    public String getActivefltPriv() {
        return activefltPriv;
    }

    public void setActivefltPriv(String activefltPriv) {
        this.activefltPriv = activefltPriv;
    }

    public Collection<SettingsAngels> getSettingsAngelsCollection() {
        return settingsAngelsCollection;
    }

    public Date getLastCheck() {
        return lastCheck;
    }

    public void setLastCheck(Date lastCheck) {
        this.lastCheck = lastCheck;
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
        if (!(object instanceof SettingsfltPriv)) {
            return false;
        }
        SettingsfltPriv other = (SettingsfltPriv) object;
        if ((this.userSettingsUid == null && other.userSettingsUid != null) || (this.userSettingsUid != null && !this.userSettingsUid.equals(other.userSettingsUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.SettingsfltPriv[userSettingsUid=" + userSettingsUid + "]";
    }
}
