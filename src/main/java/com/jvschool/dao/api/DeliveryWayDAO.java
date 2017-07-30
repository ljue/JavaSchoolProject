package com.jvschool.dao.api;

import com.jvschool.entities.DeliveryWayEntity;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
public interface DeliveryWayDAO {

    List<DeliveryWayEntity> getAllDeliveryWays();
    DeliveryWayEntity getDeliveryWayByName(String name);
}
