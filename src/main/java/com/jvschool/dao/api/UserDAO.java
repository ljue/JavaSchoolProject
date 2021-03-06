package com.jvschool.dao.api;

import com.jvschool.model.UserEntity;

import java.util.List;


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
    long getUserIdByEmail(String email);
    long getUserIdByLogin(String login);
}
