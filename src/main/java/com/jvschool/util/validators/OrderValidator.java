package com.jvschool.util.validators;

import com.jvschool.dto.OrderAttribute;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

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

        if ( order.getPayWay() == null) {
            try {
                errors.rejectValue("payWay", "Required.orderForm.payWay", "This field is required.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if ( order.getDeliveryWay() == null) {
            errors.rejectValue("deliveryWay", "Required.orderForm.deliveryWay", "This field is required.");
        }

        if ( order.getAddressId() == null) {
            errors.rejectValue("addressId", "Required.orderForm.addressId", "This field is required.");
        }

    }
}
