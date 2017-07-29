package com.jvschool.dao.Impl;

import com.jvschool.dao.UserDAO;
import com.jvschool.entities.UserEntity;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import java.util.List;

/**
 * Created by Людмила on 17.07.2017.
 */

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    public UserEntity getUserById(Long id) {

        List list  = em.createQuery("FROM UserEntity where id=:id")
            .setParameter("id",id).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (UserEntity) list.get(0);
    }

    public UserEntity getUserByLogin(String login){

        List list = em.createQuery("FROM UserEntity where login=:log")
                .setParameter("log",login).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (UserEntity) list.get(0);
    }

    public UserEntity getUserByEmail(String email){

        List list = em.createQuery("FROM UserEntity where email=:mail")
                .setParameter("mail",email).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (UserEntity) list.get(0);

    }

    public List<UserEntity> getAllUsers() {

        List users = em.createQuery("FROM UserEntity ").getResultList();

        return users;
    }

    public void addUser(UserEntity user) {


//        Query query = session.createQuery("INSERT INTO UserEntity (login, firstName, secondName, " +
//                "pass, email, birthday) values "+
//                " (:login, :firstName, :secondName, " +
//                ":pass, :email, :birthday)").setParameter(":login", user.getLogin()).
//                setParameter(":firstName",user.getFirstName()).
//                setParameter(":secondName",user.getSecondName()).
//                setParameter(":pass", user.getPass()).setParameter(":email", user.getEmail()).
//                setParameter(":birthday",user.getBirthday());

        em.persist(user);
        //int result=query.executeUpdate();


    }

    public void editUserInfo(UserEntity user) {

         Query query = em.createQuery("UPDATE UserEntity set login=:log, " +
                " firstName=:fname, secondName=:sname, email=:mail, birthday=:bday where id=:uid")
                .setParameter("uid",user.getId()).setParameter("log",user.getLogin()).
                setParameter("fname",user.getFirstName()).setParameter("sname",user.getSecondName()).
                setParameter("mail",user.getEmail()).setParameter("bday",user.getBirthday());

        query.executeUpdate();
        //em.merge(user);


    }

    public void editUserPassword(UserEntity user) {


        Query query = em.createQuery("UPDATE UserEntity set pass=:passw where id=:uid")
                .setParameter("uid",user.getId())
                .setParameter("passw", user.getPass());

        query.executeUpdate();


    }

    public UserEntity loginUser(String login, String password) {

        List list =  em.createQuery("FROM UserEntity where login=:log" +
                " and pass=:passw").setParameter("log", login)
                .setParameter("passw", password).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (UserEntity) list.get(0);
    }
}
