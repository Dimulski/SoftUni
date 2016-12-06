package app.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {
    private final int MIN_AGE = 0;
    private final int MAX_AGE = 150;

    @Override
    public void initialize(Age password) {

    }

    @Override
    public boolean isValid(Integer s, ConstraintValidatorContext constraintValidatorContext) {
        if (s < MIN_AGE || s > MAX_AGE) {
            return false;
        }

        return true;
    }
}
