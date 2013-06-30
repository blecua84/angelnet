/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.RelationshipFacebook;
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
import es.uah.cc.ie.persistence.FamilyFacebook;
import java.util.Collection;
import es.uah.cc.ie.converter.RelationshipFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class RelationshipFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of RelationshipFacebookResource */
    public RelationshipFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of RelationshipFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of RelationshipFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public RelationshipFacebookConverter get(@QueryParam("expandLevel")
                                             @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new RelationshipFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of RelationshipFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an RelationshipFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(RelationshipFacebookConverter data) {
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
     * Delete method for deleting an instance of RelationshipFacebook identified by id.
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
     * Returns an instance of RelationshipFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of RelationshipFacebook
     */
    protected RelationshipFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (RelationshipFacebook) em.createQuery("SELECT e FROM RelationshipFacebook e where e.idRelationshipFacebook = :idRelationshipFacebook").setParameter("idRelationshipFacebook", id).getSingleResult();
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
    private RelationshipFacebook updateEntity(RelationshipFacebook entity, RelationshipFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<FamilyFacebook> familyFacebookCollection = entity.getFamilyFacebookCollection();
        Collection<FamilyFacebook> familyFacebookCollectionNew = newEntity.getFamilyFacebookCollection();
        entity = em.merge(newEntity);
        for (FamilyFacebook value : familyFacebookCollection) {
            if (!familyFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from familyFacebookCollection"));
            }
        }
        for (FamilyFacebook value : familyFacebookCollectionNew) {
            if (!familyFacebookCollection.contains(value)) {
                RelationshipFacebook oldEntity = value.getRelationshipFacebook();
                value.setRelationshipFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getFamilyFacebookCollection().remove(value);
                }
            }
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(RelationshipFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        if (!entity.getFamilyFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because familyFacebookCollection is not empty."));
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of FamilyFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of FamilyFacebooksResource
     */
    @Path("familyFacebookCollection/")
    public FamilyFacebooksResource getFamilyFacebookCollectionResource() {
        FamilyFacebookCollectionResourceSub familyFacebookCollectionResourceSub = resourceContext.getResource(FamilyFacebookCollectionResourceSub.class);
        familyFacebookCollectionResourceSub.setParent(getEntity());
        return familyFacebookCollectionResourceSub;
    }

    public static class FamilyFacebookCollectionResourceSub extends FamilyFacebooksResource {

        private RelationshipFacebook parent;

        public void setParent(RelationshipFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<FamilyFacebook> getEntities(int start, int max, String query) {
            Collection<FamilyFacebook> result = new java.util.ArrayList<FamilyFacebook>();
            int index = 0;
            for (FamilyFacebook e : parent.getFamilyFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }
}
