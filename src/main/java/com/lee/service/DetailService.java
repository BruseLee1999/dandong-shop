package com.lee.service;

import com.lee.mapper.DetailMapper;
import com.lee.pojo.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetailService {
    @Autowired
    private DetailMapper detailMapper;

    public Detail findProductDetailByPid(int pid){
        return detailMapper.findProductDetailByPid(pid);
    }
}
