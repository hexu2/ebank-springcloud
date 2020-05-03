package com.hexu.ebank.springintegration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

@Component
public class AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @ServiceActivator(inputChannel = "address.channel")
    public void receiveMessage(Message<?> message) throws MessagingException {

        logger.debug("=======address.channel=======");
        logger.debug(String.valueOf(message));
        logger.debug("=============================");
        logger.debug(String.valueOf(message.getPayload()));

    }
}
