/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.FriendsFacebook;
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

@XmlRootElement(name = "friendsFacebooks")
public class FriendsFacebooksConverter {
    private Collection<FriendsFacebook> entities;
    private Collection<FriendsFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of FriendsFacebooksConverter */
    public FriendsFacebooksConverter() {
    }

    /**
     * Creates a new instance of FriendsFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public FriendsFacebooksConverter(Collection<FriendsFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getFriendsFacebook();
    }

    /**
     * Returns a collection of FriendsFacebookConverter.
     *
     * @return a collection of FriendsFacebookConverter
     */
    @XmlElement
    public Collection<FriendsFacebookConverter> getFriendsFacebook() {
        if (items == null) {
            items = new ArrayList<FriendsFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (FriendsFacebook entity : entities) {
                items.add(new FriendsFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of FriendsFacebookConverter.
     *
     * @param a collection of FriendsFacebookConverter to set
     */
    public void setFriendsFacebook(Collection<FriendsFacebookConverter> items) {
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
     * Returns a collection FriendsFacebook entities.
     *
     * @return a collection of FriendsFacebook entities
     */
    @XmlTransient
    public Collection<FriendsFacebook> getEntities() {
        entities = new ArrayList<FriendsFacebook>();
        if (items != null) {
            for (FriendsFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
