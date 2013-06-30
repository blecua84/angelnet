/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.RelationshipFacebook;
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

@XmlRootElement(name = "relationshipFacebooks")
public class RelationshipFacebooksConverter {
    private Collection<RelationshipFacebook> entities;
    private Collection<RelationshipFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of RelationshipFacebooksConverter */
    public RelationshipFacebooksConverter() {
    }

    /**
     * Creates a new instance of RelationshipFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public RelationshipFacebooksConverter(Collection<RelationshipFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getRelationshipFacebook();
    }

    /**
     * Returns a collection of RelationshipFacebookConverter.
     *
     * @return a collection of RelationshipFacebookConverter
     */
    @XmlElement
    public Collection<RelationshipFacebookConverter> getRelationshipFacebook() {
        if (items == null) {
            items = new ArrayList<RelationshipFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (RelationshipFacebook entity : entities) {
                items.add(new RelationshipFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of RelationshipFacebookConverter.
     *
     * @param a collection of RelationshipFacebookConverter to set
     */
    public void setRelationshipFacebook(Collection<RelationshipFacebookConverter> items) {
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
     * Returns a collection RelationshipFacebook entities.
     *
     * @return a collection of RelationshipFacebook entities
     */
    @XmlTransient
    public Collection<RelationshipFacebook> getEntities() {
        entities = new ArrayList<RelationshipFacebook>();
        if (items != null) {
            for (RelationshipFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
