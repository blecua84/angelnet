/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.User;
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

@XmlRootElement(name = "users")
public class UsersConverter {
    private Collection<User> entities;
    private Collection<UserConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of UsersConverter */
    public UsersConverter() {
    }

    /**
     * Creates a new instance of UsersConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public UsersConverter(Collection<User> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getUser();
    }

    /**
     * Returns a collection of UserConverter.
     *
     * @return a collection of UserConverter
     */
    @XmlElement
    public Collection<UserConverter> getUser() {
        if (items == null) {
            items = new ArrayList<UserConverter>();
        }
        if (entities != null) {
            items.clear();
            for (User entity : entities) {
                items.add(new UserConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of UserConverter.
     *
     * @param a collection of UserConverter to set
     */
    public void setUser(Collection<UserConverter> items) {
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
     * Returns a collection User entities.
     *
     * @return a collection of User entities
     */
    @XmlTransient
    public Collection<User> getEntities() {
        entities = new ArrayList<User>();
        if (items != null) {
            for (UserConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
