package com.hexu.ebank.springintegration.gateWay;


import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MessageGateWay {

//    @Gateway(requestChannel = "inputChannel")
//    public <S> void sendMessage(S request);
}
