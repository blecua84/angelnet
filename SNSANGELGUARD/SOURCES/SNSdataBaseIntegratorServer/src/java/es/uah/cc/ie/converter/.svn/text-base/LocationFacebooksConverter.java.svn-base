/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.LocationFacebook;
import java.net.URI;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.ArrayList;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "locationFacebooks")
public class LocationFacebooksConverter {
    private Collection<LocationFacebook> entities;
    private Collection<LocationFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of LocationFacebooksConverter */
    public LocationFacebooksConverter() {
    }

    /**
     * Creates a new instance of LocationFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public LocationFacebooksConverter(Collection<LocationFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getLocationFacebook();
    }

    /**
     * Returns a collection of LocationFacebookConverter.
     *
     * @return a collection of LocationFacebookConverter
     */
    @XmlElement
    public Collection<LocationFacebookConverter> getLocationFacebook() {
        if (items == null) {
            items = new ArrayList<LocationFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (LocationFacebook entity : entities) {
                items.add(new LocationFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of LocationFacebookConverter.
     *
     * @param a collection of LocationFacebookConverter to set
     */
    public void setLocationFacebook(Collection<LocationFacebookConverter> items) {
        this.items = items;
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
     * Returns a collection LocationFacebook entities.
     *
     * @return a collection of LocationFacebook entities
     */
    @XmlTransient
    public Collection<LocationFacebook> getEntities() {
        entities = new ArrayList<LocationFacebook>();
        if (items != null) {
            for (LocationFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
