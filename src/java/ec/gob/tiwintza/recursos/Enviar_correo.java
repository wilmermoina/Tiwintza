/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.gob.tiwintza.recursos;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author WMOINA
 */
@Stateless
public class Enviar_correo {

     public void EnviarEmail(String fromEmail, String username, String password,
            String toEmail, String subject, String message) {
        try {
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);

            Message mailMessge = new MimeMessage(mailSession);

            mailMessge.setFrom(new InternetAddress(fromEmail));
            mailMessge.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailMessge.setContent(message, "text/html");
            mailMessge.setSubject(subject);

            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);

            transport.sendMessage(mailMessge, mailMessge.getAllRecipients());

        } catch (Exception ex) {
            Logger.getLogger(Enviar_correo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
