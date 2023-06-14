package com.lee.mapper;

import com.lee.pojo.Cart;
import com.lee.vo.CartVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CartMapper {
    int addToCart(Cart cart);
    int cutToCart(Cart cart);
    int updateNumAndTPriceByCid (int cid, int num, double total_price);
    int updateNumByCid(int cid, int num);
    Cart findByUidAndPid(int uid, int pid);
    Cart findByCid(int cid);
    int deleteCartByCid(int cid);
    int deleteCartByUid(int uid);
    List<CartVO> findVOByUid(int uid);
}
