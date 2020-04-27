package com.hexu.ebank.card.controller;


import com.alibaba.fastjson.JSONObject;
import com.hexu.ebank.card.service.TCardService;
import com.hexu.ebank.common.util.JsonUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("账号服务API")
@RequestMapping("/v1/cardBase")
@RestController
public class TCardBaseController {
    private static final Logger logger = LoggerFactory.getLogger(TCardBaseController.class);
    private static final String classname = TCardBaseController.class.getName();


    @Autowired
    private TCardService tCardService;

    /**
     * Select All amount
     * @return
     */
    @RequestMapping(value = "/selectAllTCardWarpper", method = RequestMethod.GET)
    public JSONObject selectAllTCardWarpper() {
        return JsonUtil.getSuccessJsonObject(tCardService.selectAllTCardWarpper());
    }

    /**
     * Select All amount
     * @return
     */
    @RequestMapping(value = "/selectAllTCardWarpper/{userId}", method = RequestMethod.GET)
    public JSONObject selectAllTCardWarpperByUserId(@PathVariable Integer userId) {
        return JsonUtil.getSuccessJsonObject(tCardService.selectAllTCardWarpperByUserId(userId));
    }
}
