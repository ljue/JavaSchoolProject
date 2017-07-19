package com.jvschool.view;

import com.jvschool.entities.UserEntity;
import com.jvschool.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Людмила on 19.07.2017.
 */

@Controller
@SessionAttributes("user")
public class NavigationController {

    @Autowired
    private UserService userService;


//    @RequestMapping(value = "/has_role", method = RequestMethod.POST)
//    public String login(@ModelAttribute("user") UserEntity user) {
//
//        UserEntity us = userService.loginUser(user.getLogin(),user.getPass());
//        if (us!=null) {
//            model.addAttribute("user",us);
//            return "home";
//        }
//        else {
//            model.addAttribute("error", "Username or password is incorrect.");
//            return "login";
//        }
//
//    }
}
