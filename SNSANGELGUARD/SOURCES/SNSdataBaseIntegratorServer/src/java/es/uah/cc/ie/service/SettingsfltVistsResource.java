/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SettingsfltVist;
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
import es.uah.cc.ie.persistence.SettingsAngels;
import es.uah.cc.ie.persistence.UserSettings;
import es.uah.cc.ie.converter.SettingsfltVistsConverter;
import es.uah.cc.ie.converter.SettingsfltVistConverter;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;

/**
 *
 * @author tote
 */

@Path("/settingsfltVists/")
public class SettingsfltVistsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of SettingsfltVistsResource */
    public SettingsfltVistsResource() {
    }

    /**
     * Get method for retrieving a collection of SettingsfltVist instance in XML format.
     *
     * @return an instance of SettingsfltVistsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SettingsfltVistsConverter get(@QueryParam("start")
                                         @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM SettingsfltVist e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SettingsfltVistsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of SettingsfltVist using XML as the input format.
     *
     * @param data an SettingsfltVistConverter entity that is deserialized from an XML stream
     * @return an instance of SettingsfltVistConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(SettingsfltVistConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            SettingsfltVist entity = data.resolveEntity(em);
            entity.setLastCheck(new Date());
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getUserSettingsUid() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of SettingsfltVistResource used for entity navigation.
     *
     * @return an instance of SettingsfltVistResource
     */
    @Path("{userSettingsUid}/")
    public SettingsfltVistResource getSettingsfltVistResource(@PathParam("userSettingsUid")
    String id) {
        SettingsfltVistResource settingsfltVistResource = resourceContext.getResource(SettingsfltVistResource.class);
        settingsfltVistResource.setId(id);
        return settingsfltVistResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of SettingsfltVist instances
     */
    protected Collection<SettingsfltVist> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(SettingsfltVist entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (SettingsAngels value : entity.getSettingsAngelsCollection()) {
            value.getSettingsfltVistCollection().add(entity);
        }
        UserSettings userSettings = entity.getUserSettings();
        if (userSettings != null) {
            userSettings.setSettingsfltVist(entity);
        }
    }
}
