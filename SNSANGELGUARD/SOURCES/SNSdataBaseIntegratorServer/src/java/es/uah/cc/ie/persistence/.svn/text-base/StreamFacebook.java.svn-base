/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "stream_facebook")
@NamedQueries({
    @NamedQuery(name = "StreamFacebook.findAll", query = "SELECT s FROM StreamFacebook s"),
    @NamedQuery(name = "StreamFacebook.findByPostId", query = "SELECT s FROM StreamFacebook s WHERE s.postId = :postId"),
    @NamedQuery(name = "StreamFacebook.findByViewerId", query = "SELECT s FROM StreamFacebook s WHERE s.viewerId = :viewerId"),
    @NamedQuery(name = "StreamFacebook.findByAppId", query = "SELECT s FROM StreamFacebook s WHERE s.appId = :appId"),
    @NamedQuery(name = "StreamFacebook.findBySourceId", query = "SELECT s FROM StreamFacebook s WHERE s.sourceId = :sourceId"),
    @NamedQuery(name = "StreamFacebook.findByUpdatedTime", query = "SELECT s FROM StreamFacebook s WHERE s.updatedTime = :updatedTime"),
    @NamedQuery(name = "StreamFacebook.findByCreatedTime", query = "SELECT s FROM StreamFacebook s WHERE s.createdTime = :createdTime"),
    @NamedQuery(name = "StreamFacebook.findByFilterKey", query = "SELECT s FROM StreamFacebook s WHERE s.filterKey = :filterKey"),
    @NamedQuery(name = "StreamFacebook.findByAttribution", query = "SELECT s FROM StreamFacebook s WHERE s.attribution = :attribution"),
    @NamedQuery(name = "StreamFacebook.findByActorId", query = "SELECT s FROM StreamFacebook s WHERE s.actorId = :actorId"),
    @NamedQuery(name = "StreamFacebook.findByTargetId", query = "SELECT s FROM StreamFacebook s WHERE s.targetId = :targetId"),
    @NamedQuery(name = "StreamFacebook.findByMessage", query = "SELECT s FROM StreamFacebook s WHERE s.message = :message"),
    @NamedQuery(name = "StreamFacebook.findByAppData", query = "SELECT s FROM StreamFacebook s WHERE s.appData = :appData"),
    @NamedQuery(name = "StreamFacebook.findByAttachment", query = "SELECT s FROM StreamFacebook s WHERE s.attachment = :attachment"),
    @NamedQuery(name = "StreamFacebook.findByType", query = "SELECT s FROM StreamFacebook s WHERE s.type = :type"),
    @NamedQuery(name = "StreamFacebook.findByPermalink", query = "SELECT s FROM StreamFacebook s WHERE s.permalink = :permalink"),
    @NamedQuery(name = "StreamFacebook.findByXid", query = "SELECT s FROM StreamFacebook s WHERE s.xid = :xid")})
public class StreamFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "post_id")
    private String postId;
    @Column(name = "viewer_id")
    private String viewerId;
    @Column(name = "app_id")
    private String appId;
    @Column(name = "source_id")
    private String sourceId;
    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;
    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @Column(name = "filter_key")
    private String filterKey;
    @Column(name = "attribution")
    private String attribution;
    @Column(name = "actor_id")
    private String actorId;
    @Column(name = "target_id")
    private String targetId;
    @Column(name = "message")
    private String message;
    @Column(name = "app_data")
    private String appData;
    @Column(name = "attachment")
    private String attachment;
    @Column(name = "type")
    private String type;
    @Column(name = "permalink")
    private String permalink;
    @Column(name = "xid")
    private String xid;
    @JoinTable(name = "user_facebook_has_stream_facebook", joinColumns = {
        @JoinColumn(name = "stream_facebook_post_id", referencedColumnName = "post_id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_facebook_id_user_facebook", referencedColumnName = "id_user_facebook")})
    @ManyToMany
    private Collection<UserFacebook> userFacebookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "streamFacebook")
    private Collection<CommentsFacebook> commentsFacebookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "streamFacebook")
    private Collection<LikesFacebook> likesFacebookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "streamFacebook")
    private Collection<ActionLinksFacebook> actionLinksFacebookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "streamFacebook")
    private Collection<PrivacyFacebook> privacyFacebookCollection;

    public StreamFacebook() {
    }

    public StreamFacebook(String postId) {
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getViewerId() {
        return viewerId;
    }

    public void setViewerId(String viewerId) {
        this.viewerId = viewerId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getFilterKey() {
        return filterKey;
    }

    public void setFilterKey(String filterKey) {
        this.filterKey = filterKey;
    }

    public String getAttribution() {
        return attribution;
    }

    public void setAttribution(String attribution) {
        this.attribution = attribution;
    }

    public String getActorId() {
        return actorId;
    }

    public void setActorId(String actorId) {
        this.actorId = actorId;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAppData() {
        return appData;
    }

    public void setAppData(String appData) {
        this.appData = appData;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public Collection<UserFacebook> getUserFacebookCollection() {
        return userFacebookCollection;
    }

    public void setUserFacebookCollection(Collection<UserFacebook> userFacebookCollection) {
        this.userFacebookCollection = userFacebookCollection;
    }

    public Collection<CommentsFacebook> getCommentsFacebookCollection() {
        return commentsFacebookCollection;
    }

    public void setCommentsFacebookCollection(Collection<CommentsFacebook> commentsFacebookCollection) {
        this.commentsFacebookCollection = commentsFacebookCollection;
    }

    public Collection<LikesFacebook> getLikesFacebookCollection() {
        return likesFacebookCollection;
    }

    public void setLikesFacebookCollection(Collection<LikesFacebook> likesFacebookCollection) {
        this.likesFacebookCollection = likesFacebookCollection;
    }

    public Collection<ActionLinksFacebook> getActionLinksFacebookCollection() {
        return actionLinksFacebookCollection;
    }

    public void setActionLinksFacebookCollection(Collection<ActionLinksFacebook> actionLinksFacebookCollection) {
        this.actionLinksFacebookCollection = actionLinksFacebookCollection;
    }

    public Collection<PrivacyFacebook> getPrivacyFacebookCollection() {
        return privacyFacebookCollection;
    }

    public void setPrivacyFacebookCollection(Collection<PrivacyFacebook> privacyFacebookCollection) {
        this.privacyFacebookCollection = privacyFacebookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (postId != null ? postId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StreamFacebook)) {
            return false;
        }
        StreamFacebook other = (StreamFacebook) object;
        if ((this.postId == null && other.postId != null) || (this.postId != null && !this.postId.equals(other.postId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.StreamFacebook[postId=" + postId + "]";
    }

}
