/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.FriendsLikesFacebook;
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
import es.uah.cc.ie.converter.FriendsLikesFacebooksConverter;
import es.uah.cc.ie.converter.FriendsLikesFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/friendsLikesFacebooks/")
public class FriendsLikesFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of FriendsLikesFacebooksResource */
    public FriendsLikesFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of FriendsLikesFacebook instance in XML format.
     *
     * @return an instance of FriendsLikesFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public FriendsLikesFacebooksConverter get(@QueryParam("start")
                                              @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM FriendsLikesFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new FriendsLikesFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of FriendsLikesFacebook using XML as the input format.
     *
     * @param data an FriendsLikesFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of FriendsLikesFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(FriendsLikesFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            FriendsLikesFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdFriendsLikesFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of FriendsLikesFacebookResource used for entity navigation.
     *
     * @return an instance of FriendsLikesFacebookResource
     */
    @Path("{idFriendsLikesFacebook}/")
    public FriendsLikesFacebookResource getFriendsLikesFacebookResource(@PathParam("idFriendsLikesFacebook")
    Integer id) {
        FriendsLikesFacebookResource friendsLikesFacebookResource = resourceContext.getResource(FriendsLikesFacebookResource.class);
        friendsLikesFacebookResource.setId(id);
        return friendsLikesFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of FriendsLikesFacebook instances
     */
    protected Collection<FriendsLikesFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(FriendsLikesFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        LikesFacebook likesFacebook = entity.getLikesFacebook();
        if (likesFacebook != null) {
            likesFacebook.getFriendsLikesFacebookCollection().add(entity);
        }
    }
}
