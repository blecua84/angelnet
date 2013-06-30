/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.persistence;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author tote
 */
@Entity
@Table(name = "locale_settings")
@NamedQueries({
    @NamedQuery(name = "LocaleSettings.findAll", query = "SELECT l FROM LocaleSettings l"),
    @NamedQuery(name = "LocaleSettings.findByIdLocale", query = "SELECT l FROM LocaleSettings l WHERE l.idLocale = :idLocale"),
    @NamedQuery(name = "LocaleSettings.findByAcceptingTerms", query = "SELECT l FROM LocaleSettings l WHERE l.acceptingTerms = :acceptingTerms"),
    @NamedQuery(name = "LocaleSettings.findByBtnAgreeAT", query = "SELECT l FROM LocaleSettings l WHERE l.btnAgreeAT = :btnAgreeAT"),
    @NamedQuery(name = "LocaleSettings.findByBtnCancelAT", query = "SELECT l FROM LocaleSettings l WHERE l.btnCancelAT = :btnCancelAT"),
    @NamedQuery(name = "LocaleSettings.findByTitleAT", query = "SELECT l FROM LocaleSettings l WHERE l.titleAT = :titleAT"),
    @NamedQuery(name = "LocaleSettings.findByTitleSettings", query = "SELECT l FROM LocaleSettings l WHERE l.titleSettings = :titleSettings"),
    @NamedQuery(name = "LocaleSettings.findByTitleMenSettings", query = "SELECT l FROM LocaleSettings l WHERE l.titleMenSettings = :titleMenSettings"),
    @NamedQuery(name = "LocaleSettings.findByBtnSaveCheckSettings", query = "SELECT l FROM LocaleSettings l WHERE l.btnSaveCheckSettings = :btnSaveCheckSettings"),
    @NamedQuery(name = "LocaleSettings.findByTitleSettAng", query = "SELECT l FROM LocaleSettings l WHERE l.titleSettAng = :titleSettAng"),
    @NamedQuery(name = "LocaleSettings.findByTitleFriendsContentSettAng", query = "SELECT l FROM LocaleSettings l WHERE l.titleFriendsContentSettAng = :titleFriendsContentSettAng"),
    @NamedQuery(name = "LocaleSettings.findByTitleFriendsImportSettAng", query = "SELECT l FROM LocaleSettings l WHERE l.titleFriendsImportSettAng = :titleFriendsImportSettAng"),
    @NamedQuery(name = "LocaleSettings.findByTxtNameTutorSettAng", query = "SELECT l FROM LocaleSettings l WHERE l.txtNameTutorSettAng = :txtNameTutorSettAng"),
    @NamedQuery(name = "LocaleSettings.findByTxtEmailTutorSettAng", query = "SELECT l FROM LocaleSettings l WHERE l.txtEmailTutorSettAng = :txtEmailTutorSettAng"),
    @NamedQuery(name = "LocaleSettings.findByBtnImportSettAng", query = "SELECT l FROM LocaleSettings l WHERE l.btnImportSettAng = :btnImportSettAng"),
    @NamedQuery(name = "LocaleSettings.findByTitleFbListSettAng", query = "SELECT l FROM LocaleSettings l WHERE l.titleFbListSettAng = :titleFbListSettAng"),
    @NamedQuery(name = "LocaleSettings.findBySubTitleAngelSettAng", query = "SELECT l FROM LocaleSettings l WHERE l.subTitleAngelSettAng = :subTitleAngelSettAng"),
    @NamedQuery(name = "LocaleSettings.findByTitleSettVig", query = "SELECT l FROM LocaleSettings l WHERE l.titleSettVig = :titleSettVig"),
    @NamedQuery(name = "LocaleSettings.findByTitleVigilantSettVig", query = "SELECT l FROM LocaleSettings l WHERE l.titleVigilantSettVig = :titleVigilantSettVig"),
    @NamedQuery(name = "LocaleSettings.findByTitleVigSettVig", query = "SELECT l FROM LocaleSettings l WHERE l.titleVigSettVig = :titleVigSettVig"),
    @NamedQuery(name = "LocaleSettings.findByTitleVigDescriptionSettVig", query = "SELECT l FROM LocaleSettings l WHERE l.titleVigDescriptionSettVig = :titleVigDescriptionSettVig"),
    @NamedQuery(name = "LocaleSettings.findByTitleVigFrecSettVig", query = "SELECT l FROM LocaleSettings l WHERE l.titleVigFrecSettVig = :titleVigFrecSettVig"),
    @NamedQuery(name = "LocaleSettings.findByTitleVigFrecSelectSettVig", query = "SELECT l FROM LocaleSettings l WHERE l.titleVigFrecSelectSettVig = :titleVigFrecSelectSettVig"),
    @NamedQuery(name = "LocaleSettings.findByTitleVigAngSettVig", query = "SELECT l FROM LocaleSettings l WHERE l.titleVigAngSettVig = :titleVigAngSettVig"),
    @NamedQuery(name = "LocaleSettings.findByTitleAngConfirm", query = "SELECT l FROM LocaleSettings l WHERE l.titleAngConfirm = :titleAngConfirm"),
    @NamedQuery(name = "LocaleSettings.findByDesInfoAngConfirm", query = "SELECT l FROM LocaleSettings l WHERE l.desInfoAngConfirm = :desInfoAngConfirm"),
    @NamedQuery(name = "LocaleSettings.findByAceptConfAngConfirm", query = "SELECT l FROM LocaleSettings l WHERE l.aceptConfAngConfirm = :aceptConfAngConfirm"),
    @NamedQuery(name = "LocaleSettings.findByCancelConfAngConfirm", query = "SELECT l FROM LocaleSettings l WHERE l.cancelConfAngConfirm = :cancelConfAngConfirm"),
    @NamedQuery(name = "LocaleSettings.findByInfoAngGuard", query = "SELECT l FROM LocaleSettings l WHERE l.infoAngGuard = :infoAngGuard"),
    @NamedQuery(name = "LocaleSettings.findByTitleAngUser", query = "SELECT l FROM LocaleSettings l WHERE l.titleAngUser = :titleAngUser"),
    @NamedQuery(name = "LocaleSettings.findByNameUserAngUser", query = "SELECT l FROM LocaleSettings l WHERE l.nameUserAngUser = :nameUserAngUser"),
    @NamedQuery(name = "LocaleSettings.findByBtnCloseAngUser", query = "SELECT l FROM LocaleSettings l WHERE l.btnCloseAngUser = :btnCloseAngUser"),
    @NamedQuery(name = "LocaleSettings.findByTitleGoogleCont", query = "SELECT l FROM LocaleSettings l WHERE l.titleGoogleCont = :titleGoogleCont"),
    @NamedQuery(name = "LocaleSettings.findByTitleContGoogleCont", query = "SELECT l FROM LocaleSettings l WHERE l.titleContGoogleCont = :titleContGoogleCont"),
    @NamedQuery(name = "LocaleSettings.findByBtnLogGoogleCont", query = "SELECT l FROM LocaleSettings l WHERE l.btnLogGoogleCont = :btnLogGoogleCont"),
    @NamedQuery(name = "LocaleSettings.findByTitleNameContactGoogleCont", query = "SELECT l FROM LocaleSettings l WHERE l.titleNameContactGoogleCont = :titleNameContactGoogleCont"),
    @NamedQuery(name = "LocaleSettings.findByTitleEmailContactGoogleCont", query = "SELECT l FROM LocaleSettings l WHERE l.titleEmailContactGoogleCont = :titleEmailContactGoogleCont"),
    @NamedQuery(name = "LocaleSettings.findByBtnAceptGoogleCont", query = "SELECT l FROM LocaleSettings l WHERE l.btnAceptGoogleCont = :btnAceptGoogleCont"),
    @NamedQuery(name = "LocaleSettings.findByBtnCancelGoogleCont", query = "SELECT l FROM LocaleSettings l WHERE l.btnCancelGoogleCont = :btnCancelGoogleCont")})
