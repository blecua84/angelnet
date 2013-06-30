/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.ActionLinksFacebook;
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
import es.uah.cc.ie.converter.ActionLinksFacebooksConverter;
import es.uah.cc.ie.converter.ActionLinksFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/actionLinksFacebooks/")
public class ActionLinksFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of ActionLinksFacebooksResource */
    public ActionLinksFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of ActionLinksFacebook instance in XML format.
     *
     * @return an instance of ActionLinksFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public ActionLinksFacebooksConverter get(@QueryParam("start")
                                             @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM ActionLinksFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new ActionLinksFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of ActionLinksFacebook using XML as the input format.
     *
     * @param data an ActionLinksFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of ActionLinksFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(ActionLinksFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            ActionLinksFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdActionLinksFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of ActionLinksFacebookResource used for entity navigation.
     *
     * @return an instance of ActionLinksFacebookResource
     */
    @Path("{idActionLinksFacebook}/")
    public ActionLinksFacebookResource getActionLinksFacebookResource(@PathParam("idActionLinksFacebook")
    Integer id) {
        ActionLinksFacebookResource actionLinksFacebookResource = resourceContext.getResource(ActionLinksFacebookResource.class);
        actionLinksFacebookResource.setId(id);
        return actionLinksFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of ActionLinksFacebook instances
     */
    protected Collection<ActionLinksFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(ActionLinksFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        StreamFacebook streamFacebook = entity.getStreamFacebook();
        if (streamFacebook != null) {
            streamFacebook.getActionLinksFacebookCollection().add(entity);
        }
    }
}
