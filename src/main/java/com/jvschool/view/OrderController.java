package com.jvschool.view;

import com.jvschool.dto.*;
import com.jvschool.svc.api.*;
import com.jvschool.util.validators.OrderValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.*;


@Controller
@SessionAttributes("user")
//@RequestMapping("/my-webapp")
public class OrderController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private PayWayService payWayService;
    @Autowired
    private DeliveryWayService deliveryWayService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderValidator orderValidator;

    @GetMapping(value = "/checkout")
    public String goCheckout(@ModelAttribute("user")SessionUser user, Model model) {
        if(user.getRole().equals("ROLE_ANONYM")) {
            return "redirect:/login";
        }

        model.addAttribute("orderForm", new OrderAttribute());
        model.addAttribute("newAddress", new AddressAttribute());
        model.addAttribute("addresses", addressService.getAllAddressesByUserId(user.getId()));

        model.addAttribute("payWays", payWayService.getAllPayWays());
        model.addAttribute("deliveryWays",deliveryWayService.getAllDeliveryWays());
        return "user/checkout";
    }

    @PostMapping(value = "/checkout/goPay")
    public String goPay(@ModelAttribute("orderForm") OrderAttribute orderAttribute,
                        @ModelAttribute("user") SessionUser user, Model model, BindingResult bindingResult) {

        orderValidator.validate(orderAttribute, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("newAddress", new AddressAttribute());
            model.addAttribute("orderForm", orderAttribute);
            model.addAttribute("addresses", addressService.getAllAddressesByUserId(user.getId()));
            model.addAttribute("payWays", payWayService.getAllPayWays());
            model.addAttribute("deliveryWays",deliveryWayService.getAllDeliveryWays());
            return "user/checkout";
        }

        orderAttribute.setUserId(user.getId());
        orderAttribute.setDateTimeOrder(new Timestamp(Calendar.getInstance().getTime().getTime()));
        List<BucketAttribute> buckets = new ArrayList<>();
        for(Map.Entry<Long,Integer> mli : user.getProducts().entrySet()) {
            BucketAttribute bucket = new BucketAttribute();
            bucket.setProductId(mli.getKey());
            bucket.setCountProduct(mli.getValue());
            buckets.add(bucket);
        }
        orderAttribute.setBuckets(buckets);
        orderService.saveOrder(orderAttribute);

        user.setProducts(new TreeMap<>());
        model.addAttribute(user);

        return "user/checkoutSuccess";
    }



    @PostMapping(value = "/checkout/addNewAddress")
    public String addNewAddress(@ModelAttribute("addNewAddress") AddressAttribute addressAttribute,
                                @ModelAttribute("user") SessionUser user, Model model) {
        addressAttribute.setUserId(user.getId());
        addressService.addNewAddress(addressAttribute);

        return "redirect:/checkout";
    }

    @ResponseBody
    @PostMapping(value = "/getCountInCart")
    public int getCountItemsInCart(@ModelAttribute("user") SessionUser user){
        return user.getProducts().entrySet().stream().mapToInt(s -> s.getValue()).sum();
    }


    @PostMapping(value = "/getProductsInCart")
    public String getProductItemsInCart(@ModelAttribute("user") SessionUser user, Model model){
        Map<ProductAttribute, Integer> productsInCart = new TreeMap<>();
        double totalPrice = 0;

        for (Long productKey : user.getProducts().keySet()) {
            ProductAttribute pa = productService.getProductAttributeById(productKey);
            productsInCart.put(pa, user.getProducts().get(productKey));
            totalPrice = totalPrice + Double.parseDouble(pa.getCost()) * user.getProducts().get(productKey);
        }
        model.addAttribute("productsInNavBar", productsInCart);
        model.addAttribute("totalInNavBar", String.format(Locale.US, "%.2f", totalPrice));

        return "../templates/cartDown";
    }

}
