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
@Table(name = "Presence_openSocial")
@NamedQueries({
    @NamedQuery(name = "PresenceopenSocial.findAll", query = "SELECT p FROM PresenceopenSocial p"),
    @NamedQuery(name = "PresenceopenSocial.findByIdPresenceopenSocial", query = "SELECT p FROM PresenceopenSocial p WHERE p.idPresenceopenSocial = :idPresenceopenSocial"),
    @NamedQuery(name = "PresenceopenSocial.findByDescription", query = "SELECT p FROM PresenceopenSocial p WHERE p.description = :description")})
public class PresenceopenSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Presence_openSocial")
    private Integer idPresenceopenSocial;
    @Column(name = "DESCRIPTION")
    private String description;

    public PresenceopenSocial() {
    }

    public PresenceopenSocial(Integer idPresenceopenSocial) {
        this.idPresenceopenSocial = idPresenceopenSocial;
    }

    public Integer getIdPresenceopenSocial() {
        return idPresenceopenSocial;
    }

    public void setIdPresenceopenSocial(Integer idPresenceopenSocial) {
        this.idPresenceopenSocial = idPresenceopenSocial;
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
        hash += (idPresenceopenSocial != null ? idPresenceopenSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresenceopenSocial)) {
            return false;
        }
        PresenceopenSocial other = (PresenceopenSocial) object;
        if ((this.idPresenceopenSocial == null && other.idPresenceopenSocial != null) || (this.idPresenceopenSocial != null && !this.idPresenceopenSocial.equals(other.idPresenceopenSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.PresenceopenSocial[idPresenceopenSocial=" + idPresenceopenSocial + "]";
    }

}
