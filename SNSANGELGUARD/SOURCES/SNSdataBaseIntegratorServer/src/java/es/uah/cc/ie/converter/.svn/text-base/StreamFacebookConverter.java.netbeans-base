/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.StreamFacebook;
import java.net.URI;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.LikesFacebook;
import es.uah.cc.ie.persistence.ActionLinksFacebook;
import es.uah.cc.ie.persistence.CommentsFacebook;
import es.uah.cc.ie.persistence.PrivacyFacebook;
import java.util.Collection;
import es.uah.cc.ie.persistence.UserFacebook;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "streamFacebook")
public class StreamFacebookConverter {
    private StreamFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of StreamFacebookConverter */
    public StreamFacebookConverter() {
        entity = new StreamFacebook();
    }

    /**
     * Creates a new instance of StreamFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public StreamFacebookConverter(StreamFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getPostId() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserFacebookCollection();
        getCommentsFacebookCollection();
        getLikesFacebookCollection();
        getActionLinksFacebookCollection();
        getPrivacyFacebookCollection();
    }

    /**
     * Creates a new instance of StreamFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public StreamFacebookConverter(StreamFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
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
     * Getter for viewerId.
     *
     * @return value for viewerId
     */
    @XmlElement
    public String getViewerId() {
        return (expandLevel > 0) ? entity.getViewerId() : null;
    }

    /**
     * Setter for viewerId.
     *
     * @param value the value to set
     */
    public void setViewerId(String value) {
        entity.setViewerId(value);
    }

    /**
     * Getter for appId.
     *
     * @return value for appId
     */
    @XmlElement
    public String getAppId() {
        return (expandLevel > 0) ? entity.getAppId() : null;
    }

    /**
     * Setter for appId.
     *
     * @param value the value to set
     */
    public void setAppId(String value) {
        entity.setAppId(value);
    }

    /**
     * Getter for sourceId.
     *
     * @return value for sourceId
     */
    @XmlElement
    public String getSourceId() {
        return (expandLevel > 0) ? entity.getSourceId() : null;
    }

    /**
     * Setter for sourceId.
     *
     * @param value the value to set
     */
    public void setSourceId(String value) {
        entity.setSourceId(value);
    }

    /**
     * Getter for updatedTime.
     *
     * @return value for updatedTime
     */
    @XmlElement
    public Date getUpdatedTime() {
        return (expandLevel > 0) ? entity.getUpdatedTime() : null;
    }

    /**
     * Setter for updatedTime.
     *
     * @param value the value to set
     */
    public void setUpdatedTime(Date value) {
        entity.setUpdatedTime(value);
    }

    /**
     * Getter for createdTime.
     *
     * @return value for createdTime
     */
    @XmlElement
    public Date getCreatedTime() {
        return (expandLevel > 0) ? entity.getCreatedTime() : null;
    }

    /**
     * Setter for createdTime.
     *
     * @param value the value to set
     */
    public void setCreatedTime(Date value) {
        entity.setCreatedTime(value);
    }

    /**
     * Getter for filterKey.
     *
     * @return value for filterKey
     */
    @XmlElement
    public String getFilterKey() {
        return (expandLevel > 0) ? entity.getFilterKey() : null;
    }

    /**
     * Setter for filterKey.
     *
     * @param value the value to set
     */
    public void setFilterKey(String value) {
        entity.setFilterKey(value);
    }

    /**
     * Getter for attribution.
     *
     * @return value for attribution
     */
    @XmlElement
    public String getAttribution() {
        return (expandLevel > 0) ? entity.getAttribution() : null;
    }

    /**
     * Setter for attribution.
     *
     * @param value the value to set
     */
    public void setAttribution(String value) {
        entity.setAttribution(value);
    }

    /**
     * Getter for actorId.
     *
     * @return value for actorId
     */
    @XmlElement
    public String getActorId() {
        return (expandLevel > 0) ? entity.getActorId() : null;
    }

