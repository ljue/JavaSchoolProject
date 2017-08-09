package com.jvschool.util;

import com.jvschool.entities.ProductEntity;
import com.jvschool.util.Attributes.ProductAttribute;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class ProductValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return ProductEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ProductAttribute productAttribute = (ProductAttribute) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", "Required", "This field is required.");

        if (productAttribute.getCost()==0) {
            errors.rejectValue("cost", "Required", "This field is required.");
        }
        if (productAttribute.getCount()==0) {
            errors.rejectValue("count", "Required", "This field is required.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", "Required", "This field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "battery", "Required", "This field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Required", "This field is required.");

//        if (productEntity.getImages().isEmpty()) {
//            errors.rejectValue("images", "Required", "This field is required.");
//        }

    }
}
