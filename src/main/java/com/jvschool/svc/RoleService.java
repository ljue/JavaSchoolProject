package com.jvschool.svc;

import com.jvschool.entities.RoleEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Людмила on 21.07.2017.
 */
@Service
public interface RoleService {
    RoleEntity getRoleByName(String nameRole);
}
