/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.FriendsLikesFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.LikesFacebook;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "friendsLikesFacebook")
public class FriendsLikesFacebookConverter {
    private FriendsLikesFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of FriendsLikesFacebookConverter */
    public FriendsLikesFacebookConverter() {
        entity = new FriendsLikesFacebook();
    }

    /**
     * Creates a new instance of FriendsLikesFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public FriendsLikesFacebookConverter(FriendsLikesFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdFriendsLikesFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getLikesFacebook();
    }

    /**
     * Creates a new instance of FriendsLikesFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public FriendsLikesFacebookConverter(FriendsLikesFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idFriendsLikesFacebook.
     *
     * @return value for idFriendsLikesFacebook
     */
    @XmlElement
    public Integer getIdFriendsLikesFacebook() {
        return (expandLevel > 0) ? entity.getIdFriendsLikesFacebook() : null;
    }

    /**
     * Setter for idFriendsLikesFacebook.
     *
     * @param value the value to set
     */
    public void setIdFriendsLikesFacebook(Integer value) {
        entity.setIdFriendsLikesFacebook(value);
    }

    /**
     * Getter for uid.
     *
     * @return value for uid
     */
    @XmlElement
    public String getUid() {
        return (expandLevel > 0) ? entity.getUid() : null;
    }

    /**
     * Setter for uid.
     *
     * @param value the value to set
     */
    public void setUid(String value) {
        entity.setUid(value);
    }

    /**
     * Getter for likesFacebook.
     *
     * @return value for likesFacebook
     */
    @XmlElement
    public LikesFacebookConverter getLikesFacebook() {
        if (expandLevel > 0) {
            if (entity.getLikesFacebook() != null) {
                return new LikesFacebookConverter(entity.getLikesFacebook(), uri.resolve("likesFacebook/"), expandLevel - 1, false);
            }
        }
        return null;
    }

    /**
     * Setter for likesFacebook.
     *
     * @param value the value to set
     */
    public void setLikesFacebook(LikesFacebookConverter value) {
        entity.setLikesFacebook((value != null) ? value.getEntity() : null);
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
     * Returns the FriendsLikesFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public FriendsLikesFacebook getEntity() {
        if (entity.getIdFriendsLikesFacebook() == null) {
            FriendsLikesFacebookConverter converter = UriResolver.getInstance().resolve(FriendsLikesFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved FriendsLikesFacebook entity.
     *
     * @return an resolved entity
     */
    public FriendsLikesFacebook resolveEntity(EntityManager em) {
        LikesFacebook likesFacebook = entity.getLikesFacebook();
        if (likesFacebook != null) {
            entity.setLikesFacebook(em.getReference(LikesFacebook.class, likesFacebook.getIdLikesFacebook()));
        }
        return entity;
    }
}
