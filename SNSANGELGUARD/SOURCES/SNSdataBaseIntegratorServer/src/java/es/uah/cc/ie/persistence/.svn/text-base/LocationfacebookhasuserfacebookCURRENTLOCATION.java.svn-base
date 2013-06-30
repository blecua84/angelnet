/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "location_facebook_has_user_facebook_CURRENT_LOCATION")
@NamedQueries({
    @NamedQuery(name = "LocationfacebookhasuserfacebookCURRENTLOCATION.findAll", query = "SELECT l FROM LocationfacebookhasuserfacebookCURRENTLOCATION l"),
    @NamedQuery(name = "LocationfacebookhasuserfacebookCURRENTLOCATION.findByLocationFacebookIdLocationFacebook", query = "SELECT l FROM LocationfacebookhasuserfacebookCURRENTLOCATION l WHERE l.locationfacebookhasuserfacebookCURRENTLOCATIONPK.locationFacebookIdLocationFacebook = :locationFacebookIdLocationFacebook"),
    @NamedQuery(name = "LocationfacebookhasuserfacebookCURRENTLOCATION.findByUserFacebookIdUserFacebook", query = "SELECT l FROM LocationfacebookhasuserfacebookCURRENTLOCATION l WHERE l.locationfacebookhasuserfacebookCURRENTLOCATIONPK.userFacebookIdUserFacebook = :userFacebookIdUserFacebook"),
    @NamedQuery(name = "LocationfacebookhasuserfacebookCURRENTLOCATION.findByZip", query = "SELECT l FROM LocationfacebookhasuserfacebookCURRENTLOCATION l WHERE l.zip = :zip")})
public class LocationfacebookhasuserfacebookCURRENTLOCATION implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LocationfacebookhasuserfacebookCURRENTLOCATIONPK locationfacebookhasuserfacebookCURRENTLOCATIONPK;
    @Column(name = "ZIP")
    private String zip;
    @JoinColumn(name = "user_facebook_id_user_facebook", referencedColumnName = "id_user_facebook", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserFacebook userFacebook;
    @JoinColumn(name = "location_facebook_id_location_facebook", referencedColumnName = "id_location_facebook", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private LocationFacebook locationFacebook;

    public LocationfacebookhasuserfacebookCURRENTLOCATION() {
    }

    public LocationfacebookhasuserfacebookCURRENTLOCATION(LocationfacebookhasuserfacebookCURRENTLOCATIONPK locationfacebookhasuserfacebookCURRENTLOCATIONPK) {
        this.locationfacebookhasuserfacebookCURRENTLOCATIONPK = locationfacebookhasuserfacebookCURRENTLOCATIONPK;
    }

    public LocationfacebookhasuserfacebookCURRENTLOCATION(int locationFacebookIdLocationFacebook, String userFacebookIdUserFacebook) {
        this.locationfacebookhasuserfacebookCURRENTLOCATIONPK = new LocationfacebookhasuserfacebookCURRENTLOCATIONPK(locationFacebookIdLocationFacebook, userFacebookIdUserFacebook);
    }

    public LocationfacebookhasuserfacebookCURRENTLOCATIONPK getLocationfacebookhasuserfacebookCURRENTLOCATIONPK() {
        return locationfacebookhasuserfacebookCURRENTLOCATIONPK;
    }

    public void setLocationfacebookhasuserfacebookCURRENTLOCATIONPK(LocationfacebookhasuserfacebookCURRENTLOCATIONPK locationfacebookhasuserfacebookCURRENTLOCATIONPK) {
        this.locationfacebookhasuserfacebookCURRENTLOCATIONPK = locationfacebookhasuserfacebookCURRENTLOCATIONPK;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public UserFacebook getUserFacebook() {
        return userFacebook;
    }

    public void setUserFacebook(UserFacebook userFacebook) {
        this.userFacebook = userFacebook;
    }

    public LocationFacebook getLocationFacebook() {
        return locationFacebook;
    }

    public void setLocationFacebook(LocationFacebook locationFacebook) {
        this.locationFacebook = locationFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationfacebookhasuserfacebookCURRENTLOCATIONPK != null ? locationfacebookhasuserfacebookCURRENTLOCATIONPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocationfacebookhasuserfacebookCURRENTLOCATION)) {
            return false;
        }
        LocationfacebookhasuserfacebookCURRENTLOCATION other = (LocationfacebookhasuserfacebookCURRENTLOCATION) object;
        if ((this.locationfacebookhasuserfacebookCURRENTLOCATIONPK == null && other.locationfacebookhasuserfacebookCURRENTLOCATIONPK != null) || (this.locationfacebookhasuserfacebookCURRENTLOCATIONPK != null && !this.locationfacebookhasuserfacebookCURRENTLOCATIONPK.equals(other.locationfacebookhasuserfacebookCURRENTLOCATIONPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATION[locationfacebookhasuserfacebookCURRENTLOCATIONPK=" + locationfacebookhasuserfacebookCURRENTLOCATIONPK + "]";
    }

}
