package com.fangyuan.usercenterbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 * @author HalcyonJX
 */
@Data
public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = 229191219915041796L;
    private String userAccount;
    private String userPassword;
}
