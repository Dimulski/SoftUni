package app.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
    private final String SPECIAL_SYMBOLS = "!@#$%^&*()_+<>,.?";
    private int minLength;
    private int maxLength;
    private boolean containsLowercase;
    private boolean containsUppercase;
    private boolean containsDigit;
    private boolean containsSpecialSymbol;

    @Override
    public void initialize(Password password) {
        this.minLength = password.minLength();
        this.maxLength = password.maxLength();
        this.containsLowercase = password.containsLowercase();
        this.containsUppercase = password.containsUppercase();
        this.containsDigit = password.containsDigit();
        this.containsSpecialSymbol = password.containsSpecialSymbol();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password.length() < minLength || password.length() > maxLength) {
            return false;
        }

        if (containsLowercase && !this.checkLowercase(password)) {
            return false;
        }

        if (containsUppercase && !this.checkUppercase(password)) {
            return false;
        }

        if (containsDigit && !this.checkDigit(password)) {
            return false;
        }

        if (containsSpecialSymbol && !checkSpecialSymbol(password)) {
            return false;
        }

        return true;
    }

    private boolean checkLowercase(String password) {
        for (Character ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkUppercase(String password) {
        for (Character ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkDigit(String password) {
        for (Character ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                return true;
            }
        }

        return false;
    }

    private boolean checkSpecialSymbol(String password) {

        for (Character ch : password.toCharArray()) {
            if (SPECIAL_SYMBOLS.contains(ch.toString())) {
                return true;
            }
        }

        return false;
    }
}
