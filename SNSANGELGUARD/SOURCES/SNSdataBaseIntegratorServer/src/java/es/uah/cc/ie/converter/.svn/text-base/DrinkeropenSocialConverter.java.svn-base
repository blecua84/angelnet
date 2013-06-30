/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.DrinkeropenSocial;
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

@XmlRootElement(name = "drinkeropenSocial")
public class DrinkeropenSocialConverter {
    private DrinkeropenSocial entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of DrinkeropenSocialConverter */
    public DrinkeropenSocialConverter() {
        entity = new DrinkeropenSocial();
    }

    /**
     * Creates a new instance of DrinkeropenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public DrinkeropenSocialConverter(DrinkeropenSocial entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdDrinkeropenSocial() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of DrinkeropenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public DrinkeropenSocialConverter(DrinkeropenSocial entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idDrinkeropenSocial.
     *
     * @return value for idDrinkeropenSocial
     */
    @XmlElement
    public Integer getIdDrinkeropenSocial() {
        return (expandLevel > 0) ? entity.getIdDrinkeropenSocial() : null;
    }

    /**
     * Setter for idDrinkeropenSocial.
     *
     * @param value the value to set
     */
    public void setIdDrinkeropenSocial(Integer value) {
        entity.setIdDrinkeropenSocial(value);
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
     * Returns the DrinkeropenSocial entity.
     *
     * @return an entity
     */
    @XmlTransient
    public DrinkeropenSocial getEntity() {
        if (entity.getIdDrinkeropenSocial() == null) {
            DrinkeropenSocialConverter converter = UriResolver.getInstance().resolve(DrinkeropenSocialConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved DrinkeropenSocial entity.
     *
     * @return an resolved entity
     */
    public DrinkeropenSocial resolveEntity(EntityManager em) {
        return entity;
    }
}
