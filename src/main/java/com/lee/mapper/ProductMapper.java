package com.lee.mapper;

import com.lee.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {
    List<Product> findProductList();
    List<Product> findHotProduct();
    List<Product> findAllProduct();
    Product findProductByPid(int pid);
    List<Product> findSeaFood();
    List<Product> findFruit();
    List<Product> findOthers();
}
