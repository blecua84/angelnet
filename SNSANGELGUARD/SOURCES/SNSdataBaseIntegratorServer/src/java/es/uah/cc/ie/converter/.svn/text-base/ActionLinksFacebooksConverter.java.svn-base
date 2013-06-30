/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.ActionLinksFacebook;
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

@XmlRootElement(name = "actionLinksFacebooks")
public class ActionLinksFacebooksConverter {
    private Collection<ActionLinksFacebook> entities;
    private Collection<ActionLinksFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ActionLinksFacebooksConverter */
    public ActionLinksFacebooksConverter() {
    }

    /**
     * Creates a new instance of ActionLinksFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ActionLinksFacebooksConverter(Collection<ActionLinksFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getActionLinksFacebook();
    }

    /**
     * Returns a collection of ActionLinksFacebookConverter.
     *
     * @return a collection of ActionLinksFacebookConverter
     */
    @XmlElement
    public Collection<ActionLinksFacebookConverter> getActionLinksFacebook() {
        if (items == null) {
            items = new ArrayList<ActionLinksFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (ActionLinksFacebook entity : entities) {
                items.add(new ActionLinksFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of ActionLinksFacebookConverter.
     *
     * @param a collection of ActionLinksFacebookConverter to set
     */
    public void setActionLinksFacebook(Collection<ActionLinksFacebookConverter> items) {
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
     * Returns a collection ActionLinksFacebook entities.
     *
     * @return a collection of ActionLinksFacebook entities
     */
    @XmlTransient
    public Collection<ActionLinksFacebook> getEntities() {
        entities = new ArrayList<ActionLinksFacebook>();
        if (items != null) {
            for (ActionLinksFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
