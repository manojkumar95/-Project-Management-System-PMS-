package com.ideas2it.controller;
 
import java.io.IOException;
import java.io.PrintWriter;
 
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.exception.AppException;

@Controller
@RequestMapping("/LogoutController")
public class LogoutController extends HttpServlet {
 
    /**
     * This methos will make the user to logout from application
     * @param request
                          Request will be given by user
     * @param response
                          Response will be given back to user as result
     */
     
    @RequestMapping(params = "action=logout", 
                                        method=RequestMethod.GET)
    protected void logout(HttpServletRequest request,
                                         HttpServletResponse response)
                                         throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(false);
	        session.removeAttribute("username");
	        session.removeAttribute("password");
	        session.getMaxInactiveInterval();             
            session.invalidate();
            response.sendRedirect("Login.jsp");
        } catch (AppException e) {
            response.sendRedirect("/views/jsp/Error.jsp");
        }
    }
}
