/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SampleLikesFacebook;
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

@XmlRootElement(name = "sampleLikesFacebooks")
public class SampleLikesFacebooksConverter {
    private Collection<SampleLikesFacebook> entities;
    private Collection<SampleLikesFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SampleLikesFacebooksConverter */
    public SampleLikesFacebooksConverter() {
    }

    /**
     * Creates a new instance of SampleLikesFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SampleLikesFacebooksConverter(Collection<SampleLikesFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getSampleLikesFacebook();
    }

    /**
     * Returns a collection of SampleLikesFacebookConverter.
     *
     * @return a collection of SampleLikesFacebookConverter
     */
    @XmlElement
    public Collection<SampleLikesFacebookConverter> getSampleLikesFacebook() {
        if (items == null) {
            items = new ArrayList<SampleLikesFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (SampleLikesFacebook entity : entities) {
                items.add(new SampleLikesFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of SampleLikesFacebookConverter.
     *
     * @param a collection of SampleLikesFacebookConverter to set
     */
    public void setSampleLikesFacebook(Collection<SampleLikesFacebookConverter> items) {
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
     * Returns a collection SampleLikesFacebook entities.
     *
     * @return a collection of SampleLikesFacebook entities
     */
    @XmlTransient
    public Collection<SampleLikesFacebook> getEntities() {
        entities = new ArrayList<SampleLikesFacebook>();
        if (items != null) {
            for (SampleLikesFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
