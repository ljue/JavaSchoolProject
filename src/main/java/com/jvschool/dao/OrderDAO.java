package com.jvschool.dao;

import com.jvschool.entities.DeliveryStatusEntity;
import com.jvschool.entities.OrderEntity;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
public interface OrderDAO {

    void saveOrder(OrderEntity orderEntity);
    List<OrderEntity> getOrdersGroupByDeliveryStatus();
    OrderEntity getOrderById(long id);
    List<OrderEntity> getOrdersByUserId(long id);
    void editDeliveryStatus(DeliveryStatusEntity deliveryStatusEntity, long id);
}
