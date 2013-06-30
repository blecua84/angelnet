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
@Table(name = "Smoker_openSocial")
@NamedQueries({
    @NamedQuery(name = "SmokeropenSocial.findAll", query = "SELECT s FROM SmokeropenSocial s"),
    @NamedQuery(name = "SmokeropenSocial.findByIdSmokeropenSocial", query = "SELECT s FROM SmokeropenSocial s WHERE s.idSmokeropenSocial = :idSmokeropenSocial"),
    @NamedQuery(name = "SmokeropenSocial.findByDescription", query = "SELECT s FROM SmokeropenSocial s WHERE s.description = :description")})
public class SmokeropenSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Smoker_openSocial")
    private Integer idSmokeropenSocial;
    @Column(name = "DESCRIPTION")
    private String description;

    public SmokeropenSocial() {
    }

    public SmokeropenSocial(Integer idSmokeropenSocial) {
        this.idSmokeropenSocial = idSmokeropenSocial;
    }

    public Integer getIdSmokeropenSocial() {
        return idSmokeropenSocial;
    }

    public void setIdSmokeropenSocial(Integer idSmokeropenSocial) {
        this.idSmokeropenSocial = idSmokeropenSocial;
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
        hash += (idSmokeropenSocial != null ? idSmokeropenSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmokeropenSocial)) {
            return false;
        }
        SmokeropenSocial other = (SmokeropenSocial) object;
        if ((this.idSmokeropenSocial == null && other.idSmokeropenSocial != null) || (this.idSmokeropenSocial != null && !this.idSmokeropenSocial.equals(other.idSmokeropenSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.SmokeropenSocial[idSmokeropenSocial=" + idSmokeropenSocial + "]";
    }

}
