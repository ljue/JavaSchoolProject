package com.jvschool.view;

import com.jvschool.svc.CategoryService;
import com.jvschool.svc.ProductService;
import com.jvschool.svc.PropertyService;
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
@RequestMapping("/my-webapp")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private PropertyService propertyService;

    private String suchCategory;


    @GetMapping(value = "/catalog")
    public String goCatalog(Model model) {
        model.addAttribute("allProducts", productService.getAllProducts());
        model.addAttribute("filter", new FilterAttribute());
        model.addAttribute("allProperties", propertyService.getProperties());

        suchCategory = "All";
        model.addAttribute("categories", categoryService.getAllProductCategoryNames());

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
        suchCategory = category;

        model.addAttribute("filter", new FilterAttribute());
        model.addAttribute("categories", categoryService.getAllProductCategoryNames());
        model.addAttribute("allProperties", propertyService.getProperties());


        return "catalog";
    }

    @PostMapping(value = "/catalog/doFilter")
    public String doFilterProducts(Model model, @ModelAttribute("filter") FilterAttribute filterAttribute) {

        filterAttribute.setCategory(suchCategory);
        model.addAttribute("allProducts", productService.getProductsWithFilter(filterAttribute));
        model.addAttribute("categories", categoryService.getAllProductCategoryNames());
        model.addAttribute("allProperties", propertyService.getProperties());

        return "catalog";
    }


    @PostMapping(value = "/addToCart/{idProduct}")
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

    @PostMapping(value = "/deleteFromCart/{idProduct}")
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


    @GetMapping(value = "/bucket")
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
