/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.AffiliationsFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.TypeAffiliationsFacebook;
import es.uah.cc.ie.persistence.UserFacebook;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "affiliationsFacebook")
public class AffiliationsFacebookConverter {
    private AffiliationsFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of AffiliationsFacebookConverter */
    public AffiliationsFacebookConverter() {
        entity = new AffiliationsFacebook();
    }

    /**
     * Creates a new instance of AffiliationsFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public AffiliationsFacebookConverter(AffiliationsFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdAffiliationsFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserFacebook();
        getTypeAffiliationsFacebook();
    }

    /**
     * Creates a new instance of AffiliationsFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public AffiliationsFacebookConverter(AffiliationsFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idAffiliationsFacebook.
     *
     * @return value for idAffiliationsFacebook
     */
    @XmlElement
    public Integer getIdAffiliationsFacebook() {
        return (expandLevel > 0) ? entity.getIdAffiliationsFacebook() : null;
    }

    /**
     * Setter for idAffiliationsFacebook.
     *
     * @param value the value to set
     */
    public void setIdAffiliationsFacebook(Integer value) {
        entity.setIdAffiliationsFacebook(value);
    }

    /**
     * Getter for year.
     *
     * @return value for year
     */
    @XmlElement
    public String getYear() {
        return (expandLevel > 0) ? entity.getYear() : null;
    }

    /**
     * Setter for year.
     *
     * @param value the value to set
     */
    public void setYear(String value) {
        entity.setYear(value);
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
     * Getter for nid.
     *
     * @return value for nid
     */
    @XmlElement
    public Integer getNid() {
        return (expandLevel > 0) ? entity.getNid() : null;
    }

    /**
     * Setter for nid.
     *
     * @param value the value to set
     */
    public void setNid(Integer value) {
        entity.setNid(value);
    }

    /**
     * Getter for status.
     *
     * @return value for status
     */
    @XmlElement
    public String getStatus() {
        return (expandLevel > 0) ? entity.getStatus() : null;
    }

    /**
     * Setter for status.
     *
     * @param value the value to set
     */
    public void setStatus(String value) {
        entity.setStatus(value);
    }

    /**
     * Getter for userFacebook.
     *
     * @return value for userFacebook
     */
    @XmlElement
    public UserFacebookConverter getUserFacebook() {
        if (expandLevel > 0) {
            if (entity.getUserFacebook() != null) {
                return new UserFacebookConverter(entity.getUserFacebook(), uri.resolve("userFacebook/"), expandLevel - 1, false);
            }
        }
        return null;
    }

    /**
     * Setter for userFacebook.
     *
     * @param value the value to set
     */
    public void setUserFacebook(UserFacebookConverter value) {
        entity.setUserFacebook((value != null) ? value.getEntity() : null);
    }

    /**
     * Getter for typeAffiliationsFacebook.
     *
     * @return value for typeAffiliationsFacebook
     */
    @XmlElement
    public TypeAffiliationsFacebookConverter getTypeAffiliationsFacebook() {
        if (expandLevel > 0) {
            if (entity.getTypeAffiliationsFacebook() != null) {
                return new TypeAffiliationsFacebookConverter(entity.getTypeAffiliationsFacebook(), uri.resolve("typeAffiliationsFacebook/"), expandLevel - 1, false);
            }
        }
        return null;
    }

    /**
     * Setter for typeAffiliationsFacebook.
     *
     * @param value the value to set
     */
    public void setTypeAffiliationsFacebook(TypeAffiliationsFacebookConverter value) {
        entity.setTypeAffiliationsFacebook((value != null) ? value.getEntity() : null);
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
     * Returns the AffiliationsFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public AffiliationsFacebook getEntity() {
        if (entity.getIdAffiliationsFacebook() == null) {
            AffiliationsFacebookConverter converter = UriResolver.getInstance().resolve(AffiliationsFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved AffiliationsFacebook entity.
     *
     * @return an resolved entity
     */
    public AffiliationsFacebook resolveEntity(EntityManager em) {
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            entity.setUserFacebook(em.getReference(UserFacebook.class, userFacebook.getIdUserFacebook()));
        }
        TypeAffiliationsFacebook typeAffiliationsFacebook = entity.getTypeAffiliationsFacebook();
        if (typeAffiliationsFacebook != null) {
            entity.setTypeAffiliationsFacebook(em.getReference(TypeAffiliationsFacebook.class, typeAffiliationsFacebook.getIdTypeAffiliationsFacebook()));
        }
        return entity;
    }
}
