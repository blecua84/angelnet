/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.SettingsfltFriends;
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
import es.uah.cc.ie.converter.SettingsfltFriendssConverter;
import es.uah.cc.ie.converter.SettingsfltFriendsConverter;
import com.sun.jersey.api.core.ResourceContext;
import java.util.Date;

/**
 *
 * @author tote
 */

@Path("/settingsfltFriendss/")
public class SettingsfltFriendssResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of SettingsfltFriendssResource */
    public SettingsfltFriendssResource() {
    }

    /**
     * Get method for retrieving a collection of SettingsfltFriends instance in XML format.
     *
     * @return an instance of SettingsfltFriendssConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public SettingsfltFriendssConverter get(@QueryParam("start")
                                            @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM SettingsfltFriends e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new SettingsfltFriendssConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of SettingsfltFriends using XML as the input format.
     *
     * @param data an SettingsfltFriendsConverter entity that is deserialized from an XML stream
     * @return an instance of SettingsfltFriendsConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(SettingsfltFriendsConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            SettingsfltFriends entity = data.resolveEntity(em);
            entity.setLastCheck(new Date());
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getUserSettingsUid() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of SettingsfltFriendsResource used for entity navigation.
     *
     * @return an instance of SettingsfltFriendsResource
     */
    @Path("{userSettingsUid}/")
    public SettingsfltFriendsResource getSettingsfltFriendsResource(@PathParam("userSettingsUid")
    String id) {
        SettingsfltFriendsResource settingsfltFriendsResource = resourceContext.getResource(SettingsfltFriendsResource.class);
        settingsfltFriendsResource.setId(id);
        return settingsfltFriendsResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of SettingsfltFriends instances
     */
    protected Collection<SettingsfltFriends> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(SettingsfltFriends entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (SettingsAngels value : entity.getSettingsAngelsCollection()) {
            value.getSettingsfltFriendsCollection().add(entity);
        }
        UserSettings userSettings = entity.getUserSettings();
        if (userSettings != null) {
            userSettings.setSettingsfltFriends(entity);
        }
    }
}
