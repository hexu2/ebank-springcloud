package com.hexu.ebank.springintegration.controller;


import com.hexu.ebank.springintegration.entity.Order;
import com.hexu.ebank.springintegration.gateWay.CafeGateWay;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("Enbank-springintegration apps-cafe服务API")
@RequestMapping("/v1/cafe")
@RestController
public class CafeController {
    @Autowired
    CafeGateWay cafeGateWay;


    @RequestMapping(value = "/placeOrder", method = {RequestMethod.POST})
    public void placeOrder(@RequestBody Order order){

        cafeGateWay.placeOrder(order);

    }
}
