package softuni.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class IsInTheFutureValidator implements ConstraintValidator<IsInTheFuture, Date> {

    public void initialize(IsInTheFuture constraint) {
    }

    public boolean isValid(Date date, ConstraintValidatorContext context) {
        Date currentDate = new Date();
        boolean isInTheFuture = date.after(currentDate);
        return isInTheFuture;
    }
}
