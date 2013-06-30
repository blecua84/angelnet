/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.UseropenSocial;
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
import es.uah.cc.ie.persistence.User;
import java.util.Collection;
import es.uah.cc.ie.converter.UseropenSocialConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class UseropenSocialResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of UseropenSocialResource */
    public UseropenSocialResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of UseropenSocial identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of UseropenSocialConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public UseropenSocialConverter get(@QueryParam("expandLevel")
                                       @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new UseropenSocialConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of UseropenSocial identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an UseropenSocialConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(UseropenSocialConverter data) {
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
     * Delete method for deleting an instance of UseropenSocial identified by id.
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
     * Returns an instance of UseropenSocial identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of UseropenSocial
     */
    protected UseropenSocial getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (UseropenSocial) em.createQuery("SELECT e FROM UseropenSocial e where e.iduseropenSocial = :iduseropenSocial").setParameter("iduseropenSocial", id).getSingleResult();
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
    private UseropenSocial updateEntity(UseropenSocial entity, UseropenSocial newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<User> userCollection = entity.getUserCollection();
        Collection<User> userCollectionNew = newEntity.getUserCollection();
        entity = em.merge(newEntity);
        for (User value : userCollection) {
            if (!userCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from userCollection"));
            }
        }
        for (User value : userCollectionNew) {
            if (!userCollection.contains(value)) {
                UseropenSocial oldEntity = value.getUseropenSocial();
                value.setUseropenSocial(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getUserCollection().remove(value);
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
    private void deleteEntity(UseropenSocial entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        if (!entity.getUserCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because userCollection is not empty."));
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of UsersResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of UsersResource
     */
    @Path("userCollection/")
    public UsersResource getUserCollectionResource() {
        UserCollectionResourceSub userCollectionResourceSub = resourceContext.getResource(UserCollectionResourceSub.class);
        userCollectionResourceSub.setParent(getEntity());
        return userCollectionResourceSub;
    }

    public static class UserCollectionResourceSub extends UsersResource {

        private UseropenSocial parent;

        public void setParent(UseropenSocial parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<User> getEntities(int start, int max, String query) {
            Collection<User> result = new java.util.ArrayList<User>();
            int index = 0;
            for (User e : parent.getUserCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }
}
