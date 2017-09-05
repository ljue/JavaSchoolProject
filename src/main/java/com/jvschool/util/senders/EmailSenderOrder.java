package com.jvschool.util.senders;

import com.jvschool.model.BucketEntity;
import com.jvschool.model.OrderEntity;
import lombok.extern.log4j.Log4j;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Locale;
import java.util.Properties;

@Log4j
public class EmailSenderOrder implements Runnable {

    private OrderEntity order;
    private static final String PICTURES_DIR = "D:/JavaSchoolProject/mywebapp/src/main/webapp/resources/Images/";
    private static final String PASS = "favoritequadcopters";

    public EmailSenderOrder(OrderEntity order) {

        this.order = order;
    }

    public void run() {

        String toEmail = order.getUser().getEmail();
        String fromEmail = "favorite.quadcopters@gmail.com";


        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getDefaultInstance(properties,  new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, PASS);}});


        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            message.setSubject("Order details.");

            MimeMultipart multipart = new MimeMultipart("related");

            StringBuilder builder = new StringBuilder();
            builder.append("<H1>Hello, " + order.getUser().getFirstName() + "!</H1>" +
                    "<div><p>You registered order:</p></div><br>");
            BodyPart messageBodyPart;

            int i = 0;
            double total = 0;
            for (BucketEntity bucket: order.getBuckets()) {
                builder.append("<H4>"+ bucket.getProductId().getProductName() + "</H4>" +
                        "<p>Count: " + bucket.getCountProduct() + "</p>" +
                        "<p>Cost: " + bucket.getCostProduct() + "$</p>" +
                        "<img style=\"height: 300px; width: 300px;\" src=\"cid:image"
                        + (++i) + "\"><br><br>");
                total += bucket.getCostProduct()*bucket.getCountProduct();

                messageBodyPart = new MimeBodyPart();
                DataSource fds = new FileDataSource(
                        PICTURES_DIR + bucket.getProductId().getPictures().get(0).getPicName());

                messageBodyPart.setDataHandler(new DataHandler(fds));
                messageBodyPart.setHeader("Content-ID", "<image" + i + ">");

                multipart.addBodyPart(messageBodyPart);
            }

            builder.append("<br><H3>Total: " + String.format(Locale.US, "%.2f", total) + "$</H3>");
            builder.append("<hr><br><p>Best regards,</p><p>Favorite copters.</p>");
            messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(builder.toString(), "text/html");
            multipart.addBodyPart(messageBodyPart);

            message.setContent(multipart);

            Transport.send(message);


            log.info("send email letter successfully");
        }catch (MessagingException mex) {

            log.error(mex.toString());
        }
    }
}
