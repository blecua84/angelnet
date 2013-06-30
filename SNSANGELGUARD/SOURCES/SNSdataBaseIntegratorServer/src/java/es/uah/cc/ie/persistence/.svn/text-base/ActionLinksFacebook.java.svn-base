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
@Table(name = "action_links_facebook")
@NamedQueries({
    @NamedQuery(name = "ActionLinksFacebook.findAll", query = "SELECT a FROM ActionLinksFacebook a"),
    @NamedQuery(name = "ActionLinksFacebook.findByIdActionLinksFacebook", query = "SELECT a FROM ActionLinksFacebook a WHERE a.idActionLinksFacebook = :idActionLinksFacebook"),
    @NamedQuery(name = "ActionLinksFacebook.findByText", query = "SELECT a FROM ActionLinksFacebook a WHERE a.text = :text"),
    @NamedQuery(name = "ActionLinksFacebook.findByUrl", query = "SELECT a FROM ActionLinksFacebook a WHERE a.url = :url")})
public class ActionLinksFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_action_links_facebook")
    private Integer idActionLinksFacebook;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "URL")
    private String url;
    @JoinColumn(name = "stream_facebook_post_id", referencedColumnName = "post_id")
    @ManyToOne(optional = false)
    private StreamFacebook streamFacebook;

    public ActionLinksFacebook() {
    }

    public ActionLinksFacebook(Integer idActionLinksFacebook) {
        this.idActionLinksFacebook = idActionLinksFacebook;
    }

    public Integer getIdActionLinksFacebook() {
        return idActionLinksFacebook;
    }

    public void setIdActionLinksFacebook(Integer idActionLinksFacebook) {
        this.idActionLinksFacebook = idActionLinksFacebook;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        hash += (idActionLinksFacebook != null ? idActionLinksFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActionLinksFacebook)) {
            return false;
        }
        ActionLinksFacebook other = (ActionLinksFacebook) object;
        if ((this.idActionLinksFacebook == null && other.idActionLinksFacebook != null) || (this.idActionLinksFacebook != null && !this.idActionLinksFacebook.equals(other.idActionLinksFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.ActionLinksFacebook[idActionLinksFacebook=" + idActionLinksFacebook + "]";
    }

}
