package com.lee.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
//购物车数据的VO类(Value Object)，值对象类
public class CartVO implements Serializable {
    private int cid;
    private int uid;
    private int pid;
    private double price;
    private int num;
    private String pname;
    private String image;
    private double total_price;

}
