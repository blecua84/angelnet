/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.UseropenSocial;
import java.net.URI;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.User;
import java.util.Collection;

/**
 *
 * @author tote
 */

@XmlRootElement(name = "useropenSocial")
public class UseropenSocialConverter {
    private UseropenSocial entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of UseropenSocialConverter */
    public UseropenSocialConverter() {
        entity = new UseropenSocial();
    }

    /**
     * Creates a new instance of UseropenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public UseropenSocialConverter(UseropenSocial entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIduseropenSocial() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserCollection();
    }

    /**
     * Creates a new instance of UseropenSocialConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public UseropenSocialConverter(UseropenSocial entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for iduseropenSocial.
     *
     * @return value for iduseropenSocial
     */
    @XmlElement
    public String getIduseropenSocial() {
        return (expandLevel > 0) ? entity.getIduseropenSocial() : null;
    }

    /**
     * Setter for iduseropenSocial.
     *
     * @param value the value to set
     */
    public void setIduseropenSocial(String value) {
        entity.setIduseropenSocial(value);
    }

    /**
     * Getter for age.
     *
     * @return value for age
     */
    @XmlElement
    public Integer getAge() {
        return (expandLevel > 0) ? entity.getAge() : null;
    }

    /**
     * Setter for age.
     *
     * @param value the value to set
     */
    public void setAge(Integer value) {
        entity.setAge(value);
    }

    /**
     * Getter for bodytypeBuild.
     *
     * @return value for bodytypeBuild
     */
    @XmlElement
    public String getBodytypeBuild() {
        return (expandLevel > 0) ? entity.getBodytypeBuild() : null;
    }

    /**
     * Setter for bodytypeBuild.
     *
     * @param value the value to set
     */
    public void setBodytypeBuild(String value) {
        entity.setBodytypeBuild(value);
    }

    /**
     * Getter for bodytypeEyeColor.
     *
     * @return value for bodytypeEyeColor
     */
    @XmlElement
    public String getBodytypeEyeColor() {
        return (expandLevel > 0) ? entity.getBodytypeEyeColor() : null;
    }

    /**
     * Setter for bodytypeEyeColor.
     *
     * @param value the value to set
     */
    public void setBodytypeEyeColor(String value) {
        entity.setBodytypeEyeColor(value);
    }

    /**
     * Getter for bodytypeHairColor.
     *
     * @return value for bodytypeHairColor
     */
    @XmlElement
    public String getBodytypeHairColor() {
        return (expandLevel > 0) ? entity.getBodytypeHairColor() : null;
    }

    /**
     * Setter for bodytypeHairColor.
     *
     * @param value the value to set
     */
    public void setBodytypeHairColor(String value) {
        entity.setBodytypeHairColor(value);
    }

    /**
     * Getter for bodytypeHeight.
     *
     * @return value for bodytypeHeight
     */
    @XmlElement
    public String getBodytypeHeight() {
        return (expandLevel > 0) ? entity.getBodytypeHeight() : null;
    }

    /**
     * Setter for bodytypeHeight.
     *
     * @param value the value to set
     */
    public void setBodytypeHeight(String value) {
        entity.setBodytypeHeight(value);
    }

    /**
     * Getter for bodytypeWeight.
     *
     * @return value for bodytypeWeight
     */
    @XmlElement
    public String getBodytypeWeight() {
        return (expandLevel > 0) ? entity.getBodytypeWeight() : null;
    }

    /**
     * Setter for bodytypeWeight.
     *
     * @param value the value to set
     */
    public void setBodytypeWeight(String value) {
        entity.setBodytypeWeight(value);
    }

    /**
     * Getter for cars.
     *
     * @return value for cars
     */
    @XmlElement
    public String getCars() {
        return (expandLevel > 0) ? entity.getCars() : null;
    }

    /**
     * Setter for cars.
     *
     * @param value the value to set
     */
    public void setCars(String value) {
        entity.setCars(value);
    }

    /**
     * Getter for children.
     *
     * @return value for children
     */
    @XmlElement
    public String getChildren() {
        return (expandLevel > 0) ? entity.getChildren() : null;
    }

    /**
     * Setter for children.
     *
     * @param value the value to set
     */
    public void setChildren(String value) {
        entity.setChildren(value);
    }

