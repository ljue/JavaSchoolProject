package com.jvschool.dao;

import com.jvschool.entities.DeliveryWayEntity;

import java.util.List;


public interface DeliveryWayDAO {

    List<DeliveryWayEntity> getAllDeliveryWays();
    DeliveryWayEntity getDeliveryWayByName(String name);
}
