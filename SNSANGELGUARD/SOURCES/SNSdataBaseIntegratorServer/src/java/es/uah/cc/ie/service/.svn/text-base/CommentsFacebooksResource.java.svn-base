/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.CommentsFacebook;
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
import es.uah.cc.ie.persistence.StreamFacebook;
import es.uah.cc.ie.converter.CommentsFacebooksConverter;
import es.uah.cc.ie.converter.CommentsFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/commentsFacebooks/")
public class CommentsFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of CommentsFacebooksResource */
    public CommentsFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of CommentsFacebook instance in XML format.
     *
     * @return an instance of CommentsFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public CommentsFacebooksConverter get(@QueryParam("start")
                                          @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM CommentsFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new CommentsFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of CommentsFacebook using XML as the input format.
     *
     * @param data an CommentsFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of CommentsFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(CommentsFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            CommentsFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdCommentsFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of CommentsFacebookResource used for entity navigation.
     *
     * @return an instance of CommentsFacebookResource
     */
    @Path("{idCommentsFacebook}/")
    public CommentsFacebookResource getCommentsFacebookResource(@PathParam("idCommentsFacebook")
    Integer id) {
        CommentsFacebookResource commentsFacebookResource = resourceContext.getResource(CommentsFacebookResource.class);
        commentsFacebookResource.setId(id);
        return commentsFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of CommentsFacebook instances
     */
    protected Collection<CommentsFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(CommentsFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            streamFacebook.getCommentsFacebookCollection().add(entity);
        }
    }
}
