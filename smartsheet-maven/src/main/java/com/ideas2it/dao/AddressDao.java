package com.ideas2it.dao;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.exception.AppException;
import com.ideas2it.model.Address;
import com.ideas2it.model.Client;
import com.ideas2it.model.Employee;

public interface AddressDao {
    
    /**
     * <p>
     * Getting details of client
     * Putting the details to an client object
     * Client object contains the following attributes
     * </p>
     *
     * @param client               
     *                            client contains all the details of the 
     *                            client to be inserted
     * @return true or false
     *                            if details are valid the client details are
     *                            added to list and returns true otherwise false
     * @throws AppException if insertion query fails to get connection
     */    
    boolean insertAddressToClient(Address address) throws AppException;
    
    /**
     * <p>
     * Getting details of employee
     * Putting the details to an employee object
     * Employee object contains the following attributes
     * </p>
     *
     * @param employee               
     *                            employee contains all the details of the 
     *                            employee to be inserted
     *
     * @return true or false
     *                            if details are valid the employee details are
     *                            added to list and returns true otherwise false
     * @throws AppException if insertion query fails to get connection
     */    
    boolean insertAddressToEmployee(Address address) throws AppException;
    
    /**
     * <p>
     * Delete details of the client by the clientId from database
     * and deleting all rows containing that clientId
     * </p>
     *
     * @params clientId
     *                deletes the client record using employee id present in 
     *                the database
     * @return true or false 
     *                returns true if client record is deleted otherwise false
     * @throws AppException if deletion query fails to get connection
     */   
    boolean deleteClientAddressById(Client client) throws 
                                        AppException;
                                               
    /**
     * <p>
     * Delete details of the employee by the employeeId using the dao
     * and deleting all rows containing that employee id
     * </p>
     *
     * @params employeeId
     *                deletes the employee record using employee id present in 
     *                the database
     * @return true or false 
     *                returns true if employee record is deleted otherwise false
     * @throws AppException if deletion query fails to get connection 
     */   
    boolean deleteEmployeeAddressById(Employee employee) throws 
                                          AppException;
    /**
     * <p>
     * Display details of the client based on clientId
     * and retrieving the row from database containing the clientId
     * </p>
     *
     * @params clientId
     *                checks whether the clientId is present in the database
     * @return client 
     *                returns the client record if present otherwise null
     * @throws AppException if select query fails to get connection
     */  
    Address retrieveClientAddressById(String clientId, String userType,
                                          String addressType) throws 
                                          AppException;
                                                 
    /**
     * <p>
     * Display details of the employee based on employee id
     * and retrieving the row from database containing the employee id
     * </p>
     *
     * @params employeeId
     *                checks whether the employee id is present in the database
     * @return employee 
     *                returns the employee record if present otherwise null
     * @throws AppException if select query fails to get connection
     */  
    Address retrieveEmployeeAddressById(Employee employee, String userType,                                                   
                                            String addressType) throws 
                                            AppException;
    /**
     * <p>
     * Update details of the client using the client id
     * and retrieving all values for that particular client in the database 
     * </p>
     *
     * @params clientId
     *                updates whether the client info for that particular 
     *                client id if present in the database
     * @return true or false 
     *                returns true if client record is updated otherwise null
     * @throws AppException if update query fails to get connection
     */   
   boolean updateClientAddressById(Address address) throws AppException;                                               
    
    /**
     * <p>
     * Update details of the employee using the employee id
     * and retrieving all values for that particular employee in the database 
     * </p>
     *
     * @params  employeeId
     *                updates whether the employee info for that particular 
     *                employee id if present in the database
     * @return true or false 
     *                returns true if employee record is updated otherwise null
     * @throws AppException if update query fails to get connection
     */   
    boolean updateEmployeeAddressById(Address address) throws AppException;
    
    /**
     * <p>
     * Display details of all the clients
     * by retrieving all records belonging to clients usertype and returning a 
     * list
     * </p>
     *
     * @return clients 
     *                 List consisting of all the client records if present
     *                 otherwise null
     * @throws AppException if select query fails to get connection
     */    
    List<Address> retrieveAllClientAddresses() throws AppException;
    
    /**
     * <p>
     * Display details of all the employees
     * by retrieving all values from database and returning a list
     * </p>
     *
     * @return Employees 
     *                 List consisting of all the employee records if present
     *                 otherwise null
     * @throws AppException if select query fails to get connection
     */    
    List<Address> retrieveAllEmployeeAddresses() throws AppException;
}
