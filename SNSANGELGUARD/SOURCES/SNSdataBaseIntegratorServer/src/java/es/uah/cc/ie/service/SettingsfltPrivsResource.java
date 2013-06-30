/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SettingsfltPriv;
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
import es.uah.cc.ie.converter.SettingsfltPrivsConverter;
import es.uah.cc.ie.converter.SettingsfltPrivConverter;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;

/**
 *
 * @author tote
 */

@Path("/settingsfltPrivs/")
public class SettingsfltPrivsResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of SettingsfltPrivsResource */
    public SettingsfltPrivsResource() {
    }

    /**
     * Get method for retrieving a collection of SettingsfltPriv instance in XML format.
     *
     * @return an instance of SettingsfltPrivsConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SettingsfltPrivsConverter get(@QueryParam("start")
                                         @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM SettingsfltPriv e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SettingsfltPrivsConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of SettingsfltPriv using XML as the input format.
     *
     * @param data an SettingsfltPrivConverter entity that is deserialized from an XML stream
     * @return an instance of SettingsfltPrivConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(SettingsfltPrivConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            SettingsfltPriv entity = data.resolveEntity(em);
            entity.setLastCheck(new Date());
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getUserSettingsUid() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of SettingsfltPrivResource used for entity navigation.
     *
     * @return an instance of SettingsfltPrivResource
     */
    @Path("{userSettingsUid}/")
    public SettingsfltPrivResource getSettingsfltPrivResource(@PathParam("userSettingsUid")
    String id) {
        SettingsfltPrivResource settingsfltPrivResource = resourceContext.getResource(SettingsfltPrivResource.class);
        settingsfltPrivResource.setId(id);
        return settingsfltPrivResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of SettingsfltPriv instances
     */
    protected Collection<SettingsfltPriv> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(SettingsfltPriv entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (SettingsAngels value : entity.getSettingsAngelsCollection()) {
            value.getSettingsfltPrivCollection().add(entity);
        }
        UserSettings userSettings = entity.getUserSettings();
        if (userSettings != null) {
            userSettings.setSettingsfltPriv(entity);
        }
    }
}
