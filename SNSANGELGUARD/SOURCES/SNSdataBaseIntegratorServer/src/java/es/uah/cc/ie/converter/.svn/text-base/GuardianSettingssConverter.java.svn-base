/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.GuardianSettings;
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

@XmlRootElement(name = "guardianSettingss")
public class GuardianSettingssConverter {
    private Collection<GuardianSettings> entities;
    private Collection<GuardianSettingsConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of GuardianSettingssConverter */
    public GuardianSettingssConverter() {
    }

    /**
     * Creates a new instance of GuardianSettingssConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public GuardianSettingssConverter(Collection<GuardianSettings> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getGuardianSettings();
    }

    /**
     * Returns a collection of GuardianSettingsConverter.
     *
     * @return a collection of GuardianSettingsConverter
     */
    @XmlElement
    public Collection<GuardianSettingsConverter> getGuardianSettings() {
        if (items == null) {
            items = new ArrayList<GuardianSettingsConverter>();
        }
        if (entities != null) {
            items.clear();
            for (GuardianSettings entity : entities) {
                items.add(new GuardianSettingsConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of GuardianSettingsConverter.
     *
     * @param a collection of GuardianSettingsConverter to set
     */
    public void setGuardianSettings(Collection<GuardianSettingsConverter> items) {
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
     * Returns a collection GuardianSettings entities.
     *
     * @return a collection of GuardianSettings entities
     */
    @XmlTransient
    public Collection<GuardianSettings> getEntities() {
        entities = new ArrayList<GuardianSettings>();
        if (items != null) {
            for (GuardianSettingsConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
