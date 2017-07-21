package com.jvschool.dao;

import com.jvschool.entities.RoleEntity;

/**
 * Created by Людмила on 21.07.2017.
 */
public interface RoleDAO {
    RoleEntity getRoleByName(String nameRole);
}
