package com.lee.service;

import com.lee.mapper.CartMapper;
import com.lee.mapper.OrderMapper;
import com.lee.pojo.Cart;
import com.lee.pojo.Order;
import com.lee.pojo.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    public Order findOrderByOrderId(String orderId){return orderMapper.findOrderByOrderId(orderId);}

    public List<Order> findOrderByUid(int id){
        return orderMapper.findOrderByUid(id);
    }

    public int insertOrder(String order_id, int id, String date, String state, double total_price, String address){
        return orderMapper.insertOrder(order_id, id, date, state, total_price, address);
    }

    public int insertOrderItem(OrderItem orderItem){return orderMapper.insertOrderItem(orderItem);}

    public List<OrderItem> findOrderItemByOrderId(String orderId){
        return orderMapper.findOrderItemByOrderId(orderId);
    }

}
