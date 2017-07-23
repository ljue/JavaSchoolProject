package com.jvschool.util;

import com.jvschool.entities.ProductEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Людмила on 23.07.2017.
 */
@Component
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

        ProductEntity productEntity = (ProductEntity) o;

    }
}
