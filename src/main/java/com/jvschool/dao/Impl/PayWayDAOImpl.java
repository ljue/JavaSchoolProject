package com.jvschool.dao.Impl;

import com.jvschool.dao.api.PayWayDAO;
import com.jvschool.model.PayWayEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class PayWayDAOImpl implements PayWayDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<PayWayEntity> getAllPayWays() {

        List<PayWayEntity> ways = em.createQuery("from PayWayEntity ").getResultList();

        return  ways;
    }

    @Override
    public PayWayEntity getPayWayByName(String name) {

        List list = em.createQuery("FROM PayWayEntity where payWayName=:name")
                .setParameter("name",name).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (PayWayEntity) list.get(0);
    }
}
