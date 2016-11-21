package exercises.annoitationValidations;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class TagValidator implements ConstraintValidator<TagName, String> {

    private int size;

    @Override
    public void initialize(TagName tagName) {
        size = tagName.size();
    }

    @Override
    public boolean isValid(String tag, ConstraintValidatorContext constraintValidatorContext) {

        if(!tag.startsWith("#")){
            return false;
        }

        if(this.size > 20){
            return false;
        }

        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(tag);
        if(matcher.find()){
            return false;
        }

        return true;
    }
}
