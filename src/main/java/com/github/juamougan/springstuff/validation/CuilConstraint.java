package com.github.juamougan.springstuff.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CuilValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface CuilConstraint {
    String message() default "Invalid CUIL";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
