package com.jvschool.util.senders;

import lombok.extern.log4j.Log4j;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

@Log4j
public class Sender {

    public void send() {

        Hashtable<String, String> props = new Hashtable<>();
        props.put("java.naming.factory.initial", "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        props.put("java.naming.provider.url", "tcp://localhost:61616");
        props.put("queue.js-queue", "my_jms_queue");
        props.put("connectionFactoryNames", "queueCF");

        try {

            Context context = new InitialContext(props);
            QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup("queueCF");
            Queue queue = (Queue) context.lookup("js-queue");

            QueueConnection connection = connectionFactory.createQueueConnection();
            connection.start();

            QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

            QueueSender sender = session.createSender(queue);
            TextMessage message = session.createTextMessage("Need for speed");

            sender.send(message);

            log.info("Message send");
            sender.close();
            session.close();
            connection.close();
        } catch ( NamingException e) {
            log.info(e.toString());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
