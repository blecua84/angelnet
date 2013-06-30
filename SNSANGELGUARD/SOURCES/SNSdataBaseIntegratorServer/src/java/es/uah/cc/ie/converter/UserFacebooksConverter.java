/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.UserFacebook;
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

@XmlRootElement(name = "userFacebooks")
public class UserFacebooksConverter {
    private Collection<UserFacebook> entities;
    private Collection<UserFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of UserFacebooksConverter */
    public UserFacebooksConverter() {
    }

    /**
     * Creates a new instance of UserFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public UserFacebooksConverter(Collection<UserFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getUserFacebook();
    }

    /**
     * Returns a collection of UserFacebookConverter.
     *
     * @return a collection of UserFacebookConverter
     */
    @XmlElement
    public Collection<UserFacebookConverter> getUserFacebook() {
        if (items == null) {
            items = new ArrayList<UserFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (UserFacebook entity : entities) {
                items.add(new UserFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of UserFacebookConverter.
     *
     * @param a collection of UserFacebookConverter to set
     */
    public void setUserFacebook(Collection<UserFacebookConverter> items) {
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
     * Returns a collection UserFacebook entities.
     *
     * @return a collection of UserFacebook entities
     */
    @XmlTransient
    public Collection<UserFacebook> getEntities() {
        entities = new ArrayList<UserFacebook>();
        if (items != null) {
            for (UserFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
