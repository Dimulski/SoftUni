package softuni.server.parser;

import java.util.Map;

public interface AnnotationParser<RequestMethod, RouteInfo> {

    void parse(Map<RequestMethod, RouteInfo> routes) throws IllegalAccessException, InstantiationException;
}
