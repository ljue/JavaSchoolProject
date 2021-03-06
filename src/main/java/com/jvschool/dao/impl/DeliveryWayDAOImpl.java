package com.jvschool.dao.impl;

import com.jvschool.dao.api.DeliveryWayDAO;
import com.jvschool.model.DeliveryWayEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class DeliveryWayDAOImpl implements DeliveryWayDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<DeliveryWayEntity> getAllDeliveryWays() {

        return em.createQuery("from DeliveryWayEntity ").getResultList();
    }

    @Override
    public DeliveryWayEntity getDeliveryWayByName(String name) {

        List list = em.createQuery("FROM DeliveryWayEntity where deliveryWayName=:name")
                .setParameter("name",name).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (DeliveryWayEntity) list.get(0);
    }
}
