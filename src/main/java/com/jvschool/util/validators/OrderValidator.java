package com.jvschool.util.validators;

import com.jvschool.dto.OrderAttribute;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;

@Log4j
@Component
public class OrderValidator implements Validator {

    private static final String REQ = "This field is required.";

    @Override
    public boolean supports(Class<?> aClass) {
        return OrderAttribute.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        OrderAttribute order = (OrderAttribute) o;

        if (order.getPayWay() == null) {
            try {
                errors.rejectValue("payWay", "Required.orderForm.payWay", REQ);
            } catch (Exception e) {
                log.error(e.toString());
            }
        }

        if (order.getDeliveryWay() == null) {
            errors.rejectValue("deliveryWay", "Required.orderForm.deliveryWay", REQ);
        }

        if (order.getAddressId() == null) {
            errors.rejectValue("addressId", "Required.orderForm.addressId", REQ);
        }

    }
}
