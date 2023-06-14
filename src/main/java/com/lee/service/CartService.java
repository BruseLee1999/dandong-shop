package com.lee.service;

import com.lee.mapper.CartMapper;
import com.lee.mapper.ProductMapper;
import com.lee.pojo.Cart;
import com.lee.pojo.Product;
import com.lee.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartMapper cartMapper;
    @Autowired
    ProductMapper productMapper;
    public void addToCart(int uid, int pid, int amount){
        Cart result = cartMapper.findByUidAndPid(uid,pid);
        if (result == null){//表示商品从未加入到购物车，则进行新增操作
            //创建一个cart对象
            Cart cart = new Cart();
            //补全数据
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            //价格：来自商品中的数据
            Product product = productMapper.findProductByPid(pid);
            cart.setPrice(product.getPrice());
            cart.setTotal_price((double)Math.round(product.getPrice() * amount * 100) / 100);
            cartMapper.addToCart(cart);
        }
        else {//表示商品在购物车已经存在，则进行更新操作
            int num = result.getNum() + amount;
            double total_price = (double)Math.round(num * result.getPrice() * 100) / 100;
            cartMapper.updateNumAndTPriceByCid(result.getCid(),num,total_price);
        }
    }

    public void cutToCart(int uid, int pid, int amount){
        Cart result = cartMapper.findByUidAndPid(uid,pid);
        int num = result.getNum() - amount;
        double total_price = (double)Math.round(num * result.getPrice() * 100) / 100;
        cartMapper.updateNumAndTPriceByCid(result.getCid(),num,total_price);
    }

    public List<CartVO> findCartVOByUid(int uid){return cartMapper.findVOByUid(uid);}

    public Cart findByCid(int cid){return cartMapper.findByCid(cid);}

    public int addNum(int cid){
        Cart result = cartMapper.findByCid(cid);
        int num = result.getNum() + 1;
        cartMapper.updateNumByCid(cid,num);
        //返回新的购物车数据总量
        return num;
    }

    public int deleteCartByCid(int cid){return cartMapper.deleteCartByCid(cid);}

    public int deleteCartByUid(int uid){return cartMapper.deleteCartByUid(uid);}
}
