package com.lee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginRegisterController {
    @RequestMapping({"/user/login-out","login-register.html",
            "user/login-register.html","account/login-register.html"})
    public String toLoginRegister(){
        return "login-register";
    }
}
