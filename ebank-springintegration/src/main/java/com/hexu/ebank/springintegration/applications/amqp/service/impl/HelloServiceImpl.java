package com.hexu.ebank.springintegration.applications.amqp.service.impl;

import com.hexu.ebank.springintegration.applications.amqp.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloServiceImpl implements HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloServiceImpl.class);
    @Override
    public void sayHello(String name) {

        logger.debug("=======sayHello=======");

        logger.debug("Hello " + name);

        System.out.println("Hello " + name);
    }
}
