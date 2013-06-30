/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.GenderopenSocial;
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

@XmlRootElement(name = "genderopenSocial")
public class GenderopenSocialConverter {
    private GenderopenSocial entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of GenderopenSocialConverter */
    public GenderopenSocialConverter() {
        entity = new GenderopenSocial();
    }

    /**
     * Creates a new instance of GenderopenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public GenderopenSocialConverter(GenderopenSocial entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdGenderopenSocial() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of GenderopenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public GenderopenSocialConverter(GenderopenSocial entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idGenderopenSocial.
     *
     * @return value for idGenderopenSocial
     */
    @XmlElement
    public Integer getIdGenderopenSocial() {
        return (expandLevel > 0) ? entity.getIdGenderopenSocial() : null;
    }

    /**
     * Setter for idGenderopenSocial.
     *
     * @param value the value to set
     */
    public void setIdGenderopenSocial(Integer value) {
        entity.setIdGenderopenSocial(value);
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
     * Returns the GenderopenSocial entity.
     *
     * @return an entity
     */
    @XmlTransient
    public GenderopenSocial getEntity() {
        if (entity.getIdGenderopenSocial() == null) {
            GenderopenSocialConverter converter = UriResolver.getInstance().resolve(GenderopenSocialConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved GenderopenSocial entity.
     *
     * @return an resolved entity
     */
    public GenderopenSocial resolveEntity(EntityManager em) {
        return entity;
    }
}
