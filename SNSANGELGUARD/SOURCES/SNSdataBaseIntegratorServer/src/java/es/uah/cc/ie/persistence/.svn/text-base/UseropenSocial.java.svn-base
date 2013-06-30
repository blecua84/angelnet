/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "user_openSocial")
@NamedQueries({
    @NamedQuery(name = "UseropenSocial.findAll", query = "SELECT u FROM UseropenSocial u"),
    @NamedQuery(name = "UseropenSocial.findByIduseropenSocial", query = "SELECT u FROM UseropenSocial u WHERE u.iduseropenSocial = :iduseropenSocial"),
    @NamedQuery(name = "UseropenSocial.findByAge", query = "SELECT u FROM UseropenSocial u WHERE u.age = :age"),
    @NamedQuery(name = "UseropenSocial.findByBodytypeBuild", query = "SELECT u FROM UseropenSocial u WHERE u.bodytypeBuild = :bodytypeBuild"),
    @NamedQuery(name = "UseropenSocial.findByBodytypeEyeColor", query = "SELECT u FROM UseropenSocial u WHERE u.bodytypeEyeColor = :bodytypeEyeColor"),
    @NamedQuery(name = "UseropenSocial.findByBodytypeHairColor", query = "SELECT u FROM UseropenSocial u WHERE u.bodytypeHairColor = :bodytypeHairColor"),
    @NamedQuery(name = "UseropenSocial.findByBodytypeHeight", query = "SELECT u FROM UseropenSocial u WHERE u.bodytypeHeight = :bodytypeHeight"),
    @NamedQuery(name = "UseropenSocial.findByBodytypeWeight", query = "SELECT u FROM UseropenSocial u WHERE u.bodytypeWeight = :bodytypeWeight"),
    @NamedQuery(name = "UseropenSocial.findByCars", query = "SELECT u FROM UseropenSocial u WHERE u.cars = :cars"),
    @NamedQuery(name = "UseropenSocial.findByChildren", query = "SELECT u FROM UseropenSocial u WHERE u.children = :children"),
    @NamedQuery(name = "UseropenSocial.findByAddressopenSocialCURRENTLOCATION", query = "SELECT u FROM UseropenSocial u WHERE u.addressopenSocialCURRENTLOCATION = :addressopenSocialCURRENTLOCATION"),
    @NamedQuery(name = "UseropenSocial.findByDateOfBirth", query = "SELECT u FROM UseropenSocial u WHERE u.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "UseropenSocial.findByDrinkeropenSocialidDrinkeropenSocial", query = "SELECT u FROM UseropenSocial u WHERE u.drinkeropenSocialidDrinkeropenSocial = :drinkeropenSocialidDrinkeropenSocial"),
    @NamedQuery(name = "UseropenSocial.findByEthnicity", query = "SELECT u FROM UseropenSocial u WHERE u.ethnicity = :ethnicity"),
    @NamedQuery(name = "UseropenSocial.findByFashion", query = "SELECT u FROM UseropenSocial u WHERE u.fashion = :fashion"),
    @NamedQuery(name = "UseropenSocial.findByFood", query = "SELECT u FROM UseropenSocial u WHERE u.food = :food"),
    @NamedQuery(name = "UseropenSocial.findByGenderopenSocialidGenderopenSocial", query = "SELECT u FROM UseropenSocial u WHERE u.genderopenSocialidGenderopenSocial = :genderopenSocialidGenderopenSocial"),
    @NamedQuery(name = "UseropenSocial.findByHappiestWhen", query = "SELECT u FROM UseropenSocial u WHERE u.happiestWhen = :happiestWhen"),
    @NamedQuery(name = "UseropenSocial.findByHeroes", query = "SELECT u FROM UseropenSocial u WHERE u.heroes = :heroes"),
    @NamedQuery(name = "UseropenSocial.findByHumor", query = "SELECT u FROM UseropenSocial u WHERE u.humor = :humor"),
    @NamedQuery(name = "UseropenSocial.findByJobInterests", query = "SELECT u FROM UseropenSocial u WHERE u.jobInterests = :jobInterests"),
    @NamedQuery(name = "UseropenSocial.findByLanguagesSpoken", query = "SELECT u FROM UseropenSocial u WHERE u.languagesSpoken = :languagesSpoken"),
    @NamedQuery(name = "UseropenSocial.findByLivingArrangement", query = "SELECT u FROM UseropenSocial u WHERE u.livingArrangement = :livingArrangement"),
    @NamedQuery(name = "UseropenSocial.findByLookingForopenSocialidLookingForopenSocial", query = "SELECT u FROM UseropenSocial u WHERE u.lookingForopenSocialidLookingForopenSocial = :lookingForopenSocialidLookingForopenSocial"),
    @NamedQuery(name = "UseropenSocial.findByPresenceopenSocialidPresenceopenSocial", query = "SELECT u FROM UseropenSocial u WHERE u.presenceopenSocialidPresenceopenSocial = :presenceopenSocialidPresenceopenSocial"),
    @NamedQuery(name = "UseropenSocial.findByNickname", query = "SELECT u FROM UseropenSocial u WHERE u.nickname = :nickname"),
    @NamedQuery(name = "UseropenSocial.findByPets", query = "SELECT u FROM UseropenSocial u WHERE u.pets = :pets"),
    @NamedQuery(name = "UseropenSocial.findByProfileUrl", query = "SELECT u FROM UseropenSocial u WHERE u.profileUrl = :profileUrl"),
    @NamedQuery(name = "UseropenSocial.findByRomance", query = "SELECT u FROM UseropenSocial u WHERE u.romance = :romance"),
    @NamedQuery(name = "UseropenSocial.findByScaredOf", query = "SELECT u FROM UseropenSocial u WHERE u.scaredOf = :scaredOf"),
    @NamedQuery(name = "UseropenSocial.findBySmokeropenSocialidSmokeropenSocial", query = "SELECT u FROM UseropenSocial u WHERE u.smokeropenSocialidSmokeropenSocial = :smokeropenSocialidSmokeropenSocial"),
    @NamedQuery(name = "UseropenSocial.findBySports", query = "SELECT u FROM UseropenSocial u WHERE u.sports = :sports"),
    @NamedQuery(name = "UseropenSocial.findByTags", query = "SELECT u FROM UseropenSocial u WHERE u.tags = :tags"),
    @NamedQuery(name = "UseropenSocial.findByThumbnailUrl", query = "SELECT u FROM UseropenSocial u WHERE u.thumbnailUrl = :thumbnailUrl"),
    @NamedQuery(name = "UseropenSocial.findByTimeZone", query = "SELECT u FROM UseropenSocial u WHERE u.timeZone = :timeZone"),
    @NamedQuery(name = "UseropenSocial.findByTurnsOffs", query = "SELECT u FROM UseropenSocial u WHERE u.turnsOffs = :turnsOffs"),
    @NamedQuery(name = "UseropenSocial.findByTurnsOns", query = "SELECT u FROM UseropenSocial u WHERE u.turnsOns = :turnsOns"),
    @NamedQuery(name = "UseropenSocial.findByUrls", query = "SELECT u FROM UseropenSocial u WHERE u.urls = :urls")})
public class UseropenSocial implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_user_openSocial")
    private String iduseropenSocial;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "BODYTYPE_BUILD")
    private String bodytypeBuild;
    @Column(name = "BODYTYPE_EYE_COLOR")
    private String bodytypeEyeColor;
    @Column(name = "BODYTYPE_HAIR_COLOR")
    private String bodytypeHairColor;
    @Column(name = "BODYTYPE_HEIGHT")
    private String bodytypeHeight;
    @Column(name = "BODYTYPE_WEIGHT")
    private String bodytypeWeight;
    @Column(name = "CARS")
    private String cars;
    @Column(name = "CHILDREN")
    private String children;
    @Basic(optional = false)
    @Column(name = "Address_openSocial_CURRENT_LOCATION")
    private String addressopenSocialCURRENTLOCATION;
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "Drinker_openSocial_id_Drinker_openSocial")
    private int drinkeropenSocialidDrinkeropenSocial;
    @Column(name = "ETHNICITY")
    private String ethnicity;
    @Column(name = "FASHION")
    private String fashion;
    @Column(name = "FOOD")
    private String food;
    @Basic(optional = false)
    @Column(name = "Gender_openSocial_id_Gender_openSocial")
    private int genderopenSocialidGenderopenSocial;
    @Column(name = "HAPPIEST_WHEN")
    private String happiestWhen;
    @Column(name = "HEROES")
    private String heroes;
    @Column(name = "HUMOR")
    private String humor;
    @Column(name = "JOB_INTERESTS")
    private String jobInterests;
    @Column(name = "LANGUAGES_SPOKEN")
    private String languagesSpoken;
    @Column(name = "LIVING_ARRANGEMENT")
    private String livingArrangement;
    @Basic(optional = false)
    @Column(name = "LookingFor_openSocial_id_LookingFor_openSocial")
    private int lookingForopenSocialidLookingForopenSocial;
    @Basic(optional = false)
    @Column(name = "Presence_openSocial_id_Presence_openSocial")
    private int presenceopenSocialidPresenceopenSocial;
    @Column(name = "NICKNAME")
    private String nickname;
    @Column(name = "PETS")
    private String pets;
    @Column(name = "PROFILE_URL")
    private String profileUrl;
    @Column(name = "ROMANCE")
    private String romance;
    @Column(name = "SCARED_OF")
    private String scaredOf;
    @Basic(optional = false)
    @Column(name = "Smoker_openSocial_id_Smoker_openSocial")
    private int smokeropenSocialidSmokeropenSocial;
    @Column(name = "SPORTS")
    private String sports;
    @Column(name = "TAGS")
    private String tags;
    @Column(name = "THUMBNAIL_URL")
    private String thumbnailUrl;
    @Column(name = "TIME_ZONE")
    @Temporal(TemporalType.DATE)
    private Date timeZone;
    @Column(name = "TURNS_OFFS")
    private String turnsOffs;
    @Column(name = "TURNS_ONS")
    private String turnsOns;
    @Column(name = "URLS")
    private String urls;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useropenSocial")
    private Collection<User> userCollection;

    public UseropenSocial() {
    }

    public UseropenSocial(String iduseropenSocial) {
        this.iduseropenSocial = iduseropenSocial;
    }

    public UseropenSocial(String iduseropenSocial, String addressopenSocialCURRENTLOCATION, int drinkeropenSocialidDrinkeropenSocial, int genderopenSocialidGenderopenSocial, int lookingForopenSocialidLookingForopenSocial, int presenceopenSocialidPresenceopenSocial, int smokeropenSocialidSmokeropenSocial) {
        this.iduseropenSocial = iduseropenSocial;
        this.addressopenSocialCURRENTLOCATION = addressopenSocialCURRENTLOCATION;
        this.drinkeropenSocialidDrinkeropenSocial = drinkeropenSocialidDrinkeropenSocial;
        this.genderopenSocialidGenderopenSocial = genderopenSocialidGenderopenSocial;
        this.lookingForopenSocialidLookingForopenSocial = lookingForopenSocialidLookingForopenSocial;
        this.presenceopenSocialidPresenceopenSocial = presenceopenSocialidPresenceopenSocial;
        this.smokeropenSocialidSmokeropenSocial = smokeropenSocialidSmokeropenSocial;
    }

    public String getIduseropenSocial() {
        return iduseropenSocial;
    }

    public void setIduseropenSocial(String iduseropenSocial) {
        this.iduseropenSocial = iduseropenSocial;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBodytypeBuild() {
        return bodytypeBuild;
    }

    public void setBodytypeBuild(String bodytypeBuild) {
        this.bodytypeBuild = bodytypeBuild;
    }

    public String getBodytypeEyeColor() {
        return bodytypeEyeColor;
    }

    public void setBodytypeEyeColor(String bodytypeEyeColor) {
        this.bodytypeEyeColor = bodytypeEyeColor;
    }

    public String getBodytypeHairColor() {
        return bodytypeHairColor;
    }

    public void setBodytypeHairColor(String bodytypeHairColor) {
        this.bodytypeHairColor = bodytypeHairColor;
    }

    public String getBodytypeHeight() {
        return bodytypeHeight;
    }

    public void setBodytypeHeight(String bodytypeHeight) {
        this.bodytypeHeight = bodytypeHeight;
    }

    public String getBodytypeWeight() {
        return bodytypeWeight;
    }

    public void setBodytypeWeight(String bodytypeWeight) {
        this.bodytypeWeight = bodytypeWeight;
    }

    public String getCars() {
        return cars;
    }

    public void setCars(String cars) {
        this.cars = cars;
    }

    public String getChildren() {
        return children;
    }

    public void setChildren(String children) {
        this.children = children;
    }

    public String getAddressopenSocialCURRENTLOCATION() {
        return addressopenSocialCURRENTLOCATION;
    }

    public void setAddressopenSocialCURRENTLOCATION(String addressopenSocialCURRENTLOCATION) {
        this.addressopenSocialCURRENTLOCATION = addressopenSocialCURRENTLOCATION;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getDrinkeropenSocialidDrinkeropenSocial() {
        return drinkeropenSocialidDrinkeropenSocial;
    }

    public void setDrinkeropenSocialidDrinkeropenSocial(int drinkeropenSocialidDrinkeropenSocial) {
        this.drinkeropenSocialidDrinkeropenSocial = drinkeropenSocialidDrinkeropenSocial;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getFashion() {
        return fashion;
    }

    public void setFashion(String fashion) {
        this.fashion = fashion;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getGenderopenSocialidGenderopenSocial() {
        return genderopenSocialidGenderopenSocial;
    }

    public void setGenderopenSocialidGenderopenSocial(int genderopenSocialidGenderopenSocial) {
        this.genderopenSocialidGenderopenSocial = genderopenSocialidGenderopenSocial;
    }

    public String getHappiestWhen() {
        return happiestWhen;
    }

    public void setHappiestWhen(String happiestWhen) {
        this.happiestWhen = happiestWhen;
    }

    public String getHeroes() {
        return heroes;
    }

    public void setHeroes(String heroes) {
        this.heroes = heroes;
    }

    public String getHumor() {
        return humor;
    }

    public void setHumor(String humor) {
        this.humor = humor;
    }

    public String getJobInterests() {
        return jobInterests;
    }

    public void setJobInterests(String jobInterests) {
        this.jobInterests = jobInterests;
    }

    public String getLanguagesSpoken() {
        return languagesSpoken;
    }

    public void setLanguagesSpoken(String languagesSpoken) {
        this.languagesSpoken = languagesSpoken;
    }

    public String getLivingArrangement() {
        return livingArrangement;
    }

    public void setLivingArrangement(String livingArrangement) {
        this.livingArrangement = livingArrangement;
    }

    public int getLookingForopenSocialidLookingForopenSocial() {
        return lookingForopenSocialidLookingForopenSocial;
    }

    public void setLookingForopenSocialidLookingForopenSocial(int lookingForopenSocialidLookingForopenSocial) {
        this.lookingForopenSocialidLookingForopenSocial = lookingForopenSocialidLookingForopenSocial;
    }

    public int getPresenceopenSocialidPresenceopenSocial() {
        return presenceopenSocialidPresenceopenSocial;
    }

    public void setPresenceopenSocialidPresenceopenSocial(int presenceopenSocialidPresenceopenSocial) {
        this.presenceopenSocialidPresenceopenSocial = presenceopenSocialidPresenceopenSocial;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getRomance() {
        return romance;
    }

    public void setRomance(String romance) {
        this.romance = romance;
    }

    public String getScaredOf() {
        return scaredOf;
    }

    public void setScaredOf(String scaredOf) {
        this.scaredOf = scaredOf;
    }

    public int getSmokeropenSocialidSmokeropenSocial() {
        return smokeropenSocialidSmokeropenSocial;
    }

    public void setSmokeropenSocialidSmokeropenSocial(int smokeropenSocialidSmokeropenSocial) {
        this.smokeropenSocialidSmokeropenSocial = smokeropenSocialidSmokeropenSocial;
    }

    public String getSports() {
        return sports;
    }

    public void setSports(String sports) {
        this.sports = sports;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public Date getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(Date timeZone) {
        this.timeZone = timeZone;
    }

    public String getTurnsOffs() {
        return turnsOffs;
    }

    public void setTurnsOffs(String turnsOffs) {
        this.turnsOffs = turnsOffs;
    }

    public String getTurnsOns() {
        return turnsOns;
    }

    public void setTurnsOns(String turnsOns) {
        this.turnsOns = turnsOns;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduseropenSocial != null ? iduseropenSocial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UseropenSocial)) {
            return false;
        }
        UseropenSocial other = (UseropenSocial) object;
        if ((this.iduseropenSocial == null && other.iduseropenSocial != null) || (this.iduseropenSocial != null && !this.iduseropenSocial.equals(other.iduseropenSocial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.UseropenSocial[iduseropenSocial=" + iduseropenSocial + "]";
    }

}
