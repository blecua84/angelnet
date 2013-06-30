/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.dao.entity;


/**
 * Carga todos los recursos de idioma para un usuario dependiendo de su
 * configuracion.
 *
 * @author tote
 */
public class LocaleSettingsDAO {

    /**
     * Constructor sin argumentos.
     */
    public LocaleSettingsDAO() {
    }

    /**
     * Constructor de clase. Inicializa todos los par?metros que han sido
     * cargados de base de datos.
     * 
     * @param idLocale
     * @param acceptingTerms
     * @param legalAccepted
     * @param btnAgreeAT
     * @param btnCancelAT
     * @param titleAT
     * @param titleSettings
     * @param titleMenSettings
     * @param btnSaveCheckSettings
     * @param titleSettAng
     * @param titleFriendsContentSettAng
     * @param titleFriendsImportSettAng
     * @param txtNameTutorSettAng
     * @param txtEmailTutorSettAng
     * @param btnImportSettAng
     * @param titleFbListSettAng
     * @param subTitleAngelSettAng
     * @param titleSettVig
     * @param titleVigilantSettVig
     * @param titleVigSettVig
     * @param titleVigDescriptionSettVig
     * @param titleVigFrecSettVig
     * @param titleVigFrecSelectSettVig
     * @param titleVigAngSettVig
     * @param titleAngConfirm
     * @param desInfoAngConfirm
     * @param aceptConfAngConfirm
     * @param cancelConfAngConfirm
     * @param infoAngGuard
     * @param titleAngUser
     * @param nameUserAngUser
     * @param btnCloseAngUser
     * @param titleGoogleCont
     * @param titleContGoogleCont
     * @param btnLogGoogleCont
     * @param titleNameContactGoogleCont
     * @param titleEmailContactGoogleCont
     * @param btnAceptGoogleCont
     * @param btnCancelGoogleCont
     * @param helpMe
     * @param warnings
     * @param titleInformationMessage
     * @param informationMessage
     * @param mailDelete
     * @param mailNotification
     * @param altContactsAngelsEd
     * @param titleVisitsFilterOptions
     */
    public LocaleSettingsDAO(String idLocale, String acceptingTerms, String legalAccepted, String btnAgreeAT, String btnCancelAT, String titleAT, String titleSettings, String titleMenSettings, String btnSaveCheckSettings, String titleSettAng, String titleFriendsContentSettAng, String titleFriendsImportSettAng, String txtNameTutorSettAng, String txtEmailTutorSettAng, String btnImportSettAng, String titleFbListSettAng, String subTitleAngelSettAng, String titleSettVig, String titleVigilantSettVig, String titleVigSettVig, String titleVigDescriptionSettVig, String titleVigFrecSettVig, String titleVigFrecSelectSettVig, String titleVigAngSettVig, String titleAngConfirm, String desInfoAngConfirm, String aceptConfAngConfirm, String cancelConfAngConfirm, String infoAngGuard, String titleAngUser, String nameUserAngUser, String btnCloseAngUser, String titleGoogleCont, String titleContGoogleCont, String btnLogGoogleCont, String titleNameContactGoogleCont, String titleEmailContactGoogleCont, String btnAceptGoogleCont, String btnCancelGoogleCont, String helpMe, String warnings, String titleInformationMessage, String informationMessage, String mailDelete, String mailNotification, String altContactsAngelsEd, String titleVisitsFilterOptions) {
        this.idLocale = idLocale;
        this.acceptingTerms = acceptingTerms;
        this.legalAccepted = legalAccepted;
        this.btnAgreeAT = btnAgreeAT;
        this.btnCancelAT = btnCancelAT;
        this.titleAT = titleAT;
        this.titleSettings = titleSettings;
        this.titleMenSettings = titleMenSettings;
        this.btnSaveCheckSettings = btnSaveCheckSettings;
        this.titleSettAng = titleSettAng;
        this.titleFriendsContentSettAng = titleFriendsContentSettAng;
        this.titleFriendsImportSettAng = titleFriendsImportSettAng;
        this.txtNameTutorSettAng = txtNameTutorSettAng;
        this.txtEmailTutorSettAng = txtEmailTutorSettAng;
        this.btnImportSettAng = btnImportSettAng;
        this.titleFbListSettAng = titleFbListSettAng;
        this.subTitleAngelSettAng = subTitleAngelSettAng;
        this.titleSettVig = titleSettVig;
        this.titleVigilantSettVig = titleVigilantSettVig;
        this.titleVigSettVig = titleVigSettVig;
        this.titleVigDescriptionSettVig = titleVigDescriptionSettVig;
        this.titleVigFrecSettVig = titleVigFrecSettVig;
        this.titleVigFrecSelectSettVig = titleVigFrecSelectSettVig;
        this.titleVigAngSettVig = titleVigAngSettVig;
        this.titleAngConfirm = titleAngConfirm;
        this.desInfoAngConfirm = desInfoAngConfirm;
        this.aceptConfAngConfirm = aceptConfAngConfirm;
        this.cancelConfAngConfirm = cancelConfAngConfirm;
        this.infoAngGuard = infoAngGuard;
        this.titleAngUser = titleAngUser;
        this.nameUserAngUser = nameUserAngUser;
        this.btnCloseAngUser = btnCloseAngUser;
        this.titleGoogleCont = titleGoogleCont;
        this.titleContGoogleCont = titleContGoogleCont;
        this.btnLogGoogleCont = btnLogGoogleCont;
        this.titleNameContactGoogleCont = titleNameContactGoogleCont;
        this.titleEmailContactGoogleCont = titleEmailContactGoogleCont;
        this.btnAceptGoogleCont = btnAceptGoogleCont;
        this.btnCancelGoogleCont = btnCancelGoogleCont;
        this.helpMe = helpMe;
        this.warnings = warnings;
        this.titleInformationMessage = titleInformationMessage;
        this.informationMessage = informationMessage;
        this.mailDelete = mailDelete;
        this.mailNotification = mailNotification;
        this.altContactsAngelsEd = altContactsAngelsEd;
        this.titleVisitsFilterOptions = titleVisitsFilterOptions;
    }

