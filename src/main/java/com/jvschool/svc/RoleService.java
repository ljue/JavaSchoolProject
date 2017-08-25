package com.jvschool.svc;

import com.jvschool.entities.RoleEntity;
import org.springframework.stereotype.Service;


@Service
public interface RoleService {

    /**
     * Method returns role by role`s name
     * @param name
     * @return
     */
    RoleEntity getRoleByName(String name);

    /**
     * Method saves new role in database by name
     * @param name
     */
    void addRole(String name);
}
