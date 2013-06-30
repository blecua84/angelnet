/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "guardian_settings")
@NamedQueries({
    @NamedQuery(name = "GuardianSettings.findAll", query = "SELECT g FROM GuardianSettings g"),
    @NamedQuery(name = "GuardianSettings.findByUidGuardian", query = "SELECT g FROM GuardianSettings g WHERE g.uidGuardian = :uidGuardian"),
    @NamedQuery(name = "GuardianSettings.findByGuardianName", query = "SELECT g FROM GuardianSettings g WHERE g.guardianName = :guardianName"),
    @NamedQuery(name = "GuardianSettings.findByGuardianEmail", query = "SELECT g FROM GuardianSettings g WHERE g.guardianEmail = :guardianEmail")})
public class GuardianSettings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uid_guardian")
    private Integer uidGuardian;
    @Basic(optional = false)
    @Column(name = "guardian_name")
    private String guardianName;
    @Basic(optional = false)
    @Column(name = "guardian_email")
    private String guardianEmail;
    @JoinTable(name = "user_settings_has_guardian_settings", joinColumns = {
        @JoinColumn(name = "guardian_settings_uid_guardian", referencedColumnName = "uid_guardian")}, inverseJoinColumns = {
        @JoinColumn(name = "user_settings_uid", referencedColumnName = "uid")})
    @ManyToMany
    private Collection<UserSettings> userSettingsCollection;

    public GuardianSettings() {
    }

    public GuardianSettings(Integer uidGuardian) {
        this.uidGuardian = uidGuardian;
    }

    public GuardianSettings(Integer uidGuardian, String guardianName, String guardianEmail) {
        this.uidGuardian = uidGuardian;
        this.guardianName = guardianName;
        this.guardianEmail = guardianEmail;
    }

    public Integer getUidGuardian() {
        return uidGuardian;
    }

    public void setUidGuardian(Integer uidGuardian) {
        this.uidGuardian = uidGuardian;
    }

    public String getGuardianName() {
        return guardianName;
    }

    public void setGuardianName(String guardianName) {
        this.guardianName = guardianName;
    }

    public String getGuardianEmail() {
        return guardianEmail;
    }

    public void setGuardianEmail(String guardianEmail) {
        this.guardianEmail = guardianEmail;
    }

    public Collection<UserSettings> getUserSettingsCollection() {
        return userSettingsCollection;
    }

    public void setUserSettingsCollection(Collection<UserSettings> userSettingsCollection) {
        this.userSettingsCollection = userSettingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uidGuardian != null ? uidGuardian.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GuardianSettings)) {
            return false;
        }
        GuardianSettings other = (GuardianSettings) object;
        if ((this.uidGuardian == null && other.uidGuardian != null) || (this.uidGuardian != null && !this.uidGuardian.equals(other.uidGuardian))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.GuardianSettings[uidGuardian=" + uidGuardian + "]";
    }

}
