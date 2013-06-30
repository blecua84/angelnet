/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.TypeAffiliationsFacebook;
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

@XmlRootElement(name = "typeAffiliationsFacebooks")
public class TypeAffiliationsFacebooksConverter {
    private Collection<TypeAffiliationsFacebook> entities;
    private Collection<TypeAffiliationsFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of TypeAffiliationsFacebooksConverter */
    public TypeAffiliationsFacebooksConverter() {
    }

    /**
     * Creates a new instance of TypeAffiliationsFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public TypeAffiliationsFacebooksConverter(Collection<TypeAffiliationsFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getTypeAffiliationsFacebook();
    }

    /**
     * Returns a collection of TypeAffiliationsFacebookConverter.
     *
     * @return a collection of TypeAffiliationsFacebookConverter
     */
    @XmlElement
    public Collection<TypeAffiliationsFacebookConverter> getTypeAffiliationsFacebook() {
        if (items == null) {
            items = new ArrayList<TypeAffiliationsFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (TypeAffiliationsFacebook entity : entities) {
                items.add(new TypeAffiliationsFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of TypeAffiliationsFacebookConverter.
     *
     * @param a collection of TypeAffiliationsFacebookConverter to set
     */
    public void setTypeAffiliationsFacebook(Collection<TypeAffiliationsFacebookConverter> items) {
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
     * Returns a collection TypeAffiliationsFacebook entities.
     *
     * @return a collection of TypeAffiliationsFacebook entities
     */
    @XmlTransient
    public Collection<TypeAffiliationsFacebook> getEntities() {
        entities = new ArrayList<TypeAffiliationsFacebook>();
        if (items != null) {
            for (TypeAffiliationsFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
