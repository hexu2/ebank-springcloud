package com.hexu.ebank.springintegration.applications.helloWorld;

import com.hexu.ebank.springintegration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;

public class HelloWorldApp {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("/META-INF/spring/integration/helloWorldDemo.xml", HelloWorldApp.class);
        MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);
        PollableChannel outChannel = context.getBean("outputChannel", PollableChannel.class);
        inputChannel.send(new GenericMessage<>("World"));

        logger.info("======> HelloWorldDemo : " + outChannel.receive(0).getPayload());

        System.out.println(context);
    }
}
