package com.ideas2it.dao;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.exception.AppException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Project;

public interface ProjectDao {
    
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
     * @throws AppException if insertion query fails to get connection
     */   
    boolean insertProject(Project project) throws AppException;
    
    /**
     * <p>
     * Display details of all the projects
     * by retrieving all values from database and returning a list
     * </p>
     * 
     * @return projects 
     *                 List consisting of all the project records if present
     *                 otherwise null
     * @throws AppException if select query fails to retrieve details
     */   
    List<Project> retrieveAllProjects() throws AppException;
    
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
     * @throws AppException if deletion query fails to retrieve details
     */   
    boolean deleteProjectById(Project project) throws AppException;
    
    /**
     * <p>
     * Retrieve details of the project based on project id
     * and retrieving the row from database containing the project id
     * </p>
     *
     * @params projectId
     *                gets the project id and deletes the project
     * @return project 
     *                returns details of project if project exists otherwise 
     *                null
     * @throws AppException if select query fails to retrieve details
     */  
    Project retrieveProject(String projectId) throws AppException;
    
    /**
     * <p>
     * Update details of the project using the project id
     * and retrieving all values for that particular project in the database 
     * </p>
     *
     * @param project              
     *                            project contains the particulars of the 
     *                            project
     * @return true or false
     *                            if details are valid the project details are
     *                            added to list and returns true otherwise false
     */   
    boolean updateProject(Project project) throws AppException;
    
    /**
     * <p>
     * Assign employees to projects using the project id and if employee is not
     * present, create a employee and assign to projects
     * </p>
     *
     * @params projectId
     *                gets the project id and inserts employees working on that
     *                project 
     * @params employeeId
     *                gets the employee id and inserts employees working on 
     *                that project 
     * @return boolean 
     *                returns true if project is created otherwise false
     * @throws AppException if insert query fails to insert details
     */  
    void insertEmployeeToProject(Project project) throws AppException;
    
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
    void insertClientToProject(Project project) throws 
                                      AppException;  
    
    /** 
     * <p>
     * Remove employees from the project using the project id and if employee 
     * leaves the company, then remove from the employee list of records
     * </p>
     *
     * @params projectId
     *                gets the project id and removes employees working on that
     *                project 
     * @params employeeId
     *                gets the employee id and removes employees working on 
     *                that project 
     * @return boolean
     *                returns true if employees are removed from that project
     *                otherwise null
     * @throws AppException if delete query fails to retrieve details
     */                                          
    boolean deleteEmployeeFromProject(Employee employee)
                                         throws AppException;
    
    /*
     * <p>
     * Checks whether the project id is present in the database
     * </p>
     *
     * @params  projectId
     *                checks whether the employee id is present in the database
     * @return true or false 
     *                returns true if employee record is present otherwise false
     * @throws AppException if select query fails to find the project record
     */
    boolean isProjectRecordExists(String projectId) throws 
                                                 AppException;
    
    /*
     * <p>
     * Checks whether the employee record is present in the database
     * </p>
     *
     * @params  employeeId
     *                checks whether the employee id is present in the database
     * @return true or false 
     *                returns true if employee record is present otherwise false
     * @throws AppException if select query fails to find the employee record
     */                                              
    boolean isEmployeeRecordExists(String employeeId) throws 
                                                 AppException;                                      
     
    /*
     * <p>
     * Shows all the employees who are not working in any projects
     * </p>
     *
     * @return employees 
     *                returns list if employees are working on projects
     *                otherwise null
     * @throws AppException if select query fails to find the employee record
     */                                        
    List<Employee> retrieveEmployeesNotAssignedToProjects() throws
                                            AppException;                                        
}
