package com.lee.service;

import com.lee.mapper.ProductMapper;
import com.lee.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductMapper productMapper;

    public List<Product> findProductList(){
        return productMapper.findProductList();
    }

    public List<Product> findAllProduct(){
        return productMapper.findAllProduct();
    }

    public List<Product> findHotProduct(){
        return productMapper.findHotProduct();
    }

    public Product findProductByPid(int pid){return productMapper.findProductByPid(pid);}

    public List<Product> findSeaFood(){
        return productMapper.findSeaFood();
    }

    public List<Product> findFruit(){
        return productMapper.findFruit();
    }

    public List<Product> findOthers(){
        return productMapper.findOthers();
    }
}