public class LocaleSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_locale")
    private String idLocale;
    @Column(name = "acceptingTerms")
    private String acceptingTerms;
    @Lob
    @Column(name = "legalAccepted")
    private String legalAccepted;
    @Column(name = "btnAgreeAT")
    private String btnAgreeAT;
    @Column(name = "btnCancelAT")
    private String btnCancelAT;
    @Column(name = "titleAT")
    private String titleAT;
    @Column(name = "titleSettings")
    private String titleSettings;
    @Column(name = "titleMenSettings")
    private String titleMenSettings;
    @Column(name = "btnSaveCheckSettings")
    private String btnSaveCheckSettings;
    @Column(name = "titleSettAng")
    private String titleSettAng;
    @Column(name = "titleFriendsContentSettAng")
    private String titleFriendsContentSettAng;
    @Column(name = "titleFriendsImportSettAng")
    private String titleFriendsImportSettAng;
    @Column(name = "txtNameTutorSettAng")
    private String txtNameTutorSettAng;
    @Column(name = "txtEmailTutorSettAng")
    private String txtEmailTutorSettAng;
    @Column(name = "btnImportSettAng")
    private String btnImportSettAng;
    @Column(name = "titleFbListSettAng")
    private String titleFbListSettAng;
    @Column(name = "subTitleAngelSettAng")
    private String subTitleAngelSettAng;
    @Column(name = "titleSettVig")
    private String titleSettVig;
    @Column(name = "titleVigilantSettVig")
    private String titleVigilantSettVig;
    @Column(name = "titleVigSettVig")
    private String titleVigSettVig;
    @Column(name = "titleVigDescriptionSettVig")
    private String titleVigDescriptionSettVig;
    @Column(name = "titleVigFrecSettVig")
    private String titleVigFrecSettVig;
    @Column(name = "titleVigFrecSelectSettVig")
    private String titleVigFrecSelectSettVig;
    @Column(name = "titleVigAngSettVig")
    private String titleVigAngSettVig;
    @Column(name = "titleAngConfirm")
    private String titleAngConfirm;
    @Column(name = "desInfoAngConfirm")
    private String desInfoAngConfirm;
    @Column(name = "aceptConfAngConfirm")
    private String aceptConfAngConfirm;
    @Column(name = "cancelConfAngConfirm")
    private String cancelConfAngConfirm;
    @Column(name = "infoAngGuard")
    private String infoAngGuard;
    @Column(name = "titleAngUser")
    private String titleAngUser;
    @Column(name = "nameUserAngUser")
    private String nameUserAngUser;
    @Column(name = "btnCloseAngUser")
    private String btnCloseAngUser;
    @Column(name = "titleGoogleCont")
    private String titleGoogleCont;
    @Column(name = "titleContGoogleCont")
    private String titleContGoogleCont;
    @Column(name = "btnLogGoogleCont")
    private String btnLogGoogleCont;
    @Column(name = "titleNameContactGoogleCont")
    private String titleNameContactGoogleCont;
    @Column(name = "titleEmailContactGoogleCont")
    private String titleEmailContactGoogleCont;
    @Column(name = "btnAceptGoogleCont")
    private String btnAceptGoogleCont;
    @Column(name = "btnCancelGoogleCont")
    private String btnCancelGoogleCont;
    @Column(name = "helpMe")
    private String helpMe;
    @Column(name = "warnings")
    private String warnings;
    @Column(name = "titleInformationMessage")
    private String titleInformationMessage;
    @Column(name = "informationMessage")
    private String informationMessage;
    @Column(name = "mailDelete")
    private String mailDelete;
    @Column(name = "mailNotification")
    private String mailNotification;
    @Column(name = "altContactsAngelsEd")
    private String altContactsAngelsEd;
    @Column(name = "titleVisitsFilterOptions")
    private String titleVisitsFilterOptions;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "localeSettings")
    private Collection<UserSettings> userSettingsCollection;

    public LocaleSettings() {
    }

    public LocaleSettings(String idLocale) {
        this.idLocale = idLocale;
    }

    public String getIdLocale() {
        return idLocale;
    }

    public void setIdLocale(String idLocale) {
        this.idLocale = idLocale;
    }

    public String getAcceptingTerms() {
        return acceptingTerms;
    }

    public void setAcceptingTerms(String acceptingTerms) {
        this.acceptingTerms = acceptingTerms;
    }

    public String getLegalAccepted() {
        return legalAccepted;
    }

    public void setLegalAccepted(String legalAccepted) {
        this.legalAccepted = legalAccepted;
    }

    public String getBtnAgreeAT() {
        return btnAgreeAT;
    }

    public void setBtnAgreeAT(String btnAgreeAT) {
        this.btnAgreeAT = btnAgreeAT;
    }

    public String getBtnCancelAT() {
        return btnCancelAT;
    }

    public void setBtnCancelAT(String btnCancelAT) {
        this.btnCancelAT = btnCancelAT;
    }

    public String getTitleAT() {
        return titleAT;
    }

    public void setTitleAT(String titleAT) {
        this.titleAT = titleAT;
    }

    public String getTitleSettings() {
        return titleSettings;
    }

    public void setTitleSettings(String titleSettings) {
        this.titleSettings = titleSettings;
    }

    public String getTitleMenSettings() {
        return titleMenSettings;
    }

    public void setTitleMenSettings(String titleMenSettings) {
        this.titleMenSettings = titleMenSettings;
    }

    public String getBtnSaveCheckSettings() {
        return btnSaveCheckSettings;
    }

    public void setBtnSaveCheckSettings(String btnSaveCheckSettings) {
        this.btnSaveCheckSettings = btnSaveCheckSettings;
    }

    public String getTitleSettAng() {
        return titleSettAng;
    }

    public void setTitleSettAng(String titleSettAng) {
        this.titleSettAng = titleSettAng;
    }

    public String getTitleFriendsContentSettAng() {
        return titleFriendsContentSettAng;
    }

    public void setTitleFriendsContentSettAng(String titleFriendsContentSettAng) {
        this.titleFriendsContentSettAng = titleFriendsContentSettAng;
    }

    public String getTitleFriendsImportSettAng() {
        return titleFriendsImportSettAng;
    }

    public void setTitleFriendsImportSettAng(String titleFriendsImportSettAng) {
        this.titleFriendsImportSettAng = titleFriendsImportSettAng;
    }

    public String getTxtNameTutorSettAng() {
        return txtNameTutorSettAng;
    }

    public void setTxtNameTutorSettAng(String txtNameTutorSettAng) {
        this.txtNameTutorSettAng = txtNameTutorSettAng;
    }

    public String getTxtEmailTutorSettAng() {
        return txtEmailTutorSettAng;
    }

    public void setTxtEmailTutorSettAng(String txtEmailTutorSettAng) {
        this.txtEmailTutorSettAng = txtEmailTutorSettAng;
    }

    public String getBtnImportSettAng() {
        return btnImportSettAng;
    }

    public void setBtnImportSettAng(String btnImportSettAng) {
        this.btnImportSettAng = btnImportSettAng;
    }

    public String getTitleFbListSettAng() {
        return titleFbListSettAng;
    }

    public void setTitleFbListSettAng(String titleFbListSettAng) {
        this.titleFbListSettAng = titleFbListSettAng;
    }

    public String getSubTitleAngelSettAng() {
        return subTitleAngelSettAng;
    }

    public void setSubTitleAngelSettAng(String subTitleAngelSettAng) {
        this.subTitleAngelSettAng = subTitleAngelSettAng;
    }

    public String getTitleSettVig() {
        return titleSettVig;
    }

    public void setTitleSettVig(String titleSettVig) {
        this.titleSettVig = titleSettVig;
    }

    public String getTitleVigilantSettVig() {
        return titleVigilantSettVig;
    }

    public void setTitleVigilantSettVig(String titleVigilantSettVig) {
        this.titleVigilantSettVig = titleVigilantSettVig;
    }

    public String getTitleVigSettVig() {
        return titleVigSettVig;
    }

    public void setTitleVigSettVig(String titleVigSettVig) {
        this.titleVigSettVig = titleVigSettVig;
    }

    public String getTitleVigDescriptionSettVig() {
        return titleVigDescriptionSettVig;
    }

    public void setTitleVigDescriptionSettVig(String titleVigDescriptionSettVig) {
        this.titleVigDescriptionSettVig = titleVigDescriptionSettVig;
    }

    public String getTitleVigFrecSettVig() {
        return titleVigFrecSettVig;
    }

    public void setTitleVigFrecSettVig(String titleVigFrecSettVig) {
        this.titleVigFrecSettVig = titleVigFrecSettVig;
    }

    public String getTitleVigFrecSelectSettVig() {
        return titleVigFrecSelectSettVig;
    }

    public void setTitleVigFrecSelectSettVig(String titleVigFrecSelectSettVig) {
        this.titleVigFrecSelectSettVig = titleVigFrecSelectSettVig;
    }

    public String getTitleVigAngSettVig() {
        return titleVigAngSettVig;
    }

    public void setTitleVigAngSettVig(String titleVigAngSettVig) {
        this.titleVigAngSettVig = titleVigAngSettVig;
    }

    public String getTitleAngConfirm() {
        return titleAngConfirm;
    }

    public void setTitleAngConfirm(String titleAngConfirm) {
        this.titleAngConfirm = titleAngConfirm;
    }

    public String getDesInfoAngConfirm() {
        return desInfoAngConfirm;
    }

    public void setDesInfoAngConfirm(String desInfoAngConfirm) {
        this.desInfoAngConfirm = desInfoAngConfirm;
    }

    public String getAceptConfAngConfirm() {
        return aceptConfAngConfirm;
    }

    public void setAceptConfAngConfirm(String aceptConfAngConfirm) {
        this.aceptConfAngConfirm = aceptConfAngConfirm;
    }

    public String getCancelConfAngConfirm() {
        return cancelConfAngConfirm;
    }

    public void setCancelConfAngConfirm(String cancelConfAngConfirm) {
        this.cancelConfAngConfirm = cancelConfAngConfirm;
    }

    public String getInfoAngGuard() {
        return infoAngGuard;
    }

    public void setInfoAngGuard(String infoAngGuard) {
        this.infoAngGuard = infoAngGuard;
    }

    public String getTitleAngUser() {
        return titleAngUser;
    }

    public void setTitleAngUser(String titleAngUser) {
        this.titleAngUser = titleAngUser;
    }

    public String getNameUserAngUser() {
        return nameUserAngUser;
    }

    public void setNameUserAngUser(String nameUserAngUser) {
        this.nameUserAngUser = nameUserAngUser;
    }

    public String getBtnCloseAngUser() {
        return btnCloseAngUser;
    }

    public void setBtnCloseAngUser(String btnCloseAngUser) {
        this.btnCloseAngUser = btnCloseAngUser;
    }

    public String getTitleGoogleCont() {
        return titleGoogleCont;
    }

    public void setTitleGoogleCont(String titleGoogleCont) {
        this.titleGoogleCont = titleGoogleCont;
    }

    public String getTitleContGoogleCont() {
        return titleContGoogleCont;
    }

    public void setTitleContGoogleCont(String titleContGoogleCont) {
        this.titleContGoogleCont = titleContGoogleCont;
    }

    public String getBtnLogGoogleCont() {
        return btnLogGoogleCont;
    }

    public void setBtnLogGoogleCont(String btnLogGoogleCont) {
        this.btnLogGoogleCont = btnLogGoogleCont;
    }

    public String getTitleNameContactGoogleCont() {
        return titleNameContactGoogleCont;
    }

    public void setTitleNameContactGoogleCont(String titleNameContactGoogleCont) {
        this.titleNameContactGoogleCont = titleNameContactGoogleCont;
    }

    public String getTitleEmailContactGoogleCont() {
        return titleEmailContactGoogleCont;
    }

    public void setTitleEmailContactGoogleCont(String titleEmailContactGoogleCont) {
        this.titleEmailContactGoogleCont = titleEmailContactGoogleCont;
    }

    public String getBtnAceptGoogleCont() {
        return btnAceptGoogleCont;
    }

    public void setBtnAceptGoogleCont(String btnAceptGoogleCont) {
        this.btnAceptGoogleCont = btnAceptGoogleCont;
    }

    public String getBtnCancelGoogleCont() {
        return btnCancelGoogleCont;
    }

    public void setBtnCancelGoogleCont(String btnCancelGoogleCont) {
        this.btnCancelGoogleCont = btnCancelGoogleCont;
    }

    public String getHelpMe() {
        return helpMe;
    }

    public void setHelpMe(String helpMe) {
        this.helpMe = helpMe;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getTitleInformationMessage() {
        return titleInformationMessage;
    }

    public void setTitleInformationMessage(String titleInformationMessage) {
        this.titleInformationMessage = titleInformationMessage;
    }

    public String getInformationMessage() {
        return informationMessage;
    }

    public void setInformationMessage(String informationMessage) {
        this.informationMessage = informationMessage;
    }

    public String getMailDelete() {
        return mailDelete;
    }

    public void setMailDelete(String mailDelete) {
        this.mailDelete = mailDelete;
    }

    public String getMailNotification() {
        return mailNotification;
    }

    public void setMailNotification(String mailNotification) {
        this.mailNotification = mailNotification;
    }

    public String getAltContactsAngelsEd() {
        return altContactsAngelsEd;
    }

    public void setAltContactsAngelsEd(String altContactsAngelsEd) {
        this.altContactsAngelsEd = altContactsAngelsEd;
    }

    public String getTitleVisitsFilterOptions() {
        return titleVisitsFilterOptions;
    }

    public void setTitleVisitsFilterOptions(String titleVisitsFilterOptions) {
        this.titleVisitsFilterOptions = titleVisitsFilterOptions;
    }

    public Collection<UserSettings> getUserSettingsCollection() {
        return userSettingsCollection;
    }

    public void setUserSettingsCollection(Collection<UserSettings> userSettingsCollection) {
        this.userSettingsCollection = userSettingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocale != null ? idLocale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LocaleSettings)) {
            return false;
        }
        LocaleSettings other = (LocaleSettings) object;
        if ((this.idLocale == null && other.idLocale != null) || (this.idLocale != null && !this.idLocale.equals(other.idLocale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "es.uah.cc.ie.persistence.LocaleSettings[idLocale=" + idLocale + "]";
    }

}
