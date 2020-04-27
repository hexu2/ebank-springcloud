package com.hexu.ebank.user.feign;

import com.alibaba.fastjson.JSONObject;
import com.hexu.ebank.common.util.JsonUtil;
import com.hexu.ebank.user.entity.TUser;
import com.hexu.ebank.user.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api("用户服务 API before sync to feign service")
@RequestMapping("userFeign/v1/user")
@RestController
public class TUserServiceFeign {

    private static final Logger logger = LoggerFactory.getLogger(TUserServiceFeign.class);
    private static final String classname = TUserServiceFeign.class.getName();

    @Autowired
    private TUserService userService;


    @ApiOperation(value = "根据用户名密码登录" )
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JSONObject login1(@RequestParam("username") String username,
                             @RequestParam("password") String password) {

        TUser tUser = new TUser();
        tUser.setUsername(username);
        tUser.setPassword(password);

        TUser result = null;
        try{
            result =  userService.login(tUser);
        } catch (Exception e) {
            logger.error(classname + " Exception : {}", e);
            return JsonUtil.getFailJsonObject();
        }

        return JsonUtil.getSuccessJsonObject(result);

    }

    /**
     * 查询所有用户
     * @return
     */
    @ApiOperation(value = "查询所有用户" )
    @RequestMapping(value = "selectAllUser", method = RequestMethod.GET)
    public JSONObject selectAllUser() {
        logger.info(classname + " entry ");
        List<TUser> result = null;
        try{
            result =  userService.selectAll();
        } catch (Exception e) {
            logger.error(classname + " Exception : {}", e);
            return JsonUtil.getFailJsonObject();
        }

        return JsonUtil.getSuccessJsonObject(result);
    }


}
