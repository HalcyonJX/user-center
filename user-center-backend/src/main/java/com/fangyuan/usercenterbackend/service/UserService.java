package com.fangyuan.usercenterbackend.service;

import com.fangyuan.usercenterbackend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
* @author HalcyonJX
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-05-12 11:19:53
*/
public interface UserService extends IService<User> {
    /**
     * 注册接口
     * @param userAccount 账号
     * @param userPassword 密码
     * @param checkPassword 校验密码
     * @return 返回新用户ID
     */
    long userRegister(String userAccount,String userPassword,String checkPassword,String planetCode);

    /**
     * 登录接口
     *
     * @param userAccount  用户账号
     * @param userPassword 用户密码
     * @param request 请求信息
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount, String userPassword, HttpServletRequest request);

    /**
     * 用户脱敏
     * @param originUser 原始用户
     * @return 返回脱敏用户
     */
    User getSafetyUser(User originUser);

    /**
     * 用户注销
     * @param request 请求
     * @return
     */
    int userLogout(HttpServletRequest request);
}
