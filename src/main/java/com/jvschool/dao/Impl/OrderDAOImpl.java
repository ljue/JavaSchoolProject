package com.jvschool.dao.Impl;

import com.jvschool.dao.OrderDAO;
import com.jvschool.dao.UserDAO;
import com.jvschool.entities.OrderEntity;
import com.jvschool.entities.UserEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
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

    @Autowired
    private UserDAO userDAO;



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

    @Override
    public List<OrderEntity> getOrdersByUserId(long id) {

        UserEntity user = userDAO.getUserById(id);
        List<OrderEntity> list = em.createQuery("FROM OrderEntity where user=:user")
                .setParameter("user",user).getResultList();

        return list;
    }
}
