package com.hexu.ebank.springintegration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AddressService {

    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);


//    @ServiceActivator(inputChannel = "address.from.payloadtyperouter.channel")
//    public void receiveMessageFromPayLoadRouter(Message<?> message) throws MessagingException {
//
//        logger.debug("=======address.from.payloadtyperouter.channel=======");
//        logger.debug(String.valueOf(message));
//        logger.debug("=============================");
//        logger.debug(String.valueOf(message.getPayload()));
//
//    }
}
