/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.CommentFacebook;
import java.net.URI;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "commentFacebook")
public class CommentFacebookConverter {
    private CommentFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of CommentFacebookConverter */
    public CommentFacebookConverter() {
        entity = new CommentFacebook();
    }

    /**
     * Creates a new instance of CommentFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public CommentFacebookConverter(CommentFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getXid() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of CommentFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public CommentFacebookConverter(CommentFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for xid.
     *
     * @return value for xid
     */
    @XmlElement
    public String getXid() {
        return (expandLevel > 0) ? entity.getXid() : null;
    }

    /**
     * Setter for xid.
     *
     * @param value the value to set
     */
    public void setXid(String value) {
        entity.setXid(value);
    }

    /**
     * Getter for objectId.
     *
     * @return value for objectId
     */
    @XmlElement
    public String getObjectId() {
        return (expandLevel > 0) ? entity.getObjectId() : null;
    }

    /**
     * Setter for objectId.
     *
     * @param value the value to set
     */
    public void setObjectId(String value) {
        entity.setObjectId(value);
    }

    /**
     * Getter for postId.
     *
     * @return value for postId
     */
    @XmlElement
    public String getPostId() {
        return (expandLevel > 0) ? entity.getPostId() : null;
    }

    /**
     * Setter for postId.
     *
     * @param value the value to set
     */
    public void setPostId(String value) {
        entity.setPostId(value);
    }

    /**
     * Getter for fromid.
     *
     * @return value for fromid
     */
    @XmlElement
    public String getFromid() {
        return (expandLevel > 0) ? entity.getFromid() : null;
    }

    /**
     * Setter for fromid.
     *
     * @param value the value to set
     */
    public void setFromid(String value) {
        entity.setFromid(value);
    }

    /**
     * Getter for time.
     *
     * @return value for time
     */
    @XmlElement
    public Date getTimeComment() {
        return (expandLevel > 0) ? entity.getTimeComment() : null;
    }

    /**
     * Setter for time.
     *
     * @param value the value to set
     */
    public void setTimeComment(Date value) {
        entity.setTimeComment(value);
    }

    /**
     * Getter for text.
     *
     * @return value for text
     */
    @XmlElement
    public String getText() {
        return (expandLevel > 0) ? entity.getText() : null;
    }

    /**
     * Setter for text.
     *
     * @param value the value to set
     */
    public void setText(String value) {
        entity.setText(value);
    }

    /**
     * Getter for id.
     *
     * @return value for id
     */
    @XmlElement
    public String getId() {
        return (expandLevel > 0) ? entity.getId() : null;
    }

    /**
     * Setter for id.
     *
     * @param value the value to set
     */
    public void setId(String value) {
        entity.setId(value);
    }

    /**
     * Getter for username.
     *
     * @return value for username
     */
    @XmlElement
    public String getUsername() {
        return (expandLevel > 0) ? entity.getUsername() : null;
    }

    /**
     * Setter for username.
     *
     * @param value the value to set
     */
    public void setUsername(String value) {
        entity.setUsername(value);
    }

    /**
     * Getter for replyXid.
     *
     * @return value for replyXid
     */
    @XmlElement
    public String getReplyXid() {
        return (expandLevel > 0) ? entity.getReplyXid() : null;
    }

    /**
     * Setter for replyXid.
     *
     * @param value the value to set
     */
    public void setReplyXid(String value) {
        entity.setReplyXid(value);
    }

    /**
     * Getter for commentsFacebookIdCommentsFacebook.
     *
     * @return value for commentsFacebookIdCommentsFacebook
     */
    @XmlElement
    public Integer getCommentsFacebookIdCommentsFacebook() {
        return (expandLevel > 0) ? entity.getCommentsFacebookIdCommentsFacebook() : null;
    }

    /**
     * Setter for commentsFacebookIdCommentsFacebook.
     *
     * @param value the value to set
     */
    public void setCommentsFacebookIdCommentsFacebook(Integer value) {
        entity.setCommentsFacebookIdCommentsFacebook(value);
    }

    /**
     * Returns the URI associated with this converter.
     *
     * @return the uri
     */
    @XmlAttribute
    public URI getUri() {
        return uri;
    }

    /**
     * Sets the URI for this reference converter.
     *
     */
    public void setUri(URI uri) {
        this.uri = uri;
    }

    /**
     * Returns the CommentFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public CommentFacebook getEntity() {
        if (entity.getXid() == null) {
            CommentFacebookConverter converter = UriResolver.getInstance().resolve(CommentFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved CommentFacebook entity.
     *
     * @return an resolved entity
     */
    public CommentFacebook resolveEntity(EntityManager em) {
        return entity;
    }
}
