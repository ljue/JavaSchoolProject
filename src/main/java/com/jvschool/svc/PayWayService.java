package com.jvschool.svc;

import com.jvschool.entities.PayWayEntity;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
public interface PayWayService {

    List<String> getAllPayWays();
    PayWayEntity getPayWayByName(String name);
}
