package com.lee.controller;

import com.lee.pojo.Address;
import com.lee.pojo.Order;
import com.lee.pojo.User;
import com.lee.service.AddressService;
import com.lee.service.OrderService;
import com.lee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping({"/my-account"})
public class MyAccountController extends BaseController{
    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    AddressService addressService;

    @RequestMapping("")
    public String Account(){
        return "my-account";
    }
    @RequestMapping("/information")
    public String AccountInformationEdit(User user, Model model, HttpSession session){
        String username = user.getUsername();
        String telephone = user.getTelephone();
        String address = user.getAddress();
        User u1 = userService.Sel(getidFromSession(session));
        if (u1!=null){
            userService.updateUserInformation(getidFromSession(session), username, telephone, address);
            User u2 = userService.Sel(getidFromSession(session));
            model.addAttribute("username",u2.getUsername());
            model.addAttribute("telephone",u2.getTelephone());
            model.addAttribute("address",u2.getAddress());
        }
        return "redirect:/my-account-information.html";
    }

    @RequestMapping("/password")
    public String changePassword(
            @RequestParam("oldPassword") String oldPassword,
            @RequestParam("newPassword") String newPassword,
            @RequestParam("reNewPassword") String reNewPassword,
            Model model,HttpSession session){
        int id = getidFromSession(session);
        User u1 = userService.Sel(id);
        if(u1 == null){
            model.addAttribute("msg","用户不存在，请重新登录");
            return "login-register";
        }
        else if(!oldPassword.equals(u1.getPassword())){
            model.addAttribute("username",u1.getUsername());
            model.addAttribute("telephone",u1.getTelephone());
            model.addAttribute("address",u1.getAddress());
            model.addAttribute("msg","原密码错误，请重新输入！");
            return "my-account-information";
        }
        else if (!newPassword.equals(reNewPassword)){
            model.addAttribute("username",u1.getUsername());
            model.addAttribute("telephone",u1.getTelephone());
            model.addAttribute("address",u1.getAddress());
            model.addAttribute("msg","两次新密码输入不匹配，请重新输入！");
            return "my-account-information";
        }
        else {
            userService.updatePasswordById(id,newPassword);
            model.addAttribute("msg","密码已更改，请重新登录");
            return "login-register";
            }
    }

    @RequestMapping("/orderList")
    public String orderList(Model model, HttpSession session){
        int id = getidFromSession(session);
        List<Order> list = orderService.findOrderByUid(id);
        model.addAttribute("orderList",list);
        return "redirect:/my-account-order.html";
    }

    @RequestMapping("/address")
    public String addressList(Model model,HttpSession session){
        int id = getidFromSession(session);
        List<Address> list = addressService.findAddressByUid(id);
        {
            if (list == null){
                model.addAttribute("msg","还未添加收货地址，请点击上方按钮进行添加");
                return "redirect:my-account-address.html";
            }
            else {
                model.addAttribute("addressList",list);
                return "redirect:my-account-address.html";
            }
        }
    }

    @RequestMapping("/addAddress")
    public String addAddress(
            @RequestParam("name") String name, @RequestParam("mobile") String mobile,
            @RequestParam("address") String address, @RequestParam("type") String type,
            Model model,HttpSession session){
        int id = getidFromSession(session);
        addressService.addAddress(id,name,mobile,type,address);
        List<Address> list = addressService.findAddressByUid(id);
        model.addAttribute("addressList",list);
        return "redirect:my-account/address";
    }

    @RequestMapping("/deleteAddress")
    public String deleteAddress(Model model, HttpSession session, HttpServletRequest request){
        addressService.deleteAddressByAid(new Integer(request.getParameter("aid")));
        List<Address> list = addressService.findAddressByUid(getidFromSession(session));
        model.addAttribute("addressList",list);
        return "redirect:my-account/address";
    }
}
