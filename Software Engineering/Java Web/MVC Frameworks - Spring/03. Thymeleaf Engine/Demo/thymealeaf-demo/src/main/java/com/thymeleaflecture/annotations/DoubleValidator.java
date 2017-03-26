package com.thymeleaflecture.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class DoubleValidator implements ConstraintValidator<ValidDouble, Double> {

    @Override
    public void initialize(ValidDouble validDouble) {
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {

        return true;
    }
}
