/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.LocationFacebook;
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
import es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATION;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.LocationFacebooksConverter;
import es.uah.cc.ie.converter.LocationFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/locationFacebooks/")
public class LocationFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of LocationFacebooksResource */
    public LocationFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of LocationFacebook instance in XML format.
     *
     * @return an instance of LocationFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public LocationFacebooksConverter get(@QueryParam("start")
                                          @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM LocationFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new LocationFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of LocationFacebook using XML as the input format.
     *
     * @param data an LocationFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of LocationFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(LocationFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            LocationFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdLocationFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of LocationFacebookResource used for entity navigation.
     *
     * @return an instance of LocationFacebookResource
     */
    @Path("{idLocationFacebook}/")
    public LocationFacebookResource getLocationFacebookResource(@PathParam("idLocationFacebook")
    Integer id) {
        LocationFacebookResource locationFacebookResource = resourceContext.getResource(LocationFacebookResource.class);
        locationFacebookResource.setId(id);
        return locationFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of LocationFacebook instances
     */
    protected Collection<LocationFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(LocationFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (UserFacebook value : entity.getUserFacebookCollection()) {
            value.getLocationFacebookCollection().add(entity);
        }
        for (LocationfacebookhasuserfacebookCURRENTLOCATION value : entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection()) {
            LocationFacebook oldEntity = value.getLocationFacebook();
            value.setLocationFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().remove(value);
            }
        }
    }
}
