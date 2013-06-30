/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.RelationshipFacebook;
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
import es.uah.cc.ie.persistence.FamilyFacebook;
import es.uah.cc.ie.converter.RelationshipFacebooksConverter;
import es.uah.cc.ie.converter.RelationshipFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/relationshipFacebooks/")
public class RelationshipFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of RelationshipFacebooksResource */
    public RelationshipFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of RelationshipFacebook instance in XML format.
     *
     * @return an instance of RelationshipFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public RelationshipFacebooksConverter get(@QueryParam("start")
                                              @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM RelationshipFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new RelationshipFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of RelationshipFacebook using XML as the input format.
     *
     * @param data an RelationshipFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of RelationshipFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(RelationshipFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            RelationshipFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdRelationshipFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of RelationshipFacebookResource used for entity navigation.
     *
     * @return an instance of RelationshipFacebookResource
     */
    @Path("{idRelationshipFacebook}/")
    public RelationshipFacebookResource getRelationshipFacebookResource(@PathParam("idRelationshipFacebook")
    Integer id) {
        RelationshipFacebookResource relationshipFacebookResource = resourceContext.getResource(RelationshipFacebookResource.class);
        relationshipFacebookResource.setId(id);
        return relationshipFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of RelationshipFacebook instances
     */
    protected Collection<RelationshipFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(RelationshipFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (FamilyFacebook value : entity.getFamilyFacebookCollection()) {
            RelationshipFacebook oldEntity = value.getRelationshipFacebook();
            value.setRelationshipFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getFamilyFacebookCollection().remove(value);
            }
        }
    }
}
