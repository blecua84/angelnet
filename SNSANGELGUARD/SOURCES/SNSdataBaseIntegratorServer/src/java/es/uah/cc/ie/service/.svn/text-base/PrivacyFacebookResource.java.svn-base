/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.PrivacyFacebook;
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
import es.uah.cc.ie.persistence.StreamFacebook;
import es.uah.cc.ie.converter.PrivacyFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class PrivacyFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of PrivacyFacebookResource */
    public PrivacyFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of PrivacyFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of PrivacyFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public PrivacyFacebookConverter get(@QueryParam("expandLevel")
                                        @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new PrivacyFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of PrivacyFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an PrivacyFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(PrivacyFacebookConverter data) {
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
     * Delete method for deleting an instance of PrivacyFacebook identified by id.
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
     * Returns an instance of PrivacyFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of PrivacyFacebook
     */
    protected PrivacyFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (PrivacyFacebook) em.createQuery("SELECT e FROM PrivacyFacebook e where e.idPrivacyFacebook = :idPrivacyFacebook").setParameter("idPrivacyFacebook", id).getSingleResult();
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
    private PrivacyFacebook updateEntity(PrivacyFacebook entity, PrivacyFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        StreamFacebook streamFacebookNew = newEntity.getStreamFacebook();
        entity = em.merge(newEntity);
        if (streamFacebook != null && !streamFacebook.equals(streamFacebookNew)) {
            streamFacebook.getPrivacyFacebookCollection().remove(entity);
        }
        if (streamFacebookNew != null && !streamFacebookNew.equals(streamFacebook)) {
            streamFacebookNew.getPrivacyFacebookCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(PrivacyFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            streamFacebook.getPrivacyFacebookCollection().remove(entity);
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of StreamFacebookResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of StreamFacebookResource
     */
    @Path("streamFacebook/")
    public StreamFacebookResource getStreamFacebookResource() {
        StreamFacebookResourceSub streamFacebookResourceSub = resourceContext.getResource(StreamFacebookResourceSub.class);
        streamFacebookResourceSub.setParent(getEntity());
        return streamFacebookResourceSub;
    }

    public static class StreamFacebookResourceSub extends StreamFacebookResource {

        private PrivacyFacebook parent;

        public void setParent(PrivacyFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected StreamFacebook getEntity() {
            StreamFacebook entity = parent.getStreamFacebook();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }
}
