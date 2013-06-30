/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.PresenceopenSocial;
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

@XmlRootElement(name = "presenceopenSocial")
public class PresenceopenSocialConverter {
    private PresenceopenSocial entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PresenceopenSocialConverter */
    public PresenceopenSocialConverter() {
        entity = new PresenceopenSocial();
    }

    /**
     * Creates a new instance of PresenceopenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public PresenceopenSocialConverter(PresenceopenSocial entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdPresenceopenSocial() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of PresenceopenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PresenceopenSocialConverter(PresenceopenSocial entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idPresenceopenSocial.
     *
     * @return value for idPresenceopenSocial
     */
    @XmlElement
    public Integer getIdPresenceopenSocial() {
        return (expandLevel > 0) ? entity.getIdPresenceopenSocial() : null;
    }

    /**
     * Setter for idPresenceopenSocial.
     *
     * @param value the value to set
     */
    public void setIdPresenceopenSocial(Integer value) {
        entity.setIdPresenceopenSocial(value);
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
     * Returns the PresenceopenSocial entity.
     *
     * @return an entity
     */
    @XmlTransient
    public PresenceopenSocial getEntity() {
        if (entity.getIdPresenceopenSocial() == null) {
            PresenceopenSocialConverter converter = UriResolver.getInstance().resolve(PresenceopenSocialConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved PresenceopenSocial entity.
     *
     * @return an resolved entity
     */
    public PresenceopenSocial resolveEntity(EntityManager em) {
        return entity;
    }
}
