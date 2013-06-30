/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.converter;

import es.uah.cc.ie.persistence.LocaleSettings;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;
import es.uah.cc.ie.persistence.UserSettings;
import java.util.Collection;

/**
 *
 * @author tote
 */
@XmlRootElement(name = "localeSettings")
public class LocaleSettingsConverter {

    private LocaleSettings entity;
    private URI uri;
    private int expandLevel;

    /** Creates a new instance of LocaleSettingsConverter */
    public LocaleSettingsConverter() {
        entity = new LocaleSettings();
    }

    /**
     * Creates a new instance of LocaleSettingsConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public LocaleSettingsConverter(LocaleSettings entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getIdLocale() + "/").build() : uri;
        this.expandLevel = expandLevel;
        getUserSettingsCollection();
    }

    /**
     * Creates a new instance of LocaleSettingsConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public LocaleSettingsConverter(LocaleSettings entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for idLocale.
     *
     * @return value for idLocale
     */
    @XmlElement
    public String getIdLocale() {
        return (expandLevel > 0) ? entity.getIdLocale() : null;
    }

    /**
     * Setter for idLocale.
     *
     * @param value the value to set
     */
    public void setIdLocale(String value) {
        entity.setIdLocale(value);
    }

    /**
     * Getter for acceptingTerms.
     *
     * @return value for acceptingTerms
     */
    @XmlElement
    public String getAcceptingTerms() {
        return (expandLevel > 0) ? entity.getAcceptingTerms() : null;
    }

    /**
     * Setter for acceptingTerms.
     *
     * @param value the value to set
     */
    public void setAcceptingTerms(String value) {
        entity.setAcceptingTerms(value);
    }

    /**
     * Getter for legalAccepted.
     *
     * @return value for legalAccepted
     */
    @XmlElement
    public String getLegalAccepted() {
        return (expandLevel > 0) ? entity.getLegalAccepted() : null;
    }

    /**
     * Setter for legalAccepted.
     *
     * @param value the value to set
     */
    public void setLegalAccepted(String value) {
        entity.setLegalAccepted(value);
    }

    /**
     * Getter for btnAgreeAT.
     *
     * @return value for btnAgreeAT
     */
    @XmlElement
    public String getBtnAgreeAT() {
        return (expandLevel > 0) ? entity.getBtnAgreeAT() : null;
    }

    /**
     * Setter for btnAgreeAT.
     *
     * @param value the value to set
     */
    public void setBtnAgreeAT(String value) {
        entity.setBtnAgreeAT(value);
    }

    /**
     * Getter for btnCancelAT.
     *
     * @return value for btnCancelAT
     */
    @XmlElement
    public String getBtnCancelAT() {
        return (expandLevel > 0) ? entity.getBtnCancelAT() : null;
    }

    /**
     * Setter for btnCancelAT.
     *
     * @param value the value to set
     */
    public void setBtnCancelAT(String value) {
        entity.setBtnCancelAT(value);
    }

    /**
     * Getter for titleAT.
     *
     * @return value for titleAT
     */
    @XmlElement
    public String getTitleAT() {
        return (expandLevel > 0) ? entity.getTitleAT() : null;
    }

    /**
     * Setter for titleAT.
     *
     * @param value the value to set
     */
    public void setTitleAT(String value) {
        entity.setTitleAT(value);
    }

    /**
     * Getter for titleSettings.
     *
     * @return value for titleSettings
     */
    @XmlElement
    public String getTitleSettings() {
        return (expandLevel > 0) ? entity.getTitleSettings() : null;
    }

    /**
     * Setter for titleSettings.
     *
     * @param value the value to set
     */
    public void setTitleSettings(String value) {
        entity.setTitleSettings(value);
    }

    /**
     * Getter for titleMenSettings.
     *
     * @return value for titleMenSettings
     */
    @XmlElement
    public String getTitleMenSettings() {
        return (expandLevel > 0) ? entity.getTitleMenSettings() : null;
    }

