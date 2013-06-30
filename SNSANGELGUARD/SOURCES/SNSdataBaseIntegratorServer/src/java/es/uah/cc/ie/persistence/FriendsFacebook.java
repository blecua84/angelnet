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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "friends_facebook")
@NamedQueries({
    @NamedQuery(name = "FriendsFacebook.findAll", query = "SELECT f FROM FriendsFacebook f"),
    @NamedQuery(name = "FriendsFacebook.findByUserUid", query = "SELECT f FROM FriendsFacebook f WHERE f.userUid = :userUid"),
    @NamedQuery(name = "FriendsFacebook.findByUserName", query = "SELECT f FROM FriendsFacebook f WHERE f.userName = :userName")})
public class FriendsFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USER_UID")
    private String userUid;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "USER_BIRTHDAY")
    private String userBirthday;
    @Column(name = "USER_PIC")
    private String userPic;

    @JoinTable(name = "user_facebook_has_friends_facebook", joinColumns = {
        @JoinColumn(name = "friends_facebook_USER_UID", referencedColumnName = "USER_UID")}, inverseJoinColumns = {
        @JoinColumn(name = "user_facebook_id_user_facebook", referencedColumnName = "id_user_facebook")})
    @ManyToMany
    private Collection<UserFacebook> userFacebookCollection;

    public FriendsFacebook() {
    }

    public FriendsFacebook(String userUid) {
        this.userUid = userUid;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserBirthday(){
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday){
        this.userBirthday = userBirthday;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public Collection<UserFacebook> getUserFacebookCollection() {
        return userFacebookCollection;
    }

    public void setUserFacebookCollection(Collection<UserFacebook> userFacebookCollection) {
        this.userFacebookCollection = userFacebookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userUid != null ? userUid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendsFacebook)) {
            return false;
        }
        FriendsFacebook other = (FriendsFacebook) object;
        if ((this.userUid == null && other.userUid != null) || (this.userUid != null && !this.userUid.equals(other.userUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.FriendsFacebook[userUid=" + userUid + "]";
    }

}