package com.lee.service;

import com.lee.mapper.IndexMapper;
import com.lee.pojo.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexService {
    @Autowired
    IndexMapper indexMapper;

    public List<Index> findIndexList(){return indexMapper.findIndexList();}
}
