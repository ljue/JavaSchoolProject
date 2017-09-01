package com.jvschool.dao.Impl;

import com.jvschool.dao.AddressDAO;
import com.jvschool.dao.UserDAO;
import com.jvschool.entities.AddressEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AddressDAOImpl implements AddressDAO {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<AddressEntity> getAllAddressesByUserId(long userId) {

        List addresses = em.createQuery("FROM AddressEntity where userId=:userId and visible=:visible")
                .setParameter("userId",userId).setParameter("visible", true).getResultList();

        return addresses;
    }

    @Override
    public void addNewAddress(AddressEntity addressEntity) {

        addressEntity.setVisible(true);
        em.persist(addressEntity);

    }

    @Override
    public void removeAddress(long id) {

        Query query = em.createQuery("UPDATE AddressEntity set visible=:visible where addressId=:addressId")
                .setParameter("addressId", id).setParameter("visible", false);

        query.executeUpdate();

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
