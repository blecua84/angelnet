/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.AddressopenSocial;
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

@XmlRootElement(name = "addressopenSocial")
public class AddressopenSocialConverter {
    private AddressopenSocial entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of AddressopenSocialConverter */
    public AddressopenSocialConverter() {
        entity = new AddressopenSocial();
    }

    /**
     * Creates a new instance of AddressopenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public AddressopenSocialConverter(AddressopenSocial entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdAddressopenSocial() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of AddressopenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public AddressopenSocialConverter(AddressopenSocial entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idAddressopenSocial.
     *
     * @return value for idAddressopenSocial
     */
    @XmlElement
    public String getIdAddressopenSocial() {
        return (expandLevel > 0) ? entity.getIdAddressopenSocial() : null;
    }

    /**
     * Setter for idAddressopenSocial.
     *
     * @param value the value to set
     */
    public void setIdAddressopenSocial(String value) {
        entity.setIdAddressopenSocial(value);
    }

    /**
     * Getter for country.
     *
     * @return value for country
     */
    @XmlElement
    public String getCountry() {
        return (expandLevel > 0) ? entity.getCountry() : null;
    }

    /**
     * Setter for country.
     *
     * @param value the value to set
     */
    public void setCountry(String value) {
        entity.setCountry(value);
    }

    /**
     * Getter for extendedAddress.
     *
     * @return value for extendedAddress
     */
    @XmlElement
    public String getExtendedAddress() {
        return (expandLevel > 0) ? entity.getExtendedAddress() : null;
    }

    /**
     * Setter for extendedAddress.
     *
     * @param value the value to set
     */
    public void setExtendedAddress(String value) {
        entity.setExtendedAddress(value);
    }

    /**
     * Getter for latitude.
     *
     * @return value for latitude
     */
    @XmlElement
    public Integer getLatitude() {
        return (expandLevel > 0) ? entity.getLatitude() : null;
    }

    /**
     * Setter for latitude.
     *
     * @param value the value to set
     */
    public void setLatitude(Integer value) {
        entity.setLatitude(value);
    }

    /**
     * Getter for locality.
     *
     * @return value for locality
     */
    @XmlElement
    public String getLocality() {
        return (expandLevel > 0) ? entity.getLocality() : null;
    }

    /**
     * Setter for locality.
     *
     * @param value the value to set
     */
    public void setLocality(String value) {
        entity.setLocality(value);
    }

    /**
     * Getter for longitude.
     *
     * @return value for longitude
     */
    @XmlElement
    public Integer getLongitude() {
        return (expandLevel > 0) ? entity.getLongitude() : null;
    }

    /**
     * Setter for longitude.
     *
     * @param value the value to set
     */
    public void setLongitude(Integer value) {
        entity.setLongitude(value);
    }

    /**
     * Getter for poBox.
     *
     * @return value for poBox
     */
    @XmlElement
    public String getPoBox() {
        return (expandLevel > 0) ? entity.getPoBox() : null;
    }

    /**
     * Setter for poBox.
     *
     * @param value the value to set
     */
    public void setPoBox(String value) {
        entity.setPoBox(value);
    }

    /**
     * Getter for postalCode.
     *
     * @return value for postalCode
     */
    @XmlElement
    public String getPostalCode() {
        return (expandLevel > 0) ? entity.getPostalCode() : null;
    }

    /**
     * Setter for postalCode.
     *
     * @param value the value to set
     */
    public void setPostalCode(String value) {
        entity.setPostalCode(value);
    }

    /**
     * Getter for region.
     *
     * @return value for region
     */
    @XmlElement
    public String getRegion() {
        return (expandLevel > 0) ? entity.getRegion() : null;
    }

    /**
     * Setter for region.
     *
     * @param value the value to set
     */
    public void setRegion(String value) {
        entity.setRegion(value);
    }

    /**
     * Getter for streetAddress.
     *
     * @return value for streetAddress
     */
    @XmlElement
    public String getStreetAddress() {
        return (expandLevel > 0) ? entity.getStreetAddress() : null;
    }

    /**
     * Setter for streetAddress.
     *
     * @param value the value to set
     */
    public void setStreetAddress(String value) {
        entity.setStreetAddress(value);
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
     * Getter for unstructured.
     *
     * @return value for unstructured
     */
    @XmlElement
    public String getUnstructured() {
        return (expandLevel > 0) ? entity.getUnstructured() : null;
    }

    /**
     * Setter for unstructured.
     *
     * @param value the value to set
     */
    public void setUnstructured(String value) {
        entity.setUnstructured(value);
    }

    /**
     * Getter for useropenSocialiduseropenSocial.
     *
     * @return value for useropenSocialiduseropenSocial
     */
    @XmlElement
    public Integer getUseropenSocialiduseropenSocial() {
        return (expandLevel > 0) ? entity.getUseropenSocialiduseropenSocial() : null;
    }

    /**
     * Setter for useropenSocialiduseropenSocial.
     *
     * @param value the value to set
     */
    public void setUseropenSocialiduseropenSocial(Integer value) {
        entity.setUseropenSocialiduseropenSocial(value);
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
     * Returns the AddressopenSocial entity.
     *
     * @return an entity
     */
    @XmlTransient
    public AddressopenSocial getEntity() {
        if (entity.getIdAddressopenSocial() == null) {
            AddressopenSocialConverter converter = UriResolver.getInstance().resolve(AddressopenSocialConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved AddressopenSocial entity.
     *
     * @return an resolved entity
     */
    public AddressopenSocial resolveEntity(EntityManager em) {
        return entity;
    }
}
