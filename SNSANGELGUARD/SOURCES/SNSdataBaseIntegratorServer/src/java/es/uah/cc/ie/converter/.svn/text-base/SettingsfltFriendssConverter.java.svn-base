/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SettingsfltFriends;
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

@XmlRootElement(name = "settingsfltFriendss")
public class SettingsfltFriendssConverter {
    private Collection<SettingsfltFriends> entities;
    private Collection<SettingsfltFriendsConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SettingsfltFriendssConverter */
    public SettingsfltFriendssConverter() {
    }

    /**
     * Creates a new instance of SettingsfltFriendssConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SettingsfltFriendssConverter(Collection<SettingsfltFriends> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getSettingsfltFriends();
    }

    /**
     * Returns a collection of SettingsfltFriendsConverter.
     *
     * @return a collection of SettingsfltFriendsConverter
     */
    @XmlElement
    public Collection<SettingsfltFriendsConverter> getSettingsfltFriends() {
        if (items == null) {
            items = new ArrayList<SettingsfltFriendsConverter>();
        }
        if (entities != null) {
            items.clear();
            for (SettingsfltFriends entity : entities) {
                items.add(new SettingsfltFriendsConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of SettingsfltFriendsConverter.
     *
     * @param a collection of SettingsfltFriendsConverter to set
     */
    public void setSettingsfltFriends(Collection<SettingsfltFriendsConverter> items) {
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
     * Returns a collection SettingsfltFriends entities.
     *
     * @return a collection of SettingsfltFriends entities
     */
    @XmlTransient
    public Collection<SettingsfltFriends> getEntities() {
        entities = new ArrayList<SettingsfltFriends>();
        if (items != null) {
            for (SettingsfltFriendsConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
