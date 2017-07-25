package com.jvschool.dao.Impl;

import com.jvschool.dao.UserDAO;
import com.jvschool.entities.UserEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Query;
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
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
            UserEntity user  = (UserEntity) session.createQuery("FROM UserEntity where id=:id")
                .setParameter("id",id).uniqueResult();
        session.getTransaction().commit();
        return user;
    }

    public UserEntity getUserByLogin(String login){
        UserEntity user = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        user = (UserEntity) session.createQuery("FROM UserEntity where login=:log")
                .setParameter("log",login).uniqueResult();
        session.getTransaction().commit();
        return user;
    }

    public UserEntity getUserByEmail(String email){
        UserEntity user = null;

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        user = (UserEntity) session.createQuery("FROM UserEntity where email=:mail")
                .setParameter("mail",email).uniqueResult();
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
//        Query query = session.createQuery("INSERT INTO UserEntity (login, firstName, secondName, " +
//                "pass, email, birthday) values "+
//                " (:login, :firstName, :secondName, " +
//                ":pass, :email, :birthday)").setParameter(":login", user.getLogin()).
//                setParameter(":firstName",user.getFirstName()).
//                setParameter(":secondName",user.getSecondName()).
//                setParameter(":pass", user.getPass()).setParameter(":email", user.getEmail()).
//                setParameter(":birthday",user.getBirthday());

        session.save(user);
        //int result=query.executeUpdate();
        session.getTransaction().commit();

    }

    public void editUserInfo(UserEntity user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE UserEntity set login=:log, " +
                " firstName=:fname, secondName=:sname, email=:mail, birthday=:bday where id=:uid")
                .setParameter("uid",user.getId()).setParameter("log",user.getLogin()).
                setParameter("fname",user.getFirstName()).setParameter("sname",user.getSecondName()).
                setParameter("mail",user.getEmail()).setParameter("bday",user.getBirthday());

        query.executeUpdate();
        session.getTransaction().commit();

    }

    public void editUserPassword(UserEntity user) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("UPDATE UserEntity set pass=:passw where id=:uid")
                .setParameter("uid",user.getId())
                .setParameter("passw", user.getPass());

        query.executeUpdate();
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
