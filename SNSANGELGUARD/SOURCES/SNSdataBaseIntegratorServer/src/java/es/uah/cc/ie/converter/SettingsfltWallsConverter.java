/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.SettingsfltWall;
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

@XmlRootElement(name = "settingsfltWalls")
public class SettingsfltWallsConverter {
    private Collection<SettingsfltWall> entities;
    private Collection<SettingsfltWallConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of SettingsfltWallsConverter */
    public SettingsfltWallsConverter() {
    }

    /**
     * Creates a new instance of SettingsfltWallsConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public SettingsfltWallsConverter(Collection<SettingsfltWall> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getSettingsfltWall();
    }

    /**
     * Returns a collection of SettingsfltWallConverter.
     *
     * @return a collection of SettingsfltWallConverter
     */
    @XmlElement
    public Collection<SettingsfltWallConverter> getSettingsfltWall() {
        if (items == null) {
            items = new ArrayList<SettingsfltWallConverter>();
        }
        if (entities != null) {
            items.clear();
            for (SettingsfltWall entity : entities) {
                items.add(new SettingsfltWallConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of SettingsfltWallConverter.
     *
     * @param a collection of SettingsfltWallConverter to set
     */
    public void setSettingsfltWall(Collection<SettingsfltWallConverter> items) {
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
     * Returns a collection SettingsfltWall entities.
     *
     * @return a collection of SettingsfltWall entities
     */
    @XmlTransient
    public Collection<SettingsfltWall> getEntities() {
        entities = new ArrayList<SettingsfltWall>();
        if (items != null) {
            for (SettingsfltWallConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
