/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SmokeropenSocial;
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

@XmlRootElement(name = "smokeropenSocial")
public class SmokeropenSocialConverter {
    private SmokeropenSocial entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SmokeropenSocialConverter */
    public SmokeropenSocialConverter() {
        entity = new SmokeropenSocial();
    }

    /**
     * Creates a new instance of SmokeropenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public SmokeropenSocialConverter(SmokeropenSocial entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdSmokeropenSocial() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of SmokeropenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SmokeropenSocialConverter(SmokeropenSocial entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idSmokeropenSocial.
     *
     * @return value for idSmokeropenSocial
     */
    @XmlElement
    public Integer getIdSmokeropenSocial() {
        return (expandLevel > 0) ? entity.getIdSmokeropenSocial() : null;
    }

    /**
     * Setter for idSmokeropenSocial.
     *
     * @param value the value to set
     */
    public void setIdSmokeropenSocial(Integer value) {
        entity.setIdSmokeropenSocial(value);
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
     * Returns the SmokeropenSocial entity.
     *
     * @return an entity
     */
    @XmlTransient
    public SmokeropenSocial getEntity() {
        if (entity.getIdSmokeropenSocial() == null) {
            SmokeropenSocialConverter converter = UriResolver.getInstance().resolve(SmokeropenSocialConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved SmokeropenSocial entity.
     *
     * @return an resolved entity
     */
    public SmokeropenSocial resolveEntity(EntityManager em) {
        return entity;
    }
}
