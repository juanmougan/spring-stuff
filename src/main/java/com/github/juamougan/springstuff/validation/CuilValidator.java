package com.github.juamougan.springstuff.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class CuilValidator implements ConstraintValidator<CuilConstraint, String> {
    @Override
    public void initialize(CuilConstraint cuilConstraint) {

    }

    @Override
    public boolean isValid(String cuilField,
                           ConstraintValidatorContext cxt) {
        // Adapted from https://www.regextester.com/102575
        String cuilRegex = "\\b(20|23|24|27|30|33|34)(\\D)?[0-9]{8}(\\D)?[0-9]";
        return cuilField != null && Pattern.matches(cuilRegex, cuilField);
    }
}
