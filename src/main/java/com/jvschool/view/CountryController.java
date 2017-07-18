package com.jvschool.view;



import com.jvschool.entities.CountryEntity;
import com.jvschool.svc.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;

/**
 * Created by Людмила on 14.07.2017.
 */

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    //private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CountryController.class);
    //private static Logger log = Logger.getLogger(CountryController.class.getName());


    @RequestMapping(value = "countries", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("country", new CountryEntity());
        model.addAttribute("countries", countryService.getAllCountries());
        return "countries";

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "index";
    }

    @RequestMapping(value = "settings", method = RequestMethod.GET)
    public String goLogin(Model model) {
        return "settings";

    }

}