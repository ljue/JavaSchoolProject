package com.jvschool.svc;

import com.jvschool.entities.UserEntity;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Людмила on 17.07.2017.
 */
public interface UserService {

    List<UserEntity> getAllUsers() ;
    UserEntity getUserById(Long id) ;
    UserEntity getUserByLogin(String login) ;
}
