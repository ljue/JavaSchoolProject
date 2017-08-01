package com.jvschool.svc;

import com.jvschool.entities.OrderEntity;
import com.jvschool.util.Attributes.OrderAttribute;

import java.util.List;
import java.util.Map;

/**
 * Created by Людмила on 28.07.2017.
 */
public interface OrderService {

    void saveOrder(OrderAttribute orderAttribute);
    List<OrderAttribute> getOrdersGroupByDeliveryStatus();
    OrderAttribute getOrderById(long id);
    List<OrderAttribute> getOrdersByUserId(long id);

}
