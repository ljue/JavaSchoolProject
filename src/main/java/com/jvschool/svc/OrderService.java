package com.jvschool.svc;


import com.jvschool.util.Attributes.OrderAttribute;

import java.util.List;



public interface OrderService {

    void saveOrder(OrderAttribute orderAttribute);
    List<OrderAttribute> getOrdersGroupByDeliveryStatus();
    OrderAttribute getOrderById(long id);
    List<OrderAttribute> getOrdersByUserId(long id);
    double getWeekProceed();
    double getMonthProceed();

}
