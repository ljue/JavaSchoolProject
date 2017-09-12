package com.jvschool.svc.api;

import com.jvschool.model.UserEntity;
import com.jvschool.dto.SessionUser;

import java.util.List;


public interface UserService {


    /**
     * Gets list of all users {@link UserEntity}.
     * @return
     */
    List<UserEntity> getAllUsers() ;

    /**
     * Gets user {@link UserEntity} by id.
     * @param id
     * @return
     */
    UserEntity getUserById(Long id) ;

    /**
     * Gets user {@link UserEntity} by login.
     * @param login
     * @return
     */
    UserEntity getUserByLogin(String login);

    /**
     * Gets user {@link UserEntity} by email.
     * @param email
     * @return
     */
    UserEntity getUserByEmail(String email);


    /**
     * Gets list of top users {@link UserEntity},
     * converts it to list of user dto {@link SessionUser} and returns it.
     * @return
     */
    List<SessionUser> getTopUsers();

    /**
     * Gets user {@link UserEntity} by login and password and converts it to dto {@link SessionUser}
     * If such user does not exist, returns null value.
     * @param login
     * @param password
     * @return
     */
    SessionUser loginUser(String login, String password);

    /**
     * Creates user {@link UserEntity} by user dto {@link SessionUser},
     * sets new role {@link com.jvschool.model.RoleEntity} with name 'ROLE_CLIENT'
     * and saves it in database.
     * @param user
     */
    void addUser(SessionUser user);

    /**
     * Gets user {@link UserEntity} by user dto {@link SessionUser} and updates its information in database.
     * @param user
     */
    void editUserInfo(SessionUser user);

    /**
     * Gets user {@link UserEntity} by user dto {@link SessionUser} and updates its password in database.
     * @param user
     */
    void editUserPassword(SessionUser user);

    /**
     * Finds user {@link UserEntity} by email and returns his id or 0 if it does not exist.
     * @param email
     * @return
     */
    long getUserIdByEmail(String email);

    /**
     * Finds user {@link UserEntity} by login and returns his id or 0 if it does not exist.
     * @param login
     * @return
     */
    long getUserIdByLogin(String login);

    /**
     * If user {@link UserEntity} with such email exists in database,
     * method sends personal info (login, password) to email
     * and returns true.
     * Else returns false.
     * @param email
     * @return
     */
    boolean sendLoginPasswordToEmail(String email);
}
