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
@Table(name = "privacy_facebook")
@NamedQueries({
    @NamedQuery(name = "PrivacyFacebook.findAll", query = "SELECT p FROM PrivacyFacebook p"),
    @NamedQuery(name = "PrivacyFacebook.findByIdPrivacyFacebook", query = "SELECT p FROM PrivacyFacebook p WHERE p.idPrivacyFacebook = :idPrivacyFacebook"),
    @NamedQuery(name = "PrivacyFacebook.findByUid", query = "SELECT p FROM PrivacyFacebook p WHERE p.uid = :uid")})
public class PrivacyFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_privacy_facebook")
    private Integer idPrivacyFacebook;
    @Column(name = "UID")
    private String uid;
    @JoinColumn(name = "stream_facebook_post_id", referencedColumnName = "post_id")
    @ManyToOne(optional = false)
    private StreamFacebook streamFacebook;

    public PrivacyFacebook() {
    }

    public PrivacyFacebook(Integer idPrivacyFacebook) {
        this.idPrivacyFacebook = idPrivacyFacebook;
    }

    public Integer getIdPrivacyFacebook() {
        return idPrivacyFacebook;
    }

    public void setIdPrivacyFacebook(Integer idPrivacyFacebook) {
        this.idPrivacyFacebook = idPrivacyFacebook;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public StreamFacebook getStreamFacebook() {
        return streamFacebook;
    }

    public void setStreamFacebook(StreamFacebook streamFacebook) {
        this.streamFacebook = streamFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrivacyFacebook != null ? idPrivacyFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrivacyFacebook)) {
            return false;
        }
        PrivacyFacebook other = (PrivacyFacebook) object;
        if ((this.idPrivacyFacebook == null && other.idPrivacyFacebook != null) || (this.idPrivacyFacebook != null && !this.idPrivacyFacebook.equals(other.idPrivacyFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.PrivacyFacebook[idPrivacyFacebook=" + idPrivacyFacebook + "]";
    }

}
