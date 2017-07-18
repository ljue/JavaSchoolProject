package com.jvschool.util;

import com.jvschool.entities.UserEntity;
import com.jvschool.svc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.sql.SQLException;

/**
 * Created by Людмила on 18.07.2017.
 */
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserEntity.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        UserEntity user = (UserEntity) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        if (user.getLogin().length() < 8 || user.getLogin().length() > 32) {
            errors.rejectValue("login", "Size.userForm.username");
        }


            if (userService.getUserByLogin(user.getLogin()) != null) {
                errors.rejectValue("login", "Duplicate.userForm.username");
            }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "Required");
        if (user.getPass().length() < 8 || user.getPass().length() > 32) {
            errors.rejectValue("pass", "Size.userForm.password");
        }

        if (!user.getConfirmPassword().equals(user.getPass())) {
            errors.rejectValue("confirmPassword", "Different.userForm.password");
        }

    }


}
