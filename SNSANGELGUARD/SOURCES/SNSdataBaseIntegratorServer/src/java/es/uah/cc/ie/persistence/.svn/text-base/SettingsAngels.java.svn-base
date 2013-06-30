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
@Table(name = "settings_angels")
@NamedQueries({
    @NamedQuery(name = "SettingsAngels.findAll", query = "SELECT s FROM SettingsAngels s"),
    @NamedQuery(name = "SettingsAngels.findByUidAngel", query = "SELECT s FROM SettingsAngels s WHERE s.uidAngel = :uidAngel"),
    @NamedQuery(name = "SettingsAngels.findByIdAngel", query = "SELECT s FROM SettingsAngels s WHERE s.idAngel = :idAngel"),
    @NamedQuery(name = "SettingsAngels.findByNameAngel", query = "SELECT s FROM SettingsAngels s WHERE s.nameAngel = :nameAngel"),
    @NamedQuery(name = "SettingsAngels.findByImgAngel", query = "SELECT s FROM SettingsAngels s WHERE s.imgAngel = :imgAngel"),
    @NamedQuery(name = "SettingsAngels.findByTypeAngel", query = "SELECT s FROM SettingsAngels s WHERE s.typeAngel = :typeAngel"),
    @NamedQuery(name = "SettingsAngels.findByAcceptAngel", query = "SELECT s FROM SettingsAngels s WHERE s.acceptAngel = :acceptAngel")})
public class SettingsAngels implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "uid_angel")
    private Integer uidAngel;
    @Basic(optional = false)
    @Column(name = "id_angel")
    private String idAngel;
    @Basic(optional = false)
    @Column(name = "name_angel")
    private String nameAngel;
    @Basic(optional = false)
    @Column(name = "img_angel")
    private String imgAngel;
    @Basic(optional = false)
    @Column(name = "type_angel")
    private String typeAngel;
    @Basic(optional = false)
    @Column(name = "accept_angel")
    private String acceptAngel;
    @Column(name = "user_prop_angel")
    private String userPropAngel;
    @Column(name = "confirm_angel")
    private String confirmAngel;
    @JoinTable(name = "settings_fltVist_has_settings_angels", joinColumns = {
        @JoinColumn(name = "settings_angels_uid_angel", referencedColumnName = "uid_angel")}, inverseJoinColumns = {
        @JoinColumn(name = "settings_fltVist_user_settings_uid", referencedColumnName = "user_settings_uid")})
    @ManyToMany
    private Collection<SettingsfltVist> settingsfltVistCollection;
    @JoinTable(name = "settings_fltWall_has_settings_angels", joinColumns = {
        @JoinColumn(name = "settings_angels_uid_angel", referencedColumnName = "uid_angel")}, inverseJoinColumns = {
        @JoinColumn(name = "settings_fltWall_user_settings_uid", referencedColumnName = "user_settings_uid")})
    @ManyToMany
    private Collection<SettingsfltWall> settingsfltWallCollection;
    @JoinTable(name = "settings_fltPriv_has_settings_angels", joinColumns = {
        @JoinColumn(name = "settings_angels_uid_angel", referencedColumnName = "uid_angel")}, inverseJoinColumns = {
        @JoinColumn(name = "settings_fltPriv_user_settings_uid", referencedColumnName = "user_settings_uid")})
    @ManyToMany
    private Collection<SettingsfltPriv> settingsfltPrivCollection;
    @ManyToMany(mappedBy = "settingsAngelsCollection")
    private Collection<UserSettings> userSettingsCollection;
    @JoinTable(name = "settings_fltFriends_has_settings_angels", joinColumns = {
        @JoinColumn(name = "settings_angels_uid_angel", referencedColumnName = "uid_angel")}, inverseJoinColumns = {
        @JoinColumn(name = "settings_fltFriends_user_settings_uid", referencedColumnName = "user_settings_uid")})
    @ManyToMany
    private Collection<SettingsfltFriends> settingsfltFriendsCollection;

    public SettingsAngels() {
    }

    public SettingsAngels(Integer uidAngel) {
        this.uidAngel = uidAngel;
    }

    public SettingsAngels(Integer uidAngel, String idAngel, String nameAngel, String imgAngel, String typeAngel, String acceptAngel, String userPropAngel) {
        this.uidAngel = uidAngel;
        this.idAngel = idAngel;
        this.nameAngel = nameAngel;
        this.imgAngel = imgAngel;
        this.typeAngel = typeAngel;
        this.acceptAngel = acceptAngel;
        this.userPropAngel = userPropAngel;
    }

    public Integer getUidAngel() {
        return uidAngel;
    }

    public void setUidAngel(Integer uidAngel) {
        this.uidAngel = uidAngel;
    }

    public String getIdAngel() {
        return idAngel;
    }

    public void setIdAngel(String idAngel) {
        this.idAngel = idAngel;
    }

    public String getNameAngel() {
        return nameAngel;
    }

    public void setNameAngel(String nameAngel) {
        this.nameAngel = nameAngel;
    }

    public String getImgAngel() {
        return imgAngel;
    }

    public void setImgAngel(String imgAngel) {
        this.imgAngel = imgAngel;
    }

    public String getTypeAngel() {
        return typeAngel;
    }

    public void setTypeAngel(String typeAngel) {
        this.typeAngel = typeAngel;
    }

    public String getAcceptAngel() {
        return acceptAngel;
    }

    public void setAcceptAngel(String acceptAngel) {
        this.acceptAngel = acceptAngel;
    }

    public String getUserPropAngel() {
        return userPropAngel;
    }

    public void setUserPropAngel(String userPropAngel) {
        this.userPropAngel = userPropAngel;
    }

    public String getConfirmAngel() {
        return confirmAngel;
    }

    public void setConfirmAngel(String confirmAngel) {
        this.confirmAngel = confirmAngel;
    }

    public Collection<SettingsfltVist> getSettingsfltVistCollection() {
        return settingsfltVistCollection;
    }

    public void setSettingsfltVistCollection(Collection<SettingsfltVist> settingsfltVistCollection) {
        this.settingsfltVistCollection = settingsfltVistCollection;
    }

    public Collection<SettingsfltWall> getSettingsfltWallCollection() {
        return settingsfltWallCollection;
    }

    public void setSettingsfltWallCollection(Collection<SettingsfltWall> settingsfltWallCollection) {
        this.settingsfltWallCollection = settingsfltWallCollection;
    }

    public Collection<SettingsfltPriv> getSettingsfltPrivCollection() {
        return settingsfltPrivCollection;
    }

    public void setSettingsfltPrivCollection(Collection<SettingsfltPriv> settingsfltPrivCollection) {
        this.settingsfltPrivCollection = settingsfltPrivCollection;
    }

    public Collection<UserSettings> getUserSettingsCollection() {
        return userSettingsCollection;
    }

    public void setUserSettingsCollection(Collection<UserSettings> userSettingsCollection) {
        this.userSettingsCollection = userSettingsCollection;
    }

    public Collection<SettingsfltFriends> getSettingsfltFriendsCollection() {
        return settingsfltFriendsCollection;
    }

    public void setSettingsfltFriendsCollection(Collection<SettingsfltFriends> settingsfltFriendsCollection) {
        this.settingsfltFriendsCollection = settingsfltFriendsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uidAngel != null ? uidAngel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SettingsAngels)) {
            return false;
        }
        SettingsAngels other = (SettingsAngels) object;
        if ((this.uidAngel == null && other.uidAngel != null) || (this.uidAngel != null && !this.uidAngel.equals(other.uidAngel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.SettingsAngels[uidAngel=" + uidAngel + "]";
    }
}
