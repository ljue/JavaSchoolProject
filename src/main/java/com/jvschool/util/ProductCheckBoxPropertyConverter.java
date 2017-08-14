package com.jvschool.util;

import com.jvschool.entities.PropertyEntity;
import com.jvschool.svc.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class ProductCheckBoxPropertyConverter implements Converter<String, PropertyEntity> {

    @Autowired
    private PropertyService propertyService;

    @Override
    public PropertyEntity convert(String s) {


        return propertyService.getPropertyByName(s);
    }

//    @Override
//    public List<PropertyEntity> convert(List<String> strings) {
//        List<PropertyEntity> list = new ArrayList<PropertyEntity>();
//        for (String s:strings) {
//            list.add(propertyService.getPropertyByName(s));
//        }
//        return list;
//    }
}
