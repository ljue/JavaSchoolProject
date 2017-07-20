package com.jvschool.view;



import com.jvschool.entities.CountryEntity;
import com.jvschool.svc.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Людмила on 14.07.2017.
 */

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("country", new CountryEntity());
        model.addAttribute("countries", countryService.getAllCountries());
        return "countries";

    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

    @RequestMapping(value = "settings", method = RequestMethod.GET)
    public String goLogin(Model model) {
        return "settings";

    }

    @RequestMapping(value = {"/bucket"}, method = RequestMethod.GET)
    public String goBucket(Model model) {
        return "bucket";
    }

    @RequestMapping(value = {"/navigation"}, method = RequestMethod.GET)
    public String goNav(Model model) {
        return "navigation";
    }

}