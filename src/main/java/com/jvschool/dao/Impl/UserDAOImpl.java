package com.jvschool.dao.Impl;

import com.jvschool.dao.UserDAO;
import com.jvschool.entities.UserEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.sql.SQLException;
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
        user = session.load(UserEntity.class, id);

        return user;

    }

    public UserEntity getUserByLogin(String login){
        UserEntity user = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        user = session.load(UserEntity.class, login);

        return user;
    }

    public List<UserEntity> getAllUsers() {

        List users = new ArrayList<UserEntity>();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        users = session.createQuery("FROM UserEntity ").list();

        return users;
    }
}
