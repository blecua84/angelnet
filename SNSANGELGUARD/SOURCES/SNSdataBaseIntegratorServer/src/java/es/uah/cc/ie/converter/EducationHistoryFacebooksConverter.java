/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.EducationHistoryFacebook;
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

@XmlRootElement(name = "educationHistoryFacebooks")
public class EducationHistoryFacebooksConverter {
    private Collection<EducationHistoryFacebook> entities;
    private Collection<EducationHistoryFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of EducationHistoryFacebooksConverter */
    public EducationHistoryFacebooksConverter() {
    }

    /**
     * Creates a new instance of EducationHistoryFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public EducationHistoryFacebooksConverter(Collection<EducationHistoryFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getEducationHistoryFacebook();
    }

    /**
     * Returns a collection of EducationHistoryFacebookConverter.
     *
     * @return a collection of EducationHistoryFacebookConverter
     */
    @XmlElement
    public Collection<EducationHistoryFacebookConverter> getEducationHistoryFacebook() {
        if (items == null) {
            items = new ArrayList<EducationHistoryFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (EducationHistoryFacebook entity : entities) {
                items.add(new EducationHistoryFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of EducationHistoryFacebookConverter.
     *
     * @param a collection of EducationHistoryFacebookConverter to set
     */
    public void setEducationHistoryFacebook(Collection<EducationHistoryFacebookConverter> items) {
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
     * Returns a collection EducationHistoryFacebook entities.
     *
     * @return a collection of EducationHistoryFacebook entities
     */
    @XmlTransient
    public Collection<EducationHistoryFacebook> getEntities() {
        entities = new ArrayList<EducationHistoryFacebook>();
        if (items != null) {
            for (EducationHistoryFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
