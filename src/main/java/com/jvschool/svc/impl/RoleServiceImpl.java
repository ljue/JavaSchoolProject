package com.jvschool.svc.impl;

import com.jvschool.dao.api.RoleDAO;
import com.jvschool.model.RoleEntity;
import com.jvschool.svc.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;


    /**
     * {@inheritDoc}
     */
    @Override
    public RoleEntity getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void addRole(final String name) {
        final RoleEntity role = new RoleEntity();
        role.setRoleName(name);
        roleDAO.addRole(role);
    }
}
