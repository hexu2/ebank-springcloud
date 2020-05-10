package com.hexu.ebank.springintegration.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommonService {

    private static final Logger logger = LoggerFactory.getLogger(CommonService.class);

//    @ServiceActivator(inputChannel = "filter.result.channel")
//    public void receiveMessageFromUserChannel1(Message<?> message) throws MessagingException {
//
//        logger.debug("=======filter.result.channel=======");
//        logger.debug(String.valueOf(message));
//        logger.debug("=============================");
//        logger.debug(String.valueOf(message.getPayload()));
//
//    }
}
