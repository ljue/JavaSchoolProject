package com.jvschool.dao.Impl;

import com.jvschool.dao.OrderDAO;
import com.jvschool.entities.OrderEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Людмила on 28.07.2017.
 */
@Repository
public class OrderDAOImpl implements OrderDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveOrder(OrderEntity orderEntity) {

        em.merge(orderEntity);

    }
}
