/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SettingsfltVist;
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

@XmlRootElement(name = "settingsfltVists")
public class SettingsfltVistsConverter {
    private Collection<SettingsfltVist> entities;
    private Collection<SettingsfltVistConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SettingsfltVistsConverter */
    public SettingsfltVistsConverter() {
    }

    /**
     * Creates a new instance of SettingsfltVistsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SettingsfltVistsConverter(Collection<SettingsfltVist> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getSettingsfltVist();
    }

    /**
     * Returns a collection of SettingsfltVistConverter.
     *
     * @return a collection of SettingsfltVistConverter
     */
    @XmlElement
    public Collection<SettingsfltVistConverter> getSettingsfltVist() {
        if (items == null) {
            items = new ArrayList<SettingsfltVistConverter>();
        }
        if (entities != null) {
            items.clear();
            for (SettingsfltVist entity : entities) {
                items.add(new SettingsfltVistConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of SettingsfltVistConverter.
     *
     * @param a collection of SettingsfltVistConverter to set
     */
    public void setSettingsfltVist(Collection<SettingsfltVistConverter> items) {
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
     * Returns a collection SettingsfltVist entities.
     *
     * @return a collection of SettingsfltVist entities
     */
    @XmlTransient
    public Collection<SettingsfltVist> getEntities() {
        entities = new ArrayList<SettingsfltVist>();
        if (items != null) {
            for (SettingsfltVistConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
