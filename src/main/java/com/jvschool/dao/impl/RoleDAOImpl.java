package com.jvschool.dao.impl;

import com.jvschool.dao.api.RoleDAO;
import com.jvschool.model.RoleEntity;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public RoleEntity getRoleByName(String name) {

        List list = em.createQuery("FROM RoleEntity where roleName=:name")
                .setParameter("name",name).getResultList();

        return (list.isEmpty()) ? null : (RoleEntity) list.get(0);
    }

    @Override
    public void addRole(RoleEntity role) {
        em.merge(role);
    }
}
