/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.AddressopenSocial;
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

@XmlRootElement(name = "addressopenSocials")
public class AddressopenSocialsConverter {
    private Collection<AddressopenSocial> entities;
    private Collection<AddressopenSocialConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of AddressopenSocialsConverter */
    public AddressopenSocialsConverter() {
    }

    /**
     * Creates a new instance of AddressopenSocialsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public AddressopenSocialsConverter(Collection<AddressopenSocial> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getAddressopenSocial();
    }

    /**
     * Returns a collection of AddressopenSocialConverter.
     *
     * @return a collection of AddressopenSocialConverter
     */
    @XmlElement
    public Collection<AddressopenSocialConverter> getAddressopenSocial() {
        if (items == null) {
            items = new ArrayList<AddressopenSocialConverter>();
        }
        if (entities != null) {
            items.clear();
            for (AddressopenSocial entity : entities) {
                items.add(new AddressopenSocialConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of AddressopenSocialConverter.
     *
     * @param a collection of AddressopenSocialConverter to set
     */
    public void setAddressopenSocial(Collection<AddressopenSocialConverter> items) {
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
     * Returns a collection AddressopenSocial entities.
     *
     * @return a collection of AddressopenSocial entities
     */
    @XmlTransient
    public Collection<AddressopenSocial> getEntities() {
        entities = new ArrayList<AddressopenSocial>();
        if (items != null) {
            for (AddressopenSocialConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
