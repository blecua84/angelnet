/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "comment_facebook")
@NamedQueries({
    @NamedQuery(name = "CommentFacebook.findAll", query = "SELECT c FROM CommentFacebook c"),
    @NamedQuery(name = "CommentFacebook.findByXid", query = "SELECT c FROM CommentFacebook c WHERE c.xid = :xid"),
    @NamedQuery(name = "CommentFacebook.findByObjectId", query = "SELECT c FROM CommentFacebook c WHERE c.objectId = :objectId"),
    @NamedQuery(name = "CommentFacebook.findByPostId", query = "SELECT c FROM CommentFacebook c WHERE c.postId = :postId"),
    @NamedQuery(name = "CommentFacebook.findByFromid", query = "SELECT c FROM CommentFacebook c WHERE c.fromid = :fromid"),
    @NamedQuery(name = "CommentFacebook.findByTime", query = "SELECT c FROM CommentFacebook c WHERE c.timeComment = :timeComment"),
    @NamedQuery(name = "CommentFacebook.findByText", query = "SELECT c FROM CommentFacebook c WHERE c.text = :text"),
    @NamedQuery(name = "CommentFacebook.findById", query = "SELECT c FROM CommentFacebook c WHERE c.id = :id"),
    @NamedQuery(name = "CommentFacebook.findByUsername", query = "SELECT c FROM CommentFacebook c WHERE c.username = :username"),
    @NamedQuery(name = "CommentFacebook.findByReplyXid", query = "SELECT c FROM CommentFacebook c WHERE c.replyXid = :replyXid"),
    @NamedQuery(name = "CommentFacebook.findByCommentsFacebookIdCommentsFacebook", query = "SELECT c FROM CommentFacebook c WHERE c.commentsFacebookIdCommentsFacebook = :commentsFacebookIdCommentsFacebook")})
public class CommentFacebook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "XID")
    private String xid;
    @Column(name = "OBJECT_ID")
    private String objectId;
    @Column(name = "POST_ID")
    private String postId;
    @Column(name = "FROMID")
    private String fromid;
    @Column(name = "TIME_COMMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeComment;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "REPLY_XID")
    private String replyXid;
    @Basic(optional = false)
    @Column(name = "comments_facebook_id_comments_facebook")
    private int commentsFacebookIdCommentsFacebook;

    public CommentFacebook() {
    }

    public CommentFacebook(String xid) {
        this.xid = xid;
    }

    public CommentFacebook(String xid, int commentsFacebookIdCommentsFacebook) {
        this.xid = xid;
        this.commentsFacebookIdCommentsFacebook = commentsFacebookIdCommentsFacebook;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public Date getTimeComment() {
        return timeComment;
    }

    public void setTimeComment(Date timeComment) {
        this.timeComment = timeComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReplyXid() {
        return replyXid;
    }

    public void setReplyXid(String replyXid) {
        this.replyXid = replyXid;
    }

    public int getCommentsFacebookIdCommentsFacebook() {
        return commentsFacebookIdCommentsFacebook;
    }

    public void setCommentsFacebookIdCommentsFacebook(int commentsFacebookIdCommentsFacebook) {
        this.commentsFacebookIdCommentsFacebook = commentsFacebookIdCommentsFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (xid != null ? xid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentFacebook)) {
            return false;
        }
        CommentFacebook other = (CommentFacebook) object;
        if ((this.xid == null && other.xid != null) || (this.xid != null && !this.xid.equals(other.xid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.CommentFacebook[xid=" + xid + "]";
    }
}
