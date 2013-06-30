/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SampleLikesFacebook;
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
import es.uah.cc.ie.persistence.LikesFacebook;
import es.uah.cc.ie.converter.SampleLikesFacebooksConverter;
import es.uah.cc.ie.converter.SampleLikesFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/sampleLikesFacebooks/")
public class SampleLikesFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of SampleLikesFacebooksResource */
    public SampleLikesFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of SampleLikesFacebook instance in XML format.
     *
     * @return an instance of SampleLikesFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SampleLikesFacebooksConverter get(@QueryParam("start")
                                             @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM SampleLikesFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SampleLikesFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of SampleLikesFacebook using XML as the input format.
     *
     * @param data an SampleLikesFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of SampleLikesFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(SampleLikesFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            SampleLikesFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdSampleLikesFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of SampleLikesFacebookResource used for entity navigation.
     *
     * @return an instance of SampleLikesFacebookResource
     */
    @Path("{idSampleLikesFacebook}/")
    public SampleLikesFacebookResource getSampleLikesFacebookResource(@PathParam("idSampleLikesFacebook")
    Integer id) {
        SampleLikesFacebookResource sampleLikesFacebookResource = resourceContext.getResource(SampleLikesFacebookResource.class);
        sampleLikesFacebookResource.setId(id);
        return sampleLikesFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of SampleLikesFacebook instances
     */
    protected Collection<SampleLikesFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(SampleLikesFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        LikesFacebook likesFacebook = entity.getLikesFacebook();
        if (likesFacebook != null) {
            likesFacebook.getSampleLikesFacebookCollection().add(entity);
        }
    }
}