    private String idLocale;
    private String acceptingTerms;
    private String legalAccepted;
    private String btnAgreeAT;
    private String btnCancelAT;
    private String titleAT;
    private String titleSettings;
    private String titleMenSettings;
    private String btnSaveCheckSettings;
    private String titleSettAng;
    private String titleFriendsContentSettAng;
    private String titleFriendsImportSettAng;
    private String txtNameTutorSettAng;
    private String txtEmailTutorSettAng;
    private String btnImportSettAng;
    private String titleFbListSettAng;
    private String subTitleAngelSettAng;
    private String titleSettVig;
    private String titleVigilantSettVig;
    private String titleVigSettVig;
    private String titleVigDescriptionSettVig;
    private String titleVigFrecSettVig;
    private String titleVigFrecSelectSettVig;
    private String titleVigAngSettVig;
    private String titleAngConfirm;
    private String desInfoAngConfirm;
    private String aceptConfAngConfirm;
    private String cancelConfAngConfirm;
    private String infoAngGuard;
    private String titleAngUser;
    private String nameUserAngUser;
    private String btnCloseAngUser;
    private String titleGoogleCont;
    private String titleContGoogleCont;
    private String btnLogGoogleCont;
    private String titleNameContactGoogleCont;
    private String titleEmailContactGoogleCont;
    private String btnAceptGoogleCont;
    private String btnCancelGoogleCont;
    private String helpMe;
    private String warnings;
    private String titleInformationMessage;
    private String informationMessage;
    private String mailDelete;
    private String mailNotification;
    private String altContactsAngelsEd;
    private String titleVisitsFilterOptions;

    /**
     * @return the idLocale
     */
    public String getIdLocale() {
        return idLocale;
    }

    /**
     * @param idLocale the idLocale to set
     */
    public void setIdLocale(String idLocale) {
        this.idLocale = idLocale;
    }

