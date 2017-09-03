package com.jvschool.dao.api;

import com.jvschool.model.RoleEntity;


public interface RoleDAO {
    RoleEntity getRoleByName(String nameRole);
    void addRole(RoleEntity role);
}
