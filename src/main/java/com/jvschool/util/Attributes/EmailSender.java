package com.jvschool.util.Attributes;

import lombok.extern.log4j.Log4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Log4j
public class EmailSender {

    public void send(String emailTo, String msgSubject, String msgText) {

        String toEmail = emailTo;
        String fromEmail = "favorite.quadcopters@gmail.com";
        String fromEmailPassword = "favoritequadcopters";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties,  new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail,fromEmailPassword);}});


        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            message.setSubject(msgSubject);
            message.setText(msgText);

            Transport.send(message);

            log.info("send email letter successfully");
        }catch (MessagingException mex) {

            log.error(mex.toString());
        }
    }
}
