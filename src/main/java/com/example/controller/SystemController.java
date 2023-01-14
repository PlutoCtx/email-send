package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author MaxBrooks chentingxian195467@163.com
 * @version 2023/1/14 10:48
 * @since JDK17
 */

@Controller
public class SystemController {

    /**
     * 登录页面跳转
     * @return 信息值
     */
    @GetMapping("login")
    public String login(){
        return "login";
    }

    /**
     * 注册页面跳转
     * @return 信息值
     */
    @GetMapping("registry")
    public String registry(){
        return "registry";
    }

}
