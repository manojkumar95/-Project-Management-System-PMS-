package com.ideas2it.dao;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.exception.AppException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeHistory;
import com.ideas2it.model.Project;

public interface EmployeeHistoryDao {
    
    /**
     * <p>
     * Display details of all the employees history
     * by retrieving all values from database and returning a list
     * </p>
     *
     * @return List<EmployeeHistory> 
     *                 List consisting of all the employee records if present
     *                 otherwise null
     * @throws AppException if select query fails to retrieve details
     */    
    List<EmployeeHistory> retrieveAllEmployeesHistory() throws AppException;
    
    /**
     * <p>
     * Inserting details of all the employees history
     * by retrieving all values from database and returning a list
     * </p>
     *
     * @param EmployeeHistory 
     *                 List consisting of all the employee records if present
     *                 otherwise null
     * @throws AppException if select query fails to retrieve details
     */ 
    void insertEmployeeHistory(EmployeeHistory employeeHistory) throws 
                                    AppException;
    /**
     * <p>
     * Inserting details of all the employees history
     * by retrieving all values from database and returning a list
     * </p>
     *
     * @param EmployeeHistory 
     *                 List consisting of all the employee records if present
     *                 otherwise null
     * @throws AppException if select query fails to retrieve details
     */                                                                  
    void updateEmployeeHistory(EmployeeHistory employeeHistory) throws 
                                                                   AppException; 
    /**
     * <p>
     * Display details of all the employees history
     * by retrieving all values from database and returning a list
     * </p>
     *
     * @param employeeId 
     *                 check for employee history using the employeeId
     * @return List<EmployeeHistory> 
     *                 List consisting of all the employee records if present
     *                 otherwise null
     * @throws AppException if select query fails to retrieve details
     */                                                               
    EmployeeHistory retrieveEmployeeHistory(String projectId, String employeeId) 
                                                       throws AppException;      
}
