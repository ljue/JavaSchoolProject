package com.jvschool.util.validators;

import com.jvschool.dto.SessionUser;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EditUserInfoValidator implements Validator {

    private static final String REQUIRED = "Required";
    private static final String REQ_STR = "This field is required.";


    @Override
    public boolean supports(Class<?> aClass) {
        return SessionUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        SessionUser user = (SessionUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", REQUIRED, REQ_STR);
        if (user.getLogin() != null && (user.getLogin().length() < 4 || user.getLogin().length() > 30)) {
            errors.rejectValue("login", "Size.userForm.login", "Username must be between 4 and 30 characters.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", REQUIRED, REQ_STR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", REQUIRED, REQ_STR);
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", REQUIRED, REQ_STR);


        boolean allowLocal = true;
        if (!EmailValidator.getInstance(allowLocal).isValid(user.getEmail())) {
            errors.rejectValue("email", "Unvalidated.userForm.email", "Email is unvalidated.");
        }
    }
}