    /**
     * Setter for actorId.
     *
     * @param value the value to set
     */
    public void setActorId(String value) {
        entity.setActorId(value);
    }

    /**
     * Getter for targetId.
     *
     * @return value for targetId
     */
    @XmlElement
    public String getTargetId() {
        return (expandLevel > 0) ? entity.getTargetId() : null;
    }

    /**
     * Setter for targetId.
     *
     * @param value the value to set
     */
    public void setTargetId(String value) {
        entity.setTargetId(value);
    }

    /**
     * Getter for message.
     *
     * @return value for message
     */
    @XmlElement
    public String getMessage() {
        return (expandLevel > 0) ? entity.getMessage() : null;
    }

    /**
     * Setter for message.
     *
     * @param value the value to set
     */
    public void setMessage(String value) {
        entity.setMessage(value);
    }

    /**
     * Getter for appData.
     *
     * @return value for appData
     */
    @XmlElement
    public String getAppData() {
        return (expandLevel > 0) ? entity.getAppData() : null;
    }

    /**
     * Setter for appData.
     *
     * @param value the value to set
     */
    public void setAppData(String value) {
        entity.setAppData(value);
    }

    /**
     * Getter for attachment.
     *
     * @return value for attachment
     */
    @XmlElement
    public String getAttachment() {
        return (expandLevel > 0) ? entity.getAttachment() : null;
    }

    /**
     * Setter for attachment.
     *
     * @param value the value to set
     */
    public void setAttachment(String value) {
        entity.setAttachment(value);
    }

    /**
     * Getter for type.
     *
     * @return value for type
     */
    @XmlElement
    public String getType() {
        return (expandLevel > 0) ? entity.getType() : null;
    }

    /**
     * Setter for type.
     *
     * @param value the value to set
     */
    public void setType(String value) {
        entity.setType(value);
    }

    /**
     * Getter for permalink.
     *
     * @return value for permalink
     */
    @XmlElement
    public String getPermalink() {
        return (expandLevel > 0) ? entity.getPermalink() : null;
    }

