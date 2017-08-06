package com.jvschool.dao.Impl;

import com.jvschool.dao.OrderDAO;
import com.jvschool.dao.UserDAO;
import com.jvschool.entities.OrderEntity;
import com.jvschool.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

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

        double d = (double) em.createQuery(criteriaQuery).getSingleResult();

//        double dd = em.createQuery("select sum()")

        return d;
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

        double d = (double) em.createQuery(criteriaQuery).getSingleResult();

        return d;
    }


}
