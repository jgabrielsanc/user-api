package com.jsanchez.user.validation;

import com.jsanchez.user.util.Constants;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class ValidPasswordValidator implements ConstraintValidator<ValidPassword, String> {

    @Value("${pass.regex}")
    private String passRegex;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null ) {
            return false;
        }

        if (passRegex == null) {
            passRegex = Constants.PASS_REGEX;
        }

        Pattern pattern = Pattern.compile(passRegex);
        return pattern.matcher(value).matches();
    }
}
