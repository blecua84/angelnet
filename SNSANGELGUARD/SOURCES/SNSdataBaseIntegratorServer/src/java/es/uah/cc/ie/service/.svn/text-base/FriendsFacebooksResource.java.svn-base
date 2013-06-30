/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.FriendsFacebook;
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
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.FriendsFacebooksConverter;
import es.uah.cc.ie.converter.FriendsFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;

/**
 *
 * @author tote
 */

@Path("/friendsFacebooks/")
public class FriendsFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of FriendsFacebooksResource */
    public FriendsFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of FriendsFacebook instance in XML format.
     *
     * @return an instance of FriendsFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public FriendsFacebooksConverter get(@QueryParam("start")
                                         @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM FriendsFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new FriendsFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of FriendsFacebook using XML as the input format.
     *
     * @param data an FriendsFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of FriendsFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(FriendsFacebookConverter data) {
        Date aux = new Date();
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            FriendsFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getUserUid() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of FriendsFacebookResource used for entity navigation.
     *
     * @return an instance of FriendsFacebookResource
     */
    @Path("{userUid}/")
    public FriendsFacebookResource getFriendsFacebookResource(@PathParam("userUid")
    String id) {
        FriendsFacebookResource friendsFacebookResource = resourceContext.getResource(FriendsFacebookResource.class);
        friendsFacebookResource.setId(id);
        return friendsFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of FriendsFacebook instances
     */
    protected Collection<FriendsFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(FriendsFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (UserFacebook value : entity.getUserFacebookCollection()) {
            value.getFriendsFacebookCollection().add(entity);
        }
    }
}
