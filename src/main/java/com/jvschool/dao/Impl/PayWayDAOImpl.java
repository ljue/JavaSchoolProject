package com.jvschool.dao.Impl;

import com.jvschool.dao.PayWayDAO;
import com.jvschool.entities.PayWayEntity;
import com.jvschool.entities.RoleEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
@Repository
public class PayWayDAOImpl implements PayWayDAO {
    @Override
    public List<PayWayEntity> getAllPayWays() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<PayWayEntity> ways = session.createQuery("from PayWayEntity ").list();
        session.getTransaction().commit();
        return  ways;
    }

    @Override
    public PayWayEntity getPayWayByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        PayWayEntity way = (PayWayEntity) session.createQuery("FROM PayWayEntity where payWayName=:name")
                .setParameter("name",name).uniqueResult();
        session.getTransaction().commit();
        return way;
    }
}
