/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.FriendsLikesFacebook;
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
import es.uah.cc.ie.converter.FriendsLikesFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class FriendsLikesFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of FriendsLikesFacebookResource */
    public FriendsLikesFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of FriendsLikesFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of FriendsLikesFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public FriendsLikesFacebookConverter get(@QueryParam("expandLevel")
                                             @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new FriendsLikesFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of FriendsLikesFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an FriendsLikesFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(FriendsLikesFacebookConverter data) {
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
     * Delete method for deleting an instance of FriendsLikesFacebook identified by id.
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
     * Returns an instance of FriendsLikesFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of FriendsLikesFacebook
     */
    protected FriendsLikesFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (FriendsLikesFacebook) em.createQuery("SELECT e FROM FriendsLikesFacebook e where e.idFriendsLikesFacebook = :idFriendsLikesFacebook").setParameter("idFriendsLikesFacebook", id).getSingleResult();
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
    private FriendsLikesFacebook updateEntity(FriendsLikesFacebook entity, FriendsLikesFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        LikesFacebook likesFacebook = entity.getLikesFacebook();
        LikesFacebook likesFacebookNew = newEntity.getLikesFacebook();
        entity = em.merge(newEntity);
        if (likesFacebook != null && !likesFacebook.equals(likesFacebookNew)) {
            likesFacebook.getFriendsLikesFacebookCollection().remove(entity);
        }
        if (likesFacebookNew != null && !likesFacebookNew.equals(likesFacebook)) {
            likesFacebookNew.getFriendsLikesFacebookCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(FriendsLikesFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        LikesFacebook likesFacebook = entity.getLikesFacebook();
        if (likesFacebook != null) {
            likesFacebook.getFriendsLikesFacebookCollection().remove(entity);
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

        private FriendsLikesFacebook parent;

        public void setParent(FriendsLikesFacebook parent) {
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
