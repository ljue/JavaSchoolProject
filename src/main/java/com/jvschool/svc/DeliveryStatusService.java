package com.jvschool.svc;

import com.jvschool.entities.DeliveryStatusEntity;

import java.util.List;


public interface DeliveryStatusService {

    List<String> getAllDeliveryStatuses();
    DeliveryStatusEntity getDeliveryStatusByName(String name);
    void addDeliveryStatus(String name);
}