    /**
     * @return the acceptingTerms
     */
    public String getAcceptingTerms() {
        return acceptingTerms;
    }

    /**
     * @param acceptingTerms the acceptingTerms to set
     */
    public void setAcceptingTerms(String acceptingTerms) {
        this.acceptingTerms = acceptingTerms;
    }

    /**
     * @return the legalAccepted
     */
    public String getLegalAccepted() {
        return legalAccepted;
    }

    /**
     * @param legalAccepted the legalAccepted to set
     */
    public void setLegalAccepted(String legalAccepted) {
        this.legalAccepted = legalAccepted;
    }

    /**
     * @return the btnAgreeAT
     */
    public String getBtnAgreeAT() {
        return btnAgreeAT;
    }

    /**
     * @param btnAgreeAT the btnAgreeAT to set
     */
    public void setBtnAgreeAT(String btnAgreeAT) {
        this.btnAgreeAT = btnAgreeAT;
    }

    /**
     * @return the btnCancelAT
     */
    public String getBtnCancelAT() {
        return btnCancelAT;
    }

    /**
     * @param btnCancelAT the btnCancelAT to set
     */
    public void setBtnCancelAT(String btnCancelAT) {
        this.btnCancelAT = btnCancelAT;
    }

    /**
     * @return the titleAT
     */
    public String getTitleAT() {
        return titleAT;
    }

    /**
     * @param titleAT the titleAT to set
     */
    public void setTitleAT(String titleAT) {
        this.titleAT = titleAT;
    }

    /**
     * @return the titleSettings
     */
    public String getTitleSettings() {
        return titleSettings;
    }

    /**
     * @param titleSettings the titleSettings to set
     */
    public void setTitleSettings(String titleSettings) {
        this.titleSettings = titleSettings;
    }

    /**
     * @return the titleMenSettings
     */
    public String getTitleMenSettings() {
        return titleMenSettings;
    }

    /**
     * @param titleMenSettings the titleMenSettings to set
     */
    public void setTitleMenSettings(String titleMenSettings) {
        this.titleMenSettings = titleMenSettings;
    }

    /**
     * @return the btnSaveCheckSettings
     */
    public String getBtnSaveCheckSettings() {
        return btnSaveCheckSettings;
    }

    /**
     * @param btnSaveCheckSettings the btnSaveCheckSettings to set
     */
    public void setBtnSaveCheckSettings(String btnSaveCheckSettings) {
        this.btnSaveCheckSettings = btnSaveCheckSettings;
    }

    /**
     * @return the titleSettAng
     */
    public String getTitleSettAng() {
        return titleSettAng;
    }

    /**
     * @param titleSettAng the titleSettAng to set
     */
    public void setTitleSettAng(String titleSettAng) {
        this.titleSettAng = titleSettAng;
    }

    /**
     * @return the titleFriendsContentSettAng
     */
    public String getTitleFriendsContentSettAng() {
        return titleFriendsContentSettAng;
    }

    /**
     * @param titleFriendsContentSettAng the titleFriendsContentSettAng to set
     */
    public void setTitleFriendsContentSettAng(String titleFriendsContentSettAng) {
        this.titleFriendsContentSettAng = titleFriendsContentSettAng;
    }

    /**
     * @return the titleFriendsImportSettAng
     */
    public String getTitleFriendsImportSettAng() {
        return titleFriendsImportSettAng;
    }

    /**
     * @param titleFriendsImportSettAng the titleFriendsImportSettAng to set
     */
    public void setTitleFriendsImportSettAng(String titleFriendsImportSettAng) {
        this.titleFriendsImportSettAng = titleFriendsImportSettAng;
    }

    /**
     * @return the txtNameTutorSettAng
     */
    public String getTxtNameTutorSettAng() {
        return txtNameTutorSettAng;
    }

    /**
     * @param txtNameTutorSettAng the txtNameTutorSettAng to set
     */
    public void setTxtNameTutorSettAng(String txtNameTutorSettAng) {
        this.txtNameTutorSettAng = txtNameTutorSettAng;
    }

