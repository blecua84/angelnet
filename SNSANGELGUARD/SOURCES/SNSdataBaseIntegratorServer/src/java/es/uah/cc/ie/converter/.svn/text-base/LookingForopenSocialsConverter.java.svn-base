/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.LookingForopenSocial;
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

@XmlRootElement(name = "lookingForopenSocials")
public class LookingForopenSocialsConverter {
    private Collection<LookingForopenSocial> entities;
    private Collection<LookingForopenSocialConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of LookingForopenSocialsConverter */
    public LookingForopenSocialsConverter() {
    }

    /**
     * Creates a new instance of LookingForopenSocialsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public LookingForopenSocialsConverter(Collection<LookingForopenSocial> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getLookingForopenSocial();
    }

    /**
     * Returns a collection of LookingForopenSocialConverter.
     *
     * @return a collection of LookingForopenSocialConverter
     */
    @XmlElement
    public Collection<LookingForopenSocialConverter> getLookingForopenSocial() {
        if (items == null) {
            items = new ArrayList<LookingForopenSocialConverter>();
        }
        if (entities != null) {
            items.clear();
            for (LookingForopenSocial entity : entities) {
                items.add(new LookingForopenSocialConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of LookingForopenSocialConverter.
     *
     * @param a collection of LookingForopenSocialConverter to set
     */
    public void setLookingForopenSocial(Collection<LookingForopenSocialConverter> items) {
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
     * Returns a collection LookingForopenSocial entities.
     *
     * @return a collection of LookingForopenSocial entities
     */
    @XmlTransient
    public Collection<LookingForopenSocial> getEntities() {
        entities = new ArrayList<LookingForopenSocial>();
        if (items != null) {
            for (LookingForopenSocialConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
