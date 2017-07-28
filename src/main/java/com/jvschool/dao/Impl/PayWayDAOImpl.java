package com.jvschool.dao.Impl;

import com.jvschool.dao.PayWayDAO;
import com.jvschool.entities.PayWayEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
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

        PayWayEntity way = (PayWayEntity) em.createQuery("FROM PayWayEntity where payWayName=:name")
                .setParameter("name",name).getSingleResult();

        return way;
    }
}
