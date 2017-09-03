package com.jvschool.dao.api;

import com.jvschool.model.DeliveryWayEntity;

import java.util.List;


public interface DeliveryWayDAO {

    List<DeliveryWayEntity> getAllDeliveryWays();
    DeliveryWayEntity getDeliveryWayByName(String name);
}
