/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.ActionLinksFacebook;
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
import es.uah.cc.ie.converter.ActionLinksFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class ActionLinksFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of ActionLinksFacebookResource */
    public ActionLinksFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of ActionLinksFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of ActionLinksFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public ActionLinksFacebookConverter get(@QueryParam("expandLevel")
                                            @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new ActionLinksFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of ActionLinksFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an ActionLinksFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(ActionLinksFacebookConverter data) {
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
     * Delete method for deleting an instance of ActionLinksFacebook identified by id.
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
     * Returns an instance of ActionLinksFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of ActionLinksFacebook
     */
    protected ActionLinksFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (ActionLinksFacebook) em.createQuery("SELECT e FROM ActionLinksFacebook e where e.idActionLinksFacebook = :idActionLinksFacebook").setParameter("idActionLinksFacebook", id).getSingleResult();
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
    private ActionLinksFacebook updateEntity(ActionLinksFacebook entity, ActionLinksFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        StreamFacebook streamFacebookNew = newEntity.getStreamFacebook();
        entity = em.merge(newEntity);
        if (streamFacebook != null && !streamFacebook.equals(streamFacebookNew)) {
            streamFacebook.getActionLinksFacebookCollection().remove(entity);
        }
        if (streamFacebookNew != null && !streamFacebookNew.equals(streamFacebook)) {
            streamFacebookNew.getActionLinksFacebookCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(ActionLinksFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            streamFacebook.getActionLinksFacebookCollection().remove(entity);
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

        private ActionLinksFacebook parent;

        public void setParent(ActionLinksFacebook parent) {
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
