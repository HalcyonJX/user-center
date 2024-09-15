package com.guyue.usercenterbackend.service;

import com.guyue.usercenterbackend.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author HalcyonJX丶
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2024-09-15 23:41:23
*/
public interface UserService extends IService<User> {
    /**
     * 注册接口
     * @param userAccount 账号
     * @param userPassword 密码
     * @param checkPassword 校验密码
     * @return 返回新用户ID
     */
    long userRegister(String userAccount,String userPassword,String checkPassword);
}
