/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "location_facebook")
@NamedQueries({
    @NamedQuery(name = "LocationFacebook.findAll", query = "SELECT l FROM LocationFacebook l"),
    @NamedQuery(name = "LocationFacebook.findByIdLocationFacebook", query = "SELECT l FROM LocationFacebook l WHERE l.idLocationFacebook = :idLocationFacebook"),
    @NamedQuery(name = "LocationFacebook.findByCity", query = "SELECT l FROM LocationFacebook l WHERE l.city = :city"),
    @NamedQuery(name = "LocationFacebook.findByState", query = "SELECT l FROM LocationFacebook l WHERE l.state = :state"),
    @NamedQuery(name = "LocationFacebook.findByCountry", query = "SELECT l FROM LocationFacebook l WHERE l.country = :country")})
public class LocationFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_location_facebook")
    private Integer idLocationFacebook;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "COUNTRY")
    private String country;
    @JoinTable(name = "location_facebook_has_user_facebook", joinColumns = {
        @JoinColumn(name = "location_facebook_id_location_facebook", referencedColumnName = "id_location_facebook")}, inverseJoinColumns = {
        @JoinColumn(name = "user_facebook_id_user_facebook", referencedColumnName = "id_user_facebook")})
    @ManyToMany
    private Collection<UserFacebook> userFacebookCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "locationFacebook")
    private Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollection;

    public LocationFacebook() {
    }

    public LocationFacebook(Integer idLocationFacebook) {
        this.idLocationFacebook = idLocationFacebook;
    }

    public Integer getIdLocationFacebook() {
        return idLocationFacebook;
    }

    public void setIdLocationFacebook(Integer idLocationFacebook) {
        this.idLocationFacebook = idLocationFacebook;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Collection<UserFacebook> getUserFacebookCollection() {
        return userFacebookCollection;
    }

    public void setUserFacebookCollection(Collection<UserFacebook> userFacebookCollection) {
        this.userFacebookCollection = userFacebookCollection;
    }

    public Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection() {
        return locationfacebookhasuserfacebookCURRENTLOCATIONCollection;
    }

    public void setLocationfacebookhasuserfacebookCURRENTLOCATIONCollection(Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollection) {
        this.locationfacebookhasuserfacebookCURRENTLOCATIONCollection = locationfacebookhasuserfacebookCURRENTLOCATIONCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocationFacebook != null ? idLocationFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocationFacebook)) {
            return false;
        }
        LocationFacebook other = (LocationFacebook) object;
        if ((this.idLocationFacebook == null && other.idLocationFacebook != null) || (this.idLocationFacebook != null && !this.idLocationFacebook.equals(other.idLocationFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.LocationFacebook[idLocationFacebook=" + idLocationFacebook + "]";
    }

}
