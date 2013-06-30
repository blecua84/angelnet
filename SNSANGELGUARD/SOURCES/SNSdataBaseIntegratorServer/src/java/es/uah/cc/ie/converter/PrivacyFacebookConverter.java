/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.PrivacyFacebook;
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

@XmlRootElement(name = "privacyFacebook")
public class PrivacyFacebookConverter {
    private PrivacyFacebook entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PrivacyFacebookConverter */
    public PrivacyFacebookConverter() {
        entity = new PrivacyFacebook();
    }

    /**
     * Creates a new instance of PrivacyFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public PrivacyFacebookConverter(PrivacyFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdPrivacyFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getStreamFacebook();
    }

    /**
     * Creates a new instance of PrivacyFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PrivacyFacebookConverter(PrivacyFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idPrivacyFacebook.
     *
     * @return value for idPrivacyFacebook
     */
    @XmlElement
    public Integer getIdPrivacyFacebook() {
        return (expandLevel > 0) ? entity.getIdPrivacyFacebook() : null;
    }

    /**
     * Setter for idPrivacyFacebook.
     *
     * @param value the value to set
     */
    public void setIdPrivacyFacebook(Integer value) {
        entity.setIdPrivacyFacebook(value);
    }

    /**
     * Getter for uid.
     *
     * @return value for uid
     */
    @XmlElement
    public String getUid() {
        return (expandLevel > 0) ? entity.getUid() : null;
    }

    /**
     * Setter for uid.
     *
     * @param value the value to set
     */
    public void setUid(String value) {
        entity.setUid(value);
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
     * Returns the PrivacyFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public PrivacyFacebook getEntity() {
        if (entity.getIdPrivacyFacebook() == null) {
            PrivacyFacebookConverter converter = UriResolver.getInstance().resolve(PrivacyFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved PrivacyFacebook entity.
     *
     * @return an resolved entity
     */
    public PrivacyFacebook resolveEntity(EntityManager em) {
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            entity.setStreamFacebook(em.getReference(StreamFacebook.class, streamFacebook.getPostId()));
        }
        return entity;
    }
}
