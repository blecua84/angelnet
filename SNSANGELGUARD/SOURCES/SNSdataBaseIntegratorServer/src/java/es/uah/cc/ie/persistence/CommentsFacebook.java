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
@Table(name = "comments_facebook")
@NamedQueries({
    @NamedQuery(name = "CommentsFacebook.findAll", query = "SELECT c FROM CommentsFacebook c"),
    @NamedQuery(name = "CommentsFacebook.findByIdCommentsFacebook", query = "SELECT c FROM CommentsFacebook c WHERE c.idCommentsFacebook = :idCommentsFacebook"),
    @NamedQuery(name = "CommentsFacebook.findByCanRemove", query = "SELECT c FROM CommentsFacebook c WHERE c.canRemove = :canRemove"),
    @NamedQuery(name = "CommentsFacebook.findByCanPost", query = "SELECT c FROM CommentsFacebook c WHERE c.canPost = :canPost"),
    @NamedQuery(name = "CommentsFacebook.findByCount", query = "SELECT c FROM CommentsFacebook c WHERE c.count = :count")})
public class CommentsFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_comments_facebook")
    private Integer idCommentsFacebook;
    @Column(name = "CAN_REMOVE")
    private Boolean canRemove;
    @Column(name = "CAN_POST")
    private Boolean canPost;
    @Column(name = "COUNT")
    private Integer count;
    @JoinColumn(name = "stream_facebook_post_id", referencedColumnName = "post_id")
    @ManyToOne(optional = false)
    private StreamFacebook streamFacebook;

    public CommentsFacebook() {
    }

    public CommentsFacebook(Integer idCommentsFacebook) {
        this.idCommentsFacebook = idCommentsFacebook;
    }

    public Integer getIdCommentsFacebook() {
        return idCommentsFacebook;
    }

    public void setIdCommentsFacebook(Integer idCommentsFacebook) {
        this.idCommentsFacebook = idCommentsFacebook;
    }

    public Boolean getCanRemove() {
        return canRemove;
    }

    public void setCanRemove(Boolean canRemove) {
        this.canRemove = canRemove;
    }

    public Boolean getCanPost() {
        return canPost;
    }

    public void setCanPost(Boolean canPost) {
        this.canPost = canPost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
        hash += (idCommentsFacebook != null ? idCommentsFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentsFacebook)) {
            return false;
        }
        CommentsFacebook other = (CommentsFacebook) object;
        if ((this.idCommentsFacebook == null && other.idCommentsFacebook != null) || (this.idCommentsFacebook != null && !this.idCommentsFacebook.equals(other.idCommentsFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.CommentsFacebook[idCommentsFacebook=" + idCommentsFacebook + "]";
    }

}
