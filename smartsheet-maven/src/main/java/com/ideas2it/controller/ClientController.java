/**
 * Getting client details
 * @author manoj
 * created on 10/07/2017
 */
package com.ideas2it.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.ideas2it.model.Address;
import com.ideas2it.model.Client;
import com.ideas2it.model.Project;
import com.ideas2it.service.impl.AddressServiceImpl;
import com.ideas2it.service.impl.ClientServiceImpl;
import com.ideas2it.service.impl.ProjectServiceImpl;
import com.ideas2it.service.AddressService;
import com.ideas2it.service.ClientService;
import com.ideas2it.service.ProjectService;

/**
 * Calling the client service methods using the controller from the view
 * and returning values returned from the service to the view
 * created on 10/07/2017
 */
@Controller
@RequestMapping("/ClientController")
public class ClientController extends HttpServlet {
    private ClientService clientService; 
    
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }                                                     
   
    /**
     * <p>
     * Adding the client details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=createClient", 
                                        method=RequestMethod.GET)
    private ModelAndView createClient(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("AddClient");
        return modelAndView;  
    }
    
    /**
     * <p>
     * Adding the project details using the controller from the view and
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
        ModelAndView modelAndView = new ModelAndView("AddProjectFromClient");
        try {
            modelAndView.addObject("clientId",request.getParameter("clientId"));
        } catch (AppException e) {
            
        }
        return modelAndView;  
    }
    
    /**
     * <p>
     * Deleting the project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=deleteProject", 
                                        method=RequestMethod.GET)
    private ModelAndView deleteProject(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("DeleteProjectFromClient");
        try {
            Client client = clientService.searchClientById(
                                              request.getParameter("clientId"));
            modelAndView.addObject("client", client);
        } catch (AppException e) {
            
        }
        return modelAndView;  
    }
    
    /**
     * <p>
     * View the project details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=viewProject", 
                                        method=RequestMethod.GET)
    private ModelAndView viewProject(HttpServletRequest request, 
                                HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("ViewProjectFromClient");
        try {
            Client client = clientService.searchClientById(
                                              request.getParameter("clientId"));
            modelAndView.addObject("client", client);
        } catch (AppException exception) {
        }
        return modelAndView;  
    }
    
    /**
     * <p>
     * Deleting the client details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=DeleteClient", 
                                        method=RequestMethod.GET)
    private ModelAndView DeleteClient(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("ViewClient");
        try {    
            clientService.deleteClientById(request.getParameter("clientId"));
            modelAndView.addObject("clients",
                                     clientService.getAllClients());
            modelAndView.addObject("errorMessage", "Successfully deleted");
        } catch (AppException exception) {
            
        }
        return modelAndView; 
    }
    
    /**
     * <p>
     * View the client details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=ViewClient", method=RequestMethod.GET)
    private ModelAndView ViewClient(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException { 
        ModelAndView modelAndView = new ModelAndView("ViewClient");   
        try {
            modelAndView.addObject("clients", clientService.getAllClients());
        } catch (AppException exception) {
            
        }
        return modelAndView; 
    }
    
    /**
     * <p>
     * View the client details using the controller from the view and
     * returning values returned from the service class to the view 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=ViewClientAllDetail", 
                                        method=RequestMethod.GET) 
    private ModelAndView ViewClientAllDetail(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException {     
        ModelAndView modelAndView = new ModelAndView("ShowClientDetail"); 
        try {
            Client client = clientService.searchClientById(
                                              request.getParameter("clientId"));
            modelAndView.addObject("client", client);
        } catch (AppException exception) {
            
        }
        return modelAndView; 
    }
    
    /**
     * <p>
     * Updating details of client
     * Putting the details to an client object
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=UpdateClient", 
                                        method=RequestMethod.GET) 
    private ModelAndView UpdateClient(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException {      
        ModelAndView modelAndView = new ModelAndView("UpdateClient"); 
        try {
            Client client = clientService.searchClientById
                                            (request.getParameter("clientId"));
            modelAndView.addObject("client", client);             
        } catch (AppException exception) {
            
        }
        return modelAndView; 
    }
    
    /**
     * <p>
     * Getting details of client
     * Putting the details to an client object
     * client object contains the following attributes
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */ 
    @RequestMapping(params = "action=addClient", 
                                        method=RequestMethod.POST) 
    private ModelAndView addClient(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException {
        ModelAndView modelAndView = null; 
        try {
            List<Address> addresses = new ArrayList<Address>();
            String userType = "client";
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
            if (!clientService.addClient(request.getParameter("id"), 
                                        request.getParameter("emailId"), 
                                        request.getParameter("name"), 
                                        request.getParameter("designation"), 
                                        addresses)) {
                modelAndView = new ModelAndView("AddClient");
                modelAndView.addObject("errorMessage", 
                                    "Client Id already exists"); 
            }  
            modelAndView = new ModelAndView("ViewClient");   
            modelAndView.addObject("errorMessage", "Successfully inserted");
            modelAndView.addObject("clients",
                                     clientService.getAllClients());
        } catch (AppException e) {
           request.setAttribute("errorMessage", "Mail Id already exists"); 
           RequestDispatcher rd = request.getRequestDispatcher
                       ("/views/jsp/AddClient.jsp");
           rd.forward(request, response);
        } 
        return modelAndView;
    }         
    
     /**
     * <p>
     * Updating details of client
     * Putting the details to an client object
     * client object contains the following attributes
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=update", 
                                        method=RequestMethod.POST) 
    private ModelAndView update(HttpServletRequest request, 
                                HttpServletResponse response)
                                throws ServletException, IOException { 
        ModelAndView modelAndView = null;             
        try {
            List<Address> addresses = new ArrayList<Address>();
            String userType = "client";
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
             clientService.updateClientById(request.getParameter("id"), 
                                    request.getParameter("emailId"), 
                                    request.getParameter("name"), 
                                    request.getParameter("designation"), 
                                    addresses); 
            modelAndView = new ModelAndView("ViewClient");      
            modelAndView.addObject("errorMessage", "Successfully updated");
            modelAndView.addObject("clients",
                                         clientService.getAllClients()); 
        } catch (AppException e) {
            modelAndView = new ModelAndView("UpdateClient");
            Client client = clientService.searchClientById
                                            (request.getParameter("clientId"));
            modelAndView.addObject("client", client);            
            modelAndView.addObject("errorMessage", "Mail Id already exists"); 
        }  
        return modelAndView;    
    }
    
     /**
     * <p>
     * View details of client
     * Putting the details to an client object
     * client object contains the following attributes
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
        ModelAndView modelAndView = new ModelAndView("ViewClient"); ; 
        try {
            modelAndView.addObject("clients",
                                         clientService.getAllClients()); 
        } catch (AppException e) {
            
        }
        return modelAndView;
    } 
      
    public String getServletInfo() {
        return "Short description";
    }
}                                             
