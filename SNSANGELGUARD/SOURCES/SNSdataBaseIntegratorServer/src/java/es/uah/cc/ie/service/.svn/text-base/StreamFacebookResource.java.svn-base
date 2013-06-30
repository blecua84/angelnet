/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.StreamFacebook;
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
import es.uah.cc.ie.persistence.LikesFacebook;
import es.uah.cc.ie.persistence.ActionLinksFacebook;
import es.uah.cc.ie.persistence.CommentsFacebook;
import es.uah.cc.ie.persistence.PrivacyFacebook;
import java.util.Collection;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.StreamFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;

/**
 *
 * @author tote
 */

public class StreamFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected String id;
  
    /** Creates a new instance of StreamFacebookResource */
    public StreamFacebookResource() {
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of StreamFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of StreamFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public StreamFacebookConverter get(@QueryParam("expandLevel")
                                       @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new StreamFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of StreamFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an StreamFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(StreamFacebookConverter data,
                    @QueryParam("updatedTime") String updatedTime,
                    @QueryParam("createdTime") String createdTime) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        Date auxU = new Date();
        Date auxC = new Date();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            StreamFacebook entity = data.resolveEntity(em);
            auxU.setTime(Long.parseLong(updatedTime)*1000);
            entity.setUpdatedTime(auxU);
            auxC.setTime(Long.parseLong(createdTime)*1000);
            entity.setCreatedTime(auxC);
            updateEntity(getEntity(), data.resolveEntity(em));
            persistenceSvc.commitTx();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Delete method for deleting an instance of StreamFacebook identified by id.
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
     * Returns an instance of StreamFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of StreamFacebook
     */
    protected StreamFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (StreamFacebook) em.createQuery("SELECT e FROM StreamFacebook e where e.postId = :postId").setParameter("postId", id).getSingleResult();
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
    private StreamFacebook updateEntity(StreamFacebook entity, StreamFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<UserFacebook> userFacebookCollection = entity.getUserFacebookCollection();
        Collection<UserFacebook> userFacebookCollectionNew = newEntity.getUserFacebookCollection();
        Collection<CommentsFacebook> commentsFacebookCollection = entity.getCommentsFacebookCollection();
        Collection<CommentsFacebook> commentsFacebookCollectionNew = newEntity.getCommentsFacebookCollection();
        Collection<LikesFacebook> likesFacebookCollection = entity.getLikesFacebookCollection();
        Collection<LikesFacebook> likesFacebookCollectionNew = newEntity.getLikesFacebookCollection();
        Collection<ActionLinksFacebook> actionLinksFacebookCollection = entity.getActionLinksFacebookCollection();
        Collection<ActionLinksFacebook> actionLinksFacebookCollectionNew = newEntity.getActionLinksFacebookCollection();
        Collection<PrivacyFacebook> privacyFacebookCollection = entity.getPrivacyFacebookCollection();
        Collection<PrivacyFacebook> privacyFacebookCollectionNew = newEntity.getPrivacyFacebookCollection();
        entity = em.merge(newEntity);
        for (UserFacebook value : userFacebookCollection) {
            if (!userFacebookCollectionNew.contains(value)) {
                value.getStreamFacebookCollection().remove(entity);
            }
        }
        for (UserFacebook value : userFacebookCollectionNew) {
            if (!userFacebookCollection.contains(value)) {
                value.getStreamFacebookCollection().add(entity);
            }
        }
        for (CommentsFacebook value : commentsFacebookCollection) {
            if (!commentsFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from commentsFacebookCollection"));
            }
        }
        for (CommentsFacebook value : commentsFacebookCollectionNew) {
            if (!commentsFacebookCollection.contains(value)) {
                StreamFacebook oldEntity = value.getStreamFacebook();
                value.setStreamFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getCommentsFacebookCollection().remove(value);
                }
            }
        }
        for (LikesFacebook value : likesFacebookCollection) {
            if (!likesFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from likesFacebookCollection"));
            }
        }
        for (LikesFacebook value : likesFacebookCollectionNew) {
            if (!likesFacebookCollection.contains(value)) {
                StreamFacebook oldEntity = value.getStreamFacebook();
                value.setStreamFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getLikesFacebookCollection().remove(value);
                }
            }
        }
        for (ActionLinksFacebook value : actionLinksFacebookCollection) {
            if (!actionLinksFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from actionLinksFacebookCollection"));
            }
        }
        for (ActionLinksFacebook value : actionLinksFacebookCollectionNew) {
            if (!actionLinksFacebookCollection.contains(value)) {
                StreamFacebook oldEntity = value.getStreamFacebook();
                value.setStreamFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getActionLinksFacebookCollection().remove(value);
                }
            }
        }
        for (PrivacyFacebook value : privacyFacebookCollection) {
            if (!privacyFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from privacyFacebookCollection"));
            }
        }
        for (PrivacyFacebook value : privacyFacebookCollectionNew) {
            if (!privacyFacebookCollection.contains(value)) {
                StreamFacebook oldEntity = value.getStreamFacebook();
                value.setStreamFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getPrivacyFacebookCollection().remove(value);
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
    private void deleteEntity(StreamFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        for (UserFacebook value : entity.getUserFacebookCollection()) {
            value.getStreamFacebookCollection().remove(entity);
        }
        if (!entity.getCommentsFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because commentsFacebookCollection is not empty."));
        }
        if (!entity.getLikesFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because likesFacebookCollection is not empty."));
        }
        if (!entity.getActionLinksFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because actionLinksFacebookCollection is not empty."));
        }
        if (!entity.getPrivacyFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because privacyFacebookCollection is not empty."));
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

    /**
     * Returns a dynamic instance of CommentsFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of CommentsFacebooksResource
     */
    @Path("commentsFacebookCollection/")
    public CommentsFacebooksResource getCommentsFacebookCollectionResource() {
        CommentsFacebookCollectionResourceSub commentsFacebookCollectionResourceSub = resourceContext.getResource(CommentsFacebookCollectionResourceSub.class);
        commentsFacebookCollectionResourceSub.setParent(getEntity());
        return commentsFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of LikesFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of LikesFacebooksResource
     */
    @Path("likesFacebookCollection/")
    public LikesFacebooksResource getLikesFacebookCollectionResource() {
        LikesFacebookCollectionResourceSub likesFacebookCollectionResourceSub = resourceContext.getResource(LikesFacebookCollectionResourceSub.class);
        likesFacebookCollectionResourceSub.setParent(getEntity());
        return likesFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of ActionLinksFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of ActionLinksFacebooksResource
     */
    @Path("actionLinksFacebookCollection/")
    public ActionLinksFacebooksResource getActionLinksFacebookCollectionResource() {
        ActionLinksFacebookCollectionResourceSub actionLinksFacebookCollectionResourceSub = resourceContext.getResource(ActionLinksFacebookCollectionResourceSub.class);
        actionLinksFacebookCollectionResourceSub.setParent(getEntity());
        return actionLinksFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of PrivacyFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of PrivacyFacebooksResource
     */
    @Path("privacyFacebookCollection/")
    public PrivacyFacebooksResource getPrivacyFacebookCollectionResource() {
        PrivacyFacebookCollectionResourceSub privacyFacebookCollectionResourceSub = resourceContext.getResource(PrivacyFacebookCollectionResourceSub.class);
        privacyFacebookCollectionResourceSub.setParent(getEntity());
        return privacyFacebookCollectionResourceSub;
    }

    public static class UserFacebookCollectionResourceSub extends UserFacebooksResource {

        private StreamFacebook parent;

        public void setParent(StreamFacebook parent) {
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

    public static class CommentsFacebookCollectionResourceSub extends CommentsFacebooksResource {

        private StreamFacebook parent;

        public void setParent(StreamFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<CommentsFacebook> getEntities(int start, int max, String query) {
            Collection<CommentsFacebook> result = new java.util.ArrayList<CommentsFacebook>();
            int index = 0;
            for (CommentsFacebook e : parent.getCommentsFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class LikesFacebookCollectionResourceSub extends LikesFacebooksResource {

        private StreamFacebook parent;

        public void setParent(StreamFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<LikesFacebook> getEntities(int start, int max, String query) {
            Collection<LikesFacebook> result = new java.util.ArrayList<LikesFacebook>();
            int index = 0;
            for (LikesFacebook e : parent.getLikesFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class ActionLinksFacebookCollectionResourceSub extends ActionLinksFacebooksResource {

        private StreamFacebook parent;

        public void setParent(StreamFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<ActionLinksFacebook> getEntities(int start, int max, String query) {
            Collection<ActionLinksFacebook> result = new java.util.ArrayList<ActionLinksFacebook>();
            int index = 0;
            for (ActionLinksFacebook e : parent.getActionLinksFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class PrivacyFacebookCollectionResourceSub extends PrivacyFacebooksResource {

        private StreamFacebook parent;

        public void setParent(StreamFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<PrivacyFacebook> getEntities(int start, int max, String query) {
            Collection<PrivacyFacebook> result = new java.util.ArrayList<PrivacyFacebook>();
            int index = 0;
            for (PrivacyFacebook e : parent.getPrivacyFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }
}
