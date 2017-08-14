package com.jvschool.svc.Impl;

import com.jvschool.dao.OrderDAO;
import com.jvschool.dao.UserDAO;
import com.jvschool.entities.BucketEntity;
import com.jvschool.entities.OrderEntity;
import com.jvschool.entities.RoleEntity;
import com.jvschool.entities.UserEntity;
import com.jvschool.svc.RoleService;
import com.jvschool.svc.UserService;
import com.jvschool.util.Attributes.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private OrderDAO orderDAO;
    @Autowired
    private RoleService roleService;

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
    public List<SessionUser> getTopUsers() {

        List<UserEntity> lue = userDAO.getTopUsers();
        List<SessionUser> lsu = new ArrayList<>();
            for(UserEntity ue : lue) {
                SessionUser su = new SessionUser(ue);

                double total = 0;
                List<OrderEntity> loe = orderDAO.getOrdersByUserId(su.getId());
                for ( OrderEntity oa : loe) {
                    for (BucketEntity be : oa.getBuckets()) {
                        su.setSumCountProducts(su.getSumCountProducts()+be.getCountProduct());
                        total += be.getProductId().getCost();
                    }
                }
                su.setSumTotal(String.format("%.2f", total));

                lsu.add(su);
            }
        return lsu;
    }

    @Override
    public SessionUser loginUser(String login, String password) {
        UserEntity ue = userDAO.loginUser(login,password);
        if(ue!=null)
            return new SessionUser(ue);
        else
            return null;
    }

    @Override
    public void addUser(SessionUser user) {

        UserEntity userEntity = new UserEntity();

        userEntity.setLogin(user.getLogin());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setSecondName(user.getSecondName());
        userEntity.setPass(user.getPass());
        userEntity.setEmail(user.getEmail());
        userEntity.setBirthday(user.getBirthday());

        RoleEntity role = roleService.getRoleByName(user.getRole());
        if (role!=null) {
            userEntity.setRoleByRole(role);
        } else {
            role = new RoleEntity();
            role.setRoleName(user.getRole());
            userEntity.setRoleByRole(role);
        }

        userDAO.addUser(userEntity);
    }

    @Override
    public void editUserInfo(SessionUser user) {

        UserEntity userEntity = userDAO.getUserById(user.getId());
        userEntity.setBirthday(user.getBirthday());
        userEntity.setEmail(user.getEmail());
        userEntity.setSecondName(user.getSecondName());
        userEntity.setFirstName(user.getFirstName());
        userEntity.setLogin(user.getLogin());

        userDAO.editUserInfo(userEntity);
    }

    @Override
    public void editUserPassword(SessionUser user) {
        UserEntity ue = userDAO.getUserById(user.getId());
        ue.setPass(user.getPass());
        userDAO.editUserPassword(ue);
    }

    @Override
    public long getUserIdByEmail(String email) {
        return userDAO.getUserIdByEmail(email);
    }


}
