package com.fangyuan.usercenterbackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 * @author HalcyonJX
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = -8364996575893854559L;

    private String userAccount;
    private String userPassword;
    private String checkPassword;
    private String planetCode;
}
