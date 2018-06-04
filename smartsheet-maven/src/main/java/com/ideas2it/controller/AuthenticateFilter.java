package com.ideas2it.controller;
import java.io.IOException;  
import java.io.PrintWriter;  
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
  
public class AuthenticateFilter implements Filter{  
      
    public void init(final FilterConfig arg0) throws ServletException {}  
          
    public void doFilter(ServletRequest req, ServletResponse res,  
            FilterChain chain) throws IOException, ServletException {  
              
        
		HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);               
        if (null != session) {
            if (null != request.getParameter("action")) {
                response.setHeader("Cache-Control", "no-cache, no-store,"
                                                        + "must-revalidate");
                response.setHeader("Pragma", "no-cache");
                response.setDateHeader("Expires", 0);
                chain.doFilter(req, res);
            } else {
                response.sendRedirect("Login.jsp");
            }
        } else {
            response.sendRedirect("Login.jsp");
        }
    }

    public void destroy() {}  
      
}  

