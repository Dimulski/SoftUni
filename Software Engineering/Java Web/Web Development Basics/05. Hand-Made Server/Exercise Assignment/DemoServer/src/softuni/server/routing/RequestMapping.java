package softuni.server.routing;

import softuni.server.http.HttpRequestMethod;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {

    String value();

    HttpRequestMethod method() default HttpRequestMethod.GET;
}
