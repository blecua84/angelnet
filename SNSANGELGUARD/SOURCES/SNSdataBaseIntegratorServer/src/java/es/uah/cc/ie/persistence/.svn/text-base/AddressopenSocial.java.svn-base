/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "Address_openSocial")
@NamedQueries({
    @NamedQuery(name = "AddressopenSocial.findAll", query = "SELECT a FROM AddressopenSocial a"),
    @NamedQuery(name = "AddressopenSocial.findByIdAddressopenSocial", query = "SELECT a FROM AddressopenSocial a WHERE a.idAddressopenSocial = :idAddressopenSocial"),
    @NamedQuery(name = "AddressopenSocial.findByCountry", query = "SELECT a FROM AddressopenSocial a WHERE a.country = :country"),
    @NamedQuery(name = "AddressopenSocial.findByExtendedAddress", query = "SELECT a FROM AddressopenSocial a WHERE a.extendedAddress = :extendedAddress"),
    @NamedQuery(name = "AddressopenSocial.findByLatitude", query = "SELECT a FROM AddressopenSocial a WHERE a.latitude = :latitude"),
    @NamedQuery(name = "AddressopenSocial.findByLocality", query = "SELECT a FROM AddressopenSocial a WHERE a.locality = :locality"),
    @NamedQuery(name = "AddressopenSocial.findByLongitude", query = "SELECT a FROM AddressopenSocial a WHERE a.longitude = :longitude"),
    @NamedQuery(name = "AddressopenSocial.findByPoBox", query = "SELECT a FROM AddressopenSocial a WHERE a.poBox = :poBox"),
    @NamedQuery(name = "AddressopenSocial.findByPostalCode", query = "SELECT a FROM AddressopenSocial a WHERE a.postalCode = :postalCode"),
    @NamedQuery(name = "AddressopenSocial.findByRegion", query = "SELECT a FROM AddressopenSocial a WHERE a.region = :region"),
    @NamedQuery(name = "AddressopenSocial.findByStreetAddress", query = "SELECT a FROM AddressopenSocial a WHERE a.streetAddress = :streetAddress"),
    @NamedQuery(name = "AddressopenSocial.findByType", query = "SELECT a FROM AddressopenSocial a WHERE a.type = :type"),
    @NamedQuery(name = "AddressopenSocial.findByUnstructured", query = "SELECT a FROM AddressopenSocial a WHERE a.unstructured = :unstructured"),
    @NamedQuery(name = "AddressopenSocial.findByUseropenSocialiduseropenSocial", query = "SELECT a FROM AddressopenSocial a WHERE a.useropenSocialiduseropenSocial = :useropenSocialiduseropenSocial")})
public class AddressopenSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_Address_openSocial")
    private String idAddressopenSocial;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "EXTENDED_ADDRESS")
    private String extendedAddress;
    @Column(name = "LATITUDE")
    private Integer latitude;
    @Column(name = "LOCALITY")
    private String locality;
    @Column(name = "LONGITUDE")
    private Integer longitude;
    @Column(name = "PO_BOX")
    private String poBox;
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Column(name = "REGION")
    private String region;
    @Column(name = "STREET_ADDRESS")
    private String streetAddress;
    @Column(name = "TYPE")
    private String type;
    @Column(name = "UNSTRUCTURED")
    private String unstructured;
    @Basic(optional = false)
    @Column(name = "user_openSocial_iduser_openSocial")
    private int useropenSocialiduseropenSocial;

    public AddressopenSocial() {
    }

    public AddressopenSocial(String idAddressopenSocial) {
        this.idAddressopenSocial = idAddressopenSocial;
    }

    public AddressopenSocial(String idAddressopenSocial, int useropenSocialiduseropenSocial) {
        this.idAddressopenSocial = idAddressopenSocial;
        this.useropenSocialiduseropenSocial = useropenSocialiduseropenSocial;
    }

    public String getIdAddressopenSocial() {
        return idAddressopenSocial;
    }

    public void setIdAddressopenSocial(String idAddressopenSocial) {
        this.idAddressopenSocial = idAddressopenSocial;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getExtendedAddress() {
        return extendedAddress;
    }

    public void setExtendedAddress(String extendedAddress) {
        this.extendedAddress = extendedAddress;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnstructured() {
        return unstructured;
    }

    public void setUnstructured(String unstructured) {
        this.unstructured = unstructured;
    }

    public int getUseropenSocialiduseropenSocial() {
        return useropenSocialiduseropenSocial;
    }

    public void setUseropenSocialiduseropenSocial(int useropenSocialiduseropenSocial) {
        this.useropenSocialiduseropenSocial = useropenSocialiduseropenSocial;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAddressopenSocial != null ? idAddressopenSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressopenSocial)) {
            return false;
        }
        AddressopenSocial other = (AddressopenSocial) object;
        if ((this.idAddressopenSocial == null && other.idAddressopenSocial != null) || (this.idAddressopenSocial != null && !this.idAddressopenSocial.equals(other.idAddressopenSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.AddressopenSocial[idAddressopenSocial=" + idAddressopenSocial + "]";
    }

}
