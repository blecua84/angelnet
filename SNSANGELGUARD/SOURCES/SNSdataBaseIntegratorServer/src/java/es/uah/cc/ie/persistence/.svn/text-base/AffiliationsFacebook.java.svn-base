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
@Table(name = "affiliations_facebook")
@NamedQueries({
    @NamedQuery(name = "AffiliationsFacebook.findAll", query = "SELECT a FROM AffiliationsFacebook a"),
    @NamedQuery(name = "AffiliationsFacebook.findByIdAffiliationsFacebook", query = "SELECT a FROM AffiliationsFacebook a WHERE a.idAffiliationsFacebook = :idAffiliationsFacebook"),
    @NamedQuery(name = "AffiliationsFacebook.findByYear", query = "SELECT a FROM AffiliationsFacebook a WHERE a.year = :year"),
    @NamedQuery(name = "AffiliationsFacebook.findByName", query = "SELECT a FROM AffiliationsFacebook a WHERE a.name = :name"),
    @NamedQuery(name = "AffiliationsFacebook.findByNid", query = "SELECT a FROM AffiliationsFacebook a WHERE a.nid = :nid"),
    @NamedQuery(name = "AffiliationsFacebook.findByStatus", query = "SELECT a FROM AffiliationsFacebook a WHERE a.status = :status")})
public class AffiliationsFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_affiliations_facebook")
    private Integer idAffiliationsFacebook;
    @Column(name = "YEAR")
    private String year;
    @Column(name = "NAME")
    private String name;
    @Column(name = "NID")
    private Integer nid;
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "user_facebook_id_user_facebook", referencedColumnName = "id_user_facebook")
    @ManyToOne(optional = false)
    private UserFacebook userFacebook;
    @JoinColumn(name = "type_affiliations_facebook_id_type_affiliations_facebook", referencedColumnName = "id_type_affiliations_facebook")
    @ManyToOne(optional = false)
    private TypeAffiliationsFacebook typeAffiliationsFacebook;

    public AffiliationsFacebook() {
    }

    public AffiliationsFacebook(Integer idAffiliationsFacebook) {
        this.idAffiliationsFacebook = idAffiliationsFacebook;
    }

    public Integer getIdAffiliationsFacebook() {
        return idAffiliationsFacebook;
    }

    public void setIdAffiliationsFacebook(Integer idAffiliationsFacebook) {
        this.idAffiliationsFacebook = idAffiliationsFacebook;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserFacebook getUserFacebook() {
        return userFacebook;
    }

    public void setUserFacebook(UserFacebook userFacebook) {
        this.userFacebook = userFacebook;
    }

    public TypeAffiliationsFacebook getTypeAffiliationsFacebook() {
        return typeAffiliationsFacebook;
    }

    public void setTypeAffiliationsFacebook(TypeAffiliationsFacebook typeAffiliationsFacebook) {
        this.typeAffiliationsFacebook = typeAffiliationsFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAffiliationsFacebook != null ? idAffiliationsFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AffiliationsFacebook)) {
            return false;
        }
        AffiliationsFacebook other = (AffiliationsFacebook) object;
        if ((this.idAffiliationsFacebook == null && other.idAffiliationsFacebook != null) || (this.idAffiliationsFacebook != null && !this.idAffiliationsFacebook.equals(other.idAffiliationsFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.AffiliationsFacebook[idAffiliationsFacebook=" + idAffiliationsFacebook + "]";
    }

}
