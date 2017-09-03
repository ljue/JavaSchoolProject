package com.jvschool.view;

import com.jvschool.dto.*;
import com.jvschool.svc.api.*;
import com.jvschool.util.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;


@Controller
@SessionAttributes("user")
//@RequestMapping("/my-webapp")
public class ManagerController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductValidator productValidator;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private DeliveryStatusService deliveryStatusService;
    @Autowired
    private UserService userService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PropertyGroupService propertyGroupService;


    @GetMapping(value = "/adminProducts")
    public String goAdminProducts(Model model, @ModelAttribute("productForm") ProductAttribute productForm
            , @ModelAttribute("user") SessionUser user) {
        if (!user.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/home";
        }

        model.addAttribute("categories", categoryService.getAllProductCategoryNames());
        model.addAttribute("propertiesSolo", propertyService.getSoloProperties());
        model.addAttribute("propertiesNotSolo", propertyService.getNotSoloProperties());

        return "adminProducts";
    }


    @PostMapping(value = "/adminProducts")
    public String addProduct(@ModelAttribute("productForm") ProductAttribute productForm,
                             BindingResult bindingResult, Model model, HttpServletRequest request) {

        productValidator.validate(productForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllProductCategoryNames());
            model.addAttribute("propertiesSolo", propertyService.getSoloProperties());
            model.addAttribute("propertiesNotSolo", propertyService.getNotSoloProperties());
            return "adminProducts";
        }

        List<MultipartFile> files = productForm.getImages();
        List<String> picNames = new ArrayList<>();
        if (null != files && files.size() > 0) {
            for (MultipartFile multipartFile : files) {

                String picName = multipartFile.getOriginalFilename();
                picNames.add(picName);

                File imageFile = new File(request.getSession().getServletContext().getRealPath("/resources/Images/"), picName);
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        productForm.setPicturesPath(picNames);

        productService.addProduct(productForm);
        return "redirect:/adminProducts";
    }


    @GetMapping(value = "/editCategories")
    public String editCategoryGet(@ModelAttribute("formEditCategory") CategoryAttribute categoryAttribute,
                                  @ModelAttribute("formAddCategory") CategoryAttribute addCategoryAttribute,
                                  Model model, @ModelAttribute("user") SessionUser user) {

        if (!user.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/home";
        }

        model.addAttribute("formEditCategory", new CategoryAttribute());
        model.addAttribute("formAddCategory", new CategoryAttribute());
        model.addAttribute("formRemoveCategory", new CategoryAttribute());
        model.addAttribute("formReturnCategory", new CategoryAttribute());
        List<String> categoryAttributes = categoryService.getAllProductCategoryNames();
        model.addAttribute("categories", categoryAttributes);
        model.addAttribute("categoriesForRemove", categoryAttributes);
        model.addAttribute("removedCategories", categoryService.getRemovedCategories());

        return "editCategories";
    }


    @PostMapping(value = "/editCategories/editCategoryName")
    public String editCategoryPost(@ModelAttribute("formEditCategory") CategoryAttribute categoryAttribute,
                                   Model model) {

        if (categoryAttribute.getEditCategoryName() == null) {
            model.addAttribute("categories", categoryService.getAllProductCategoryNames());
            model.addAttribute("error", "This field is required.");
            return "redirect:/editCategories";
        }

        categoryService.editCategory(categoryAttribute);

        return "redirect:/editCategories";
    }


    @PostMapping(value = "/editCategories/addCategory")
    public String addCategoryPost(@ModelAttribute("formAddCategory") CategoryAttribute categoryAttribute) {
        categoryService.addProductCategory(categoryAttribute.getAddCategoryName());
        return "redirect:/editCategories";
    }

    @PostMapping(value = "/editCategories/removeCategory")
    public String removeCategory(@ModelAttribute("formRemoveCategory") CategoryAttribute categoryAttribute) {
        categoryService.removeCategory(categoryAttribute.getRemoveCategoryName());
        return "redirect:/editCategories";
    }

    @PostMapping(value = "/editCategories/returnCategory")
    public String returnCategory(@ModelAttribute("formReturnCategory") CategoryAttribute categoryAttribute) {
        categoryService.returnCategory(categoryAttribute.getReturnCategoryName());
        return "redirect:/editCategories";
    }

    @PostMapping(value = "/editCategories/checkExisting")
    @ResponseBody
    public boolean checkExistingCategory(@RequestParam String addCategoryName) {
        boolean b = (categoryService.getProductCategoryByName(addCategoryName) != null) ? true : false;
        return b;
    }



    @GetMapping(value = "/adminOrders")
    public String goAdminOrders(Model model, @ModelAttribute("user") SessionUser user) {

        if (!user.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/home";
        }

        List<OrderAttribute> orders = orderService.getOrdersGroupByDeliveryStatus();
        model.addAttribute("orders", orders);

        return "adminOrders";
    }


    @GetMapping(value = "/adminOrders/{orderId}")
    public String goCheckOrder(@PathVariable("orderId") Long orderId, Model model,
                               HttpServletRequest request, @ModelAttribute("user") SessionUser user) {

        if (!user.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/home";
        }

        OrderAttribute orderAttribute = orderService.getOrderById(orderId);
        List<BucketAttribute> bucketAttributes = orderAttribute.getBuckets();
        List<ProductAttribute> productAttributes = new ArrayList<>();
        Double total = 0d;
        if (!bucketAttributes.isEmpty()) {
            for (BucketAttribute ba : bucketAttributes) {
                ProductAttribute pa = productService.getProductAttributeById(ba.getProductId());
                if (pa != null) {
                    pa.setCost(ba.getCostProduct());
                    productAttributes.add(pa);
                    total = total + ba.getCostProduct() * ba.getCountProduct();
                }
            }
        }
        model.addAttribute("products", productAttributes);
        model.addAttribute("orderIn", orderAttribute);
        model.addAttribute("buckets", bucketAttributes);
        model.addAttribute("addressOrder", addressService.getAddressById(orderAttribute.getAddressId()));
        model.addAttribute("deliveryStatuses", deliveryStatusService.getAllDeliveryStatuses());
        model.addAttribute("total", String.format(Locale.US, "%.2f", total));
        model.addAttribute("editDeliveryStatus", new OrderAttribute());
        request.getSession().setAttribute("editOrder", orderAttribute);

        return "checkOrder";
    }


    @PostMapping(value = "editDeliveryStatus")
    public String editDeliveryStatus(HttpServletRequest request,
                                     @ModelAttribute("editDeliveryStatus") OrderAttribute orderEditAttribute) {

        OrderAttribute orderAttribute = (OrderAttribute) request.getSession().getAttribute("editOrder");
        orderAttribute.setDeliveryStatus(orderEditAttribute.getDeliveryStatus());
        orderService.editOrderDeliveryStatus(orderAttribute);

        return "redirect:/adminOrders/" + orderAttribute.getOrderId();
    }


    @GetMapping(value = "statistics")
    public String goStatistics(Model model, @ModelAttribute("user") SessionUser user) {

        if (!user.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/home";
        }

        model.addAttribute("topClients", userService.getTopUsers());
        model.addAttribute("topProducts", productService.getTopProducts());
        //model.addAttribute("weekProceed", String.format(Locale.US, "%.2f", orderService.getWeekProceed()));
        //model.addAttribute("monthProceed", String.format(Locale.US, "%.2f", orderService.getMonthProceed()));

        return "statistics";
    }
}
