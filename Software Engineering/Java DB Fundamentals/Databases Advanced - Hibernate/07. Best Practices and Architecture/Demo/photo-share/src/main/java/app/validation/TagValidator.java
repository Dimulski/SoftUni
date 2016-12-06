package app.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagValidator implements ConstraintValidator<Tag, String> {
    @Override
    public void initialize(Tag tag) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String regex = "#[a-zA-Z0-9]{2,20}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (!matcher.matches()) {
            return false;
        }
        return true;
    }
}
