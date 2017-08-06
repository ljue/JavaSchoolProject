package com.jvschool.dao;


import com.jvschool.entities.OrderEntity;

import java.util.List;


public interface OrderDAO {

    void saveOrder(OrderEntity orderEntity);
    List<OrderEntity> getOrdersGroupByDeliveryStatus();
    OrderEntity getOrderById(long id);
    List<OrderEntity> getOrdersByUserId(long id);
    double getWeekProceed();
    double getMonthProceed();

}
