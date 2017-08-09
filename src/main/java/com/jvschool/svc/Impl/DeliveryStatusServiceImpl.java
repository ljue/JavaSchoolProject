package com.jvschool.svc.Impl;

import com.jvschool.dao.DeliveryStatusDAO;
import com.jvschool.entities.DeliveryStatusEntity;
import com.jvschool.svc.DeliveryStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class DeliveryStatusServiceImpl implements DeliveryStatusService {

    @Autowired
    private DeliveryStatusDAO deliveryStatusDAO;

    @Override
    public List<String> getAllDeliveryStatuses() {
        List<String> ls = new ArrayList<>();
        deliveryStatusDAO.getAllDeliveryStatuses()
                .stream().forEachOrdered(de -> ls.add(de.getDeliveryStatusName()));
        return ls;
    }

    @Override
    public DeliveryStatusEntity getDeliveryStatusByName(String name) {
        return deliveryStatusDAO.getDeliveryStatusByName(name);
    }

    @Override
    public void addDeliveryStatus(String name) {
        deliveryStatusDAO.addDeliveryStatus(name);
    }
}
