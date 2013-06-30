/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.TypeAffiliationsFacebook;
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
import es.uah.cc.ie.persistence.AffiliationsFacebook;
import es.uah.cc.ie.converter.TypeAffiliationsFacebooksConverter;
import es.uah.cc.ie.converter.TypeAffiliationsFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/typeAffiliationsFacebooks/")
public class TypeAffiliationsFacebooksResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of TypeAffiliationsFacebooksResource */
    public TypeAffiliationsFacebooksResource() {
    }

    /**
     * Get method for retrieving a collection of TypeAffiliationsFacebook instance in XML format.
     *
     * @return an instance of TypeAffiliationsFacebooksConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public TypeAffiliationsFacebooksConverter get(@QueryParam("start")
                                                  @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM TypeAffiliationsFacebook e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new TypeAffiliationsFacebooksConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of TypeAffiliationsFacebook using XML as the input format.
     *
     * @param data an TypeAffiliationsFacebookConverter entity that is deserialized from an XML stream
     * @return an instance of TypeAffiliationsFacebookConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(TypeAffiliationsFacebookConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            TypeAffiliationsFacebook entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdTypeAffiliationsFacebook() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of TypeAffiliationsFacebookResource used for entity navigation.
     *
     * @return an instance of TypeAffiliationsFacebookResource
     */
    @Path("{idTypeAffiliationsFacebook}/")
    public TypeAffiliationsFacebookResource getTypeAffiliationsFacebookResource(@PathParam("idTypeAffiliationsFacebook")
    Integer id) {
        TypeAffiliationsFacebookResource typeAffiliationsFacebookResource = resourceContext.getResource(TypeAffiliationsFacebookResource.class);
        typeAffiliationsFacebookResource.setId(id);
        return typeAffiliationsFacebookResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of TypeAffiliationsFacebook instances
     */
    protected Collection<TypeAffiliationsFacebook> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(TypeAffiliationsFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (AffiliationsFacebook value : entity.getAffiliationsFacebookCollection()) {
            TypeAffiliationsFacebook oldEntity = value.getTypeAffiliationsFacebook();
            value.setTypeAffiliationsFacebook(entity);
            if (oldEntity != null) {
                oldEntity.getAffiliationsFacebookCollection().remove(value);
            }
        }
    }
}
