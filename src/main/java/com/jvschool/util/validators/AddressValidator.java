package com.jvschool.util.validators;

import com.jvschool.model.AddressEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class AddressValidator implements Validator {

    private static final String REQ = "Required";
    private static final String REQ_STR = "This field is required.";

    @Override
    public boolean supports(Class<?> aClass) {
        return AddressEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", REQ, REQ_STR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "region", REQ, REQ_STR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", REQ, REQ_STR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "streetAddress", REQ, REQ_STR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "postIndex", REQ, REQ_STR);


    }
}
