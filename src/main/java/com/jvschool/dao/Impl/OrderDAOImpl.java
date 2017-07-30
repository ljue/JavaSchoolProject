package com.jvschool.dao.Impl;

import com.jvschool.dao.OrderDAO;
import com.jvschool.entities.OrderEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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

    @Override
    public List<OrderEntity> getOrdersGroupByDeliveryStatus() {

        List list = em.createQuery("FROM OrderEntity " +
                " order by deliveryStatus.deliveryStatusId, dateTimeOrder").getResultList();
        return list;
    }

    @Override
    public OrderEntity getOrderById(long id) {

        List list = em.createQuery("FROM OrderEntity where orderId=:id")
                .setParameter("id",id).getResultList();

        if (list.isEmpty())
            return null;
        else
            return (OrderEntity) list.get(0);

    }
}
