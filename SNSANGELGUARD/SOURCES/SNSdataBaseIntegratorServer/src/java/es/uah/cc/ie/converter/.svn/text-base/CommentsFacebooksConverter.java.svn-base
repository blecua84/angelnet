/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.CommentsFacebook;
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

@XmlRootElement(name = "commentsFacebooks")
public class CommentsFacebooksConverter {
    private Collection<CommentsFacebook> entities;
    private Collection<CommentsFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of CommentsFacebooksConverter */
    public CommentsFacebooksConverter() {
    }

    /**
     * Creates a new instance of CommentsFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public CommentsFacebooksConverter(Collection<CommentsFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getCommentsFacebook();
    }

    /**
     * Returns a collection of CommentsFacebookConverter.
     *
     * @return a collection of CommentsFacebookConverter
     */
    @XmlElement
    public Collection<CommentsFacebookConverter> getCommentsFacebook() {
        if (items == null) {
            items = new ArrayList<CommentsFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (CommentsFacebook entity : entities) {
                items.add(new CommentsFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of CommentsFacebookConverter.
     *
     * @param a collection of CommentsFacebookConverter to set
     */
    public void setCommentsFacebook(Collection<CommentsFacebookConverter> items) {
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
     * Returns a collection CommentsFacebook entities.
     *
     * @return a collection of CommentsFacebook entities
     */
    @XmlTransient
    public Collection<CommentsFacebook> getEntities() {
        entities = new ArrayList<CommentsFacebook>();
        if (items != null) {
            for (CommentsFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
