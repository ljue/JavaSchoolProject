package com.jvschool.svc;

import com.jvschool.entities.UserEntity;
import com.jvschool.util.Attributes.SessionUser;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;


public interface UserService {

    List<UserEntity> getAllUsers() ;
    UserEntity getUserById(Long id) ;
    UserEntity getUserByLogin(String login);
    UserEntity getUserByEmail(String email);


    List<SessionUser> getTopUsers();
    SessionUser loginUser(String login, String password);
    void addUser(SessionUser user);
    void editUserInfo(SessionUser user);
    void editUserPassword(SessionUser user);
    long getUserIdByEmail(String email);
}
