package com.jvschool.view;

import com.jvschool.entities.UserEntity;
import com.jvschool.svc.*;
import com.jvschool.svc.Impl.OrderServiceImpl;
import com.jvschool.util.Attributes.BucketAttribute;
import com.jvschool.util.Attributes.OrderAttribute;
import com.jvschool.util.Attributes.ProductAttribute;
import com.jvschool.util.Attributes.SessionUser;
import com.jvschool.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Basic;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String start(Model model) {
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("user") SessionUser user,
                        Model model, HttpServletRequest request, String error, String logout) {

        UserEntity use = userService.loginUser(user.getLogin(),user.getPass());
        if (use!=null) {
            model.addAttribute("user", new SessionUser(use,user.getProducts()));
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
    public String registration(@ModelAttribute("userForm") UserEntity userForm, BindingResult bindingResult,
            @ModelAttribute("user") SessionUser user, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userForm.setRoleByRole(roleService.getRoleByName("ROLE_CLIENT"));
        userService.addUser(userForm);
        SessionUser us = new SessionUser(userForm, user.getProducts());
        model.addAttribute("user",us);
        return "redirect:/home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String editUser(@ModelAttribute("user") SessionUser sessionUser,Model model) {
        model.addAttribute("userForm", new UserEntity());
        return "user";
    }

    @RequestMapping(value = "/user/editInfo", method = RequestMethod.POST)
    public String editUser(@ModelAttribute("userForm") UserEntity userForm, @ModelAttribute("user") SessionUser sessionUser,
                           BindingResult bindingResult, Model model) {
        userForm.setId(sessionUser.getId());
        //userValidator.validate(userForm, bindingResult);!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (bindingResult.hasErrors()) {
            return "user";
        }
        userService.editUserInfo(userForm);
        SessionUser us = new SessionUser(userService.getUserById(userForm.getId()), sessionUser.getProducts());
        model.addAttribute("user",us);
        return "redirect:/user";
    }

    @RequestMapping(value = "/user/editPass", method = RequestMethod.POST)
    public String editPass(@ModelAttribute("userForm") UserEntity userForm, @ModelAttribute("user") SessionUser sessionUser,
                           BindingResult bindingResult, Model model) {
        userForm.setId(sessionUser.getId());
        //userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user";
        }
        userService.editUserPassword(userForm);
        SessionUser us = new SessionUser(userService.getUserById(userForm.getId()),sessionUser.getProducts());
        model.addAttribute("user",us);
        return "redirect:/user";
    }

    @RequestMapping(value = {"/history"}, method = RequestMethod.GET)
    public String goOrdersHistoryInfo(@ModelAttribute("user") SessionUser user, Model model) {

        model.addAttribute("ordersHistory", orderService.getOrdersByUserId(user.getId()));

        return "history";
    }

    @GetMapping(value = "/orderInHistory/{orderId}")
    public String goOrderInHistory(@PathVariable("orderId") long orderId, Model model) {

        OrderAttribute orderAttribute = orderService.getOrderById(orderId);
        List<BucketAttribute> bucketAttributes = orderAttribute.getBuckets();
        List<ProductAttribute> productAttributes = new ArrayList<>();
        Double total=0d;
        if(!bucketAttributes.isEmpty()) {
            for (BucketAttribute ba : bucketAttributes) {
                ProductAttribute pa = productService.getProductAttributeById(ba.getProductId());
                productAttributes.add(pa);
                total = total+pa.getCost()*ba.getCountProduct();
            }
        }
        model.addAttribute("products",productAttributes);
        model.addAttribute("orderIn", orderAttribute);
        model.addAttribute("buckets", bucketAttributes);
        model.addAttribute("addressOrder", addressService.getAddressById(orderAttribute.getAddressId()));

        model.addAttribute("total",total);



        return "orderInHistory";
    }



}
