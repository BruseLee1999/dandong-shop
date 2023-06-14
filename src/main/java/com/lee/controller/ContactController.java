package com.lee.controller;

import com.lee.pojo.Product;
import com.lee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ContactController {
    @Autowired
    private ProductService productService;

    @RequestMapping({"/contact.html"})
    public String contact(Model model){
        List<Product> seaFood = productService.findSeaFood();
        List<Product> fruit = productService.findFruit();
        List<Product> others = productService.findOthers();

        model.addAttribute("sea_food",seaFood);
        model.addAttribute("fruit",fruit);
        model.addAttribute("others",others);
        return "contact";
    }
}
