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
@Table(name = "relationship_facebook")
@NamedQueries({
    @NamedQuery(name = "RelationshipFacebook.findAll", query = "SELECT r FROM RelationshipFacebook r"),
    @NamedQuery(name = "RelationshipFacebook.findByIdRelationshipFacebook", query = "SELECT r FROM RelationshipFacebook r WHERE r.idRelationshipFacebook = :idRelationshipFacebook"),
    @NamedQuery(name = "RelationshipFacebook.findByDescription", query = "SELECT r FROM RelationshipFacebook r WHERE r.description = :description")})
public class RelationshipFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_relationship_facebook")
    private Integer idRelationshipFacebook;
    @Column(name = "DESCRIPTION")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "relationshipFacebook")
    private Collection<FamilyFacebook> familyFacebookCollection;

    public RelationshipFacebook() {
    }

    public RelationshipFacebook(Integer idRelationshipFacebook) {
        this.idRelationshipFacebook = idRelationshipFacebook;
    }

    public Integer getIdRelationshipFacebook() {
        return idRelationshipFacebook;
    }

    public void setIdRelationshipFacebook(Integer idRelationshipFacebook) {
        this.idRelationshipFacebook = idRelationshipFacebook;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<FamilyFacebook> getFamilyFacebookCollection() {
        return familyFacebookCollection;
    }

    public void setFamilyFacebookCollection(Collection<FamilyFacebook> familyFacebookCollection) {
        this.familyFacebookCollection = familyFacebookCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelationshipFacebook != null ? idRelationshipFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelationshipFacebook)) {
            return false;
        }
        RelationshipFacebook other = (RelationshipFacebook) object;
        if ((this.idRelationshipFacebook == null && other.idRelationshipFacebook != null) || (this.idRelationshipFacebook != null && !this.idRelationshipFacebook.equals(other.idRelationshipFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.RelationshipFacebook[idRelationshipFacebook=" + idRelationshipFacebook + "]";
    }

}
