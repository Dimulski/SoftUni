package exercises.annoitationValidations;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TagValidator.class)
public @interface TagName {

    int size();

    String message() default "Invalid Tag";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
