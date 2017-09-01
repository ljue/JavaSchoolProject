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

import java.util.*;

@Controller
@SessionAttributes("user")
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
//        List<ProductAttribute> productAttributes = productService.getAllProducts();
        model.addAttribute("countProducts", productService.getCountProducts());
        model.addAttribute("allProducts", productService.getProductsFromTo(1, 12));
//        model.addAttribute("allProducts", productAttributes);
        model.addAttribute("filter", new FilterAttribute());
        model.addAttribute("allProperties", propertyService.getProperties());

        //suchCategory = "All";
        model.addAttribute("categories", categoryService.getAllProductCategoryNames());

        return "catalog";
    }

//    @PostMapping(value = "/catalog/getProductsOnPage/{page}")
//    public String getProductsOnPage(@PathVariable("page") int page, Model model,
//                                    @RequestParam("countProductsOnPage") int count) {
//
//        model.addAttribute("allProducts", productService.getProductsFromTo(page, count));
//
//        return "catalogProducts";
//    }



    @PostMapping(value = "/catalog/getProductsOnPageWithFilter/{page}/{count}")
    public String getProductsOnPageWithFilter(@PathVariable("page") int page,
                                              @PathVariable("count") int count,
                                              @ModelAttribute("filter") FilterAttribute filterAttribute,
                                              Model model) {
        Map<Integer, List<ProductAttribute>> map =
                productService.getProductsByFilterFromTo(page, count, filterAttribute);
        for(int i : map.keySet()) {
            model.addAttribute("countProducts", i);
            model.addAttribute("allProducts", map.get(i));
        }
        return "catalogProducts";
    }


//    @GetMapping(value = "/catalog/{category}")
//    public String getProductsByCategory(@PathVariable("category") String category, Model model) {
//        List<ProductAttribute> productAttributes = new ArrayList<>();
//        if (category.equals("All")) {
//            productAttributes = productService.getAllProducts();
//            model.addAttribute("allProducts", productAttributes);
//        } else {
//            productAttributes = productService.getProductsByCategory(category);
//            model.addAttribute("allProducts", productAttributes);
//        }
//        suchCategory = category;
//
//        //model.addAttribute("countProducts", productAttributes.size());
//        model.addAttribute("filter", new FilterAttribute());
//        model.addAttribute("categories", categoryService.getAllProductCategoryNames());
//        model.addAttribute("allProperties", propertyService.getProperties());
//
//
//        return "catalog";
//    }

//    @PostMapping(value = "/catalog/doFilter")
//    public String doFilterProducts(Model model, @ModelAttribute("filter") FilterAttribute filterAttribute) {
//
//
//        filterAttribute.setCategory(suchCategory);
//        List<ProductAttribute> productAttributes = productService.getProductsWithFilter(filterAttribute);
//        //model.addAttribute("countProducts", productAttributes.size());
//
//
//        model.addAttribute("countProducts", productAttributes.size());
//
//        model.addAttribute("allProducts", productAttributes);
//        model.addAttribute("categories", categoryService.getAllProductCategoryNames());
//        model.addAttribute("allProperties", propertyService.getProperties());
//        model.addAttribute("filter", filterAttribute);
//
//        return "catalog";
//    }


    @PostMapping(value = "/addToCart/{idProduct}")
    public void addToCart(@PathVariable("idProduct") Long id, @ModelAttribute("user") SessionUser user, Model model) {

        if (user.getProducts() == null) {
            Map<Long, Integer> map = new HashMap<>();
            map.put(id, 1);
            user.setProducts(map);
        } else {
            Integer val = user.getProducts().get(id);
            if (val == null) {
                user.getProducts().put(id, 1);
            } else {
                val++;
                user.getProducts().put(id, val);
            }
        }
        model.addAttribute("user", user);
    }

    @PostMapping(value = "/minusFromCart/{idProduct}")
    public void minusFromCart(@PathVariable("idProduct") Long id, @ModelAttribute("user") SessionUser user, Model model) {

        Integer val = user.getProducts().get(id);
        if (val == null) {
            return;
        } else {
            val--;
            if (val == 0) {
                user.getProducts().remove(id);
            } else {
                user.getProducts().put(id, val);
            }
        }
        model.addAttribute("user", user);
    }

    @PostMapping(value = "/changeCountInCart/{idProduct}")
    public String changeCountProductInCart(@PathVariable("idProduct") long id, @RequestParam("count") int count,
                                           @ModelAttribute("user") SessionUser user, Model model) {
        if(count>0) {
            user.getProducts().put(id, count);
        } else {
            user.getProducts().remove(id);
        }
        model.addAttribute("user", user);

        Map<ProductAttribute, Integer> productsInCart = new HashMap<>();
        double totalPrice = 0;

        for (Long productKey : user.getProducts().keySet()) {
            ProductAttribute pa = productService.getProductAttributeById(productKey);
            productsInCart.put(pa, user.getProducts().get(productKey));
            totalPrice = totalPrice + pa.getCost() * user.getProducts().get(productKey);
        }
        model.addAttribute("productsInCart", productsInCart);
        model.addAttribute("totalPrice", String.format(Locale.US, "%.2f", totalPrice));

        return "bucketInto";
    }


    @GetMapping(value = "/bucket")
    public String goBucket(@ModelAttribute("user") SessionUser user, Model model) {

        Map<ProductAttribute, Integer> productsInCart = new HashMap<>();
        double totalPrice = 0;

        for (Long productKey : user.getProducts().keySet()) {
            ProductAttribute pa = productService.getProductAttributeById(productKey);
            productsInCart.put(pa, user.getProducts().get(productKey));
            totalPrice = totalPrice + pa.getCost() * user.getProducts().get(productKey);
        }
        model.addAttribute("productsInCart", productsInCart);
        model.addAttribute("totalPrice", String.format(Locale.US, "%.2f", totalPrice));

        return "bucket";
    }


}
