/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.CommentFacebook;
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

@XmlRootElement(name = "commentFacebooks")
public class CommentFacebooksConverter {
    private Collection<CommentFacebook> entities;
    private Collection<CommentFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of CommentFacebooksConverter */
    public CommentFacebooksConverter() {
    }

    /**
     * Creates a new instance of CommentFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public CommentFacebooksConverter(Collection<CommentFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getCommentFacebook();
    }

    /**
     * Returns a collection of CommentFacebookConverter.
     *
     * @return a collection of CommentFacebookConverter
     */
    @XmlElement
    public Collection<CommentFacebookConverter> getCommentFacebook() {
        if (items == null) {
            items = new ArrayList<CommentFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (CommentFacebook entity : entities) {
                items.add(new CommentFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of CommentFacebookConverter.
     *
     * @param a collection of CommentFacebookConverter to set
     */
    public void setCommentFacebook(Collection<CommentFacebookConverter> items) {
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
     * Returns a collection CommentFacebook entities.
     *
     * @return a collection of CommentFacebook entities
     */
    @XmlTransient
    public Collection<CommentFacebook> getEntities() {
        entities = new ArrayList<CommentFacebook>();
        if (items != null) {
            for (CommentFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
