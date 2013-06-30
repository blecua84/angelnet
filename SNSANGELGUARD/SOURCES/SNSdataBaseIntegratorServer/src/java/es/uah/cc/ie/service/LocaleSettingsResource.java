/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.LocaleSettings;
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
import java.util.Collection;
import es.uah.cc.ie.converter.LocaleSettingsConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class LocaleSettingsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected String id;
  
    /** Creates a new instance of LocaleSettingsResource */
    public LocaleSettingsResource() {
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of LocaleSettings identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of LocaleSettingsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public LocaleSettingsConverter get(@QueryParam("expandLevel")
                                       @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new LocaleSettingsConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of LocaleSettings identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an LocaleSettingsConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(LocaleSettingsConverter data) {
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
     * Delete method for deleting an instance of LocaleSettings identified by id.
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
     * Returns an instance of LocaleSettings identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of LocaleSettings
     */
    protected LocaleSettings getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (LocaleSettings) em.createQuery("SELECT e FROM LocaleSettings e where e.idLocale = :idLocale").setParameter("idLocale", id).getSingleResult();
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
    private LocaleSettings updateEntity(LocaleSettings entity, LocaleSettings newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<UserSettings> userSettingsCollection = entity.getUserSettingsCollection();
        Collection<UserSettings> userSettingsCollectionNew = newEntity.getUserSettingsCollection();
        entity = em.merge(newEntity);
        for (UserSettings value : userSettingsCollection) {
            if (!userSettingsCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from userSettingsCollection"));
            }
        }
        for (UserSettings value : userSettingsCollectionNew) {
            if (!userSettingsCollection.contains(value)) {
                LocaleSettings oldEntity = value.getLocaleSettings();
                value.setLocaleSettings(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getUserSettingsCollection().remove(value);
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
    private void deleteEntity(LocaleSettings entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        if (!entity.getUserSettingsCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because userSettingsCollection is not empty."));
        }
        em.remove(entity);
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

    public static class UserSettingsCollectionResourceSub extends UserSettingssResource {

        private LocaleSettings parent;

        public void setParent(LocaleSettings parent) {
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
}
