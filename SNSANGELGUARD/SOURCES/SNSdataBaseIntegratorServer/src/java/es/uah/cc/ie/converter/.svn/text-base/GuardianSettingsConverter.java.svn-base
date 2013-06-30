/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.GuardianSettings;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "guardianSettings")
public class GuardianSettingsConverter {
    private GuardianSettings entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of GuardianSettingsConverter */
    public GuardianSettingsConverter() {
        entity = new GuardianSettings();
    }

    /**
     * Creates a new instance of GuardianSettingsConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public GuardianSettingsConverter(GuardianSettings entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getUidGuardian() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of GuardianSettingsConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public GuardianSettingsConverter(GuardianSettings entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for uidGuardian.
     *
     * @return value for uidGuardian
     */
    @XmlElement
    public Integer getUidGuardian() {
        return (expandLevel > 0) ? entity.getUidGuardian() : null;
    }

    /**
     * Setter for uidGuardian.
     *
     * @param value the value to set
     */
    public void setUidGuardian(Integer value) {
        entity.setUidGuardian(value);
    }

    /**
     * Getter for guardianName.
     *
     * @return value for guardianName
     */
    @XmlElement
    public String getGuardianName() {
        return (expandLevel > 0) ? entity.getGuardianName() : null;
    }

    /**
     * Setter for guardianName.
     *
     * @param value the value to set
     */
    public void setGuardianName(String value) {
        entity.setGuardianName(value);
    }

    /**
     * Getter for guardianEmail.
     *
     * @return value for guardianEmail
     */
    @XmlElement
    public String getGuardianEmail() {
        return (expandLevel > 0) ? entity.getGuardianEmail() : null;
    }

    /**
     * Setter for guardianEmail.
     *
     * @param value the value to set
     */
    public void setGuardianEmail(String value) {
        entity.setGuardianEmail(value);
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
     * Returns the GuardianSettings entity.
     *
     * @return an entity
     */
    @XmlTransient
    public GuardianSettings getEntity() {
        if (entity.getUidGuardian() == null) {
            GuardianSettingsConverter converter = UriResolver.getInstance().resolve(GuardianSettingsConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved GuardianSettings entity.
     *
     * @return an resolved entity
     */
    public GuardianSettings resolveEntity(EntityManager em) {
        return entity;
    }
}
