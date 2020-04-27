package com.hexu.ebank.user.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.hexu.ebank.common.util.JsonUtil;
import com.hexu.ebank.user.entity.TUser;
import com.hexu.ebank.user.service.TUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("用户服务Base API")
@RequestMapping("/v1/Userbase")
@RestController
public class TUserBaseController {
    private static final Logger logger = LoggerFactory.getLogger(TUserBaseController.class);
    private static final String classname = TUserBaseController.class.getName();

    @Autowired
    private TUserService userService;

    /**
     * 根据usernmae 删除用户
     * @param username
     * @return
     */
    @ApiOperation(value = "根据id 删除用户" )
    @RequestMapping(value = "selectByUsername/{username}", method = RequestMethod.GET)
    public JSONObject selectByUsername(@PathVariable String username) {
        logger.info(classname + " username : {}", username);
        TUser result = null;
        try{
            result =  userService.selectByUsername(username);
        } catch (Exception e) {
            logger.error(classname + " Exception : {}", e);

            return JsonUtil.getFailJsonObject();
        }

        return JsonUtil.getSuccessJsonObject(result);
    }


    /**
     * 根据id 删除用户
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id 删除用户" )
    @RequestMapping(value = "deleteByPrimaryKey/{id}", method = RequestMethod.GET)
    public JSONObject deleteByPrimaryKey(@PathVariable Integer id) {
        logger.info(classname + " id : {}", id);
        int result = 0;
        try{
            result =  userService.deleteByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(classname + " Exception : {}", e);
            return JsonUtil.getFailJsonObject();
        }

        return JsonUtil.getSuccessJsonObject(result);
    }


    /**
     * 新增用户
     * @param record
     * @return
     */
    @ApiOperation(value = "新增用户" )
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public JSONObject insert(@RequestBody TUser record) {
        logger.info(classname + " record : {}", record);

        if(record == null){
            return JsonUtil.getFailJsonObject("user object is null");
        }

        if(record != null){
            if(StringUtils.isEmpty(String.valueOf(record.getId()))){
                return JsonUtil.getFailJsonObject("id is null");
            }

            if(StringUtils.isEmpty(String.valueOf(record.getId()))){
                return JsonUtil.getFailJsonObject("id is null");
            }

        }


        int result = 0;
        try{
            result =  userService.insert(record);
        } catch (Exception e) {
            logger.error(classname + " Exception : {}", e);
            return JsonUtil.getFailJsonObject();
        }

        return JsonUtil.getSuccessJsonObject(result);
    }

    /**
     * 根据 id 查询用户
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 查询用户" )
    @RequestMapping(value = "selectByPrimaryKey/{id}", method = RequestMethod.GET)
    public JSONObject selectByPrimaryKey(@PathVariable Integer id) {
        logger.info(classname + " id : {}", id);
        TUser result = null;
        try{
            result =  userService.selectByPrimaryKey(id);
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
    @RequestMapping(value = "selectAll", method = RequestMethod.GET)
    public JSONObject selectAll() {
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

    /**
     * 根据 id 更新用户
     * @param record
     * @return
     */
    @ApiOperation(value = "根据 id 更新用户 " )
    @RequestMapping(value = "updateByPrimaryKey", method = RequestMethod.POST)
    public JSONObject updateByPrimaryKey(@RequestBody TUser record) {

        logger.info(classname + " record : {}", record);
        int result = 0;
        try{
            result =  userService.updateByPrimaryKey(record);
        } catch (Exception e) {
            logger.error(classname + " Exception : {}", e);
            return JsonUtil.getFailJsonObject();
        }
        return JsonUtil.getSuccessJsonObject(result);
    }
}
