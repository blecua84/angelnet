/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "likes_facebook")
@NamedQueries({
    @NamedQuery(name = "LikesFacebook.findAll", query = "SELECT l FROM LikesFacebook l"),
    @NamedQuery(name = "LikesFacebook.findByIdLikesFacebook", query = "SELECT l FROM LikesFacebook l WHERE l.idLikesFacebook = :idLikesFacebook"),
    @NamedQuery(name = "LikesFacebook.findByHref", query = "SELECT l FROM LikesFacebook l WHERE l.href = :href"),
    @NamedQuery(name = "LikesFacebook.findByCount", query = "SELECT l FROM LikesFacebook l WHERE l.count = :count"),
    @NamedQuery(name = "LikesFacebook.findByUserLikes", query = "SELECT l FROM LikesFacebook l WHERE l.userLikes = :userLikes"),
    @NamedQuery(name = "LikesFacebook.findByCanLike", query = "SELECT l FROM LikesFacebook l WHERE l.canLike = :canLike")})
public class LikesFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_likes_facebook")
    private Integer idLikesFacebook;
    @Column(name = "HREF")
    private String href;
    @Column(name = "COUNT")
    private Integer count;
    @Column(name = "USER_LIKES")
    private Boolean userLikes;
    @Column(name = "CAN_LIKE")
    private Boolean canLike;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "likesFacebook")
    private Collection<FriendsLikesFacebook> friendsLikesFacebookCollection;
    @JoinColumn(name = "stream_facebook_post_id", referencedColumnName = "post_id")
    @ManyToOne(optional = false)
    private StreamFacebook streamFacebook;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "likesFacebook")
    private Collection<SampleLikesFacebook> sampleLikesFacebookCollection;

    public LikesFacebook() {
    }

    public LikesFacebook(Integer idLikesFacebook) {
        this.idLikesFacebook = idLikesFacebook;
    }

    public Integer getIdLikesFacebook() {
        return idLikesFacebook;
    }

    public void setIdLikesFacebook(Integer idLikesFacebook) {
        this.idLikesFacebook = idLikesFacebook;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Boolean userLikes) {
        this.userLikes = userLikes;
    }

    public Boolean getCanLike() {
        return canLike;
    }

    public void setCanLike(Boolean canLike) {
        this.canLike = canLike;
    }

    public Collection<FriendsLikesFacebook> getFriendsLikesFacebookCollection() {
        return friendsLikesFacebookCollection;
    }

    public void setFriendsLikesFacebookCollection(Collection<FriendsLikesFacebook> friendsLikesFacebookCollection) {
        this.friendsLikesFacebookCollection = friendsLikesFacebookCollection;
    }

    public StreamFacebook getStreamFacebook() {
        return streamFacebook;
    }

    public void setStreamFacebook(StreamFacebook streamFacebook) {
        this.streamFacebook = streamFacebook;
    }

    public Collection<SampleLikesFacebook> getSampleLikesFacebookCollection() {
        return sampleLikesFacebookCollection;
    }

    public void setSampleLikesFacebookCollection(Collection<SampleLikesFacebook> sampleLikesFacebookCollection) {
        this.sampleLikesFacebookCollection = sampleLikesFacebookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLikesFacebook != null ? idLikesFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LikesFacebook)) {
            return false;
        }
        LikesFacebook other = (LikesFacebook) object;
        if ((this.idLikesFacebook == null && other.idLikesFacebook != null) || (this.idLikesFacebook != null && !this.idLikesFacebook.equals(other.idLikesFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.LikesFacebook[idLikesFacebook=" + idLikesFacebook + "]";
    }

}
