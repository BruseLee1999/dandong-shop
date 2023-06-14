package com.lee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//订单项实体类，显示订单中的商品数据
public class OrderItem {
    private int id;
    private String oid;
    private int pid;
    private String pname;
    private String image;
    private double price;
    private int num;
    private double total_price;//总价格
}
