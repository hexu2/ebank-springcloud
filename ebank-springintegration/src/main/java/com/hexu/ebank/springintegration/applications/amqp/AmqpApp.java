package com.hexu.ebank.springintegration.applications.amqp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

public class AmqpApp {

    public static void main(String[] args) {


        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("/META-INF/spring/integration/amqp/spring-integration-amap-context.xml");

        for(;;){
            MessageChannel channel = context.getBean("toRabbit", MessageChannel.class);
            Message<String> message = MessageBuilder.withPayload("World").build();
            channel.send(message);
        }

    }
}
