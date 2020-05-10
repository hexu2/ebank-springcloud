package com.hexu.ebank.gate.rpc;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("ebank-springintegration 远程调用接口")
@FeignClient(value = "ebank-spring-integration")
@RestController
public interface EbankSpringIntegrationRpc {

    /**
     * get User account summary cardino list
     * @return
     */
    @ApiOperation("App-cafe: trigger an order")
    @RequestMapping(value = "springIntegrationFeign/v1/cafe/triggerAnOrder", method = RequestMethod.GET)
    public JSONObject triggerAnOrder();
}
