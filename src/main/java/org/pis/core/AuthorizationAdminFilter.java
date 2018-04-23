package org.pis.core;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationAdminFilter implements Filter {
    @Inject
    private AuthorizationBean authorizationBean;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(authorizationBean.isUserInRole("admin")){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            String contextPath = ((HttpServletRequest) servletRequest).getContextPath();

            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.sendRedirect(contextPath + "/403.xhtml");
        }
    }

    @Override
    public void destroy() {

    }
}
