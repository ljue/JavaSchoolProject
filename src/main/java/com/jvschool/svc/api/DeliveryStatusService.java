package com.jvschool.svc.api;

import com.jvschool.model.DeliveryStatusEntity;

import java.util.List;


public interface DeliveryStatusService {

    /**
     * Get list of delivery sttus model and return list of their names.
     * @return
     */
    List<String> getAllDeliveryStatuses();

    /**
     * Get delivery status entity by name.
     * @param name
     * @return
     */
    DeliveryStatusEntity getDeliveryStatusByName(String name);

    /**
     * Create new delivery status by name and save it in database.
     * @param name
     */
    void addDeliveryStatus(String name);
}
