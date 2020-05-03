package com.hexu.ebank.springintegration.gateWay;


import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface CafeGateWay {

    @Gateway(requestChannel="cafe.order.gateway.channel")
    public <S> void placeOrder(S request);

}
