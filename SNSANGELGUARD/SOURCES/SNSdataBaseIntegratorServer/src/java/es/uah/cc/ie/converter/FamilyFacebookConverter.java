/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.FamilyFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.RelationshipFacebook;
import java.util.Collection;
import es.uah.cc.ie.persistence.UserFacebook;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "familyFacebook")
public class FamilyFacebookConverter {
    private FamilyFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of FamilyFacebookConverter */
    public FamilyFacebookConverter() {
        entity = new FamilyFacebook();
    }

    /**
     * Creates a new instance of FamilyFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public FamilyFacebookConverter(FamilyFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdFamilyFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserFacebookCollection();
        getRelationshipFacebook();
    }

    /**
     * Creates a new instance of FamilyFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public FamilyFacebookConverter(FamilyFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idFamilyFacebook.
     *
     * @return value for idFamilyFacebook
     */
    @XmlElement
    public Integer getIdFamilyFacebook() {
        return (expandLevel > 0) ? entity.getIdFamilyFacebook() : null;
    }

    /**
     * Setter for idFamilyFacebook.
     *
     * @param value the value to set
     */
    public void setIdFamilyFacebook(Integer value) {
        entity.setIdFamilyFacebook(value);
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
     * Getter for name.
     *
     * @return value for name
     */
    @XmlElement
    public String getName() {
        return (expandLevel > 0) ? entity.getName() : null;
    }

    /**
     * Setter for name.
     *
     * @param value the value to set
     */
    public void setName(String value) {
        entity.setName(value);
    }

    /**
     * Getter for birthday.
     *
     * @return value for birthday
     */
    @XmlElement
    public String getBirthday() {
        return (expandLevel > 0) ? entity.getBirthday() : null;
    }

    /**
     * Setter for birthday.
     *
     * @param value the value to set
     */
    public void setBirthday(String value) {
        entity.setBirthday(value);
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
     * Getter for relationshipFacebook.
     *
     * @return value for relationshipFacebook
     */
    @XmlElement
    public RelationshipFacebookConverter getRelationshipFacebook() {
        if (expandLevel > 0) {
            if (entity.getRelationshipFacebook() != null) {
                return new RelationshipFacebookConverter(entity.getRelationshipFacebook(), uri.resolve("relationshipFacebook/"), expandLevel - 1, false);
            }
        }
        return null;
    }

    /**
     * Setter for relationshipFacebook.
     *
     * @param value the value to set
     */
    public void setRelationshipFacebook(RelationshipFacebookConverter value) {
        entity.setRelationshipFacebook((value != null) ? value.getEntity() : null);
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
     * Returns the FamilyFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public FamilyFacebook getEntity() {
        if (entity.getIdFamilyFacebook() == null) {
            FamilyFacebookConverter converter = UriResolver.getInstance().resolve(FamilyFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved FamilyFacebook entity.
     *
     * @return an resolved entity
     */
    public FamilyFacebook resolveEntity(EntityManager em) {
        Collection<UserFacebook> userFacebookCollection = entity.getUserFacebookCollection();
        Collection<UserFacebook> newuserFacebookCollection = new java.util.ArrayList<UserFacebook>();
        if (userFacebookCollection != null) {
            for (UserFacebook item : userFacebookCollection) {
                newuserFacebookCollection.add(em.getReference(UserFacebook.class, item.getIdUserFacebook()));
            }
        }
        entity.setUserFacebookCollection(newuserFacebookCollection);
        RelationshipFacebook relationshipFacebook = entity.getRelationshipFacebook();
        if (relationshipFacebook != null) {
            entity.setRelationshipFacebook(em.getReference(RelationshipFacebook.class, relationshipFacebook.getIdRelationshipFacebook()));
        }
        return entity;
    }
}
