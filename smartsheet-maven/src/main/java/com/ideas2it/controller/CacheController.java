package com.ideas2it.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CacheController implements Filter {
    private FilterConfig filterConfig = null;
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
 
    /* 
     * <p>
     * Filters all requestv and responses
     * The reference to the response object is of type ServletResponse,
     * so we need to cast it to HttpServletResponse:
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    public void doFilter(ServletRequest req, ServletResponse res, 
                            FilterChain chain) throws IOException, 
                            ServletException { 
        HttpServletRequest request = (HttpServletRequest) req; 
        HttpServletResponse response = (HttpServletResponse) res; 
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("Login.jsp"); 
        } else { 
            response.setHeader("Cache-Control", 
                                    "no-cache, no-store, must-revalidate"); 
            response.setHeader("Pragma", "no-cache"); 
            response.setDateHeader("Expires", 0); 
            chain.doFilter(req, res); 
        } 
    }

    public void destroy() {}

}
