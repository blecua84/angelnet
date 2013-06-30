/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.AffiliationsFacebook;
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

@XmlRootElement(name = "affiliationsFacebooks")
public class AffiliationsFacebooksConverter {
    private Collection<AffiliationsFacebook> entities;
    private Collection<AffiliationsFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of AffiliationsFacebooksConverter */
    public AffiliationsFacebooksConverter() {
    }

    /**
     * Creates a new instance of AffiliationsFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public AffiliationsFacebooksConverter(Collection<AffiliationsFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getAffiliationsFacebook();
    }

    /**
     * Returns a collection of AffiliationsFacebookConverter.
     *
     * @return a collection of AffiliationsFacebookConverter
     */
    @XmlElement
    public Collection<AffiliationsFacebookConverter> getAffiliationsFacebook() {
        if (items == null) {
            items = new ArrayList<AffiliationsFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (AffiliationsFacebook entity : entities) {
                items.add(new AffiliationsFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of AffiliationsFacebookConverter.
     *
     * @param a collection of AffiliationsFacebookConverter to set
     */
    public void setAffiliationsFacebook(Collection<AffiliationsFacebookConverter> items) {
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
     * Returns a collection AffiliationsFacebook entities.
     *
     * @return a collection of AffiliationsFacebook entities
     */
    @XmlTransient
    public Collection<AffiliationsFacebook> getEntities() {
        entities = new ArrayList<AffiliationsFacebook>();
        if (items != null) {
            for (AffiliationsFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
