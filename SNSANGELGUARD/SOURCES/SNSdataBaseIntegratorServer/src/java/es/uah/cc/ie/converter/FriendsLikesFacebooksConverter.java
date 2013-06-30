/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.FriendsLikesFacebook;
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

@XmlRootElement(name = "friendsLikesFacebooks")
public class FriendsLikesFacebooksConverter {
    private Collection<FriendsLikesFacebook> entities;
    private Collection<FriendsLikesFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of FriendsLikesFacebooksConverter */
    public FriendsLikesFacebooksConverter() {
    }

    /**
     * Creates a new instance of FriendsLikesFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public FriendsLikesFacebooksConverter(Collection<FriendsLikesFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getFriendsLikesFacebook();
    }

    /**
     * Returns a collection of FriendsLikesFacebookConverter.
     *
     * @return a collection of FriendsLikesFacebookConverter
     */
    @XmlElement
    public Collection<FriendsLikesFacebookConverter> getFriendsLikesFacebook() {
        if (items == null) {
            items = new ArrayList<FriendsLikesFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (FriendsLikesFacebook entity : entities) {
                items.add(new FriendsLikesFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of FriendsLikesFacebookConverter.
     *
     * @param a collection of FriendsLikesFacebookConverter to set
     */
    public void setFriendsLikesFacebook(Collection<FriendsLikesFacebookConverter> items) {
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
     * Returns a collection FriendsLikesFacebook entities.
     *
     * @return a collection of FriendsLikesFacebook entities
     */
    @XmlTransient
    public Collection<FriendsLikesFacebook> getEntities() {
        entities = new ArrayList<FriendsLikesFacebook>();
        if (items != null) {
            for (FriendsLikesFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
