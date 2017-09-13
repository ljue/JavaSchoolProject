package com.jvschool.dao.impl;

import com.jvschool.dao.api.AddressDAO;
import com.jvschool.model.AddressEntity;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Log4j
@Repository
public class AddressDAOImpl implements AddressDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<AddressEntity> getAllAddressesByUserId(long userId) {

        return em.createQuery("FROM AddressEntity where userId=:userId and visible=:visible")
                .setParameter("userId",userId).setParameter("visible", true).getResultList();

    }

    @Override
    public void addNewAddress(AddressEntity addressEntity) {

        addressEntity.setVisible(true);
        em.persist(addressEntity);
        log.info("Add address: " + addressEntity.toString());
    }

    @Override
    public void removeAddress(long id) {

        Query query = em.createQuery("UPDATE AddressEntity set visible=:visible where addressId=:addressId")
                .setParameter("addressId", id).setParameter("visible", false);

        query.executeUpdate();
        log.info("Remove address with id: " + id);
    }

    @Override
    public AddressEntity getAddressById(long id) {

        List list = em.createQuery("FROM AddressEntity where addressId=:id")
                .setParameter("id",id).getResultList();

        return (list.isEmpty()) ? null : (AddressEntity) list.get(0);
    }


}
