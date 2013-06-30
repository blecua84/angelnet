/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.EducationHistoryFacebook;
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
import es.uah.cc.ie.converter.EducationHistoryFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class EducationHistoryFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of EducationHistoryFacebookResource */
    public EducationHistoryFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of EducationHistoryFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of EducationHistoryFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public EducationHistoryFacebookConverter get(@QueryParam("expandLevel")
                                                 @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new EducationHistoryFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of EducationHistoryFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an EducationHistoryFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(EducationHistoryFacebookConverter data) {
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
     * Delete method for deleting an instance of EducationHistoryFacebook identified by id.
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
     * Returns an instance of EducationHistoryFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of EducationHistoryFacebook
     */
    protected EducationHistoryFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (EducationHistoryFacebook) em.createQuery("SELECT e FROM EducationHistoryFacebook e where e.idEducationHistoryFacebook = :idEducationHistoryFacebook").setParameter("idEducationHistoryFacebook", id).getSingleResult();
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
    private EducationHistoryFacebook updateEntity(EducationHistoryFacebook entity, EducationHistoryFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserFacebook userFacebook = entity.getUserFacebook();
        UserFacebook userFacebookNew = newEntity.getUserFacebook();
        entity = em.merge(newEntity);
        if (userFacebook != null && !userFacebook.equals(userFacebookNew)) {
            userFacebook.getEducationHistoryFacebookCollection().remove(entity);
        }
        if (userFacebookNew != null && !userFacebookNew.equals(userFacebook)) {
            userFacebookNew.getEducationHistoryFacebookCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(EducationHistoryFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            userFacebook.getEducationHistoryFacebookCollection().remove(entity);
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

        private EducationHistoryFacebook parent;

        public void setParent(EducationHistoryFacebook parent) {
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
