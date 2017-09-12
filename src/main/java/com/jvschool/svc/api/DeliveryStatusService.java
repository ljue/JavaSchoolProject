package com.jvschool.svc.api;

import com.jvschool.model.DeliveryStatusEntity;

import java.util.List;


public interface DeliveryStatusService {

    /**
     * Gets list of delivery status {@link DeliveryStatusEntity} and return list of their names.
     * @return
     */
    List<String> getAllDeliveryStatuses();

    /**
     * Gets delivery status {@link DeliveryStatusEntity} by name.
     * @param name
     * @return
     */
    DeliveryStatusEntity getDeliveryStatusByName(String name);

    /**
     * Creates new delivery status {@link DeliveryStatusEntity} by name and saves it in database.
     * @param name
     */
    void addDeliveryStatus(String name);
}
