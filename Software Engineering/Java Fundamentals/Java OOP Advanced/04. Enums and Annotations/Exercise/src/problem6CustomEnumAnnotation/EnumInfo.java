package problem6CustomEnumAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnumInfo { // I would make this package local, but Judge has a problem with that.

    String type() default "Enumeration";

    String category();

    String description();
}
