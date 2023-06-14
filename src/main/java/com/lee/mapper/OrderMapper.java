package com.lee.mapper;

import com.lee.pojo.Order;
import com.lee.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    int insertOrder(String order_id, int id, String date, String state, double total_price, String address);
    int insertOrderItem(OrderItem orderItem);
    Order findOrderByOrderId(String orderId);
    List<Order> findOrderByUid(int id);
    List<OrderItem> findOrderItemByOrderId(String orderId);
    List<OrderItem> findOrderItem();
}
