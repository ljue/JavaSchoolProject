package com.jvschool.util;

import com.jvschool.entities.ProductCategoryEntity;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Людмила on 23.07.2017.
 */
public class CategoryProductConvector implements Converter<String, ProductCategoryEntity> {



    @Override
    public ProductCategoryEntity convert(String s) {
        return null;
    }
}
