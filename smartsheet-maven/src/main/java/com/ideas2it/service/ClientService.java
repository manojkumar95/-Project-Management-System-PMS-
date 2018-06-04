package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.Address;
import com.ideas2it.model.Client;
import com.ideas2it.model.Project;
import com.ideas2it.exception.AppException;

public interface ClientService {
    
    /**
     * <p>
     * Adding details of a client using the direct access object
     * </p>
     *
     * param clientId                
     *                            unique id to find, search and update the 
     *                            client details of the user
     * @param clientDesignation
     *                            clientDesignation to store in the 
     *                            corresponding clientId
     * @param clientMailId
     *                            clientMailId to store in the 
     *                            corresponding clientId
     *                            clientName to store in the database 
     * @param clientName  
     *                            clientName to store in the 
     *                            corresponding clientId     
     * @return true or false
     *                            if details are valid the client details are
     *                            added to list and returns true otherwise false
     * @throws AppException if insert query fails to get connection
     */
    boolean addClient(String clientId, String clientMailId, 
                          String clientName, String clientDesignation,
                          List<Address> addresses) 
                          throws AppException;
    
    /**
     * <p>
     * Display details of all the employees
     * </p>
     *
     * return List            
     *                        returns list of clients for a particular 
     *                        userType, if no details are present then return 
     *                        null
     * @throws AppException if select query fails to get connection
     */                                
    List<Client> getAllClients() throws AppException;
    
    /**
     * <p>
     * Removing the client details by getting the clientId from the user
     * </p>
     *
     * @param clientId                
     *                           delete the client record based on client Id
     * return boolean
     *                           returns true if employee record is deleted,
     *                           otherwise false
     * @throws AppException if delete query fails to get connection
     */  
    boolean deleteClientById(String clientId) throws AppException;
    
    /**
     * <p>
     * Searching details of client using the Employee Id
     * </p>
     * @params clientId
     *                   for searching records based on client id
     * @return client or null
     *                   returns details present in an object client
     * @throws AppException if search query fails to get connection
     */
    Client searchClientById(String clientId) throws AppException;
    
     /**
     * <p>
     * Updating details of client using the client Id
     * </p>
     *
     * param clientId                
     *                            unique id to find, search and update the 
     *                            client details of the user
     * @param clientDesignation
     *                            clientDesignation to store in the 
     *                            corresponding clientId
     * @param clientMailId
     *                            clientMailId to store in the 
     *                            corresponding clientId
     *                            clientName to store in the database 
     * @param clientName  
     *                            clientName to store in the 
     *                            corresponding clientId     
     * @return true or false
     *                            if details are valid the client details are
     *                            updated to list and returns true otherwise 
     *                            false
     * @throws AppException if update query fails to get connection
     */
    boolean updateClientById(String clientId, String clientMailId, 
                          String clientName, String clientDesignation,
                          List<Address> addresses) 
                          throws AppException;
    
    /**
     * Checking whether the client id already exists in the clients list
     * @param client id  
     *                        checks if client id already exists
     * @return true or false
     *                        if client id already exists, returns 
     *                        true otherwise false
     * @throws AppException if select query fails to find the client record
     */                                      
    boolean isClientIdExists(String clientId) throws AppException;
    
    /**
     * <p>
     * Getting details of project
     * Putting the details to an project object
     * project object contains the following attributes
     * </p>
     *
     * @param project              
     *                            project contains the particulars of the 
     *                            project
     * @return true or false
     *                            if details are valid the project details are
     *                            added to list and returns true otherwise false
     * @throws AppException if insert query fails to find the project record
     */                                           
    public boolean addProjectToClient(String clientId, String projectId)
                                            throws AppException;                                                
                                       
    /**
     * <p>
     * Delete details of the project by getting the id from database
     * and deleting all rows containing that project id
     * </p>
     *
     * @params projectId
     *                gets the project id and deletes the project
     * @return boolean 
     *                returns true if project is deleted otherwise null
     * @throws AppException if delete query fails to find the project record
     */   
    public boolean deleteProjectByClientId(String clientId, String projectId)
                                            throws AppException;  
}  
