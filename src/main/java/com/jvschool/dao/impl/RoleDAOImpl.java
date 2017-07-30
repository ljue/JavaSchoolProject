package com.jvschool.dao.impl;

import com.jvschool.dao.api.RoleDAO;
import com.jvschool.entities.RoleEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Людмила on 21.07.2017.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public RoleEntity getRoleByName(String nameRole) {

        List list = em.createQuery("FROM RoleEntity where name=:namerole")
                .setParameter("namerole",nameRole).getResultList();

        if(list.isEmpty())
            return null;
        else
            return (RoleEntity) list.get(0);
    }
}
