/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.CommentFacebook;
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
import es.uah.cc.ie.converter.CommentFacebooksConverter;
import es.uah.cc.ie.converter.CommentFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;

/**
 *
 * @author tote
 */

@Path("/commentFacebooks/")
public class CommentFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of CommentFacebooksResource */
    public CommentFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of CommentFacebook instance in XML format.
     *
     * @return an instance of CommentFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public CommentFacebooksConverter get(@QueryParam("start")
                                         @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM CommentFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new CommentFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of CommentFacebook using XML as the input format.
     *
     * @param data an CommentFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of CommentFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(CommentFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        Date auxTime = new Date();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            CommentFacebook entity = data.resolveEntity(em);
            auxTime.setTime(data.getEntity().getTimeComment().getTime() * 1000);
            entity.setTimeComment(auxTime);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getXid() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of CommentFacebookResource used for entity navigation.
     *
     * @return an instance of CommentFacebookResource
     */
    @Path("{id}/")
    public CommentFacebookResource getCommentFacebookResource(@PathParam("id")
    String id) {
        CommentFacebookResource commentFacebookResource = resourceContext.getResource(CommentFacebookResource.class);
        commentFacebookResource.setId(id);
        return commentFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of CommentFacebook instances
     */
    protected Collection<CommentFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(CommentFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
    }
}
