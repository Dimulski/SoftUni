package softuni.server.routing;

import softuni.server.handler.RequestHandlerImpl;

import java.util.Map;

/**
 * Created by s_she on 09.2.2017 г..
 */
public interface RoutingContext {
    RequestHandlerImpl getHandler();

    Map<Integer, Class> getArgumentMapping();

    ControllerActionPair getActionPair();
}
