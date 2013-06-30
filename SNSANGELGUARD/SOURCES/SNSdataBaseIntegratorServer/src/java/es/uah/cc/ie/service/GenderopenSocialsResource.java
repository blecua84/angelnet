/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.GenderopenSocial;
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
import es.uah.cc.ie.converter.GenderopenSocialsConverter;
import es.uah.cc.ie.converter.GenderopenSocialConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/genderopenSocials/")
public class GenderopenSocialsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of GenderopenSocialsResource */
    public GenderopenSocialsResource() {
    }

    /**
     * Get method for retrieving a collection of GenderopenSocial instance in XML format.
     *
     * @return an instance of GenderopenSocialsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public GenderopenSocialsConverter get(@QueryParam("start")
                                          @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM GenderopenSocial e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new GenderopenSocialsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of GenderopenSocial using XML as the input format.
     *
     * @param data an GenderopenSocialConverter entity that is deserialized from an XML stream
     * @return an instance of GenderopenSocialConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(GenderopenSocialConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            GenderopenSocial entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdGenderopenSocial() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of GenderopenSocialResource used for entity navigation.
     *
     * @return an instance of GenderopenSocialResource
     */
    @Path("{idGenderopenSocial}/")
    public GenderopenSocialResource getGenderopenSocialResource(@PathParam("idGenderopenSocial")
    Integer id) {
        GenderopenSocialResource genderopenSocialResource = resourceContext.getResource(GenderopenSocialResource.class);
        genderopenSocialResource.setId(id);
        return genderopenSocialResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of GenderopenSocial instances
     */
    protected Collection<GenderopenSocial> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(GenderopenSocial entity) {
        entity.setIdGenderopenSocial(null);
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
    }
}
