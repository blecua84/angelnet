/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SettingsAngels;
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
import es.uah.cc.ie.persistence.UserSettings;
import es.uah.cc.ie.persistence.SettingsfltWall;
import es.uah.cc.ie.persistence.SettingsfltPriv;
import es.uah.cc.ie.persistence.SettingsfltFriends;
import java.util.Collection;
import es.uah.cc.ie.persistence.SettingsfltVist;
import es.uah.cc.ie.converter.SettingsAngelsConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class SettingsAngelsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of SettingsAngelsResource */
    public SettingsAngelsResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of SettingsAngels identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of SettingsAngelsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SettingsAngelsConverter get(@QueryParam("expandLevel")
                                       @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SettingsAngelsConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of SettingsAngels identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an SettingsAngelsConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(SettingsAngelsConverter data) {
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
     * Delete method for deleting an instance of SettingsAngels identified by id.
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
     * Returns an instance of SettingsAngels identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of SettingsAngels
     */
    protected SettingsAngels getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (SettingsAngels) em.createQuery("SELECT e FROM SettingsAngels e where e.uidAngel = :uidAngel").setParameter("uidAngel", id).getSingleResult();
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
    private SettingsAngels updateEntity(SettingsAngels entity, SettingsAngels newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<SettingsfltVist> settingsfltVistCollection = entity.getSettingsfltVistCollection();
        Collection<SettingsfltVist> settingsfltVistCollectionNew = newEntity.getSettingsfltVistCollection();
        Collection<SettingsfltWall> settingsfltWallCollection = entity.getSettingsfltWallCollection();
        Collection<SettingsfltWall> settingsfltWallCollectionNew = newEntity.getSettingsfltWallCollection();
        Collection<SettingsfltPriv> settingsfltPrivCollection = entity.getSettingsfltPrivCollection();
        Collection<SettingsfltPriv> settingsfltPrivCollectionNew = newEntity.getSettingsfltPrivCollection();
        Collection<UserSettings> userSettingsCollection = entity.getUserSettingsCollection();
        Collection<UserSettings> userSettingsCollectionNew = newEntity.getUserSettingsCollection();
        Collection<SettingsfltFriends> settingsfltFriendsCollection = entity.getSettingsfltFriendsCollection();
        Collection<SettingsfltFriends> settingsfltFriendsCollectionNew = newEntity.getSettingsfltFriendsCollection();
        entity = em.merge(newEntity);
        for (SettingsfltVist value : settingsfltVistCollection) {
            if (!settingsfltVistCollectionNew.contains(value)) {
                value.getSettingsAngelsCollection().remove(entity);
            }
        }
        for (SettingsfltVist value : settingsfltVistCollectionNew) {
            if (!settingsfltVistCollection.contains(value)) {
                value.getSettingsAngelsCollection().add(entity);
            }
        }
        for (SettingsfltWall value : settingsfltWallCollection) {
            if (!settingsfltWallCollectionNew.contains(value)) {
                value.getSettingsAngelsCollection().remove(entity);
            }
        }
        for (SettingsfltWall value : settingsfltWallCollectionNew) {
            if (!settingsfltWallCollection.contains(value)) {
                value.getSettingsAngelsCollection().add(entity);
            }
        }
        for (SettingsfltPriv value : settingsfltPrivCollection) {
            if (!settingsfltPrivCollectionNew.contains(value)) {
                value.getSettingsAngelsCollection().remove(entity);
            }
        }
        for (SettingsfltPriv value : settingsfltPrivCollectionNew) {
            if (!settingsfltPrivCollection.contains(value)) {
                value.getSettingsAngelsCollection().add(entity);
            }
        }
        for (UserSettings value : userSettingsCollection) {
            if (!userSettingsCollectionNew.contains(value)) {
                value.getSettingsAngelsCollection().remove(entity);
            }
        }
        for (UserSettings value : userSettingsCollectionNew) {
            if (!userSettingsCollection.contains(value)) {
                value.getSettingsAngelsCollection().add(entity);
            }
        }
        for (SettingsfltFriends value : settingsfltFriendsCollection) {
            if (!settingsfltFriendsCollectionNew.contains(value)) {
                value.getSettingsAngelsCollection().remove(entity);
            }
        }
        for (SettingsfltFriends value : settingsfltFriendsCollectionNew) {
            if (!settingsfltFriendsCollection.contains(value)) {
                value.getSettingsAngelsCollection().add(entity);
            }
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(SettingsAngels entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        for (SettingsfltVist value : entity.getSettingsfltVistCollection()) {
            value.getSettingsAngelsCollection().remove(entity);
        }
        for (SettingsfltWall value : entity.getSettingsfltWallCollection()) {
            value.getSettingsAngelsCollection().remove(entity);
        }
        for (SettingsfltPriv value : entity.getSettingsfltPrivCollection()) {
            value.getSettingsAngelsCollection().remove(entity);
        }
        for (UserSettings value : entity.getUserSettingsCollection()) {
            value.getSettingsAngelsCollection().remove(entity);
        }
        for (SettingsfltFriends value : entity.getSettingsfltFriendsCollection()) {
            value.getSettingsAngelsCollection().remove(entity);
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of SettingsfltVistsResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of SettingsfltVistsResource
     */
    @Path("settingsfltVistCollection/")
    public SettingsfltVistsResource getSettingsfltVistCollectionResource() {
        SettingsfltVistCollectionResourceSub settingsfltVistCollectionResourceSub = resourceContext.getResource(SettingsfltVistCollectionResourceSub.class);
        settingsfltVistCollectionResourceSub.setParent(getEntity());
        return settingsfltVistCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of SettingsfltWallsResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of SettingsfltWallsResource
     */
    @Path("settingsfltWallCollection/")
    public SettingsfltWallsResource getSettingsfltWallCollectionResource() {
        SettingsfltWallCollectionResourceSub settingsfltWallCollectionResourceSub = resourceContext.getResource(SettingsfltWallCollectionResourceSub.class);
        settingsfltWallCollectionResourceSub.setParent(getEntity());
        return settingsfltWallCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of SettingsfltPrivsResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of SettingsfltPrivsResource
     */
    @Path("settingsfltPrivCollection/")
    public SettingsfltPrivsResource getSettingsfltPrivCollectionResource() {
        SettingsfltPrivCollectionResourceSub settingsfltPrivCollectionResourceSub = resourceContext.getResource(SettingsfltPrivCollectionResourceSub.class);
        settingsfltPrivCollectionResourceSub.setParent(getEntity());
        return settingsfltPrivCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of UserSettingssResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of UserSettingssResource
     */
    @Path("userSettingsCollection/")
    public UserSettingssResource getUserSettingsCollectionResource() {
        UserSettingsCollectionResourceSub userSettingsCollectionResourceSub = resourceContext.getResource(UserSettingsCollectionResourceSub.class);
        userSettingsCollectionResourceSub.setParent(getEntity());
        return userSettingsCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of SettingsfltFriendssResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of SettingsfltFriendssResource
     */
    @Path("settingsfltFriendsCollection/")
    public SettingsfltFriendssResource getSettingsfltFriendsCollectionResource() {
        SettingsfltFriendsCollectionResourceSub settingsfltFriendsCollectionResourceSub = resourceContext.getResource(SettingsfltFriendsCollectionResourceSub.class);
        settingsfltFriendsCollectionResourceSub.setParent(getEntity());
        return settingsfltFriendsCollectionResourceSub;
    }

    public static class SettingsfltVistCollectionResourceSub extends SettingsfltVistsResource {

        private SettingsAngels parent;

        public void setParent(SettingsAngels parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<SettingsfltVist> getEntities(int start, int max, String query) {
            Collection<SettingsfltVist> result = new java.util.ArrayList<SettingsfltVist>();
            int index = 0;
            for (SettingsfltVist e : parent.getSettingsfltVistCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class SettingsfltWallCollectionResourceSub extends SettingsfltWallsResource {

        private SettingsAngels parent;

        public void setParent(SettingsAngels parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<SettingsfltWall> getEntities(int start, int max, String query) {
            Collection<SettingsfltWall> result = new java.util.ArrayList<SettingsfltWall>();
            int index = 0;
            for (SettingsfltWall e : parent.getSettingsfltWallCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class SettingsfltPrivCollectionResourceSub extends SettingsfltPrivsResource {

        private SettingsAngels parent;

        public void setParent(SettingsAngels parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<SettingsfltPriv> getEntities(int start, int max, String query) {
            Collection<SettingsfltPriv> result = new java.util.ArrayList<SettingsfltPriv>();
            int index = 0;
            for (SettingsfltPriv e : parent.getSettingsfltPrivCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class UserSettingsCollectionResourceSub extends UserSettingssResource {

        private SettingsAngels parent;

        public void setParent(SettingsAngels parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<UserSettings> getEntities(int start, int max, String query) {
            Collection<UserSettings> result = new java.util.ArrayList<UserSettings>();
            int index = 0;
            for (UserSettings e : parent.getUserSettingsCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class SettingsfltFriendsCollectionResourceSub extends SettingsfltFriendssResource {

        private SettingsAngels parent;

        public void setParent(SettingsAngels parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<SettingsfltFriends> getEntities(int start, int max, String query) {
            Collection<SettingsfltFriends> result = new java.util.ArrayList<SettingsfltFriends>();
            int index = 0;
            for (SettingsfltFriends e : parent.getSettingsfltFriendsCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }
}
