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
@Table(name = "Gender_openSocial")
@NamedQueries({
    @NamedQuery(name = "GenderopenSocial.findAll", query = "SELECT g FROM GenderopenSocial g"),
    @NamedQuery(name = "GenderopenSocial.findByIdGenderopenSocial", query = "SELECT g FROM GenderopenSocial g WHERE g.idGenderopenSocial = :idGenderopenSocial"),
    @NamedQuery(name = "GenderopenSocial.findByDescription", query = "SELECT g FROM GenderopenSocial g WHERE g.description = :description")})
public class GenderopenSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Gender_openSocial")
    private Integer idGenderopenSocial;
    @Column(name = "DESCRIPTION")
    private String description;

    public GenderopenSocial() {
    }

    public GenderopenSocial(Integer idGenderopenSocial) {
        this.idGenderopenSocial = idGenderopenSocial;
    }

    public Integer getIdGenderopenSocial() {
        return idGenderopenSocial;
    }

    public void setIdGenderopenSocial(Integer idGenderopenSocial) {
        this.idGenderopenSocial = idGenderopenSocial;
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
        hash += (idGenderopenSocial != null ? idGenderopenSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenderopenSocial)) {
            return false;
        }
        GenderopenSocial other = (GenderopenSocial) object;
        if ((this.idGenderopenSocial == null && other.idGenderopenSocial != null) || (this.idGenderopenSocial != null && !this.idGenderopenSocial.equals(other.idGenderopenSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.GenderopenSocial[idGenderopenSocial=" + idGenderopenSocial + "]";
    }

}
