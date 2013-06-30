/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.RelationshipFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.FamilyFacebook;
import java.util.Collection;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "relationshipFacebook")
public class RelationshipFacebookConverter {
    private RelationshipFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of RelationshipFacebookConverter */
    public RelationshipFacebookConverter() {
        entity = new RelationshipFacebook();
    }

    /**
     * Creates a new instance of RelationshipFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public RelationshipFacebookConverter(RelationshipFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdRelationshipFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getFamilyFacebookCollection();
    }

    /**
     * Creates a new instance of RelationshipFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public RelationshipFacebookConverter(RelationshipFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idRelationshipFacebook.
     *
     * @return value for idRelationshipFacebook
     */
    @XmlElement
    public Integer getIdRelationshipFacebook() {
        return (expandLevel > 0) ? entity.getIdRelationshipFacebook() : null;
    }

    /**
     * Setter for idRelationshipFacebook.
     *
     * @param value the value to set
     */
    public void setIdRelationshipFacebook(Integer value) {
        entity.setIdRelationshipFacebook(value);
    }

    /**
     * Getter for description.
     *
     * @return value for description
     */
    @XmlElement
    public String getDescription() {
        return (expandLevel > 0) ? entity.getDescription() : null;
    }

    /**
     * Setter for description.
     *
     * @param value the value to set
     */
    public void setDescription(String value) {
        entity.setDescription(value);
    }

    /**
     * Getter for familyFacebookCollection.
     *
     * @return value for familyFacebookCollection
     */
    @XmlElement
    public FamilyFacebooksConverter getFamilyFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getFamilyFacebookCollection() != null) {
                return new FamilyFacebooksConverter(entity.getFamilyFacebookCollection(), uri.resolve("familyFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for familyFacebookCollection.
     *
     * @param value the value to set
     */
    public void setFamilyFacebookCollection(FamilyFacebooksConverter value) {
        entity.setFamilyFacebookCollection((value != null) ? value.getEntities() : null);
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
     * Returns the RelationshipFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public RelationshipFacebook getEntity() {
        if (entity.getIdRelationshipFacebook() == null) {
            RelationshipFacebookConverter converter = UriResolver.getInstance().resolve(RelationshipFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved RelationshipFacebook entity.
     *
     * @return an resolved entity
     */
    public RelationshipFacebook resolveEntity(EntityManager em) {
        Collection<FamilyFacebook> familyFacebookCollection = entity.getFamilyFacebookCollection();
        Collection<FamilyFacebook> newfamilyFacebookCollection = new java.util.ArrayList<FamilyFacebook>();
        if (familyFacebookCollection != null) {
            for (FamilyFacebook item : familyFacebookCollection) {
                newfamilyFacebookCollection.add(em.getReference(FamilyFacebook.class, item.getIdFamilyFacebook()));
            }
        }
        entity.setFamilyFacebookCollection(newfamilyFacebookCollection);
        return entity;
    }
}
