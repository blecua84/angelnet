/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.WorkHistoryFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.UserFacebook;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "workHistoryFacebook")
public class WorkHistoryFacebookConverter {
    private WorkHistoryFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of WorkHistoryFacebookConverter */
    public WorkHistoryFacebookConverter() {
        entity = new WorkHistoryFacebook();
    }

    /**
     * Creates a new instance of WorkHistoryFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public WorkHistoryFacebookConverter(WorkHistoryFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdWorkHistoryFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserFacebook();
    }

    /**
     * Creates a new instance of WorkHistoryFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public WorkHistoryFacebookConverter(WorkHistoryFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idWorkHistoryFacebook.
     *
     * @return value for idWorkHistoryFacebook
     */
    @XmlElement
    public Integer getIdWorkHistoryFacebook() {
        return (expandLevel > 0) ? entity.getIdWorkHistoryFacebook() : null;
    }

    /**
     * Setter for idWorkHistoryFacebook.
     *
     * @param value the value to set
     */
    public void setIdWorkHistoryFacebook(Integer value) {
        entity.setIdWorkHistoryFacebook(value);
    }

    /**
     * Getter for location.
     *
     * @return value for location
     */
    @XmlElement
    public String getLocation() {
        return (expandLevel > 0) ? entity.getLocation() : null;
    }

    /**
     * Setter for location.
     *
     * @param value the value to set
     */
    public void setLocation(String value) {
        entity.setLocation(value);
    }

    /**
     * Getter for companyName.
     *
     * @return value for companyName
     */
    @XmlElement
    public String getCompanyName() {
        return (expandLevel > 0) ? entity.getCompanyName() : null;
    }

    /**
     * Setter for companyName.
     *
     * @param value the value to set
     */
    public void setCompanyName(String value) {
        entity.setCompanyName(value);
    }

    /**
     * Getter for description.
     *
     * @return value for description
     */
    @XmlElement
    public String getDescription() {
        return (expandLevel > 0) ? entity.getDescription() : null;
    }

    /**
     * Setter for description.
     *
     * @param value the value to set
     */
    public void setDescription(String value) {
        entity.setDescription(value);
    }

    /**
     * Getter for position.
     *
     * @return value for position
     */
    @XmlElement
    public String getPosition() {
        return (expandLevel > 0) ? entity.getPosition() : null;
    }

    /**
     * Setter for position.
     *
     * @param value the value to set
     */
    public void setPosition(String value) {
        entity.setPosition(value);
    }

    /**
     * Getter for startDate.
     *
     * @return value for startDate
     */
    @XmlElement
    public String getStartDate() {
        return (expandLevel > 0) ? entity.getStartDate() : null;
    }

    /**
     * Setter for startDate.
     *
     * @param value the value to set
     */
    public void setStartDate(String value) {
        entity.setStartDate(value);
    }

    /**
     * Getter for endDate.
     *
     * @return value for endDate
     */
    @XmlElement
    public String getEndDate() {
        return (expandLevel > 0) ? entity.getEndDate() : null;
    }

    /**
     * Setter for endDate.
     *
     * @param value the value to set
     */
    public void setEndDate(String value) {
        entity.setEndDate(value);
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
     * Returns the WorkHistoryFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public WorkHistoryFacebook getEntity() {
        if (entity.getIdWorkHistoryFacebook() == null) {
            WorkHistoryFacebookConverter converter = UriResolver.getInstance().resolve(WorkHistoryFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved WorkHistoryFacebook entity.
     *
     * @return an resolved entity
     */
    public WorkHistoryFacebook resolveEntity(EntityManager em) {
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            entity.setUserFacebook(em.getReference(UserFacebook.class, userFacebook.getIdUserFacebook()));
        }
        return entity;
    }
}
