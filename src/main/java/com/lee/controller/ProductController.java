package com.lee.controller;

import com.lee.pojo.Product;
import com.lee.service.ProductService;
import com.lee.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.List;

@Controller
public class ProductController extends BaseController {
    @Autowired
    ProductService productService;

    @RequestMapping("new_product")
    public String getNewList(Model model){
       List<Product> newProduct = productService.findProductList();
        model.addAttribute("new_product",newProduct);
        return "index";

    }
}
