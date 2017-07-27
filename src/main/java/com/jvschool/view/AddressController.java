package com.jvschool.view;

import com.jvschool.entities.AddressEntity;
import com.jvschool.svc.*;
import com.jvschool.util.Attributes.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

/**
 * Created by Людмила on 21.07.2017.
 */
@Controller
@SessionAttributes("user")
public class AddressController {

    @Autowired
    private AddressService addressService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private CityService cityService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/address"}, method = RequestMethod.GET)
    public String goAddressInfo(@ModelAttribute("user") SessionUser user, Model model) {
        List<AddressEntity> addrlist = addressService.getAllAddressesByUserId(user.getId());
        model.addAttribute("addresses", addrlist);
//        model.addAttribute("countries", countryService.getAllCountries());
//        model.addAttribute("cities", cityService.getAllCities());
//        model.addAttribute("regions",regionService.getAllRegions());
        model.addAttribute("formAddAddress", new AddressEntity());

        return "address";
    }

    @RequestMapping(value = "/address/add", method = RequestMethod.POST)
    public String addNewAddress(@ModelAttribute("formAddAddress") AddressEntity addressEntity,
    @ModelAttribute("user") SessionUser user) {
        addressEntity.setUserId(user.getId());
        addressService.addNewAddress(addressEntity);

        return "redirect:/address";
    }
}
