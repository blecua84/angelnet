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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "type_affiliations_facebook")
@NamedQueries({
    @NamedQuery(name = "TypeAffiliationsFacebook.findAll", query = "SELECT t FROM TypeAffiliationsFacebook t"),
    @NamedQuery(name = "TypeAffiliationsFacebook.findByIdTypeAffiliationsFacebook", query = "SELECT t FROM TypeAffiliationsFacebook t WHERE t.idTypeAffiliationsFacebook = :idTypeAffiliationsFacebook"),
    @NamedQuery(name = "TypeAffiliationsFacebook.findByType", query = "SELECT t FROM TypeAffiliationsFacebook t WHERE t.type = :type")})
public class TypeAffiliationsFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_type_affiliations_facebook")
    private Integer idTypeAffiliationsFacebook;
    @Column(name = "TYPE")
    private String type;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeAffiliationsFacebook")
    private Collection<AffiliationsFacebook> affiliationsFacebookCollection;

    public TypeAffiliationsFacebook() {
    }

    public TypeAffiliationsFacebook(Integer idTypeAffiliationsFacebook) {
        this.idTypeAffiliationsFacebook = idTypeAffiliationsFacebook;
    }

    public Integer getIdTypeAffiliationsFacebook() {
        return idTypeAffiliationsFacebook;
    }

    public void setIdTypeAffiliationsFacebook(Integer idTypeAffiliationsFacebook) {
        this.idTypeAffiliationsFacebook = idTypeAffiliationsFacebook;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<AffiliationsFacebook> getAffiliationsFacebookCollection() {
        return affiliationsFacebookCollection;
    }

    public void setAffiliationsFacebookCollection(Collection<AffiliationsFacebook> affiliationsFacebookCollection) {
        this.affiliationsFacebookCollection = affiliationsFacebookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeAffiliationsFacebook != null ? idTypeAffiliationsFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeAffiliationsFacebook)) {
            return false;
        }
        TypeAffiliationsFacebook other = (TypeAffiliationsFacebook) object;
        if ((this.idTypeAffiliationsFacebook == null && other.idTypeAffiliationsFacebook != null) || (this.idTypeAffiliationsFacebook != null && !this.idTypeAffiliationsFacebook.equals(other.idTypeAffiliationsFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.TypeAffiliationsFacebook[idTypeAffiliationsFacebook=" + idTypeAffiliationsFacebook + "]";
    }

}
