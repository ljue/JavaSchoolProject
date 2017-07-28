package com.jvschool.dao.Impl;

import com.jvschool.dao.OrderDAO;
import com.jvschool.entities.OrderEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Людмила on 28.07.2017.
 */
@Repository
public class OrderDAOImpl implements OrderDAO {
    @Override
    public void saveOrder(OrderEntity orderEntity) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(orderEntity);
        session.getTransaction().commit();
    }
}
