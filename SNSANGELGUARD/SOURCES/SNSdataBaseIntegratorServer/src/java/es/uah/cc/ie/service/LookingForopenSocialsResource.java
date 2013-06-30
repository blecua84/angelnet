/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.LookingForopenSocial;
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
import es.uah.cc.ie.converter.LookingForopenSocialsConverter;
import es.uah.cc.ie.converter.LookingForopenSocialConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/lookingForopenSocials/")
public class LookingForopenSocialsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of LookingForopenSocialsResource */
    public LookingForopenSocialsResource() {
    }

    /**
     * Get method for retrieving a collection of LookingForopenSocial instance in XML format.
     *
     * @return an instance of LookingForopenSocialsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public LookingForopenSocialsConverter get(@QueryParam("start")
                                              @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM LookingForopenSocial e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new LookingForopenSocialsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of LookingForopenSocial using XML as the input format.
     *
     * @param data an LookingForopenSocialConverter entity that is deserialized from an XML stream
     * @return an instance of LookingForopenSocialConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(LookingForopenSocialConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            LookingForopenSocial entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdLookingForopenSocial() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of LookingForopenSocialResource used for entity navigation.
     *
     * @return an instance of LookingForopenSocialResource
     */
    @Path("{idLookingForopenSocial}/")
    public LookingForopenSocialResource getLookingForopenSocialResource(@PathParam("idLookingForopenSocial")
    Integer id) {
        LookingForopenSocialResource lookingForopenSocialResource = resourceContext.getResource(LookingForopenSocialResource.class);
        lookingForopenSocialResource.setId(id);
        return lookingForopenSocialResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of LookingForopenSocial instances
     */
    protected Collection<LookingForopenSocial> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(LookingForopenSocial entity) {
        entity.setIdLookingForopenSocial(null);
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
    }
}
