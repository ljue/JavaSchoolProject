package com.jvschool.view;

import com.jvschool.svc.AddressService;
import com.jvschool.svc.OrderService;
import com.jvschool.svc.ProductService;
import com.jvschool.svc.UserService;
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

import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProductService productService;




    @GetMapping(value = "/user")
    public String editUser(@ModelAttribute("user") SessionUser sessionUser,Model model) {
        model.addAttribute("userForm", new SessionUser());
        return "user";
    }

    @PostMapping(value = "/user/editInfo")
    public String editUser(@ModelAttribute("userForm") SessionUser userForm, @ModelAttribute("user") SessionUser user,
                           BindingResult bindingResult, Model model) {
        userForm.setId(user.getId());
        //userValidator.validate(userForm, bindingResult);!!!!!!!!!!!!!!!!!!!!!!!!!!!
        if (bindingResult.hasErrors()) {
            return "user";
        }
        userService.editUserInfo(userForm);
        userForm.setProducts(user.getProducts());
        model.addAttribute("user",userForm);
        return "redirect:/user";
    }

    @PostMapping(value = "/user/editPass")
    public String editPass(@ModelAttribute("userForm") SessionUser userForm, @ModelAttribute("user") SessionUser user,
                           BindingResult bindingResult, Model model) {
        userForm.setId(user.getId());
        //userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user";
        }
        userService.editUserPassword(userForm);
        userForm.setProducts(user.getProducts());
        model.addAttribute("user",userForm);
        return "redirect:/user";
    }

    @GetMapping(value = "/history")
    public String goOrdersHistoryInfo(@ModelAttribute("user") SessionUser user, Model model) {

        model.addAttribute("ordersHistory", orderService.getOrdersByUserId(user.getId()));

        return "history";
    }

    @GetMapping(value = "/orderInHistory/{orderId}")
    public String goOrderInHistory(@PathVariable("orderId") long orderId, Model model) {

        OrderAttribute orderAttribute = orderService.getOrderById(orderId);
        List<BucketAttribute> bucketAttributes = orderAttribute.getBuckets();
        List<ProductAttribute> productAttributes = new ArrayList<>();
        double total=0;
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
        model.addAttribute("total",String.format("%.2f", total));

        return "orderInHistory";
    }



}
