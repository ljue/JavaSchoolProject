package com.jvschool.svc.api;

import com.jvschool.entities.DeliveryStatusEntity;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
public interface DeliveryStatusService {

    List<String> getAllDeliveryStatuses();
    DeliveryStatusEntity getDeliveryStatusByName(String name);
}
