/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.WorkHistoryFacebook;
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
import es.uah.cc.ie.converter.WorkHistoryFacebooksConverter;
import es.uah.cc.ie.converter.WorkHistoryFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/workHistoryFacebooks/")
public class WorkHistoryFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of WorkHistoryFacebooksResource */
    public WorkHistoryFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of WorkHistoryFacebook instance in XML format.
     *
     * @return an instance of WorkHistoryFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public WorkHistoryFacebooksConverter get(@QueryParam("start")
                                             @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM WorkHistoryFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new WorkHistoryFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of WorkHistoryFacebook using XML as the input format.
     *
     * @param data an WorkHistoryFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of WorkHistoryFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(WorkHistoryFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            WorkHistoryFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdWorkHistoryFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of WorkHistoryFacebookResource used for entity navigation.
     *
     * @return an instance of WorkHistoryFacebookResource
     */
    @Path("{idWorkHistoryFacebook}/")
    public WorkHistoryFacebookResource getWorkHistoryFacebookResource(@PathParam("idWorkHistoryFacebook")
    Integer id) {
        WorkHistoryFacebookResource workHistoryFacebookResource = resourceContext.getResource(WorkHistoryFacebookResource.class);
        workHistoryFacebookResource.setId(id);
        return workHistoryFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of WorkHistoryFacebook instances
     */
    protected Collection<WorkHistoryFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(WorkHistoryFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            userFacebook.getWorkHistoryFacebookCollection().add(entity);
        }
    }
}
