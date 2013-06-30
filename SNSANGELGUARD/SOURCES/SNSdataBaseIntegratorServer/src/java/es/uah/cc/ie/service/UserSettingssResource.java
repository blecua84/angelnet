/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.UserSettings;
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
import es.uah.cc.ie.persistence.LocaleSettings;
import es.uah.cc.ie.persistence.SettingsAngels;
import es.uah.cc.ie.persistence.SettingsfltWall;
import es.uah.cc.ie.persistence.SettingsfltPriv;
import es.uah.cc.ie.persistence.SettingsfltFriends;
import es.uah.cc.ie.persistence.SettingsfltVist;
import es.uah.cc.ie.converter.UserSettingssConverter;
import es.uah.cc.ie.converter.UserSettingsConverter;
import com.sun.jersey.api.core.ResourceContext;
import es.uah.cc.ie.persistence.User;
import java.util.Date;

/**
 *
 * @author tote
 */
@Path("/userSettingss/")
public class UserSettingssResource {

    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;

    /** Creates a new instance of UserSettingssResource */
    public UserSettingssResource() {
    }

    /**
     * Get method for retrieving a collection of UserSettings instance in XML format.
     *
     * @return an instance of UserSettingssConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public UserSettingssConverter get(@QueryParam("start")
            @DefaultValue("0") int start, @QueryParam("max")
            @DefaultValue("10") int max, @QueryParam("expandLevel")
            @DefaultValue("1") int expandLevel, @QueryParam("query")
            @DefaultValue("SELECT e FROM UserSettings e") String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new UserSettingssConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of UserSettings using XML as the input format.
     *
     * @param data an UserSettingsConverter entity that is deserialized from an XML stream
     * @return an instance of UserSettingsConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(UserSettingsConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            UserSettings entity = data.resolveEntity(em);
            entity.setLastCheck(new Date());
            entity.setBackupCheck(new Date());
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getUid() + "/")).build();
        } finally {
            persistenceSvc.close();
        }

    }

    /**
     * Returns a dynamic instance of UserSettingsResource used for entity navigation.
     *
     * @return an instance of UserSettingsResource
     */
    @Path("{uid}/")
    public UserSettingsResource getUserSettingsResource(@PathParam("uid") String id) {
        UserSettingsResource userSettingsResource = resourceContext.getResource(UserSettingsResource.class);
        userSettingsResource.setId(id);
        return userSettingsResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of UserSettings instances
     */
    protected Collection<UserSettings> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(UserSettings entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (SettingsAngels value : entity.getSettingsAngelsCollection()) {
            value.getUserSettingsCollection().add(entity);
        }
        LocaleSettings localeSettings = entity.getLocaleSettings();
        if (localeSettings != null) {
            localeSettings.getUserSettingsCollection().add(entity);
        }
        SettingsfltFriends settingsfltFriends = entity.getSettingsfltFriends();
        if (settingsfltFriends != null) {
            settingsfltFriends.setUserSettings(entity);
        }
        SettingsfltPriv settingsfltPriv = entity.getSettingsfltPriv();
        if (settingsfltPriv != null) {
            settingsfltPriv.setUserSettings(entity);
        }
        SettingsfltWall settingsfltWall = entity.getSettingsfltWall();
        if (settingsfltWall != null) {
            settingsfltWall.setUserSettings(entity);
        }
        SettingsfltVist settingsfltVist = entity.getSettingsfltVist();
        if (settingsfltVist != null) {
            settingsfltVist.setUserSettings(entity);
        }
        User user = entity.getUser();
        if (user != null) {
            user.setUserSettings(entity);
        }
    }
}
