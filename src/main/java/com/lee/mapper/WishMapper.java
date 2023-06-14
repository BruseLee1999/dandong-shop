package com.lee.mapper;

import com.lee.pojo.Wish;
import com.lee.vo.WishVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WishMapper {
    int addWishList(int pid,int uid);
    int deleteWishListByWid(int wid);
    List<WishVO> findWishVOByUid(int uid);
}
