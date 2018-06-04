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
import com.ideas2it.dao.EmployeeHistoryDao;
import com.ideas2it.exception.AppException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeHistory;
import com.ideas2it.model.Project;
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
public class EmployeeHistoryDaoImpl implements EmployeeHistoryDao { 
    
    /**
     * <p> 
     * Get a connection to database
     * </p>
     * 
     * @return Connection object
     */
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
    /**
     * @see package com.ideas2it.dao.impl #retrieveEmployee()
     */   
    public List<EmployeeHistory> retrieveAllEmployeesHistory()
                                            throws AppException {
         Session session = null;
         List<EmployeeHistory> employeeHistories = null;
         try {
            session = sessionFactory.openSession();                         
            Criteria crit = session.createCriteria(EmployeeHistory.class);
            employeeHistories = crit.list();
        }
        catch (HibernateException exception) {
            LoggerManager.error(EmployeeHistoryDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);            
        } finally {
            session.close();
        }
        return employeeHistories;    
    }
    
    /**
     * @see package com.ideas2it.dao.impl #retrieveEmployee()
     */
    public void insertEmployeeHistory(EmployeeHistory employeeHistory) 
                                   throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(employeeHistory);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(EmployeeHistoryDaoImpl.class,
                                        Constant.INSERT_EXCEPTION, exception);
            throw new AppException(Constant.INSERT_EXCEPTION, exception);
        } finally {
            session.close();
        }                                  
    }
    
    /**
     * @see package com.ideas2it.dao.impl #retrieveEmployee()
     */
    public void updateEmployeeHistory(EmployeeHistory employeeHistory)
                                   throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(employeeHistory);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(EmployeeHistoryDaoImpl.class,
                                        Constant.INSERT_EXCEPTION, exception);
            throw new AppException(Constant.INSERT_EXCEPTION, exception);
        } finally {
            session.close();
        }                                  
    }                  
    
    /**
     * @see package com.ideas2it.dao.impl #retrieveEmployee()
     */
    public EmployeeHistory retrieveEmployeeHistory(String projectId, String employeeId) 
                                                       throws AppException {
        Session session = null;
        EmployeeHistory employeeHistory = null;       
        List<EmployeeHistory> employeeHistories = null ;
        try {
            session = sessionFactory.openSession();
            employeeHistories =
               session.createQuery("from EmployeeHistory e where e.employee.id = :empid"
         + " and e.project.id = :projid")
               .setString("projid", projectId)
               .setString("empid", employeeId)
               .list();
           if (employeeHistories.size() > 0) {
               employeeHistory = employeeHistories.get(0);
           } 
        }
        catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);          
        } finally {
            session.close();
        }
        return employeeHistory;
    }
}
