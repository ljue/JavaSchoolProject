package com.jvschool.svc;

import com.jvschool.entities.UserEntity;

import java.util.List;

/**
 * Created by Людмила on 17.07.2017.
 */
public interface UserService {

    List<UserEntity> getAllUsers() ;
    UserEntity getUserById(Long id) ;
    UserEntity getUserByLogin(String login) ;
    void addUser(UserEntity user);
    UserEntity loginUser(String login, String password);
}
