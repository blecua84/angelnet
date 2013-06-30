/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "family_facebook")
@NamedQueries({
    @NamedQuery(name = "FamilyFacebook.findAll", query = "SELECT f FROM FamilyFacebook f"),
    @NamedQuery(name = "FamilyFacebook.findByIdFamilyFacebook", query = "SELECT f FROM FamilyFacebook f WHERE f.idFamilyFacebook = :idFamilyFacebook"),
    @NamedQuery(name = "FamilyFacebook.findByUid", query = "SELECT f FROM FamilyFacebook f WHERE f.uid = :uid"),
    @NamedQuery(name = "FamilyFacebook.findByName", query = "SELECT f FROM FamilyFacebook f WHERE f.name = :name"),
    @NamedQuery(name = "FamilyFacebook.findByBirthday", query = "SELECT f FROM FamilyFacebook f WHERE f.birthday = :birthday")})
public class FamilyFacebook implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_family_facebook")
    private Integer idFamilyFacebook;
    @Column(name = "UID")
    private String uid;
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTHDAY")
    private String birthday;
    @JoinTable(name = "user_facebook_has_family_facebook", joinColumns = {
        @JoinColumn(name = "family_facebook_id_family_facebook", referencedColumnName = "id_family_facebook")}, inverseJoinColumns = {
        @JoinColumn(name = "user_facebook_id_user_facebook", referencedColumnName = "id_user_facebook")})
    @ManyToMany
    private Collection<UserFacebook> userFacebookCollection;
    @JoinColumn(name = "relationship_facebook_id_relationship_facebook", referencedColumnName = "id_relationship_facebook")
    @ManyToOne(optional = false)
    private RelationshipFacebook relationshipFacebook;

    public FamilyFacebook() {
    }

    public FamilyFacebook(Integer idFamilyFacebook) {
        this.idFamilyFacebook = idFamilyFacebook;
    }

    public Integer getIdFamilyFacebook() {
        return idFamilyFacebook;
    }

    public void setIdFamilyFacebook(Integer idFamilyFacebook) {
        this.idFamilyFacebook = idFamilyFacebook;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Collection<UserFacebook> getUserFacebookCollection() {
        return userFacebookCollection;
    }

    public void setUserFacebookCollection(Collection<UserFacebook> userFacebookCollection) {
        this.userFacebookCollection = userFacebookCollection;
    }

    public RelationshipFacebook getRelationshipFacebook() {
        return relationshipFacebook;
    }

    public void setRelationshipFacebook(RelationshipFacebook relationshipFacebook) {
        this.relationshipFacebook = relationshipFacebook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFamilyFacebook != null ? idFamilyFacebook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamilyFacebook)) {
            return false;
        }
        FamilyFacebook other = (FamilyFacebook) object;
        if ((this.idFamilyFacebook == null && other.idFamilyFacebook != null) || (this.idFamilyFacebook != null && !this.idFamilyFacebook.equals(other.idFamilyFacebook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.FamilyFacebook[idFamilyFacebook=" + idFamilyFacebook + "]";
    }

}
