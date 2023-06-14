package com.lee.controller;

import com.lee.pojo.Cart;
import com.lee.pojo.Index;
import com.lee.pojo.Product;
import com.lee.pojo.User;
import com.lee.service.*;
import com.lee.vo.CartVO;
import com.lee.vo.WishVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping({"/user"})
public class LoginController extends BaseController{
    @Autowired
    private UserService userService;

    //登录操作
    @RequestMapping({"/loginUser"})
    public String login(User user, Model model, HttpSession session){
        String username = user.getUsername();
        String password = user.getPassword();
        User u1 =userService.login(username,password);
        if (u1==null){
            model.addAttribute("msg","用户名或密码错误，请重新输入");
            return "login-register";
        }else{
            //向session对象中完成数据的绑定
            session.setAttribute("id",u1.getId());
            session.setAttribute("username",u1.getUsername());
            session.setAttribute("telephone",u1.getTelephone());
            session.setAttribute("address",u1.getAddress());
            return "redirect:/indexLogin";
        }
    }

    //注册操作
    @RequestMapping("/register")
    public String register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("telephone") String telephone,
            Model model){
        User u2 = userService.findUserByName(username);
        if(u2 != null){
            model.addAttribute("rmsg","用户已存在，请在左边登录");
            return "login-register";
        }
        else {
            userService.register(username,password,telephone,getDate());
            model.addAttribute("rmsg","注册成功，请登录");
            return "login-register";
        }
    }

}