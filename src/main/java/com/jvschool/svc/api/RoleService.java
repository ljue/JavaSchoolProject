package com.jvschool.svc.api;

import com.jvschool.model.RoleEntity;
import org.springframework.stereotype.Service;


@Service
public interface RoleService {

    /**
     * Method returns role {@link RoleEntity} by role`s name
     * @param name
     * @return
     */
    RoleEntity getRoleByName(String name);

    /**
     * Method saves new role {@link RoleEntity} in database by name
     * @param name
     */
    void addRole(String name);
}
