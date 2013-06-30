/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.WorkHistoryFacebook;
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

@XmlRootElement(name = "workHistoryFacebooks")
public class WorkHistoryFacebooksConverter {
    private Collection<WorkHistoryFacebook> entities;
    private Collection<WorkHistoryFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of WorkHistoryFacebooksConverter */
    public WorkHistoryFacebooksConverter() {
    }

    /**
     * Creates a new instance of WorkHistoryFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public WorkHistoryFacebooksConverter(Collection<WorkHistoryFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getWorkHistoryFacebook();
    }

    /**
     * Returns a collection of WorkHistoryFacebookConverter.
     *
     * @return a collection of WorkHistoryFacebookConverter
     */
    @XmlElement
    public Collection<WorkHistoryFacebookConverter> getWorkHistoryFacebook() {
        if (items == null) {
            items = new ArrayList<WorkHistoryFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (WorkHistoryFacebook entity : entities) {
                items.add(new WorkHistoryFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of WorkHistoryFacebookConverter.
     *
     * @param a collection of WorkHistoryFacebookConverter to set
     */
    public void setWorkHistoryFacebook(Collection<WorkHistoryFacebookConverter> items) {
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
     * Returns a collection WorkHistoryFacebook entities.
     *
     * @return a collection of WorkHistoryFacebook entities
     */
    @XmlTransient
    public Collection<WorkHistoryFacebook> getEntities() {
        entities = new ArrayList<WorkHistoryFacebook>();
        if (items != null) {
            for (WorkHistoryFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
