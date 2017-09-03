package com.jvschool.dao.api;

import com.jvschool.model.DeliveryStatusEntity;

import java.util.List;


public interface DeliveryStatusDAO {

    List<DeliveryStatusEntity> getAllDeliveryStatuses();
    DeliveryStatusEntity getDeliveryStatusByName(String name);
    void addDeliveryStatus(String name);
}
