/*
 * Copyrights reserved
 * Demonstrate employee operations using a sample program
 */
package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.dao.ClientDao;
import com.ideas2it.dao.impl.ClientDaoImpl;
import com.ideas2it.exception.AppException;
import com.ideas2it.model.Address;
import com.ideas2it.model.Client;
import com.ideas2it.model.Project;
import com.ideas2it.service.ClientService;
import com.ideas2it.service.ProjectService;
import com.ideas2it.service.impl.ProjectServiceImpl;
import com.ideas2it.util.CommonUtil;
import com.ideas2it.util.DateUtil;

/**
 * Implementing the basic operations performed on an employee table by using
 * direct access object, all validations and operations are 
 * performed in the service class and returned to controller. 
 *
 * @author manoj
 *
 * created on 06-07-2017
 */

public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    private ProjectService projectService;
    
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    } 
    
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    } 
    
    /*
     * @see com.ideas2it.service.ClientService #addClient(String, String, 
     *                                              String, String)
     */
    public boolean addClient(String clientId, String clientMailId, 
                          String clientName, String clientDesignation,
                          List<Address> addresses) 
                          throws AppException {
        if (!isClientIdExists(clientId)) {   
            Client client = new Client(clientId, clientMailId, clientName, 
                                    clientDesignation);
            client.setAddresses(addresses);
            return clientDao.insertClient(client);
        }
        return false;
    }
    
    /*
     * @see com.ideas2it.service.ClientService #getAllClients
     */      
    public List<Client> getAllClients() throws AppException {  
        return clientDao.retrieveAllClients();
    }
   
    /*
     * @see com.ideas2it.service.ClientService #deleteClientById(String)
     */  
    public boolean deleteClientById(String clientId) throws AppException {  
        Client client = searchClientById(clientId);
        if (client.getProjects() != null) {
            for (Project project : client.getProjects()) {
                projectService.deleteProjectById(project.getId());
            }
        }
        return clientDao.deleteClientById(clientId); 
    }
    
    /*
     * @see com.ideas2it.service.ClientService #deleteClientById(String)
     */
    public Client searchClientById(String clientId) throws AppException {     
        return clientDao.retrieveClientById(clientId);
    }

    /*
     * @see com.ideas2it.service.ClientService #updateClientById(String, String, 
     *                                              String, String)
     */ 
    public boolean updateClientById(String clientId, String clientMailId, 
                                String clientName, String clientDesignation,
                                List<Address> updatedAddresses) 
                                throws AppException {    
        Client client = searchClientById(clientId);  
        client.setName(clientName);
        client.setEmailId(clientMailId);
        client.setDesignation(clientDesignation);                 
        if (null != updatedAddresses) {
            List<Address> previousAddresses = client.getAddresses();
            for (Address previousAddress : previousAddresses) {
                for (Address updatedAddress : updatedAddresses) {
                    if (previousAddresses.indexOf(previousAddress) ==
                            updatedAddresses.indexOf(updatedAddress)) {                
                        updatedAddress.setId(previousAddress.getId());
                    }
               }
           }
           client.setAddresses(updatedAddresses);                                
           return clientDao.updateClientById(client);
        }
        return false;
    }  
            
    /*
     * @see com.ideas2it.service.ProjectService #method createProjectByClient
     *                                              (String, String, String,
     *                                               String)
     */
    public boolean addProjectToClient(String clientId, String projectId)
                                            throws AppException {   
        List<Project> projects = null;
        if ((projectService.isProjectIdExists(projectId)) && 
                                      (isClientIdExists(clientId))) {
            Project project = projectService.searchProjectById(projectId);
            Client client = searchClientById(clientId);
            projects.add(project); 
            if (null != projects) {
                client.setProjects(projects);                         
            }
            return clientDao.insertProjectToClient(client);
        }                                  
        return false;
    }                                                               

    /*
     * @see com.ideas2it.service.ProjectService #method deleteProjectByClientId
     *                                              (String, String)
     */
    public boolean deleteProjectByClientId(String clientId, String projectId)
                                             throws AppException {
        List<Project> projects = null;
        int index = 0;
        if ((projectService.isProjectIdExists(projectId)) && 
                                   (isClientIdExists(clientId))) {
            Client client = searchClientById(clientId);
            projects = client.getProjects();
            if (null != projects) {
                for(Project project : projects) {                
                    if (project.getId().equals(projectId)) { 
                        index = projects.indexOf(project); 
                    }
                }  
            }
            projects.remove(index);         
            return clientDao.deleteProjectByClient(client);
        }
        return false;   
    }   
   
    /*
     * @see com.ideas2it.service.ClientService #isClientIdExists(String) 
     */ 
    public boolean isClientIdExists(String clientId) throws AppException {        
        return clientDao.isRecordExists(clientId);
    }
    
    /**
     * <p>
     * Checks whether all the details are entered in valid format
     * </p>
     *
     * @params clientId
     *                        checks for only numbers in client id
     * @param clientDesignation
     *                        check for only characters in client 
     *                        designation
     * @param clientMailId        
     *                        checks for valid mail format of client mail
     * @param clientName        
     *                        checks for only characters in client name
     * @return true or false
     *                        if all client details are valid, returns 
     *                        true otherwise false
     */ 
    private boolean isValidClientDetail(String clientId, String clientMailId, 
                                 String clientName, 
                                 String clientDesignation) {
        boolean validEntryChecked = true;
        if (!isValidMail(clientMailId)) {
            validEntryChecked = false;
        }
        if (!isValidClientId(clientId)) {
            validEntryChecked = false;
        } 
        if (!isValidClientName(clientName)) {
            validEntryChecked = false;
        }
        if (!isValidClientDesignation(clientDesignation)) {
            validEntryChecked = false;
        } 
        return validEntryChecked;
    }
           
    /**
     * <p>
     * Checking whether all the client's emailid is entered in correct format
     * </p>
     *
     * @params emailId
     *                        checks for valid mail format in client mail
     * @return true or false
     *                        if client mail id is in valid format,  
     *                             returns true otherwise false
     */
    private boolean isValidMail(String emailId) {
        return CommonUtil.isValidMailFormat(emailId);
    }
    
    /**
     * <p>
     * Checking whether all the client's id is entered in correct format
     * </p>
     *
     * @params id
     *                        check for only numbers in client id
     * @return true or false
     *                        if client id contains only numbers,  
     *                        returns true otherwise false
     */
    private boolean isValidClientId(String id) {
        return CommonUtil.isNumerical(id);
    }
         
    /**
     * <p>
     * Checking whether all the client's designation is entered in 
     * correct format
     * </p>
     *
     * @params designation
     *                        checks if client designation has only characters
     * @return true or false
     *                        if all client mail id is in valid format,  
     *                        returns true otherwise false
     */
    private boolean isValidClientDesignation(String designation) {
        return CommonUtil.isString(designation);
    }
    
    /**
     * <p>
     * Checking whether all the client's names is entered in correct format
     * </p>
     *                                                       
     * @params name
     *                        checks if client name has only characters
     * @return true or false
     *                        if client name contains only characters,  
     *                             returns true otherwise false
     */
    private boolean isValidClientName(String name) {
        return CommonUtil.isString(name);
    }     
}     

