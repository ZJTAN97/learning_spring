package com.sample.security.config;

import java.io.IOException;
import javax.servlet.*;

public class CustomSecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        System.out.println("Before request go to the next component");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("After request go to the next component");
    }
}
