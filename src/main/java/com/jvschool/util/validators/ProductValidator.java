package com.jvschool.util.validators;

import com.jvschool.model.ProductEntity;
import com.jvschool.dto.ProductAttribute;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class ProductValidator implements Validator {

    private static final String REQUIRED = "Required";
    private static final String REQ_STR = "This field is required.";

    @Override
    public boolean supports(Class<?> aClass) {
        return ProductEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ProductAttribute productAttribute = (ProductAttribute) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName", REQUIRED, REQ_STR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cost", REQUIRED, REQ_STR);

        try {
            double b = Double.parseDouble(productAttribute.getCost());
            if (b < 0) {
                errors.rejectValue("cost", "Format.productForm.cost", "Cost must be positive.");
            }
        } catch (NumberFormatException e) {
            errors.rejectValue("cost", "Format.productForm.cost", "Invalid format.");
        }
        if (productAttribute.getCount() == 0) {
            errors.rejectValue("count", REQUIRED, REQ_STR);
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "size", REQUIRED, REQ_STR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "battery", REQUIRED, REQ_STR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", REQUIRED, REQ_STR);

    }
}
