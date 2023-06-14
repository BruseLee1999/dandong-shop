package com.lee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int oid;//订单id
    private String order_id; //订单编号
    private int id;//用户id
    private String date;//下单时间
    private String state;//订单状态
    private double total_price;//总价格
    private String address;//收货地址
}
