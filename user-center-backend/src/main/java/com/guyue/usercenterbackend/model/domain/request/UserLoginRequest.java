package com.guyue.usercenterbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 * @author HalcyonJX丶
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -5270240720065091076L;
    private String userAccount;
    private String userPassword;
}
