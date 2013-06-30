/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.User;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.UseropenSocial;
import es.uah.cc.ie.persistence.UserSettings;
import es.uah.cc.ie.persistence.UserFacebook;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "user")
public class UserConverter {
    private User entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of UserConverter */
    public UserConverter() {
        entity = new User();
    }

    /**
     * Creates a new instance of UserConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public UserConverter(User entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getUserSettingsUid() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserSettings();
        getUseropenSocial();
        getUserFacebook();
    }

    /**
     * Creates a new instance of UserConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public UserConverter(User entity, URI uri, int expandLevel) {
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
     * Getter for sex.
     *
     * @return value for sex
     */
    @XmlElement
    public String getSex() {
        return (expandLevel > 0) ? entity.getSex() : null;
    }

    /**
     * Setter for sex.
     *
     * @param value the value to set
     */
    public void setSex(String value) {
        entity.setSex(value);
    }

    /**
     * Getter for religion.
     *
     * @return value for religion
     */
    @XmlElement
    public String getReligion() {
        return (expandLevel > 0) ? entity.getReligion() : null;
    }

    /**
     * Setter for religion.
     *
     * @param value the value to set
     */
    public void setReligion(String value) {
        entity.setReligion(value);
    }

    /**
     * Getter for relationshipStatus.
     *
     * @return value for relationshipStatus
     */
    @XmlElement
    public String getRelationshipStatus() {
        return (expandLevel > 0) ? entity.getRelationshipStatus() : null;
    }

    /**
     * Setter for relationshipStatus.
     *
     * @param value the value to set
     */
    public void setRelationshipStatus(String value) {
        entity.setRelationshipStatus(value);
    }

    /**
     * Getter for political.
     *
     * @return value for political
     */
    @XmlElement
    public String getPolitical() {
        return (expandLevel > 0) ? entity.getPolitical() : null;
    }

    /**
     * Setter for political.
     *
     * @param value the value to set
     */
    public void setPolitical(String value) {
        entity.setPolitical(value);
    }

    /**
     * Getter for activities.
     *
     * @return value for activities
     */
    @XmlElement
    public String getActivities() {
        return (expandLevel > 0) ? entity.getActivities() : null;
    }

    /**
     * Setter for activities.
     *
     * @param value the value to set
     */
    public void setActivities(String value) {
        entity.setActivities(value);
    }

    /**
     * Getter for interests.
     *
     * @return value for interests
     */
    @XmlElement
    public String getInterests() {
        return (expandLevel > 0) ? entity.getInterests() : null;
    }

    /**
     * Setter for interests.
     *
     * @param value the value to set
     */
    public void setInterests(String value) {
        entity.setInterests(value);
    }

    /**
     * Getter for isAppUser.
     *
     * @return value for isAppUser
     */
    @XmlElement
    public Boolean getIsAppUser() {
        return (expandLevel > 0) ? entity.getIsAppUser() : null;
    }

    /**
     * Setter for isAppUser.
     *
     * @param value the value to set
     */
    public void setIsAppUser(Boolean value) {
        entity.setIsAppUser(value);
    }

    /**
     * Getter for music.
     *
     * @return value for music
     */
    @XmlElement
    public String getMusic() {
        return (expandLevel > 0) ? entity.getMusic() : null;
    }

    /**
     * Setter for music.
     *
     * @param value the value to set
     */
    public void setMusic(String value) {
        entity.setMusic(value);
    }

    /**
     * Getter for tv.
     *
     * @return value for tv
     */
    @XmlElement
    public String getTv() {
        return (expandLevel > 0) ? entity.getTv() : null;
    }

    /**
     * Setter for tv.
     *
     * @param value the value to set
     */
    public void setTv(String value) {
        entity.setTv(value);
    }

    /**
     * Getter for movies.
     *
     * @return value for movies
     */
    @XmlElement
    public String getMovies() {
        return (expandLevel > 0) ? entity.getMovies() : null;
    }

    /**
     * Setter for movies.
     *
     * @param value the value to set
     */
    public void setMovies(String value) {
        entity.setMovies(value);
    }

    /**
     * Getter for books.
     *
     * @return value for books
     */
    @XmlElement
    public String getBooks() {
        return (expandLevel > 0) ? entity.getBooks() : null;
    }

    /**
     * Setter for books.
     *
     * @param value the value to set
     */
    public void setBooks(String value) {
        entity.setBooks(value);
    }

    /**
     * Getter for aboutMe.
     *
     * @return value for aboutMe
     */
    @XmlElement
    public String getAboutMe() {
        return (expandLevel > 0) ? entity.getAboutMe() : null;
    }

    /**
     * Setter for aboutMe.
     *
     * @param value the value to set
     */
    public void setAboutMe(String value) {
        entity.setAboutMe(value);
    }

    /**
     * Getter for status.
     *
     * @return value for status
     */
    @XmlElement
    public String getStatus() {
        return (expandLevel > 0) ? entity.getStatus() : null;
    }

    /**
     * Setter for status.
     *
     * @param value the value to set
     */
    public void setStatus(String value) {
        entity.setStatus(value);
    }

    /**
     * Getter for quotes.
     *
     * @return value for quotes
     */
    @XmlElement
    public String getQuotes() {
        return (expandLevel > 0) ? entity.getQuotes() : null;
    }

    /**
     * Setter for quotes.
     *
     * @param value the value to set
     */
    public void setQuotes(String value) {
        entity.setQuotes(value);
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
     * Getter for useropenSocial.
     *
     * @return value for useropenSocial
     */
    @XmlElement
    public UseropenSocialConverter getUseropenSocial() {
        if (expandLevel > 0) {
            if (entity.getUseropenSocial() != null) {
                return new UseropenSocialConverter(entity.getUseropenSocial(), uri.resolve("useropenSocial/"), expandLevel - 1, false);
            }
        }
        return null;
    }

    /**
     * Setter for useropenSocial.
     *
     * @param value the value to set
     */
    public void setUseropenSocial(UseropenSocialConverter value) {
        entity.setUseropenSocial((value != null) ? value.getEntity() : null);
    }

    /**
     * Getter for userFacebook.
     *
     * @return value for userFacebook
     */
    @XmlElement
    public UserFacebookConverter getUserFacebook() {
        if (expandLevel > 0) {
            if (entity.getUserFacebook() != null) {
                return new UserFacebookConverter(entity.getUserFacebook(), uri.resolve("userFacebook/"), expandLevel - 1, false);
            }
        }
        return null;
    }

    /**
     * Setter for userFacebook.
     *
     * @param value the value to set
     */
    public void setUserFacebook(UserFacebookConverter value) {
        entity.setUserFacebook((value != null) ? value.getEntity() : null);
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
     * Returns the User entity.
     *
     * @return an entity
     */
    @XmlTransient
    public User getEntity() {
        if (entity.getUserSettingsUid() == null) {
            UserConverter converter = UriResolver.getInstance().resolve(UserConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved User entity.
     *
     * @return an resolved entity
     */
    public User resolveEntity(EntityManager em) {
        UserSettings userSettings = entity.getUserSettings();
        if (userSettings != null) {
            entity.setUserSettings(em.getReference(UserSettings.class, userSettings.getUid()));
        }
        UseropenSocial useropenSocial = entity.getUseropenSocial();
        if (useropenSocial != null) {
            entity.setUseropenSocial(em.getReference(UseropenSocial.class, useropenSocial.getIduseropenSocial()));
        }
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            entity.setUserFacebook(em.getReference(UserFacebook.class, userFacebook.getIdUserFacebook()));
        }
        return entity;
    }
}
