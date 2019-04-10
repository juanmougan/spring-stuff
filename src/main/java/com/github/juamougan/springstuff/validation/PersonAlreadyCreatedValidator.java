package com.github.juamougan.springstuff.validation;

import com.github.juamougan.springstuff.entities.Person;
import com.github.juamougan.springstuff.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonAlreadyCreatedValidator implements ConstraintValidator<PersonExistingConstraint, String> {

    @Autowired
    private PeopleService peopleService;

    @Override
    public void initialize(PersonExistingConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(String personName, ConstraintValidatorContext context) {
        return personName != null &&
                peopleService.retrieveAll().stream().map(Person::getName).noneMatch(n -> personName.equals(n));
    }
}
