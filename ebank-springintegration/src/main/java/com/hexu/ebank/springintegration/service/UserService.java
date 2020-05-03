package com.hexu.ebank.springintegration.service;

import com.hexu.ebank.user.entity.TUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @ServiceActivator(inputChannel = "integration.tuser.objToJson.channel", outputChannel = "integration.tuser.jsonToObj.channel")
    public Message<?> receiveMessage(Message<?> message) throws MessagingException {
        logger.debug("********receiveMessage*******");
        logger.debug("message = " + String.valueOf(message));
        logger.debug("Obj to json - " + message.getPayload());
        return message;
    }

    @ServiceActivator(inputChannel = "integration.tuser.jsonToObj.fromTransformer.channel")
    public void processObjToJson(Message<?> message) throws MessagingException {

        logger.debug("********processObjToJson*******");
        MessageChannel replyMessageChannel = (MessageChannel) message.getHeaders().getReplyChannel();
        MessageBuilder.fromMessage(message);
        logger.debug("message = " + String.valueOf(message));
        logger.debug("Json to Obj = " + message.getPayload());
        TUser tUser = (TUser) message.getPayload();
        Message<?> newMessage = MessageBuilder.withPayload(tUser.toString()).build();
        logger.debug("newMessage = " + String.valueOf(newMessage));
        replyMessageChannel.send(newMessage);
    }


    @ServiceActivator(inputChannel = "tuser.from.payloadtyperouter.channel")
    public void receiveMessageFromPayloadRouter(Message<?> message) throws MessagingException {

        logger.debug("=======tuser.from.payloadtypeRouter.channel=======");
        logger.debug(String.valueOf(message));
        logger.debug("=============================");
        logger.debug(String.valueOf(message.getPayload()));

    }

    @ServiceActivator(inputChannel = "tuser.channel.1")
    public void receiveMessageFromUserChannel1(Message<?> message) throws MessagingException {

        logger.debug("=======tuser.channel.1=======");
        logger.debug(String.valueOf(message));
        logger.debug("=============================");
        logger.debug(String.valueOf(message.getPayload()));

    }

    @ServiceActivator(inputChannel = "tuser.channel.2")
    public void receiveMessageFromUserChannel2(Message<?> message) throws MessagingException {

        logger.debug("=======tuser.channel.2=======");
        logger.debug(String.valueOf(message));
        logger.debug("=============================");
        logger.debug(String.valueOf(message.getPayload()));

    }

}