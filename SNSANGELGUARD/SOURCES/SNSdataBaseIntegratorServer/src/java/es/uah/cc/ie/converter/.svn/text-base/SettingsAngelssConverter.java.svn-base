/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SettingsAngels;
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

@XmlRootElement(name = "settingsAngelss")
public class SettingsAngelssConverter {
    private Collection<SettingsAngels> entities;
    private Collection<SettingsAngelsConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SettingsAngelssConverter */
    public SettingsAngelssConverter() {
    }

    /**
     * Creates a new instance of SettingsAngelssConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SettingsAngelssConverter(Collection<SettingsAngels> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getSettingsAngels();
    }

    /**
     * Returns a collection of SettingsAngelsConverter.
     *
     * @return a collection of SettingsAngelsConverter
     */
    @XmlElement
    public Collection<SettingsAngelsConverter> getSettingsAngels() {
        if (items == null) {
            items = new ArrayList<SettingsAngelsConverter>();
        }
        if (entities != null) {
            items.clear();
            for (SettingsAngels entity : entities) {
                items.add(new SettingsAngelsConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of SettingsAngelsConverter.
     *
     * @param a collection of SettingsAngelsConverter to set
     */
    public void setSettingsAngels(Collection<SettingsAngelsConverter> items) {
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
     * Returns a collection SettingsAngels entities.
     *
     * @return a collection of SettingsAngels entities
     */
    @XmlTransient
    public Collection<SettingsAngels> getEntities() {
        entities = new ArrayList<SettingsAngels>();
        if (items != null) {
            for (SettingsAngelsConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
