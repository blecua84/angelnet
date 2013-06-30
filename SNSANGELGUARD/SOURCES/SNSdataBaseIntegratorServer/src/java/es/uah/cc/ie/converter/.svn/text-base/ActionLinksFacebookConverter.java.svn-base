/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.ActionLinksFacebook;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.StreamFacebook;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "actionLinksFacebook")
public class ActionLinksFacebookConverter {
    private ActionLinksFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ActionLinksFacebookConverter */
    public ActionLinksFacebookConverter() {
        entity = new ActionLinksFacebook();
    }

    /**
     * Creates a new instance of ActionLinksFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public ActionLinksFacebookConverter(ActionLinksFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdActionLinksFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getStreamFacebook();
    }

    /**
     * Creates a new instance of ActionLinksFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ActionLinksFacebookConverter(ActionLinksFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idActionLinksFacebook.
     *
     * @return value for idActionLinksFacebook
     */
    @XmlElement
    public Integer getIdActionLinksFacebook() {
        return (expandLevel > 0) ? entity.getIdActionLinksFacebook() : null;
    }

    /**
     * Setter for idActionLinksFacebook.
     *
     * @param value the value to set
     */
    public void setIdActionLinksFacebook(Integer value) {
        entity.setIdActionLinksFacebook(value);
    }

    /**
     * Getter for text.
     *
     * @return value for text
     */
    @XmlElement
    public String getText() {
        return (expandLevel > 0) ? entity.getText() : null;
    }

    /**
     * Setter for text.
     *
     * @param value the value to set
     */
    public void setText(String value) {
        entity.setText(value);
    }

    /**
     * Getter for url.
     *
     * @return value for url
     */
    @XmlElement
    public String getUrl() {
        return (expandLevel > 0) ? entity.getUrl() : null;
    }

    /**
     * Setter for url.
     *
     * @param value the value to set
     */
    public void setUrl(String value) {
        entity.setUrl(value);
    }

    /**
     * Getter for streamFacebook.
     *
     * @return value for streamFacebook
     */
    @XmlElement
    public StreamFacebookConverter getStreamFacebook() {
        if (expandLevel > 0) {
            if (entity.getStreamFacebook() != null) {
                return new StreamFacebookConverter(entity.getStreamFacebook(), uri.resolve("streamFacebook/"), expandLevel - 1, false);
            }
        }
        return null;
    }

    /**
     * Setter for streamFacebook.
     *
     * @param value the value to set
     */
    public void setStreamFacebook(StreamFacebookConverter value) {
        entity.setStreamFacebook((value != null) ? value.getEntity() : null);
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
     * Sets the URI for this reference converter.
     *
     */
    public void setUri(URI uri) {
        this.uri = uri;
    }

    /**
     * Returns the ActionLinksFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public ActionLinksFacebook getEntity() {
        if (entity.getIdActionLinksFacebook() == null) {
            ActionLinksFacebookConverter converter = UriResolver.getInstance().resolve(ActionLinksFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved ActionLinksFacebook entity.
     *
     * @return an resolved entity
     */
    public ActionLinksFacebook resolveEntity(EntityManager em) {
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            entity.setStreamFacebook(em.getReference(StreamFacebook.class, streamFacebook.getPostId()));
        }
        return entity;
    }
}
