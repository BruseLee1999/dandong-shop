package com.lee.mapper;

import com.lee.pojo.Index;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IndexMapper {
    List<Index> findIndexList();
}
