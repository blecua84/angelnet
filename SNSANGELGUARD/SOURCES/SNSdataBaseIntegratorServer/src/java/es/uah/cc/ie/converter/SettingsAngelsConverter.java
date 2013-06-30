/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SettingsAngels;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.UserSettings;
import es.uah.cc.ie.persistence.SettingsfltWall;
import es.uah.cc.ie.persistence.SettingsfltPriv;
import es.uah.cc.ie.persistence.SettingsfltFriends;
import java.util.Collection;
import es.uah.cc.ie.persistence.SettingsfltVist;

/**
 *
 * @author tote
 */
@XmlRootElement(name = "settingsAngels")
public class SettingsAngelsConverter {

    private SettingsAngels entity;
    private URI uri;
    private int expandLevel;

    /** Creates a new instance of SettingsAngelsConverter */
    public SettingsAngelsConverter() {
        entity = new SettingsAngels();
    }

    /**
     * Creates a new instance of SettingsAngelsConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public SettingsAngelsConverter(SettingsAngels entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getUidAngel() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getSettingsfltVistCollection();
        getSettingsfltWallCollection();
        getSettingsfltPrivCollection();
        getUserSettingsCollection();
        getSettingsfltFriendsCollection();
    }

    /**
     * Creates a new instance of SettingsAngelsConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SettingsAngelsConverter(SettingsAngels entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for uidAngel.
     *
     * @return value for uidAngel
     */
    @XmlElement
    public Integer getUidAngel() {
        return (expandLevel > 0) ? entity.getUidAngel() : null;
    }

    /**
     * Setter for uidAngel.
     *
     * @param value the value to set
     */
    public void setUidAngel(Integer value) {
        entity.setUidAngel(value);
    }

    /**
     * Getter for idAngel.
     *
     * @return value for idAngel
     */
    @XmlElement
    public String getIdAngel() {
        return (expandLevel > 0) ? entity.getIdAngel() : null;
    }

    /**
     * Setter for idAngel.
     *
     * @param value the value to set
     */
    public void setIdAngel(String value) {
        entity.setIdAngel(value);
    }

    /**
     * Getter for nameAngel.
     *
     * @return value for nameAngel
     */
    @XmlElement
    public String getNameAngel() {
        return (expandLevel > 0) ? entity.getNameAngel() : null;
    }

    /**
     * Setter for nameAngel.
     *
     * @param value the value to set
     */
    public void setNameAngel(String value) {
        entity.setNameAngel(value);
    }

    /**
     * Getter for imgAngel.
     *
     * @return value for imgAngel
     */
    @XmlElement
    public String getImgAngel() {
        return (expandLevel > 0) ? entity.getImgAngel() : null;
    }

    /**
     * Setter for imgAngel.
     *
     * @param value the value to set
     */
    public void setImgAngel(String value) {
        entity.setImgAngel(value);
    }

    /**
     * Getter for typeAngel.
     *
     * @return value for typeAngel
     */
    @XmlElement
    public String getTypeAngel() {
        return (expandLevel > 0) ? entity.getTypeAngel() : null;
    }

    /**
     * Setter for typeAngel.
     *
     * @param value the value to set
     */
    public void setTypeAngel(String value) {
        entity.setTypeAngel(value);
    }

    /**
     * Getter for acceptAngel.
     *
     * @return value for acceptAngel
     */
    @XmlElement
    public String getAcceptAngel() {
        return (expandLevel > 0) ? entity.getAcceptAngel() : null;
    }

    /**
     * Setter for acceptAngel.
     *
     * @param value the value to set
     */
    public void setAcceptAngel(String value) {
        entity.setAcceptAngel(value);
    }

    /**
     * Getter for confirmAngel.
     *
     * @return value for confirmAngel
     */
    @XmlElement
    public String getConfirmAngel() {
        return (expandLevel > 0) ? entity.getConfirmAngel() : null;
    }

    /**
     * Setter for acceptAngel.
     *
     * @param value the value to set
     */
    public void setConfirmAngel(String value) {
        entity.setConfirmAngel(value);
    }

    /**
     * Getter for userPropAngel.
     *
     * @return value for userPropAngel
     */
    @XmlElement
    public String getUserPropAngel() {
        return (expandLevel > 0) ? entity.getUserPropAngel() : null;
    }

    /**
     * @param userPropAngel the userPropAngel to set
     */
    public void setUserPropAngel(String userPropAngel) {
        entity.setUserPropAngel(userPropAngel);
    }

