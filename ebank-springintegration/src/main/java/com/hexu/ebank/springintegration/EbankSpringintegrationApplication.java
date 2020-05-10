package com.hexu.ebank.springintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
@EnableAutoConfiguration
@ImportResource({"/META-INF/spring/integration/amqpdemo2/spring-integration-amapdemo2-context.xml","/META-INF/spring/integration/amqpdemo2/spring-integration-amapdemo2-context.xml"})
public class EbankSpringintegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankSpringintegrationApplication.class, args);
    }
}