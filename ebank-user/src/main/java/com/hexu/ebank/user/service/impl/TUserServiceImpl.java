package com.hexu.ebank.user.service.impl;

import com.hexu.ebank.user.entity.TUser;
import com.hexu.ebank.user.mapper.TUserMapper;
import com.hexu.ebank.user.service.TUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserServiceImpl implements TUserService {

    private static final Logger logger = LoggerFactory.getLogger(TUserServiceImpl.class);
    private static final String classname = TUserServiceImpl.class.getName();

    @Autowired
    private TUserMapper userMapper;

    /**
     * login
     * @param tUser
     * @return
     */
    @Override
    public TUser login(TUser tUser) {

        TUser result = null;

        //请求为空
        if(tUser == null){
            logger.error(classname + "login : tUser = " + tUser);
            return null;
        }

        String username = tUser.getUsername();
        String password = tUser.getPassword();

        //用户名为空
        if (StringUtils.isEmpty(username)){
            logger.error(classname + "login : username = " + username);
            return null;
        }

        //密码为空
        if (StringUtils.isEmpty(password)){
            logger.error(classname + "login : username = " + password);
            return null;
        }

        try{
            //successfully
            result = userMapper.selectByUsernameAndPassWord(tUser);
        }catch(Exception e) {
            logger.error(classname + "login : exception = " + e);;
        }

        return result;
    }

    @Override
    public TUser selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TUser record) {
        return userMapper.insert(record);
    }

    @Override
    public TUser selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TUser> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(TUser record) {
        return userMapper.updateByPrimaryKey(record);
    }
}
