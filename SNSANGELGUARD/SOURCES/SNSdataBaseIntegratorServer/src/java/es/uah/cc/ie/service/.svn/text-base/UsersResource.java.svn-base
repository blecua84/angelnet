/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.User;
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
import es.uah.cc.ie.persistence.UseropenSocial;
import es.uah.cc.ie.persistence.UserSettings;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.UsersConverter;
import es.uah.cc.ie.converter.UserConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */
@Path("/users/")
public class UsersResource {

    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;

    /** Creates a new instance of UsersResource */
    public UsersResource() {
    }

    /**
     * Get method for retrieving a collection of User instance in XML format.
     *
     * @return an instance of UsersConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public UsersConverter get(@QueryParam("start")
            @DefaultValue("0") int start, @QueryParam("max")
            @DefaultValue("10") int max, @QueryParam("expandLevel")
            @DefaultValue("1") int expandLevel, @QueryParam("query")
            @DefaultValue("SELECT e FROM User e") String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new UsersConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of User using XML as the input format.
     *
     * @param data an UserConverter entity that is deserialized from an XML stream
     * @return an instance of UserConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(UserConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            User entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getUserSettingsUid() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of UserResource used for entity navigation.
     *
     * @return an instance of UserResource
     */
    @Path("{userSettingsUid}/")
    public UserResource getUserResource(@PathParam("userSettingsUid") String id) {
        UserResource userResource = resourceContext.getResource(UserResource.class);
        userResource.setId(id);
        return userResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of User instances
     */
    protected Collection<User> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(User entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        UserSettings userSettings = entity.getUserSettings();
        if (userSettings != null) {
            userSettings.setUser(entity);
        }
        UseropenSocial useropenSocial = entity.getUseropenSocial();
        if (useropenSocial != null) {
            useropenSocial.getUserCollection().add(entity);
        }
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            userFacebook.getUserCollection().add(entity);
        }
    }
}
