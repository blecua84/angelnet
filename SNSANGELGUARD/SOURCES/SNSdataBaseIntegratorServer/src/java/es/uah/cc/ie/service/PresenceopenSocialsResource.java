/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.PresenceopenSocial;
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
import es.uah.cc.ie.converter.PresenceopenSocialsConverter;
import es.uah.cc.ie.converter.PresenceopenSocialConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/presenceopenSocials/")
public class PresenceopenSocialsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of PresenceopenSocialsResource */
    public PresenceopenSocialsResource() {
    }

    /**
     * Get method for retrieving a collection of PresenceopenSocial instance in XML format.
     *
     * @return an instance of PresenceopenSocialsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public PresenceopenSocialsConverter get(@QueryParam("start")
                                            @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM PresenceopenSocial e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new PresenceopenSocialsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of PresenceopenSocial using XML as the input format.
     *
     * @param data an PresenceopenSocialConverter entity that is deserialized from an XML stream
     * @return an instance of PresenceopenSocialConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(PresenceopenSocialConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            PresenceopenSocial entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdPresenceopenSocial() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of PresenceopenSocialResource used for entity navigation.
     *
     * @return an instance of PresenceopenSocialResource
     */
    @Path("{idPresenceopenSocial}/")
    public PresenceopenSocialResource getPresenceopenSocialResource(@PathParam("idPresenceopenSocial")
    Integer id) {
        PresenceopenSocialResource presenceopenSocialResource = resourceContext.getResource(PresenceopenSocialResource.class);
        presenceopenSocialResource.setId(id);
        return presenceopenSocialResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of PresenceopenSocial instances
     */
    protected Collection<PresenceopenSocial> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(PresenceopenSocial entity) {
        entity.setIdPresenceopenSocial(null);
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
    }
}