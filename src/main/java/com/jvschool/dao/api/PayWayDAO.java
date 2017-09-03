package com.jvschool.dao.api;

import com.jvschool.model.PayWayEntity;

import java.util.List;


public interface PayWayDAO {

    List<PayWayEntity> getAllPayWays();
    PayWayEntity getPayWayByName(String name);
}
