package com.lee.controller;

import com.lee.pojo.Product;
import com.lee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShopController {
    @Autowired
    ProductService productService;
    @RequestMapping({"/shop-list","shop.html","user/shop.html"})
    public String shop(Model model, HttpSession session){
        List<Product> AllProduct = productService.findAllProduct();
        int productNum = AllProduct.size();
        session.setAttribute("productNum",productNum);
        model.addAttribute("all_product",AllProduct);
        return "shop";
    }
}
