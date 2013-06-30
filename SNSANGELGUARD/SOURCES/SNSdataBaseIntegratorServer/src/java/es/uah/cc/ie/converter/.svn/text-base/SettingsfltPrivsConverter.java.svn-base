/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SettingsfltPriv;
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

@XmlRootElement(name = "settingsfltPrivs")
public class SettingsfltPrivsConverter {
    private Collection<SettingsfltPriv> entities;
    private Collection<SettingsfltPrivConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SettingsfltPrivsConverter */
    public SettingsfltPrivsConverter() {
    }

    /**
     * Creates a new instance of SettingsfltPrivsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SettingsfltPrivsConverter(Collection<SettingsfltPriv> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getSettingsfltPriv();
    }

    /**
     * Returns a collection of SettingsfltPrivConverter.
     *
     * @return a collection of SettingsfltPrivConverter
     */
    @XmlElement
    public Collection<SettingsfltPrivConverter> getSettingsfltPriv() {
        if (items == null) {
            items = new ArrayList<SettingsfltPrivConverter>();
        }
        if (entities != null) {
            items.clear();
            for (SettingsfltPriv entity : entities) {
                items.add(new SettingsfltPrivConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of SettingsfltPrivConverter.
     *
     * @param a collection of SettingsfltPrivConverter to set
     */
    public void setSettingsfltPriv(Collection<SettingsfltPrivConverter> items) {
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
     * Returns a collection SettingsfltPriv entities.
     *
     * @return a collection of SettingsfltPriv entities
     */
    @XmlTransient
    public Collection<SettingsfltPriv> getEntities() {
        entities = new ArrayList<SettingsfltPriv>();
        if (items != null) {
            for (SettingsfltPrivConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
