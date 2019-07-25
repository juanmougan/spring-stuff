package com.github.juamougan.springstuff.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PersonAlreadyCreatedValidator.class)
@Target( {ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonExistingConstraint {
    String message() default "Person already created";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
