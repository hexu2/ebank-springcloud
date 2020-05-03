package com.hexu.ebank.springintegration.service;


import com.hexu.ebank.user.entity.TUser;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface IntegrationGateWay {

    @Gateway(requestChannel = "integration.gateway.channel")
    public String sendMessage(String messge);

    @Gateway(requestChannel = "integration.tuser.gatewary.channel")
    String pocessTuserDetails(TUser tUser);

    @Gateway(requestChannel = "router.channel")
    public <T> void process(T object);
}
