package com.lee.controller;

import com.lee.pojo.Address;
import com.lee.pojo.Order;
import com.lee.pojo.OrderItem;
import com.lee.service.AddressService;
import com.lee.service.CartService;
import com.lee.service.OrderService;
import com.lee.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping({"/order","my-account/order"})
public class ShopOrderController extends BaseController{
    @Autowired
    private CartService cartService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private OrderService orderService;

    double totalPrice = 0;

    @RequestMapping("")
    public String showOrderList(Model model, HttpSession session){
        List<CartVO> cartVOList = cartService.findCartVOByUid(getidFromSession(session));
        List<Address> addressList = addressService.findAddressByUid(getidFromSession(session));
        for (int i = 0; i < cartVOList.size(); i++){
            CartVO cartVO = cartVOList.get(i);
            totalPrice = totalPrice + cartVO.getTotal_price();
        }
        model.addAttribute("cartVOList",cartVOList);
        model.addAttribute("addressList",addressList);
        model.addAttribute("totalPrice",totalPrice);
        return "shop-order";
    }

    @RequestMapping("/check")
    public String ConfirmOrderList(
            @RequestParam("address") String address,
            Model model, HttpSession session){
        String orderId = getUUID();
        List<CartVO> cartVOList = cartService.findCartVOByUid(getidFromSession(session));
        for(CartVO c:cartVOList){
            OrderItem orderItem = new OrderItem();
            orderItem.setOid(orderId);
            orderItem.setPid(c.getPid());
            orderItem.setPname(c.getPname());
            orderItem.setImage(c.getImage());
            orderItem.setPrice(c.getPrice());
            orderItem.setNum(c.getNum());
            orderItem.setTotal_price(c.getTotal_price());
            orderService.insertOrderItem(orderItem);
        }
        List<OrderItem> orderItemList = orderService.findOrderItemByOrderId(orderId);
        orderService.insertOrder(orderId,getidFromSession(session),getDate(),"已下单",totalPrice,address);
        cartService.deleteCartByUid(getidFromSession(session));

        model.addAttribute("title","下单成功！请查看您的本单信息：");
        model.addAttribute("address",address);
        model.addAttribute("orderNum",orderId);
        model.addAttribute("orderItemList",orderItemList);
        model.addAttribute("totalPrice",totalPrice);
        return "shop-order-after";
    }

    @RequestMapping("/showOrderList/{orderId}")
    public String orderList(@PathVariable("orderId") String orderId, Model model){
        Order order = orderService.findOrderByOrderId(orderId);
        List<OrderItem> orderItemList = orderService.findOrderItemByOrderId(orderId);
        for (int i = 0; i < orderItemList.size(); i++){
            OrderItem orderItem = orderItemList.get(i);
            totalPrice = totalPrice + orderItem.getTotal_price();
        }
        model.addAttribute("title","本单信息：");
        model.addAttribute("orderNum",orderId);
        model.addAttribute("address",order.getAddress());
        model.addAttribute("orderItemList",orderItemList);
        model.addAttribute("totalPrice",totalPrice);
        return "shop-order-after";
    }
}
