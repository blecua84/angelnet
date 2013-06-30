/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.AddressopenSocial;
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
import es.uah.cc.ie.converter.AddressopenSocialsConverter;
import es.uah.cc.ie.converter.AddressopenSocialConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/addressopenSocials/")
public class AddressopenSocialsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of AddressopenSocialsResource */
    public AddressopenSocialsResource() {
    }

    /**
     * Get method for retrieving a collection of AddressopenSocial instance in XML format.
     *
     * @return an instance of AddressopenSocialsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public AddressopenSocialsConverter get(@QueryParam("start")
                                           @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM AddressopenSocial e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new AddressopenSocialsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of AddressopenSocial using XML as the input format.
     *
     * @param data an AddressopenSocialConverter entity that is deserialized from an XML stream
     * @return an instance of AddressopenSocialConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(AddressopenSocialConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            AddressopenSocial entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdAddressopenSocial() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of AddressopenSocialResource used for entity navigation.
     *
     * @return an instance of AddressopenSocialResource
     */
    @Path("{idAddressopenSocial}/")
    public AddressopenSocialResource getAddressopenSocialResource(@PathParam("idAddressopenSocial")
    String id) {
        AddressopenSocialResource addressopenSocialResource = resourceContext.getResource(AddressopenSocialResource.class);
        addressopenSocialResource.setId(id);
        return addressopenSocialResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of AddressopenSocial instances
     */
    protected Collection<AddressopenSocial> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(AddressopenSocial entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
    }
}
