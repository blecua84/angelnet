/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.LikesFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.FriendsLikesFacebook;
import es.uah.cc.ie.persistence.SampleLikesFacebook;
import es.uah.cc.ie.persistence.StreamFacebook;
import java.util.Collection;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "likesFacebook")
public class LikesFacebookConverter {
    private LikesFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of LikesFacebookConverter */
    public LikesFacebookConverter() {
        entity = new LikesFacebook();
    }

    /**
     * Creates a new instance of LikesFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public LikesFacebookConverter(LikesFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdLikesFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getFriendsLikesFacebookCollection();
        getStreamFacebook();
        getSampleLikesFacebookCollection();
    }

    /**
     * Creates a new instance of LikesFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public LikesFacebookConverter(LikesFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idLikesFacebook.
     *
     * @return value for idLikesFacebook
     */
    @XmlElement
    public Integer getIdLikesFacebook() {
        return (expandLevel > 0) ? entity.getIdLikesFacebook() : null;
    }

    /**
     * Setter for idLikesFacebook.
     *
     * @param value the value to set
     */
    public void setIdLikesFacebook(Integer value) {
        entity.setIdLikesFacebook(value);
    }

    /**
     * Getter for href.
     *
     * @return value for href
     */
    @XmlElement
    public String getHref() {
        return (expandLevel > 0) ? entity.getHref() : null;
    }

    /**
     * Setter for href.
     *
     * @param value the value to set
     */
    public void setHref(String value) {
        entity.setHref(value);
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
     * Getter for userLikes.
     *
     * @return value for userLikes
     */
    @XmlElement
    public Boolean getUserLikes() {
        return (expandLevel > 0) ? entity.getUserLikes() : null;
    }

    /**
     * Setter for userLikes.
     *
     * @param value the value to set
     */
    public void setUserLikes(Boolean value) {
        entity.setUserLikes(value);
    }

    /**
     * Getter for canLike.
     *
     * @return value for canLike
     */
    @XmlElement
    public Boolean getCanLike() {
        return (expandLevel > 0) ? entity.getCanLike() : null;
    }

    /**
     * Setter for canLike.
     *
     * @param value the value to set
     */
    public void setCanLike(Boolean value) {
        entity.setCanLike(value);
    }

    /**
     * Getter for friendsLikesFacebookCollection.
     *
     * @return value for friendsLikesFacebookCollection
     */
    @XmlElement
    public FriendsLikesFacebooksConverter getFriendsLikesFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getFriendsLikesFacebookCollection() != null) {
                return new FriendsLikesFacebooksConverter(entity.getFriendsLikesFacebookCollection(), uri.resolve("friendsLikesFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for friendsLikesFacebookCollection.
     *
     * @param value the value to set
     */
    public void setFriendsLikesFacebookCollection(FriendsLikesFacebooksConverter value) {
        entity.setFriendsLikesFacebookCollection((value != null) ? value.getEntities() : null);
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
     * Getter for sampleLikesFacebookCollection.
     *
     * @return value for sampleLikesFacebookCollection
     */
    @XmlElement
    public SampleLikesFacebooksConverter getSampleLikesFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getSampleLikesFacebookCollection() != null) {
                return new SampleLikesFacebooksConverter(entity.getSampleLikesFacebookCollection(), uri.resolve("sampleLikesFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for sampleLikesFacebookCollection.
     *
     * @param value the value to set
     */
    public void setSampleLikesFacebookCollection(SampleLikesFacebooksConverter value) {
        entity.setSampleLikesFacebookCollection((value != null) ? value.getEntities() : null);
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
     * Returns the LikesFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public LikesFacebook getEntity() {
        if (entity.getIdLikesFacebook() == null) {
            LikesFacebookConverter converter = UriResolver.getInstance().resolve(LikesFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved LikesFacebook entity.
     *
     * @return an resolved entity
     */
    public LikesFacebook resolveEntity(EntityManager em) {
        Collection<FriendsLikesFacebook> friendsLikesFacebookCollection = entity.getFriendsLikesFacebookCollection();
        Collection<FriendsLikesFacebook> newfriendsLikesFacebookCollection = new java.util.ArrayList<FriendsLikesFacebook>();
        if (friendsLikesFacebookCollection != null) {
            for (FriendsLikesFacebook item : friendsLikesFacebookCollection) {
                newfriendsLikesFacebookCollection.add(em.getReference(FriendsLikesFacebook.class, item.getIdFriendsLikesFacebook()));
            }
        }
        entity.setFriendsLikesFacebookCollection(newfriendsLikesFacebookCollection);
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            entity.setStreamFacebook(em.getReference(StreamFacebook.class, streamFacebook.getPostId()));
        }
        Collection<SampleLikesFacebook> sampleLikesFacebookCollection = entity.getSampleLikesFacebookCollection();
        Collection<SampleLikesFacebook> newsampleLikesFacebookCollection = new java.util.ArrayList<SampleLikesFacebook>();
        if (sampleLikesFacebookCollection != null) {
            for (SampleLikesFacebook item : sampleLikesFacebookCollection) {
                newsampleLikesFacebookCollection.add(em.getReference(SampleLikesFacebook.class, item.getIdSampleLikesFacebook()));
            }
        }
        entity.setSampleLikesFacebookCollection(newsampleLikesFacebookCollection);
        return entity;
    }
}
