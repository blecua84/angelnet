/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.UserFacebook;
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
import es.uah.cc.ie.persistence.WorkHistoryFacebook;
import es.uah.cc.ie.persistence.AffiliationsFacebook;
import es.uah.cc.ie.persistence.User;
import es.uah.cc.ie.persistence.LocationFacebook;
import es.uah.cc.ie.persistence.StreamFacebook;
import es.uah.cc.ie.persistence.FamilyFacebook;
import es.uah.cc.ie.persistence.EducationHistoryFacebook;
import es.uah.cc.ie.persistence.FriendsFacebook;
import es.uah.cc.ie.persistence.LocationfacebookhasuserfacebookCURRENTLOCATION;
import java.util.Collection;
import es.uah.cc.ie.converter.UserFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class UserFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected String id;
  
    /** Creates a new instance of UserFacebookResource */
    public UserFacebookResource() {
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of UserFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of UserFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public UserFacebookConverter get(@QueryParam("expandLevel")
                                     @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new UserFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of UserFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an UserFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(UserFacebookConverter data) {
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
     * Delete method for deleting an instance of UserFacebook identified by id.
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
     * Returns an instance of UserFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of UserFacebook
     */
    protected UserFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (UserFacebook) em.createQuery("SELECT e FROM UserFacebook e where e.idUserFacebook = :idUserFacebook").setParameter("idUserFacebook", id).getSingleResult();
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
    private UserFacebook updateEntity(UserFacebook entity, UserFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<LocationFacebook> locationFacebookCollection = entity.getLocationFacebookCollection();
        Collection<LocationFacebook> locationFacebookCollectionNew = newEntity.getLocationFacebookCollection();
        Collection<FamilyFacebook> familyFacebookCollection = entity.getFamilyFacebookCollection();
        Collection<FamilyFacebook> familyFacebookCollectionNew = newEntity.getFamilyFacebookCollection();
        Collection<FriendsFacebook> friendsFacebookCollection = entity.getFriendsFacebookCollection();
        Collection<FriendsFacebook> friendsFacebookCollectionNew = newEntity.getFriendsFacebookCollection();
        Collection<StreamFacebook> streamFacebookCollection = entity.getStreamFacebookCollection();
        Collection<StreamFacebook> streamFacebookCollectionNew = newEntity.getStreamFacebookCollection();
        Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollection = entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection();
        Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollectionNew = newEntity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection();
        Collection<AffiliationsFacebook> affiliationsFacebookCollection = entity.getAffiliationsFacebookCollection();
        Collection<AffiliationsFacebook> affiliationsFacebookCollectionNew = newEntity.getAffiliationsFacebookCollection();
        Collection<EducationHistoryFacebook> educationHistoryFacebookCollection = entity.getEducationHistoryFacebookCollection();
        Collection<EducationHistoryFacebook> educationHistoryFacebookCollectionNew = newEntity.getEducationHistoryFacebookCollection();
        Collection<WorkHistoryFacebook> workHistoryFacebookCollection = entity.getWorkHistoryFacebookCollection();
        Collection<WorkHistoryFacebook> workHistoryFacebookCollectionNew = newEntity.getWorkHistoryFacebookCollection();
        Collection<User> userCollection = entity.getUserCollection();
        Collection<User> userCollectionNew = newEntity.getUserCollection();
        entity = em.merge(newEntity);
        for (LocationFacebook value : locationFacebookCollection) {
            if (!locationFacebookCollectionNew.contains(value)) {
                value.getUserFacebookCollection().remove(entity);
            }
        }
        for (LocationFacebook value : locationFacebookCollectionNew) {
            if (!locationFacebookCollection.contains(value)) {
                value.getUserFacebookCollection().add(entity);
            }
        }
        for (FamilyFacebook value : familyFacebookCollection) {
            if (!familyFacebookCollectionNew.contains(value)) {
                value.getUserFacebookCollection().remove(entity);
            }
        }
        for (FamilyFacebook value : familyFacebookCollectionNew) {
            if (!familyFacebookCollection.contains(value)) {
                value.getUserFacebookCollection().add(entity);
            }
        }
        for (FriendsFacebook value : friendsFacebookCollection) {
            if (!friendsFacebookCollectionNew.contains(value)) {
                value.getUserFacebookCollection().remove(entity);
            }
        }
        for (FriendsFacebook value : friendsFacebookCollectionNew) {
            if (!friendsFacebookCollection.contains(value)) {
                value.getUserFacebookCollection().add(entity);
            }
        }
        for (StreamFacebook value : streamFacebookCollection) {
            if (!streamFacebookCollectionNew.contains(value)) {
                value.getUserFacebookCollection().remove(entity);
            }
        }
        for (StreamFacebook value : streamFacebookCollectionNew) {
            if (!streamFacebookCollection.contains(value)) {
                value.getUserFacebookCollection().add(entity);
            }
        }
        for (LocationfacebookhasuserfacebookCURRENTLOCATION value : locationfacebookhasuserfacebookCURRENTLOCATIONCollection) {
            if (!locationfacebookhasuserfacebookCURRENTLOCATIONCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from locationfacebookhasuserfacebookCURRENTLOCATIONCollection"));
            }
        }
        for (LocationfacebookhasuserfacebookCURRENTLOCATION value : locationfacebookhasuserfacebookCURRENTLOCATIONCollectionNew) {
            if (!locationfacebookhasuserfacebookCURRENTLOCATIONCollection.contains(value)) {
                UserFacebook oldEntity = value.getUserFacebook();
                value.setUserFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().remove(value);
                }
            }
        }
        for (AffiliationsFacebook value : affiliationsFacebookCollection) {
            if (!affiliationsFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from affiliationsFacebookCollection"));
            }
        }
        for (AffiliationsFacebook value : affiliationsFacebookCollectionNew) {
            if (!affiliationsFacebookCollection.contains(value)) {
                UserFacebook oldEntity = value.getUserFacebook();
                value.setUserFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getAffiliationsFacebookCollection().remove(value);
                }
            }
        }
        for (EducationHistoryFacebook value : educationHistoryFacebookCollection) {
            if (!educationHistoryFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from educationHistoryFacebookCollection"));
            }
        }
        for (EducationHistoryFacebook value : educationHistoryFacebookCollectionNew) {
            if (!educationHistoryFacebookCollection.contains(value)) {
                UserFacebook oldEntity = value.getUserFacebook();
                value.setUserFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getEducationHistoryFacebookCollection().remove(value);
                }
            }
        }
        for (WorkHistoryFacebook value : workHistoryFacebookCollection) {
            if (!workHistoryFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from workHistoryFacebookCollection"));
            }
        }
        for (WorkHistoryFacebook value : workHistoryFacebookCollectionNew) {
            if (!workHistoryFacebookCollection.contains(value)) {
                UserFacebook oldEntity = value.getUserFacebook();
                value.setUserFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getWorkHistoryFacebookCollection().remove(value);
                }
            }
        }
 /*       for (User value : userCollection) {
            if (!userCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from userCollection"));
            }
        }
        for (User value : userCollectionNew) {
            if (!userCollection.contains(value)) {
                UserFacebook oldEntity = value.getUserFacebook();
                value.setUserFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getUserCollection().remove(value);
                }
            }
        }*/
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(UserFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        for (LocationFacebook value : entity.getLocationFacebookCollection()) {
            value.getUserFacebookCollection().remove(entity);
        }
        for (FamilyFacebook value : entity.getFamilyFacebookCollection()) {
            value.getUserFacebookCollection().remove(entity);
        }
        for (FriendsFacebook value : entity.getFriendsFacebookCollection()) {
            value.getUserFacebookCollection().remove(entity);
        }
        for (StreamFacebook value : entity.getStreamFacebookCollection()) {
            value.getUserFacebookCollection().remove(entity);
        }
        if (!entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because locationfacebookhasuserfacebookCURRENTLOCATIONCollection is not empty."));
        }
        if (!entity.getAffiliationsFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because affiliationsFacebookCollection is not empty."));
        }
        if (!entity.getEducationHistoryFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because educationHistoryFacebookCollection is not empty."));
        }
        if (!entity.getWorkHistoryFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because workHistoryFacebookCollection is not empty."));
        }
        if (!entity.getUserCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because userCollection is not empty."));
        }
        em.remove(entity);
    }

    /**
     * Returns a dynamic instance of LocationFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of LocationFacebooksResource
     */
    @Path("locationFacebookCollection/")
    public LocationFacebooksResource getLocationFacebookCollectionResource() {
        LocationFacebookCollectionResourceSub locationFacebookCollectionResourceSub = resourceContext.getResource(LocationFacebookCollectionResourceSub.class);
        locationFacebookCollectionResourceSub.setParent(getEntity());
        return locationFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of FamilyFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of FamilyFacebooksResource
     */
    @Path("familyFacebookCollection/")
    public FamilyFacebooksResource getFamilyFacebookCollectionResource() {
        FamilyFacebookCollectionResourceSub familyFacebookCollectionResourceSub = resourceContext.getResource(FamilyFacebookCollectionResourceSub.class);
        familyFacebookCollectionResourceSub.setParent(getEntity());
        return familyFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of FriendsFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of FriendsFacebooksResource
     */
    @Path("friendsFacebookCollection/")
    public FriendsFacebooksResource getFriendsFacebookCollectionResource() {
        FriendsFacebookCollectionResourceSub friendsFacebookCollectionResourceSub = resourceContext.getResource(FriendsFacebookCollectionResourceSub.class);
        friendsFacebookCollectionResourceSub.setParent(getEntity());
        return friendsFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of StreamFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of StreamFacebooksResource
     */
    @Path("streamFacebookCollection/")
    public StreamFacebooksResource getStreamFacebookCollectionResource() {
        StreamFacebookCollectionResourceSub streamFacebookCollectionResourceSub = resourceContext.getResource(StreamFacebookCollectionResourceSub.class);
        streamFacebookCollectionResourceSub.setParent(getEntity());
        return streamFacebookCollectionResourceSub;
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

    /**
     * Returns a dynamic instance of AffiliationsFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of AffiliationsFacebooksResource
     */
    @Path("affiliationsFacebookCollection/")
    public AffiliationsFacebooksResource getAffiliationsFacebookCollectionResource() {
        AffiliationsFacebookCollectionResourceSub affiliationsFacebookCollectionResourceSub = resourceContext.getResource(AffiliationsFacebookCollectionResourceSub.class);
        affiliationsFacebookCollectionResourceSub.setParent(getEntity());
        return affiliationsFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of EducationHistoryFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of EducationHistoryFacebooksResource
     */
    @Path("educationHistoryFacebookCollection/")
    public EducationHistoryFacebooksResource getEducationHistoryFacebookCollectionResource() {
        EducationHistoryFacebookCollectionResourceSub educationHistoryFacebookCollectionResourceSub = resourceContext.getResource(EducationHistoryFacebookCollectionResourceSub.class);
        educationHistoryFacebookCollectionResourceSub.setParent(getEntity());
        return educationHistoryFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of WorkHistoryFacebooksResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of WorkHistoryFacebooksResource
     */
    @Path("workHistoryFacebookCollection/")
    public WorkHistoryFacebooksResource getWorkHistoryFacebookCollectionResource() {
        WorkHistoryFacebookCollectionResourceSub workHistoryFacebookCollectionResourceSub = resourceContext.getResource(WorkHistoryFacebookCollectionResourceSub.class);
        workHistoryFacebookCollectionResourceSub.setParent(getEntity());
        return workHistoryFacebookCollectionResourceSub;
    }

    /**
     * Returns a dynamic instance of UsersResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of UsersResource
     */
    @Path("userCollection/")
    public UsersResource getUserCollectionResource() {
        UserCollectionResourceSub userCollectionResourceSub = resourceContext.getResource(UserCollectionResourceSub.class);
        userCollectionResourceSub.setParent(getEntity());
        return userCollectionResourceSub;
    }

    public static class LocationFacebookCollectionResourceSub extends LocationFacebooksResource {

        private UserFacebook parent;

        public void setParent(UserFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<LocationFacebook> getEntities(int start, int max, String query) {
            Collection<LocationFacebook> result = new java.util.ArrayList<LocationFacebook>();
            int index = 0;
            for (LocationFacebook e : parent.getLocationFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class FamilyFacebookCollectionResourceSub extends FamilyFacebooksResource {

        private UserFacebook parent;

        public void setParent(UserFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<FamilyFacebook> getEntities(int start, int max, String query) {
            Collection<FamilyFacebook> result = new java.util.ArrayList<FamilyFacebook>();
            int index = 0;
            for (FamilyFacebook e : parent.getFamilyFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class FriendsFacebookCollectionResourceSub extends FriendsFacebooksResource {

        private UserFacebook parent;

        public void setParent(UserFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<FriendsFacebook> getEntities(int start, int max, String query) {
            Collection<FriendsFacebook> result = new java.util.ArrayList<FriendsFacebook>();
            int index = 0;
            for (FriendsFacebook e : parent.getFriendsFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class StreamFacebookCollectionResourceSub extends StreamFacebooksResource {

        private UserFacebook parent;

        public void setParent(UserFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<StreamFacebook> getEntities(int start, int max, String query) {
            Collection<StreamFacebook> result = new java.util.ArrayList<StreamFacebook>();
            int index = 0;
            for (StreamFacebook e : parent.getStreamFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class LocationfacebookhasuserfacebookCURRENTLOCATIONCollectionResourceSub extends LocationfacebookhasuserfacebookCURRENTLOCATIONsResource {

        private UserFacebook parent;

        public void setParent(UserFacebook parent) {
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

    public static class AffiliationsFacebookCollectionResourceSub extends AffiliationsFacebooksResource {

        private UserFacebook parent;

        public void setParent(UserFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<AffiliationsFacebook> getEntities(int start, int max, String query) {
            Collection<AffiliationsFacebook> result = new java.util.ArrayList<AffiliationsFacebook>();
            int index = 0;
            for (AffiliationsFacebook e : parent.getAffiliationsFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class EducationHistoryFacebookCollectionResourceSub extends EducationHistoryFacebooksResource {

        private UserFacebook parent;

        public void setParent(UserFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<EducationHistoryFacebook> getEntities(int start, int max, String query) {
            Collection<EducationHistoryFacebook> result = new java.util.ArrayList<EducationHistoryFacebook>();
            int index = 0;
            for (EducationHistoryFacebook e : parent.getEducationHistoryFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class WorkHistoryFacebookCollectionResourceSub extends WorkHistoryFacebooksResource {

        private UserFacebook parent;

        public void setParent(UserFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<WorkHistoryFacebook> getEntities(int start, int max, String query) {
            Collection<WorkHistoryFacebook> result = new java.util.ArrayList<WorkHistoryFacebook>();
            int index = 0;
            for (WorkHistoryFacebook e : parent.getWorkHistoryFacebookCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }

    public static class UserCollectionResourceSub extends UsersResource {

        private UserFacebook parent;

        public void setParent(UserFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected Collection<User> getEntities(int start, int max, String query) {
            Collection<User> result = new java.util.ArrayList<User>();
            int index = 0;
            for (User e : parent.getUserCollection()) {
                if (index >= start && (index - start) < max) {
                    result.add(e);
                }
                index++;
            }
            return result;
        }
    }
}
