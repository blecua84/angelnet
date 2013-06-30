/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.GuardianSettings;
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
import es.uah.cc.ie.converter.GuardianSettingssConverter;
import es.uah.cc.ie.converter.GuardianSettingsConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/guardianSettingss/")
public class GuardianSettingssResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of GuardianSettingssResource */
    public GuardianSettingssResource() {
    }

    /**
     * Get method for retrieving a collection of GuardianSettings instance in XML format.
     *
     * @return an instance of GuardianSettingssConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public GuardianSettingssConverter get(@QueryParam("start")
                                          @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM GuardianSettings e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new GuardianSettingssConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of GuardianSettings using XML as the input format.
     *
     * @param data an GuardianSettingsConverter entity that is deserialized from an XML stream
     * @return an instance of GuardianSettingsConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(GuardianSettingsConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            GuardianSettings entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getUidGuardian() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of GuardianSettingsResource used for entity navigation.
     *
     * @return an instance of GuardianSettingsResource
     */
    @Path("{uidGuardian}/")
    public GuardianSettingsResource getGuardianSettingsResource(@PathParam("uidGuardian")
    Integer id) {
        GuardianSettingsResource guardianSettingsResource = resourceContext.getResource(GuardianSettingsResource.class);
        guardianSettingsResource.setId(id);
        return guardianSettingsResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of GuardianSettings instances
     */
    protected Collection<GuardianSettings> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(GuardianSettings entity) {
        entity.setUidGuardian(null);
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
    }
}
