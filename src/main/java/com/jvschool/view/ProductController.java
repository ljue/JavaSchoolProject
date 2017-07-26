package com.jvschool.view;

import com.jvschool.entities.ProductEntity;
import com.jvschool.svc.ProductService;
import com.jvschool.util.ProductAttribute;
import com.jvschool.util.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Людмила on 26.07.2017.
 */
@Controller
@SessionAttributes("user")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String goCatalog(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());

        return "catalog";
    }


    @RequestMapping(value = "/addToCart/{id}", method = RequestMethod.POST)
    public void addToCart(@PathVariable("id") Long id, @ModelAttribute("user") SessionUser user, Model model) {

        user.getListProducts().add(id);
        model.addAttribute("user", user);

    }

    @RequestMapping(value = {"/bucket"}, method = RequestMethod.GET)
    public String goBucket(@ModelAttribute("user") SessionUser user, Model model) {

        model.addAttribute("productsInCart", productService.getProductsToBuy(user.getListProducts()));

        return "bucket";

    }


}
