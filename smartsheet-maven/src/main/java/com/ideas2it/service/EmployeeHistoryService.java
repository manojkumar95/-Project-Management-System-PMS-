package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeHistory;
import com.ideas2it.model.Project;
import com.ideas2it.exception.AppException;

public interface EmployeeHistoryService {
    
    /**
     * <p>
     * Display details of all the employees
     * by retrieving all values from database and returning a list
     * </p>
     *
     * @return Employees 
     *                 List consisting of all the employee records if present
     *                 otherwise null
     * @throws AppException if select query fails to retrieve details
     */    
    List<EmployeeHistory> getAllEmployeesHistory() throws AppException;
    
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
    void addEmployeeHistory(EmployeeHistory employeeHistory) throws 
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
    EmployeeHistory getEmployeeHistory(String projectId, String employeeId) 
                                                       throws AppException;
}
