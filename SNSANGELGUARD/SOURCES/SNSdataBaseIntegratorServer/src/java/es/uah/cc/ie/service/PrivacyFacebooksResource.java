/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.PrivacyFacebook;
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
import es.uah.cc.ie.persistence.StreamFacebook;
import es.uah.cc.ie.converter.PrivacyFacebooksConverter;
import es.uah.cc.ie.converter.PrivacyFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/privacyFacebooks/")
public class PrivacyFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of PrivacyFacebooksResource */
    public PrivacyFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of PrivacyFacebook instance in XML format.
     *
     * @return an instance of PrivacyFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public PrivacyFacebooksConverter get(@QueryParam("start")
                                         @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM PrivacyFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new PrivacyFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of PrivacyFacebook using XML as the input format.
     *
     * @param data an PrivacyFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of PrivacyFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(PrivacyFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            PrivacyFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdPrivacyFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of PrivacyFacebookResource used for entity navigation.
     *
     * @return an instance of PrivacyFacebookResource
     */
    @Path("{idPrivacyFacebook}/")
    public PrivacyFacebookResource getPrivacyFacebookResource(@PathParam("idPrivacyFacebook")
    Integer id) {
        PrivacyFacebookResource privacyFacebookResource = resourceContext.getResource(PrivacyFacebookResource.class);
        privacyFacebookResource.setId(id);
        return privacyFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of PrivacyFacebook instances
     */
    protected Collection<PrivacyFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(PrivacyFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            streamFacebook.getPrivacyFacebookCollection().add(entity);
        }
    }
}
