package com.jvschool.util;

import com.jvschool.entities.UserEntity;
import com.jvschool.svc.UserService;
import com.jvschool.util.Attributes.SessionUser;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;



@Component
public class UserValidator implements Validator {

//    @Autowired
//    private UserService userService;


    @Override
    public boolean supports(Class<?> aClass) {
        return SessionUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        SessionUser user = (SessionUser) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required", "This field is required.");
        if (user.getLogin().length() < 4 || user.getLogin().length() > 30) {
            errors.rejectValue("login", "Size.userForm.login", "Username must be between 4 and 30 characters.");
        }

//        if (userService.getUserByLogin(user.getLogin()) != null) {
//            errors.rejectValue("login", "Duplicate.userForm.login", "Such username already exists.");
//        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "Required", "This field is required.");
        if ( user.getPass()!=null &&
                (user.getPass().length() < 4 || user.getPass().length() > 30)) {
            errors.rejectValue("pass", "Size.userForm.pass", "Password must be between 4 and 30 characters.");
        }

        if (  user.getPass()!=null && user.getConfirmPassword()!=null &&
                !user.getConfirmPassword().equals(user.getPass())) {
            errors.rejectValue("confirmPassword", "Different.userForm.pass", "Password don't match.");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Required", "This field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "secondName", "Required", "This field is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "Required", "This field is required.");


        boolean allowLocal = true;
        if (!EmailValidator.getInstance(allowLocal).isValid(user.getEmail())) {
            errors.rejectValue("email","Unvalidated.userForm.email", "Email is unvalidated.");
        }
//        if (userService.getUserByEmail(user.getEmail())!=null) {
//            errors.rejectValue("email","Duplicate.userForm.email", "Such email already exists.");
//        }

    }


}