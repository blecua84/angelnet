/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.email;

import com.sun.jersey.api.client.UniformInterfaceException;
import es.uah.cc.ie.snsangelguardfb.facebookclient.clients.FacebookClientLocal;
import es.uah.cc.ie.snsangelguardfb.SNSAngelGuardFBManager;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchProviderException;
import javax.mail.MessagingException;
import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Clase que se ocupa de distribuir y enviar las notificaciones a los angeles.
 *
 * @author tote
 */
public class GenericEmailObject {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(GenericEmailObject.class);

    /** Manager principal de la aplicacion */
    private SNSAngelGuardFBManager snsObject;
    
    /** Cliente de Facebook (Deprecado) */
    private FacebookClientLocal facebookClient;
    
    /** Objeto con las credenciales del servidor de correo electr?nico */
    private EmailObject email;

    /**
     * Constructor de clase.
     *
     * @param snsObject
     * @param facebookClient
     */
    public GenericEmailObject(SNSAngelGuardFBManager snsObject, FacebookClientLocal facebookClient) {
        this.snsObject = snsObject;
        this.facebookClient = facebookClient;
        this.email = new EmailObject();
    }

    /**
     * Envio de la notificacion de confirmacion a un nuevo angel. Podr? lanzar excepciones del tipo
     * JSONException, UnsupportedEncodingException, UniformInterfaceException, IOException, NoSuchProviderException o MessagingException.
     *
     * @param jsonAngel
     * @param uidPublic
     * @throws JSONException
     * @throws UnsupportedEncodingException
     * @throws UniformInterfaceException
     * @throws IOException
     * @throws NoSuchProviderException
     * @throws MessagingException
     */
    public void sendMailConfirmationAngel(JSONObject jsonAngel, String uidPublic) throws JSONException, UnsupportedEncodingException, UniformInterfaceException, IOException, NoSuchProviderException, MessagingException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendMailConfirmationAngel: Inicio sendMailConfirmationAngel al angel: " + jsonAngel.getString("idAngel"));
        String bodyEmail = "";

