package com.wt.learn;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2023/5/31 16:09
 */
public class JmsConsummerTopicSer {
    public static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    public static final String TOPIC_NAME = "topic01";

    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        javax.jms.Connection connection = activeMQConnectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic(TOPIC_NAME);
        MessageConsumer messageConsumer = session.createConsumer(topic);

        messageConsumer.setMessageListener((message) -> {
            // 判断消息是哪种类型之后，再强转。
            if (null != message && message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("****消费者text的消息：" + textMessage.getText());
                } catch (JMSException e) {
                }
            }
            if (null != message && message instanceof MapMessage) {
                MapMessage mapMessage = (MapMessage) message;
                try {
                    System.out.println("****消费者的map消息：" + mapMessage.getString("name"));
                    System.out.println("****消费者的map消息：" + mapMessage.getInt("age"));
                } catch (JMSException e) {
                }
            }

        });
        System.in.read();
        messageConsumer.close();
        session.close();
        connection.close();
    }

}
