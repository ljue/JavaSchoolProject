package com.jvschool.view;

import com.jvschool.svc.AddressService;
import com.jvschool.util.AddressValidator;
import com.jvschool.util.Attributes.AddressAttribute;
import com.jvschool.util.Attributes.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("user")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressValidator addressValidator;


    @GetMapping(value = "/address")
    public String goAddressInfo(@ModelAttribute("user") SessionUser user, Model model) {

        model.addAttribute("addresses", addressService.getAllAddressesByUserId(user.getId()));
        model.addAttribute("formAddAddress", new AddressAttribute());

        return "address";
    }


    @RequestMapping(value = "/address/add", method = RequestMethod.POST)
    public String addNewAddress(@ModelAttribute("formAddAddress") AddressAttribute addressAttribute, BindingResult bindingResult,
    @ModelAttribute("user") SessionUser user) {

        addressValidator.validate(addressAttribute, bindingResult);

        if (bindingResult.hasErrors()) {
            return "address";
        }

        addressAttribute.setUserId(user.getId());
        addressService.addNewAddress(addressAttribute);

        return "redirect:/address";
    }
}
