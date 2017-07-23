package com.jvschool.view;

import com.jvschool.util.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Людмила on 21.07.2017.
 */
@Controller
@SessionAttributes("user")
public class AddressController {


    @RequestMapping(value = {"/address"}, method = RequestMethod.GET)
    public String goAddressInfo(@ModelAttribute("user") SessionUser user) {
        return "address";
    }

//    @RequestMapping(value = "/addNewAddress", method = RequestMethod.GET)
//    public String goNewAddress(Model model) {
//        return "addNewAddress";
//    }
}
