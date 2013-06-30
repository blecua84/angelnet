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
@Table(name = "work_history_facebook")
@NamedQueries({
    @NamedQuery(name = "WorkHistoryFacebook.findAll", query = "SELECT w FROM WorkHistoryFacebook w"),
    @NamedQuery(name = "WorkHistoryFacebook.findByIdWorkHistoryFacebook", query = "SELECT w FROM WorkHistoryFacebook w WHERE w.idWorkHistoryFacebook = :idWorkHistoryFacebook"),
    @NamedQuery(name = "WorkHistoryFacebook.findByLocation", query = "SELECT w FROM WorkHistoryFacebook w WHERE w.location = :location"),
    @NamedQuery(name = "WorkHistoryFacebook.findByCompanyName", query = "SELECT w FROM WorkHistoryFacebook w WHERE w.companyName = :companyName"),
    @NamedQuery(name = "WorkHistoryFacebook.findByDescription", query = "SELECT w FROM WorkHistoryFacebook w WHERE w.description = :description"),
    @NamedQuery(name = "WorkHistoryFacebook.findByPosition", query = "SELECT w FROM WorkHistoryFacebook w WHERE w.position = :position"),
    @NamedQuery(name = "WorkHistoryFacebook.findByStartDate", query = "SELECT w FROM WorkHistoryFacebook w WHERE w.startDate = :startDate"),
    @NamedQuery(name = "WorkHistoryFacebook.findByEndDate", query = "SELECT w FROM WorkHistoryFacebook w WHERE w.endDate = :endDate")})
public class WorkHistoryFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_work_history_facebook")
    private Integer idWorkHistoryFacebook;
    @Column(name = "LOCATION")
    private String location;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "POSITION")
    private String position;
    @Column(name = "START_DATE")
    private String startDate;
    @Column(name = "END_DATE")
    private String endDate;
    @JoinColumn(name = "user_facebook_id_user_facebook", referencedColumnName = "id_user_facebook")
    @ManyToOne(optional = false)
    private UserFacebook userFacebook;

    public WorkHistoryFacebook() {
    }

    public WorkHistoryFacebook(Integer idWorkHistoryFacebook) {
        this.idWorkHistoryFacebook = idWorkHistoryFacebook;
    }

    public Integer getIdWorkHistoryFacebook() {
        return idWorkHistoryFacebook;
    }

    public void setIdWorkHistoryFacebook(Integer idWorkHistoryFacebook) {
        this.idWorkHistoryFacebook = idWorkHistoryFacebook;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
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
        hash += (idWorkHistoryFacebook != null ? idWorkHistoryFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkHistoryFacebook)) {
            return false;
        }
        WorkHistoryFacebook other = (WorkHistoryFacebook) object;
        if ((this.idWorkHistoryFacebook == null && other.idWorkHistoryFacebook != null) || (this.idWorkHistoryFacebook != null && !this.idWorkHistoryFacebook.equals(other.idWorkHistoryFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.WorkHistoryFacebook[idWorkHistoryFacebook=" + idWorkHistoryFacebook + "]";
    }

}
