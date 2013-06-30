/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.LikesFacebook;
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
import es.uah.cc.ie.persistence.FriendsLikesFacebook;
import es.uah.cc.ie.persistence.SampleLikesFacebook;
import es.uah.cc.ie.persistence.StreamFacebook;
import es.uah.cc.ie.converter.LikesFacebooksConverter;
import es.uah.cc.ie.converter.LikesFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/likesFacebooks/")
public class LikesFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of LikesFacebooksResource */
    public LikesFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of LikesFacebook instance in XML format.
     *
     * @return an instance of LikesFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public LikesFacebooksConverter get(@QueryParam("start")
                                       @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM LikesFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new LikesFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of LikesFacebook using XML as the input format.
     *
     * @param data an LikesFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of LikesFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(LikesFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            LikesFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdLikesFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of LikesFacebookResource used for entity navigation.
     *
     * @return an instance of LikesFacebookResource
     */
    @Path("{idLikesFacebook}/")
    public LikesFacebookResource getLikesFacebookResource(@PathParam("idLikesFacebook")
    Integer id) {
        LikesFacebookResource likesFacebookResource = resourceContext.getResource(LikesFacebookResource.class);
        likesFacebookResource.setId(id);
        return likesFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of LikesFacebook instances
     */
    protected Collection<LikesFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(LikesFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (FriendsLikesFacebook value : entity.getFriendsLikesFacebookCollection()) {
            LikesFacebook oldEntity = value.getLikesFacebook();
            value.setLikesFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getFriendsLikesFacebookCollection().remove(value);
            }
        }
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            streamFacebook.getLikesFacebookCollection().add(entity);
        }
        for (SampleLikesFacebook value : entity.getSampleLikesFacebookCollection()) {
            LikesFacebook oldEntity = value.getLikesFacebook();
            value.setLikesFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getSampleLikesFacebookCollection().remove(value);
            }
        }
    }
}
