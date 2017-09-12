package com.jvschool.security;

import com.jvschool.dao.api.UserDAO;
import com.jvschool.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) {
        UserEntity user;
        UserEntity userEntityByEmail = userDAO.getUserByEmail(s);
        UserEntity userEntityByLogin = userDAO.getUserByLogin(s);
        if(userEntityByEmail != null) {
            user = userEntityByEmail;
        } else if (userEntityByLogin != null) {
            user = userEntityByLogin;
        } else {
            throw new UsernameNotFoundException(s);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRoleByRole().getRoleName()));
        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPass(),grantedAuthorities);
    }
}
