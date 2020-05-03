package com.hexu.ebank.springintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

@SpringBootApplication
@EnableIntegration
public class EbankSpringintegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankSpringintegrationApplication.class, args);
    }
}
