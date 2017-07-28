package com.jvschool.svc.Impl;

import com.jvschool.dao.DeliveryStatusDAO;
import com.jvschool.entities.DeliveryStatusEntity;
import com.jvschool.svc.DeliveryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
@Service
public class DeliveryStatusServiceImpl implements DeliveryStatusService {

    @Autowired
    private DeliveryStatusDAO deliveryStatusDAO;

    @Override
    public List<String> getAllDeliveryStatuses() {
        List<String> ls = new ArrayList<>();
        if(deliveryStatusDAO.getAllDeliveryStatuses()!=null) {
            for(DeliveryStatusEntity ps : deliveryStatusDAO.getAllDeliveryStatuses()) {
                ls.add(ps.getDeliveryStatusName());
            }
        }
        return ls;
    }

    @Override
    public DeliveryStatusEntity getDeliveryStatusByName(String name) {
        return deliveryStatusDAO.getDeliveryStatusByName(name);
    }
}
