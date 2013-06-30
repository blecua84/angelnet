/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.FamilyFacebook;
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

@XmlRootElement(name = "familyFacebooks")
public class FamilyFacebooksConverter {
    private Collection<FamilyFacebook> entities;
    private Collection<FamilyFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of FamilyFacebooksConverter */
    public FamilyFacebooksConverter() {
    }

    /**
     * Creates a new instance of FamilyFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public FamilyFacebooksConverter(Collection<FamilyFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getFamilyFacebook();
    }

    /**
     * Returns a collection of FamilyFacebookConverter.
     *
     * @return a collection of FamilyFacebookConverter
     */
    @XmlElement
    public Collection<FamilyFacebookConverter> getFamilyFacebook() {
        if (items == null) {
            items = new ArrayList<FamilyFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (FamilyFacebook entity : entities) {
                items.add(new FamilyFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of FamilyFacebookConverter.
     *
     * @param a collection of FamilyFacebookConverter to set
     */
    public void setFamilyFacebook(Collection<FamilyFacebookConverter> items) {
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
     * Returns a collection FamilyFacebook entities.
     *
     * @return a collection of FamilyFacebook entities
     */
    @XmlTransient
    public Collection<FamilyFacebook> getEntities() {
        entities = new ArrayList<FamilyFacebook>();
        if (items != null) {
            for (FamilyFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
