package io.github.javageeks.mase.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionHandlerInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionData sessionData;

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        // Register functionality is authorized for anonymous user
    	if (request.getMethod().equals(HttpMethod.POST.toString()) && request.getRequestURI().indexOf("/account") > 0) {
        	return true;
        }
    	
    	if (sessionData.getUser() == null) {
        	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
            return false;
        } else {
            return true;
        }
    }
}