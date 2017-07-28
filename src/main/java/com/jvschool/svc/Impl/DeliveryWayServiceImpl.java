package com.jvschool.svc.Impl;

import com.jvschool.dao.DeliveryWayDAO;
import com.jvschool.entities.DeliveryWayEntity;
import com.jvschool.svc.DeliveryWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
@Service
@Transactional
public class DeliveryWayServiceImpl implements DeliveryWayService {

    @Autowired
    private DeliveryWayDAO deliveryWayDAO;

    @Override
    public List<String> getAllDeliveryWays() {
        List<String> ls = new ArrayList<>();
        if(deliveryWayDAO.getAllDeliveryWays()!=null) {
            for(DeliveryWayEntity ds : deliveryWayDAO.getAllDeliveryWays()) {
                ls.add(ds.getDeliveryWayName());
            }
        }
        return ls;
    }

    @Override
    public DeliveryWayEntity getDeliveryWayByName(String name) {
        return deliveryWayDAO.getDeliveryWayByName(name);
    }
}
