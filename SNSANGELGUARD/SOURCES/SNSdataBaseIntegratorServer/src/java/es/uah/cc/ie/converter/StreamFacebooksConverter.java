/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.StreamFacebook;
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

@XmlRootElement(name = "streamFacebooks")
public class StreamFacebooksConverter {
    private Collection<StreamFacebook> entities;
    private Collection<StreamFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of StreamFacebooksConverter */
    public StreamFacebooksConverter() {
    }

    /**
     * Creates a new instance of StreamFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public StreamFacebooksConverter(Collection<StreamFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getStreamFacebook();
    }

    /**
     * Returns a collection of StreamFacebookConverter.
     *
     * @return a collection of StreamFacebookConverter
     */
    @XmlElement
    public Collection<StreamFacebookConverter> getStreamFacebook() {
        if (items == null) {
            items = new ArrayList<StreamFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (StreamFacebook entity : entities) {
                items.add(new StreamFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of StreamFacebookConverter.
     *
     * @param a collection of StreamFacebookConverter to set
     */
    public void setStreamFacebook(Collection<StreamFacebookConverter> items) {
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
     * Returns a collection StreamFacebook entities.
     *
     * @return a collection of StreamFacebook entities
     */
    @XmlTransient
    public Collection<StreamFacebook> getEntities() {
        entities = new ArrayList<StreamFacebook>();
        if (items != null) {
            for (StreamFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