    /**
     * Getter for addressopenSocialCURRENTLOCATION.
     *
     * @return value for addressopenSocialCURRENTLOCATION
     */
    @XmlElement
    public String getAddressopenSocialCURRENTLOCATION() {
        return (expandLevel > 0) ? entity.getAddressopenSocialCURRENTLOCATION() : null;
    }

    /**
     * Setter for addressopenSocialCURRENTLOCATION.
     *
     * @param value the value to set
     */
    public void setAddressopenSocialCURRENTLOCATION(String value) {
        entity.setAddressopenSocialCURRENTLOCATION(value);
    }

    /**
     * Getter for dateOfBirth.
     *
     * @return value for dateOfBirth
     */
    @XmlElement
    public Date getDateOfBirth() {
        return (expandLevel > 0) ? entity.getDateOfBirth() : null;
    }

    /**
     * Setter for dateOfBirth.
     *
     * @param value the value to set
     */
    public void setDateOfBirth(Date value) {
        entity.setDateOfBirth(value);
    }

    /**
     * Getter for drinkeropenSocialidDrinkeropenSocial.
     *
     * @return value for drinkeropenSocialidDrinkeropenSocial
     */
    @XmlElement
    public Integer getDrinkeropenSocialidDrinkeropenSocial() {
        return (expandLevel > 0) ? entity.getDrinkeropenSocialidDrinkeropenSocial() : null;
    }

    /**
     * Setter for drinkeropenSocialidDrinkeropenSocial.
     *
     * @param value the value to set
     */
    public void setDrinkeropenSocialidDrinkeropenSocial(Integer value) {
        entity.setDrinkeropenSocialidDrinkeropenSocial(value);
    }

    /**
     * Getter for ethnicity.
     *
     * @return value for ethnicity
     */
    @XmlElement
    public String getEthnicity() {
        return (expandLevel > 0) ? entity.getEthnicity() : null;
    }

    /**
     * Setter for ethnicity.
     *
     * @param value the value to set
     */
    public void setEthnicity(String value) {
        entity.setEthnicity(value);
    }

    /**
     * Getter for fashion.
     *
     * @return value for fashion
     */
    @XmlElement
    public String getFashion() {
        return (expandLevel > 0) ? entity.getFashion() : null;
    }

    /**
     * Setter for fashion.
     *
     * @param value the value to set
     */
    public void setFashion(String value) {
        entity.setFashion(value);
    }

    /**
     * Getter for food.
     *
     * @return value for food
     */
    @XmlElement
    public String getFood() {
        return (expandLevel > 0) ? entity.getFood() : null;
    }

    /**
     * Setter for food.
     *
     * @param value the value to set
     */
    public void setFood(String value) {
        entity.setFood(value);
    }

    /**
     * Getter for genderopenSocialidGenderopenSocial.
     *
     * @return value for genderopenSocialidGenderopenSocial
     */
    @XmlElement
    public Integer getGenderopenSocialidGenderopenSocial() {
        return (expandLevel > 0) ? entity.getGenderopenSocialidGenderopenSocial() : null;
    }

    /**
     * Setter for genderopenSocialidGenderopenSocial.
     *
     * @param value the value to set
     */
    public void setGenderopenSocialidGenderopenSocial(Integer value) {
        entity.setGenderopenSocialidGenderopenSocial(value);
    }

    /**
     * Getter for happiestWhen.
     *
     * @return value for happiestWhen
     */
    @XmlElement
    public String getHappiestWhen() {
        return (expandLevel > 0) ? entity.getHappiestWhen() : null;
    }

    /**
     * Setter for happiestWhen.
     *
     * @param value the value to set
     */
    public void setHappiestWhen(String value) {
        entity.setHappiestWhen(value);
    }

    /**
     * Getter for heroes.
     *
     * @return value for heroes
     */
    @XmlElement
    public String getHeroes() {
        return (expandLevel > 0) ? entity.getHeroes() : null;
    }

    /**
     * Setter for heroes.
     *
     * @param value the value to set
     */
    public void setHeroes(String value) {
        entity.setHeroes(value);
    }

    /**
     * Getter for humor.
     *
     * @return value for humor
     */
    @XmlElement
    public String getHumor() {
        return (expandLevel > 0) ? entity.getHumor() : null;
    }

    /**
     * Setter for humor.
     *
     * @param value the value to set
     */
    public void setHumor(String value) {
        entity.setHumor(value);
    }

    /**
     * Getter for jobInterests.
     *
     * @return value for jobInterests
     */
    @XmlElement
    public String getJobInterests() {
        return (expandLevel > 0) ? entity.getJobInterests() : null;
    }

