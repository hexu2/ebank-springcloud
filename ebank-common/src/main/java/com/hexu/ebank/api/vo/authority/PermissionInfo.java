package com.hexu.ebank.api.vo.authority;

import lombok.Data;

import java.io.Serializable;


@Data
public class PermissionInfo implements Serializable{
    private String code;
    private String type;
    private String uri;
    private String method;
}
