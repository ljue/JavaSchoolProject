package com.jvschool.svc;

import com.jvschool.entities.DeliveryWayEntity;

import java.util.List;

public interface DeliveryWayService {

    List<String> getAllDeliveryWays();
    DeliveryWayEntity getDeliveryWayByName(String name);
}
