package com.jvschool.util;


import com.jvschool.dao.UserDAO;
import com.jvschool.entities.RoleEntity;
import com.jvschool.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;


import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Людмила on 18.07.2017.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = null;

        user = userDAO.getUserByLogin(username);


        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        RoleEntity role = user.getRoleByRole();
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));

        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPass(), grantedAuthorities);
    }
}
