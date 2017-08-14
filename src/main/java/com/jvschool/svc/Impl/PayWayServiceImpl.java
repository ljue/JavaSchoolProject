package com.jvschool.svc.Impl;

import com.jvschool.dao.PayWayDAO;
import com.jvschool.entities.PayWayEntity;
import com.jvschool.svc.PayWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PayWayServiceImpl implements PayWayService {

    @Autowired
    private PayWayDAO payWayDAO;

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public List<String> getAllPayWays() {
        List<String> ls = new ArrayList<>();
        payWayDAO.getAllPayWays()
                .stream().forEachOrdered(payWayEntity -> ls.add(payWayEntity.getPayWayName()));
        return ls;
    }

    @Override
    public PayWayEntity getPayWayByName(String name) {
        return payWayDAO.getPayWayByName(name);
    }
}
