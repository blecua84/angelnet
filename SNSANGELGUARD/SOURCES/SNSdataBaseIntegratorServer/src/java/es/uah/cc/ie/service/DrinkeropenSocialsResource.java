/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.DrinkeropenSocial;
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
import es.uah.cc.ie.converter.DrinkeropenSocialsConverter;
import es.uah.cc.ie.converter.DrinkeropenSocialConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/drinkeropenSocials/")
public class DrinkeropenSocialsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of DrinkeropenSocialsResource */
    public DrinkeropenSocialsResource() {
    }

    /**
     * Get method for retrieving a collection of DrinkeropenSocial instance in XML format.
     *
     * @return an instance of DrinkeropenSocialsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public DrinkeropenSocialsConverter get(@QueryParam("start")
                                           @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM DrinkeropenSocial e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new DrinkeropenSocialsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of DrinkeropenSocial using XML as the input format.
     *
     * @param data an DrinkeropenSocialConverter entity that is deserialized from an XML stream
     * @return an instance of DrinkeropenSocialConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(DrinkeropenSocialConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            DrinkeropenSocial entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdDrinkeropenSocial() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of DrinkeropenSocialResource used for entity navigation.
     *
     * @return an instance of DrinkeropenSocialResource
     */
    @Path("{idDrinkeropenSocial}/")
    public DrinkeropenSocialResource getDrinkeropenSocialResource(@PathParam("idDrinkeropenSocial")
    Integer id) {
        DrinkeropenSocialResource drinkeropenSocialResource = resourceContext.getResource(DrinkeropenSocialResource.class);
        drinkeropenSocialResource.setId(id);
        return drinkeropenSocialResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of DrinkeropenSocial instances
     */
    protected Collection<DrinkeropenSocial> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(DrinkeropenSocial entity) {
        entity.setIdDrinkeropenSocial(null);
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
    }
}
