package com.hexu.ebank.user;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient  //激活eureka中的DiscoveryClient实现
@MapperScan("com.hexu.ebank.user.mapper")
public class EbankUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankUserApplication.class,args);
    }

}
