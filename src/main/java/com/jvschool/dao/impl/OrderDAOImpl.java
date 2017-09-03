package com.jvschool.dao.impl;

import com.jvschool.dao.api.OrderDAO;
import com.jvschool.dao.api.UserDAO;
import com.jvschool.model.OrderEntity;
import com.jvschool.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.List;


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

        return em.createQuery("FROM OrderEntity " +
                " order by deliveryStatus.deliveryStatusId, dateTimeOrder").getResultList();
    }

    @Override
    public OrderEntity getOrderById(long id) {

        List list = em.createQuery("FROM OrderEntity where orderId=:id")
                .setParameter("id",id).getResultList();

        return (list.isEmpty()) ? null : (OrderEntity) list.get(0);

    }

    @Override
    public List<OrderEntity> getOrdersByUserId(long id) {

        UserEntity user = userDAO.getUserById(id);
        return em.createQuery("FROM OrderEntity where user=:user")
                .setParameter("user",user).getResultList();
    }

    @Override
    public double getWeekProceed() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root order = criteriaQuery.from(OrderEntity.class);
        Join b = order.join("buckets");
        criteriaQuery.multiselect(criteriaBuilder.sum
                (criteriaBuilder.prod
                        (b.get("countProduct"),
                                b.get("productId").get("cost"))));
        criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(
                order.get("dateTimeOrder"),
                new Date(System.currentTimeMillis() - 7L * 24 * 3600 * 1000)));

        return (double) em.createQuery(criteriaQuery).getSingleResult();
    }

    @Override
    public double getMonthProceed() {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root order = criteriaQuery.from(OrderEntity.class);
        Join b = order.join("buckets");
        criteriaQuery.multiselect(criteriaBuilder.sum
                (criteriaBuilder.prod
                        (b.get("countProduct"),
                                b.get("productId").get("cost"))));
        criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(
                order.get("dateTimeOrder"), new Date(System.currentTimeMillis() - 30L * 24 * 3600 * 1000)));

        return (double) em.createQuery(criteriaQuery).getSingleResult();
    }
}
