package com.jvschool.util;

import com.jvschool.dto.SessionUser;
import com.jvschool.svc.api.SecurityService;
import com.jvschool.svc.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class RoleFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // default implementation ignored
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        SessionUser user = (SessionUser) session.getAttribute("user");
        if (user == null) {
            user = new SessionUser();
            session.setAttribute("user", user);
        }
//        SecurityContextHolder.getContext().getAuthentication().
//        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
//            String loginName = SecurityContextHolder.getContext().getAuthentication().getName();
//            if (loginName != null && user != null) {
//                UserEntity userEntityByEmail = userService.getUserByEmail(loginName);
//                UserEntity userEntityByLogin = userService.getUserByLogin(loginName);
//                SessionUser newUser = null;
//                if (userEntityByEmail != null) {
//                    newUser = new SessionUser(userEntityByEmail);
//                } else if (userEntityByLogin != null) {
//                    newUser = new SessionUser(userEntityByLogin);
//                }
//                newUser.setProducts(user.getProducts());
//                session.setAttribute("user", newUser);
//            }
//        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // default implementation ignored
    }
}