    /**
     * Setter for titleMenSettings.
     *
     * @param value the value to set
     */
    public void setTitleMenSettings(String value) {
        entity.setTitleMenSettings(value);
    }

    /**
     * Getter for btnSaveCheckSettings.
     *
     * @return value for btnSaveCheckSettings
     */
    @XmlElement
    public String getBtnSaveCheckSettings() {
        return (expandLevel > 0) ? entity.getBtnSaveCheckSettings() : null;
    }

    /**
     * Setter for btnSaveCheckSettings.
     *
     * @param value the value to set
     */
    public void setBtnSaveCheckSettings(String value) {
        entity.setBtnSaveCheckSettings(value);
    }

    /**
     * Getter for titleSettAng.
     *
     * @return value for titleSettAng
     */
    @XmlElement
    public String getTitleSettAng() {
        return (expandLevel > 0) ? entity.getTitleSettAng() : null;
    }

    /**
     * Setter for titleSettAng.
     *
     * @param value the value to set
     */
    public void setTitleSettAng(String value) {
        entity.setTitleSettAng(value);
    }

    /**
     * Getter for titleFriendsContentSettAng.
     *
     * @return value for titleFriendsContentSettAng
     */
    @XmlElement
    public String getTitleFriendsContentSettAng() {
        return (expandLevel > 0) ? entity.getTitleFriendsContentSettAng() : null;
    }

    /**
     * Setter for titleFriendsContentSettAng.
     *
     * @param value the value to set
     */
    public void setTitleFriendsContentSettAng(String value) {
        entity.setTitleFriendsContentSettAng(value);
    }

    /**
     * Getter for titleFriendsImportSettAng.
     *
     * @return value for titleFriendsImportSettAng
     */
    @XmlElement
    public String getTitleFriendsImportSettAng() {
        return (expandLevel > 0) ? entity.getTitleFriendsImportSettAng() : null;
    }

    /**
     * Setter for titleFriendsImportSettAng.
     *
     * @param value the value to set
     */
    public void setTitleFriendsImportSettAng(String value) {
        entity.setTitleFriendsImportSettAng(value);
    }

    /**
     * Getter for txtNameTutorSettAng.
     *
     * @return value for txtNameTutorSettAng
     */
    @XmlElement
    public String getTxtNameTutorSettAng() {
        return (expandLevel > 0) ? entity.getTxtNameTutorSettAng() : null;
    }

    /**
     * Setter for txtNameTutorSettAng.
     *
     * @param value the value to set
     */
    public void setTxtNameTutorSettAng(String value) {
        entity.setTxtNameTutorSettAng(value);
    }

    /**
     * Getter for txtEmailTutorSettAng.
     *
     * @return value for txtEmailTutorSettAng
     */
    @XmlElement
    public String getTxtEmailTutorSettAng() {
        return (expandLevel > 0) ? entity.getTxtEmailTutorSettAng() : null;
    }

    /**
     * Setter for txtEmailTutorSettAng.
     *
     * @param value the value to set
     */
    public void setTxtEmailTutorSettAng(String value) {
        entity.setTxtEmailTutorSettAng(value);
    }

    /**
     * Getter for btnImportSettAng.
     *
     * @return value for btnImportSettAng
     */
    @XmlElement
    public String getBtnImportSettAng() {
        return (expandLevel > 0) ? entity.getBtnImportSettAng() : null;
    }

    /**
     * Setter for btnImportSettAng.
     *
     * @param value the value to set
     */
    public void setBtnImportSettAng(String value) {
        entity.setBtnImportSettAng(value);
    }

    /**
     * Getter for titleFbListSettAng.
     *
     * @return value for titleFbListSettAng
     */
    @XmlElement
    public String getTitleFbListSettAng() {
        return (expandLevel > 0) ? entity.getTitleFbListSettAng() : null;
    }

    /**
     * Setter for titleFbListSettAng.
     *
     * @param value the value to set
     */
    public void setTitleFbListSettAng(String value) {
        entity.setTitleFbListSettAng(value);
    }

