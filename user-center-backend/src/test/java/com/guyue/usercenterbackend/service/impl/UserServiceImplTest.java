package com.guyue.usercenterbackend.service.impl;
import java.util.Date;

import com.guyue.usercenterbackend.model.domain.User;
import com.guyue.usercenterbackend.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Resource
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setId(0L);
        user.setUsername("古月方源");
        user.setUserAccount("fangyuan");
        user.setUserPassword("123456");
        user.setAvatarUrl("https://raw.githubusercontent.com/HalcyonJX/blog-img/main/blog-imgimage-20240915234925341.png");
        user.setGender(1);
        user.setPhone("123");
        user.setEmail("456");
        user.setPlanetCode("1");

        boolean save = userService.save(user);
        Assertions.assertTrue(save);
    }

    @Test
    void userRegister() {
        String userAccount = "ningbing";
        String userPassword = "";
        String checkPassword = "123456";
        String planetCode = "5";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,planetCode);
        Assertions.assertEquals(-1,result);
        userAccount = "bin";
        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
        Assertions.assertEquals(-1,result);
        userAccount = "yupi";
        userPassword = "123456";
        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
        Assertions.assertEquals(-1,result);
        userAccount = "yu pi";
        userPassword = "12345678";
        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
        Assertions.assertEquals(-1,result);

        checkPassword = "123456789";
        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
        Assertions.assertEquals(-1,result);

        userAccount = "fangyuan";
        checkPassword = "12345678";
        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
        Assertions.assertEquals(-1,result);

        userAccount = "ningbing";
        result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
        Assertions.assertEquals(-1,result);
    }
}