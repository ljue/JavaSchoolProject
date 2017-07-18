package com.jvschool.view;

import com.jvschool.entities.CountryEntity;
import com.jvschool.entities.UserEntity;
import com.jvschool.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

/**
 * Created by Людмила on 17.07.2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("users", userService.getAllUsers());
        return "user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }


}
