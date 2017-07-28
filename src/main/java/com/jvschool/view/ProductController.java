package com.jvschool.view;

import com.jvschool.svc.ProductService;
import com.jvschool.util.Attributes.ProductAttribute;
import com.jvschool.util.Attributes.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

//    @RequestMapping(value = "/gocheckout", method = RequestMethod.GET)
//    public String goCheckout(@ModelAttribute("user") SessionUser user,Model model) {
//        if(user.getRole().equals("ROLE_ANONYM")) {
//            return "forward:/login";
//        }
//        return "forward:/checkout";
//    }




    @RequestMapping(value = "/addToCart/{idProduct}", method = RequestMethod.POST)
    public void addToCart(@PathVariable("idProduct") Long id, @ModelAttribute("user") SessionUser user, Model model) {

        if(user.getProducts()==null) {
            Map<Long,Integer> map= new HashMap<>();
            map.put(id,1);
            user.setProducts(map);
        } else {
            Integer val =user.getProducts().get(id);
            if(val==null)
            {
                user.getProducts().put(id,1);
            } else {
                val++;
                user.getProducts().put(id,val);
            }
        }
        model.addAttribute("user", user);
    }

    @RequestMapping(value = "/deleteFromCart/{idProduct}", method = RequestMethod.POST)
    public void deleteFromCart(@PathVariable("idProduct") Long id, @ModelAttribute("user") SessionUser user, Model model) {

        Integer val =user.getProducts().get(id);
        if(val==null) {
            return;
        } else {
            val--;
            if(val==0){
                user.getProducts().remove(id);
            }
            else {
                user.getProducts().put(id, val);
            }
        }
        model.addAttribute("user", user);
    }


    @RequestMapping(value = {"/bucket"}, method = RequestMethod.GET)
    public String goBucket(@ModelAttribute("user") SessionUser user, Model model) {

        //model.addAttribute("productsInCart", productService.getProductsToBuy(user.getProducts().keySet()));
        Map<ProductAttribute,Integer> productsInCart = new HashMap<>();
        double commonPrice=0L;
        if(!user.getProducts().isEmpty()) {
            for (Long productKey : user.getProducts().keySet()) {
                ProductAttribute pa= productService.getProductAttributeById(productKey);
                productsInCart.put(pa,user.getProducts().get(productKey));
                commonPrice=commonPrice+pa.getCost()*user.getProducts().get(productKey);
            }
        }



        model.addAttribute("productsInCart",productsInCart);
        model.addAttribute("commonPrice",String.format("%.2f", commonPrice));

        return "bucket";
    }

//    @RequestMapping(value = {"/reloadCart"}, method = RequestMethod.GET)
//    public String reloadCart() {
//
//        return "redirect:/bucket";
//    }


}