    /**
     * @return the txtEmailTutorSettAng
     */
    public String getTxtEmailTutorSettAng() {
        return txtEmailTutorSettAng;
    }

    /**
     * @param txtEmailTutorSettAng the txtEmailTutorSettAng to set
     */
    public void setTxtEmailTutorSettAng(String txtEmailTutorSettAng) {
        this.txtEmailTutorSettAng = txtEmailTutorSettAng;
    }

    /**
     * @return the btnImportSettAng
     */
    public String getBtnImportSettAng() {
        return btnImportSettAng;
    }

    /**
     * @param btnImportSettAng the btnImportSettAng to set
     */
    public void setBtnImportSettAng(String btnImportSettAng) {
        this.btnImportSettAng = btnImportSettAng;
    }

    /**
     * @return the titleFbListSettAng
     */
    public String getTitleFbListSettAng() {
        return titleFbListSettAng;
    }

    /**
     * @param titleFbListSettAng the titleFbListSettAng to set
     */
    public void setTitleFbListSettAng(String titleFbListSettAng) {
        this.titleFbListSettAng = titleFbListSettAng;
    }

    /**
     * @return the subTitleAngelSettAng
     */
    public String getSubTitleAngelSettAng() {
        return subTitleAngelSettAng;
    }

    /**
     * @param subTitleAngelSettAng the subTitleAngelSettAng to set
     */
    public void setSubTitleAngelSettAng(String subTitleAngelSettAng) {
        this.subTitleAngelSettAng = subTitleAngelSettAng;
    }

    /**
     * @return the titleSettVig
     */
    public String getTitleSettVig() {
        return titleSettVig;
    }

    /**
     * @param titleSettVig the titleSettVig to set
     */
    public void setTitleSettVig(String titleSettVig) {
        this.titleSettVig = titleSettVig;
    }

    /**
     * @return the titleVigilantSettVig
     */
    public String getTitleVigilantSettVig() {
        return titleVigilantSettVig;
    }

    /**
     * @param titleVigilantSettVig the titleVigilantSettVig to set
     */
    public void setTitleVigilantSettVig(String titleVigilantSettVig) {
        this.titleVigilantSettVig = titleVigilantSettVig;
    }

    /**
     * @return the titleVigSettVig
     */
    public String getTitleVigSettVig() {
        return titleVigSettVig;
    }

    /**
     * @param titleVigSettVig the titleVigSettVig to set
     */
    public void setTitleVigSettVig(String titleVigSettVig) {
        this.titleVigSettVig = titleVigSettVig;
    }

    /**
     * @return the titleVigDescriptionSettVig
     */
    public String getTitleVigDescriptionSettVig() {
        return titleVigDescriptionSettVig;
    }

    /**
     * @param titleVigDescriptionSettVig the titleVigDescriptionSettVig to set
     */
    public void setTitleVigDescriptionSettVig(String titleVigDescriptionSettVig) {
        this.titleVigDescriptionSettVig = titleVigDescriptionSettVig;
    }

    /**
     * @return the titleVigFrecSettVig
     */
    public String getTitleVigFrecSettVig() {
        return titleVigFrecSettVig;
    }

    /**
     * @param titleVigFrecSettVig the titleVigFrecSettVig to set
     */
    public void setTitleVigFrecSettVig(String titleVigFrecSettVig) {
        this.titleVigFrecSettVig = titleVigFrecSettVig;
    }

    /**
     * @return the titleVigFrecSelectSettVig
     */
    public String getTitleVigFrecSelectSettVig() {
        return titleVigFrecSelectSettVig;
    }

    /**
     * @param titleVigFrecSelectSettVig the titleVigFrecSelectSettVig to set
     */
    public void setTitleVigFrecSelectSettVig(String titleVigFrecSelectSettVig) {
        this.titleVigFrecSelectSettVig = titleVigFrecSelectSettVig;
    }

    /**
     * @return the titleVigAngSettVig
     */
    public String getTitleVigAngSettVig() {
        return titleVigAngSettVig;
    }

