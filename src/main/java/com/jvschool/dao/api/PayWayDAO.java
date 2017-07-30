package com.jvschool.dao.api;

import com.jvschool.entities.PayWayEntity;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
public interface PayWayDAO {

    List<PayWayEntity> getAllPayWays();
    PayWayEntity getPayWayByName(String name);
}
