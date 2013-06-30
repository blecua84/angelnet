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
@Table(name = "Drinker_openSocial")
@NamedQueries({
    @NamedQuery(name = "DrinkeropenSocial.findAll", query = "SELECT d FROM DrinkeropenSocial d"),
    @NamedQuery(name = "DrinkeropenSocial.findByIdDrinkeropenSocial", query = "SELECT d FROM DrinkeropenSocial d WHERE d.idDrinkeropenSocial = :idDrinkeropenSocial"),
    @NamedQuery(name = "DrinkeropenSocial.findByDescription", query = "SELECT d FROM DrinkeropenSocial d WHERE d.description = :description")})
public class DrinkeropenSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Drinker_openSocial")
    private Integer idDrinkeropenSocial;
    @Column(name = "DESCRIPTION")
    private String description;

    public DrinkeropenSocial() {
    }

    public DrinkeropenSocial(Integer idDrinkeropenSocial) {
        this.idDrinkeropenSocial = idDrinkeropenSocial;
    }

    public Integer getIdDrinkeropenSocial() {
        return idDrinkeropenSocial;
    }

    public void setIdDrinkeropenSocial(Integer idDrinkeropenSocial) {
        this.idDrinkeropenSocial = idDrinkeropenSocial;
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
        hash += (idDrinkeropenSocial != null ? idDrinkeropenSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DrinkeropenSocial)) {
            return false;
        }
        DrinkeropenSocial other = (DrinkeropenSocial) object;
        if ((this.idDrinkeropenSocial == null && other.idDrinkeropenSocial != null) || (this.idDrinkeropenSocial != null && !this.idDrinkeropenSocial.equals(other.idDrinkeropenSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.DrinkeropenSocial[idDrinkeropenSocial=" + idDrinkeropenSocial + "]";
    }

}
