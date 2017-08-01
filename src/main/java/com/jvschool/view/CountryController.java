package com.jvschool.view;



import com.jvschool.svc.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CountryController {


    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public String listUsers(Model model) {
//        model.addAttribute("country", new CountryEntity());
//        model.addAttribute("countries", countryService.getAllCountries());
        //model.addAttribute("product",productService.getProductAttributeById(18));


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



    @RequestMapping(value = {"/navigation"}, method = RequestMethod.GET)
    public String goNav(Model model) {
        return "navigation";
    }

}