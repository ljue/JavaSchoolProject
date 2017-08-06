package com.jvschool.svc;

import com.jvschool.entities.UserEntity;
import com.jvschool.util.Attributes.SessionUser;

import java.util.List;


public interface UserService {

    List<UserEntity> getAllUsers() ;
    UserEntity getUserById(Long id) ;
    UserEntity getUserByLogin(String login);
    UserEntity getUserByEmail(String email);
    void addUser(UserEntity user);
    UserEntity loginUser(String login, String password);
    void editUserInfo(UserEntity user);
    void editUserPassword(UserEntity user);
    List<SessionUser> getTopUsers();
}
