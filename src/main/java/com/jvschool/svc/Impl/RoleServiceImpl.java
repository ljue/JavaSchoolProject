package com.jvschool.svc.Impl;

import com.jvschool.dao.api.RoleDAO;
import com.jvschool.entities.RoleEntity;
import com.jvschool.svc.api.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Людмила on 21.07.2017.
 */

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;



    public RoleEntity getRoleByName(String nameRole) {
        return roleDAO.getRoleByName(nameRole);
    }
}
