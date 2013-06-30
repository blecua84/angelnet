/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.UserFacebook;
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
import es.uah.cc.ie.persistence.WorkHistoryFacebook;
import es.uah.cc.ie.persistence.AffiliationsFacebook;
import es.uah.cc.ie.persistence.User;
import es.uah.cc.ie.persistence.LocationFacebook;
import es.uah.cc.ie.persistence.StreamFacebook;
import es.uah.cc.ie.persistence.EducationHistoryFacebook;
import es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATION;
import es.uah.cc.ie.persistence.FriendsFacebook;
import es.uah.cc.ie.persistence.FamilyFacebook;
import es.uah.cc.ie.converter.UserFacebooksConverter;
import es.uah.cc.ie.converter.UserFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/userFacebooks/")
public class UserFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of UserFacebooksResource */
    public UserFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of UserFacebook instance in XML format.
     *
     * @return an instance of UserFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public UserFacebooksConverter get(@QueryParam("start")
                                      @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM UserFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new UserFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of UserFacebook using XML as the input format.
     *
     * @param data an UserFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of UserFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(UserFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            UserFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdUserFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of UserFacebookResource used for entity navigation.
     *
     * @return an instance of UserFacebookResource
     */
    @Path("{idUserFacebook}/")
    public UserFacebookResource getUserFacebookResource(@PathParam("idUserFacebook")
    String id) {
        UserFacebookResource userFacebookResource = resourceContext.getResource(UserFacebookResource.class);
        userFacebookResource.setId(id);
        return userFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of UserFacebook instances
     */
    protected Collection<UserFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(UserFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (LocationFacebook value : entity.getLocationFacebookCollection()) {
            value.getUserFacebookCollection().add(entity);
        }
        for (FamilyFacebook value : entity.getFamilyFacebookCollection()) {
            value.getUserFacebookCollection().add(entity);
        }
        for (FriendsFacebook value : entity.getFriendsFacebookCollection()) {
            value.getUserFacebookCollection().add(entity);
        }
        for (StreamFacebook value : entity.getStreamFacebookCollection()) {
            value.getUserFacebookCollection().add(entity);
        }
        for (LocationfacebookhasuserfacebookCURRENTLOCATION value : entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection()) {
            UserFacebook oldEntity = value.getUserFacebook();
            value.setUserFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().remove(value);
            }
        }
        for (AffiliationsFacebook value : entity.getAffiliationsFacebookCollection()) {
            UserFacebook oldEntity = value.getUserFacebook();
            value.setUserFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getAffiliationsFacebookCollection().remove(value);
            }
        }
        for (EducationHistoryFacebook value : entity.getEducationHistoryFacebookCollection()) {
            UserFacebook oldEntity = value.getUserFacebook();
            value.setUserFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getEducationHistoryFacebookCollection().remove(value);
            }
        }
        for (WorkHistoryFacebook value : entity.getWorkHistoryFacebookCollection()) {
            UserFacebook oldEntity = value.getUserFacebook();
            value.setUserFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getWorkHistoryFacebookCollection().remove(value);
            }
        }
        for (User value : entity.getUserCollection()) {
            UserFacebook oldEntity = value.getUserFacebook();
            value.setUserFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getUserCollection().remove(value);
            }
        }
    }
}
