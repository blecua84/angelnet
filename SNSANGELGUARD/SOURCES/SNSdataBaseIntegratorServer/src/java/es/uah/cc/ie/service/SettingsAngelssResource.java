/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SettingsAngels;
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
import es.uah.cc.ie.persistence.UserSettings;
import es.uah.cc.ie.persistence.SettingsfltWall;
import es.uah.cc.ie.persistence.SettingsfltPriv;
import es.uah.cc.ie.persistence.SettingsfltFriends;
import es.uah.cc.ie.persistence.SettingsfltVist;
import es.uah.cc.ie.converter.SettingsAngelssConverter;
import es.uah.cc.ie.converter.SettingsAngelsConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/settingsAngelss/")
public class SettingsAngelssResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of SettingsAngelssResource */
    public SettingsAngelssResource() {
    }

    /**
     * Get method for retrieving a collection of SettingsAngels instance in XML format.
     *
     * @return an instance of SettingsAngelssConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SettingsAngelssConverter get(@QueryParam("start")
                                        @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM SettingsAngels e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SettingsAngelssConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of SettingsAngels using XML as the input format.
     *
     * @param data an SettingsAngelsConverter entity that is deserialized from an XML stream
     * @return an instance of SettingsAngelsConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(SettingsAngelsConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            SettingsAngels entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getUidAngel() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of SettingsAngelsResource used for entity navigation.
     *
     * @return an instance of SettingsAngelsResource
     */
    @Path("{uidAngel}/")
    public SettingsAngelsResource getSettingsAngelsResource(@PathParam("uidAngel")
    Integer id) {
        SettingsAngelsResource settingsAngelsResource = resourceContext.getResource(SettingsAngelsResource.class);
        settingsAngelsResource.setId(id);
        return settingsAngelsResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of SettingsAngels instances
     */
    protected Collection<SettingsAngels> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(SettingsAngels entity) {
        entity.setUidAngel(null);
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (SettingsfltVist value : entity.getSettingsfltVistCollection()) {
            value.getSettingsAngelsCollection().add(entity);
        }
        for (SettingsfltWall value : entity.getSettingsfltWallCollection()) {
            value.getSettingsAngelsCollection().add(entity);
        }
        for (SettingsfltPriv value : entity.getSettingsfltPrivCollection()) {
            value.getSettingsAngelsCollection().add(entity);
        }
        for (UserSettings value : entity.getUserSettingsCollection()) {
            value.getSettingsAngelsCollection().add(entity);
        }
        for (SettingsfltFriends value : entity.getSettingsfltFriendsCollection()) {
            value.getSettingsAngelsCollection().add(entity);
        }
    }
}
