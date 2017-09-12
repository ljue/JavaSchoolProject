package com.jvschool.util.senders;

import lombok.extern.log4j.Log4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Log4j
public class EmailSender implements Runnable {

    private String emailTo;
    private String msgSubject;
    private String msgText;
    private static final String PASS = "favoritequadcopters";

    public EmailSender(String emailTo, String msgSubject, String msgText) {
        this.emailTo = emailTo;
        this.msgSubject = msgSubject;
        this.msgText = msgText;
    }

    public void run() {

        String toEmail = emailTo;
        String fromEmail = "favorite.quadcopters@gmail.com";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, PASS);
            }
        });


        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            message.setSubject(msgSubject);
            message.setText(msgText);

            Transport.send(message);

            log.info("send email letter successfully");
        } catch (MessagingException mex) {

            log.error(mex.toString());
        }
    }
}
