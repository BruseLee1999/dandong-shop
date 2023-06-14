package com.lee.mapper;

import com.lee.pojo.Review;
import com.lee.vo.ReviewVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ReviewMapper {
    List<ReviewVO> findAllReviewByPid(int pid);
    int addToReview(int pid, int uid, String date, String type, String title, String content);
}
