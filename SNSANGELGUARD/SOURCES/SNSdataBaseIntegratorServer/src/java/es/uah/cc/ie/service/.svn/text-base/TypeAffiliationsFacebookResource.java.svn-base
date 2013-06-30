/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.service;

import es.uah.cc.ie.persistence.TypeAffiliationsFacebook;
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
import es.uah.cc.ie.persistence.AffiliationsFacebook;
import java.util.Collection;
import es.uah.cc.ie.converter.TypeAffiliationsFacebookConverter;
import com.sun.jersey.api.core.ResourceContext;

/**
 *
 * @author tote
 */

public class TypeAffiliationsFacebookResource {
    @Context
    protected ResourceContext resourceContext;
    @Context
    protected UriInfo uriInfo;
    protected Integer id;
  
    /** Creates a new instance of TypeAffiliationsFacebookResource */
    public TypeAffiliationsFacebookResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Get method for retrieving an instance of TypeAffiliationsFacebook identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of TypeAffiliationsFacebookConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public TypeAffiliationsFacebookConverter get(@QueryParam("expandLevel")
                                                 @DefaultValue("1")
    int expandLevel) {
        PersistenceService persistenceSvc = PersistenceService.getInstance();
        try {
            persistenceSvc.beginTx();
            return new TypeAffiliationsFacebookConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
        } finally {
            PersistenceService.getInstance().close();
        }
    }

    /**
     * Put method for updating an instance of TypeAffiliationsFacebook identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an TypeAffiliationsFacebookConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(TypeAffiliationsFacebookConverter data) {
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
     * Delete method for deleting an instance of TypeAffiliationsFacebook identified by id.
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
     * Returns an instance of TypeAffiliationsFacebook identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of TypeAffiliationsFacebook
     */
    protected TypeAffiliationsFacebook getEntity() {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        try {
            return (TypeAffiliationsFacebook) em.createQuery("SELECT e FROM TypeAffiliationsFacebook e where e.idTypeAffiliationsFacebook = :idTypeAffiliationsFacebook").setParameter("idTypeAffiliationsFacebook", id).getSingleResult();
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
    private TypeAffiliationsFacebook updateEntity(TypeAffiliationsFacebook entity, TypeAffiliationsFacebook newEntity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        Collection<AffiliationsFacebook> affiliationsFacebookCollection = entity.getAffiliationsFacebookCollection();
        Collection<AffiliationsFacebook> affiliationsFacebookCollectionNew = newEntity.getAffiliationsFacebookCollection();
        entity = em.merge(newEntity);
        for (AffiliationsFacebook value : affiliationsFacebookCollection) {
            if (!affiliationsFacebookCollectionNew.contains(value)) {
                throw new WebApplicationException(new Throwable("Cannot remove items from affiliationsFacebookCollection"));
            }
        }
        for (AffiliationsFacebook value : affiliationsFacebookCollectionNew) {
            if (!affiliationsFacebookCollection.contains(value)) {
                TypeAffiliationsFacebook oldEntity = value.getTypeAffiliationsFacebook();
                value.setTypeAffiliationsFacebook(entity);
                if (oldEntity != null && !oldEntity.equals(entity)) {
                    oldEntity.getAffiliationsFacebookCollection().remove(value);
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
    private void deleteEntity(TypeAffiliationsFacebook entity) {
        EntityManager em = PersistenceService.getInstance().getEntityManager();
        if (!entity.getAffiliationsFacebookCollection().isEmpty()) {
            throw new WebApplicationException(new Throwable("Cannot delete entity because affiliationsFacebookCollection is not empty."));
        }
        em.remove(entity);
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

    public static class AffiliationsFacebookCollectionResourceSub extends AffiliationsFacebooksResource {

        private TypeAffiliationsFacebook parent;

        public void setParent(TypeAffiliationsFacebook parent) {
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
}
