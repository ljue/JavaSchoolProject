package com.jvschool.svc.api;

import com.jvschool.model.PayWayEntity;

import java.util.List;


public interface PayWayService {
    /**
     * Gets list of all pay ways {@link PayWayEntity} and returns list of their names.
     * @return
     */
    List<String> getAllPayWays();

    /**
     * Gets pay way {@link PayWayEntity} by name.
     * @param name
     * @return
     */
    PayWayEntity getPayWayByName(String name);
}