    /**
     * Getter for subTitleAngelSettAng.
     *
     * @return value for subTitleAngelSettAng
     */
    @XmlElement
    public String getSubTitleAngelSettAng() {
        return (expandLevel > 0) ? entity.getSubTitleAngelSettAng() : null;
    }

    /**
     * Setter for subTitleAngelSettAng.
     *
     * @param value the value to set
     */
    public void setSubTitleAngelSettAng(String value) {
        entity.setSubTitleAngelSettAng(value);
    }

    /**
     * Getter for titleSettVig.
     *
     * @return value for titleSettVig
     */
    @XmlElement
    public String getTitleSettVig() {
        return (expandLevel > 0) ? entity.getTitleSettVig() : null;
    }

    /**
     * Setter for titleSettVig.
     *
     * @param value the value to set
     */
    public void setTitleSettVig(String value) {
        entity.setTitleSettVig(value);
    }

    /**
     * Getter for titleVigilantSettVig.
     *
     * @return value for titleVigilantSettVig
     */
    @XmlElement
    public String getTitleVigilantSettVig() {
        return (expandLevel > 0) ? entity.getTitleVigilantSettVig() : null;
    }

    /**
     * Setter for titleVigilantSettVig.
     *
     * @param value the value to set
     */
    public void setTitleVigilantSettVig(String value) {
        entity.setTitleVigilantSettVig(value);
    }

    /**
     * Getter for titleVigSettVig.
     *
     * @return value for titleVigSettVig
     */
    @XmlElement
    public String getTitleVigSettVig() {
        return (expandLevel > 0) ? entity.getTitleVigSettVig() : null;
    }

    /**
     * Setter for titleVigSettVig.
     *
     * @param value the value to set
     */
    public void setTitleVigSettVig(String value) {
        entity.setTitleVigSettVig(value);
    }

    /**
     * Getter for titleVigDescriptionSettVig.
     *
     * @return value for titleVigDescriptionSettVig
     */
    @XmlElement
    public String getTitleVigDescriptionSettVig() {
        return (expandLevel > 0) ? entity.getTitleVigDescriptionSettVig() : null;
    }

    /**
     * Setter for titleVigDescriptionSettVig.
     *
     * @param value the value to set
     */
    public void setTitleVigDescriptionSettVig(String value) {
        entity.setTitleVigDescriptionSettVig(value);
    }

    /**
     * Getter for titleVigFrecSettVig.
     *
     * @return value for titleVigFrecSettVig
     */
    @XmlElement
    public String getTitleVigFrecSettVig() {
        return (expandLevel > 0) ? entity.getTitleVigFrecSettVig() : null;
    }

    /**
     * Setter for titleVigFrecSettVig.
     *
     * @param value the value to set
     */
    public void setTitleVigFrecSettVig(String value) {
        entity.setTitleVigFrecSettVig(value);
    }

    /**
     * Getter for titleVigFrecSelectSettVig.
     *
     * @return value for titleVigFrecSelectSettVig
     */
    @XmlElement
    public String getTitleVigFrecSelectSettVig() {
        return (expandLevel > 0) ? entity.getTitleVigFrecSelectSettVig() : null;
    }

    /**
     * Setter for titleVigFrecSelectSettVig.
     *
     * @param value the value to set
     */
    public void setTitleVigFrecSelectSettVig(String value) {
        entity.setTitleVigFrecSelectSettVig(value);
    }

    /**
     * Getter for titleVigAngSettVig.
     *
     * @return value for titleVigAngSettVig
     */
    @XmlElement
    public String getTitleVigAngSettVig() {
        return (expandLevel > 0) ? entity.getTitleVigAngSettVig() : null;
    }

    /**
     * Setter for titleVigAngSettVig.
     *
     * @param value the value to set
     */
    public void setTitleVigAngSettVig(String value) {
        entity.setTitleVigAngSettVig(value);
    }

