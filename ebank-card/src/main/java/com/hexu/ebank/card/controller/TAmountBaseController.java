package com.hexu.ebank.card.controller;


import com.alibaba.fastjson.JSONObject;
import com.hexu.ebank.card.service.TAmountService;
import com.hexu.ebank.common.util.JsonUtil;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api("TAmount Base API")
@RequestMapping("/v1/tAmountBase")
@RestController
public class TAmountBaseController {
    private static final Logger logger = LoggerFactory.getLogger(TAmountBaseController.class);
    private static final String classname = TAmountBaseController.class.getName();

    @Autowired
    private TAmountService tAmountService;

    /**
     * Select All amount
     * @return
     */
    @RequestMapping(value = "/selectAllTamountWarpper", method = RequestMethod.GET)
    public JSONObject selectAllTamountWarpper() {
        return JsonUtil.getSuccessJsonObject(tAmountService.selectAllTamountWarpper());
    }

    /**
     * select amunt list by card id
     * @param cardId
     * @return
     */
    @RequestMapping(value = "/selectTamountWarpperByCardId/{cardId}", method = RequestMethod.GET)
    public JSONObject selectTamountWarpperByCardId(@PathVariable Integer cardId) {
        return JsonUtil.getSuccessJsonObject(tAmountService.selectTamountWarpperByCardId(cardId));
    }

}
