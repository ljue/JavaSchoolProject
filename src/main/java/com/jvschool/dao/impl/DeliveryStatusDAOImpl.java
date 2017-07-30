package com.jvschool.dao.impl;

import com.jvschool.dao.api.DeliveryStatusDAO;
import com.jvschool.entities.DeliveryStatusEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Людмила on 28.07.2017.
 */
@Repository
public class DeliveryStatusDAOImpl implements DeliveryStatusDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<DeliveryStatusEntity> getAllDeliveryStatuses() {

        List<DeliveryStatusEntity> statuses = em.createQuery("from DeliveryStatusEntity order by deliveryStatusId")
                .getResultList();

        return  statuses;
    }

    @Override
    public DeliveryStatusEntity getDeliveryStatusByName(String name) {

        List list = em.createQuery("FROM DeliveryStatusEntity where deliveryStatusName=:name")
                .setParameter("name",name).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (DeliveryStatusEntity) list.get(0);
    }
}
