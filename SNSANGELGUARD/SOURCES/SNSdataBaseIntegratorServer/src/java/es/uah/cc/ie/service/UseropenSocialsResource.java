/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.UseropenSocial;
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
import es.uah.cc.ie.persistence.User;
import es.uah.cc.ie.converter.UseropenSocialsConverter;
import es.uah.cc.ie.converter.UseropenSocialConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/useropenSocials/")
public class UseropenSocialsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of UseropenSocialsResource */
    public UseropenSocialsResource() {
    }

    /**
     * Get method for retrieving a collection of UseropenSocial instance in XML format.
     *
     * @return an instance of UseropenSocialsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public UseropenSocialsConverter get(@QueryParam("start")
                                        @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM UseropenSocial e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new UseropenSocialsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of UseropenSocial using XML as the input format.
     *
     * @param data an UseropenSocialConverter entity that is deserialized from an XML stream
     * @return an instance of UseropenSocialConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(UseropenSocialConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            UseropenSocial entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIduseropenSocial() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of UseropenSocialResource used for entity navigation.
     *
     * @return an instance of UseropenSocialResource
     */
    @Path("{iduseropenSocial}/")
    public UseropenSocialResource getUseropenSocialResource(@PathParam("iduseropenSocial")
    Integer id) {
        UseropenSocialResource useropenSocialResource = resourceContext.getResource(UseropenSocialResource.class);
        useropenSocialResource.setId(id);
        return useropenSocialResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of UseropenSocial instances
     */
    protected Collection<UseropenSocial> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(UseropenSocial entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (User value : entity.getUserCollection()) {
            UseropenSocial oldEntity = value.getUseropenSocial();
            value.setUseropenSocial(entity);
            if (oldEntity != null) {
                oldEntity.getUserCollection().remove(value);
            }
        }
    }
}
