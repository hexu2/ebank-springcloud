package com.hexu.ebank.springintegration.applications.amqpdemo2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AmqpDemo2App {

    public static void main(String[] args) {


        AbstractApplicationContext context =
                new ClassPathXmlApplicationContext("/META-INF/spring/integration/amqpdemo2/spring-integration-amapdemo2-context.xml");

        context.registerShutdownHook();

    }
}
