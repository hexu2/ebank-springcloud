package com.hexu.ebank.springintegration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.redis.inbound.RedisQueueMessageDrivenEndpoint;

@Configuration
@EnableIntegration
@IntegrationComponentScan
public class MessageConfig {


    @Bean
    public JedisConnectionFactory getJedisConnectionFactory(){

        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();

        return jedisConnectionFactory;

    }


    @Bean
    public DirectChannel receiverChannel(){

        return new DirectChannel();
    }


    @Bean
    public RedisQueueMessageDrivenEndpoint consumerEndPoint(){

        RedisQueueMessageDrivenEndpoint endpoint = new RedisQueueMessageDrivenEndpoint("redis-queue",getJedisConnectionFactory());

        endpoint.setOutputChannelName("receiverChannel");
        return endpoint;

    }


}
