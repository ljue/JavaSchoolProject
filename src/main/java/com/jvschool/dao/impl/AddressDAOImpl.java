package com.jvschool.dao.impl;

import com.jvschool.dao.api.AddressDAO;
import com.jvschool.dao.api.UserDAO;
import com.jvschool.entities.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
@Repository
public class AddressDAOImpl implements AddressDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<AddressEntity> getAllAddressesByUserId(long userId) {

        List addresses = em.createQuery("FROM AddressEntity where userId=:userId")
                .setParameter("userId",userId).getResultList();

        return addresses;
    }

    @Override
    public void addNewAddress(AddressEntity addressEntity) {

        em.persist(addressEntity);

    }

    @Override
    public AddressEntity getAddressById(long id) {

        List list = em.createQuery("FROM AddressEntity where addressId=:id")
                .setParameter("id",id).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (AddressEntity) list.get(0);
    }


}
