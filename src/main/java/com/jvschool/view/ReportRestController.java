package com.jvschool.view;


import com.jvschool.svc.api.ProductService;
import com.jvschool.dto.ProductAttribute;
import com.jvschool.util.dto.ProductDTO;
import com.jvschool.util.dto.ProductsDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Log4j
@RestController
public class ReportRestController {

    @Autowired
    private ProductService productService;

    @RequestMapping( value = "/advertisement/top", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public ProductsDTO topInfo() {

        List<ProductAttribute> productAttributes = productService.getTopProducts();
        ProductsDTO productsDTO = new ProductsDTO();
        List<ProductDTO> productDTOList = new ArrayList<>();
        for(ProductAttribute productAttribute : productAttributes) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(productAttribute.getProductId());
            productDTO.setProductName(productAttribute.getProductName());
            productDTO.setCost(productAttribute.getCost());
            productDTO.setPicture(productAttribute.getPresentPic());
            productDTOList.add(productDTO);
        }
        productsDTO.setProducts(productDTOList);

        log.info(productsDTO.toString());
        return productsDTO;
    }

}