    /**
     * Getter for settingsfltVistCollection.
     *
     * @return value for settingsfltVistCollection
     */
    @XmlElement
    public SettingsfltVistsConverter getSettingsfltVistCollection() {
        if (expandLevel > 0) {
            if (entity.getSettingsfltVistCollection() != null) {
                return new SettingsfltVistsConverter(entity.getSettingsfltVistCollection(), uri.resolve("settingsfltVistCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for settingsfltVistCollection.
     *
     * @param value the value to set
     */
    public void setSettingsfltVistCollection(SettingsfltVistsConverter value) {
        entity.setSettingsfltVistCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for settingsfltWallCollection.
     *
     * @return value for settingsfltWallCollection
     */
    @XmlElement
    public SettingsfltWallsConverter getSettingsfltWallCollection() {
        if (expandLevel > 0) {
            if (entity.getSettingsfltWallCollection() != null) {
                return new SettingsfltWallsConverter(entity.getSettingsfltWallCollection(), uri.resolve("settingsfltWallCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for settingsfltWallCollection.
     *
     * @param value the value to set
     */
    public void setSettingsfltWallCollection(SettingsfltWallsConverter value) {
        entity.setSettingsfltWallCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for settingsfltPrivCollection.
     *
     * @return value for settingsfltPrivCollection
     */
    @XmlElement
    public SettingsfltPrivsConverter getSettingsfltPrivCollection() {
        if (expandLevel > 0) {
            if (entity.getSettingsfltPrivCollection() != null) {
                return new SettingsfltPrivsConverter(entity.getSettingsfltPrivCollection(), uri.resolve("settingsfltPrivCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for settingsfltPrivCollection.
     *
     * @param value the value to set
     */
    public void setSettingsfltPrivCollection(SettingsfltPrivsConverter value) {
        entity.setSettingsfltPrivCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for userSettingsCollection.
     *
     * @return value for userSettingsCollection
     */
    @XmlElement
    public UserSettingssConverter getUserSettingsCollection() {
        if (expandLevel > 0) {
            if (entity.getUserSettingsCollection() != null) {
                return new UserSettingssConverter(entity.getUserSettingsCollection(), uri.resolve("userSettingsCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for userSettingsCollection.
     *
     * @param value the value to set
     */
    public void setUserSettingsCollection(UserSettingssConverter value) {
        entity.setUserSettingsCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for settingsfltFriendsCollection.
     *
     * @return value for settingsfltFriendsCollection
     */
    @XmlElement
    public SettingsfltFriendssConverter getSettingsfltFriendsCollection() {
        if (expandLevel > 0) {
            if (entity.getSettingsfltFriendsCollection() != null) {
                return new SettingsfltFriendssConverter(entity.getSettingsfltFriendsCollection(), uri.resolve("settingsfltFriendsCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for settingsfltFriendsCollection.
     *
     * @param value the value to set
     */
    public void setSettingsfltFriendsCollection(SettingsfltFriendssConverter value) {
        entity.setSettingsfltFriendsCollection((value != null) ? value.getEntities() : null);
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
     * Returns the SettingsAngels entity.
     *
     * @return an entity
     */
    @XmlTransient
    public SettingsAngels getEntity() {
        if (entity.getUidAngel() == null) {
            SettingsAngelsConverter converter = UriResolver.getInstance().resolve(SettingsAngelsConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved SettingsAngels entity.
     *
     * @return an resolved entity
     */
    public SettingsAngels resolveEntity(EntityManager em) {
        Collection<SettingsfltVist> settingsfltVistCollection = entity.getSettingsfltVistCollection();
        Collection<SettingsfltVist> newsettingsfltVistCollection = new java.util.ArrayList<SettingsfltVist>();
        if (settingsfltVistCollection != null) {
            for (SettingsfltVist item : settingsfltVistCollection) {
                newsettingsfltVistCollection.add(em.getReference(SettingsfltVist.class, item.getUserSettingsUid()));
            }
        }
        entity.setSettingsfltVistCollection(newsettingsfltVistCollection);
        Collection<SettingsfltWall> settingsfltWallCollection = entity.getSettingsfltWallCollection();
        Collection<SettingsfltWall> newsettingsfltWallCollection = new java.util.ArrayList<SettingsfltWall>();
        if (settingsfltWallCollection != null) {
            for (SettingsfltWall item : settingsfltWallCollection) {
                newsettingsfltWallCollection.add(em.getReference(SettingsfltWall.class, item.getUserSettingsUid()));
            }
        }
        entity.setSettingsfltWallCollection(newsettingsfltWallCollection);
        Collection<SettingsfltPriv> settingsfltPrivCollection = entity.getSettingsfltPrivCollection();
        Collection<SettingsfltPriv> newsettingsfltPrivCollection = new java.util.ArrayList<SettingsfltPriv>();
        if (settingsfltPrivCollection != null) {
            for (SettingsfltPriv item : settingsfltPrivCollection) {
                newsettingsfltPrivCollection.add(em.getReference(SettingsfltPriv.class, item.getUserSettingsUid()));
            }
        }
        entity.setSettingsfltPrivCollection(newsettingsfltPrivCollection);
        Collection<UserSettings> userSettingsCollection = entity.getUserSettingsCollection();
        Collection<UserSettings> newuserSettingsCollection = new java.util.ArrayList<UserSettings>();
        if (userSettingsCollection != null) {
            for (UserSettings item : userSettingsCollection) {
                newuserSettingsCollection.add(em.getReference(UserSettings.class, item.getUid()));
            }
        }
        entity.setUserSettingsCollection(newuserSettingsCollection);
        Collection<SettingsfltFriends> settingsfltFriendsCollection = entity.getSettingsfltFriendsCollection();
        Collection<SettingsfltFriends> newsettingsfltFriendsCollection = new java.util.ArrayList<SettingsfltFriends>();
        if (settingsfltFriendsCollection != null) {
            for (SettingsfltFriends item : settingsfltFriendsCollection) {
                newsettingsfltFriendsCollection.add(em.getReference(SettingsfltFriends.class, item.getUserSettingsUid()));
            }
        }
        entity.setSettingsfltFriendsCollection(newsettingsfltFriendsCollection);
        return entity;
    }
}
