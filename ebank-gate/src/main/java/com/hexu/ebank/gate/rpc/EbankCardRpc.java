package com.hexu.ebank.gate.rpc;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("ebank-card 远程调用接口")
@FeignClient(value = "ebank-card")
@RestController
public interface EbankCardRpc {

    /**
     * get User account summary cardino list
     * @return
     */
    @ApiOperation("get User account summary cardino list")
    @RequestMapping(value = "cardFeign/v1/card/getCardListByUserId/{userId}", method = RequestMethod.GET)
    public JSONObject getCardListByUserId(@PathVariable Integer userId);
}
