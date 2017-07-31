package com.jvschool.view;

import com.jvschool.svc.AddressService;
import com.jvschool.svc.DeliveryWayService;
import com.jvschool.svc.OrderService;
import com.jvschool.svc.PayWayService;
import com.jvschool.util.Attributes.AddressAttribute;
import com.jvschool.util.Attributes.BucketAttribute;
import com.jvschool.util.Attributes.OrderAttribute;
import com.jvschool.util.Attributes.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 * Created by Людмила on 26.07.2017.
 */
@Controller
@SessionAttributes("user")
public class OrderController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private PayWayService payWayService;
    @Autowired
    private DeliveryWayService deliveryWayService;
    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/checkout")
    public String goCheckout(@ModelAttribute("user")SessionUser user, Model model) {

        if(user.getRole().equals("ROLE_ANONYM")) {
            return "forward:/login";
        }

        model.addAttribute("orderForm", new OrderAttribute());
        model.addAttribute("newAddress", new AddressAttribute());
        model.addAttribute("addresses", addressService.getAllAddressesByUserIdS(user.getId()));

        model.addAttribute("payWays", payWayService.getAllPayWays());
        model.addAttribute("deliveryWays",deliveryWayService.getAllDeliveryWays());
        return "checkout";
    }

    @PostMapping(value = "/checkout/goPay")
    public String goPay(@ModelAttribute("orderForm") OrderAttribute orderAttribute,
                        @ModelAttribute("user") SessionUser user, Model model) {

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



        if(orderAttribute.getPayWay().equals("By card")) {
            return "payOrder";
        }
        else {
            return "history";
        }


    }

    @RequestMapping(value = "/checkout/addNewAddress", method = RequestMethod.POST)
    public String addNewAddress(@ModelAttribute("addNewAddress") AddressAttribute addressAttribute,
                                @ModelAttribute("user") SessionUser user, Model model) {
        addressAttribute.setUserId(user.getId());
        addressService.addNewAddress(addressAttribute);


        return "redirect:/checkout";
    }



}
