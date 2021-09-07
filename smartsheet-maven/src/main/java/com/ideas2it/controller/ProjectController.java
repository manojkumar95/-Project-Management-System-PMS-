package com.ideas2it.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ideas2it.common.Constant;
import com.ideas2it.exception.AppException;
import com.ideas2it.logger.LoggerManager;
import com.ideas2it.model.Client;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Project;
import com.ideas2it.service.ClientService;
import com.ideas2it.service.impl.ClientServiceImpl;
import com.ideas2it.service.ProjectService;
import com.ideas2it.service.impl.ProjectServiceImpl;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.service.impl.EmployeeServiceImpl;

/**
 * Service which provides the functionalities to do basic operations
 * @author raviprasad
 * Created on 20/07/2017
 */
@Controller
@RequestMapping("/ProjectController")
public class ProjectController extends HttpServlet {
    private ProjectService projectService;
    private ClientService clientService;
    private EmployeeService employeeService;
    
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
    
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }
    
    /**
     * <p>
     * Add the project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */ 
    @RequestMapping(params = "action=addProject", 
                                        method=RequestMethod.GET)
    private ModelAndView addProject(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException { 
        ModelAndView modelAndView = new ModelAndView("AddProject");     
        try {
            modelAndView.addObject("clients", clientService.getAllClients());
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Unassign Employees from project using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=UnassignEmployees", 
                                        method=RequestMethod.GET)
    private ModelAndView UnassignEmployees(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {      
        ModelAndView modelAndView = new ModelAndView("UnassignEmployees");    
        try {
            modelAndView.addObject("projectId", 
                        request.getParameter("projectId"));
            Project project = projectService.searchProjectById(
                               request.getParameter("projectId"));
            modelAndView.addObject("project", project);
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>            Client client = clientService.searchClientById(clientId);
     * View Employees in project using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=ViewEmployeesInTheProject", 
                                        method=RequestMethod.GET)
    private ModelAndView ViewEmployeesInTheProject(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {      
        ModelAndView modelAndView = new ModelAndView("ViewEmployeesInAProject");
        try {
            modelAndView.addObject("projectId",
                                     request.getParameter("projectId"));
            Project project = projectService.searchProjectById(
                               request.getParameter("projectId"));
            modelAndView.addObject("project", project);
        } catch (AppException e) {
                
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Update project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=UpdateProject", 
                                        method=RequestMethod.GET)
    private ModelAndView UpdateProject(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {       
        ModelAndView modelAndView = new ModelAndView("UpdateProject");
        try {
            Project project = projectService.searchProjectById(
                                            request.getParameter("projectId"));
            modelAndView.addObject("project", project);
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * View project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=ViewProject", 
                                        method=RequestMethod.GET)
    private ModelAndView ViewProject(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("ViewProject");
        try {
            modelAndView.addObject("projects", projectService.getAllProjects());
        } catch (AppException e) {
            
        }
        return modelAndView; 
    }
    
    /**
     * <p>
     * Delete project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */ 
    @RequestMapping(params = "action=DeleteProject", 
                                        method=RequestMethod.GET)  
    private ModelAndView DeleteProject(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("ViewProject");
        try {
            projectService.deleteProjectById(request.getParameter("projectId"));
            modelAndView.addObject("errorMessage", "Successfully deleted");
            modelAndView.addObject("projects", projectService.getAllProjects());
        } catch (AppException e) {
            
        }
        return modelAndView;
    } 
    
    /**
     * <p>
     * View project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=ViewProjectAllDetail", 
                                        method=RequestMethod.GET) 
    private ModelAndView ViewProjectAllDetail(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("ShowProjectDetail");
        try {
            Project project = projectService.searchProjectById(
                                            request.getParameter("projectId"));
            modelAndView.addObject("project", project);
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Assign Employees in project using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=AssignEmployees", 
                                        method=RequestMethod.GET)
    private ModelAndView AssignEmployees(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
       ModelAndView modelAndView = new ModelAndView("AssignEmployees");
       try {
            modelAndView.addObject("projectId", 
                            request.getParameter("projectId"));
            modelAndView.addObject("employees", 
                        projectService.getEmployeesNotAssignedToProjects());
        } catch (AppException e) {
            
        }
        return modelAndView;
    }      
    
    /**
     * <p>
     * Add project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=addProjectDetail", 
                                        method=RequestMethod.POST)
    private ModelAndView addProjectDetail(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {     
        ModelAndView modelAndView = null;
        try {
            if (!projectService.addProject(request.getParameter("projectId"), 
                                          request.getParameter("title"),
                                          request.getParameter("startDate"),
                                          request.getParameter("endDate"))) {
                modelAndView = new ModelAndView("AddProject");
                modelAndView.addObject("errorMessage", "Project Id exists");
            }
            projectService.addClientToProject(
                                   request.getParameter("projectId"),
                                   request.getParameter("clientId"));
            modelAndView = new ModelAndView("ViewProject");
            modelAndView.addObject("errorMessage", "Successfully Inserted");
            modelAndView.addObject("projects",
                                         projectService.getAllProjects());
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Add project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=addProjectfromClient", 
                                        method=RequestMethod.POST)
    private ModelAndView addProjectfromClient(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {     
        ModelAndView modelAndView = null;
        try {
            if (!projectService.addProject(request.getParameter("projectId"), 
                                          request.getParameter("title"),
                                          request.getParameter("startDate"),
                                          request.getParameter("endDate"))) {
                modelAndView = new ModelAndView("AddProject");
                modelAndView.addObject("errorMessage", "Project Id exists");
            }                
            projectService.addClientToProject(request.getParameter("projectId"),
                             request.getParameter("clientId"));
            modelAndView = new ModelAndView("ViewProject");
            modelAndView.addObject("errorMessage", "Successfully Inserted");
            modelAndView.addObject("projects",
                                         projectService.getAllProjects());
        } catch (AppException e) {
            
        }
        return modelAndView;
    }         
    
    /**
     * <p>
     * Update project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=Update", 
                                        method=RequestMethod.POST)
    private ModelAndView Update(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {        
       ModelAndView modelAndView = new ModelAndView("ViewProject");
       try {
            projectService.updateProjectById(request.getParameter("projectId"), 
                                          request.getParameter("title"),
                                          request.getParameter("startDate"),
                                          request.getParameter("endDate"));
            modelAndView.addObject("errorMessage", "Successfully updated");
            modelAndView.addObject("projects",
                                         projectService.getAllProjects());
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * View project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=view", 
                                        method=RequestMethod.POST)
    private ModelAndView view(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {  
        ModelAndView modelAndView = new ModelAndView("ViewProject");
        try {
            modelAndView.addObject("projects",
                                             projectService.getAllProjects());
        } catch (AppException e) {
            
        }
        return modelAndView; 
    }      
    
    /**
     * <p>
     * Assign project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=assign", 
                                        method=RequestMethod.POST) 
    private ModelAndView assign(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {      
       ModelAndView modelAndView = null;    
       try {
            String[] employeeValues = request.getParameterValues("employeeId");
            if (null == employeeValues) {
                modelAndView = new ModelAndView("AssignEmployees");
                modelAndView.addObject("errorMessage",
                                     "No checkboxes selected");
            }
            for(int iterator = 0 ; iterator < employeeValues.length ; 
                                                                 iterator++) {
               projectService.addEmployeeToProject(
                              request.getParameter("projectId"), 
                              employeeValues[iterator]);
            }
            modelAndView = new ModelAndView("ViewProject");
            modelAndView.addObject("errorMessage",
                                     "Successfully assigned employees");
            modelAndView.addObject("projects",
                                         projectService.getAllProjects());
        } catch(AppException e) {
            modelAndView = new ModelAndView("ViewProject");
            modelAndView.addObject("errorMessage",
                                     "Successfully assigned employees");
            modelAndView.addObject("projects",
                                         projectService.getAllProjects());
        }   
        return modelAndView;    
    }    
    
    /**
     * <p>
     * Unassign project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=unAssign", 
                                        method=RequestMethod.POST) 
    private ModelAndView unAssign(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = null;      
        try {
            String[] employeeValues = request.getParameterValues("employeeId"); 
            if (null == employeeValues) {
                modelAndView = new ModelAndView("UnassignEmployees");
                modelAndView.addObject("errorMessage",
                                     "No checkboxes selected");
            }
            for (int iterator= 0 ; iterator < employeeValues.length ; 
                                                                iterator++) {
               projectService.removeEmployeeFromProject(
                              request.getParameter("projectId"), 
                              employeeValues[iterator]);
            }
            modelAndView = new ModelAndView("ViewProject");
            modelAndView.addObject("errorMessage",
                                         "Successfully Unassigned employees");
            modelAndView.addObject("projects",
                                         projectService.getAllProjects());
        } catch (AppException e) {
            
        }
        return modelAndView;  
    }
    
    /**
     * <p>
     * Delete project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=deleteProject", 
                                        method=RequestMethod.POST) 
    private ModelAndView deleteProject(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {      
        ModelAndView modelAndView = new ModelAndView("ViewProject");
        try {
            String[] projectValues = request.getParameterValues("projectId"); 
            for (int iterator= 0 ; iterator < projectValues.length ;
                                                                iterator++) {
               projectService.deleteProjectById(projectValues[iterator]);
            }
            modelAndView.addObject("errorMessage", "Successfully deleted");
            modelAndView.addObject("projects", projectService.getAllProjects());
        } catch (AppException e) {
            
        }
        return modelAndView;  
    }

    public String getServletInfo() {
        return "Short description";
    }
} 