    /**
     * Setter for permalink.
     *
     * @param value the value to set
     */
    public void setPermalink(String value) {
        entity.setPermalink(value);
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
     * Getter for userFacebookCollection.
     *
     * @return value for userFacebookCollection
     */
    @XmlElement
    public UserFacebooksConverter getUserFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getUserFacebookCollection() != null) {
                return new UserFacebooksConverter(entity.getUserFacebookCollection(), uri.resolve("userFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for userFacebookCollection.
     *
     * @param value the value to set
     */
    public void setUserFacebookCollection(UserFacebooksConverter value) {
        entity.setUserFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for commentsFacebookCollection.
     *
     * @return value for commentsFacebookCollection
     */
    @XmlElement
    public CommentsFacebooksConverter getCommentsFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getCommentsFacebookCollection() != null) {
                return new CommentsFacebooksConverter(entity.getCommentsFacebookCollection(), uri.resolve("commentsFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for commentsFacebookCollection.
     *
     * @param value the value to set
     */
    public void setCommentsFacebookCollection(CommentsFacebooksConverter value) {
        entity.setCommentsFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for likesFacebookCollection.
     *
     * @return value for likesFacebookCollection
     */
    @XmlElement
    public LikesFacebooksConverter getLikesFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getLikesFacebookCollection() != null) {
                return new LikesFacebooksConverter(entity.getLikesFacebookCollection(), uri.resolve("likesFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for likesFacebookCollection.
     *
     * @param value the value to set
     */
    public void setLikesFacebookCollection(LikesFacebooksConverter value) {
        entity.setLikesFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for actionLinksFacebookCollection.
     *
     * @return value for actionLinksFacebookCollection
     */
    @XmlElement
    public ActionLinksFacebooksConverter getActionLinksFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getActionLinksFacebookCollection() != null) {
                return new ActionLinksFacebooksConverter(entity.getActionLinksFacebookCollection(), uri.resolve("actionLinksFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for actionLinksFacebookCollection.
     *
     * @param value the value to set
     */
    public void setActionLinksFacebookCollection(ActionLinksFacebooksConverter value) {
        entity.setActionLinksFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for privacyFacebookCollection.
     *
     * @return value for privacyFacebookCollection
     */
    @XmlElement
    public PrivacyFacebooksConverter getPrivacyFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getPrivacyFacebookCollection() != null) {
                return new PrivacyFacebooksConverter(entity.getPrivacyFacebookCollection(), uri.resolve("privacyFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for privacyFacebookCollection.
     *
     * @param value the value to set
     */
    public void setPrivacyFacebookCollection(PrivacyFacebooksConverter value) {
        entity.setPrivacyFacebookCollection((value != null) ? value.getEntities() : null);
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
     * Returns the StreamFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public StreamFacebook getEntity() {
        if (entity.getPostId() == null) {
            StreamFacebookConverter converter = UriResolver.getInstance().resolve(StreamFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved StreamFacebook entity.
     *
     * @return an resolved entity
     */
    public StreamFacebook resolveEntity(EntityManager em) {
        Collection<UserFacebook> userFacebookCollection = entity.getUserFacebookCollection();
        Collection<UserFacebook> newuserFacebookCollection = new java.util.ArrayList<UserFacebook>();
        if (userFacebookCollection != null) {
            for (UserFacebook item : userFacebookCollection) {
                newuserFacebookCollection.add(em.getReference(UserFacebook.class, item.getIdUserFacebook()));
            }
        }
        entity.setUserFacebookCollection(newuserFacebookCollection);
        Collection<CommentsFacebook> commentsFacebookCollection = entity.getCommentsFacebookCollection();
        Collection<CommentsFacebook> newcommentsFacebookCollection = new java.util.ArrayList<CommentsFacebook>();
        if (commentsFacebookCollection != null) {
            for (CommentsFacebook item : commentsFacebookCollection) {
                newcommentsFacebookCollection.add(em.getReference(CommentsFacebook.class, item.getIdCommentsFacebook()));
            }
        }
        entity.setCommentsFacebookCollection(newcommentsFacebookCollection);
        Collection<LikesFacebook> likesFacebookCollection = entity.getLikesFacebookCollection();
        Collection<LikesFacebook> newlikesFacebookCollection = new java.util.ArrayList<LikesFacebook>();
        if (likesFacebookCollection != null) {
            for (LikesFacebook item : likesFacebookCollection) {
                newlikesFacebookCollection.add(em.getReference(LikesFacebook.class, item.getIdLikesFacebook()));
            }
        }
        entity.setLikesFacebookCollection(newlikesFacebookCollection);
        Collection<ActionLinksFacebook> actionLinksFacebookCollection = entity.getActionLinksFacebookCollection();
        Collection<ActionLinksFacebook> newactionLinksFacebookCollection = new java.util.ArrayList<ActionLinksFacebook>();
        if (actionLinksFacebookCollection != null) {
            for (ActionLinksFacebook item : actionLinksFacebookCollection) {
                newactionLinksFacebookCollection.add(em.getReference(ActionLinksFacebook.class, item.getIdActionLinksFacebook()));
            }
        }
        entity.setActionLinksFacebookCollection(newactionLinksFacebookCollection);
        Collection<PrivacyFacebook> privacyFacebookCollection = entity.getPrivacyFacebookCollection();
        Collection<PrivacyFacebook> newprivacyFacebookCollection = new java.util.ArrayList<PrivacyFacebook>();
        if (privacyFacebookCollection != null) {
            for (PrivacyFacebook item : privacyFacebookCollection) {
                newprivacyFacebookCollection.add(em.getReference(PrivacyFacebook.class, item.getIdPrivacyFacebook()));
            }
        }
        entity.setPrivacyFacebookCollection(newprivacyFacebookCollection);
        return entity;
    }
}
