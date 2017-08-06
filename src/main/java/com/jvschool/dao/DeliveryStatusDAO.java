package com.jvschool.dao;

import com.jvschool.entities.DeliveryStatusEntity;

import java.util.List;


public interface DeliveryStatusDAO {

    List<DeliveryStatusEntity> getAllDeliveryStatuses();
    DeliveryStatusEntity getDeliveryStatusByName(String name);
    void addDeliveryStatus(String name);
}
