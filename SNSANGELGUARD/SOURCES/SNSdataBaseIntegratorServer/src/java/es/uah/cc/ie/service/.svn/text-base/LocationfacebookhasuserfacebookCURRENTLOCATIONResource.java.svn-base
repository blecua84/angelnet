/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATION;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.WebApplicationException;
import javax.persistence.NoResultException;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.LocationFacebook;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.LocationfacebookhasuserfacebookCURRENTLOCATIONConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class LocationfacebookhasuserfacebookCURRENTLOCATIONResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected String id2;
    protected Integer id1;
  
    /** Creates a new instance of LocationfacebookhasuserfacebookCURRENTLOCATIONResource */
    public LocationfacebookhasuserfacebookCURRENTLOCATIONResource() {
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    /**
     * Get method for retrieving an instance of LocationfacebookhasuserfacebookCURRENTLOCATION identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of LocationfacebookhasuserfacebookCURRENTLOCATIONConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public LocationfacebookhasuserfacebookCURRENTLOCATIONConverter get(@QueryParam("expandLevel")
                                                                       @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new LocationfacebookhasuserfacebookCURRENTLOCATIONConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of LocationfacebookhasuserfacebookCURRENTLOCATION identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an LocationfacebookhasuserfacebookCURRENTLOCATIONConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(LocationfacebookhasuserfacebookCURRENTLOCATIONConverter data) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            EntityManager em = persistenceSvc.getEntityManager();
            updateEntity(getEntity(), data.resolveEntity(em));
            persistenceSvc.commitTx();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Delete method for deleting an instance of LocationfacebookhasuserfacebookCURRENTLOCATION identified by id.
     *
     * @param id identifier for the entity
     */
    @DELETE
    public void delete() {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            deleteEntity(getEntity());
            persistenceSvc.commitTx();
        } finally {
            persistenceSvc.close();
        }
    }

    /**
     * Returns an instance of LocationfacebookhasuserfacebookCURRENTLOCATION identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of LocationfacebookhasuserfacebookCURRENTLOCATION
     */
    protected LocationfacebookhasuserfacebookCURRENTLOCATION getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATIONPK id = new es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATIONPK(id1, id2);
            return (LocationfacebookhasuserfacebookCURRENTLOCATION) em.createQuery("SELECT e FROM LocationfacebookhasuserfacebookCURRENTLOCATION e where e.locationfacebookhasuserfacebookCURRENTLOCATIONPK = :locationfacebookhasuserfacebookCURRENTLOCATIONPK").setParameter("locationfacebookhasuserfacebookCURRENTLOCATIONPK", id).getSingleResult();
        } catch (NoResultException ex) {
            throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
        }
    }

    /**
     * Updates entity using data from newEntity.
     *
     * @param entity the entity to update
     * @param newEntity the entity containing the new data
     * @return the updated entity
     */
    private LocationfacebookhasuserfacebookCURRENTLOCATION updateEntity(LocationfacebookhasuserfacebookCURRENTLOCATION entity, LocationfacebookhasuserfacebookCURRENTLOCATION newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserFacebook userFacebook = entity.getUserFacebook();
        UserFacebook userFacebookNew = newEntity.getUserFacebook();
        LocationFacebook locationFacebook = entity.getLocationFacebook();
        LocationFacebook locationFacebookNew = newEntity.getLocationFacebook();
        entity = em.merge(newEntity);
        if (userFacebook != null && !userFacebook.equals(userFacebookNew)) {
            userFacebook.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().remove(entity);
        }
        if (userFacebookNew != null && !userFacebookNew.equals(userFacebook)) {
            userFacebookNew.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().add(entity);
        }
        if (locationFacebook != null && !locationFacebook.equals(locationFacebookNew)) {
            locationFacebook.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().remove(entity);
        }
        if (locationFacebookNew != null && !locationFacebookNew.equals(locationFacebook)) {
            locationFacebookNew.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(LocationfacebookhasuserfacebookCURRENTLOCATION entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            userFacebook.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().remove(entity);
        }
        LocationFacebook locationFacebook = entity.getLocationFacebook();
        if (locationFacebook != null) {
            locationFacebook.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().remove(entity);
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of UserFacebookResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of UserFacebookResource
     */
    @Path("userFacebook/")
    public UserFacebookResource getUserFacebookResource() {
        UserFacebookResourceSub userFacebookResourceSub = resourceContext.getResource(UserFacebookResourceSub.class);
        userFacebookResourceSub.setParent(getEntity());
        return userFacebookResourceSub;
    }

    /**
     * Returns a dynamic instance of LocationFacebookResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of LocationFacebookResource
     */
    @Path("locationFacebook/")
    public LocationFacebookResource getLocationFacebookResource() {
        LocationFacebookResourceSub locationFacebookResourceSub = resourceContext.getResource(LocationFacebookResourceSub.class);
        locationFacebookResourceSub.setParent(getEntity());
        return locationFacebookResourceSub;
    }

    public static class UserFacebookResourceSub extends UserFacebookResource {

        private LocationfacebookhasuserfacebookCURRENTLOCATION parent;

        public void setParent(LocationfacebookhasuserfacebookCURRENTLOCATION parent) {
            this.parent = parent;
        }

        @Override
        protected UserFacebook getEntity() {
            UserFacebook entity = parent.getUserFacebook();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }

    public static class LocationFacebookResourceSub extends LocationFacebookResource {

        private LocationfacebookhasuserfacebookCURRENTLOCATION parent;

        public void setParent(LocationfacebookhasuserfacebookCURRENTLOCATION parent) {
            this.parent = parent;
        }

        @Override
        protected LocationFacebook getEntity() {
            LocationFacebook entity = parent.getLocationFacebook();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }
}
