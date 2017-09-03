package com.jvschool.dao.api;


import com.jvschool.model.OrderEntity;

import java.util.List;


public interface OrderDAO {

    void saveOrder(OrderEntity orderEntity);
    List<OrderEntity> getOrdersGroupByDeliveryStatus();
    OrderEntity getOrderById(long id);
    List<OrderEntity> getOrdersByUserId(long id);
    double getWeekProceed();
    double getMonthProceed();

}
