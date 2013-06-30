/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SmokeropenSocial;
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
import es.uah.cc.ie.converter.SmokeropenSocialsConverter;
import es.uah.cc.ie.converter.SmokeropenSocialConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/smokeropenSocials/")
public class SmokeropenSocialsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of SmokeropenSocialsResource */
    public SmokeropenSocialsResource() {
    }

    /**
     * Get method for retrieving a collection of SmokeropenSocial instance in XML format.
     *
     * @return an instance of SmokeropenSocialsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SmokeropenSocialsConverter get(@QueryParam("start")
                                          @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM SmokeropenSocial e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SmokeropenSocialsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of SmokeropenSocial using XML as the input format.
     *
     * @param data an SmokeropenSocialConverter entity that is deserialized from an XML stream
     * @return an instance of SmokeropenSocialConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(SmokeropenSocialConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            SmokeropenSocial entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdSmokeropenSocial() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of SmokeropenSocialResource used for entity navigation.
     *
     * @return an instance of SmokeropenSocialResource
     */
    @Path("{idSmokeropenSocial}/")
    public SmokeropenSocialResource getSmokeropenSocialResource(@PathParam("idSmokeropenSocial")
    Integer id) {
        SmokeropenSocialResource smokeropenSocialResource = resourceContext.getResource(SmokeropenSocialResource.class);
        smokeropenSocialResource.setId(id);
        return smokeropenSocialResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of SmokeropenSocial instances
     */
    protected Collection<SmokeropenSocial> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(SmokeropenSocial entity) {
        entity.setIdSmokeropenSocial(null);
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
    }
}
