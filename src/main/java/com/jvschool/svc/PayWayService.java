package com.jvschool.svc;

import com.jvschool.entities.PayWayEntity;

import java.util.List;


public interface PayWayService {
    /**
     * Some Desription
     *
     */
    List<String> getAllPayWays();
    PayWayEntity getPayWayByName(String name);
}
