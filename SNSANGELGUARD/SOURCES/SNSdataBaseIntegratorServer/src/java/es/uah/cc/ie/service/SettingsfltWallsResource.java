/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SettingsfltWall;
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
import es.uah.cc.ie.converter.SettingsfltWallsConverter;
import es.uah.cc.ie.converter.SettingsfltWallConverter;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;

/**
 *
 * @author tote
 */

@Path("/settingsfltWalls/")
public class SettingsfltWallsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of SettingsfltWallsResource */
    public SettingsfltWallsResource() {
    }

    /**
     * Get method for retrieving a collection of SettingsfltWall instance in XML format.
     *
     * @return an instance of SettingsfltWallsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SettingsfltWallsConverter get(@QueryParam("start")
                                         @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM SettingsfltWall e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SettingsfltWallsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of SettingsfltWall using XML as the input format.
     *
     * @param data an SettingsfltWallConverter entity that is deserialized from an XML stream
     * @return an instance of SettingsfltWallConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(SettingsfltWallConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            SettingsfltWall entity = data.resolveEntity(em);
            entity.setLastCheck(new Date());
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getUserSettingsUid() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of SettingsfltWallResource used for entity navigation.
     *
     * @return an instance of SettingsfltWallResource
     */
    @Path("{userSettingsUid}/")
    public SettingsfltWallResource getSettingsfltWallResource(@PathParam("userSettingsUid")
    String id) {
        SettingsfltWallResource settingsfltWallResource = resourceContext.getResource(SettingsfltWallResource.class);
        settingsfltWallResource.setId(id);
        return settingsfltWallResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of SettingsfltWall instances
     */
    protected Collection<SettingsfltWall> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(SettingsfltWall entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (SettingsAngels value : entity.getSettingsAngelsCollection()) {
            value.getSettingsfltWallCollection().add(entity);
        }
        UserSettings userSettings = entity.getUserSettings();
        if (userSettings != null) {
            userSettings.setSettingsfltWall(entity);
        }
    }
}
