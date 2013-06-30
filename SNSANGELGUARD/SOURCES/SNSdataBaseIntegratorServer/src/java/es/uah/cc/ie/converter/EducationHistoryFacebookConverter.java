/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.EducationHistoryFacebook;
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

@XmlRootElement(name = "educationHistoryFacebook")
public class EducationHistoryFacebookConverter {
    private EducationHistoryFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of EducationHistoryFacebookConverter */
    public EducationHistoryFacebookConverter() {
        entity = new EducationHistoryFacebook();
    }

    /**
     * Creates a new instance of EducationHistoryFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public EducationHistoryFacebookConverter(EducationHistoryFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdEducationHistoryFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserFacebook();
    }

    /**
     * Creates a new instance of EducationHistoryFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public EducationHistoryFacebookConverter(EducationHistoryFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idEducationHistoryFacebook.
     *
     * @return value for idEducationHistoryFacebook
     */
    @XmlElement
    public Integer getIdEducationHistoryFacebook() {
        return (expandLevel > 0) ? entity.getIdEducationHistoryFacebook() : null;
    }

    /**
     * Setter for idEducationHistoryFacebook.
     *
     * @param value the value to set
     */
    public void setIdEducationHistoryFacebook(Integer value) {
        entity.setIdEducationHistoryFacebook(value);
    }

    /**
     * Getter for year.
     *
     * @return value for year
     */
    @XmlElement
    public String getYear() {
        return (expandLevel > 0) ? entity.getYear() : null;
    }

    /**
     * Setter for year.
     *
     * @param value the value to set
     */
    public void setYear(String value) {
        entity.setYear(value);
    }

    /**
     * Getter for name.
     *
     * @return value for name
     */
    @XmlElement
    public String getName() {
        return (expandLevel > 0) ? entity.getName() : null;
    }

    /**
     * Setter for name.
     *
     * @param value the value to set
     */
    public void setName(String value) {
        entity.setName(value);
    }

    /**
     * Getter for degree.
     *
     * @return value for degree
     */
    @XmlElement
    public String getDegree() {
        return (expandLevel > 0) ? entity.getDegree() : null;
    }

    /**
     * Setter for degree.
     *
     * @param value the value to set
     */
    public void setDegree(String value) {
        entity.setDegree(value);
    }

    /**
     * Getter for concentrations0.
     *
     * @return value for concentrations0
     */
    @XmlElement
    public String getConcentrations0() {
        return (expandLevel > 0) ? entity.getConcentrations0() : null;
    }

    /**
     * Setter for concentrations0.
     *
     * @param value the value to set
     */
    public void setConcentrations0(String value) {
        entity.setConcentrations0(value);
    }

    /**
     * Getter for concentrations1.
     *
     * @return value for concentrations1
     */
    @XmlElement
    public String getConcentrations1() {
        return (expandLevel > 0) ? entity.getConcentrations1() : null;
    }

    /**
     * Setter for concentrations1.
     *
     * @param value the value to set
     */
    public void setConcentrations1(String value) {
        entity.setConcentrations1(value);
    }

    /**
     * Getter for concentrations2.
     *
     * @return value for concentrations2
     */
    @XmlElement
    public String getConcentrations2() {
        return (expandLevel > 0) ? entity.getConcentrations2() : null;
    }

    /**
     * Setter for concentrations2.
     *
     * @param value the value to set
     */
    public void setConcentrations2(String value) {
        entity.setConcentrations2(value);
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
     * Returns the EducationHistoryFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public EducationHistoryFacebook getEntity() {
        if (entity.getIdEducationHistoryFacebook() == null) {
            EducationHistoryFacebookConverter converter = UriResolver.getInstance().resolve(EducationHistoryFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved EducationHistoryFacebook entity.
     *
     * @return an resolved entity
     */
    public EducationHistoryFacebook resolveEntity(EntityManager em) {
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            entity.setUserFacebook(em.getReference(UserFacebook.class, userFacebook.getIdUserFacebook()));
        }
        return entity;
    }
}
