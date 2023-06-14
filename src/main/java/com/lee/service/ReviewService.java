package com.lee.service;

import com.lee.mapper.ReviewMapper;
import com.lee.pojo.Review;
import com.lee.vo.ReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewMapper reviewMapper;

    public List<ReviewVO> findAllReviewByPid(int pid){return reviewMapper.findAllReviewByPid(pid);}

    public int addToReview(int pid, int uid, String date, String type, String title, String content){
        return reviewMapper.addToReview(pid, uid, date, type, title, content);
    }
}
