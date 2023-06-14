package com.lee.controller;

import com.lee.pojo.Index;
import com.lee.pojo.Product;
import com.lee.service.CartService;
import com.lee.service.IndexService;
import com.lee.service.ProductService;
import com.lee.service.WishService;
import com.lee.vo.CartVO;
import com.lee.vo.WishVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/indexLogin")
public class IndexLoginController extends BaseController{
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private WishService wishService;

    @Autowired
    private IndexService indexService;

    @RequestMapping("")
    public String indexLogin(Model model, HttpSession session){
        double totalPrice = 0;//购物车中所有商品的总价格
        List<Product> newProduct = productService.findProductList();
        List<Product> hotProduct = productService.findHotProduct();
        List<Product> seaFood = productService.findSeaFood();
        List<Product> fruit = productService.findFruit();
        List<Product> others = productService.findOthers();

        List<WishVO> wishVOList = wishService.findWishVOByUid(getidFromSession(session));

        List<Index> indexList = indexService.findIndexList();

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
        model.addAttribute("new_product",newProduct);
        model.addAttribute("hot_product",hotProduct);
        model.addAttribute("sea_food",seaFood);
        model.addAttribute("fruit",fruit);
        model.addAttribute("others",others);

        model.addAttribute("cartList",cartVOList);
        model.addAttribute("cartNum",cartVOList.size());
        model.addAttribute("totalPrice",totalPrice);

        model.addAttribute("wishNum",wishVOList.size());

        model.addAttribute("indexList",indexList);
        return "index-2";
    }

    @RequestMapping("/deleteCart")
    public String deleteCart(HttpServletRequest request){
        cartService.deleteCartByCid(new Integer(request.getParameter("cid")));
        return "redirect:/indexLogin";
    }
}
