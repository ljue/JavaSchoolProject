package com.jvschool.view;

import com.jvschool.entities.UserEntity;
import com.jvschool.svc.UserService;
import com.jvschool.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Людмила on 17.07.2017.
 */
@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

//    @ModelAttribute("user")
//    public UserEntity getUser() {
//        return new UserEntity();
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("user", new UserEntity());
        return "login";
    }


    @RequestMapping(value = "/login/checkuser", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") UserEntity user,
                        Model model, String error, String logout) {

        UserEntity us = userService.loginUser(user.getLogin(),user.getPass());
        if (us!=null) {
            model.addAttribute("user",us);
            return "home";
        }
        else {
            model.addAttribute("error", "Username or password is incorrect.");
            return "login";
        }

    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserEntity());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult, Model model) {
        UserValidator userValidator=new UserValidator();
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(userForm);

        return "redirect:/home";
    }


}
