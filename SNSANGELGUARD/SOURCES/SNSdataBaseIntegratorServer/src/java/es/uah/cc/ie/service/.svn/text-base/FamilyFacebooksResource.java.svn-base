/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.FamilyFacebook;
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
import es.uah.cc.ie.persistence.RelationshipFacebook;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.FamilyFacebooksConverter;
import es.uah.cc.ie.converter.FamilyFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/familyFacebooks/")
public class FamilyFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of FamilyFacebooksResource */
    public FamilyFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of FamilyFacebook instance in XML format.
     *
     * @return an instance of FamilyFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public FamilyFacebooksConverter get(@QueryParam("start")
                                        @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM FamilyFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new FamilyFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of FamilyFacebook using XML as the input format.
     *
     * @param data an FamilyFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of FamilyFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(FamilyFacebookConverter data) {
        System.out.println("DENTRO AMIGOS");
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            FamilyFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdFamilyFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of FamilyFacebookResource used for entity navigation.
     *
     * @return an instance of FamilyFacebookResource
     */
    @Path("{idFamilyFacebook}/")
    public FamilyFacebookResource getFamilyFacebookResource(@PathParam("idFamilyFacebook")
    Integer id) {
        FamilyFacebookResource familyFacebookResource = resourceContext.getResource(FamilyFacebookResource.class);
        familyFacebookResource.setId(id);
        return familyFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of FamilyFacebook instances
     */
    protected Collection<FamilyFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(FamilyFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (UserFacebook value : entity.getUserFacebookCollection()) {
            value.getFamilyFacebookCollection().add(entity);
        }
        RelationshipFacebook relationshipFacebook = entity.getRelationshipFacebook();
        if (relationshipFacebook != null) {
            relationshipFacebook.getFamilyFacebookCollection().add(entity);
        }
    }
}
