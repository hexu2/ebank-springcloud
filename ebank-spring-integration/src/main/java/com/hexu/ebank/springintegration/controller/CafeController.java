package com.hexu.ebank.springintegration.controller;


import com.alibaba.fastjson.JSONObject;
import com.hexu.ebank.common.util.JsonUtil;
import com.hexu.ebank.springintegration.applications.cafe.CafeGateWay;
import com.hexu.ebank.springintegration.applications.cafe.entity.DrinkType;
import com.hexu.ebank.springintegration.applications.cafe.entity.Order;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Api("App-Cafe Base API")
@RequestMapping("/v1/cafe")
@RestController
public class CafeController {

    private static final Logger logger = LoggerFactory.getLogger(CafeController.class);

    @Autowired
    CafeGateWay cafeGateWay;

    @ApiOperation("Copy file from folder a to folder b")
    @RequestMapping(value = "/triggerAnOrder", method = RequestMethod.GET)
    public JSONObject triggerAnOrder(){

        logger.debug("===triggerAnOrder start:===");

        Order order = new Order(new Random().nextInt());
        order.addItem(DrinkType.LATTE, 2, false);
        order.addItem(DrinkType.MOCHA, 3, true);
        cafeGateWay.placeOrder(order);

        logger.debug("===triggerAnOrder end:===");

        return JsonUtil.getSuccessJsonObject("copy success!!!");

    }
}
