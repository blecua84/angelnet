/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.LocationFacebook;
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
import es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATION;
import java.util.Collection;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.LocationFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class LocationFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of LocationFacebookResource */
    public LocationFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of LocationFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of LocationFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public LocationFacebookConverter get(@QueryParam("expandLevel")
                                         @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new LocationFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of LocationFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an LocationFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(LocationFacebookConverter data) {
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
     * Delete method for deleting an instance of LocationFacebook identified by id.
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
     * Returns an instance of LocationFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of LocationFacebook
     */
    protected LocationFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (LocationFacebook) em.createQuery("SELECT e FROM LocationFacebook e where e.idLocationFacebook = :idLocationFacebook").setParameter("idLocationFacebook", id).getSingleResult();
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
    private LocationFacebook updateEntity(LocationFacebook entity, LocationFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<UserFacebook> userFacebookCollection = entity.getUserFacebookCollection();
        Collection<UserFacebook> userFacebookCollectionNew = newEntity.getUserFacebookCollection();
        Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollection = entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection();
        Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollectionNew = newEntity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection();
        entity = em.merge(newEntity);
        for (UserFacebook value : userFacebookCollection) {
            if (!userFacebookCollectionNew.contains(value)) {
                value.getLocationFacebookCollection().remove(entity);
            }
        }
        for (UserFacebook value : userFacebookCollectionNew) {
            if (!userFacebookCollection.contains(value)) {
                value.getLocationFacebookCollection().add(entity);
            }
        }
        for (LocationfacebookhasuserfacebookCURRENTLOCATION value : locationfacebookhasuserfacebookCURRENTLOCATIONCollection) {
            if (!locationfacebookhasuserfacebookCURRENTLOCATIONCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from locationfacebookhasuserfacebookCURRENTLOCATIONCollection"));
            }
        }
        for (LocationfacebookhasuserfacebookCURRENTLOCATION value : locationfacebookhasuserfacebookCURRENTLOCATIONCollectionNew) {
            if (!locationfacebookhasuserfacebookCURRENTLOCATIONCollection.contains(value)) {
                LocationFacebook oldEntity = value.getLocationFacebook();
                value.setLocationFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().remove(value);
                }
            }
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(LocationFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        for (UserFacebook value : entity.getUserFacebookCollection()) {
            value.getLocationFacebookCollection().remove(entity);
        }
        if (!entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because locationfacebookhasuserfacebookCURRENTLOCATIONCollection is not empty."));
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of UserFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of UserFacebooksResource
     */
    @Path("userFacebookCollection/")
    public UserFacebooksResource getUserFacebookCollectionResource() {
        UserFacebookCollectionResourceSub userFacebookCollectionResourceSub = resourceContext.getResource(UserFacebookCollectionResourceSub.class);
        userFacebookCollectionResourceSub.setParent(getEntity());
        return userFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of LocationfacebookhasuserfacebookCURRENTLOCATIONsResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of LocationfacebookhasuserfacebookCURRENTLOCATIONsResource
     */
    @Path("locationfacebookhasuserfacebookCURRENTLOCATIONCollection/")
    public LocationfacebookhasuserfacebookCURRENTLOCATIONsResource getLocationfacebookhasuserfacebookCURRENTLOCATIONCollectionResource() {
        LocationfacebookhasuserfacebookCURRENTLOCATIONCollectionResourceSub locationfacebookhasuserfacebookCURRENTLOCATIONCollectionResourceSub = resourceContext.getResource(LocationfacebookhasuserfacebookCURRENTLOCATIONCollectionResourceSub.class);
        locationfacebookhasuserfacebookCURRENTLOCATIONCollectionResourceSub.setParent(getEntity());
        return locationfacebookhasuserfacebookCURRENTLOCATIONCollectionResourceSub;
    }

    public static class UserFacebookCollectionResourceSub extends UserFacebooksResource {

        private LocationFacebook parent;

        public void setParent(LocationFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<UserFacebook> getEntities(int start, int max, String query) {
            Collection<UserFacebook> result = new java.util.ArrayList<UserFacebook>();
            int index = 0;
            for (UserFacebook e : parent.getUserFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class LocationfacebookhasuserfacebookCURRENTLOCATIONCollectionResourceSub extends LocationfacebookhasuserfacebookCURRENTLOCATIONsResource {

        private LocationFacebook parent;

        public void setParent(LocationFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> getEntities(int start, int max, String query) {
            Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> result = new java.util.ArrayList<LocationfacebookhasuserfacebookCURRENTLOCATION>();
            int index = 0;
            for (LocationfacebookhasuserfacebookCURRENTLOCATION e : parent.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }
}
