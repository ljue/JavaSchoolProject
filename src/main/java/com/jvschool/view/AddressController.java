package com.jvschool.view;

import com.jvschool.svc.api.AddressService;
import com.jvschool.util.validators.AddressValidator;
import com.jvschool.dto.AddressAttribute;
import com.jvschool.dto.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("user")
@RequestMapping("/profile")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private AddressValidator addressValidator;


    @GetMapping(value = "/address")
    public String goAddressInfo(@ModelAttribute("user") SessionUser user, Model model) {

        model.addAttribute("addresses", addressService.getAllAddressesByUserId(user.getId()));
        model.addAttribute("formAddAddress", new AddressAttribute());

        return "user/address";
    }


    @PostMapping(value = "/address/add")
    public String addNewAddress(@ModelAttribute("formAddAddress") AddressAttribute addressAttribute, BindingResult bindingResult,
    @ModelAttribute("user") SessionUser user) {

        addressValidator.validate(addressAttribute, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/address";
        }

        addressAttribute.setUserId(user.getId());
        addressService.addNewAddress(addressAttribute);

        return "redirect:/profile/address";
    }

    @PostMapping(value = "/address/remove/{addressId}")
    public void removeAddress(@PathVariable("addressId") long addressId) {

        addressService.removeAddress(addressId);

    }
}
