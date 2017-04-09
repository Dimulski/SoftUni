package softuni.interceptors;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IpInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String ipAddress = httpServletRequest.getRemoteAddr();
        httpServletRequest.setAttribute("ipAddress", ipAddress);
        String dnt = httpServletRequest.getHeader("DNT");
        if(dnt != null){
            httpServletResponse.sendRedirect("/error");
        }

        return true;
    }
}
