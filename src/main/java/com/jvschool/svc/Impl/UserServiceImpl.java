package com.jvschool.svc.Impl;

import com.jvschool.dao.UserDAO;
import com.jvschool.entities.UserEntity;
import com.jvschool.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Людмила on 17.07.2017.
 */

@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<UserEntity> getAllUsers()  {
        return userDAO.getAllUsers();
    }

    @Override
    public UserEntity getUserById(Long id)  {
        return userDAO.getUserById(id);
    }

    @Override
    public UserEntity getUserByLogin(String login) {
        return userDAO.getUserByLogin(login);
    }

    @Override
    public void addUser(UserEntity user) { userDAO.addUser(user);}

    @Override
    public UserEntity loginUser(String login, String password) {
        return userDAO.loginUser(login,password);
    }
}
