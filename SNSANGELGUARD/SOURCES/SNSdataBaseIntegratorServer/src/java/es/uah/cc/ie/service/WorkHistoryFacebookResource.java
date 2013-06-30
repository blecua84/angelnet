/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.WorkHistoryFacebook;
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
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.WorkHistoryFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class WorkHistoryFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of WorkHistoryFacebookResource */
    public WorkHistoryFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of WorkHistoryFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of WorkHistoryFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public WorkHistoryFacebookConverter get(@QueryParam("expandLevel")
                                            @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new WorkHistoryFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of WorkHistoryFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an WorkHistoryFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(WorkHistoryFacebookConverter data) {
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
     * Delete method for deleting an instance of WorkHistoryFacebook identified by id.
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
     * Returns an instance of WorkHistoryFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of WorkHistoryFacebook
     */
    protected WorkHistoryFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (WorkHistoryFacebook) em.createQuery("SELECT e FROM WorkHistoryFacebook e where e.idWorkHistoryFacebook = :idWorkHistoryFacebook").setParameter("idWorkHistoryFacebook", id).getSingleResult();
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
    private WorkHistoryFacebook updateEntity(WorkHistoryFacebook entity, WorkHistoryFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserFacebook userFacebook = entity.getUserFacebook();
        UserFacebook userFacebookNew = newEntity.getUserFacebook();
        entity = em.merge(newEntity);
        if (userFacebook != null && !userFacebook.equals(userFacebookNew)) {
            userFacebook.getWorkHistoryFacebookCollection().remove(entity);
        }
        if (userFacebookNew != null && !userFacebookNew.equals(userFacebook)) {
            userFacebookNew.getWorkHistoryFacebookCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(WorkHistoryFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            userFacebook.getWorkHistoryFacebookCollection().remove(entity);
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of UserFacebookResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of UserFacebookResource
     */
    @Path("userFacebook/")
    public UserFacebookResource getUserFacebookResource() {
        UserFacebookResourceSub userFacebookResourceSub = resourceContext.getResource(UserFacebookResourceSub.class);
        userFacebookResourceSub.setParent(getEntity());
        return userFacebookResourceSub;
    }

    public static class UserFacebookResourceSub extends UserFacebookResource {

        private WorkHistoryFacebook parent;

        public void setParent(WorkHistoryFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected UserFacebook getEntity() {
            UserFacebook entity = parent.getUserFacebook();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }
}
