package com.jvschool.util.validators;

import com.jvschool.dto.SessionUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class EditPassValidator implements Validator {

    private static final String REQUIRED = "Required";
    private static final String REQ_STR = "This field is required.";


    @Override
    public boolean supports(Class<?> aClass) {
        return SessionUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        SessionUser user = (SessionUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", REQUIRED, REQ_STR);
        if (user.getPass() != null &&
                (user.getPass().length() < 4 || user.getPass().length() > 30)) {
            errors.rejectValue("pass", "Size.userForm.pass", "Password must be between 4 and 30 characters.");
        }

        if (user.getPass() != null && user.getConfirmPassword() != null &&
                !user.getConfirmPassword().equals(user.getPass())) {
            errors.rejectValue("confirmPassword", "Different.userForm.pass", "Password don't match.");
        }
    }
}
