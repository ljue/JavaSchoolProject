package com.jvschool.dao;

import com.jvschool.entities.PayWayEntity;

import java.util.List;


public interface PayWayDAO {

    List<PayWayEntity> getAllPayWays();
    PayWayEntity getPayWayByName(String name);
}
