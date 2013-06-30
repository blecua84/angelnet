/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATION;
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

@XmlRootElement(name = "locationfacebookhasuserfacebookCURRENTLOCATIONs")
public class LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter {
    private Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> entities;
    private Collection<LocationfacebookhasuserfacebookCURRENTLOCATIONConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter */
    public LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter() {
    }

    /**
     * Creates a new instance of LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter(Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getLocationfacebookhasuserfacebookCURRENTLOCATION();
    }

    /**
     * Returns a collection of LocationfacebookhasuserfacebookCURRENTLOCATIONConverter.
     *
     * @return a collection of LocationfacebookhasuserfacebookCURRENTLOCATIONConverter
     */
    @XmlElement
    public Collection<LocationfacebookhasuserfacebookCURRENTLOCATIONConverter> getLocationfacebookhasuserfacebookCURRENTLOCATION() {
        if (items == null) {
            items = new ArrayList<LocationfacebookhasuserfacebookCURRENTLOCATIONConverter>();
        }
        if (entities != null) {
            items.clear();
            for (LocationfacebookhasuserfacebookCURRENTLOCATION entity : entities) {
                items.add(new LocationfacebookhasuserfacebookCURRENTLOCATIONConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of LocationfacebookhasuserfacebookCURRENTLOCATIONConverter.
     *
     * @param a collection of LocationfacebookhasuserfacebookCURRENTLOCATIONConverter to set
     */
    public void setLocationfacebookhasuserfacebookCURRENTLOCATION(Collection<LocationfacebookhasuserfacebookCURRENTLOCATIONConverter> items) {
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
     * Returns a collection LocationfacebookhasuserfacebookCURRENTLOCATION entities.
     *
     * @return a collection of LocationfacebookhasuserfacebookCURRENTLOCATION entities
     */
    @XmlTransient
    public Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> getEntities() {
        entities = new ArrayList<LocationfacebookhasuserfacebookCURRENTLOCATION>();
        if (items != null) {
            for (LocationfacebookhasuserfacebookCURRENTLOCATIONConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