    /**
     * @param titleVigAngSettVig the titleVigAngSettVig to set
     */
    public void setTitleVigAngSettVig(String titleVigAngSettVig) {
        this.titleVigAngSettVig = titleVigAngSettVig;
    }

    /**
     * @return the titleAngConfirm
     */
    public String getTitleAngConfirm() {
        return titleAngConfirm;
    }

    /**
     * @param titleAngConfirm the titleAngConfirm to set
     */
    public void setTitleAngConfirm(String titleAngConfirm) {
        this.titleAngConfirm = titleAngConfirm;
    }

    /**
     * @return the desInfoAngConfirm
     */
    public String getDesInfoAngConfirm() {
        return desInfoAngConfirm;
    }

    /**
     * @param desInfoAngConfirm the desInfoAngConfirm to set
     */
    public void setDesInfoAngConfirm(String desInfoAngConfirm) {
        this.desInfoAngConfirm = desInfoAngConfirm;
    }

    /**
     * @return the aceptConfAngConfirm
     */
    public String getAceptConfAngConfirm() {
        return aceptConfAngConfirm;
    }

    /**
     * @param aceptConfAngConfirm the aceptConfAngConfirm to set
     */
    public void setAceptConfAngConfirm(String aceptConfAngConfirm) {
        this.aceptConfAngConfirm = aceptConfAngConfirm;
    }

    /**
     * @return the cancelConfAngConfirm
     */
    public String getCancelConfAngConfirm() {
        return cancelConfAngConfirm;
    }

    /**
     * @param cancelConfAngConfirm the cancelConfAngConfirm to set
     */
    public void setCancelConfAngConfirm(String cancelConfAngConfirm) {
        this.cancelConfAngConfirm = cancelConfAngConfirm;
    }

    /**
     * @return the infoAngGuard
     */
    public String getInfoAngGuard() {
        return infoAngGuard;
    }

    /**
     * @param infoAngGuard the infoAngGuard to set
     */
    public void setInfoAngGuard(String infoAngGuard) {
        this.infoAngGuard = infoAngGuard;
    }

    /**
     * @return the titleAngUser
     */
    public String getTitleAngUser() {
        return titleAngUser;
    }

    /**
     * @param titleAngUser the titleAngUser to set
     */
    public void setTitleAngUser(String titleAngUser) {
        this.titleAngUser = titleAngUser;
    }

    /**
     * @return the nameUserAngUser
     */
    public String getNameUserAngUser() {
        return nameUserAngUser;
    }

    /**
     * @param nameUserAngUser the nameUserAngUser to set
     */
    public void setNameUserAngUser(String nameUserAngUser) {
        this.nameUserAngUser = nameUserAngUser;
    }

    /**
     * @return the btnCloseAngUser
     */
    public String getBtnCloseAngUser() {
        return btnCloseAngUser;
    }

    /**
     * @param btnCloseAngUser the btnCloseAngUser to set
     */
    public void setBtnCloseAngUser(String btnCloseAngUser) {
        this.btnCloseAngUser = btnCloseAngUser;
    }

    /**
     * @return the titleGoogleCont
     */
    public String getTitleGoogleCont() {
        return titleGoogleCont;
    }

    /**
     * @param titleGoogleCont the titleGoogleCont to set
     */
    public void setTitleGoogleCont(String titleGoogleCont) {
        this.titleGoogleCont = titleGoogleCont;
    }

    /**
     * @return the titleContGoogleCont
     */
    public String getTitleContGoogleCont() {
        return titleContGoogleCont;
    }

    /**
     * @param titleContGoogleCont the titleContGoogleCont to set
     */
    public void setTitleContGoogleCont(String titleContGoogleCont) {
        this.titleContGoogleCont = titleContGoogleCont;
    }

    /**
     * @return the btnLogGoogleCont
     */
    public String getBtnLogGoogleCont() {
        return btnLogGoogleCont;
    }

    /**
     * @param btnLogGoogleCont the btnLogGoogleCont to set
     */
    public void setBtnLogGoogleCont(String btnLogGoogleCont) {
        this.btnLogGoogleCont = btnLogGoogleCont;
    }

