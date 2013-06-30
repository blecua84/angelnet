/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.LikesFacebook;
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

@XmlRootElement(name = "likesFacebooks")
public class LikesFacebooksConverter {
    private Collection<LikesFacebook> entities;
    private Collection<LikesFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of LikesFacebooksConverter */
    public LikesFacebooksConverter() {
    }

    /**
     * Creates a new instance of LikesFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public LikesFacebooksConverter(Collection<LikesFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getLikesFacebook();
    }

    /**
     * Returns a collection of LikesFacebookConverter.
     *
     * @return a collection of LikesFacebookConverter
     */
    @XmlElement
    public Collection<LikesFacebookConverter> getLikesFacebook() {
        if (items == null) {
            items = new ArrayList<LikesFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (LikesFacebook entity : entities) {
                items.add(new LikesFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of LikesFacebookConverter.
     *
     * @param a collection of LikesFacebookConverter to set
     */
    public void setLikesFacebook(Collection<LikesFacebookConverter> items) {
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
     * Returns a collection LikesFacebook entities.
     *
     * @return a collection of LikesFacebook entities
     */
    @XmlTransient
    public Collection<LikesFacebook> getEntities() {
        entities = new ArrayList<LikesFacebook>();
        if (items != null) {
            for (LikesFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
