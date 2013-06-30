/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.UserFacebook;
import java.net.URI;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
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

/**
 *
 * @author tote
 */
@XmlRootElement(name = "userFacebook")
public class UserFacebookConverter {

    private UserFacebook entity;
    private URI uri;
    private int expandLevel;

    /** Creates a new instance of UserFacebookConverter */
    public UserFacebookConverter() {
        entity = new UserFacebook();
    }

    /**
     * Creates a new instance of UserFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public UserFacebookConverter(UserFacebook entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdUserFacebook() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getLocationFacebookCollection();
        getFamilyFacebookCollection();
        getFriendsFacebookCollection();
        getStreamFacebookCollection();
        getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection();
        getMeetingSexFacebook();
        getMeetingForFacebook();
        getAffiliationsFacebookCollection();
        getEducationHistoryFacebookCollection();
        getWorkHistoryFacebookCollection();
        getUserCollection();
    }

    /**
     * Creates a new instance of UserFacebookConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public UserFacebookConverter(UserFacebook entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idUserFacebook.
     *
     * @return value for idUserFacebook
     */
    @XmlElement
    public String getIdUserFacebook() {
        return (expandLevel > 0) ? entity.getIdUserFacebook() : null;
    }

    /**
     * Setter for idUserFacebook.
     *
     * @param value the value to set
     */
    public void setIdUserFacebook(String value) {
        entity.setIdUserFacebook(value);
    }

    /**
     * Getter for firstName.
     *
     * @return value for firstName
     */
    @XmlElement
    public String getFirstName() {
        return (expandLevel > 0) ? entity.getFirstName() : null;
    }

    /**
     * Setter for firstName.
     *
     * @param value the value to set
     */
    public void setFirstName(String value) {
        entity.setFirstName(value);
    }

    /**
     * Getter for middleName.
     *
     * @return value for middleName
     */
    @XmlElement
    public String getMiddleName() {
        return (expandLevel > 0) ? entity.getMiddleName() : null;
    }

    /**
     * Setter for middleName.
     *
     * @param value the value to set
     */
    public void setMiddleName(String value) {
        entity.setMiddleName(value);
    }

    /**
     * Getter for lastName.
     *
     * @return value for lastName
     */
    @XmlElement
    public String getLastName() {
        return (expandLevel > 0) ? entity.getLastName() : null;
    }

    /**
     * Setter for lastName.
     *
     * @param value the value to set
     */
    public void setLastName(String value) {
        entity.setLastName(value);
    }

    /**
     * Getter for name.
     *
     * @return value for name
     */
    @XmlElement
    public String getName() {
        return (expandLevel > 0) ? entity.getName() : null;
    }

    /**
     * Setter for name.
     *
     * @param value the value to set
     */
    public void setName(String value) {
        entity.setName(value);
    }

    /**
     * Getter for picSmall.
     *
     * @return value for picSmall
     */
    @XmlElement
    public String getPicSmall() {
        return (expandLevel > 0) ? entity.getPicSmall() : null;
    }

    /**
     * Setter for picSmall.
     *
     * @param value the value to set
     */
    public void setPicSmall(String value) {
        entity.setPicSmall(value);
    }

    /**
     * Getter for picBig.
     *
     * @return value for picBig
     */
    @XmlElement
    public String getPicBig() {
        return (expandLevel > 0) ? entity.getPicBig() : null;
    }

    /**
     * Setter for picBig.
     *
     * @param value the value to set
     */
    public void setPicBig(String value) {
        entity.setPicBig(value);
    }

    /**
     * Getter for picSquare.
     *
     * @return value for picSquare
     */
    @XmlElement
    public String getPicSquare() {
        return (expandLevel > 0) ? entity.getPicSquare() : null;
    }

    /**
     * Setter for picSquare.
     *
     * @param value the value to set
     */
    public void setPicSquare(String value) {
        entity.setPicSquare(value);
    }

    /**
     * Getter for pic.
     *
     * @return value for pic
     */
    @XmlElement
    public String getPic() {
        return (expandLevel > 0) ? entity.getPic() : null;
    }

    /**
     * Setter for pic.
     *
     * @param value the value to set
     */
    public void setPic(String value) {
        entity.setPic(value);
    }

    /**
     * Getter for profileUpdateTime.
     *
     * @return value for profileUpdateTime
     */
    @XmlElement
    public Date getProfileUpdateTime() {
        return (expandLevel > 0) ? entity.getProfileUpdateTime() : null;
    }

