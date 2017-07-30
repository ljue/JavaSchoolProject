package com.jvschool.svc.api;

import com.jvschool.dto.OrderAttribute;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
public interface OrderService {

    void saveOrder(OrderAttribute orderAttribute);
    List<OrderAttribute> getOrdersGroupByDeliveryStatus();
    OrderAttribute getOrderById(long id);

}
