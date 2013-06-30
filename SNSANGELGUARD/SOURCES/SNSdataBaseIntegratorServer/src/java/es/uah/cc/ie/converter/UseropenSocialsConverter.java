/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.UseropenSocial;
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

@XmlRootElement(name = "useropenSocials")
public class UseropenSocialsConverter {
    private Collection<UseropenSocial> entities;
    private Collection<UseropenSocialConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of UseropenSocialsConverter */
    public UseropenSocialsConverter() {
    }

    /**
     * Creates a new instance of UseropenSocialsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public UseropenSocialsConverter(Collection<UseropenSocial> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getUseropenSocial();
    }

    /**
     * Returns a collection of UseropenSocialConverter.
     *
     * @return a collection of UseropenSocialConverter
     */
    @XmlElement
    public Collection<UseropenSocialConverter> getUseropenSocial() {
        if (items == null) {
            items = new ArrayList<UseropenSocialConverter>();
        }
        if (entities != null) {
            items.clear();
            for (UseropenSocial entity : entities) {
                items.add(new UseropenSocialConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of UseropenSocialConverter.
     *
     * @param a collection of UseropenSocialConverter to set
     */
    public void setUseropenSocial(Collection<UseropenSocialConverter> items) {
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
     * Returns a collection UseropenSocial entities.
     *
     * @return a collection of UseropenSocial entities
     */
    @XmlTransient
    public Collection<UseropenSocial> getEntities() {
        entities = new ArrayList<UseropenSocial>();
        if (items != null) {
            for (UseropenSocialConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
