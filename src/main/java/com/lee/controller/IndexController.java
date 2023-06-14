package com.lee.controller;

import com.lee.mapper.IndexMapper;
import com.lee.pojo.Index;
import com.lee.pojo.Product;
import com.lee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class IndexController {
    @Autowired
    ProductService productService;
    @Autowired
    IndexMapper indexMapper;

    @RequestMapping({"user/index.html","/index.html","account/index.html"})
    public String index(Model model){
        List<Product> newProduct = productService.findProductList();
        List<Product> hotProduct = productService.findHotProduct();
        List<Product> seaFood = productService.findSeaFood();
        List<Product> fruit = productService.findFruit();
        List<Product> others = productService.findOthers();

        List<Index> indexList = indexMapper.findIndexList();

        model.addAttribute("new_product",newProduct);
        model.addAttribute("hot_product",hotProduct);
        model.addAttribute("sea_food",seaFood);
        model.addAttribute("fruit",fruit);
        model.addAttribute("others",others);

        model.addAttribute("indexList",indexList);
        return "index";
    }
}
