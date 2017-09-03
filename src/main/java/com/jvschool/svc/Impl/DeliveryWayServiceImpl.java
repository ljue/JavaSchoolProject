package com.jvschool.svc.Impl;

import com.jvschool.dao.api.DeliveryWayDAO;
import com.jvschool.model.DeliveryWayEntity;
import com.jvschool.svc.api.DeliveryWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DeliveryWayServiceImpl implements DeliveryWayService {

    @Autowired
    private DeliveryWayDAO deliveryWayDAO;

    @Override
    public List<String> getAllDeliveryWays() {
        List<String> ls = new ArrayList<>();
        deliveryWayDAO.getAllDeliveryWays()
                .stream().forEachOrdered(dwe -> ls.add(dwe.getDeliveryWayName()));
        return ls;
    }

    @Override
    public DeliveryWayEntity getDeliveryWayByName(String name) {
        return deliveryWayDAO.getDeliveryWayByName(name);
    }
}
