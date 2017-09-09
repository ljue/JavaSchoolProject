package com.jvschool.view;

import com.jvschool.svc.api.CategoryService;
import com.jvschool.svc.api.ProductService;
import com.jvschool.svc.api.PropertyService;
import com.jvschool.dto.FilterAttribute;
import com.jvschool.dto.ProductAttribute;
import com.jvschool.dto.SessionUser;
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


    @GetMapping(value = "/catalog")
    public String goCatalog(Model model) {
        model.addAttribute("countProducts", productService.getCountProducts());
        model.addAttribute("allProducts", productService.getProductsFromTo(1, 12));
        model.addAttribute("filter", new FilterAttribute());
        model.addAttribute("allProperties", propertyService.getProperties());
        model.addAttribute("categories", categoryService.getAllProductCategoryNames());

        return "catalog";
    }

    @PostMapping(value = "/catalog/getProductsOnPageWithFilter/{page}/{count}")
    public String getProductsOnPageWithFilter(@PathVariable("page") int page,
                                              @PathVariable("count") int count,
                                              @ModelAttribute("filter") FilterAttribute filterAttribute,
                                              Model model) {
        Map<Integer, List<ProductAttribute>> map =
                productService.getProductsByFilterFromTo(page, count, filterAttribute);
        for (Map.Entry<Integer, List<ProductAttribute>> entry : map.entrySet()) {
            model.addAttribute("countProducts", entry.getKey());
            model.addAttribute("allProducts", entry.getValue());
        }
        return "catalogProducts";
    }

    @GetMapping(value = "/catalog/product/{productId}")
    public String getProductDetails(@PathVariable long productId, Model model) {
        model.addAttribute("product", productService.getProductAttributeById(productId));
        model.addAttribute("productTop", productService.getTopProductsForOneProduct(productId));
        return "product";
    }


    @PostMapping(value = "/addToCart/{idProduct}")
    public void addToCart(@PathVariable("idProduct") Long id, @ModelAttribute("user") SessionUser user, Model model) {

        if (user.getProducts() == null) {
            Map<Long, Integer> map = new TreeMap<>();
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

        Map<ProductAttribute, Integer> productsInCart = new TreeMap<>();
        double totalPrice = 0;

        for (Long productKey : user.getProducts().keySet()) {
            ProductAttribute pa = productService.getProductAttributeById(productKey);
            productsInCart.put(pa, user.getProducts().get(productKey));
            totalPrice = totalPrice + Double.parseDouble(pa.getCost()) * user.getProducts().get(productKey);
        }
        model.addAttribute("productsInCart", productsInCart);
        model.addAttribute("totalPrice", String.format(Locale.US, "%.2f", totalPrice));

        return "bucketInto";
    }

    @ResponseBody
    @PostMapping(value = "/changeCountInCart/getCurrentVal/{idProduct}")
    public int changeCountProductInCartGetCurrentVal(@PathVariable("idProduct") long id,
                                           @ModelAttribute("user") SessionUser user, Model model) {
        return user.getProducts().get(id);
    }


    @GetMapping(value = "/bucket")
    public String goBucket(@ModelAttribute("user") SessionUser user, Model model) {

        Map<ProductAttribute, Integer> productsInCart = new TreeMap<>();
        double totalPrice = 0;

        for (Long productKey : user.getProducts().keySet()) {
            ProductAttribute pa = productService.getProductAttributeById(productKey);
            productsInCart.put(pa, user.getProducts().get(productKey));
            totalPrice = totalPrice + Double.parseDouble(pa.getCost()) * user.getProducts().get(productKey);
        }
        model.addAttribute("productsInCart", productsInCart);
        model.addAttribute("totalPrice", String.format(Locale.US, "%.2f", totalPrice));

        return "bucket";
    }


}
