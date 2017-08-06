package com.jvschool.view;

import com.jvschool.svc.ProductCategoryService;
import com.jvschool.svc.ProductService;
import com.jvschool.util.Attributes.FilterAttribute;
import com.jvschool.util.Attributes.ProductAttribute;
import com.jvschool.util.Attributes.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@SessionAttributes("user")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;


    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String goCatalog(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());
        model.addAttribute("filter", new FilterAttribute());

        model.addAttribute("categories", productCategoryService.getAllProductCategoryNames());

        return "catalog";
    }


    @GetMapping(value = "/catalog/{category}")
    public String getProductsByCategory(@PathVariable("category") String category, Model model) {
        if (category.equals("All")) {
            model.addAttribute("allProducts", productService.getAllProducts());
        }
        else {
            model.addAttribute("allProducts", productService.getProductsByCategory(category));
        }

        model.addAttribute("filter", new FilterAttribute());
        model.addAttribute("categories", productCategoryService.getAllProductCategoryNames());

        return "catalog";
    }

    @PostMapping(value = "/catalog/doFilter")
    public String doFilterProducts(Model model, @ModelAttribute("filter") FilterAttribute filterAttribute) {

        model.addAttribute("allProducts", productService.getProductsWithFilter(filterAttribute));
        model.addAttribute("categories", productCategoryService.getAllProductCategoryNames());

        return "catalog";
    }


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


}
