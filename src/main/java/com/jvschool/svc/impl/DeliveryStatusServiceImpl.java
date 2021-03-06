package com.jvschool.svc.impl;

import com.jvschool.dao.api.DeliveryStatusDAO;
import com.jvschool.model.DeliveryStatusEntity;
import com.jvschool.svc.api.DeliveryStatusService;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getAllDeliveryStatuses() {
        List<String> ls = new ArrayList<>();
        deliveryStatusDAO.getAllDeliveryStatuses()
                .stream().forEachOrdered(de -> ls.add(de.getDeliveryStatusName()));
        return ls;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DeliveryStatusEntity getDeliveryStatusByName(String name) {
        return deliveryStatusDAO.getDeliveryStatusByName(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addDeliveryStatus(String name) {
        deliveryStatusDAO.addDeliveryStatus(name);
    }
}
