package com.lee.controller;

import com.lee.pojo.Wish;
import com.lee.service.CartService;
import com.lee.service.ProductService;
import com.lee.service.WishService;
import com.lee.vo.WishVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/wish")
public class WishListController extends BaseController{

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    @Autowired
    WishService wishService;

    @RequestMapping("/showWishList")
    public String wishList(Model model, HttpSession session){
        List<WishVO> wishList = wishService.findWishVOByUid(getidFromSession(session));
        model.addAttribute("wishList",wishList);
        return "shop-wishlist";
    }

    @RequestMapping("/deleteWishList")
    public String deleteWishList(Model model, HttpServletRequest request, HttpSession session){
        wishService.deleteWishListByWid(new Integer(request.getParameter("wid")));
        List<WishVO> wishList = wishService.findWishVOByUid(getidFromSession(session));
        model.addAttribute("wishList",wishList);
        return "shop-wishlist";
    }
}
