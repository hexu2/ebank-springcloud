package com.hexu.ebank.springintegration.service;


import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class IntegrationService {

    @ServiceActivator(inputChannel = "integration.gateway.channel")
    public void anotherMessage(Message<String> message) throws MessagingException {

        MessageChannel replyChannel = (MessageChannel) message.getHeaders().getReplyChannel();

        Message<String> newMessage = MessageBuilder.withPayload("Welcome " + message.getPayload() + " to spring integration!!").build();
        replyChannel.send(newMessage);
    }

}