    /**
     * Setter for jobInterests.
     *
     * @param value the value to set
     */
    public void setJobInterests(String value) {
        entity.setJobInterests(value);
    }

    /**
     * Getter for languagesSpoken.
     *
     * @return value for languagesSpoken
     */
    @XmlElement
    public String getLanguagesSpoken() {
        return (expandLevel > 0) ? entity.getLanguagesSpoken() : null;
    }

    /**
     * Setter for languagesSpoken.
     *
     * @param value the value to set
     */
    public void setLanguagesSpoken(String value) {
        entity.setLanguagesSpoken(value);
    }

    /**
     * Getter for livingArrangement.
     *
     * @return value for livingArrangement
     */
    @XmlElement
    public String getLivingArrangement() {
        return (expandLevel > 0) ? entity.getLivingArrangement() : null;
    }

    /**
     * Setter for livingArrangement.
     *
     * @param value the value to set
     */
    public void setLivingArrangement(String value) {
        entity.setLivingArrangement(value);
    }

    /**
     * Getter for lookingForopenSocialidLookingForopenSocial.
     *
     * @return value for lookingForopenSocialidLookingForopenSocial
     */
    @XmlElement
    public Integer getLookingForopenSocialidLookingForopenSocial() {
        return (expandLevel > 0) ? entity.getLookingForopenSocialidLookingForopenSocial() : null;
    }

    /**
     * Setter for lookingForopenSocialidLookingForopenSocial.
     *
     * @param value the value to set
     */
    public void setLookingForopenSocialidLookingForopenSocial(Integer value) {
        entity.setLookingForopenSocialidLookingForopenSocial(value);
    }

    /**
     * Getter for presenceopenSocialidPresenceopenSocial.
     *
     * @return value for presenceopenSocialidPresenceopenSocial
     */
    @XmlElement
    public Integer getPresenceopenSocialidPresenceopenSocial() {
        return (expandLevel > 0) ? entity.getPresenceopenSocialidPresenceopenSocial() : null;
    }

    /**
     * Setter for presenceopenSocialidPresenceopenSocial.
     *
     * @param value the value to set
     */
    public void setPresenceopenSocialidPresenceopenSocial(Integer value) {
        entity.setPresenceopenSocialidPresenceopenSocial(value);
    }

    /**
     * Getter for nickname.
     *
     * @return value for nickname
     */
    @XmlElement
    public String getNickname() {
        return (expandLevel > 0) ? entity.getNickname() : null;
    }

    /**
     * Setter for nickname.
     *
     * @param value the value to set
     */
    public void setNickname(String value) {
        entity.setNickname(value);
    }

    /**
     * Getter for pets.
     *
     * @return value for pets
     */
    @XmlElement
    public String getPets() {
        return (expandLevel > 0) ? entity.getPets() : null;
    }

    /**
     * Setter for pets.
     *
     * @param value the value to set
     */
    public void setPets(String value) {
        entity.setPets(value);
    }

    /**
     * Getter for profileUrl.
     *
     * @return value for profileUrl
     */
    @XmlElement
    public String getProfileUrl() {
        return (expandLevel > 0) ? entity.getProfileUrl() : null;
    }

    /**
     * Setter for profileUrl.
     *
     * @param value the value to set
     */
    public void setProfileUrl(String value) {
        entity.setProfileUrl(value);
    }

    /**
     * Getter for romance.
     *
     * @return value for romance
     */
    @XmlElement
    public String getRomance() {
        return (expandLevel > 0) ? entity.getRomance() : null;
    }

    /**
     * Setter for romance.
     *
     * @param value the value to set
     */
    public void setRomance(String value) {
        entity.setRomance(value);
    }

    /**
     * Getter for scaredOf.
     *
     * @return value for scaredOf
     */
    @XmlElement
    public String getScaredOf() {
        return (expandLevel > 0) ? entity.getScaredOf() : null;
    }

    /**
     * Setter for scaredOf.
     *
     * @param value the value to set
     */
    public void setScaredOf(String value) {
        entity.setScaredOf(value);
    }

    /**
     * Getter for smokeropenSocialidSmokeropenSocial.
     *
     * @return value for smokeropenSocialidSmokeropenSocial
     */
    @XmlElement
    public Integer getSmokeropenSocialidSmokeropenSocial() {
        return (expandLevel > 0) ? entity.getSmokeropenSocialidSmokeropenSocial() : null;
    }