    /**
     * Getter for titleAngConfirm.
     *
     * @return value for titleAngConfirm
     */
    @XmlElement
    public String getTitleAngConfirm() {
        return (expandLevel > 0) ? entity.getTitleAngConfirm() : null;
    }

    /**
     * Setter for titleAngConfirm.
     *
     * @param value the value to set
     */
    public void setTitleAngConfirm(String value) {
        entity.setTitleAngConfirm(value);
    }

    /**
     * Getter for desInfoAngConfirm.
     *
     * @return value for desInfoAngConfirm
     */
    @XmlElement
    public String getDesInfoAngConfirm() {
        return (expandLevel > 0) ? entity.getDesInfoAngConfirm() : null;
    }

    /**
     * Setter for desInfoAngConfirm.
     *
     * @param value the value to set
     */
    public void setDesInfoAngConfirm(String value) {
        entity.setDesInfoAngConfirm(value);
    }

    /**
     * Getter for aceptConfAngConfirm.
     *
     * @return value for aceptConfAngConfirm
     */
    @XmlElement
    public String getAceptConfAngConfirm() {
        return (expandLevel > 0) ? entity.getAceptConfAngConfirm() : null;
    }

    /**
     * Setter for aceptConfAngConfirm.
     *
     * @param value the value to set
     */
    public void setAceptConfAngConfirm(String value) {
        entity.setAceptConfAngConfirm(value);
    }

    /**
     * Getter for cancelConfAngConfirm.
     *
     * @return value for cancelConfAngConfirm
     */
    @XmlElement
    public String getCancelConfAngConfirm() {
        return (expandLevel > 0) ? entity.getCancelConfAngConfirm() : null;
    }

    /**
     * Setter for cancelConfAngConfirm.
     *
     * @param value the value to set
     */
    public void setCancelConfAngConfirm(String value) {
        entity.setCancelConfAngConfirm(value);
    }

    /**
     * Getter for infoAngGuard.
     *
     * @return value for infoAngGuard
     */
    @XmlElement
    public String getInfoAngGuard() {
        return (expandLevel > 0) ? entity.getInfoAngGuard() : null;
    }

    /**
     * Setter for infoAngGuard.
     *
     * @param value the value to set
     */
    public void setInfoAngGuard(String value) {
        entity.setInfoAngGuard(value);
    }

    /**
     * Getter for titleAngUser.
     *
     * @return value for titleAngUser
     */
    @XmlElement
    public String getTitleAngUser() {
        return (expandLevel > 0) ? entity.getTitleAngUser() : null;
    }

    /**
     * Setter for titleAngUser.
     *
     * @param value the value to set
     */
    public void setTitleAngUser(String value) {
        entity.setTitleAngUser(value);
    }

    /**
     * Getter for nameUserAngUser.
     *
     * @return value for nameUserAngUser
     */
    @XmlElement
    public String getNameUserAngUser() {
        return (expandLevel > 0) ? entity.getNameUserAngUser() : null;
    }

    /**
     * Setter for nameUserAngUser.
     *
     * @param value the value to set
     */
    public void setNameUserAngUser(String value) {
        entity.setNameUserAngUser(value);
    }

    /**
     * Getter for btnCloseAngUser.
     *
     * @return value for btnCloseAngUser
     */
    @XmlElement
    public String getBtnCloseAngUser() {
        return (expandLevel > 0) ? entity.getBtnCloseAngUser() : null;
    }

    /**
     * Setter for btnCloseAngUser.
     *
     * @param value the value to set
     */
    public void setBtnCloseAngUser(String value) {
        entity.setBtnCloseAngUser(value);
    }

    /**
     * Getter for titleGoogleCont.
     *
     * @return value for titleGoogleCont
     */
    @XmlElement
    public String getTitleGoogleCont() {
        return (expandLevel > 0) ? entity.getTitleGoogleCont() : null;
    }

    /**
     * Setter for titleGoogleCont.
     *
     * @param value the value to set
     */
    public void setTitleGoogleCont(String value) {
        entity.setTitleGoogleCont(value);
    }

