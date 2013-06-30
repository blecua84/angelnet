/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.FamilyFacebook;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.WebApplicationException;
import javax.persistence.NoResultException;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.RelationshipFacebook;
import java.util.Collection;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.FamilyFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class FamilyFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of FamilyFacebookResource */
    public FamilyFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of FamilyFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of FamilyFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public FamilyFacebookConverter get(@QueryParam("expandLevel")
                                       @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new FamilyFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of FamilyFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an FamilyFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(FamilyFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            updateEntity(getEntity(), data.resolveEntity(em));
            persistenceSvc.commitTx();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Delete method for deleting an instance of FamilyFacebook identified by id.
     *
     * @param id identifier for the entity
     */
    @DELETE
    public void delete() {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            deleteEntity(getEntity());
            persistenceSvc.commitTx();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns an instance of FamilyFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of FamilyFacebook
     */
    protected FamilyFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (FamilyFacebook) em.createQuery("SELECT e FROM FamilyFacebook e where e.idFamilyFacebook = :idFamilyFacebook").setParameter("idFamilyFacebook", id).getSingleResult();
        } catch (NoResultException ex) {
            throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
        }
    }

    /**
     * Updates entity using data from newEntity.
     *
     * @param entity the entity to update
     * @param newEntity the entity containing the new data
     * @return the updated entity
     */
    private FamilyFacebook updateEntity(FamilyFacebook entity, FamilyFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<UserFacebook> userFacebookCollection = entity.getUserFacebookCollection();
        Collection<UserFacebook> userFacebookCollectionNew = newEntity.getUserFacebookCollection();
        RelationshipFacebook relationshipFacebook = entity.getRelationshipFacebook();
        RelationshipFacebook relationshipFacebookNew = newEntity.getRelationshipFacebook();
        entity = em.merge(newEntity);
        for (UserFacebook value : userFacebookCollection) {
            if (!userFacebookCollectionNew.contains(value)) {
                value.getFamilyFacebookCollection().remove(entity);
            }
        }
        for (UserFacebook value : userFacebookCollectionNew) {
            if (!userFacebookCollection.contains(value)) {
                value.getFamilyFacebookCollection().add(entity);
            }
        }
        if (relationshipFacebook != null && !relationshipFacebook.equals(relationshipFacebookNew)) {
            relationshipFacebook.getFamilyFacebookCollection().remove(entity);
        }
        if (relationshipFacebookNew != null && !relationshipFacebookNew.equals(relationshipFacebook)) {
            relationshipFacebookNew.getFamilyFacebookCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(FamilyFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        for (UserFacebook value : entity.getUserFacebookCollection()) {
            value.getFamilyFacebookCollection().remove(entity);
        }
        RelationshipFacebook relationshipFacebook = entity.getRelationshipFacebook();
        if (relationshipFacebook != null) {
            relationshipFacebook.getFamilyFacebookCollection().remove(entity);
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of UserFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of UserFacebooksResource
     */
    @Path("userFacebookCollection/")
    public UserFacebooksResource getUserFacebookCollectionResource() {
        UserFacebookCollectionResourceSub userFacebookCollectionResourceSub = resourceContext.getResource(UserFacebookCollectionResourceSub.class);
        userFacebookCollectionResourceSub.setParent(getEntity());
        return userFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of RelationshipFacebookResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of RelationshipFacebookResource
     */
    @Path("relationshipFacebook/")
    public RelationshipFacebookResource getRelationshipFacebookResource() {
        RelationshipFacebookResourceSub relationshipFacebookResourceSub = resourceContext.getResource(RelationshipFacebookResourceSub.class);
        relationshipFacebookResourceSub.setParent(getEntity());
        return relationshipFacebookResourceSub;
    }

    public static class UserFacebookCollectionResourceSub extends UserFacebooksResource {

        private FamilyFacebook parent;

        public void setParent(FamilyFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<UserFacebook> getEntities(int start, int max, String query) {
            Collection<UserFacebook> result = new java.util.ArrayList<UserFacebook>();
            int index = 0;
            for (UserFacebook e : parent.getUserFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class RelationshipFacebookResourceSub extends RelationshipFacebookResource {

        private FamilyFacebook parent;

        public void setParent(FamilyFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected RelationshipFacebook getEntity() {
            RelationshipFacebook entity = parent.getRelationshipFacebook();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }
}
