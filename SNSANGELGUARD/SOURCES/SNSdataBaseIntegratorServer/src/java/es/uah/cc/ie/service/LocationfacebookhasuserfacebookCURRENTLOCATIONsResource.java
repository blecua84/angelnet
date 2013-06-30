/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATION;
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
import es.uah.cc.ie.persistence.LocationFacebook;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter;
import es.uah.cc.ie.converter.LocationfacebookhasuserfacebookCURRENTLOCATIONConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/locationfacebookhasuserfacebookCURRENTLOCATIONs/")
public class LocationfacebookhasuserfacebookCURRENTLOCATIONsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of LocationfacebookhasuserfacebookCURRENTLOCATIONsResource */
    public LocationfacebookhasuserfacebookCURRENTLOCATIONsResource() {
    }

    /**
     * Get method for retrieving a collection of LocationfacebookhasuserfacebookCURRENTLOCATION instance in XML format.
     *
     * @return an instance of LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter get(@QueryParam("start")
                                                                        @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM LocationfacebookhasuserfacebookCURRENTLOCATION e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of LocationfacebookhasuserfacebookCURRENTLOCATION using XML as the input format.
     *
     * @param data an LocationfacebookhasuserfacebookCURRENTLOCATIONConverter entity that is deserialized from an XML stream
     * @return an instance of LocationfacebookhasuserfacebookCURRENTLOCATIONConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(LocationfacebookhasuserfacebookCURRENTLOCATIONConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            LocationfacebookhasuserfacebookCURRENTLOCATION entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONPK().getLocationFacebookIdLocationFacebook() + "," + entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONPK().getUserFacebookIdUserFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of LocationfacebookhasuserfacebookCURRENTLOCATIONResource used for entity navigation.
     *
     * @return an instance of LocationfacebookhasuserfacebookCURRENTLOCATIONResource
     */
    @Path("{locationFacebookIdLocationFacebook},{userFacebookIdUserFacebook}/")
    public LocationfacebookhasuserfacebookCURRENTLOCATIONResource getLocationfacebookhasuserfacebookCURRENTLOCATIONResource(@PathParam("locationFacebookIdLocationFacebook")
    Integer id1, @PathParam("userFacebookIdUserFacebook")
    String id2) {
        LocationfacebookhasuserfacebookCURRENTLOCATIONResource locationfacebookhasuserfacebookCURRENTLOCATIONResource = resourceContext.getResource(LocationfacebookhasuserfacebookCURRENTLOCATIONResource.class);
        locationfacebookhasuserfacebookCURRENTLOCATIONResource.setId1(id1);
        locationfacebookhasuserfacebookCURRENTLOCATIONResource.setId2(id2);
        return locationfacebookhasuserfacebookCURRENTLOCATIONResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of LocationfacebookhasuserfacebookCURRENTLOCATION instances
     */
    protected Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(LocationfacebookhasuserfacebookCURRENTLOCATION entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            userFacebook.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().add(entity);
        }
        LocationFacebook locationFacebook = entity.getLocationFacebook();
        if (locationFacebook != null) {
            locationFacebook.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().add(entity);
        }
    }
}
