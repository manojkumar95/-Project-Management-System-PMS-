package com.ideas2it.service;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.exception.AppException;
import com.ideas2it.model.Project;
import com.ideas2it.model.Employee;

public interface ProjectService {
    
    /**
     * <p>
     * Adds all the project details are entered in valid format
     * </p>
     *
     * @params projectId
     *                        checks for only numbers in project id
     * @param projectTitle
     *                        check for only characters in project 
     *                        title
     * @param projectStartDate        
     *                        checks for valid date format in project 
     * @param projectEndDate        
     *                        checks for valid date format in project
     * @return true or false
     *                        if details are valid the project details are
     *                        added and returns true otherwise false
     * @throws AppException if insert query fails to get connection
     */   
    public boolean addProject(String projectId, String projectTitle, 
                              String projectStartDate, String projectEndDate) 
                              throws AppException;
    
    /**
     * <p>
     * Display details of all the projects
     * </p>
     *
     * @return projects 
     *                returns list if projects are working on projects
     *                otherwise null
     * @throws AppException if select query fails to find the employee record
     */                                        
    public List<Project> getAllProjects() throws AppException;

    /**
     * <p>
     * Getting the project Id to remove all the corresponding detail of project
     * Removing the project details 
     * </p>
     *
     * @params projectId
     *                gets the project id and deletes the project
     * @return boolean 
     *                returns true if project is deleted otherwise null
     * @throws AppException if deletion query fails to retrieve details
     */   
    public boolean deleteProjectById(String projectId) throws AppException;
    
    /**
     * <p>
     * Searching details of project using the project Id
     * </p>
     *
     * @params projectId
     *                   for searching records based on project id
     * @return project or null
     *                   returns details present in an object project
     * @throws AppException if select query fails to retrieve details
     */
    public Project searchProjectById(String projectId) throws AppException;

    /**
     * Updates all the project details are entered in valid format
     * 
     * @params projectId
     *                        checks for only numbers in project id
     * @param projectTitle
     *                        check for only characters in project 
     *                        title
     * @param projectStartDate        
     *                        checks for valid date format in project 
     * @param projectEndDate        
     *                        checks for valid date format in project
     * @return true or false
     *                        if details are valid the project details are
     *                        updated and returns true otherwise false
     * @throws AppException if updation query fails to retrieve details
     */   
    public boolean updateProjectById(String projectId, String projectTitle, 
                              String projectStartDate, String projectEndDate) 
                              throws AppException;
    
    /** 
     * Add employees who are working on the project by requesting the
     * projectDao and returning values from services to controller  
     *
     * @params projectId 
     *                   gets the project id to add employees to the project    
     * @params employeeId
     *                   gets the employee id to add employees to the project
     * @return boolean
     *                   if employees are added to project, returns true
     *                   otherwise false
     * @throws AppException if insert query fails to insert details
     */
    public boolean addEmployeeToProject(String projectId, String employeeId) 
                                            throws AppException;
    
    /** 
     * Add employees who are working on the project by requesting the
     * projectDao and returning values from services to controller  
     *
     * @params projectId 
     *                   gets the project id to add employees to the project    
     * @params employeeId
     *                   gets the employee id to add employees to the project
     * @return boolean
     *                   if employees are added to project, returns true
     *                   otherwise false
     * @throws AppException if insert query fails to insert details
     */                                        
    public boolean addClientToProject(String projectId, String clientId) 
                                            throws AppException;
    
    /** 
     * Remove the employees who are not working on the project by requesting the
     * projectDao and returning values from services to controller  
     * @params projectId 
     *                   gets the project id to remove employees from project    
     * @params employeeid
     *                   gets the employee id to remove employees from project
     * @return boolean
     *                   if employees are removed from project, returns true
     *                   otherwise false
     * @throws AppException if deletion query fails to remove details
     */                                        
    public boolean removeEmployeeFromProject(String projectId, 
                                                  String employeeId) 
                                                  throws AppException;
    
    /*
     * shows all the employees working in projects
     *
     * @return employees 
     *                returns list if employees are working on projects
     *                otherwise null
     * @throws AppException if select query fails to retrieve details
     */                                         
    public List<Employee> getEmployeesNotAssignedToProjects() throws
                                            AppException;  
                                            
    /**
     * Checking whether the project id already exists 
     *
     * @param projectId  
     *                        checks if project id already exists
     * @return true or false
     *                        if project id already exists, returns 
     *                        true otherwise false
     */ 
    public boolean isProjectIdExists(String projectId) throws
                                            AppException;
}
