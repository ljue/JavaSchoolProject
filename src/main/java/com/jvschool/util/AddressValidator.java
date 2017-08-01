package com.jvschool.util;

import com.jvschool.entities.AddressEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddressValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return AddressEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "Required", "This field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "region", "Required", "This field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "Required", "This field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetAddress", "Required", "This field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postIndex", "Required", "This field is required.");


    }
}
