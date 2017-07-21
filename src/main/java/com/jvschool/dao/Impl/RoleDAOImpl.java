package com.jvschool.dao.Impl;

import com.jvschool.dao.RoleDAO;
import com.jvschool.entities.RoleEntity;
import com.jvschool.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * Created by Людмила on 21.07.2017.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {
    public RoleEntity getRoleByName(String nameRole) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        RoleEntity role = (RoleEntity) session.createQuery("FROM RoleEntity where name=:namerole")
                .setParameter("namerole",nameRole).uniqueResult();
        session.getTransaction().commit();
        return role;
    }
}
