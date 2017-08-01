package com.jvschool.dao;

import com.jvschool.entities.DeliveryStatusEntity;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
public interface DeliveryStatusDAO {

    List<DeliveryStatusEntity> getAllDeliveryStatuses();
    DeliveryStatusEntity getDeliveryStatusByName(String name);
    void addDeliveryStatus(String name);
}