    /**
     * @return the titleNameContactGoogleCont
     */
    public String getTitleNameContactGoogleCont() {
        return titleNameContactGoogleCont;
    }

    /**
     * @param titleNameContactGoogleCont the titleNameContactGoogleCont to set
     */
    public void setTitleNameContactGoogleCont(String titleNameContactGoogleCont) {
        this.titleNameContactGoogleCont = titleNameContactGoogleCont;
    }

    /**
     * @return the titleEmailContactGoogleCont
     */
    public String getTitleEmailContactGoogleCont() {
        return titleEmailContactGoogleCont;
    }

    /**
     * @param titleEmailContactGoogleCont the titleEmailContactGoogleCont to set
     */
    public void setTitleEmailContactGoogleCont(String titleEmailContactGoogleCont) {
        this.titleEmailContactGoogleCont = titleEmailContactGoogleCont;
    }

    /**
     * @return the btnAceptGoogleCont
     */
    public String getBtnAceptGoogleCont() {
        return btnAceptGoogleCont;
    }

    /**
     * @param btnAceptGoogleCont the btnAceptGoogleCont to set
     */
    public void setBtnAceptGoogleCont(String btnAceptGoogleCont) {
        this.btnAceptGoogleCont = btnAceptGoogleCont;
    }

    /**
     * @return the btnCancelGoogleCont
     */
    public String getBtnCancelGoogleCont() {
        return btnCancelGoogleCont;
    }

    /**
     * @param btnCancelGoogleCont the btnCancelGoogleCont to set
     */
    public void setBtnCancelGoogleCont(String btnCancelGoogleCont) {
        this.btnCancelGoogleCont = btnCancelGoogleCont;
    }

    /**
     * @return the helpMe
     */
    public String getHelpMe() {
        return helpMe;
    }

    /**
     * @param helpMe the helpMe to set
     */
    public void setHelpMe(String helpMe) {
        this.helpMe = helpMe;
    }

    /**
     * @return the warnings
     */
    public String getWarnings() {
        return warnings;
    }

    /**
     * @param warnings the warnings to set
     */
    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    /**
     * @return the titleInformationMessage
     */
    public String getTitleInformationMessage() {
        return titleInformationMessage;
    }

    /**
     * @param titleInformationMessage the titleInformationMessage to set
     */
    public void setTitleInformationMessage(String titleInformationMessage) {
        this.titleInformationMessage = titleInformationMessage;
    }

    /**
     * @return the informationMessage
     */
    public String getInformationMessage() {
        return informationMessage;
    }

    /**
     * @param informationMessage the informationMessage to set
     */
    public void setInformationMessage(String informationMessage) {
        this.informationMessage = informationMessage;
    }

    /**
     * @return the mailDelete
     */
    public String getMailDelete() {
        return mailDelete;
    }

    /**
     * @param mailDelete the mailDelete to set
     */
    public void setMailDelete(String mailDelete) {
        this.mailDelete = mailDelete;
    }

    /**
     * @return the mailNotification
     */
    public String getMailNotification() {
        return mailNotification;
    }

    /**
     * @param mailNotification the mailNotification to set
     */
    public void setMailNotification(String mailNotification) {
        this.mailNotification = mailNotification;
    }

    /**
     * @return the altContactsAngelsEd
     */
    public String getAltContactsAngelsEd() {
        return altContactsAngelsEd;
    }

    /**
     * @param altContactsAngelsEd the altContactsAngelsEd to set
     */
    public void setAltContactsAngelsEd(String altContactsAngelsEd) {
        this.altContactsAngelsEd = altContactsAngelsEd;
    }

    /**
     * @return the titleVisitsFilterOptions
     */
    public String getTitleVisitsFilterOptions() {
        return titleVisitsFilterOptions;
    }

    /**
     * @param titleVisitsFilterOptions The value to set.
     */
    public void setTitleVisitsFilterOptions(String titleVisitsFilterOptions) {
        this.titleVisitsFilterOptions = titleVisitsFilterOptions;
    }
}