        bodyEmail = this.getBodyMailConfirmation(uidPublic, jsonAngel.getString("uidAngel"));
        this.email.sendEmail("SNSAngelGuard: Angel Confirmation", bodyEmail, jsonAngel.getString("idAngel"));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendMailConfirmationAngel: Fin sendMailConfirmationAngel al angel: " + jsonAngel.getString("idAngel"));
    }

    /**
     * Envio de la notificacion de borrado de un angel. Podr? lanzar excepciones del tipo
     * JSONException, NoSuchProviderException, MessagingException, UniformInterfaceException o IOException.
     *
     * @param jsonAngel
     * @param uidPublic
     * @throws JSONException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws UniformInterfaceException
     * @throws IOException
     */
    public void sendMailDeleteAngel(JSONObject jsonAngel, String uidPublic) throws JSONException, NoSuchProviderException, MessagingException, UniformInterfaceException, IOException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendMailDeleteAngel: Inicio sendMailDeleteAngel al angel: " + jsonAngel.getString("idAngel"));
        String bodyEmail = "";

        bodyEmail = this.getBodyMailDeleteAngel(uidPublic);
        this.email.sendEmail("SNSAngelGuard: Angel Deleted", bodyEmail, jsonAngel.getString("idAngel"));
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendMailDeleteAngel: Fin sendMailDeleteAngel al angel: " + jsonAngel.getString("idAngel"));
    }


    /**
     * Obtiene el cuerpo del email de confirmacion para un usuario y su angel. Podr? lanzar excepciones del tipo UnsupportedEncodingException.
     *
     * @param uidPublic
     * @param idAngel
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getBodyMailConfirmation(String uidPublic, String idAngel) throws UnsupportedEncodingException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getBodyMailConfirmation: Inicio getBodyMailConfirmation al angel: " + idAngel);

        String body = "<html><head><title>" + this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleAngConfirm() + "</title>"
                + "</head>"
                + "<body><form id=\"frAngelDelete\" action=\"\" method=\"\"><div id=\"divAngelDeleteContainer\" style=\"width: 100%; margin: auto\">"
                + "<table width=\"100%\"><tr><td width=\"60%\"><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:20px;color: #3b5998;margin:5px;\">" + this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleAngConfirm() + "</div></td></tr></table>"
                + "<hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /><div id=\"divAngelConfirmation\" style=\"margin:10px;height:250px;width: 95%;margin:5px;padding:10px 20px;background:#f7f7f7;border:1px solid #CCC;\"><table id=\"tabInfoConfirmation\">"
                + "<tr><td height=\"20px\"></td></tr><tr><td width=\"10%\" align=\"center\"><img src=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/resources/legalAccepted/iconoLeft.gif\" WIDTH=\"83\" HEIGHT=\"111\" alt=\"\">"
                + "</td><td width=\"80%\"><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color:#333;text-align:justify;padding:10px 10px 10px 10px;\"><A style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;color: #3b5998;cursor:pointer;\" href=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/angelUser.jsp?par1=" + uidPublic + "\">" + this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUserName() + "</A> "
                + this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getDesInfoAngConfirm() + "</div></td><td width=\"10%\" align=\"center\"><img src=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/resources/legalAccepted/iconoRight.gif\" WIDTH=\"83\" HEIGHT=\"111\" alt=\"\">"
                + "</td></tr><tr><td height=\"20px\"></td></tr></table><center><table id=\"tabLinkConfirmation\"><tr><td height=\"15px\"></td></tr>"
                + "<tr><td height=\"50px\" width=\"50px\" align=\"center\"><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color:#333;text-align:justify;padding:10px 10px 10px 10px;\">"
                + "<A style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;color: #3b5998;cursor:pointer;\" href=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/angelConfirmation.jsp?par1=" + uidPublic + "&par2=" + idAngel + "&par3=1\">" + this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getAceptConfAngConfirm() + "</A>"
                + "</div></td><td height=\"50px\" width=\"50px\" align=\"center\">"
                + "<div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color:#333;text-align:justify;padding:10px 10px 10px 10px;\"><A style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;color: #3b5998;cursor:pointer;\" href=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/angelConfirmation.jsp?par1=" + uidPublic + "&par2=" + idAngel + "&par3=0\">" + this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getCancelConfAngConfirm() + "</A>"
                + "</div></td></tr><tr><td height=\"15px\"></td></tr></table></center></div><div id=\"botoneraInferior\" style=\"width:100%;\" align=\"left\" margin=\"15px\">"
                + "<hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:12px;color:#333;text-align:justify;margin: 5px;\"><A style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;color: #3b5998;cursor:pointer;\" href=\"http://www.facebook.com/apps/application.php?id=179105958774916\">SNSAngelGuard</A>" + this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getInfoAngGuard()
                + "</div></div></div></form></body></html>";

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getBodyMailConfirmation: Fin getBodyMailConfirmation al angel: " + idAngel);
        return body;
    }

    /**
     * Obtiene el cuerpo del email de borrado de un angel.
     * 
     * @param uidPublic
     * @return
     */
    public String getBodyMailDeleteAngel(String uidPublic) {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getBodyMailDeleteAngel: Inicio getBodyMailDeleteAngel...");
        String menDB[] = this.snsObject.getStringUtilities().stringToArray(this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getMailDelete());
        String body = "<html><head><title>" + menDB[0] + "</title>"
                + "</head>"
                + "<body><form id=\"frAngelDelete\" action=\"\" method=\"\"><div id=\"divAngelDeleteContainer\" style=\"width: 100%; margin: auto\">"
                + "<table width=\"100%\"><tr><td width=\"60%\"><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:20px;color: #3b5998;margin:5px;\">" + this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleAngConfirm() + "</div></td></tr></table>"
                + "<hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /><div id=\"divAngelConfirmation\" style=\"height:250px;width: 95%;padding:10px 20px;background:#f7f7f7;border:1px solid #CCC;margin:10px;\"><table id=\"tabInfoConfirmation\">"
                + "<tr><td height=\"20px\"></td></tr><tr><td width=\"10%\" align=\"center\"><img src=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/resources/legalAccepted/iconoLeft.gif\" WIDTH=\"83\" HEIGHT=\"111\" alt=\"\">"
                + "</td><td width=\"80%\"><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color:#333;text-align:justify;padding:10px 10px 10px 10px;\"><A style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;color: #3b5998;cursor:pointer;\" href=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/angelUser.jsp?par1=" + uidPublic + "\">" + this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUserName() + "</A> "
                + menDB[1] + "</div></td><td width=\"10%\" align=\"center\"><img src=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/resources/legalAccepted/iconoRight.gif\" WIDTH=\"83\" HEIGHT=\"111\" alt=\"\">"
                + "</td></tr><tr><td height=\"20px\"></td></tr></table></div><div id=\"botoneraInferior\" style=\"width:100%;\" align=\"left\" margin=\"15px\">"
                + "<hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:12px;color:#333;text-align:justify;margin: 5px;\"><A style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;color: #3b5998;cursor:pointer;\" href=\"http://www.facebook.com/apps/application.php?id=179105958774916\">SNSAngelGuard</A>" + this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getInfoAngGuard()
                + "</div></div></div></form></body></html>";

        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - getBodyMailDeleteAngel: Fin getBodyMailDeleteAngel...");
        return body;
    }

    /**
     * Envia las notificaciones en funcion del resultado obtenido del chequeo de los filtros. Podr? lanzar excepciones del tipo
     * JSONException, NoSuchProviderException, MessagingException, UniformInterfaceException o IOException.
     * 
     * @param resultFltWall
     * @param resultFltFriends
     * @param resultFltPriv
     * @param resultFltVist
     * @param jsonAngel
     * @throws JSONException
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws UniformInterfaceException
     * @throws IOException
     */
    public void sendEmailCheck(String resultFltWall, String resultFltFriends, String resultFltPriv, String resultFltVist, JSONObject jsonAngel) throws JSONException, NoSuchProviderException, MessagingException, UniformInterfaceException, IOException {
        logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendEmailCheck: Inicio sendEmailCheck para el angel: " + jsonAngel.getString("idAngel"));
        String menDB[] = this.snsObject.getStringUtilities().stringToArray(this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getMailNotification());
        String titleVigDB[] = this.snsObject.getStringUtilities().stringToArray(this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getTitleVigSettVig());
        String title = menDB[1];
        String[] titleHelp = snsObject.getStringUtilities().stringToArray(snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getHelpMe());

        String bodyEmail = "<html><head><title>" + menDB[0] + "</title>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\" />"
                + "</head><body><form id=\"frAngelNotification\" action=\"\">"
                + "<div id=\"divAngelNotificationContainer\" style=\"position: absolute;width: 95%;margin:15px;\">"
                + "<div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:20px;color: #3b5998;margin:5px;\">" + title + "<A style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;color: #3b5998;cursor:pointer;\" href=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/angelUser.jsp?par1=" + this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUidPublic() + "\">" + this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUserName() + "</A>"
                + "<hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" />"
                + "<table width=\"97%\">"
                + "<tr><br><td width=\"95%\"><A style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;color: #3b5998;cursor:pointer;\" href=\"" + this.snsObject.getConfigurationManager().getConfigHostApplication() + "SNSAngelGuardFB/helpMe.jsp" + "\">" + titleHelp[0] + "</A></td></tr>";

        if (!resultFltWall.equals("")) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendEmailCheck: Resultado notificaci?n filtro Wall: " + resultFltWall);
            bodyEmail += "<tr><td width=\"95%\"><br><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color: #3b5998;margin:5px;\">" + titleVigDB[0] + "</div><tr><td width=\"95%\"><hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /></td></tr>"
                    + "<tr><td><div id=\"divFilterWall\" style=\"height: auto;margin:10px;width:90%;margin:10px;padding:10px 20px;background:#f7f7f7;border:1px solid #CCC;\"><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:12px;text-align:justify;color:#808080;padding:10px 10px 10px;\">" + resultFltWall + "</div>"
                    + "</div></td></tr>";
        }

        if (!resultFltFriends.equals("")) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendEmailCheck: Resultado notificaci?n filtro Friends: " + resultFltFriends);
            bodyEmail += "<tr><td width=\"95%\"><br><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color: #3b5998;margin:5px;\">" + titleVigDB[1] + "</div><hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /></td></tr>"
                    + "<tr><td><div id=\"divFilterFriends\" style=\"height: auto;margin:10px;width:90%;margin:10px;padding:10px 20px;background:#f7f7f7;border:1px solid #CCC;\"><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:12px;text-align:justify;color:#808080;padding:10px 10px 10px;\">" + resultFltFriends + "</div>"
                    + "</div></td></tr>";
        }
        if (!resultFltPriv.equals("")) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendEmailCheck: Resultado notificaci?n filtro Priv: " + resultFltPriv);
            bodyEmail += "<tr><td width=\"95%\"><br><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color: #3b5998;margin:5px;\">" + titleVigDB[2] + "</div><hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /></td></tr>"
                    + "<tr><td><div id=\"divFilterPriv\" style=\"height: auto;margin:10px;width:90%;margin:10px;padding:10px 20px;background:#f7f7f7;border:1px solid #CCC;\"><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:12px;text-align:justify;color:#808080;padding:10px 10px 10px;\">" + resultFltPriv + "</div>"
                    + "</div></td></tr>";
        }
        if (!resultFltVist.equals("")) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendEmailCheck: Resultado notificaci?n filtro Vist: " + resultFltVist);
            bodyEmail += "<tr><td width=\"95%\"><br><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:15px;color: #3b5998;margin:5px;\">" + titleVigDB[3] + "</div><hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /></td></tr>"
                    + "<tr><td><div id=\"divFilterVist\" style=\"height: auto;margin:10px;width:90%;margin:10px;padding:10px 20px;background:#f7f7f7;border:1px solid #CCC;\"><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:12px;text-align:justify;color:#808080;padding:10px 10px 10px;\">" + resultFltVist + "</div>"
                    + "</div></td></tr>";
        }

        bodyEmail += "</table><div id=\"botoneraInferior\" style=\"width:100%;\" align=\"left\" margin=\"15px\">"
                + "<hr style=\"background:#d9d9d9;border-width:0;color:#d9d9d9;height:1px;margin:2px;\" /><div style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;font-size:12px;color:#333;text-align:justify;margin: 5px;\"><A style=\"font-family:\"lucida grande\",tahoma,verdana,arial,sans-serif;color: #3b5998;cursor:pointer;\" href=\"http://www.facebook.com/apps/application.php?id=179105958774916\">SNSAngelGuard</A>" + this.snsObject.getLocaleSettingsDaoManager().getLocaleSettingsDao().getInfoAngGuard()
                + "</div></div></div></form></body></html>";

        if (!resultFltWall.equals("") || !resultFltFriends.equals("") || !resultFltPriv.equals("") || !resultFltVist.equals("")) {
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendEmailCheck: Enviando email al usuario: " + jsonAngel.getString("idAngel"));
            this.email.sendEmail(menDB[0], bodyEmail, jsonAngel.getString("idAngel"));
            logger.debug(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendEmailCheck: Email enviado!!");
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendEmailCheck: Fin sendEmailCheck...");
        }else{
            logger.info(this.snsObject.getUserSettingsDaoManager().getUserSettingsDAO().getUid() + " - sendEmailCheck: Fin sendEmailCheck para el angel: " + jsonAngel.getString("idAngel"));
        }
    }
}
