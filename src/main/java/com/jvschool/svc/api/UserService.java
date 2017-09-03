package com.jvschool.svc.api;

import com.jvschool.model.UserEntity;
import com.jvschool.dto.SessionUser;

import java.util.List;


public interface UserService {

    List<UserEntity> getAllUsers() ;
    UserEntity getUserById(Long id) ;
    UserEntity getUserByLogin(String login);
    UserEntity getUserByEmail(String email);


    /**
     * Gets list of dto top users
     * @return
     */
    List<SessionUser> getTopUsers();

    /**
     * Method gets user entity by login and password and transforms it to do.
     * If such user does not exist, method returns null value.
     * @param login
     * @param password
     * @return
     */
    SessionUser loginUser(String login, String password);

    /**
     * Method creates user entity by user dto and save it in database.
     * @param user
     */
    void addUser(SessionUser user);

    /**
     * Method gets user entity by user dto and update its information in database.
     * @param user
     */
    void editUserInfo(SessionUser user);

    /**
     * Method gets user entity by user dto and update its password in database.
     * @param user
     */
    void editUserPassword(SessionUser user);

    /**
     * Method finds user by email and return his id or 0 if it does not exist.
     * @param email
     * @return
     */
    long getUserIdByEmail(String email);

    /**
     * Method finds user by login and return his id or 0 if it does not exist.
     * @param login
     * @return
     */
    long getUserIdByLogin(String login);

    /**
     * If user with such email exists in database,
     * method sends personal info (login, password) to email
     * and return true.
     * Else return false.
     * @param email
     * @return
     */
    boolean sendLoginPasswordToEmail(String email);
}
