package com.andrew.filter;

import com.andrew.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.andrew.util.AttributeConstant.USER;
import static com.andrew.util.JspPathConstant.LOG_IN_JSP;

public class UserFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        User user = (User) session.getAttribute(USER);

        if(user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletRequest.getRequestDispatcher(LOG_IN_JSP).forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
