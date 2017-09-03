package com.jvschool.svc.api;

import com.jvschool.model.DeliveryWayEntity;

import java.util.List;

public interface DeliveryWayService {

    /**
     * Get list of all delivery ways and return list of their names.
     * @return
     */
    List<String> getAllDeliveryWays();

    /**
     * Get delivery way entity by name.
     * @param name
     * @return
     */
    DeliveryWayEntity getDeliveryWayByName(String name);
}
