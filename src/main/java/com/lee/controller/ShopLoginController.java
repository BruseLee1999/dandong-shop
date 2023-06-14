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
public class ShopLoginController extends BaseController{
    @Autowired
    ProductService productService;
    @RequestMapping({"shop-login.html","user/shop-login.html","order/shop-login.html"})
    public String shopLogin(Model model, HttpSession session){
        List<Product> AllProduct = productService.findAllProduct();
        int productNum = AllProduct.size();
        session.setAttribute("productNum",productNum);
        model.addAttribute("product",AllProduct);
        model.addAttribute("username",getUsernameFromSession(session));
        return "shop-login";
    }

    @RequestMapping("/seaFood")
    public String findSeeFood(Model model, HttpSession session){
        List<Product> seaFoodList = productService.findSeaFood();
        int seeFoodNum = seaFoodList.size();
        session.setAttribute("productNum",seeFoodNum);
        model.addAttribute("product",seaFoodList);
        model.addAttribute("username",getUsernameFromSession(session));
        return "shop-login";
    }

    @RequestMapping("/fruit")
    public String findFruit(Model model, HttpSession session){
        List<Product> fruitList = productService.findFruit();
        int fruitNum = fruitList.size();
        session.setAttribute("productNum",fruitNum);
        model.addAttribute("product",fruitList);
        model.addAttribute("username",getUsernameFromSession(session));
        return "shop-login";
    }

    @RequestMapping("/others")
    public String findOthers(Model model, HttpSession session){
        List<Product> otherList = productService.findOthers();
        int otherNum = otherList.size();
        session.setAttribute("productNum",otherNum);
        model.addAttribute("product",otherList);
        model.addAttribute("username",getUsernameFromSession(session));
        return "shop-login";
    }

    @RequestMapping("/newProduct")
    public String findNewProduct(Model model, HttpSession session){
        List<Product> newProductList = productService.findProductList();
        int newProductNum = newProductList.size();
        session.setAttribute("productNum",newProductNum);
        model.addAttribute("product",newProductList);
        model.addAttribute("username",getUsernameFromSession(session));
        return "shop-login";
    }

    @RequestMapping("/hotProduct")
    public String findHotProduct(Model model, HttpSession session){
        List<Product> hotProductList = productService.findHotProduct();
        int hotProductNum = hotProductList.size();
        session.setAttribute("productNum",hotProductNum);
        model.addAttribute("product",hotProductList);
        model.addAttribute("username",getUsernameFromSession(session));
        return "shop-login";
    }
}
