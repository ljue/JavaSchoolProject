package com.jvschool.util;

import com.jvschool.entities.ProductPropertyEntity;
import com.jvschool.svc.api.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Людмила on 23.07.2017.
 */
public class ProductCheckBoxPropertyConverter implements Converter<String, ProductPropertyEntity> {

    @Autowired
    private ProductPropertyService productPropertyService;

    @Override
    public ProductPropertyEntity convert(String s) {


        return productPropertyService.getProductPropertyByName(s);
    }

//    @Override
//    public List<ProductPropertyEntity> convert(List<String> strings) {
//        List<ProductPropertyEntity> list = new ArrayList<ProductPropertyEntity>();
//        for (String s:strings) {
//            list.add(productPropertyService.getProductPropertyByName(s));
//        }
//        return list;
//    }
}
