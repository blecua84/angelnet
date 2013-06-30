/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.User;
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
import es.uah.cc.ie.persistence.UseropenSocial;
import es.uah.cc.ie.persistence.UserSettings;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.UserConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class UserResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected String id;
  
    /** Creates a new instance of UserResource */
    public UserResource() {
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of User identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of UserConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public UserConverter get(@QueryParam("expandLevel")
                             @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new UserConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of User identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an UserConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(UserConverter data) {
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
     * Delete method for deleting an instance of User identified by id.
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
     * Returns an instance of User identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of User
     */
    protected User getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (User) em.createQuery("SELECT e FROM User e where e.userSettingsUid = :userSettingsUid").setParameter("userSettingsUid", id).getSingleResult();
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
    private User updateEntity(User entity, User newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserSettings userSettings = entity.getUserSettings();
        UserSettings userSettingsNew = newEntity.getUserSettings();
        UseropenSocial useropenSocial = entity.getUseropenSocial();
        UseropenSocial useropenSocialNew = newEntity.getUseropenSocial();
        UserFacebook userFacebook = entity.getUserFacebook();
        UserFacebook userFacebookNew = newEntity.getUserFacebook();
        entity = em.merge(newEntity);
        if (userSettings != null && !userSettings.equals(userSettingsNew)) {
            userSettings.setUser(null);
        }
        if (userSettingsNew != null && !userSettingsNew.equals(userSettings)) {
            userSettingsNew.setUser(entity);
        }
        if (useropenSocial != null && !useropenSocial.equals(useropenSocialNew)) {
            useropenSocial.getUserCollection().remove(entity);
        }
        if (useropenSocialNew != null && !useropenSocialNew.equals(useropenSocial)) {
            useropenSocialNew.getUserCollection().add(entity);
        }
        if (userFacebook != null && !userFacebook.equals(userFacebookNew)) {
            userFacebook.getUserCollection().remove(entity);
        }
        if (userFacebookNew != null && !userFacebookNew.equals(userFacebook)) {
            userFacebookNew.getUserCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(User entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserSettings userSettings = entity.getUserSettings();
        if (userSettings != null) {
            userSettings.setUser(null);
        }
        UseropenSocial useropenSocial = entity.getUseropenSocial();
        if (useropenSocial != null) {
            useropenSocial.getUserCollection().remove(entity);
        }
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            userFacebook.getUserCollection().remove(entity);
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of UserSettingsResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of UserSettingsResource
     */
    @Path("userSettings/")
    public UserSettingsResource getUserSettingsResource() {
        UserSettingsResourceSub userSettingsResourceSub = resourceContext.getResource(UserSettingsResourceSub.class);
        userSettingsResourceSub.setParent(getEntity());
        return userSettingsResourceSub;
    }

    /**
     * Returns a dynamic instance of UseropenSocialResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of UseropenSocialResource
     */
    @Path("useropenSocial/")
    public UseropenSocialResource getUseropenSocialResource() {
        UseropenSocialResourceSub useropenSocialResourceSub = resourceContext.getResource(UseropenSocialResourceSub.class);
        useropenSocialResourceSub.setParent(getEntity());
        return useropenSocialResourceSub;
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

    public static class UserSettingsResourceSub extends UserSettingsResource {

        private User parent;

        public void setParent(User parent) {
            this.parent = parent;
        }

        protected UserSettings getEntity() {
            UserSettings entity = parent.getUserSettings();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }

    public static class UseropenSocialResourceSub extends UseropenSocialResource {

        private User parent;

        public void setParent(User parent) {
            this.parent = parent;
        }

        @Override
        protected UseropenSocial getEntity() {
            UseropenSocial entity = parent.getUseropenSocial();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }

    public static class UserFacebookResourceSub extends UserFacebookResource {

        private User parent;

        public void setParent(User parent) {
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
