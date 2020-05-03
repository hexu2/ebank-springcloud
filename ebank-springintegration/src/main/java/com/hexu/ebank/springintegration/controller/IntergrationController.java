package com.hexu.ebank.springintegration.controller;


import com.hexu.ebank.springintegration.entity.Address;
import com.hexu.ebank.springintegration.service.IntegrationGateWay;
import com.hexu.ebank.user.entity.TUser;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("Enbank-springintegration服务API")
@RequestMapping("/v1/integrate")
@RestController
public class IntergrationController {


    @Autowired
    private IntegrationGateWay integrationGateWay;


    @RequestMapping(value = "{name}", method = {RequestMethod.GET})
    public String getMessageFromIntergrationService(@PathVariable("name") String name){

        return integrationGateWay.sendMessage(name);
    }

    @RequestMapping(value = "/tuser", method = {RequestMethod.POST})
    public String processTuserDetails(@RequestBody TUser tUser){

        return integrationGateWay.pocessTuserDetails(tUser);
    }

    @RequestMapping(value = "/user", method = {RequestMethod.POST})
    public void processAddressDetails(@RequestBody TUser user){
        integrationGateWay.process(user);
    }

    @RequestMapping(value = "/address", method = {RequestMethod.POST})
    public void processAddressDetails(@RequestBody Address address){
        integrationGateWay.process(address);
    }

}