    /**
     * Setter for profileUpdateTime.
     *
     * @param value the value to set
     */
    public void setProfileUpdateTime(Date value) {
        entity.setProfileUpdateTime(value);
    }

    /**
     * Getter for birthday.
     *
     * @return value for birthday
     */
    @XmlElement
    public String getBirthday() {
        return (expandLevel > 0) ? entity.getBirthday() : null;
    }

    /**
     * Setter for birthday.
     *
     * @param value the value to set
     */
    public void setBirthday(String value) {
        entity.setBirthday(value);
    }

    /**
     * Getter for birthdayDate.
     *
     * @return value for birthdayDate
     */
    @XmlElement
    public String getBirthdayDate() {
        return (expandLevel > 0) ? entity.getBirthdayDate() : null;
    }

    /**
     * Setter for birthdayDate.
     *
     * @param value the value to set
     */
    public void setBirthdayDate(String value) {
        entity.setBirthdayDate(value);
    }

    /**
     * Getter for significantOtherId.
     *
     * @return value for significantOtherId
     */
    @XmlElement
    public String getSignificantOtherId() {
        return (expandLevel > 0) ? entity.getSignificantOtherId() : null;
    }

    /**
     * Setter for significantOtherId.
     *
     * @param value the value to set
     */
    public void setSignificantOtherId(String value) {
        entity.setSignificantOtherId(value);
    }

    /**
     * Getter for hs1Name.
     *
     * @return value for hs1Name
     */
    @XmlElement
    public String getHs1Name() {
        return (expandLevel > 0) ? entity.getHs1Name() : null;
    }

    /**
     * Setter for hs1Name.
     *
     * @param value the value to set
     */
    public void setHs1Name(String value) {
        entity.setHs1Name(value);
    }

    /**
     * Getter for hs2Name.
     *
     * @return value for hs2Name
     */
    @XmlElement
    public String getHs2Name() {
        return (expandLevel > 0) ? entity.getHs2Name() : null;
    }

    /**
     * Setter for hs2Name.
     *
     * @param value the value to set
     */
    public void setHs2Name(String value) {
        entity.setHs2Name(value);
    }

    /**
     * Getter for gradYear.
     *
     * @return value for gradYear
     */
    @XmlElement
    public Integer getGradYear() {
        return (expandLevel > 0) ? entity.getGradYear() : null;
    }

    /**
     * Setter for gradYear.
     *
     * @param value the value to set
     */
    public void setGradYear(Integer value) {
        entity.setGradYear(value);
    }

    /**
     * Getter for hs1Id.
     *
     * @return value for hs1Id
     */
    @XmlElement
    public String getHs1Id() {
        return (expandLevel > 0) ? entity.getHs1Id() : null;
    }

    /**
     * Setter for hs1Id.
     *
     * @param value the value to set
     */
    public void setHs1Id(String value) {
        entity.setHs1Id(value);
    }

    /**
     * Getter for hs2Id.
     *
     * @return value for hs2Id
     */
    @XmlElement
    public String getHs2Id() {
        return (expandLevel > 0) ? entity.getHs2Id() : null;
    }

    /**
     * Setter for hs2Id.
     *
     * @param value the value to set
     */
    public void setHs2Id(String value) {
        entity.setHs2Id(value);
    }

    /**
     * Getter for notesCount.
     *
     * @return value for notesCount
     */
    @XmlElement
    public Integer getNotesCount() {
        return (expandLevel > 0) ? entity.getNotesCount() : null;
    }

    /**
     * Setter for notesCount.
     *
     * @param value the value to set
     */
    public void setNotesCount(Integer value) {
        entity.setNotesCount(value);
    }

    /**
     * Getter for wallCount.
     *
     * @return value for wallCount
     */
    @XmlElement
    public Integer getWallCount() {
        return (expandLevel > 0) ? entity.getWallCount() : null;
    }

    /**
     * Setter for wallCount.
     *
     * @param value the value to set
     */
    public void setWallCount(Integer value) {
        entity.setWallCount(value);
    }

    /**
     * Getter for onlinePresence.
     *
     * @return value for onlinePresence
     */
    @XmlElement
    public String getOnlinePresence() {
        return (expandLevel > 0) ? entity.getOnlinePresence() : null;
    }

