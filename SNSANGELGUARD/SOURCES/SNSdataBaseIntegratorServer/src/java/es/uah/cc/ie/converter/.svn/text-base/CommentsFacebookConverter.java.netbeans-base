/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.CommentsFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.StreamFacebook;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "commentsFacebook")
public class CommentsFacebookConverter {
    private CommentsFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of CommentsFacebookConverter */
    public CommentsFacebookConverter() {
        entity = new CommentsFacebook();
    }

    /**
     * Creates a new instance of CommentsFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public CommentsFacebookConverter(CommentsFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdCommentsFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getStreamFacebook();
    }

    /**
     * Creates a new instance of CommentsFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public CommentsFacebookConverter(CommentsFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idCommentsFacebook.
     *
     * @return value for idCommentsFacebook
     */
    @XmlElement
    public Integer getIdCommentsFacebook() {
        return (expandLevel > 0) ? entity.getIdCommentsFacebook() : null;
    }

    /**
     * Setter for idCommentsFacebook.
     *
     * @param value the value to set
     */
    public void setIdCommentsFacebook(Integer value) {
        entity.setIdCommentsFacebook(value);
    }

    /**
     * Getter for canRemove.
     *
     * @return value for canRemove
     */
    @XmlElement
    public Boolean getCanRemove() {
        return (expandLevel > 0) ? entity.getCanRemove() : null;
    }

    /**
     * Setter for canRemove.
     *
     * @param value the value to set
     */
    public void setCanRemove(Boolean value) {
        entity.setCanRemove(value);
    }

    /**
     * Getter for canPost.
     *
     * @return value for canPost
     */
    @XmlElement
    public Boolean getCanPost() {
        return (expandLevel > 0) ? entity.getCanPost() : null;
    }

    /**
     * Setter for canPost.
     *
     * @param value the value to set
     */
    public void setCanPost(Boolean value) {
        entity.setCanPost(value);
    }

    /**
     * Getter for count.
     *
     * @return value for count
     */
    @XmlElement
    public Integer getCount() {
        return (expandLevel > 0) ? entity.getCount() : null;
    }

    /**
     * Setter for count.
     *
     * @param value the value to set
     */
    public void setCount(Integer value) {
        entity.setCount(value);
    }

    /**
     * Getter for streamFacebook.
     *
     * @return value for streamFacebook
     */
    @XmlElement
    public StreamFacebookConverter getStreamFacebook() {
        if (expandLevel > 0) {
            if (entity.getStreamFacebook() != null) {
                return new StreamFacebookConverter(entity.getStreamFacebook(), uri.resolve("streamFacebook/"), expandLevel - 1, false);
            }
        }
        return null;
    }

    /**
     * Setter for streamFacebook.
     *
     * @param value the value to set
     */
    public void setStreamFacebook(StreamFacebookConverter value) {
        entity.setStreamFacebook((value != null) ? value.getEntity() : null);
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
     * Returns the CommentsFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public CommentsFacebook getEntity() {
        if (entity.getIdCommentsFacebook() == null) {
            CommentsFacebookConverter converter = UriResolver.getInstance().resolve(CommentsFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved CommentsFacebook entity.
     *
     * @return an resolved entity
     */
    public CommentsFacebook resolveEntity(EntityManager em) {
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            entity.setStreamFacebook(em.getReference(StreamFacebook.class, streamFacebook.getPostId()));
        }
        return entity;
    }
}
