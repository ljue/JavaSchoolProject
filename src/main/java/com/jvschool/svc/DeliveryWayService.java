package com.jvschool.svc;

import com.jvschool.entities.DeliveryWayEntity;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
public interface DeliveryWayService {

    List<String> getAllDeliveryWays();
    DeliveryWayEntity getDeliveryWayByName(String name);
}