    /**
     * Setter for onlinePresence.
     *
     * @param value the value to set
     */
    public void setOnlinePresence(String value) {
        entity.setOnlinePresence(value);
    }

    /**
     * Getter for locale.
     *
     * @return value for locale
     */
    @XmlElement
    public String getLocale() {
        return (expandLevel > 0) ? entity.getLocale() : null;
    }

    /**
     * Setter for locale.
     *
     * @param value the value to set
     */
    public void setLocale(String value) {
        entity.setLocale(value);
    }

    /**
     * Getter for proxiedEmail.
     *
     * @return value for proxiedEmail
     */
    @XmlElement
    public String getProxiedEmail() {
        return (expandLevel > 0) ? entity.getProxiedEmail() : null;
    }

    /**
     * Setter for proxiedEmail.
     *
     * @param value the value to set
     */
    public void setProxiedEmail(String value) {
        entity.setProxiedEmail(value);
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
     * Getter for emailHashes.
     *
     * @return value for emailHashes
     */
    @XmlElement
    public String getEmailHashes() {
        return (expandLevel > 0) ? entity.getEmailHashes() : null;
    }

    /**
     * Setter for emailHashes.
     *
     * @param value the value to set
     */
    public void setEmailHashes(String value) {
        entity.setEmailHashes(value);
    }

    /**
     * Getter for picSmallWithLogo.
     *
     * @return value for picSmallWithLogo
     */
    @XmlElement
    public String getPicSmallWithLogo() {
        return (expandLevel > 0) ? entity.getPicSmallWithLogo() : null;
    }

    /**
     * Setter for picSmallWithLogo.
     *
     * @param value the value to set
     */
    public void setPicSmallWithLogo(String value) {
        entity.setPicSmallWithLogo(value);
    }

    /**
     * Getter for picBigWithLogo.
     *
     * @return value for picBigWithLogo
     */
    @XmlElement
    public String getPicBigWithLogo() {
        return (expandLevel > 0) ? entity.getPicBigWithLogo() : null;
    }

    /**
     * Setter for picBigWithLogo.
     *
     * @param value the value to set
     */
    public void setPicBigWithLogo(String value) {
        entity.setPicBigWithLogo(value);
    }

    /**
     * Getter for picSquareWithLogo.
     *
     * @return value for picSquareWithLogo
     */
    @XmlElement
    public String getPicSquareWithLogo() {
        return (expandLevel > 0) ? entity.getPicSquareWithLogo() : null;
    }

    /**
     * Setter for picSquareWithLogo.
     *
     * @param value the value to set
     */
    public void setPicSquareWithLogo(String value) {
        entity.setPicSquareWithLogo(value);
    }

    /**
     * Getter for picWithLogo.
     *
     * @return value for picWithLogo
     */
    @XmlElement
    public String getPicWithLogo() {
        return (expandLevel > 0) ? entity.getPicWithLogo() : null;
    }

    /**
     * Setter for picWithLogo.
     *
     * @param value the value to set
     */
    public void setPicWithLogo(String value) {
        entity.setPicWithLogo(value);
    }

    /**
     * Getter for allowedRestrictions.
     *
     * @return value for allowedRestrictions
     */
    @XmlElement
    public String getAllowedRestrictions() {
        return (expandLevel > 0) ? entity.getAllowedRestrictions() : null;
    }

    /**
     * Setter for allowedRestrictions.
     *
     * @param value the value to set
     */
    public void setAllowedRestrictions(String value) {
        entity.setAllowedRestrictions(value);
    }

    /**
     * Getter for verified.
     *
     * @return value for verified
     */
    @XmlElement
    public Boolean getVerified() {
        return (expandLevel > 0) ? entity.getVerified() : null;
    }

    /**
     * Setter for verified.
     *
     * @param value the value to set
     */
    public void setVerified(Boolean value) {
        entity.setVerified(value);
    }

    /**
     * Getter for profileBlurb.
     *
     * @return value for profileBlurb
     */
    @XmlElement
    public String getProfileBlurb() {
        return (expandLevel > 0) ? entity.getProfileBlurb() : null;
    }

    /**
     * Setter for profileBlurb.
     *
     * @param value the value to set
     */
    public void setProfileBlurb(String value) {
        entity.setProfileBlurb(value);
    }

    /**
     * Getter for username.
     *
     * @return value for username
     */
    @XmlElement
    public String getUsername() {
        return (expandLevel > 0) ? entity.getUsername() : null;
    }

    /**
     * Setter for username.
     *
     * @param value the value to set
     */
    public void setUsername(String value) {
        entity.setUsername(value);
    }

    /**
     * Getter for website.
     *
     * @return value for website
     */
    @XmlElement
    public String getWebsite() {
        return (expandLevel > 0) ? entity.getWebsite() : null;
    }

    /**
     * Setter for website.
     *
     * @param value the value to set
     */
    public void setWebsite(String value) {
        entity.setWebsite(value);
    }

    /**
     * Getter for isBlocked.
     *
     * @return value for isBlocked
     */
    @XmlElement
    public Boolean getIsBlocked() {
        return (expandLevel > 0) ? entity.getIsBlocked() : null;
    }

    /**
     * Setter for isBlocked.
     *
     * @param value the value to set
     */
    public void setIsBlocked(Boolean value) {
        entity.setIsBlocked(value);
    }

    /**
     * Getter for contactEmail.
     *
     * @return value for contactEmail
     */
    @XmlElement
    public String getContactEmail() {
        return (expandLevel > 0) ? entity.getContactEmail() : null;
    }

    /**
     * Setter for contactEmail.
     *
     * @param value the value to set
     */
    public void setContactEmail(String value) {
        entity.setContactEmail(value);
    }

    /**
     * Getter for email.
     *
     * @return value for email
     */
    @XmlElement
    public String getEmail() {
        return (expandLevel > 0) ? entity.getEmail() : null;
    }

    /**
     * Setter for email.
     *
     * @param value the value to set
     */
    public void setEmail(String value) {
        entity.setEmail(value);
    }

    /**
     * Getter for meetingSexFacebook.
     *
     * @return value for meetingSexFacebook
     */
    @XmlElement
    public String getMeetingSexFacebook() {
        return (expandLevel > 0) ? entity.getMeetingSexFacebook() : null;
    }

    /**
     * Setter for meetingSexFacebook.
     *
     * @param value the value to set
     */
    public void setMeetingSexFacebook(String value) {
        entity.setMeetingSexFacebook(value);
    }

    /**
     * Getter for meetingForFacebook.
     *
     * @return value for meetingForFacebook
     */
    @XmlElement
    public String getMeetingForFacebook() {
        return (expandLevel > 0) ? entity.getMeetingForFacebook() : null;
    }

    /**
     * Setter for meetingForFacebook.
     *
     * @param value the value to set
     */
    public void setMeetingForFacebook(String value) {
        entity.setMeetingForFacebook(value);
    }

    /**
     * Getter for locationFacebookCollection.
     *
     * @return value for locationFacebookCollection
     */
    @XmlElement
    public LocationFacebooksConverter getLocationFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getLocationFacebookCollection() != null) {
                return new LocationFacebooksConverter(entity.getLocationFacebookCollection(), uri.resolve("locationFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for locationFacebookCollection.
     *
     * @param value the value to set
     */
    public void setLocationFacebookCollection(LocationFacebooksConverter value) {
        entity.setLocationFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for familyFacebookCollection.
     *
     * @return value for familyFacebookCollection
     */
    @XmlElement
    public FamilyFacebooksConverter getFamilyFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getFamilyFacebookCollection() != null) {
                return new FamilyFacebooksConverter(entity.getFamilyFacebookCollection(), uri.resolve("familyFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for familyFacebookCollection.
     *
     * @param value the value to set
     */
    public void setFamilyFacebookCollection(FamilyFacebooksConverter value) {
        entity.setFamilyFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for friendsFacebookCollection.
     *
     * @return value for friendsFacebookCollection
     */
    @XmlElement
    public FriendsFacebooksConverter getFriendsFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getFriendsFacebookCollection() != null) {
                return new FriendsFacebooksConverter(entity.getFriendsFacebookCollection(), uri.resolve("friendsFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for friendsFacebookCollection.
     *
     * @param value the value to set
     */
    public void setFriendsFacebookCollection(FriendsFacebooksConverter value) {
        entity.setFriendsFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for streamFacebookCollection.
     *
     * @return value for streamFacebookCollection
     */
    @XmlElement
    public StreamFacebooksConverter getStreamFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getStreamFacebookCollection() != null) {
                return new StreamFacebooksConverter(entity.getStreamFacebookCollection(), uri.resolve("streamFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for streamFacebookCollection.
     *
     * @param value the value to set
     */
    public void setStreamFacebookCollection(StreamFacebooksConverter value) {
        entity.setStreamFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for locationfacebookhasuserfacebookCURRENTLOCATIONCollection.
     *
     * @return value for locationfacebookhasuserfacebookCURRENTLOCATIONCollection
     */
    @XmlElement
    public LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection() {
        if (expandLevel > 0) {
            if (entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection() != null) {
                return new LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter(entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection(), uri.resolve("locationfacebookhasuserfacebookCURRENTLOCATIONCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for locationfacebookhasuserfacebookCURRENTLOCATIONCollection.
     *
     * @param value the value to set
     */
    public void setLocationfacebookhasuserfacebookCURRENTLOCATIONCollection(LocationfacebookhasuserfacebookCURRENTLOCATIONsConverter value) {
        entity.setLocationfacebookhasuserfacebookCURRENTLOCATIONCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for affiliationsFacebookCollection.
     *
     * @return value for affiliationsFacebookCollection
     */
    @XmlElement
    public AffiliationsFacebooksConverter getAffiliationsFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getAffiliationsFacebookCollection() != null) {
                return new AffiliationsFacebooksConverter(entity.getAffiliationsFacebookCollection(), uri.resolve("affiliationsFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for affiliationsFacebookCollection.
     *
     * @param value the value to set
     */
    public void setAffiliationsFacebookCollection(AffiliationsFacebooksConverter value) {
        entity.setAffiliationsFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for educationHistoryFacebookCollection.
     *
     * @return value for educationHistoryFacebookCollection
     */
    @XmlElement
    public EducationHistoryFacebooksConverter getEducationHistoryFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getEducationHistoryFacebookCollection() != null) {
                return new EducationHistoryFacebooksConverter(entity.getEducationHistoryFacebookCollection(), uri.resolve("educationHistoryFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for educationHistoryFacebookCollection.
     *
     * @param value the value to set
     */
    public void setEducationHistoryFacebookCollection(EducationHistoryFacebooksConverter value) {
        entity.setEducationHistoryFacebookCollection((value != null) ? value.getEntities() : null);
    }

    /**
     * Getter for workHistoryFacebookCollection.
     *
     * @return value for workHistoryFacebookCollection
     */
    @XmlElement
    public WorkHistoryFacebooksConverter getWorkHistoryFacebookCollection() {
        if (expandLevel > 0) {
            if (entity.getWorkHistoryFacebookCollection() != null) {
                return new WorkHistoryFacebooksConverter(entity.getWorkHistoryFacebookCollection(), uri.resolve("workHistoryFacebookCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for workHistoryFacebookCollection.
     *
     * @param value the value to set
     */
    public void setWorkHistoryFacebookCollection(WorkHistoryFacebooksConverter value) {
        entity.setWorkHistoryFacebookCollection((value != null) ? value.getEntities() : null);
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
     * Returns the UserFacebook entity.
     *
     * @return an entity
     */
    @XmlTransient
    public UserFacebook getEntity() {
        if (entity.getIdUserFacebook() == null) {
            UserFacebookConverter converter = UriResolver.getInstance().resolve(UserFacebookConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved UserFacebook entity.
     *
     * @return an resolved entity
     */
    public UserFacebook resolveEntity(EntityManager em) {
        Collection<LocationFacebook> locationFacebookCollection = entity.getLocationFacebookCollection();
        Collection<LocationFacebook> newlocationFacebookCollection = new java.util.ArrayList<LocationFacebook>();
        if (locationFacebookCollection != null) {
            for (LocationFacebook item : locationFacebookCollection) {
                newlocationFacebookCollection.add(em.getReference(LocationFacebook.class, item.getIdLocationFacebook()));
            }
        }
        entity.setLocationFacebookCollection(newlocationFacebookCollection);
        Collection<FamilyFacebook> familyFacebookCollection = entity.getFamilyFacebookCollection();
        Collection<FamilyFacebook> newfamilyFacebookCollection = new java.util.ArrayList<FamilyFacebook>();
        if (familyFacebookCollection != null) {
            for (FamilyFacebook item : familyFacebookCollection) {
                newfamilyFacebookCollection.add(em.getReference(FamilyFacebook.class, item.getIdFamilyFacebook()));
            }
        }
        entity.setFamilyFacebookCollection(newfamilyFacebookCollection);
        Collection<FriendsFacebook> friendsFacebookCollection = entity.getFriendsFacebookCollection();
        Collection<FriendsFacebook> newfriendsFacebookCollection = new java.util.ArrayList<FriendsFacebook>();
        if (friendsFacebookCollection != null) {
            for (FriendsFacebook item : friendsFacebookCollection) {
                newfriendsFacebookCollection.add(em.getReference(FriendsFacebook.class, item.getUserUid()));
            }
        }
        entity.setFriendsFacebookCollection(newfriendsFacebookCollection);
        Collection<StreamFacebook> streamFacebookCollection = entity.getStreamFacebookCollection();
        Collection<StreamFacebook> newstreamFacebookCollection = new java.util.ArrayList<StreamFacebook>();
        if (streamFacebookCollection != null) {
            for (StreamFacebook item : streamFacebookCollection) {
                newstreamFacebookCollection.add(em.getReference(StreamFacebook.class, item.getPostId()));
            }
        }
        entity.setStreamFacebookCollection(newstreamFacebookCollection);
        Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> locationfacebookhasuserfacebookCURRENTLOCATIONCollection = entity.getLocationfacebookhasuserfacebookCURRENTLOCATIONCollection();
        Collection<LocationfacebookhasuserfacebookCURRENTLOCATION> newlocationfacebookhasuserfacebookCURRENTLOCATIONCollection = new java.util.ArrayList<LocationfacebookhasuserfacebookCURRENTLOCATION>();
        if (locationfacebookhasuserfacebookCURRENTLOCATIONCollection != null) {
            for (LocationfacebookhasuserfacebookCURRENTLOCATION item : locationfacebookhasuserfacebookCURRENTLOCATIONCollection) {
                newlocationfacebookhasuserfacebookCURRENTLOCATIONCollection.add(em.getReference(LocationfacebookhasuserfacebookCURRENTLOCATION.class, item.getLocationfacebookhasuserfacebookCURRENTLOCATIONPK()));
            }
        }
        entity.setLocationfacebookhasuserfacebookCURRENTLOCATIONCollection(newlocationfacebookhasuserfacebookCURRENTLOCATIONCollection);
        Collection<AffiliationsFacebook> affiliationsFacebookCollection = entity.getAffiliationsFacebookCollection();
        Collection<AffiliationsFacebook> newaffiliationsFacebookCollection = new java.util.ArrayList<AffiliationsFacebook>();
        if (affiliationsFacebookCollection != null) {
            for (AffiliationsFacebook item : affiliationsFacebookCollection) {
                newaffiliationsFacebookCollection.add(em.getReference(AffiliationsFacebook.class, item.getIdAffiliationsFacebook()));
            }
        }
        entity.setAffiliationsFacebookCollection(newaffiliationsFacebookCollection);
        Collection<EducationHistoryFacebook> educationHistoryFacebookCollection = entity.getEducationHistoryFacebookCollection();
        Collection<EducationHistoryFacebook> neweducationHistoryFacebookCollection = new java.util.ArrayList<EducationHistoryFacebook>();
        if (educationHistoryFacebookCollection != null) {
            for (EducationHistoryFacebook item : educationHistoryFacebookCollection) {
                neweducationHistoryFacebookCollection.add(em.getReference(EducationHistoryFacebook.class, item.getIdEducationHistoryFacebook()));
            }
        }
        entity.setEducationHistoryFacebookCollection(neweducationHistoryFacebookCollection);
        Collection<WorkHistoryFacebook> workHistoryFacebookCollection = entity.getWorkHistoryFacebookCollection();
        Collection<WorkHistoryFacebook> newworkHistoryFacebookCollection = new java.util.ArrayList<WorkHistoryFacebook>();
        if (workHistoryFacebookCollection != null) {
            for (WorkHistoryFacebook item : workHistoryFacebookCollection) {
                newworkHistoryFacebookCollection.add(em.getReference(WorkHistoryFacebook.class, item.getIdWorkHistoryFacebook()));
            }
        }
        entity.setWorkHistoryFacebookCollection(newworkHistoryFacebookCollection);
     /*   Collection<User> userCollection = entity.getUserCollection();
        Collection<User> newuserCollection = new java.util.ArrayList<User>();
        if (userCollection != null) {
            for (User item : userCollection) {
                newuserCollection.add(em.getReference(User.class, item.getUserSettingsUid()));
            }
        }
        entity.setUserCollection(newuserCollection);*/
        return entity;
    }
}
