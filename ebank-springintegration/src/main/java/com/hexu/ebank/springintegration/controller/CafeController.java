package com.hexu.ebank.springintegration.controller;



import com.hexu.ebank.springintegration.applications.cafeAnnotation.entity.Order;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("Enbank-springintegration apps-cafe服务API")
@RequestMapping("/v1/cafe")
@RestController
public class CafeController {

    private static final Logger logger = LoggerFactory.getLogger(CafeController.class);


    @RequestMapping(value = "/placeOrder", method = {RequestMethod.POST})
    public void placeOrder(@RequestBody Order order){

        logger.debug(" order " + order);

    }
}
