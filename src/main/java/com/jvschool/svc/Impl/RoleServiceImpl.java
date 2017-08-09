package com.jvschool.svc.Impl;

import com.jvschool.dao.RoleDAO;
import com.jvschool.entities.RoleEntity;
import com.jvschool.svc.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;



    public RoleEntity getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    public void addRole(String name) {
        RoleEntity role = new RoleEntity();
        role.setRoleName(name);
        roleDAO.addRole(role);
    }
}
