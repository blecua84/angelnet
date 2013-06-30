/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.PrivacyFacebook;
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

@XmlRootElement(name = "privacyFacebooks")
public class PrivacyFacebooksConverter {
    private Collection<PrivacyFacebook> entities;
    private Collection<PrivacyFacebookConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of PrivacyFacebooksConverter */
    public PrivacyFacebooksConverter() {
    }

    /**
     * Creates a new instance of PrivacyFacebooksConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public PrivacyFacebooksConverter(Collection<PrivacyFacebook> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getPrivacyFacebook();
    }

    /**
     * Returns a collection of PrivacyFacebookConverter.
     *
     * @return a collection of PrivacyFacebookConverter
     */
    @XmlElement
    public Collection<PrivacyFacebookConverter> getPrivacyFacebook() {
        if (items == null) {
            items = new ArrayList<PrivacyFacebookConverter>();
        }
        if (entities != null) {
            items.clear();
            for (PrivacyFacebook entity : entities) {
                items.add(new PrivacyFacebookConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of PrivacyFacebookConverter.
     *
     * @param a collection of PrivacyFacebookConverter to set
     */
    public void setPrivacyFacebook(Collection<PrivacyFacebookConverter> items) {
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
     * Returns a collection PrivacyFacebook entities.
     *
     * @return a collection of PrivacyFacebook entities
     */
    @XmlTransient
    public Collection<PrivacyFacebook> getEntities() {
        entities = new ArrayList<PrivacyFacebook>();
        if (items != null) {
            for (PrivacyFacebookConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
