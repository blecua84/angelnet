/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.DrinkeropenSocial;
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

@XmlRootElement(name = "drinkeropenSocials")
public class DrinkeropenSocialsConverter {
    private Collection<DrinkeropenSocial> entities;
    private Collection<DrinkeropenSocialConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of DrinkeropenSocialsConverter */
    public DrinkeropenSocialsConverter() {
    }

    /**
     * Creates a new instance of DrinkeropenSocialsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public DrinkeropenSocialsConverter(Collection<DrinkeropenSocial> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getDrinkeropenSocial();
    }

    /**
     * Returns a collection of DrinkeropenSocialConverter.
     *
     * @return a collection of DrinkeropenSocialConverter
     */
    @XmlElement
    public Collection<DrinkeropenSocialConverter> getDrinkeropenSocial() {
        if (items == null) {
            items = new ArrayList<DrinkeropenSocialConverter>();
        }
        if (entities != null) {
            items.clear();
            for (DrinkeropenSocial entity : entities) {
                items.add(new DrinkeropenSocialConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of DrinkeropenSocialConverter.
     *
     * @param a collection of DrinkeropenSocialConverter to set
     */
    public void setDrinkeropenSocial(Collection<DrinkeropenSocialConverter> items) {
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
     * Returns a collection DrinkeropenSocial entities.
     *
     * @return a collection of DrinkeropenSocial entities
     */
    @XmlTransient
    public Collection<DrinkeropenSocial> getEntities() {
        entities = new ArrayList<DrinkeropenSocial>();
        if (items != null) {
            for (DrinkeropenSocialConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
