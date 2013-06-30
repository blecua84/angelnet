/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uah.cc.ie.snsangelguardfb.sources.email;

import java.net.MalformedURLException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;

/**
 * Clase que se ocupa de centralizar el envio de emails.
 *
 * @author tote
 */
public class EmailObject {

    /** Logger Class */
    private static Logger logger = Logger.getLogger(EmailObject.class);

    /** Host del servidor de correo electronico */
    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    
    /** Puerto del servidor de correo electronico */
    private static final int SMTP_HOST_PORT = 465;
    
    /** Direccion de la cuenta de correo electronico */
    private static final String SMTP_AUTH_USER = "snsAngel.Guard@gmail.com";
    
    /** Contrase?a de la cuenta de correo electronico */
    private static final String SMTP_AUTH_PWD = "snsangelguard2011";

    /**
     * Constructor sin argumentos.
     */
    public EmailObject() {
    }

    /**
     * Envia un email a la direccion de correo electronico del atributo sentTo. Podr? lanzar excepciones del tipo NoSuchProviderException, MessagingException o MalformedURLException.
     * 
     * @param subject
     * @param body
     * @throws NoSuchProviderException
     * @throws MessagingException
     * @throws MalformedURLException 
     */
    public void sendEmail(String subject, String body, String sendTo) throws NoSuchProviderException, MessagingException, MalformedURLException {
        logger.info("Envio de notificaciones - sendEmail: Inicio sendEmail al angel: " + sendTo);
        Properties props = new Properties();

        props.put("mail.transport.protocol", "smtps");
        props.put("mail.smtps.host", SMTP_HOST_NAME);
        props.put("mail.smtps.auth", "true");

        Session mailSession = Session.getDefaultInstance(props);
        mailSession.setDebug(true);
        Transport transport = mailSession.getTransport();

        MimeMessage message = new MimeMessage(mailSession);
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(sendTo));
        message.setSubject(subject);
        message.setText(body, "ISO-8859-1", "html");
        
        transport.connect(SMTP_HOST_NAME, SMTP_HOST_PORT, SMTP_AUTH_USER, SMTP_AUTH_PWD);

        transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
        transport.close();
        logger.info("Envio de notificaciones - sendEmail: Fin sendEmail al angel: " + sendTo);
    }
}
