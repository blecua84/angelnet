/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.LookingForopenSocial;
import java.net.URI;
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

@XmlRootElement(name = "lookingForopenSocial")
public class LookingForopenSocialConverter {
    private LookingForopenSocial entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of LookingForopenSocialConverter */
    public LookingForopenSocialConverter() {
        entity = new LookingForopenSocial();
    }

    /**
     * Creates a new instance of LookingForopenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public LookingForopenSocialConverter(LookingForopenSocial entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdLookingForopenSocial() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of LookingForopenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public LookingForopenSocialConverter(LookingForopenSocial entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idLookingForopenSocial.
     *
     * @return value for idLookingForopenSocial
     */
    @XmlElement
    public Integer getIdLookingForopenSocial() {
        return (expandLevel > 0) ? entity.getIdLookingForopenSocial() : null;
    }

    /**
     * Setter for idLookingForopenSocial.
     *
     * @param value the value to set
     */
    public void setIdLookingForopenSocial(Integer value) {
        entity.setIdLookingForopenSocial(value);
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
     * Returns the LookingForopenSocial entity.
     *
     * @return an entity
     */
    @XmlTransient
    public LookingForopenSocial getEntity() {
        if (entity.getIdLookingForopenSocial() == null) {
            LookingForopenSocialConverter converter = UriResolver.getInstance().resolve(LookingForopenSocialConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved LookingForopenSocial entity.
     *
     * @return an resolved entity
     */
    public LookingForopenSocial resolveEntity(EntityManager em) {
        return entity;
    }
}
