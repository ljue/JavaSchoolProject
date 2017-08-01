package com.jvschool.util;

import com.jvschool.entities.ProductRadioPropertyEntity;
import com.jvschool.svc.ProductRadioPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class ProductRadioPropertyConverter implements Converter<String,ProductRadioPropertyEntity> {

    @Autowired
    private ProductRadioPropertyService productRadioPropertyService;

    @Override
    public ProductRadioPropertyEntity convert(String s) {
        return productRadioPropertyService.getProductRadioPropertyByName(s);
    }

//    @Override
//    public List<ProductRadioPropertyEntity> convert(List<String> stringList) {
//        List<ProductRadioPropertyEntity> list = new ArrayList<ProductRadioPropertyEntity>();
//        for (String s:stringList) {
//            list.add(productRadioPropertyService.getProductRadioPropertyByName(s));
//        }
//        return list;
//    }
}
