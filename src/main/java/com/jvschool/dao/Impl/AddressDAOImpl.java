package com.jvschool.dao.Impl;

import com.jvschool.dao.AddressDAO;
import com.jvschool.dao.UserDAO;
import com.jvschool.entities.AddressEntity;
import com.jvschool.entities.UserEntity;
import com.jvschool.svc.UserService;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Людмила on 24.07.2017.
 */
@Repository
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<AddressEntity> getAllAddressesByUserId(long userId) {
        //UserEntity user = userDAO.getUserById(userId);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List addresses = session.createQuery("FROM AddressEntity where userId=:userId")
                .setParameter("userId",userId).list();
        session.getTransaction().commit();
        return addresses;
    }

    @Override
    public void addNewAddress(AddressEntity addressEntity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(addressEntity);
        session.getTransaction().commit();
    }


}
