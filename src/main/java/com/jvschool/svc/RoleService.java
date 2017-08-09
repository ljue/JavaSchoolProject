package com.jvschool.svc;

import com.jvschool.entities.RoleEntity;
import org.springframework.stereotype.Service;


@Service
public interface RoleService {
    RoleEntity getRoleByName(String name);
    void addRole(String name);
}
