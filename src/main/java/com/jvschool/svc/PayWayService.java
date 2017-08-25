package com.jvschool.svc;

import com.jvschool.entities.PayWayEntity;

import java.util.List;


public interface PayWayService {
    /**
     * Get list of names all pay ways
     * @return
     */
    List<String> getAllPayWays();

    /**
     * Get pay way entity by name
     * @param name
     * @return
     */
    PayWayEntity getPayWayByName(String name);
}
