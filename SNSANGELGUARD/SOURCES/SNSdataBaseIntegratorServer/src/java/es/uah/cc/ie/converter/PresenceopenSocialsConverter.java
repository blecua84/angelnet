/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.PresenceopenSocial;
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

@XmlRootElement(name = "presenceopenSocials")
public class PresenceopenSocialsConverter {
    private Collection<PresenceopenSocial> entities;
    private Collection<PresenceopenSocialConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PresenceopenSocialsConverter */
    public PresenceopenSocialsConverter() {
    }

    /**
     * Creates a new instance of PresenceopenSocialsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PresenceopenSocialsConverter(Collection<PresenceopenSocial> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getPresenceopenSocial();
    }

    /**
     * Returns a collection of PresenceopenSocialConverter.
     *
     * @return a collection of PresenceopenSocialConverter
     */
    @XmlElement
    public Collection<PresenceopenSocialConverter> getPresenceopenSocial() {
        if (items == null) {
            items = new ArrayList<PresenceopenSocialConverter>();
        }
        if (entities != null) {
            items.clear();
            for (PresenceopenSocial entity : entities) {
                items.add(new PresenceopenSocialConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of PresenceopenSocialConverter.
     *
     * @param a collection of PresenceopenSocialConverter to set
     */
    public void setPresenceopenSocial(Collection<PresenceopenSocialConverter> items) {
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
     * Returns a collection PresenceopenSocial entities.
     *
     * @return a collection of PresenceopenSocial entities
     */
    @XmlTransient
    public Collection<PresenceopenSocial> getEntities() {
        entities = new ArrayList<PresenceopenSocial>();
        if (items != null) {
            for (PresenceopenSocialConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
