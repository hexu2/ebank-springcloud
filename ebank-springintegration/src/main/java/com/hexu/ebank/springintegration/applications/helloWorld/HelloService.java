package com.hexu.ebank.springintegration.applications.helloWorld;

import com.hexu.ebank.springintegration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloService {


    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public String sayHello(String name){


        return "Hello " + name;
    }


}
