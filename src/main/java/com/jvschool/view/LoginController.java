package com.jvschool.view;

import com.jvschool.security.SecurityService;
import com.jvschool.svc.api.UserService;
import com.jvschool.dto.SessionUser;
import com.jvschool.util.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;


    @GetMapping(value = {"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping(value = "/login")
    public String start(Model model, String error, HttpServletRequest request) {
        if (error != null)
            model.addAttribute("error", "Username or password is incorrect.");
        else {
            String referrer = request.getHeader("Referer");
            request.getSession().setAttribute("url_prior_login", referrer);
        }
        return "login";
    }

    @GetMapping(value = "/403")
    public String accessDenied() {
        return "error/accessDenied";
    }


    @PostMapping(value = "/sendPassword")
    public @ResponseBody boolean sendForgotPassword(@RequestParam("sendEmail") String email) {
        return userService.sendLoginPasswordToEmail(email);
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
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.addUser(userForm);
        userForm.setId(userService.getUserIdByEmail(user.getEmail()));

        securityService.autoLogin(userForm.getLogin(),userForm.getConfirmPassword());

        userForm.setPass("");
        userForm.setConfirmPassword("");
        userForm.setProducts(user.getProducts());
        model.addAttribute("user",userForm);

        return "redirect:/home";
    }

    @PostMapping(value = "/registration/findEmail/")
    @ResponseBody
    public String checkEmailExisting(@RequestParam String email) {
        if (userService.getUserIdByEmail(email)!=0) {
            return "this email already exists";
        } else
            return "";
    }

    @PostMapping(value = "/registration/findLogin/")
    @ResponseBody
    public String checkLoginExisting(@RequestParam String login) {
        if (userService.getUserIdByLogin(login)!=0) {
            return "this login already exists";
        } else
            return "";
    }



}
