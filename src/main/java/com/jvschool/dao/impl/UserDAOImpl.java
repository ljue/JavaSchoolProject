package com.jvschool.dao.impl;

import com.jvschool.dao.api.UserDAO;
import com.jvschool.model.OrderEntity;
import com.jvschool.model.UserEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;



@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public UserEntity getUserById(Long id) {

        List list  = em.createQuery("FROM UserEntity where id=:id")
            .setParameter("id",id).getResultList();

        return (list.isEmpty()) ? null : (UserEntity) list.get(0);
    }

    @Override
    public UserEntity getUserByLogin(String login){

        List list = em.createQuery("FROM UserEntity where login=:log")
                .setParameter("log",login).getResultList();

        return (list.isEmpty()) ? null : (UserEntity) list.get(0);
    }

    @Override
    public UserEntity getUserByEmail(String email){

        List list = em.createQuery("FROM UserEntity where email=:mail")
                .setParameter("mail",email).getResultList();

        return (list.isEmpty()) ? null : (UserEntity) list.get(0);

    }

    @Override
    public List<UserEntity> getAllUsers() {

        return em.createQuery("FROM UserEntity ").getResultList();
    }

    @Override
    public void addUser(UserEntity user) {

        em.persist(user);

    }

    @Override
    public void editUserInfo(UserEntity user) {

         Query query = em.createQuery("UPDATE UserEntity set login=:log, " +
                " firstName=:fname, secondName=:sname, email=:mail, birthday=:bday where id=:uid")
                .setParameter("uid",user.getId()).setParameter("log",user.getLogin()).
                setParameter("fname",user.getFirstName()).setParameter("sname",user.getSecondName()).
                setParameter("mail",user.getEmail()).setParameter("bday",user.getBirthday());

        query.executeUpdate();

    }

    @Override
    public void editUserPassword(UserEntity user) {


        Query query = em.createQuery("UPDATE UserEntity set pass=:passw where id=:uid")
                .setParameter("uid",user.getId())
                .setParameter("passw", user.getPass());

        query.executeUpdate();


    }


    @Override
    public UserEntity loginUser(String login, String password) {

        List list =  em.createQuery("FROM UserEntity where login=:log" +
                " and pass=:passw").setParameter("log", login)
                .setParameter("passw", password).getResultList();

        return (list.isEmpty()) ? null : (UserEntity) list.get(0);
    }

    @Override
    public List<UserEntity> getTopUsers() {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root order = criteriaQuery.from(OrderEntity.class);
        Join b = order.join("buckets");
        criteriaQuery.multiselect(order.get("user"));
        criteriaQuery.groupBy(order.get("user"));
        criteriaQuery.orderBy(criteriaBuilder.desc
                (criteriaBuilder.sum
                        (criteriaBuilder.prod
                                (b.get("countProduct"),
                                        b.get("productId").get("cost")))));

        List<UserEntity> list = em.createQuery(criteriaQuery).getResultList();

        int countTop = 10;
        countTop = countTop < list.size() ? countTop : list.size();

        return list.subList(0,countTop-1);
    }

    @Override
    public long getUserIdByEmail(String email) {
        List list =  em.createQuery("select u.id FROM UserEntity u where u.email=:email")
                .setParameter("email", email).getResultList();

        return (list.isEmpty()) ? 0 : (long) list.get(0);
    }

    @Override
    public long getUserIdByLogin(String login) {
        List list =  em.createQuery("select u.id FROM UserEntity u where u.login=:login")
                .setParameter("login", login).getResultList();

        return (list.isEmpty()) ? 0 : (long) list.get(0);
    }

}
