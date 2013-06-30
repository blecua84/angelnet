/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SettingsfltWall;
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
import es.uah.cc.ie.persistence.SettingsAngels;
import es.uah.cc.ie.persistence.UserSettings;
import java.util.Collection;
import es.uah.cc.ie.converter.SettingsfltWallConverter;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;

/**
 *
 * @author tote
 */

public class SettingsfltWallResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected String id;
  
    /** Creates a new instance of SettingsfltWallResource */
    public SettingsfltWallResource() {
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of SettingsfltWall identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of SettingsfltWallConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SettingsfltWallConverter get(@QueryParam("expandLevel")
                                        @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SettingsfltWallConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of SettingsfltWall identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an SettingsfltWallConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(SettingsfltWallConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            SettingsfltWall entity = em.find(SettingsfltWall.class, id);
            //updateEntity(entity,data.getEntity());
            entity.setActivefltWall(data.getEntity().getActivefltWall());
            entity.setFrecfltWall(data.getEntity().getFrecfltWall());
            entity.setLastCheck(new Date());
            persistenceSvc.commitTx();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Delete method for deleting an instance of SettingsfltWall identified by id.
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
     * Returns an instance of SettingsfltWall identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of SettingsfltWall
     */
    protected SettingsfltWall getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (SettingsfltWall) em.createQuery("SELECT e FROM SettingsfltWall e where e.userSettingsUid = :userSettingsUid").setParameter("userSettingsUid", id).getSingleResult();
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
    private SettingsfltWall updateEntity(SettingsfltWall entity, SettingsfltWall newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<SettingsAngels> settingsAngelsCollection = entity.getSettingsAngelsCollection();
        Collection<SettingsAngels> settingsAngelsCollectionNew = newEntity.getSettingsAngelsCollection();
        UserSettings userSettings = entity.getUserSettings();
        UserSettings userSettingsNew = newEntity.getUserSettings();
        entity = em.merge(newEntity);
        for (SettingsAngels value : settingsAngelsCollection) {
            if (!settingsAngelsCollectionNew.contains(value)) {
                value.getSettingsfltWallCollection().remove(entity);
            }
        }
        for (SettingsAngels value : settingsAngelsCollectionNew) {
            if (!settingsAngelsCollection.contains(value)) {
                value.getSettingsfltWallCollection().add(entity);
            }
        }
        if (userSettings != null && !userSettings.equals(userSettingsNew)) {
            userSettings.setSettingsfltWall(null);
        }
        if (userSettingsNew != null && !userSettingsNew.equals(userSettings)) {
            userSettingsNew.setSettingsfltWall(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(SettingsfltWall entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        for (SettingsAngels value : entity.getSettingsAngelsCollection()) {
            value.getSettingsfltWallCollection().remove(entity);
        }
        UserSettings userSettings = entity.getUserSettings();
        if (userSettings != null) {
            userSettings.setSettingsfltWall(null);
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of SettingsAngelssResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of SettingsAngelssResource
     */
    @Path("settingsAngelsCollection/")
    public SettingsAngelssResource getSettingsAngelsCollectionResource() {
        SettingsAngelsCollectionResourceSub settingsAngelsCollectionResourceSub = resourceContext.getResource(SettingsAngelsCollectionResourceSub.class);
        settingsAngelsCollectionResourceSub.setParent(getEntity());
        return settingsAngelsCollectionResourceSub;
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

    public static class SettingsAngelsCollectionResourceSub extends SettingsAngelssResource {

        private SettingsfltWall parent;

        public void setParent(SettingsfltWall parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<SettingsAngels> getEntities(int start, int max, String query) {
            Collection<SettingsAngels> result = new java.util.ArrayList<SettingsAngels>();
            int index = 0;
            for (SettingsAngels e : parent.getSettingsAngelsCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class UserSettingsResourceSub extends UserSettingsResource {

        private SettingsfltWall parent;

        public void setParent(SettingsfltWall parent) {
            this.parent = parent;
        }

        @Override
        protected UserSettings getEntity() {
            UserSettings entity = parent.getUserSettings();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }
}
