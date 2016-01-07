package com.getjavajob.training.web06.khomutova.Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        if (session.getAttribute("profileType") == null) {
            request.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
        } else if (session.getAttribute("profileType").equals("user")) {
            request.getRequestDispatcher("/login").forward(servletRequest, servletResponse);
        } else if (session.getAttribute("profileType").equals("admin")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
