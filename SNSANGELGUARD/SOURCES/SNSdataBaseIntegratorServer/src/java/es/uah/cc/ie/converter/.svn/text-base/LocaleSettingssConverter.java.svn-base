/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.LocaleSettings;
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

@XmlRootElement(name = "localeSettingss")
public class LocaleSettingssConverter {
    private Collection<LocaleSettings> entities;
    private Collection<LocaleSettingsConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of LocaleSettingssConverter */
    public LocaleSettingssConverter() {
    }

    /**
     * Creates a new instance of LocaleSettingssConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public LocaleSettingssConverter(Collection<LocaleSettings> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getLocaleSettings();
    }

    /**
     * Returns a collection of LocaleSettingsConverter.
     *
     * @return a collection of LocaleSettingsConverter
     */
    @XmlElement
    public Collection<LocaleSettingsConverter> getLocaleSettings() {
        if (items == null) {
            items = new ArrayList<LocaleSettingsConverter>();
        }
        if (entities != null) {
            items.clear();
            for (LocaleSettings entity : entities) {
                items.add(new LocaleSettingsConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of LocaleSettingsConverter.
     *
     * @param a collection of LocaleSettingsConverter to set
     */
    public void setLocaleSettings(Collection<LocaleSettingsConverter> items) {
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
     * Returns a collection LocaleSettings entities.
     *
     * @return a collection of LocaleSettings entities
     */
    @XmlTransient
    public Collection<LocaleSettings> getEntities() {
        entities = new ArrayList<LocaleSettings>();
        if (items != null) {
            for (LocaleSettingsConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
