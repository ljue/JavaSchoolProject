package com.jvschool.view;

import com.jvschool.svc.UserService;
import com.jvschool.util.Attributes.SessionUser;
import com.jvschool.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("user")
public class LoginController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping(value = {"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String start() {
        return "login";
    }


    @PostMapping(value = "/login")
    public String login(@ModelAttribute("user") SessionUser user,
                        Model model, HttpServletRequest request, String error, String logout) {

        SessionUser su = userService.loginUser(user.getLogin(),user.getPass());
        if (su!=null) {
            su.setProducts(user.getProducts());
            model.addAttribute("user", su);
            return "redirect:/home";
        }
        else {
            model.addAttribute("error", "Username or password is incorrect.");
            return "login";
        }
    }

    @GetMapping(value = "/logout")
    public String logout(@ModelAttribute("user") SessionUser user, Model model) {
        model.addAttribute("user",new SessionUser());
        return "/login";
    }


    @GetMapping(value = "/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new SessionUser());

        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registration(@ModelAttribute("userForm") SessionUser userForm, BindingResult bindingResult,
                               @ModelAttribute("user") SessionUser user, Model model) {
        userValidator.validate(userForm, bindingResult);
        userService.addUser(user);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userForm.setRole("ROLE_CLIENT");
        userService.addUser(userForm);
        userForm.setId(userService.getUserIdByEmail(user.getEmail()));
        userForm.setProducts(user.getProducts());
        model.addAttribute("user",userForm);
        return "redirect:/home";
    }
}
