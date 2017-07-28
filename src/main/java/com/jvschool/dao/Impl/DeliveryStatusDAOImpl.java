package com.jvschool.dao.Impl;

import com.jvschool.dao.DeliveryStatusDAO;
import com.jvschool.entities.DeliveryStatusEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
@Repository
public class DeliveryStatusDAOImpl implements DeliveryStatusDAO {
    @Override
    public List<DeliveryStatusEntity> getAllDeliveryStatuses() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<DeliveryStatusEntity> statuses = session.createQuery("from DeliveryStatusEntity ").list();
        session.getTransaction().commit();
        return  statuses;
    }

    @Override
    public DeliveryStatusEntity getDeliveryStatusByName(String name) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        DeliveryStatusEntity status = (DeliveryStatusEntity) session.createQuery("FROM DeliveryStatusEntity where deliveryStatusName=:name")
                .setParameter("name",name).uniqueResult();
        session.getTransaction().commit();
        return status;
    }
}
