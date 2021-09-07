/**
 * Getting employee details
 * @author manoj
 * created on 10/07/2017
 */
package com.ideas2it.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.ideas2it.common.Constant;
import com.ideas2it.exception.AppException;
import com.ideas2it.logger.LoggerManager;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Address;
import com.ideas2it.service.impl.EmployeeServiceImpl;
import com.ideas2it.service.EmployeeService;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Calling the employee service methods using the controller from the view
 * and returning values returned from the service to the view
 * created on 10/07/2017
 */
@Controller
@RequestMapping("/EmployeeController")
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService;  
    
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    /**
     * <p>
     * Delete the employee details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     */ 
    @RequestMapping(params = "action=deleteEmployee", 
                                        method=RequestMethod.GET)
    private ModelAndView deleteEmployee(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("ShowEmployee");
        try {
            employeeService.deleteEmployee(request.getParameter("employeeId"));
            modelAndView.addObject("errorMessage", "Successfully deleted");
            modelAndView.addObject("employees",
                                     employeeService.getAllEmployees());
        } catch (AppException e) {
            
        }
        return modelAndView;
     }
    
    /**
     * <p>
     * Delete the employee details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     */ 
    @RequestMapping(params = "action=createEmployee", 
                                        method=RequestMethod.GET)
    private ModelAndView createEmployee(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("AddEmployee");
        return modelAndView;  
    } 
    
    /**
     * <p>
     * View the employee details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=ViewEmployeeAllDetail", 
                                        method=RequestMethod.GET)
    private ModelAndView ViewEmployeeAllDetail(HttpServletRequest request,
                                           HttpServletResponse response)
                                           throws ServletException, 
                                           IOException {
        ModelAndView modelAndView = new ModelAndView("ShowEmployeeDetail");
        try {
            Employee employee = employeeService.searchEmployeeById
                                    (request.getParameter("employeeId"));
            modelAndView.addObject("employee", employee); 
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Update the employee details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */ 
    @RequestMapping(params = "action=updateEmployee", 
                                        method=RequestMethod.GET)
    private ModelAndView updateEmployee(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("UpdateEmployee");
        try {
            Employee employee = employeeService.searchEmployeeById
                                (request.getParameter("employeeId"));
            modelAndView.addObject("employee", employee);                 
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * View the employee history details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */ 
    @RequestMapping(params = "action=viewEmployeeHistory", 
                                        method=RequestMethod.GET)
    private ModelAndView viewEmployeeHistory(HttpServletRequest request,
                                           HttpServletResponse response)
                                           throws ServletException, 
                                           IOException {
        ModelAndView modelAndView = new ModelAndView("ViewEmployeeHistory");
        try {
            Employee employee = employeeService.searchEmployeeById
                                    (request.getParameter("employeeId"));
            modelAndView.addObject("employee", employee); 
        } catch (AppException e) {
            response.sendRedirect("Error.jsp");
        }
        return modelAndView;
    } 
    
    /**
     * <p>
     * Show the employee details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=showEmployee", method=RequestMethod.GET)
    private ModelAndView showEmployee(HttpServletRequest request, 
                                   HttpServletResponse response) 
                                   throws ServletException, IOException {  
        ModelAndView modelAndView = new ModelAndView("ShowEmployee");
        try {
            modelAndView.addObject("employees", 
                                    employeeService.getAllEmployees());
        } catch (AppException e) {
        } 
        return modelAndView;     
    }
    
    /**
     * <p>
     * Create the employee details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=addEmployee", method=RequestMethod.POST)
    private ModelAndView addEmployee(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException {
        ModelAndView modelAndView = null;
        try {
            List<Address> addresses = new ArrayList<Address>();
            String userType = "employee";
            Address address = new Address(request.getParameter("id"), 
                                       request.getParameter("addresstype"),
                                       userType, 
                                       request.getParameter("doornumber"), 
                                       request.getParameter("street1"), 
                                       request.getParameter("street2"),
                                       request.getParameter("landmark"),
                                       request.getParameter("city"), 
                                       request.getParameter("state"),
                                       request.getParameter("country"),
                                       request.getParameter("zipcode"));
            addresses.add(address);
            if (!employeeService.addEmployee(request.getParameter("id"), 
                                           request.getParameter("email"), 
                                           request.getParameter("ename"),
                                           request.getParameter("dob"),
                                           request.getParameter("designation"), 
                                           addresses)) {  
                modelAndView = new ModelAndView("AddEmployee");                   
                modelAndView.addObject("errorMessage", 
                            "Employee Id already exists"); 
            }      
            modelAndView = new ModelAndView("ShowEmployee");  
            modelAndView.addObject("errorMessage", "Successfully inserted");
            modelAndView.addObject("employees",
                                     employeeService.getAllEmployees());  
        } catch (AppException e) {
           modelAndView = new ModelAndView("AddEmployee"); 
           modelAndView.addObject("errorMessage", "Mail Id already exists"); 
        } 
        return modelAndView; 
    }
    
    /**
     * <p>
     * Update the employee details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */ 
    @RequestMapping(params = "action=update", method=RequestMethod.POST)        
    private ModelAndView update(HttpServletRequest request, 
                                  HttpServletResponse response) 
                                  throws ServletException, IOException {  
        ModelAndView modelAndView = null;
        try {
            List<Address> addresses = new ArrayList<Address>();
            String userType = "employee";             
            Address address = new Address(request.getParameter("enumber"), 
                                           request.getParameter("addresstype"),
                                           userType, 
                                           request.getParameter("doornumber"), 
                                           request.getParameter("street1"), 
                                           request.getParameter("street2"),
                                           request.getParameter("landmark"),
                                           request.getParameter("city"), 
                                           request.getParameter("state"),
                                           request.getParameter("country"),
                                           request.getParameter("zipcode"));
            addresses.add(address);
            employeeService.updateEmployee(request.getParameter("enumber"), 
                                           request.getParameter("email"), 
                                           request.getParameter("ename"),
                                           request.getParameter("edate"),
                                           request.getParameter("designation"), 
                                           addresses); 
            modelAndView = new ModelAndView("ShowEmployee");       
            modelAndView.addObject("errorMessage", "Successfully updated");
            modelAndView.addObject("employees",
                                     employeeService.getAllEmployees());
        } catch (AppException e) {
            modelAndView = new ModelAndView("UpdateEmployee");  
            modelAndView.addObject("errorMessage", "Mail Id already exists"); 
            Employee employee = employeeService.searchEmployeeById
                                (request.getParameter("enumber"));
            modelAndView.addObject("employee", employee);    
        } 
        return modelAndView; 
    }
 
    /**
     * <p>
     * View the employee details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=view", method=RequestMethod.POST)
    private ModelAndView view(HttpServletRequest request, 
                          HttpServletResponse response)
                          throws ServletException, IOException { 
        ModelAndView modelAndView = null;
        try {
            response.sendRedirect("/views/jsp/ViewClient.jsp");   
        } catch (AppException e) {
            
        }
        return modelAndView;
    }

    public String getServletInfo() {
        return "Short description";
    }
}
