/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SmokeropenSocial;
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

@XmlRootElement(name = "smokeropenSocials")
public class SmokeropenSocialsConverter {
    private Collection<SmokeropenSocial> entities;
    private Collection<SmokeropenSocialConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SmokeropenSocialsConverter */
    public SmokeropenSocialsConverter() {
    }

    /**
     * Creates a new instance of SmokeropenSocialsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SmokeropenSocialsConverter(Collection<SmokeropenSocial> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getSmokeropenSocial();
    }

    /**
     * Returns a collection of SmokeropenSocialConverter.
     *
     * @return a collection of SmokeropenSocialConverter
     */
    @XmlElement
    public Collection<SmokeropenSocialConverter> getSmokeropenSocial() {
        if (items == null) {
            items = new ArrayList<SmokeropenSocialConverter>();
        }
        if (entities != null) {
            items.clear();
            for (SmokeropenSocial entity : entities) {
                items.add(new SmokeropenSocialConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of SmokeropenSocialConverter.
     *
     * @param a collection of SmokeropenSocialConverter to set
     */
    public void setSmokeropenSocial(Collection<SmokeropenSocialConverter> items) {
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
     * Returns a collection SmokeropenSocial entities.
     *
     * @return a collection of SmokeropenSocial entities
     */
    @XmlTransient
    public Collection<SmokeropenSocial> getEntities() {
        entities = new ArrayList<SmokeropenSocial>();
        if (items != null) {
            for (SmokeropenSocialConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
