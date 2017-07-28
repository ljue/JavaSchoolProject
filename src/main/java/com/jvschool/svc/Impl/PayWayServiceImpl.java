package com.jvschool.svc.Impl;

import com.jvschool.dao.PayWayDAO;
import com.jvschool.entities.PayWayEntity;
import com.jvschool.svc.PayWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
@Service
public class PayWayServiceImpl implements PayWayService {

    @Autowired
    private PayWayDAO payWayDAO;

    @Override
    public List<String> getAllPayWays() {
        List<String> ls = new ArrayList<>();
        if(payWayDAO.getAllPayWays()!=null) {
            for (PayWayEntity pwe : payWayDAO.getAllPayWays()) {
                ls.add(pwe.getPayWayName());
            }
        }
        return ls;
    }

    @Override
    public PayWayEntity getPayWayByName(String name) {
        return payWayDAO.getPayWayByName(name);
    }
}