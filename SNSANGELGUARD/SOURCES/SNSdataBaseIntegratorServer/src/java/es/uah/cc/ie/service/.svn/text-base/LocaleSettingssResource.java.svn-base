/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.LocaleSettings;
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
import es.uah.cc.ie.converter.LocaleSettingssConverter;
import es.uah.cc.ie.converter.LocaleSettingsConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

@Path("/localeSettingss/")
public class LocaleSettingssResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
  
    /** Creates a new instance of LocaleSettingssResource */
    public LocaleSettingssResource() {
    }

    /**
     * Get method for retrieving a collection of LocaleSettings instance in XML format.
     *
     * @return an instance of LocaleSettingssConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public LocaleSettingssConverter get(@QueryParam("start")
                                        @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM LocaleSettings e")
    String query) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new LocaleSettingssConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            persistenceSvc.commitTx();
            persistenceSvc.close();
        }
    }

    /**
     * Post method for creating an instance of LocaleSettings using XML as the input format.
     *
     * @param data an LocaleSettingsConverter entity that is deserialized from an XML stream
     * @return an instance of LocaleSettingsConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(LocaleSettingsConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            LocaleSettings entity = data.resolveEntity(em);
            createEntity(data.resolveEntity(em));
            persistenceSvc.commitTx();
            return Response.created(uriInfo.getAbsolutePath().resolve(entity.getIdLocale() + "/")).build();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns a dynamic instance of LocaleSettingsResource used for entity navigation.
     *
     * @return an instance of LocaleSettingsResource
     */
    @Path("{idLocale}/")
    public LocaleSettingsResource getLocaleSettingsResource(@PathParam("idLocale")
    String id) {
        LocaleSettingsResource localeSettingsResource = resourceContext.getResource(LocaleSettingsResource.class);
        localeSettingsResource.setId(id);
        return localeSettingsResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of LocaleSettings instances
     */
    protected Collection<LocaleSettings> getEntities(int start, int max, String query) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(LocaleSettings entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        em.persist(entity);
        for (UserSettings value : entity.getUserSettingsCollection()) {
            LocaleSettings oldEntity = value.getLocaleSettings();
            value.setLocaleSettings(entity);
            if (oldEntity != null) {
                oldEntity.getUserSettingsCollection().remove(value);
            }
        }
    }
}
