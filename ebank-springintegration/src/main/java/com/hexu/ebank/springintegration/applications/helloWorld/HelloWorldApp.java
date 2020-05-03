package com.hexu.ebank.springintegration.applications.helloWorld;

import com.hexu.ebank.springintegration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldApp {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public static void main(String[] args) {
        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("/META-INF/spring/integration/helloWorld/helloWorldDemo.xmll", HelloWorldApp.class);

        context.registerShutdownHook();
        System.out.println(context);
    }
}
