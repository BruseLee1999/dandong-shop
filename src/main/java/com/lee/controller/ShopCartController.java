package com.lee.controller;

import com.lee.pojo.Cart;
import com.lee.pojo.Product;
import com.lee.pojo.Wish;
import com.lee.service.CartService;
import com.lee.service.ProductService;
import com.lee.service.WishService;
import com.lee.util.JsonResult;
import com.lee.vo.CartVO;
import com.lee.vo.WishVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping({"/cart","my-account/cart","wish/cart"})
public class ShopCartController extends BaseController{
    @Autowired
    CartService cartService;
    @Autowired
    ProductService productService;
    @Autowired
    WishService wishService;

    @RequestMapping("/showCartList")
    public String showCartList(Model model, HttpSession session){
        List<CartVO> cartVOList = cartService.findCartVOByUid(getidFromSession(session));
        model.addAttribute("cartVOList",cartVOList);
        return "shop-cart";
    }

    @RequestMapping("/addCart")
    public String shop_cart(Model model, HttpSession session,@RequestParam("amount") Integer amount){
        int pid = getPidFromSession(session);
        cartService.addToCart(getidFromSession(session),pid,amount);
        List<CartVO> cartVOList = cartService.findCartVOByUid(getidFromSession(session));
        model.addAttribute("cartVOList",cartVOList);
        return "shop-cart";
    }

    @RequestMapping("/deleteCart")
    public String deleteCart(Model model, HttpServletRequest request, HttpSession session){
        cartService.deleteCartByCid(new Integer(request.getParameter("cid")));
        List<CartVO> cartVOList = cartService.findCartVOByUid(getidFromSession(session));
        model.addAttribute("cartVOList",cartVOList);
        return "shop-cart";
    }

    @RequestMapping("/addWishList")
    public String addWishList(Model model, HttpSession session){
        int pid = getPidFromSession(session);
        int id = getidFromSession(session);
        wishService.addWishList(pid,id);
        List<WishVO> wishList = wishService.findWishVOByUid(id);
        model.addAttribute("wishList",wishList);
        return "shop-wishList";
    }

    @RequestMapping("/wishAddCart/{pid}")
    public String wishAddCart(@PathVariable("pid")Integer pid, HttpSession session){
        cartService.addToCart(getidFromSession(session),pid,1);
        return "redirect:/cart/showCartList";
    }

    @RequestMapping("/addNum/{pid}")
    public String addNum(@PathVariable("pid")Integer pid, HttpSession session){
        cartService.addToCart(getidFromSession(session),pid,1);
        return "redirect:/cart/showCartList";
    }

    @RequestMapping("/cutNum/{pid}")
    public String cutNum(@PathVariable("pid")Integer pid, HttpSession session){
        cartService.cutToCart(getidFromSession(session),pid,1);
        return "redirect:/cart/showCartList";
    }

}
