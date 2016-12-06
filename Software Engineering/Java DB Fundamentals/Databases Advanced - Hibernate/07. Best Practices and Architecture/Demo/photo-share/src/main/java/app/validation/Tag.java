package app.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = TagValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Tag {

    String message() default "Invalid tag";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
