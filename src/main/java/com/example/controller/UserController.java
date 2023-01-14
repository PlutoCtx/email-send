package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/1/14 12:05
 * @since JDK17
 */

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 注册账号
     * @param user
     * @return
     */
    @PostMapping("create")
    public Map<String, Object> createAccount(User user){
        return userService.createAccount(user);
    }

    /**
     * 登录账号
     * @param user
     * @return
     */
    @PostMapping("login")
    public Map<String, Object> loginAccount(User user){
        return userService.loginAccount(user);
    }

}
