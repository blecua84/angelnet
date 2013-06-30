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
@Table(name = "education_history_facebook")
@NamedQueries({
    @NamedQuery(name = "EducationHistoryFacebook.findAll", query = "SELECT e FROM EducationHistoryFacebook e"),
    @NamedQuery(name = "EducationHistoryFacebook.findByIdEducationHistoryFacebook", query = "SELECT e FROM EducationHistoryFacebook e WHERE e.idEducationHistoryFacebook = :idEducationHistoryFacebook"),
    @NamedQuery(name = "EducationHistoryFacebook.findByYear", query = "SELECT e FROM EducationHistoryFacebook e WHERE e.year = :year"),
    @NamedQuery(name = "EducationHistoryFacebook.findByName", query = "SELECT e FROM EducationHistoryFacebook e WHERE e.name = :name"),
    @NamedQuery(name = "EducationHistoryFacebook.findByDegree", query = "SELECT e FROM EducationHistoryFacebook e WHERE e.degree = :degree"),
    @NamedQuery(name = "EducationHistoryFacebook.findByConcentrations0", query = "SELECT e FROM EducationHistoryFacebook e WHERE e.concentrations0 = :concentrations0"),
    @NamedQuery(name = "EducationHistoryFacebook.findByConcentrations1", query = "SELECT e FROM EducationHistoryFacebook e WHERE e.concentrations1 = :concentrations1"),
    @NamedQuery(name = "EducationHistoryFacebook.findByConcentrations2", query = "SELECT e FROM EducationHistoryFacebook e WHERE e.concentrations2 = :concentrations2")})
public class EducationHistoryFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_education_history_facebook")
    private Integer idEducationHistoryFacebook;
    @Column(name = "YEAR")
    private String year;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DEGREE")
    private String degree;
    @Column(name = "CONCENTRATIONS_0")
    private String concentrations0;
    @Column(name = "CONCENTRATIONS_1")
    private String concentrations1;
    @Column(name = "CONCENTRATIONS_2")
    private String concentrations2;
    @JoinColumn(name = "user_facebook_id_user_facebook", referencedColumnName = "id_user_facebook")
    @ManyToOne(optional = false)
    private UserFacebook userFacebook;

    public EducationHistoryFacebook() {
    }

    public EducationHistoryFacebook(Integer idEducationHistoryFacebook) {
        this.idEducationHistoryFacebook = idEducationHistoryFacebook;
    }

    public Integer getIdEducationHistoryFacebook() {
        return idEducationHistoryFacebook;
    }

    public void setIdEducationHistoryFacebook(Integer idEducationHistoryFacebook) {
        this.idEducationHistoryFacebook = idEducationHistoryFacebook;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getConcentrations0() {
        return concentrations0;
    }

    public void setConcentrations0(String concentrations0) {
        this.concentrations0 = concentrations0;
    }

    public String getConcentrations1() {
        return concentrations1;
    }

    public void setConcentrations1(String concentrations1) {
        this.concentrations1 = concentrations1;
    }

    public String getConcentrations2() {
        return concentrations2;
    }

    public void setConcentrations2(String concentrations2) {
        this.concentrations2 = concentrations2;
    }

    public UserFacebook getUserFacebook() {
        return userFacebook;
    }

    public void setUserFacebook(UserFacebook userFacebook) {
        this.userFacebook = userFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEducationHistoryFacebook != null ? idEducationHistoryFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducationHistoryFacebook)) {
            return false;
        }
        EducationHistoryFacebook other = (EducationHistoryFacebook) object;
        if ((this.idEducationHistoryFacebook == null && other.idEducationHistoryFacebook != null) || (this.idEducationHistoryFacebook != null && !this.idEducationHistoryFacebook.equals(other.idEducationHistoryFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.EducationHistoryFacebook[idEducationHistoryFacebook=" + idEducationHistoryFacebook + "]";
    }

}
