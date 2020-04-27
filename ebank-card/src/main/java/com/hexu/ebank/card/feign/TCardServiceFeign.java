package com.hexu.ebank.card.feign;

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
@RequestMapping("cardFeign/v1/card")
@RestController
public class TCardServiceFeign {
    private static final Logger logger = LoggerFactory.getLogger(TCardServiceFeign.class);
    private static final String classname = TCardServiceFeign.class.getName();


    @Autowired
    private TCardService tCardService;

    /**
     * get card list by user id
     * @return
     */
    @RequestMapping(value = "/getCardListByUserId/{userId}", method = RequestMethod.GET)
    public JSONObject getCardListByUserId(@PathVariable Integer userId) {
        return JsonUtil.getSuccessJsonObject(tCardService.selectAllTCardWarpperByUserId(userId));
    }

    /**
     * get card details by cardId
     * @return
     */
    @RequestMapping(value = "/getCardDetailsByCardId/{cardId}", method = RequestMethod.GET)
    public JSONObject getCardDetailsByCardId(@PathVariable Integer cardId) {
        return JsonUtil.getSuccessJsonObject(tCardService.getCardDetailsByCardId(cardId));
    }
}