    /**
     * Getter for titleContGoogleCont.
     *
     * @return value for titleContGoogleCont
     */
    @XmlElement
    public String getTitleContGoogleCont() {
        return (expandLevel > 0) ? entity.getTitleContGoogleCont() : null;
    }

    /**
     * Setter for titleContGoogleCont.
     *
     * @param value the value to set
     */
    public void setTitleContGoogleCont(String value) {
        entity.setTitleContGoogleCont(value);
    }

    /**
     * Getter for btnLogGoogleCont.
     *
     * @return value for btnLogGoogleCont
     */
    @XmlElement
    public String getBtnLogGoogleCont() {
        return (expandLevel > 0) ? entity.getBtnLogGoogleCont() : null;
    }

    /**
     * Setter for btnLogGoogleCont.
     *
     * @param value the value to set
     */
    public void setBtnLogGoogleCont(String value) {
        entity.setBtnLogGoogleCont(value);
    }

    /**
     * Getter for titleNameContactGoogleCont.
     *
     * @return value for titleNameContactGoogleCont
     */
    @XmlElement
    public String getTitleNameContactGoogleCont() {
        return (expandLevel > 0) ? entity.getTitleNameContactGoogleCont() : null;
    }

    /**
     * Setter for titleNameContactGoogleCont.
     *
     * @param value the value to set
     */
    public void setTitleNameContactGoogleCont(String value) {
        entity.setTitleNameContactGoogleCont(value);
    }

    /**
     * Getter for titleEmailContactGoogleCont.
     *
     * @return value for titleEmailContactGoogleCont
     */
    @XmlElement
    public String getTitleEmailContactGoogleCont() {
        return (expandLevel > 0) ? entity.getTitleEmailContactGoogleCont() : null;
    }

    /**
     * Setter for titleEmailContactGoogleCont.
     *
     * @param value the value to set
     */
    public void setTitleEmailContactGoogleCont(String value) {
        entity.setTitleEmailContactGoogleCont(value);
    }

    /**
     * Getter for btnAceptGoogleCont.
     *
     * @return value for btnAceptGoogleCont
     */
    @XmlElement
    public String getBtnAceptGoogleCont() {
        return (expandLevel > 0) ? entity.getBtnAceptGoogleCont() : null;
    }

    /**
     * Setter for btnAceptGoogleCont.
     *
     * @param value the value to set
     */
    public void setBtnAceptGoogleCont(String value) {
        entity.setBtnAceptGoogleCont(value);
    }

    /**
     * Getter for btnCancelGoogleCont.
     *
     * @return value for btnCancelGoogleCont
     */
    @XmlElement
    public String getBtnCancelGoogleCont() {
        return (expandLevel > 0) ? entity.getBtnCancelGoogleCont() : null;
    }

    /**
     * Setter for btnCancelGoogleCont.
     *
     * @param value the value to set
     */
    public void setBtnCancelGoogleCont(String value) {
        entity.setBtnCancelGoogleCont(value);
    }

    /**
     * Getter for helpMe.
     *
     * @return value for helpMe
     */
    @XmlElement
    public String getHelpMe() {
        return (expandLevel > 0) ? entity.getHelpMe() : null;
    }

    /**
     * Setter for helpMe.
     *
     * @param value the value to set
     */
    public void setHelpMe(String value) {
        entity.setHelpMe(value);
    }

    /**
     * Getter for warnings.
     *
     * @return value for btnCancelGoogleCont
     */
    @XmlElement
    public String getWarnings() {
        return (expandLevel > 0) ? entity.getWarnings() : null;
    }

    /**
     * Setter for warnings.
     *
     * @param value the value to set
     */
    public void setWarnings(String value) {
        entity.setWarnings(value);
    }

    /**
     * Getter for titleInformationMessage.
     *
     * @return value for titleInformationMessage
     */
    @XmlElement
    public String getTitleInformationMessage() {
        return (expandLevel > 0) ? entity.getTitleInformationMessage() : null;
    }

