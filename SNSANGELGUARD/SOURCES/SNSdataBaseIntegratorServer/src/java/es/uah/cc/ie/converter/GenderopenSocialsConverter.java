/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.GenderopenSocial;
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

@XmlRootElement(name = "genderopenSocials")
public class GenderopenSocialsConverter {
    private Collection<GenderopenSocial> entities;
    private Collection<GenderopenSocialConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of GenderopenSocialsConverter */
    public GenderopenSocialsConverter() {
    }

    /**
     * Creates a new instance of GenderopenSocialsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public GenderopenSocialsConverter(Collection<GenderopenSocial> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getGenderopenSocial();
    }

    /**
     * Returns a collection of GenderopenSocialConverter.
     *
     * @return a collection of GenderopenSocialConverter
     */
    @XmlElement
    public Collection<GenderopenSocialConverter> getGenderopenSocial() {
        if (items == null) {
            items = new ArrayList<GenderopenSocialConverter>();
        }
        if (entities != null) {
            items.clear();
            for (GenderopenSocial entity : entities) {
                items.add(new GenderopenSocialConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of GenderopenSocialConverter.
     *
     * @param a collection of GenderopenSocialConverter to set
     */
    public void setGenderopenSocial(Collection<GenderopenSocialConverter> items) {
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
     * Returns a collection GenderopenSocial entities.
     *
     * @return a collection of GenderopenSocial entities
     */
    @XmlTransient
    public Collection<GenderopenSocial> getEntities() {
        entities = new ArrayList<GenderopenSocial>();
        if (items != null) {
            for (GenderopenSocialConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
