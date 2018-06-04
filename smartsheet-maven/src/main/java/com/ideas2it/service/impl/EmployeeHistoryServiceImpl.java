/*
 * Copyrights reserved
 * Demonstrate employee operations using a sample program
 */
package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.dao.EmployeeHistoryDao;
import com.ideas2it.dao.impl.EmployeeHistoryDaoImpl;
import com.ideas2it.exception.AppException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeHistory;
import com.ideas2it.model.Project;
import com.ideas2it.service.EmployeeHistoryService;
import com.ideas2it.exception.AppException;

/**
 * Implementing the basic operations performed on an employee table by using
 * direct access object, all validations and operations are 
 * performed in the service class and returned to controller. 
 *
 * @author manoj
 *
 * created on 06-07-2017
 */

public class EmployeeHistoryServiceImpl implements EmployeeHistoryService {
    private EmployeeHistoryDao employeeHistoryDao;
    
    public void setEmployeeHistoryDao(EmployeeHistoryDao employeeHistoryDao) {
        this.employeeHistoryDao = employeeHistoryDao;
    } 
    
    /*
     * @see com.ideas2it.service.EmployeeHistoryService 
     *                               #method addEmployeeHistory(EmployeeHistory)
     * 
     */
    public void addEmployeeHistory(EmployeeHistory employeeHistory) throws 
                                                                 AppException {
        employeeHistoryDao.insertEmployeeHistory(employeeHistory);
    }
    
    /*
     * @see com.ideas2it.service.EmployeeHistoryService 
     *                               #method getEmployeeHistory(String)
     * 
     */
    public EmployeeHistory getEmployeeHistory(String projectId, 
                                                  String employeeId) 
                                                  throws AppException {
        return employeeHistoryDao.retrieveEmployeeHistory(projectId, employeeId);
    }
    
    public void updateEmployeeHistory(EmployeeHistory employeeHistory) throws 
                                                                 AppException {
        employeeHistoryDao.updateEmployeeHistory(employeeHistory);
    }     
     
    /*
     * @see com.ideas2it.service.EmployeeHistoryService  
     *                                        #method getAllEmployeesHistory()
     * 
     */
    public List<EmployeeHistory> getAllEmployeesHistory() throws AppException {
        return employeeHistoryDao.retrieveAllEmployeesHistory();
    }
}


