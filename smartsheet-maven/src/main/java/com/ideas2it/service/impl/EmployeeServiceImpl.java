/*
 * Copyrights reserved
 * Demonstrate employee operations using a sample program
 */
package com.ideas2it.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.impl.EmployeeDaoImpl;
import com.ideas2it.exception.AppException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Address;
import com.ideas2it.service.EmployeeService;
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

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    } 
    
    /*
     * @see com.ideas2it.service.EmployeeService #method addEmployee(String, 
     *                                                String, String, String)
     * 
     */
    public boolean addEmployee(String id, String emailId, String name, 
                                   String dob, String designation, 
                                   List<Address> addresses) throws 
                                AppException { 
        if (!isEmployeeIdExists(id)) {   
            Employee employee = new Employee(id, emailId, name, dob, 
                                  designation);
            employee.setAddresses(addresses);                 
            employeeDao.insertEmployee(employee);
            return true;
        }
        return false;
    }
        
    /*
     * @see com.ideas2it.service.EmployeeService #method getAllEmployees()
     */     
    public List<Employee> getAllEmployees() throws AppException {  
        return employeeDao.retrieveAllEmployees();
    }
    
     /*
     * @see com.ideas2it.service.EmployeeService #method searchEmployeeById
     *                                                (String)
     */ 
    public Employee searchEmployeeById(String employeeId) throws AppException {     
        if (isEmployeeIdExists(employeeId)) {
            return employeeDao.retrieveEmployee(employeeId);
        }
        return null;
    }
   
    /*
     * @see com.ideas2it.service.EmployeeService #method deleteEmployeeById
     *                                                                  (String)
     */ 
    public void deleteEmployee(String employeeId) throws AppException {  
        employeeDao.deleteEmployeeById(employeeId);
    }
    
    /*
     * @see com.ideas2it.service.EmployeeService #method updateEmployeeById
     *                                                (String, String, String, 
     *                                                 String)
     */ 
    public void updateEmployee(String id, String emailId, String name, 
                                   String dob, String designation, 
                                   List<Address> updatedAddresses) throws 
                                   AppException {   
        Employee employee = searchEmployeeById(id);                      
        if (null != employee) {
            employee.setName(name);
            employee.setEmailId(emailId);
            employee.setDateOfBirth(dob);
            employee.setDesignation(designation); 
            if (null != updatedAddresses) {
                List<Address> previousAddresses =
                                               employee.getAddresses();
                for (Address previousAddress : previousAddresses) {
                    for (Address updatedAddress : updatedAddresses) {
                        if (previousAddresses.indexOf(previousAddress) 
                            == updatedAddresses.
                            indexOf(updatedAddress)) {                
                            updatedAddress.setId(previousAddress.getId());
                        }
                    }
                }  
                employee.setAddresses(updatedAddresses);
                employeeDao.updateEmployee(employee);
            }
        }
    } 
    
    /**
     * Checking whether the employee id already exists in the employees list
     * @param employee id  
     *                        checks if Employee id already exists
     * @return true or false
     *                        if Employee id already exists, returns 
     *                        true otherwise false
     */ 
    private boolean isEmployeeIdExists(String employeeId) throws AppException {        
        return employeeDao.isRecordExists(employeeId);
    }
}     

