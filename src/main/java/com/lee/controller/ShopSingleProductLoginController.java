package com.lee.controller;

import com.lee.pojo.Detail;
import com.lee.pojo.Image;
import com.lee.pojo.Product;
import com.lee.pojo.Review;
import com.lee.service.*;
import com.lee.vo.CartVO;
import com.lee.vo.ReviewVO;
import com.lee.vo.WishVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShopSingleProductLoginController extends BaseController{
    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private WishService wishService;

    @Autowired
    private DetailService detailService;

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ImageService imageService;

    @RequestMapping({"shop-single-product-login.html","user/shop-single-product-login.html"})
    public String shopSingleLogin(Model model, HttpServletRequest request, HttpSession session){
        double totalPrice = 0;//购物车中所有商品的总价格
        List<WishVO> wishVOList = wishService.findWishVOByUid(getidFromSession(session));
        List<CartVO> cartVOList = cartService.findCartVOByUid(getidFromSession(session));
        if (cartVOList == null){
            totalPrice = 0;
        }
        else {
            for (int i = 0; i < cartVOList.size(); i++){
                CartVO cartVO = cartVOList.get(i);
                totalPrice = totalPrice + cartVO.getTotal_price();
            }
        }
        if(request.getParameter("pid") != null){
            Product product = productService.findProductByPid(new Integer(request.getParameter("pid")));
            Detail detail =detailService.findProductDetailByPid(new Integer(request.getParameter("pid")));
            List<ReviewVO> reviewVOList = reviewService.findAllReviewByPid(new Integer(request.getParameter("pid")));
            Image image = imageService.findProductImageByPid(new Integer(request.getParameter("pid")));

            session.setAttribute("pid",product.getPid());

            model.addAttribute("pid",request.getParameter("pid"));
            model.addAttribute("image",product.getImage());
            model.addAttribute("pname",product.getPname());
            model.addAttribute("price",product.getPrice());
            model.addAttribute("profile",product.getProfile());
            model.addAttribute("tip",product.getTip());
            model.addAttribute("weight",detail.getWeight());
            model.addAttribute("area",detail.getArea());
            model.addAttribute("pack",detail.getPack());
            model.addAttribute("domestic",detail.getDomestic());

            model.addAttribute("username",getUsernameFromSession(session));

            model.addAttribute("reviewVOList",reviewVOList);
            model.addAttribute("reviewNum",reviewVOList.size());

            model.addAttribute("cartList",cartVOList);
            model.addAttribute("cartNum",cartVOList.size());
            model.addAttribute("totalPrice",totalPrice);

            model.addAttribute("wishNum",wishVOList.size());

            model.addAttribute("image1",image.getImage1());
            model.addAttribute("image2",image.getImage2());
            model.addAttribute("image3",image.getImage3());
            model.addAttribute("image4",image.getImage4());
        }
        return "shop-single-product-login";
    }

    @RequestMapping("/review")
    public String review(
            @RequestParam("reviewType") String reviewType,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            Model model, HttpSession session){
        int uid = getidFromSession(session);
        int pid = getPidFromSession(session);

        reviewService.addToReview(pid, uid, getDate(), reviewType, title, content);
        Product product = productService.findProductByPid(pid);
        Detail detail =detailService.findProductDetailByPid(pid);


        List<ReviewVO> reviewVOList = reviewService.findAllReviewByPid(pid);
        model.addAttribute("pid",pid);
        model.addAttribute("pname",product.getPname());
        model.addAttribute("price",product.getPrice());
        model.addAttribute("profile",product.getProfile());
        model.addAttribute("tip",product.getTip());
        model.addAttribute("weight",detail.getWeight());
        model.addAttribute("area",detail.getArea());
        model.addAttribute("pack",detail.getPack());
        model.addAttribute("domestic",detail.getDomestic());

        model.addAttribute("username",getUsernameFromSession(session));
        model.addAttribute("reviewVOList",reviewVOList);
        model.addAttribute("reviewNum",reviewVOList.size());
        return "shop-single-product-login";
    }
}
