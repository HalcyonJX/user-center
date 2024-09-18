package com.guyue.usercenterbackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.guyue.usercenterbackend.mapper.UserMapper;
import com.guyue.usercenterbackend.model.domain.User;
import com.guyue.usercenterbackend.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.guyue.usercenterbackend.constant.UserConstant.USER_LOGIN_STATE;

/**
* @author HalcyonJX丶
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2024-09-15 23:41:23
*/
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private UserMapper userMapper;

    //加密
    private static final String SALT = "guyue";


    @Override
    public long userRegister(String userAccount, String userPassword, String checkPassword) {
        //校验
        if(StringUtils.isAllBlank(userAccount,userPassword,checkPassword)){
            return -1;
        }
        if(userAccount.length() < 4){
            return -1;
        }
        if(userPassword.length() < 8 || checkPassword.length() < 8){
            return -1;
        }
        //账户不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\]/<>/?~! @#￥%……&*（）——+|{}【】‘；：“”’。，、？]"; //正则表达式，网上搜
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if(matcher.find()){
            return -1;
        }
        //密码和校验相同
        if(!userPassword.equals(checkPassword)){
            return -1;
        }
        //账号不能重复
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("userAccount",userAccount);
        Long count = userMapper.selectCount(userQueryWrapper);
        if(count > 0){
            return -1;
        }
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT + userPassword).getBytes());
        //插入数据
        User user = new User();
        user.setUserAccount(userAccount);
        user.setUserPassword(encryptPassword);
        boolean result = this.save(user);
        if(!result){
            return -1;
        }
        return user.getId();
    }

    @Override
    public User userLogin(String userAccount, String userPassword, HttpServletRequest request) {
        //先校验为空
        if(StringUtils.isAllBlank(userAccount,userPassword)){
            return null;
        }
        if(userAccount.length() < 4){
            return null;
        }
        if(userPassword.length() < 8){
            return null;
        }
        //账号不能包含特殊字符
        String validPattern = "[`~!@#$%^&*()+=|{}':;',\\\\[\\\\]/<>/?~! @#￥%……&*（）——+|{}【】‘；：“”’。，、？]"; //正则表达式，网上搜
        Matcher matcher = Pattern.compile(validPattern).matcher(userAccount);
        if (matcher.find()) {
            return null;
        }
        //加密
        String encryptPassword = DigestUtils.md5DigestAsHex((SALT+userPassword).getBytes());
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("userAccount",userAccount);
        userQueryWrapper.eq("userPassword",encryptPassword);
        User user = userMapper.selectOne(userQueryWrapper);
        //用户不存在
        if(user == null){
            //日志
            log.info("user login failed,userAccount Cannot match userPassword");
            return null;
        }
        //记录用户的登录态
        User safetyUser = getSafetyUser(user);
        request.getSession().setAttribute(USER_LOGIN_STATE,safetyUser);
        //用户脱敏
        return safetyUser;//注意这里返回脱敏后的user
    }
    /**
     * 用户脱敏
     * @param originUser 原始的用户
     * @return 返回脱敏的用户
     */
   @Override
    public User getSafetyUser(User originUser){
        User safetyUser = new User();
        safetyUser.setId(originUser.getId());
        safetyUser.setUsername(originUser.getUsername());
        safetyUser.setUserAccount(originUser.getUserAccount());
        safetyUser.setAvatarUrl(originUser.getAvatarUrl());
        safetyUser.setGender(originUser.getGender());
        safetyUser.setPhone(originUser.getPhone());
        safetyUser.setEmail(originUser.getEmail());
        safetyUser.setUserStatus(originUser.getUserStatus());
        safetyUser.setCreateTime(originUser.getCreateTime());
        safetyUser.setUserRole(originUser.getUserRole());
        return safetyUser;
    }
}




