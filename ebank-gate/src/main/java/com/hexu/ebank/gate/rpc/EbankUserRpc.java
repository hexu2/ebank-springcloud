package com.hexu.ebank.gate.rpc;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api("ebank-user 远程调用接口")
@FeignClient(value = "ebank-user")
@RestController
public interface EbankUserRpc {


    @ApiOperation(value = "根据用户名密码登录" )
    @RequestMapping(value = "userFeign/v1/user/login", method = RequestMethod.POST)
    JSONObject login1(@RequestParam("username") String username,
                             @RequestParam("password") String password);


    /**
     * 查询所有用户
     * @return
     */
    @ApiOperation(value = "查询所有用户" )
    @RequestMapping(value = "userFeign/v1/user/selectAllUser", method = RequestMethod.GET)
    JSONObject selectAllUser();
}
