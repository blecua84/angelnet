/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.EducationHistoryFacebook;
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
import es.uah.cc.ie.converter.EducationHistoryFacebooksConverter;
import es.uah.cc.ie.converter.EducationHistoryFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/educationHistoryFacebooks/")
public class EducationHistoryFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of EducationHistoryFacebooksResource */
    public EducationHistoryFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of EducationHistoryFacebook instance in XML format.
     *
     * @return an instance of EducationHistoryFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public EducationHistoryFacebooksConverter get(@QueryParam("start")
                                                  @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM EducationHistoryFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new EducationHistoryFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of EducationHistoryFacebook using XML as the input format.
     *
     * @param data an EducationHistoryFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of EducationHistoryFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(EducationHistoryFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            EducationHistoryFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdEducationHistoryFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of EducationHistoryFacebookResource used for entity navigation.
     *
     * @return an instance of EducationHistoryFacebookResource
     */
    @Path("{idEducationHistoryFacebook}/")
    public EducationHistoryFacebookResource getEducationHistoryFacebookResource(@PathParam("idEducationHistoryFacebook")
    Integer id) {
        EducationHistoryFacebookResource educationHistoryFacebookResource = resourceContext.getResource(EducationHistoryFacebookResource.class);
        educationHistoryFacebookResource.setId(id);
        return educationHistoryFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of EducationHistoryFacebook instances
     */
    protected Collection<EducationHistoryFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(EducationHistoryFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            userFacebook.getEducationHistoryFacebookCollection().add(entity);
        }
    }
}
