package com.lee.service;

import com.lee.mapper.WishMapper;
import com.lee.pojo.Wish;
import com.lee.vo.WishVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishService {
    @Autowired
    WishMapper wishMapper;

    public int addWishList(int pid, int uid){return wishMapper.addWishList(pid, uid);}

    public int deleteWishListByWid(int wid){return wishMapper.deleteWishListByWid(wid);}

    public List<WishVO> findWishVOByUid(int uid){return wishMapper.findWishVOByUid(uid);}
}
