package com.jvschool.view;


import com.jvschool.entities.PicturesEntity;
import com.jvschool.entities.ProductEntity;

import com.jvschool.svc.*;
import com.jvschool.util.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Людмила on 22.07.2017.
 */

@Controller
public class ManagerController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private PropertyCategoryService propertyCategoryService;

    @Autowired
    private ProductPropertyService productPropertyService;

    @Autowired
    private ProductValidator productValidator;

    @Autowired
    private ProductService productService;

    @Autowired
    private PropertyRadioCategoryService propertyRadioCategoryService;

    @Autowired
    private ProductRadioPropertyService productRadioPropertyService;

    @RequestMapping(value = "/orderList", method = RequestMethod.GET)
    public String goOrderList(Model model) {
        return "orderList";
    }

    @RequestMapping(value = "/adminProducts", method = RequestMethod.GET)
    public String goAdminProducts(Model model, @ModelAttribute("productForm")ProductEntity productForm) {
        model.addAttribute("categories", productCategoryService.getAllProductCategories());
        model.addAttribute("propertiesMany", propertyCategoryService.getAllPropertyCategories());
        model.addAttribute("propertyManyChild",productPropertyService.getAllProductProperties());

        model.addAttribute("radioCategory", propertyRadioCategoryService.getAllRadioCategories());
        model.addAttribute("radioProperties", productRadioPropertyService.getAllRadioProperties());


        return "adminProducts";
    }

    @RequestMapping(value = "/adminProducts", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("productForm")ProductEntity productForm,
                           BindingResult bindingResult, Model model, HttpServletRequest request) {

        List<MultipartFile> files = productForm.getImages();
        List<String> fileNames = new ArrayList<String>();
        List<PicturesEntity> picNames=new ArrayList<>();
        if (null != files && files.size() > 0)
        {
            for (MultipartFile multipartFile : files) {

                String fileName = multipartFile.getOriginalFilename();
                fileNames.add(fileName);

                File imageFile = new File(request.getSession().getServletContext().getRealPath("/resources/Images/"), fileName);
                try
                {
                    multipartFile.transferTo(imageFile);

                    PicturesEntity pic = new PicturesEntity();
                    pic.setPicName(fileName);
                    picNames.add(pic);

                } catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        productForm.setPicturesByProductId(picNames);

        productValidator.validate(productForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "adminProducts";
        }
        productService.addProduct(productForm);
        return "redirect:/adminProducts";
    }
}
