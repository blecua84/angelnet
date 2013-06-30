/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author tote
 */
@Embeddable
public class LocationfacebookhasuserfacebookCURRENTLOCATIONPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "location_facebook_id_location_facebook")
    private int locationFacebookIdLocationFacebook;
    @Basic(optional = false)
    @Column(name = "user_facebook_id_user_facebook")
    private String userFacebookIdUserFacebook;

    public LocationfacebookhasuserfacebookCURRENTLOCATIONPK() {
    }

    public LocationfacebookhasuserfacebookCURRENTLOCATIONPK(int locationFacebookIdLocationFacebook, String userFacebookIdUserFacebook) {
        this.locationFacebookIdLocationFacebook = locationFacebookIdLocationFacebook;
        this.userFacebookIdUserFacebook = userFacebookIdUserFacebook;
    }

    public int getLocationFacebookIdLocationFacebook() {
        return locationFacebookIdLocationFacebook;
    }

    public void setLocationFacebookIdLocationFacebook(int locationFacebookIdLocationFacebook) {
        this.locationFacebookIdLocationFacebook = locationFacebookIdLocationFacebook;
    }

    public String getUserFacebookIdUserFacebook() {
        return userFacebookIdUserFacebook;
    }

    public void setUserFacebookIdUserFacebook(String userFacebookIdUserFacebook) {
        this.userFacebookIdUserFacebook = userFacebookIdUserFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) locationFacebookIdLocationFacebook;
        hash += (userFacebookIdUserFacebook != null ? userFacebookIdUserFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocationfacebookhasuserfacebookCURRENTLOCATIONPK)) {
            return false;
        }
        LocationfacebookhasuserfacebookCURRENTLOCATIONPK other = (LocationfacebookhasuserfacebookCURRENTLOCATIONPK) object;
        if (this.locationFacebookIdLocationFacebook != other.locationFacebookIdLocationFacebook) {
            return false;
        }
        if ((this.userFacebookIdUserFacebook == null && other.userFacebookIdUserFacebook != null) || (this.userFacebookIdUserFacebook != null && !this.userFacebookIdUserFacebook.equals(other.userFacebookIdUserFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATIONPK[locationFacebookIdLocationFacebook=" + locationFacebookIdLocationFacebook + ", userFacebookIdUserFacebook=" + userFacebookIdUserFacebook + "]";
    }

}
