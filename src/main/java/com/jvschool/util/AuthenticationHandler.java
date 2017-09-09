package com.jvschool.util;

import com.jvschool.dto.SessionUser;
import com.jvschool.model.UserEntity;
import com.jvschool.svc.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class AuthenticationHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        HttpSession session = httpServletRequest.getSession();
        SessionUser user = (SessionUser) session.getAttribute("user");

        String loginName = authentication.getName();

        if (loginName != null && user.getId() == 0) {

            UserEntity userEntityByEmail = userService.getUserByEmail(loginName);
            UserEntity userEntityByLogin = userService.getUserByLogin(loginName);
            SessionUser newUser = null;

            if (userEntityByEmail != null) {
                newUser = new SessionUser(userEntityByEmail);
            } else if (userEntityByLogin != null) {
                newUser = new SessionUser(userEntityByLogin);
            }

            newUser.setProducts(user.getProducts());
            session.setAttribute("user", newUser);
        }
        httpServletResponse.sendRedirect("/");
    }
}
