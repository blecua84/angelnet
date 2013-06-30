/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.LikesFacebook;
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
import es.uah.cc.ie.persistence.FriendsLikesFacebook;
import es.uah.cc.ie.persistence.SampleLikesFacebook;
import es.uah.cc.ie.persistence.StreamFacebook;
import java.util.Collection;
import es.uah.cc.ie.converter.LikesFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class LikesFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of LikesFacebookResource */
    public LikesFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of LikesFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of LikesFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public LikesFacebookConverter get(@QueryParam("expandLevel")
                                      @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new LikesFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of LikesFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an LikesFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(LikesFacebookConverter data) {
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
     * Delete method for deleting an instance of LikesFacebook identified by id.
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
     * Returns an instance of LikesFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of LikesFacebook
     */
    protected LikesFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (LikesFacebook) em.createQuery("SELECT e FROM LikesFacebook e where e.idLikesFacebook = :idLikesFacebook").setParameter("idLikesFacebook", id).getSingleResult();
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
    private LikesFacebook updateEntity(LikesFacebook entity, LikesFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<FriendsLikesFacebook> friendsLikesFacebookCollection = entity.getFriendsLikesFacebookCollection();
        Collection<FriendsLikesFacebook> friendsLikesFacebookCollectionNew = newEntity.getFriendsLikesFacebookCollection();
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        StreamFacebook streamFacebookNew = newEntity.getStreamFacebook();
        Collection<SampleLikesFacebook> sampleLikesFacebookCollection = entity.getSampleLikesFacebookCollection();
        Collection<SampleLikesFacebook> sampleLikesFacebookCollectionNew = newEntity.getSampleLikesFacebookCollection();
        entity = em.merge(newEntity);
        for (FriendsLikesFacebook value : friendsLikesFacebookCollection) {
            if (!friendsLikesFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from friendsLikesFacebookCollection"));
            }
        }
        for (FriendsLikesFacebook value : friendsLikesFacebookCollectionNew) {
            if (!friendsLikesFacebookCollection.contains(value)) {
                LikesFacebook oldEntity = value.getLikesFacebook();
                value.setLikesFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getFriendsLikesFacebookCollection().remove(value);
                }
            }
        }
        if (streamFacebook != null && !streamFacebook.equals(streamFacebookNew)) {
            streamFacebook.getLikesFacebookCollection().remove(entity);
        }
        if (streamFacebookNew != null && !streamFacebookNew.equals(streamFacebook)) {
            streamFacebookNew.getLikesFacebookCollection().add(entity);
        }
        for (SampleLikesFacebook value : sampleLikesFacebookCollection) {
            if (!sampleLikesFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from sampleLikesFacebookCollection"));
            }
        }
        for (SampleLikesFacebook value : sampleLikesFacebookCollectionNew) {
            if (!sampleLikesFacebookCollection.contains(value)) {
                LikesFacebook oldEntity = value.getLikesFacebook();
                value.setLikesFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getSampleLikesFacebookCollection().remove(value);
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
    private void deleteEntity(LikesFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        if (!entity.getFriendsLikesFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because friendsLikesFacebookCollection is not empty."));
        }
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            streamFacebook.getLikesFacebookCollection().remove(entity);
        }
        if (!entity.getSampleLikesFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because sampleLikesFacebookCollection is not empty."));
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of FriendsLikesFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of FriendsLikesFacebooksResource
     */
    @Path("friendsLikesFacebookCollection/")
    public FriendsLikesFacebooksResource getFriendsLikesFacebookCollectionResource() {
        FriendsLikesFacebookCollectionResourceSub friendsLikesFacebookCollectionResourceSub = resourceContext.getResource(FriendsLikesFacebookCollectionResourceSub.class);
        friendsLikesFacebookCollectionResourceSub.setParent(getEntity());
        return friendsLikesFacebookCollectionResourceSub;
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

    /**
     * Returns a dynamic instance of SampleLikesFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of SampleLikesFacebooksResource
     */
    @Path("sampleLikesFacebookCollection/")
    public SampleLikesFacebooksResource getSampleLikesFacebookCollectionResource() {
        SampleLikesFacebookCollectionResourceSub sampleLikesFacebookCollectionResourceSub = resourceContext.getResource(SampleLikesFacebookCollectionResourceSub.class);
        sampleLikesFacebookCollectionResourceSub.setParent(getEntity());
        return sampleLikesFacebookCollectionResourceSub;
    }

    public static class FriendsLikesFacebookCollectionResourceSub extends FriendsLikesFacebooksResource {

        private LikesFacebook parent;

        public void setParent(LikesFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<FriendsLikesFacebook> getEntities(int start, int max, String query) {
            Collection<FriendsLikesFacebook> result = new java.util.ArrayList<FriendsLikesFacebook>();
            int index = 0;
            for (FriendsLikesFacebook e : parent.getFriendsLikesFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class StreamFacebookResourceSub extends StreamFacebookResource {

        private LikesFacebook parent;

        public void setParent(LikesFacebook parent) {
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

    public static class SampleLikesFacebookCollectionResourceSub extends SampleLikesFacebooksResource {

        private LikesFacebook parent;

        public void setParent(LikesFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<SampleLikesFacebook> getEntities(int start, int max, String query) {
            Collection<SampleLikesFacebook> result = new java.util.ArrayList<SampleLikesFacebook>();
            int index = 0;
            for (SampleLikesFacebook e : parent.getSampleLikesFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }
}
