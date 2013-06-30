/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.FriendsFacebook;
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
import java.util.Collection;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.FriendsFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class FriendsFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected String id;
  
    /** Creates a new instance of FriendsFacebookResource */
    public FriendsFacebookResource() {
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of FriendsFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of FriendsFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public FriendsFacebookConverter get(@QueryParam("expandLevel")
                                        @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new FriendsFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of FriendsFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an FriendsFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(FriendsFacebookConverter data) {
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
     * Delete method for deleting an instance of FriendsFacebook identified by id.
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
     * Returns an instance of FriendsFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of FriendsFacebook
     */
    protected FriendsFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (FriendsFacebook) em.createQuery("SELECT e FROM FriendsFacebook e where e.userUid = :userUid").setParameter("userUid", id).getSingleResult();
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
    private FriendsFacebook updateEntity(FriendsFacebook entity, FriendsFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<UserFacebook> userFacebookCollection = entity.getUserFacebookCollection();
        Collection<UserFacebook> userFacebookCollectionNew = newEntity.getUserFacebookCollection();
        entity = em.merge(newEntity);
        for (UserFacebook value : userFacebookCollection) {
            if (!userFacebookCollectionNew.contains(value)) {
                value.getFriendsFacebookCollection().remove(entity);
            }
        }
        for (UserFacebook value : userFacebookCollectionNew) {
            if (!userFacebookCollection.contains(value)) {
                value.getFriendsFacebookCollection().add(entity);
            }
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(FriendsFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        for (UserFacebook value : entity.getUserFacebookCollection()) {
            value.getFriendsFacebookCollection().remove(entity);
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

    public static class UserFacebookCollectionResourceSub extends UserFacebooksResource {

        private FriendsFacebook parent;

        public void setParent(FriendsFacebook parent) {
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
}
