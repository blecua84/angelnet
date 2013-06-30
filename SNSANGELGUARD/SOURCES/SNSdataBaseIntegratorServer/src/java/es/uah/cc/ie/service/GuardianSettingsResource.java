/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.GuardianSettings;
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
import es.uah.cc.ie.converter.GuardianSettingsConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class GuardianSettingsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of GuardianSettingsResource */
    public GuardianSettingsResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of GuardianSettings identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of GuardianSettingsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public GuardianSettingsConverter get(@QueryParam("expandLevel")
                                         @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new GuardianSettingsConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of GuardianSettings identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an GuardianSettingsConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(GuardianSettingsConverter data) {
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
     * Delete method for deleting an instance of GuardianSettings identified by id.
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
     * Returns an instance of GuardianSettings identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of GuardianSettings
     */
    protected GuardianSettings getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (GuardianSettings) em.createQuery("SELECT e FROM GuardianSettings e where e.uidGuardian = :uidGuardian").setParameter("uidGuardian", id).getSingleResult();
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
    private GuardianSettings updateEntity(GuardianSettings entity, GuardianSettings newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        entity = em.merge(newEntity);
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(GuardianSettings entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.remove(entity);
    }
}