/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.UserSettings;
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

@XmlRootElement(name = "userSettingss")
public class UserSettingssConverter {
    private Collection<UserSettings> entities;
    private Collection<UserSettingsConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of UserSettingssConverter */
    public UserSettingssConverter() {
    }

    /**
     * Creates a new instance of UserSettingssConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public UserSettingssConverter(Collection<UserSettings> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getUserSettings();
    }

    /**
     * Returns a collection of UserSettingsConverter.
     *
     * @return a collection of UserSettingsConverter
     */
    @XmlElement
    public Collection<UserSettingsConverter> getUserSettings() {
        if (items == null) {
            items = new ArrayList<UserSettingsConverter>();
        }
        if (entities != null) {
            items.clear();
            for (UserSettings entity : entities) {
                items.add(new UserSettingsConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of UserSettingsConverter.
     *
     * @param a collection of UserSettingsConverter to set
     */
    public void setUserSettings(Collection<UserSettingsConverter> items) {
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
     * Returns a collection UserSettings entities.
     *
     * @return a collection of UserSettings entities
     */
    @XmlTransient
    public Collection<UserSettings> getEntities() {
        entities = new ArrayList<UserSettings>();
        if (items != null) {
            for (UserSettingsConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
