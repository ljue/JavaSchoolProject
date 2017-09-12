package com.jvschool.view;

import com.jvschool.svc.api.AddressService;
import com.jvschool.svc.api.OrderService;
import com.jvschool.svc.api.ProductService;
import com.jvschool.svc.api.UserService;
import com.jvschool.dto.BucketAttribute;
import com.jvschool.dto.OrderAttribute;
import com.jvschool.dto.ProductAttribute;
import com.jvschool.dto.SessionUser;
import com.jvschool.util.validators.EditPassValidator;
import com.jvschool.util.validators.EditUserInfoValidator;
import com.jvschool.util.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@Controller
@SessionAttributes("user")
@RequestMapping("/profile")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EditUserInfoValidator editUserInfoValidator;

    @Autowired
    private EditPassValidator editPassValidator;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProductService productService;




    @GetMapping(value = "/")
    public String editUser(@ModelAttribute("user") SessionUser sessionUser,Model model) {
        SessionUser user = new SessionUser(userService.getUserById(sessionUser.getId()));
        model.addAttribute("user", user);
        model.addAttribute("userForm", user);
        return "user/profile";
    }

    @PostMapping(value = "/editInfo")
    public String editUser(@ModelAttribute("userForm") SessionUser userForm,
                           HttpServletRequest request,
                           BindingResult bindingResult, Model model) {


        editUserInfoValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
//            model.addAttribute("user", user);
            return "user/profile";
        }

        SessionUser user = (SessionUser) request.getSession().getAttribute("user");
        userForm.setId(user.getId());
        userService.editUserInfo(userForm);
        userForm.setProducts(user.getProducts());
        userForm.setRole(user.getRole());
        model.addAttribute("user",userForm);
        return "redirect:/profile/";
    }

    @PostMapping(value = "/editInfo/findEmail/")
    @ResponseBody
    public String checkEmailExisting(@RequestParam String email, @ModelAttribute("user") SessionUser user) {
        long id = userService.getUserIdByEmail(email);
        if (id!=0 && id!=user.getId()) {
            return "this email already exists";
        } else
            return "";
    }

    @PostMapping(value = "/editInfo/findLogin/")
    @ResponseBody
    public String checkLoginExisting(@RequestParam String login, @ModelAttribute("user") SessionUser user) {
        long id = userService.getUserIdByLogin(login);
        if (id!=0 && id!=user.getId()) {
            return "this login already exists";
        } else
            return "";
    }

    @PostMapping(value = "/editPass")
    public String editPass(@ModelAttribute("userForm") SessionUser userForm, HttpServletRequest request,
                           BindingResult bindingResult, Model model) {

        SessionUser user = (SessionUser) request.getSession().getAttribute("user");
        editPassValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "user/profile";
        }

        userForm.setId(user.getId());
        userService.editUserPassword(userForm);
        return "redirect:/profile/";
    }

    @GetMapping(value = "/history")
    public String goOrdersHistoryInfo(@ModelAttribute("user") SessionUser user, Model model) {

        model.addAttribute("ordersHistory", orderService.getOrdersByUserId(user.getId()));

        return "user/history";
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
                pa.setCost(ba.getCostProduct());
                productAttributes.add(pa);
                total = total+ Double.parseDouble(ba.getCostProduct())*ba.getCountProduct();
            }
        }
        model.addAttribute("products",productAttributes);
        model.addAttribute("orderIn", orderAttribute);
        model.addAttribute("buckets", bucketAttributes);
        model.addAttribute("addressOrder", addressService.getAddressById(orderAttribute.getAddressId()));
        model.addAttribute("total",String.format(Locale.US, "%.2f", total));

        return "user/orderInHistory";
    }

    @PostMapping(value = "/orderInHistory/repeatOrder/{orderId}")
    public boolean repeatOrder(@PathVariable("orderId") long id, @ModelAttribute("user") SessionUser user, Model model) {

        OrderAttribute orderAttribute = orderService.getOrderById(id);
        for(BucketAttribute bucketAttribute : orderAttribute.getBuckets()) {
            Integer val = user.getProducts().get(bucketAttribute.getProductId());
            if(val == null) {
                val = 0;
            }
            val += bucketAttribute.getCountProduct();
            user.getProducts().put(bucketAttribute.getProductId(), val);
        }
        return true;
    }



}
