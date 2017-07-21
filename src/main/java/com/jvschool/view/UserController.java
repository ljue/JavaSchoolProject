package com.jvschool.view;

import com.jvschool.entities.UserEntity;
import com.jvschool.svc.RoleService;
import com.jvschool.svc.UserService;
import com.jvschool.util.SessionUser;
import com.jvschool.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Людмила on 17.07.2017.
 */
@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserValidator userValidator;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String start(Model model) {
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") SessionUser user,
                        Model model, HttpServletRequest request, String error, String logout) {

        SessionUser us = new SessionUser(userService.loginUser(user.getLogin(),user.getPass()));
        if (us!=null) {
            model.addAttribute("user",us);
            return "redirect:/home";
        }
        else {
            model.addAttribute("error", "Username or password is incorrect.");
            return "login";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(@ModelAttribute("user") SessionUser user, Model model,
                         HttpServletRequest request) {
        model.addAttribute("user",new SessionUser());
        return "/login";
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new UserEntity());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userForm.setRoleByRole(roleService.getRoleByName("ROLE_CLIENT"));
        userService.addUser(userForm);
        SessionUser us = new SessionUser(userForm);
        model.addAttribute("user",us);
        return "redirect:/home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String editUser(Model model) {
        model.addAttribute("userForm", new UserEntity());

        return "user";
    }

    @RequestMapping(value = "/user/editInfo", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userForm") UserEntity userForm, @ModelAttribute("user") SessionUser sessionUser,
                           BindingResult bindingResult, Model model) {
        userForm.setId(sessionUser.getId());
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user";
        }
        userService.editUserInfo(userForm);
        SessionUser us = new SessionUser(userService.getUserById(userForm.getId()));
        model.addAttribute("user",us);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/editPass", method = RequestMethod.POST)
    public String editPass(@ModelAttribute("userForm") UserEntity userForm, @ModelAttribute("user") SessionUser sessionUser,
                           BindingResult bindingResult, Model model) {
        userForm.setId(sessionUser.getId());
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user";
        }
        userService.editUserPassword(userForm);
        SessionUser us = new SessionUser(userService.getUserById(userForm.getId()));
        model.addAttribute("user",us);
        return "redirect:/user";
    }

}
