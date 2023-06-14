package com.lee.service;

import com.lee.mapper.ImageMapper;
import com.lee.pojo.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    private ImageMapper imageMapper;

    public Image findProductImageByPid(int pid){return imageMapper.findProductImageByPid(pid);}
}
