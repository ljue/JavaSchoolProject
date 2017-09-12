package com.jvschool.svc.api;

import com.jvschool.model.DeliveryWayEntity;

import java.util.List;

public interface DeliveryWayService {

    /**
     * Gets list of all delivery ways {@link DeliveryWayEntity} and returns list of their names.
     * @return
     */
    List<String> getAllDeliveryWays();

    /**
     * Gets delivery way {@link DeliveryWayEntity} by name.
     * @param name
     * @return
     */
    DeliveryWayEntity getDeliveryWayByName(String name);
}
