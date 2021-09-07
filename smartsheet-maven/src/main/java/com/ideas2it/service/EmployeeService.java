package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Address;
import com.ideas2it.exception.AppException;

public interface EmployeeService {
    
    /**
     * <p>
     * Adding details of a employee using the direct access object
     * </p>
     *
     * @param employeeId                
     *                            unique id to find, search and update the 
     *                            employee details of the user
     * @param employeeDesignation
     *                            employeeDesignation to store in the 
     *                            corresponding employeeId
     * @param employeeMailId
     *                            employeeMailId to store in the 
     *                            corresponding employeeId
     * @param employeeName              
     *                            employeeName to store in the 
     *                            corresponding employeeId          
     * @param employeeAge               
     *                            employeeAge to store in the 
     *                            corresponding employeeId     
     * @return true or false
     *                            if details are valid the employee details are
     *                            added to list and returns true otherwise false
     * @throws AppException if insert query fails to get connection
     */
    boolean addEmployee(String id, String emailId, String name, 
                                   String dob, String designation, 
                                   List<Address> addresses) throws AppException;
                            
    /**
     * <p>
     * Display details of all the employees
     * </p>
     *
     *
     * return List            
     *                        returns list of employees for a particular 
     *                        userType, if no details are present then return 
     *                        null
     * @throws AppException if select query fails to get connection
     */                                  
    List<Employee> getAllEmployees() throws AppException;
    
    /**
     * <p>
     * Display details of all the employees
     * </p>
     *
     *
     * return Employee            
     *                        returns object employee for a particular 
     *                        userType, if no details are present then return 
     *                        null
     * @throws AppException if select query fails to get connection
     */                                  
    public Employee searchEmployeeById(String employeeId) throws AppException;
    
    /**
     * <p>
     * Getting ID details isValidEmployeeDetailof employee
     * Removing the employee details from the list
     * </p>
     *
     * @param employeeId                
     *                           delete the employee record based on employee Id
     * return boolean
     *                           returns true if employee record is deleted,
     *                           otherwise false
     * @throws AppException if delete query fails to get connection
     */  
    void deleteEmployee(String employeeId) throws AppException;
    
    /**
     * <p>
     * Updating details of employee using the Employee Id
     * </p>
     *
     * @param employeeId                
     *                            unique id to find, search and update the 
     *                            employee details of the user
     * @param employeeDesignation
     *                            employeeDesignation to store in the 
     *                            corresponding employeeId
     * @param employeeMailId
     *                            employeeMailId to store in the 
     *                            corresponding employeeId
     * @param employeeName              
     *                            employeeName to store in the 
     *                            corresponding employeeId          
     * @param employeeAge               
     *                            employeeAge to store in the 
     *                            corresponding employeeId  
     * @return true or false
     *                            if details are valid the employee details are
     *                            updated to list and returns true otherwise 
     *                            false
     * @throws AppException if update query fails to get connection
     */   
    void updateEmployee(String id, String emailId, String name, 
                                   String dob, String designation, 
                                   List<Address> addresses) throws AppException;                                        
}  
