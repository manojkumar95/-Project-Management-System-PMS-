package com.ideas2it.controller;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.exception.AppException;
 
@Controller
@RequestMapping("/LoginController")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
 
    /**
     * This methos will check whether the username and password is matching or not
     * @param request
                          Request will be given by user
     * @param response
                          Response will be given back to user as result
     */    
    @RequestMapping(params = "action=Login", 
                                        method=RequestMethod.POST)
    protected void Login(HttpServletRequest request,
                                         HttpServletResponse response)
                                         throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("manoj") && password.equals("1234")) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                session.setAttribute("password", password);
                RequestDispatcher rd = request.
                                        getRequestDispatcher
                                        ("WEB-INF/views/jsp/Dashboard.jsp");
                rd.include(request, response);
            } else {
                request.setAttribute("errorMessage", 
                            "Username or password is incorrect");
                RequestDispatcher rd = request.
                                        getRequestDispatcher("Login.jsp");
                rd.include(request, response);
            }
        } catch (AppException e) {
            response.sendRedirect("/views/jsp/Error.jsp");
        }
    }
    
    /**
     * This methos will check wheather the username and password is matching or not
     * @param request
                          Request will be given by user
     * @param response
                          Response will be given back to user as result
     */    
    @RequestMapping(params = "action=Register", 
                                        method=RequestMethod.POST)
    protected void Register(HttpServletRequest request,
                                         HttpServletResponse response)
                                         throws ServletException, IOException {
        try {
            request.setAttribute("errorMessage", 
                                "Registration is currently not possible");
            RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
            rd.forward(request, response); 
        }  catch (AppException e) {
            response.sendRedirect("/views/jsp/Error.jsp");
        }
    }
    
    @RequestMapping(params = "action=dashboard", 
                                        method=RequestMethod.GET)
    private ModelAndView dashboard(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("Dashboard");
        return modelAndView;  
    }
}

