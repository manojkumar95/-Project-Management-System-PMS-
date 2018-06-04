/*
 * Copyrights reserved
 * Demonstrate employee operations using a sample program
 */
package com.ideas2it.dao.impl;

import org.hibernate.cfg.Configuration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Filter;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.common.Constant;
import com.ideas2it.connection.ConnectionFactory;
import com.ideas2it.connection.HibernateSessionFactory;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.exception.AppException;
import com.ideas2it.model.Employee;
import com.ideas2it.logger.LoggerManager;

/**
 * Implementing the basic operations performed on an employee table by using
 * direct access object to link model class with the database, all validations 
 * and operations are performed in the service class and returned to 
 * controller. 
 *
 * @author manoj
 *
 * created on 06-07-2017
 */
public class EmployeeDaoImpl implements EmployeeDao { 
    private final String EMP_ID = "employee_id";
    private final String EMP_NAME = "employee_name";
    private final String EMP_MAIL_ID = "employee_mail_id";
    private final String EMP_DESIGNATION = "employee_designation";
    private final String EMP_DOB = "employee_dob";
    private final String IS_DELETED =  "isDeleted"; 
    private final String DELETE_FILTER = "isDeletedFilter";
    private final String STATUS = "status";
    private final String ID = "id";
    
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
    /**
     * @see package com.ideas2it.dao.impl #insertEmployee(Employee)
     */
    public void insertEmployee(Employee employee) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.INSERT_EXCEPTION
                                        + employee.getId(), exception);
            throw new AppException(Constant.INSERT_EXCEPTION
                                      + employee.getId(), exception);
        } finally {
            session.close();
        }                                
    }
    
    
    /**
     * @see package com.ideas2it.dao.impl #updateEmployee(Employee)
     */
    public void updateEmployee(Employee employee) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();                          
            session.update(employee);
            transaction.commit();
        } catch (HibernateException exception) {
           LoggerManager.error(EmployeeDaoImpl.class, Constant.UPDATE_EXCEPTION
                                       + employee.getId(), exception);
           throw new AppException(Constant.UPDATE_EXCEPTION
                                      + employee.getId(), exception);
        } finally {
            session.close();
        }     
    }
    
    /**
     * @see package com.ideas2it.dao.impl #retrieveAllEmployees()
     */
    public List<Employee> retrieveAllEmployees() throws AppException { 
        List<Employee> employees = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();                        
            Criteria crit = session.createCriteria(Employee.class).
                                        add(Restrictions.eq(IS_DELETED, false));
            employees = crit.list();
        }
        catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);            
        } finally {
            session.close();
        }
        return employees;
    } 
    
    /**
     * @see package com.ideas2it.dao.impl #retrieveEmployee()
     */
    public Employee retrieveEmployee(String employeeId) throws AppException {
        Session session = null;
        Employee employee = null;
        try {
            session = sessionFactory.openSession();
            Filter filter = session.enableFilter(DELETE_FILTER);
            filter.setParameter(STATUS, false);
            employee = (Employee)session.get(Employee.class, employeeId);
        }
        catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);          
        } finally {
            session.close();
        }
        return employee;
    } 
      
    /**
     * @see package com.ideas2it.dao.impl #deleteEmployeeById(String)
     */
    public void deleteEmployeeById(String employeeId) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, 
                                                                  employeeId);
            employee.setIsDeleted(true);
            session.update(employee);
            transaction.commit();            
        } catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.DELETE_EXCEPTION 
                                        + employeeId, exception);
            throw new AppException(Constant.DELETE_EXCEPTION + employeeId 
                                                                 , exception);          
        } finally {
            session.close();
        }
    }
    
    /**
     * @see package com.ideas2it.dao.impl #isRecordExists(String)
     */
    public boolean isRecordExists(String employeeId) throws AppException {
        boolean recordFound =  false;
        Session session = null;
        try {      
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq(ID, employeeId));
            criteria.setProjection(Projections.rowCount());
            long count = (Long) criteria.uniqueResult();
            if (count != 0) {
               recordFound = true;
            }
        }
        catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class, Constant.
                                        EMPLOYEE_RECORD_NOT_FOUND_EXCEPTION
                                        + employeeId, exception);
            throw new AppException(Constant.EMPLOYEE_RECORD_NOT_FOUND_EXCEPTION
                                               + employeeId , exception);
        } finally {
            session.close();
        }
        return recordFound;
    }           
}
