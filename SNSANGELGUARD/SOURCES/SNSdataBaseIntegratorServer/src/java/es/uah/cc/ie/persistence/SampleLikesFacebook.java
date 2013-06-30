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
@Table(name = "sample_likes_facebook")
@NamedQueries({
    @NamedQuery(name = "SampleLikesFacebook.findAll", query = "SELECT s FROM SampleLikesFacebook s"),
    @NamedQuery(name = "SampleLikesFacebook.findByIdSampleLikesFacebook", query = "SELECT s FROM SampleLikesFacebook s WHERE s.idSampleLikesFacebook = :idSampleLikesFacebook"),
    @NamedQuery(name = "SampleLikesFacebook.findByUid", query = "SELECT s FROM SampleLikesFacebook s WHERE s.uid = :uid")})
public class SampleLikesFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_sample_likes_facebook")
    private Integer idSampleLikesFacebook;
    @Column(name = "UID")
    private String uid;
    @JoinColumn(name = "likes_facebook_id_likes_facebook", referencedColumnName = "id_likes_facebook")
    @ManyToOne(optional = false)
    private LikesFacebook likesFacebook;

    public SampleLikesFacebook() {
    }

    public SampleLikesFacebook(Integer idSampleLikesFacebook) {
        this.idSampleLikesFacebook = idSampleLikesFacebook;
    }

    public Integer getIdSampleLikesFacebook() {
        return idSampleLikesFacebook;
    }

    public void setIdSampleLikesFacebook(Integer idSampleLikesFacebook) {
        this.idSampleLikesFacebook = idSampleLikesFacebook;
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
        hash += (idSampleLikesFacebook != null ? idSampleLikesFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SampleLikesFacebook)) {
            return false;
        }
        SampleLikesFacebook other = (SampleLikesFacebook) object;
        if ((this.idSampleLikesFacebook == null && other.idSampleLikesFacebook != null) || (this.idSampleLikesFacebook != null && !this.idSampleLikesFacebook.equals(other.idSampleLikesFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.SampleLikesFacebook[idSampleLikesFacebook=" + idSampleLikesFacebook + "]";
    }

}
