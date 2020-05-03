package com.hexu.ebank.springintegration.listerner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.redis.outbound.RedisQueueOutboundChannelAdapter;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @ServiceActivator(inputChannel = "inputChannel", outputChannel = "redisChannel")
    public Message<?> receiveMessageFromService(Message<?> message){
        logger.debug("receiveMessageFromService================");
        return message;
    }

    @ServiceActivator(inputChannel = "redisChannel")
    public void sendMesssageToQueue(Message<?> message){

        RedisQueueOutboundChannelAdapter adapter = new RedisQueueOutboundChannelAdapter("redis-queue",jedisConnectionFactory);

        adapter.handleMessage(message);

    }

    @ServiceActivator(inputChannel = "receiverChannel")
    public void receiveFromQueue(Message<?> message){
        logger.debug("receiveFromQueue================");
        logger.debug("received from redis queue " + message);
    }

}
