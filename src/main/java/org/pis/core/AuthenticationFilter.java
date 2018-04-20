package org.pis.core;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    @Inject
    AuthenticationBean auth;

    @SuppressWarnings("unused")
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    if (!(servletRequest instanceof HttpServletRequest) || !(servletResponse instanceof HttpServletResponse)) {
        return;
    }
        String contextPath = ((HttpServletRequest) servletRequest).getContextPath();
        String servletPath = ((HttpServletRequest) servletRequest).getServletPath();

        filterChain.doFilter(servletRequest, servletResponse);

//
//        if (servletPath.startsWith("/login.") || servletPath.endsWith(".css.xhtml")|| servletPath.endsWith(".js.xhtml") )
//        {
//            filterChain.doFilter(servletRequest, servletResponse);
//            return;
//        }
//        if (auth != null && auth.isAuthorized())
//        {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//        else
//        {
//            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
//            httpResponse.sendRedirect(contextPath + "/login.xhtml");
//        }
    }

    @Override
    public void destroy() {

    }
}