    /**
     * Setter for smokeropenSocialidSmokeropenSocial.
     *
     * @param value the value to set
     */
    public void setSmokeropenSocialidSmokeropenSocial(Integer value) {
        entity.setSmokeropenSocialidSmokeropenSocial(value);
    }

    /**
     * Getter for sports.
     *
     * @return value for sports
     */
    @XmlElement
    public String getSports() {
        return (expandLevel > 0) ? entity.getSports() : null;
    }

    /**
     * Setter for sports.
     *
     * @param value the value to set
     */
    public void setSports(String value) {
        entity.setSports(value);
    }

    /**
     * Getter for tags.
     *
     * @return value for tags
     */
    @XmlElement
    public String getTags() {
        return (expandLevel > 0) ? entity.getTags() : null;
    }

    /**
     * Setter for tags.
     *
     * @param value the value to set
     */
    public void setTags(String value) {
        entity.setTags(value);
    }

    /**
     * Getter for thumbnailUrl.
     *
     * @return value for thumbnailUrl
     */
    @XmlElement
    public String getThumbnailUrl() {
        return (expandLevel > 0) ? entity.getThumbnailUrl() : null;
    }

    /**
     * Setter for thumbnailUrl.
     *
     * @param value the value to set
     */
    public void setThumbnailUrl(String value) {
        entity.setThumbnailUrl(value);
    }

    /**
     * Getter for timeZone.
     *
     * @return value for timeZone
     */
    @XmlElement
    public Date getTimeZone() {
        return (expandLevel > 0) ? entity.getTimeZone() : null;
    }

    /**
     * Setter for timeZone.
     *
     * @param value the value to set
     */
    public void setTimeZone(Date value) {
        entity.setTimeZone(value);
    }

    /**
     * Getter for turnsOffs.
     *
     * @return value for turnsOffs
     */
    @XmlElement
    public String getTurnsOffs() {
        return (expandLevel > 0) ? entity.getTurnsOffs() : null;
    }

    /**
     * Setter for turnsOffs.
     *
     * @param value the value to set
     */
    public void setTurnsOffs(String value) {
        entity.setTurnsOffs(value);
    }

    /**
     * Getter for turnsOns.
     *
     * @return value for turnsOns
     */
    @XmlElement
    public String getTurnsOns() {
        return (expandLevel > 0) ? entity.getTurnsOns() : null;
    }

    /**
     * Setter for turnsOns.
     *
     * @param value the value to set
     */
    public void setTurnsOns(String value) {
        entity.setTurnsOns(value);
    }

    /**
     * Getter for urls.
     *
     * @return value for urls
     */
    @XmlElement
    public String getUrls() {
        return (expandLevel > 0) ? entity.getUrls() : null;
    }

    /**
     * Setter for urls.
     *
     * @param value the value to set
     */
    public void setUrls(String value) {
        entity.setUrls(value);
    }

    /**
     * Getter for userCollection.
     *
     * @return value for userCollection
     */
    @XmlElement
    public UsersConverter getUserCollection() {
        if (expandLevel > 0) {
            if (entity.getUserCollection() != null) {
                return new UsersConverter(entity.getUserCollection(), uri.resolve("userCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for userCollection.
     *
     * @param value the value to set
     */
    public void setUserCollection(UsersConverter value) {
        entity.setUserCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Returns the URI associated with this converter.
     *
     * @return the uri
     */
    @XmlAttribute
    public URI getUri() {
        return uri;
    }

    /**
     * Sets the URI for this reference converter.
     *
     */
    public void setUri(URI uri) {
        this.uri = uri;
    }

    /**
     * Returns the UseropenSocial entity.
     *
     * @return an entity
     */
    @XmlTransient
    public UseropenSocial getEntity() {
        if (entity.getIduseropenSocial() == null) {
            UseropenSocialConverter converter = UriResolver.getInstance().resolve(UseropenSocialConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved UseropenSocial entity.
     *
     * @return an resolved entity
     */
    public UseropenSocial resolveEntity(EntityManager em) {
        Collection<User> userCollection = entity.getUserCollection();
        Collection<User> newuserCollection = new java.util.ArrayList<User>();
        if (userCollection != null) {
            for (User item : userCollection) {
                newuserCollection.add(em.getReference(User.class, item.getUserSettingsUid()));
            }
        }
        entity.setUserCollection(newuserCollection);
        return entity;
    }
}
