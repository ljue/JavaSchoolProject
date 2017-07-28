package com.jvschool.dao.Impl;

import com.jvschool.dao.DeliveryWayDAO;
import com.jvschool.entities.DeliveryWayEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
@Repository
public class DeliveryWayDAOImpl implements DeliveryWayDAO {
    @Override
    public List<DeliveryWayEntity> getAllDeliveryWays() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<DeliveryWayEntity> ways = session.createQuery("from DeliveryWayEntity ").list();
        session.getTransaction().commit();
        return  ways;
    }

    @Override
    public DeliveryWayEntity getDeliveryWayByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        DeliveryWayEntity way = (DeliveryWayEntity) session.createQuery("FROM DeliveryWayEntity where deliveryWayName=:name")
                .setParameter("name",name).uniqueResult();
        session.getTransaction().commit();
        return way;
    }
}
