package com.lee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckoutController {
    @RequestMapping({"/shop-checkout.html"})
    public String checkout(){
        return "shop-checkout";
    }
}
