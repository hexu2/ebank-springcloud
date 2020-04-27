package com.hexu.ebank.card.controller;

import com.alibaba.fastjson.JSONObject;
import com.hexu.ebank.common.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("查看Client instance 状态")
@RestController
public class InstanceStatusController {

    @ApiOperation("默认URI '/' ")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public JSONObject defaultPage(){

        return JsonUtil.getSuccessJsonObject("ebank-card success !!!");

    }
}
