package com.lee.mapper;

import com.lee.pojo.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ImageMapper {
    Image findProductImageByPid(int pid);
}
