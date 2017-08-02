package com.jvschool.dao;

import com.jvschool.entities.UserEntity;

import java.util.List;

/**
 * Created by Людмила on 17.07.2017.
 */
public interface UserDAO {

    List<UserEntity> getAllUsers();
    UserEntity getUserById(Long id);
    UserEntity getUserByLogin(String login);
    UserEntity getUserByEmail(String email);
    UserEntity loginUser(String login, String password);
    void addUser(UserEntity user);
    void editUserInfo(UserEntity user);
    void editUserPassword(UserEntity user);
    List<UserEntity> getTopUsers();
}
