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
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "friends_likes_facebook")
@NamedQueries({
    @NamedQuery(name = "FriendsLikesFacebook.findAll", query = "SELECT f FROM FriendsLikesFacebook f"),
    @NamedQuery(name = "FriendsLikesFacebook.findByIdFriendsLikesFacebook", query = "SELECT f FROM FriendsLikesFacebook f WHERE f.idFriendsLikesFacebook = :idFriendsLikesFacebook"),
    @NamedQuery(name = "FriendsLikesFacebook.findByUid", query = "SELECT f FROM FriendsLikesFacebook f WHERE f.uid = :uid")})
public class FriendsLikesFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_friends_likes_facebook")
    private Integer idFriendsLikesFacebook;
    @Column(name = "UID")
    private String uid;
    @JoinColumn(name = "likes_facebook_id_likes_facebook", referencedColumnName = "id_likes_facebook")
    @ManyToOne(optional = false)
    private LikesFacebook likesFacebook;

    public FriendsLikesFacebook() {
    }

    public FriendsLikesFacebook(Integer idFriendsLikesFacebook) {
        this.idFriendsLikesFacebook = idFriendsLikesFacebook;
    }

    public Integer getIdFriendsLikesFacebook() {
        return idFriendsLikesFacebook;
    }

    public void setIdFriendsLikesFacebook(Integer idFriendsLikesFacebook) {
        this.idFriendsLikesFacebook = idFriendsLikesFacebook;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public LikesFacebook getLikesFacebook() {
        return likesFacebook;
    }

    public void setLikesFacebook(LikesFacebook likesFacebook) {
        this.likesFacebook = likesFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFriendsLikesFacebook != null ? idFriendsLikesFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FriendsLikesFacebook)) {
            return false;
        }
        FriendsLikesFacebook other = (FriendsLikesFacebook) object;
        if ((this.idFriendsLikesFacebook == null && other.idFriendsLikesFacebook != null) || (this.idFriendsLikesFacebook != null && !this.idFriendsLikesFacebook.equals(other.idFriendsLikesFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.FriendsLikesFacebook[idFriendsLikesFacebook=" + idFriendsLikesFacebook + "]";
    }

}
