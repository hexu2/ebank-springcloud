package com.hexu.ebank.card;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient  //激活eureka中的DiscoveryClient实现
@MapperScan("com.hexu.ebank.card.mapper")
public class EbankCardApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankCardApplication.class, args);
    }

}
