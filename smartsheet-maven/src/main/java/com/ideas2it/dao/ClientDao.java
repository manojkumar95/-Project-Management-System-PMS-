package com.ideas2it.dao;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.exception.AppException;
import com.ideas2it.model.Client;
import com.ideas2it.model.Project;

public interface ClientDao {
    
    /**
     * <p>
     * Getting details of client
     * Putting the details to an client object
     * client object contains the following attributes
     * </p>
     *
     * @param client               
     *                            client contains all the details of the 
     *                            client to be inserted
     *
     * @return true or false
     *                            if details are valid the client details are
     *                            added to list and returns true otherwise false
     */    
    boolean insertClient(Client client) throws AppException ;
    
    /**
     * <p>
     * Delete details of the client by the client id by accessing the dao
     * and deleting all rows containing that client id
     * </p>
     *
     * @params clientId
     *                deletes the client record using client id present in 
     *                the database
     * @return true or false 
     *                returns true if client record is deleted otherwise false
     * @throws AppException if insertion query fails to get connection
     */   
    boolean deleteClientById(String clientId) throws AppException;
    
    /**
     * <p>
     * Display details of the client based on client id
     * and retrieving the row from database containing the client id
     * </p>
     *
     * @params clientId
     *                checks whether the client id is present in the database
     * @return client 
     *                returns the client record if present otherwise null
     * @throws AppException if deletion query fails to get connection
     */  
    Client retrieveClientById(String clientId) throws AppException;

    /**
     * <p>
     * Update details of the client using the client id
     * and retrieving all values for that particular client in the database 
     * </p>
     *
     * @params client
     *                updates whether the client info for that particular 
     *                client id if present in the database
     * @return true or false 
     *                returns true if client record is updated otherwise null
     * @throws AppException if select query fails to get connection
     */   
    boolean updateClientById(Client client) throws AppException;
    
    /**
     * <p>
     * Display details of all the clients
     * by retrieving all values from database and returning a list
     * </p>
     *
     * @return clients 
     *                 List consisting of all the client records if present
     *                 otherwise null
     * @throws AppException if update query fails to get connection
     */    
    List<Client> retrieveAllClients() throws AppException;
    
    /*
     * <p>
     * checks whether the client record is present in the database
     * </p>
     *
     * @params clientId
     *                checks whether the client id is present in the database
     * @return true or false 
     *                returns true if client record is present otherwise false
     * @throws AppException if insertion query fails to find the client record
     */ 
    boolean isRecordExists(String clientId) throws AppException;
    
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
    boolean insertProjectToClient(Client client) throws 
                                      AppException;                                        
    
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
    boolean deleteProjectByClient(Client client) throws AppException; 
}
