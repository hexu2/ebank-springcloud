package com.hexu.ebank.api.vo.user;


import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Data
public class TUserVo implements Serializable{
    private Integer id;

    private String username;

    private String password;

    private String name;

    private String birthday;

    private String address;

    private String mobilePhone;

    private String telPhone;

    private String email;

    private String sex;

    private String status;

    private Date createTime;

    private Date updateTime;

    /**
     * 角色列表
     */
    private List<String> roleList = new ArrayList<>();
}