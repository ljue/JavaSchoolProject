package com.jvschool.util;

import com.jvschool.util.Attributes.OrderAttribute;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class OrderValidator  implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return OrderAttribute.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        OrderAttribute order = (OrderAttribute) o;
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "payWay", "Required", "This field is required.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "deliveryWay", "Required", "This field is required.");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "addressId", "Required", "This field is required.");

        if ( order.getPayWay() == null) {
            try {
                errors.rejectValue("payWay", "Required", "This field is required.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if ( order.getDeliveryWay() == null) {
            errors.rejectValue("deliveryWay", "Required", "This field is required.");
        }

        if ( order.getAddressId() == null) {
            errors.rejectValue("addressId", "Required", "This field is required.");
        }

    }
}
