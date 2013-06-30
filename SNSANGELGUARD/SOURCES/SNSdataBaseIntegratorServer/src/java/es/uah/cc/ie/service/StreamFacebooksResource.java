/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.StreamFacebook;
import java.text.ParseException;
import java.util.Collection;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.LikesFacebook;
import es.uah.cc.ie.persistence.ActionLinksFacebook;
import es.uah.cc.ie.persistence.CommentsFacebook;
import es.uah.cc.ie.persistence.PrivacyFacebook;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.StreamFacebooksConverter;
import es.uah.cc.ie.converter.StreamFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;

/**
 *
 * @author tote
 */

@Path("/streamFacebooks/")
public class StreamFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of StreamFacebooksResource */
    public StreamFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of StreamFacebook instance in XML format.
     *
     * @return an instance of StreamFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public StreamFacebooksConverter get(@QueryParam("start")
                                        @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM StreamFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new StreamFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of StreamFacebook using XML as the input format.
     *
     * @param data an StreamFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of StreamFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(StreamFacebookConverter data) throws ParseException {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        Date auxU = new Date();
        Date auxC = new Date();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            StreamFacebook entity = data.resolveEntity(em);
            auxU.setTime(data.getEntity().getUpdatedTime().getTime() * 1000);
            entity.setUpdatedTime(auxU);
            auxC.setTime(data.getEntity().getCreatedTime().getTime() * 1000);
            entity.setCreatedTime(auxC);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getPostId() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of StreamFacebookResource used for entity navigation.
     *
     * @return an instance of StreamFacebookResource
     */
    @Path("{postId}/")
    public StreamFacebookResource getStreamFacebookResource(@PathParam("postId")
    String id) {
        StreamFacebookResource streamFacebookResource = resourceContext.getResource(StreamFacebookResource.class);
        streamFacebookResource.setId(id);
        return streamFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of StreamFacebook instances
     */
    protected Collection<StreamFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(StreamFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (UserFacebook value : entity.getUserFacebookCollection()) {
            value.getStreamFacebookCollection().add(entity);
        }
        for (CommentsFacebook value : entity.getCommentsFacebookCollection()) {
            StreamFacebook oldEntity = value.getStreamFacebook();
            value.setStreamFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getCommentsFacebookCollection().remove(value);
            }
        }
        for (LikesFacebook value : entity.getLikesFacebookCollection()) {
            StreamFacebook oldEntity = value.getStreamFacebook();
            value.setStreamFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getLikesFacebookCollection().remove(value);
            }
        }
        for (ActionLinksFacebook value : entity.getActionLinksFacebookCollection()) {
            StreamFacebook oldEntity = value.getStreamFacebook();
            value.setStreamFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getActionLinksFacebookCollection().remove(value);
            }
        }
        for (PrivacyFacebook value : entity.getPrivacyFacebookCollection()) {
            StreamFacebook oldEntity = value.getStreamFacebook();
            value.setStreamFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getPrivacyFacebookCollection().remove(value);
            }
        }
    }
}
