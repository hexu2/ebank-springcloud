package com.hexu.ebank.springintegration.controller;


import com.hexu.ebank.springintegration.gateWay.IntegrationGateWay;
import com.hexu.ebank.springintegration.gateWay.MessageGateWay;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Enbank-springintegration服务API")
@RequestMapping("/v1/integrate")
@RestController
public class IntergrationController {

    @Autowired
    private IntegrationGateWay integrationGateWay;

    @Autowired
    private MessageGateWay messageGateWay;

//    @RequestMapping(value = "/tuser", method = {RequestMethod.POST})
//    public String processTuserDetails(@RequestBody TUser tUser){
//
//        return integrationGateWay.pocessTuserDetails(tUser);
//    }

//    @RequestMapping(value = "/userByPayLoadRouter", method = {RequestMethod.POST})
//    public void processUserDetailsByPlayLoad(@RequestBody TUser tUser){
//        integrationGateWay.processByPayloadRouter(tUser);
//    }
//
//    @RequestMapping(value = "/addressByPayLoadTypeRouter", method = {RequestMethod.POST})
//    public void processAddressDetailsByPlayLoad(@RequestBody Address address){
//        integrationGateWay.processByPayloadRouter(address);
//    }

//    @RequestMapping(value = "/userByprocessByRepecipientListRouter", method = {RequestMethod.POST})
//    public void processByRepecipientListRouter(@RequestBody TUser tUser){
//        integrationGateWay.processByRepecipientListRouter(tUser);
//    }


//    @RequestMapping(value = "/processUserDetailsByFilter", method = {RequestMethod.POST})
//    public void processUserDetailsByFilter(@RequestBody TUser tUser){
//        integrationGateWay.processUserDetailsByFilter(tUser);
//    }
//
//    @RequestMapping(value = "/processAddressDetailsByFilter", method = {RequestMethod.POST})
//    public void processAddressDetailsByFilter(@RequestBody Address address){
//        integrationGateWay.processUserDetailsByFilter (address);
//    }
//
//
//    @RequestMapping(value = "/sendUserInformation", method = {RequestMethod.POST})
//    public void processAddressDetailsByFilter(@RequestBody TUser tUser){
//        integrationGateWay.processUserDetailsByFilter (tUser);
//    }


//    @RequestMapping(value = "/sendUserInformationViaRedis", method = {RequestMethod.POST})
//    public void sendUserInformationViaRedis(@RequestBody TUser tUser){
//        messageGateWay.sendMessage(tUser);
//    }

}
