package com.jvschool.svc.Impl;

import com.jvschool.dao.OrderDAO;
import com.jvschool.dao.UserDAO;
import com.jvschool.entities.BucketEntity;
import com.jvschool.entities.OrderEntity;
import com.jvschool.entities.UserEntity;
import com.jvschool.svc.OrderService;
import com.jvschool.svc.UserService;
import com.jvschool.util.Attributes.BucketAttribute;
import com.jvschool.util.Attributes.OrderAttribute;
import com.jvschool.util.Attributes.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 17.07.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderDAO orderDAO;

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
    public UserEntity getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    @Override
    public void addUser(UserEntity user) { userDAO.addUser(user);}

    @Override
    public UserEntity loginUser(String login, String password) {
        return userDAO.loginUser(login,password);
    }

    @Override
    public void editUserInfo(UserEntity user) {
        userDAO.editUserInfo(user);
    }

    @Override
    public void editUserPassword(UserEntity user) { userDAO.editUserPassword(user);}

    @Override
    public List<SessionUser> getTopUsers() {

        List<UserEntity> lue = userDAO.getTopUsers();
        List<SessionUser> lsu = new ArrayList<>();
        if(!lue.isEmpty()) {
            for(UserEntity ue : lue) {
                SessionUser su = new SessionUser(ue);

                List<OrderEntity> loe = orderDAO.getOrdersByUserId(su.getId());
                for ( OrderEntity oa : loe) {
                    for (BucketEntity be : oa.getBuckets()) {
                        su.setSumCountProducts(su.getSumCountProducts()+be.getCountProduct());
                        su.setSumTotal(su.getSumTotal()+be.getProductId().getCost());
                    }
                }

                lsu.add(su);
            }
        }


        return lsu;
    }
}
