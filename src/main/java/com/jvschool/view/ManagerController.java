package com.jvschool.view;

import com.jvschool.dto.*;
import com.jvschool.svc.api.*;
import com.jvschool.util.validators.ProductValidator;
import lombok.extern.log4j.Log4j;
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

@Log4j
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

        return "manager/adminProducts";
    }


    @PostMapping(value = "/adminProducts")
    public String addProduct(@ModelAttribute("productForm") ProductAttribute productForm,
                             BindingResult bindingResult, Model model, HttpServletRequest request) {

        productValidator.validate(productForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.getAllProductCategoryNames());
            model.addAttribute("propertiesSolo", propertyService.getSoloProperties());
            model.addAttribute("propertiesNotSolo", propertyService.getNotSoloProperties());
            return "manager/adminProducts";
        }

        List<MultipartFile> files = productForm.getImages();
        List<String> picNames = new ArrayList<>();
        if (!files.isEmpty()) {
            for (MultipartFile multipartFile : files) {

                String picName = multipartFile.getOriginalFilename();
                picNames.add(picName);

                File imageFile = new File(request.getSession().getServletContext().getRealPath("/resources/Images/"), picName);
                try {
                    multipartFile.transferTo(imageFile);
                } catch (IOException e) {
                    log.error(e.toString());
                }
            }
        }
        productForm.setPicturesPath(picNames);

        productService.addProduct(productForm);
        return "redirect:/manager/adminProducts";
    }

    @GetMapping(value = "/adminOrders")
    public String goAdminOrders(Model model, @ModelAttribute("user") SessionUser user) {

        if (!user.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/home";
        }

        List<OrderAttribute> orders = orderService.getOrdersGroupByDeliveryStatus();
        model.addAttribute("orders", orders);

        return "manager/adminOrders";
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

        return "manager/checkOrder";
    }


    @PostMapping(value = "editDeliveryStatus")
    public String editDeliveryStatus(HttpServletRequest request,
                                     @ModelAttribute("editDeliveryStatus") OrderAttribute orderEditAttribute) {

        OrderAttribute orderAttribute = (OrderAttribute) request.getSession().getAttribute("editOrder");
        orderAttribute.setDeliveryStatus(orderEditAttribute.getDeliveryStatus());
        orderService.editOrderDeliveryStatus(orderAttribute);

        return "redirect:/manager/adminOrders/" + orderAttribute.getOrderId();
    }


    @GetMapping(value = "statistics")
    public String goStatistics(Model model, @ModelAttribute("user") SessionUser user) {

        if (!user.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/home";
        }

        model.addAttribute("topClients", userService.getTopUsers());
        model.addAttribute("topProducts", productService.getTopProducts());
        model.addAttribute("weekProceed", String.format(Locale.US, "%.2f", orderService.getWeekProceed()));
        model.addAttribute("monthProceed", String.format(Locale.US, "%.2f", orderService.getMonthProceed()));

        return "manager/statistics";
    }


    /////////////////////////////// Categories //////////////////////////////////


    @GetMapping(value = "/editCategories")
    public String editCategoryGet(Model model, @ModelAttribute("user") SessionUser user) {

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

        return "manager/editCategories";
    }

    @PostMapping(value = "/editCategories/editCategoryName")
    public String editCategoryPost(@ModelAttribute("formEditCategory") CategoryAttribute categoryAttribute, Model model) {

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
        return (categoryService.getProductCategoryByName(addCategoryName) != null) ? true : false;
    }



    /////////////////////////////// Property Groups ///////////////////////////////


    @GetMapping(value = "/editPropertyGroups")
    public String editPropertyGroupsGet(Model model, @ModelAttribute("user") SessionUser user) {

        if (!user.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/home";
        }

        model.addAttribute("formEditPropertyGroup", new EditForm());
        model.addAttribute("formAddPropertyGroup", new EditForm());
        model.addAttribute("formRemovePropertyGroup", new EditForm());
        model.addAttribute("formReturnPropertyGroup", new EditForm());
        List<String> propertyGroups = propertyGroupService.getNamesAllPropertyGroups();
        model.addAttribute("propertyGroups", propertyGroups);
        model.addAttribute("propertyGroupsForRemove", propertyGroups);
        model.addAttribute("removedPropertyGroups", propertyGroupService.getRemovedPropertyGroups());

        return "manager/editPropertyGroups";
    }

    @PostMapping(value = "/editPropertyGroups/editPropertyGroup")
    public String editPropertyGroupsPost(@ModelAttribute("formEditPropertyGroup") EditForm editForm, Model model) {
        propertyGroupService.editPropertyGroup(editForm);
        return "redirect:/editPropertyGroups";
    }

    @PostMapping(value = "/editPropertyGroups/addPropertyGroup")
    public String addPropertyGroupsPost(@ModelAttribute("formAddPropertyGroup") EditForm editForm, Model model) {
        propertyGroupService.addPropertyGroup(editForm);
        return "redirect:/editPropertyGroups";
    }

    @PostMapping(value = "/editPropertyGroups/removePropertyGroup")
    public String removePropertyGroupsPost(@ModelAttribute("formRemovePropertyGroup") EditForm editForm, Model model) {
        propertyGroupService.removePropertyGroup(editForm.getRemove());
        return "redirect:/editPropertyGroups";
    }

    @PostMapping(value = "/editPropertyGroups/returnPropertyGroup")
    public String returnPropertyGroupsPost(@ModelAttribute("formReturnPropertyGroup") EditForm editForm, Model model) {
        propertyGroupService.returnPropertyGroup(editForm.getReturns());
        return "redirect:/editPropertyGroups";
    }

    @PostMapping(value = "/editPropertyGroups/checkExisting")
    @ResponseBody
    public boolean checkExistingPropertyGroup(@RequestParam String add) {
        return (propertyGroupService.getPropertyGroupByName(add) != null) ? true : false;
    }



    /////////////////////////////// Properties //////////////////////////////////

    @GetMapping(value = "/editProperties")
    public String editPropertyGet(Model model, @ModelAttribute("user") SessionUser user) {

        if (!user.getRole().equals("ROLE_MANAGER")) {
            return "redirect:/home";
        }

        model.addAttribute("formEditProperty", new EditForm());
        model.addAttribute("formAddProperty", new EditForm());
        model.addAttribute("formRemoveProperty", new EditForm());
        model.addAttribute("formReturnProperty", new EditForm());
        List<String> properties = propertyService.getAllVisibleProperties();
        model.addAttribute("properties", properties);
        model.addAttribute("propertiesForRemove", properties);
        model.addAttribute("removedProperties", propertyService.getRemovedProperties());
        model.addAttribute("propertyGroups", propertyGroupService.getNamesAllPropertyGroups());

        return "manager/editProperties";
    }

    @PostMapping(value = "/editProperties/editProperty")
    public String editPropertyPost(@ModelAttribute("formEditProperty") EditForm editForm, Model model) {
        propertyService.editProperty(editForm);
        return "redirect:/editProperties";
    }

    @PostMapping(value = "/editProperties/addProperty")
    public String addPropertyPost(@ModelAttribute("formAddProperty") EditForm editForm, Model model) {
        propertyService.addProperty(editForm);
        return "redirect:/editProperties";
    }

    @PostMapping(value = "/editProperties/removeProperty")
    public String removePropertyPost(@ModelAttribute("formRemoveProperty") EditForm editForm, Model model) {
        propertyService.removeProperty(editForm.getRemove());
        return "redirect:/editProperties";
    }

    @PostMapping(value = "/editProperties/returnProperty")
    public String returnPropertyPost(@ModelAttribute("formReturnProperty") EditForm editForm, Model model) {
        propertyService.returnProperty(editForm.getReturns());
        return "redirect:/editProperties";
    }

    @PostMapping(value = "/editProperties/checkExisting")
    @ResponseBody
    public boolean checkExistingProperty(@RequestParam String add) {
        return (propertyService.getPropertyByName(add) != null) ? true : false;
    }



}
