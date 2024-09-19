package com.guyue.usercenterbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 * @author HalcyonJX丶
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 1715874587221689120L;
    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String planetCode;
}
