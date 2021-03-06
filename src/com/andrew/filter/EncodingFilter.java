package com.andrew.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private final String ENCODING = "utf-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(ENCODING);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}
}
