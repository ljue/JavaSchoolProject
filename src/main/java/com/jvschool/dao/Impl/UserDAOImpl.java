package com.jvschool.dao.Impl;

import com.jvschool.dao.UserDAO;
import com.jvschool.entities.UserEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 17.07.2017.
 */

@Repository
public class UserDAOImpl implements UserDAO {

        public UserEntity getUserById(Long id) {

        UserEntity user = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        user = session.load(UserEntity.class, id);
        session.getTransaction().commit();
        return user;

    }

    public UserEntity getUserByLogin(String login){
        UserEntity user = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        user = session.load(UserEntity.class, login);
        session.getTransaction().commit();
        return user;
    }

    public List<UserEntity> getAllUsers() {

        List users = new ArrayList<UserEntity>();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        users = session.createQuery("FROM UserEntity ").list();
        session.getTransaction().commit();
        return users;
    }

    public void addUser(UserEntity user) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();

    }

    public UserEntity loginUser(String login, String password) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        UserEntity user = (UserEntity) session.createQuery("FROM UserEntity where login=:log"+
                " and pass=:passw").setParameter("log",login)
                .setParameter("passw",password).uniqueResult();
        session.getTransaction().commit();
        return user;
    }
}
