package softuni.server.routing;

import softuni.server.handler.RequestHandlerImpl;

import java.util.Map;

/**
 * Created by s_she on 09.2.2017 г..
 */
public class RoutingContextImpl implements RoutingContext {
    private RequestHandlerImpl handler;
    private Map<Integer, Class> argumentMapping;
    private ControllerActionPair actionPair;

    public RoutingContextImpl(RequestHandlerImpl handler, Map<Integer,
            Class> argumentMapping, ControllerActionPair actionPair) {
        this.handler = handler;
        this.argumentMapping = argumentMapping;
        this.actionPair = actionPair;
    }

    @Override
    public RequestHandlerImpl getHandler() {
        return this.handler;
    }

    @Override
    public Map<Integer, Class> getArgumentMapping() {
        return this.argumentMapping;
    }

    @Override
    public ControllerActionPair getActionPair() {
        return this.actionPair;
    }
}
