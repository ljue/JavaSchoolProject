package com.jvschool.svc.api;


import com.jvschool.dto.OrderAttribute;

import java.util.List;



public interface OrderService {

    /**
     * Convert order dto to order entity and save it in database.
     * @param orderAttribute
     */
    void saveOrder(OrderAttribute orderAttribute);

    /**
     * Convert order dto to order entity and merge it in database.
     * @param orderAttribute
     */
    void editOrderDeliveryStatus(OrderAttribute orderAttribute);

    /**
     * Get list of order model grouping by delivery status and convert it to list of order dto.
     * @return
     */
    List<OrderAttribute> getOrdersGroupByDeliveryStatus();

    /**
     * Get order entity by order id and transform it to order dto.
     * @param id
     * @return
     */
    OrderAttribute getOrderById(long id);

    /**
     * Get list of order model by user id and transform it to list of order dto.
     * @param id
     * @return
     */
    List<OrderAttribute> getOrdersByUserId(long id);

    /**
     * Get proceed for a week.
     * @return
     */
    double getWeekProceed();

    /**
     * Get proceed for a month.
     * @return
     */
    double getMonthProceed();

}
