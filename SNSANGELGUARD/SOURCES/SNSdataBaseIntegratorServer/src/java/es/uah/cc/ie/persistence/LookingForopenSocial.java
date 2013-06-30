/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "LookingFor_openSocial")
@NamedQueries({
    @NamedQuery(name = "LookingForopenSocial.findAll", query = "SELECT l FROM LookingForopenSocial l"),
    @NamedQuery(name = "LookingForopenSocial.findByIdLookingForopenSocial", query = "SELECT l FROM LookingForopenSocial l WHERE l.idLookingForopenSocial = :idLookingForopenSocial"),
    @NamedQuery(name = "LookingForopenSocial.findByDescription", query = "SELECT l FROM LookingForopenSocial l WHERE l.description = :description")})
public class LookingForopenSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_LookingFor_openSocial")
    private Integer idLookingForopenSocial;
    @Column(name = "DESCRIPTION")
    private String description;

    public LookingForopenSocial() {
    }

    public LookingForopenSocial(Integer idLookingForopenSocial) {
        this.idLookingForopenSocial = idLookingForopenSocial;
    }

    public Integer getIdLookingForopenSocial() {
        return idLookingForopenSocial;
    }

    public void setIdLookingForopenSocial(Integer idLookingForopenSocial) {
        this.idLookingForopenSocial = idLookingForopenSocial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLookingForopenSocial != null ? idLookingForopenSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LookingForopenSocial)) {
            return false;
        }
        LookingForopenSocial other = (LookingForopenSocial) object;
        if ((this.idLookingForopenSocial == null && other.idLookingForopenSocial != null) || (this.idLookingForopenSocial != null && !this.idLookingForopenSocial.equals(other.idLookingForopenSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.LookingForopenSocial[idLookingForopenSocial=" + idLookingForopenSocial + "]";
    }

}
