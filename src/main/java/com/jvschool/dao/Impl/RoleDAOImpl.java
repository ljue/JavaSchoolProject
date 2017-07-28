package com.jvschool.dao.Impl;

import com.jvschool.dao.RoleDAO;
import com.jvschool.entities.RoleEntity;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Людмила on 21.07.2017.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public RoleEntity getRoleByName(String nameRole) {

        RoleEntity role = (RoleEntity) em.createQuery("FROM RoleEntity where name=:namerole")
                .setParameter("namerole",nameRole).getSingleResult();

        return role;
    }
}
