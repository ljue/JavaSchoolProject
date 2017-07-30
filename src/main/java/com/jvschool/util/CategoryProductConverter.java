package com.jvschool.util;

import com.jvschool.entities.ProductCategoryEntity;
import com.jvschool.svc.api.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Людмила on 23.07.2017.
 */

public class CategoryProductConverter implements Converter<String, ProductCategoryEntity> {

    @Autowired
    private ProductCategoryService productCategoryService;


    @Override
    public ProductCategoryEntity convert(String s) {

        ProductCategoryEntity productCategoryEntity=productCategoryService.getProductCategoryByName(s);

        return productCategoryEntity;

    }
}
