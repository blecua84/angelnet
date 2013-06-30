/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.AffiliationsFacebook;
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
import es.uah.cc.ie.persistence.TypeAffiliationsFacebook;
import es.uah.cc.ie.persistence.UserFacebook;
import es.uah.cc.ie.converter.AffiliationsFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class AffiliationsFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of AffiliationsFacebookResource */
    public AffiliationsFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of AffiliationsFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of AffiliationsFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public AffiliationsFacebookConverter get(@QueryParam("expandLevel")
                                             @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new AffiliationsFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of AffiliationsFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an AffiliationsFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(AffiliationsFacebookConverter data) {
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
     * Delete method for deleting an instance of AffiliationsFacebook identified by id.
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
     * Returns an instance of AffiliationsFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of AffiliationsFacebook
     */
    protected AffiliationsFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (AffiliationsFacebook) em.createQuery("SELECT e FROM AffiliationsFacebook e where e.idAffiliationsFacebook = :idAffiliationsFacebook").setParameter("idAffiliationsFacebook", id).getSingleResult();
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
    private AffiliationsFacebook updateEntity(AffiliationsFacebook entity, AffiliationsFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserFacebook userFacebook = entity.getUserFacebook();
        UserFacebook userFacebookNew = newEntity.getUserFacebook();
        TypeAffiliationsFacebook typeAffiliationsFacebook = entity.getTypeAffiliationsFacebook();
        TypeAffiliationsFacebook typeAffiliationsFacebookNew = newEntity.getTypeAffiliationsFacebook();
        entity = em.merge(newEntity);
        if (userFacebook != null && !userFacebook.equals(userFacebookNew)) {
            userFacebook.getAffiliationsFacebookCollection().remove(entity);
        }
        if (userFacebookNew != null && !userFacebookNew.equals(userFacebook)) {
            userFacebookNew.getAffiliationsFacebookCollection().add(entity);
        }
        if (typeAffiliationsFacebook != null && !typeAffiliationsFacebook.equals(typeAffiliationsFacebookNew)) {
            typeAffiliationsFacebook.getAffiliationsFacebookCollection().remove(entity);
        }
        if (typeAffiliationsFacebookNew != null && !typeAffiliationsFacebookNew.equals(typeAffiliationsFacebook)) {
            typeAffiliationsFacebookNew.getAffiliationsFacebookCollection().add(entity);
        }
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(AffiliationsFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        UserFacebook userFacebook = entity.getUserFacebook();
        if (userFacebook != null) {
            userFacebook.getAffiliationsFacebookCollection().remove(entity);
        }
        TypeAffiliationsFacebook typeAffiliationsFacebook = entity.getTypeAffiliationsFacebook();
        if (typeAffiliationsFacebook != null) {
            typeAffiliationsFacebook.getAffiliationsFacebookCollection().remove(entity);
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
     * Returns a dynamic instance of TypeAffiliationsFacebookResource used for entity navigation.
     *
     * @param id identifier for the parent entity
     * @return an instance of TypeAffiliationsFacebookResource
     */
    @Path("typeAffiliationsFacebook/")
    public TypeAffiliationsFacebookResource getTypeAffiliationsFacebookResource() {
        TypeAffiliationsFacebookResourceSub typeAffiliationsFacebookResourceSub = resourceContext.getResource(TypeAffiliationsFacebookResourceSub.class);
        typeAffiliationsFacebookResourceSub.setParent(getEntity());
        return typeAffiliationsFacebookResourceSub;
    }

    public static class UserFacebookResourceSub extends UserFacebookResource {

        private AffiliationsFacebook parent;

        public void setParent(AffiliationsFacebook parent) {
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

    public static class TypeAffiliationsFacebookResourceSub extends TypeAffiliationsFacebookResource {

        private AffiliationsFacebook parent;

        public void setParent(AffiliationsFacebook parent) {
            this.parent = parent;
        }

        @Override
        protected TypeAffiliationsFacebook getEntity() {
            TypeAffiliationsFacebook entity = parent.getTypeAffiliationsFacebook();
            if (entity == null) {
                throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
            }
            return entity;
        }
    }
}
