/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SampleLikesFacebook;
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
import es.uah.cc.ie.persistence.LikesFacebook;
import es.uah.cc.ie.converter.SampleLikesFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class SampleLikesFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of SampleLikesFacebookResource */
    public SampleLikesFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of SampleLikesFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of SampleLikesFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SampleLikesFacebookConverter get(@QueryParam("expandLevel")
                                            @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SampleLikesFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of SampleLikesFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an SampleLikesFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(SampleLikesFacebookConverter data) {
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
     * Delete method for deleting an instance of SampleLikesFacebook identified by id.
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
     * Returns an instance of SampleLikesFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of SampleLikesFacebook
     */
    protected SampleLikesFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (SampleLikesFacebook) em.createQuery("SELECT e FROM SampleLikesFacebook e where e.idSampleLikesFacebook = :idSampleLikesFacebook").setParameter("idSampleLikesFacebook", id).getSingleResult();
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
    private SampleLikesFacebook updateEntity(SampleLikesFacebook entity, SampleLikesFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        LikesFacebook likesFacebook = entity.getLikesFacebook();
        LikesFacebook likesFacebookNew = newEntity.getLikesFacebook();
        entity = em.merge(newEntity);
        if (likesFacebook != null && !likesFacebook.equals(likesFacebookNew)) {
            likesFacebook.getSampleLikesFacebookCollection().remove(entity);
        }
        if (likesFacebookNew != null && !likesFacebookNew.equals(likesFacebook)) {
            likesFacebookNew.getSampleLikesFacebookCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(SampleLikesFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        LikesFacebook likesFacebook = entity.getLikesFacebook();
        if (likesFacebook != null) {
            likesFacebook.getSampleLikesFacebookCollection().remove(entity);
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of LikesFacebookResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of LikesFacebookResource
     */
    @Path("likesFacebook/")
    public LikesFacebookResource getLikesFacebookResource() {
        LikesFacebookResourceSub likesFacebookResourceSub = resourceContext.getResource(LikesFacebookResourceSub.class);
        likesFacebookResourceSub.setParent(getEntity());
        return likesFacebookResourceSub;
    }

    public static class LikesFacebookResourceSub extends LikesFacebookResource {

        private SampleLikesFacebook parent;

        public void setParent(SampleLikesFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected LikesFacebook getEntity() {
            LikesFacebook entity = parent.getLikesFacebook();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }
}
