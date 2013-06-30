/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.FriendsFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import java.util.Collection;
import es.uah.cc.ie.persistence.UserFacebook;
import java.util.Date;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "friendsFacebook")
public class FriendsFacebookConverter {
    private FriendsFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of FriendsFacebookConverter */
    public FriendsFacebookConverter() {
        entity = new FriendsFacebook();
    }

    /**
     * Creates a new instance of FriendsFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public FriendsFacebookConverter(FriendsFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getUserUid() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserFacebookCollection();
    }

    /**
     * Creates a new instance of FriendsFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public FriendsFacebookConverter(FriendsFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for userUid.
     *
     * @return value for userUid
     */
    @XmlElement
    public String getUserUid() {
        return (expandLevel > 0) ? entity.getUserUid() : null;
    }

    /**
     * Setter for userUid.
     *
     * @param value the value to set
     */
    public void setUserUid(String value) {
        entity.setUserUid(value);
    }

    /**
     * Getter for userName.
     *
     * @return value for userName
     */
    @XmlElement
    public String getUserName() {
        return (expandLevel > 0) ? entity.getUserName() : null;
    }

    /**
     * Setter for userName.
     *
     * @param value the value to set
     */
    public void setUserName(String value) {
        entity.setUserName(value);
    }

    /**
     * Getter for userBirthday.
     *
     * @return value for userName
     */
    @XmlElement
    public String getUserBirthday() {
        return (expandLevel > 0) ? entity.getUserBirthday() : null;
    }

    /**
     * Setter for userBirthday.
     *
     * @param value the value to set
     */
    public void setUserBirthday(String value) {
        entity.setUserBirthday(value);
    }

        /**
     * Getter for userPath.
     *
     * @return value for userPath
     */
    @XmlElement
    public String getUserPic() {
        return (expandLevel > 0) ? entity.getUserPic() : null;
    }

    /**
     * Setter for userPath.
     *
     * @param value the value to set
     */
    public void setUserPic(String value) {
        entity.setUserPic(value);
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
     * Returns the FriendsFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public FriendsFacebook getEntity() {
        if (entity.getUserUid() == null) {
            FriendsFacebookConverter converter = UriResolver.getInstance().resolve(FriendsFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved FriendsFacebook entity.
     *
     * @return an resolved entity
     */
    public FriendsFacebook resolveEntity(EntityManager em) {
        Collection<UserFacebook> userFacebookCollection = entity.getUserFacebookCollection();
        Collection<UserFacebook> newuserFacebookCollection = new java.util.ArrayList<UserFacebook>();
        if (userFacebookCollection != null) {
            for (UserFacebook item : userFacebookCollection) {
                newuserFacebookCollection.add(em.getReference(UserFacebook.class, item.getIdUserFacebook()));
            }
        }
        entity.setUserFacebookCollection(newuserFacebookCollection);
        return entity;
    }
}
