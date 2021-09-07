/**
 * Getting employee details
 * @author manoj
 * created on 10/07/2017
 */
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
import com.ideas2it.model.Employee;
import com.ideas2it.model.Address;
import com.ideas2it.model.Client;
import com.ideas2it.logger.LoggerManager;
import com.ideas2it.service.impl.AddressServiceImpl;
import com.ideas2it.service.impl.ClientServiceImpl;
import com.ideas2it.service.impl.EmployeeServiceImpl;
import com.ideas2it.service.AddressService;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.service.ClientService;
import java.io.IOException;

/**
 * Calling the employee service methods using the controller from the view
 * and returning values returned from the service to the view
 * created on 10/07/2017
 */
@Controller
@RequestMapping("/AddressController")
public class AddressController extends HttpServlet {
    private EmployeeService employeeService;                                                       
    private AddressService addressService; 
    private ClientService clientService; 
    
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    } 
    
    public void setAddressService(AddressService addressService) {
        this.addressService = addressService;
    } 
    
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }    
    
    /**
     * <p>
     * Display details of the addresses based on employeeId
     * and retrieving the row from database containing the employeeId
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=viewAddress", 
                                        method=RequestMethod.GET)
    private ModelAndView viewAddress(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("ViewAddresses"); 
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
     * Display details of the client based on clientId
     * and retrieving the row from database containing the clientId
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=viewClientAddress", 
                                        method=RequestMethod.GET)
    private ModelAndView viewClientAddress(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("ViewClientAddresses"); 
        try {
            Client client = clientService.searchClientById
                                        (request.getParameter("employeeId"));
            modelAndView.addObject("client", client);
        } catch (AppException e) {
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Update details of the client using the client id
     * and retrieving all values for that particular client in the database 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=updateAddress", 
                                        method=RequestMethod.GET)
    private ModelAndView updateAddress(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("ViewAddresses"); 
        try {
            if (request.getParameter("userType").equals("employee")) {
                int addressId = Integer.parseInt
                                  (request.getParameter("addressId"));
                Employee employee = employeeService.searchEmployeeById
                                            (request.getParameter("id"));
                modelAndView.addObject("employee", employee);
                for (Address address : employee.getAddresses()) {
                    if (address.getAddressId() == addressId) {                                    
                        modelAndView.addObject("address", address);
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher(
                                   "/views/jsp/UpdateAllEmployeeAddresses.jsp");
                rd.forward(request, response);
            }
            if (request.getParameter("userType").equals("client")) {
                int addressId = Integer.parseInt
                                   (request.getParameter("addressId"));
                Client client = clientService.searchClientById
                                            (request.getParameter("id"));
                modelAndView.addObject("client", client);
                for (Address address : client.getAddresses()) {
                    if (address.getAddressId() == addressId) {                                    
                        modelAndView.addObject("address", address);
                    }
                }
                RequestDispatcher rd = request.getRequestDispatcher(
                                    "/views/jsp/UpdateAllClientAddresses.jsp");
                rd.forward(request, response);
            }
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Getting details of client
     * Putting the details to an client object
     * Client object contains the following attributes
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=addNewAddress", 
                                        method=RequestMethod.GET)
    private ModelAndView addNewAddress(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("UpdateAddress");
        try {
            modelAndView.addObject("id", request.getParameter("employeeId"));
            if (request.getParameter("userType").equals("employee")) {
                modelAndView.addObject("userType", "employee");
            } else {
                modelAndView.addObject("userType", "client");
            }
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Delete details of the client by the clientId from database
     * and deleting all rows containing that clientId
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=deleteEmployeeAddresses", 
                                        method=RequestMethod.POST)
    private ModelAndView deleteEmployeeAddresses(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = null;
        try {   
            String[] addressValues = request.getParameterValues("addressType"); 
            if (null == addressValues) { 
                modelAndView = new ModelAndView("DeleteEmployeeAddresses");
                modelAndView.addObject("errorMessage", "No checkbox deleted");
            }   
            for (int iterator= 0 ; iterator < addressValues.length ;
                                                               iterator++) {
                int addressId = Integer.parseInt(addressValues[iterator]);
                addressService.deleteAddressById(
                              request.getParameter("id"),                       
                              request.getParameter("userType"),
                              addressId);
            }
            modelAndView = new ModelAndView("ShowEmployee");
            modelAndView.addObject("errorMessage", "Successfully deleted");
            modelAndView.addObject("employees",
                                         employeeService.getAllEmployees());
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Delete details of the employee by the employeeId using the dao
     * and deleting all rows containing that employee id
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=deleteClientAddresses", 
                                        method=RequestMethod.POST)
    private ModelAndView deleteClientAddresses(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = null;
        try {   
            String[] addressValues = request.getParameterValues("addressType");
            if (null == addressValues) { 
                modelAndView.addObject("errorMessage", "No checkbox deleted");
            } 
            for (int iterator= 0 ; iterator < addressValues.length ;
                                                               iterator++) {
                int addressId = Integer.parseInt(addressValues[iterator]);
                addressService.deleteAddressById(
                              request.getParameter("id"),                       
                              "client",
                              addressId);
            }
            modelAndView = new ModelAndView("ViewClient");
            modelAndView.addObject("errorMessage", "Successfully deleted");
            modelAndView.addObject("clients",
                                         clientService.getAllClients());
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Delete details of the employee by the employeeId using the dao
     * and deleting all rows containing that employee id
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=deleteAddress", 
                                        method=RequestMethod.GET)
    private ModelAndView deleteAddress(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {        
        ModelAndView modelAndView = new ModelAndView("DeleteEmployeeAddresses");
        try {      
            modelAndView.addObject("id", request.getParameter("id"));
            Employee employee = employeeService.searchEmployeeById
                                            (request.getParameter("id"));
            modelAndView.addObject("employee", employee);
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Delete details of the employee by the employeeId using the dao
     * and deleting all rows containing that employee id
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=deleteClientAddress", 
                                        method=RequestMethod.GET)
    private ModelAndView deleteClientAddress(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("DeleteClientAddresses");
        try {      
            modelAndView.addObject("id", request.getParameter("id"));
            Client client = clientService.searchClientById
                                            (request.getParameter("id"));
            modelAndView.addObject("client", client);
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Getting details of client
     * Putting the details to an client object
     * Client object contains the following attributes
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */ 
    @RequestMapping(params = "action=addAddress", 
                                        method=RequestMethod.POST)
    private ModelAndView addAddress(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws ServletException, IOException {
        ModelAndView modelAndView = null; 
        try {
            addressService.addAddress(request.getParameter("id"), 
                                       request.getParameter("addresstype"),
                                       request.getParameter("userType"), 
                                       request.getParameter("doorNumber"),
                                       request.getParameter("street1"), 
                                       request.getParameter("street2"),
                                       request.getParameter("landmark"),
                                       request.getParameter("city"), 
                                       request.getParameter("state"),
                                       request.getParameter("country"),
                                       request.getParameter("zipcode"));
            if (request.getParameter("userType").equals("employee")) {
                modelAndView = new ModelAndView("ShowEmployee");
                modelAndView.addObject("errorMessage", "Successfully added");
                modelAndView.addObject("employees",
                                             employeeService.getAllEmployees());
            } else {
                modelAndView = new ModelAndView("ViewClient");
                modelAndView.addObject("errorMessage", "Successfully added");
                modelAndView.addObject("clients",
                                             clientService.getAllClients());
            }
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
    
    /**
     * <p>
     * Update details of the client using the client id
     * and retrieving all values for that particular client in the database 
     * </p>
     * @param request
     *                     Request will be given by user
     * @param response
     *                     Response will be given back to user as result
     */
    @RequestMapping(params = "action=updateIndvidualAddress", 
                                        method=RequestMethod.POST)
    private ModelAndView updateIndvidualAddress(HttpServletRequest request, 
                                    HttpServletResponse response)
                                    throws IOException {
        ModelAndView modelAndView = null; 
        try {
            int addressId = Integer.parseInt(request.getParameter("addressId"));
            if (null != request.getParameter("addressId")) {
                addressService.updateAddressById(addressId, 
                                           request.getParameter("id"), 
                                           request.getParameter("addresstype"),
                                           request.getParameter("userType"), 
                                           request.getParameter("doorNumber"),
                                           request.getParameter("street1"), 
                                           request.getParameter("street2"),
                                           request.getParameter("landmark"),
                                           request.getParameter("city"), 
                                           request.getParameter("state"),
                                           request.getParameter("country"),
                                           request.getParameter("zipcode"));
                modelAndView.addObject("errorMessage", "Successfully updated");
            }
            if (request.getParameter("userType").equals("employee")) {
                modelAndView = new ModelAndView("ShowEmployee");
                modelAndView.addObject("employees",
                                             employeeService.getAllEmployees());
            } else {
                modelAndView = new ModelAndView("ViewClient");
                modelAndView.addObject("clients",
                                             clientService.getAllClients());
            }
        } catch (AppException e) {
            
        }
        return modelAndView;
    }
}
