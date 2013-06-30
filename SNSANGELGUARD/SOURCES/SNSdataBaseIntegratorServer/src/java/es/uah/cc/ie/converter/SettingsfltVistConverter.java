/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SettingsfltVist;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.SettingsAngels;
import es.uah.cc.ie.persistence.UserSettings;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author tote
 */
@XmlRootElement(name = "settingsfltVist")
public class SettingsfltVistConverter {

    private SettingsfltVist entity;
    private URI uri;
    private int expandLevel;

    /** Creates a new instance of SettingsfltVistConverter */
    public SettingsfltVistConverter() {
        entity = new SettingsfltVist();
    }

    /**
     * Creates a new instance of SettingsfltVistConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public SettingsfltVistConverter(SettingsfltVist entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getUserSettingsUid() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getSettingsAngelsCollection();
        getUserSettings();
    }

    /**
     * Creates a new instance of SettingsfltVistConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SettingsfltVistConverter(SettingsfltVist entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for userSettingsUid.
     *
     * @return value for userSettingsUid
     */
    @XmlElement
    public String getUserSettingsUid() {
        return (expandLevel > 0) ? entity.getUserSettingsUid() : null;
    }

    /**
     * Setter for userSettingsUid.
     *
     * @param value the value to set
     */
    public void setUserSettingsUid(String value) {
        entity.setUserSettingsUid(value);
    }

    /**
     * Getter for frecfltVist.
     *
     * @return value for frecfltVist
     */
    @XmlElement
    public String getFrecfltVist() {
        return (expandLevel > 0) ? entity.getFrecfltVist() : null;
    }

    /**
     * Setter for frecfltVist.
     *
     * @param value the value to set
     */
    public void setFrecfltVist(String value) {
        entity.setFrecfltVist(value);
    }

    /**
     * Getter for activefltVist.
     *
     * @return value for activefltVist
     */
    @XmlElement
    public String getActivefltVist() {
        return (expandLevel > 0) ? entity.getActivefltVist() : null;
    }

    /**
     * Setter for activefltVist.
     *
     * @param value the value to set
     */
    public void setActivefltVist(String value) {
        entity.setActivefltVist(value);
    }

    /**
     * Getter for lastCheck.
     *
     * @return value for lastCheck
     */
    @XmlElement
    public Date getLastCheck() {
        return (expandLevel > 0) ? entity.getLastCheck() : null;
    }

    /**
     * Setter for lastCheck.
     *
     * @param value the value to set
     */
    public void setLastCheck(Date value) {
        entity.setLastCheck(value);
    }

    /**
     * Getter for settingsAngelsCollection.
     *
     * @return value for settingsAngelsCollection
     */
    @XmlElement
    public SettingsAngelssConverter getSettingsAngelsCollection() {
        if (expandLevel > 0) {
            if (entity.getSettingsAngelsCollection() != null) {
                return new SettingsAngelssConverter(entity.getSettingsAngelsCollection(), uri.resolve("settingsAngelsCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for settingsAngelsCollection.
     *
     * @param value the value to set
     */
    public void setSettingsAngelsCollection(SettingsAngelssConverter value) {
        entity.setSettingsAngelsCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for userSettings.
     *
     * @return value for userSettings
     */
    @XmlElement
    public UserSettingsConverter getUserSettings() {
        if (expandLevel > 0) {
            if (entity.getUserSettings() != null) {
                return new UserSettingsConverter(entity.getUserSettings(), uri.resolve("userSettings/"), expandLevel - 1, false);
            }
        }
        return null;
    }

    /**
     * Setter for userSettings.
     *
     * @param value the value to set
     */
    public void setUserSettings(UserSettingsConverter value) {
        entity.setUserSettings((value != null) ? value.getEntity() : null);
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
     * Sets the URI for this reference converter.
     *
     */
    public void setUri(URI uri) {
        this.uri = uri;
    }

    /**
     * Returns the SettingsfltVist entity.
     *
     * @return an entity
     */
    @XmlTransient
    public SettingsfltVist getEntity() {
        if (entity.getUserSettingsUid() == null) {
            SettingsfltVistConverter converter = UriResolver.getInstance().resolve(SettingsfltVistConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved SettingsfltVist entity.
     *
     * @return an resolved entity
     */
    public SettingsfltVist resolveEntity(EntityManager em) {
        Collection<SettingsAngels> settingsAngelsCollection = entity.getSettingsAngelsCollection();
        Collection<SettingsAngels> newsettingsAngelsCollection = new java.util.ArrayList<SettingsAngels>();
        if (settingsAngelsCollection != null) {
            for (SettingsAngels item : settingsAngelsCollection) {
                newsettingsAngelsCollection.add(em.getReference(SettingsAngels.class, item.getUidAngel()));
            }
        }
        entity.setSettingsAngelsCollection(newsettingsAngelsCollection);
        UserSettings userSettings = entity.getUserSettings();
        if (userSettings != null) {
            entity.setUserSettings(em.getReference(UserSettings.class, userSettings.getUid()));
        }
        return entity;
    }
}
