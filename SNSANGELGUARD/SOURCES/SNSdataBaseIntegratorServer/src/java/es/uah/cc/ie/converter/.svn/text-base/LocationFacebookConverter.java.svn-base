/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.LocationFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATION;
import java.util.Collection;
import es.uah.cc.ie.persistence.UserFacebook;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "locationFacebook")
public class LocationFacebookConverter {
    private LocationFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of LocationFacebookConverter */
    public LocationFacebookConverter() {
        entity = new LocationFacebook();
    }

    /**
     * Creates a new instance of LocationFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public LocationFacebookConverter(LocationFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdLocationFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserFacebookCollection();
        getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection();
    }

    /**
     * Creates a new instance of LocationFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public LocationFacebookConverter(LocationFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idLocationFacebook.
     *
     * @return value for idLocationFacebook
     */
    @XmlElement
    public Integer getIdLocationFacebook() {
        return (expandLevel > 0) ? entity.getIdLocationFacebook() : null;
    }

    /**
     * Setter for idLocationFacebook.
     *
     * @param value the value to set
     */
    public void setIdLocationFacebook(Integer value) {
        entity.setIdLocationFacebook(value);
    }

    /**
     * Getter for city.
     *
     * @return value for city
     */
    @XmlElement
    public String getCity() {
        return (expandLevel > 0) ? entity.getCity() : null;
    }

    /**
     * Setter for city.
     *
     * @param value the value to set
     */
    public void setCity(String value) {
        entity.setCity(value);
    }

    /**
     * Getter for state.
     *
     * @return value for state
     */
    @XmlElement
    public String getState() {
        return (expandLevel > 0) ? entity.getState() : null;
    }

    /**
     * Setter for state.
     *
     * @param value the value to set
     */
    public void setState(String value) {
        entity.setState(value);
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
     * Getter for locationfacebookhasuserfacebookCURRENTLOCATIONCollection.
     *
     * @return value for locationfacebookhasuserfacebookCURRENTLOCATIONCollection
     */
    @XmlElement
    public LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection() {
        if (expandLevel > 0) {
            if (entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection() != null) {
                return new LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter(entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection(), uri.resolve("locationfacebookhasuserfacebookCURRENTLOCATIONCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for locationfacebookhasuserfacebookCURRENTLOCATIONCollection.
     *
     * @param value the value to set
     */
    public void setLocationfacebookhasuserfacebookCURRENTLOCATIONCollection(LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter value) {
        entity.setLocationfacebookhasuserfacebookCURRENTLOCATIONCollection((value != null) ? value.getEntities() : null);
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
     * Returns the LocationFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public LocationFacebook getEntity() {
        if (entity.getIdLocationFacebook() == null) {
            LocationFacebookConverter converter = UriResolver.getInstance().resolve(LocationFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved LocationFacebook entity.
     *
     * @return an resolved entity
     */
    public LocationFacebook resolveEntity(EntityManager em) {
        Collection<UserFacebook> userFacebookCollection = entity.getUserFacebookCollection();
        Collection<UserFacebook> newuserFacebookCollection = new java.util.ArrayList<UserFacebook>();
        if (userFacebookCollection != null) {
            for (UserFacebook item : userFacebookCollection) {
                newuserFacebookCollection.add(em.getReference(UserFacebook.class, item.getIdUserFacebook()));
            }
        }
        entity.setUserFacebookCollection(newuserFacebookCollection);
        Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollection = entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection();
        Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> newlocationfacebookhasuserfacebookCURRENTLOCATIONCollection = new java.util.ArrayList<LocationfacebookhasuserfacebookCURRENTLOCATION>();
        if (locationfacebookhasuserfacebookCURRENTLOCATIONCollection != null) {
            for (LocationfacebookhasuserfacebookCURRENTLOCATION item : locationfacebookhasuserfacebookCURRENTLOCATIONCollection) {
                newlocationfacebookhasuserfacebookCURRENTLOCATIONCollection.add(em.getReference(LocationfacebookhasuserfacebookCURRENTLOCATION.class, item.getLocationfacebookhasuserfacebookCURRENTLOCATIONPK()));
            }
        }
        entity.setLocationfacebookhasuserfacebookCURRENTLOCATIONCollection(newlocationfacebookhasuserfacebookCURRENTLOCATIONCollection);
        return entity;
    }
}
