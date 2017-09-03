package com.jvschool.dao.Impl;

import com.jvschool.dao.api.DeliveryStatusDAO;
import com.jvschool.model.DeliveryStatusEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


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

    @Override
    public void addDeliveryStatus(String name) {
        DeliveryStatusEntity deliveryStatusEntity = new DeliveryStatusEntity();
        deliveryStatusEntity.setDeliveryStatusName(name);
        em.persist(deliveryStatusEntity);
    }
}
