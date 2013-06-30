/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.TypeAffiliationsFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.AffiliationsFacebook;
import java.util.Collection;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "typeAffiliationsFacebook")
public class TypeAffiliationsFacebookConverter {
    private TypeAffiliationsFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of TypeAffiliationsFacebookConverter */
    public TypeAffiliationsFacebookConverter() {
        entity = new TypeAffiliationsFacebook();
    }

    /**
     * Creates a new instance of TypeAffiliationsFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public TypeAffiliationsFacebookConverter(TypeAffiliationsFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdTypeAffiliationsFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getAffiliationsFacebookCollection();
    }

    /**
     * Creates a new instance of TypeAffiliationsFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public TypeAffiliationsFacebookConverter(TypeAffiliationsFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idTypeAffiliationsFacebook.
     *
     * @return value for idTypeAffiliationsFacebook
     */
    @XmlElement
    public Integer getIdTypeAffiliationsFacebook() {
        return (expandLevel > 0) ? entity.getIdTypeAffiliationsFacebook() : null;
    }

    /**
     * Setter for idTypeAffiliationsFacebook.
     *
     * @param value the value to set
     */
    public void setIdTypeAffiliationsFacebook(Integer value) {
        entity.setIdTypeAffiliationsFacebook(value);
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
     * Getter for affiliationsFacebookCollection.
     *
     * @return value for affiliationsFacebookCollection
     */
    @XmlElement
    public AffiliationsFacebooksConverter getAffiliationsFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getAffiliationsFacebookCollection() != null) {
                return new AffiliationsFacebooksConverter(entity.getAffiliationsFacebookCollection(), uri.resolve("affiliationsFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for affiliationsFacebookCollection.
     *
     * @param value the value to set
     */
    public void setAffiliationsFacebookCollection(AffiliationsFacebooksConverter value) {
        entity.setAffiliationsFacebookCollection((value != null) ? value.getEntities() : null);
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
     * Returns the TypeAffiliationsFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public TypeAffiliationsFacebook getEntity() {
        if (entity.getIdTypeAffiliationsFacebook() == null) {
            TypeAffiliationsFacebookConverter converter = UriResolver.getInstance().resolve(TypeAffiliationsFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved TypeAffiliationsFacebook entity.
     *
     * @return an resolved entity
     */
    public TypeAffiliationsFacebook resolveEntity(EntityManager em) {
        Collection<AffiliationsFacebook> affiliationsFacebookCollection = entity.getAffiliationsFacebookCollection();
        Collection<AffiliationsFacebook> newaffiliationsFacebookCollection = new java.util.ArrayList<AffiliationsFacebook>();
        if (affiliationsFacebookCollection != null) {
            for (AffiliationsFacebook item : affiliationsFacebookCollection) {
                newaffiliationsFacebookCollection.add(em.getReference(AffiliationsFacebook.class, item.getIdAffiliationsFacebook()));
            }
        }
        entity.setAffiliationsFacebookCollection(newaffiliationsFacebookCollection);
        return entity;
    }
}
