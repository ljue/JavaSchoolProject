package com.jvschool.dao;

import com.jvschool.entities.RoleEntity;


public interface RoleDAO {
    RoleEntity getRoleByName(String nameRole);
    void addRole(RoleEntity role);
}
