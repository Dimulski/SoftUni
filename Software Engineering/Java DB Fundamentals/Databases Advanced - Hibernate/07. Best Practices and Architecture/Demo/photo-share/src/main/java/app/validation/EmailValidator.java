package app.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "(?<=\\s|^)[a-z0-9A-Z]+[-._]*[a-z0-9A-Z]+@[a-z0-9A-Z]+([-][a-z0-9A-Z]+)*(\\.[a-z0-9A-Z]+([-][a-z0-9A-Z]+)*)+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
}
