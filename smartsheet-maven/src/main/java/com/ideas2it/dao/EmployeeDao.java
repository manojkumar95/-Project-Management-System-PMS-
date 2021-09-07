package com.ideas2it.dao;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.exception.AppException;
import com.ideas2it.model.Employee;

public interface EmployeeDao {
    
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
    void insertEmployee(Employee employee) throws AppException ;
    
    /**
     * <p>
     * Delete details of the employee by the id from database
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
    void deleteEmployeeById(String employeeId) throws AppException;

    /**
     * <p>
     * Update details of the employee using the employee id
     * and retrieving all values for that particular employee in the database 
     * </p>
     *
     * @params employee
     *                updates whether the employee info for that particular 
     *                employee id if present in the database
     * @return true or false 
     *                returns trye if employee record is updated otherwise null
     * @throws AppException if updation query fails to get connection
     */   
    void updateEmployee(Employee employee) throws AppException;
    
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
    List<Employee> retrieveAllEmployees() throws AppException;
    
    Employee retrieveEmployee(String employeeId) throws AppException;
    
    boolean isRecordExists(String employeeId) throws AppException;
}