    /**
     * Setter for titleInformationMessage.
     *
     * @param value the value to set
     */
    public void setTitleInformationMessage(String value) {
        entity.setTitleInformationMessage(value);
    }

    /**
     * Getter for informationMessage.
     *
     * @return value for informationMessage
     */
    @XmlElement
    public String getInformationMessage() {
        return (expandLevel > 0) ? entity.getInformationMessage() : null;
    }

    /**
     * Setter for informationMessage.
     *
     * @param value the value to set
     */
    public void setInformationMessage(String value) {
        entity.setInformationMessage(value);
    }

    /**
     * Getter for mailDelete.
     *
     * @return value for mailDelete
     */
    @XmlElement
    public String getMailDelete() {
        return (expandLevel > 0) ? entity.getMailDelete() : null;
    }

    /**
     * Setter for mailDelete.
     *
     * @param value the value to set
     */
    public void setMailDelete(String value) {
        entity.setMailDelete(value);
    }

    /**
     * Getter for mailNotification.
     *
     * @return value for mailNotification
     */
    @XmlElement
    public String getMailNotification() {
        return (expandLevel > 0) ? entity.getMailNotification() : null;
    }

    /**
     * Setter for mailNotification.
     *
     * @param value the value to set
     */
    public void setMailNotification(String value) {
        entity.setMailNotification(value);
    }

    /**
     * Geter for altContactsAngelsEd
     * 
     * @return value of altContactsAngelsEd
     */
    @XmlElement
    public String getAltContactsAngelsEd(){
        return (expandLevel > 0) ? entity.getAltContactsAngelsEd() : null;
    }

    /**
     * Setter for altContactsAngelsEd
     *
     * @param value the value to set
     */
    public void setAltContactsAngelsEd(String value){
        entity.setAltContactsAngelsEd(value);
    }

    /**
     * Geter for titleVisitsFilterOptions
     *
     * @return value of titleVisitsFilterOptions
     */
    @XmlElement
    public String getTitleVisitsFilterOptions() {
        return (expandLevel > 0) ? entity.getTitleVisitsFilterOptions() : null;
    }

    /**
     * Setter for titleVisitsFilterOptions
     *
     * @param value The value to set
     */
    public void setTitleVisitsFilterOptions(String value) {
        entity.setTitleVisitsFilterOptions(value);
    }


    /**
     * Getter for userSettingsCollection.
     *
     * @return value for userSettingsCollection
     */
    @XmlElement
    public UserSettingssConverter getUserSettingsCollection() {
        if (expandLevel > 0) {
            if (entity.getUserSettingsCollection() != null) {
                return new UserSettingssConverter(entity.getUserSettingsCollection(), uri.resolve("userSettingsCollection/"), expandLevel - 1);
            }
        }
        return null;
    }

    /**
     * Setter for userSettingsCollection.
     *
     * @param value the value to set
     */
    public void setUserSettingsCollection(UserSettingssConverter value) {
        entity.setUserSettingsCollection((value != null) ? value.getEntities() : null);
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
     * Returns the LocaleSettings entity.
     *
     * @return an entity
     */
    @XmlTransient
    public LocaleSettings getEntity() {
        if (entity.getIdLocale() == null) {
            LocaleSettingsConverter converter = UriResolver.getInstance().resolve(LocaleSettingsConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved LocaleSettings entity.
     *
     * @return an resolved entity
     */
    public LocaleSettings resolveEntity(EntityManager em) {
        Collection<UserSettings> userSettingsCollection = entity.getUserSettingsCollection();
        Collection<UserSettings> newuserSettingsCollection = new java.util.ArrayList<UserSettings>();
        if (userSettingsCollection != null) {
            for (UserSettings item : userSettingsCollection) {
                newuserSettingsCollection.add(em.getReference(UserSettings.class, item.getUid()));
            }
        }
        entity.setUserSettingsCollection(newuserSettingsCollection);
        return entity;
    }
}
