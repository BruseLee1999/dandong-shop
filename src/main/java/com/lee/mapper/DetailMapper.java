package com.lee.mapper;

import com.lee.pojo.Detail;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DetailMapper {
    Detail findProductDetailByPid(int pid);
}
