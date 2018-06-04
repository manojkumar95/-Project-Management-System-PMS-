/*
 * Copyrights reserved
 * Demonstrate project operations using a sample program
 */
package com.ideas2it.dao.impl;

import java.util.ArrayList;
import java.util.List;

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

import com.ideas2it.common.Constant;
import com.ideas2it.connection.ConnectionFactory;
import com.ideas2it.connection.HibernateSessionFactory;
import com.ideas2it.dao.ProjectDao;
import com.ideas2it.exception.AppException;
import com.ideas2it.logger.LoggerManager;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Project;

/**
 * Implementing the basic operations performed on an project table by using
 * direct access object to link model class with the database, all validations 
 * and operations are performed in the service class and returned to 
 * controller. 
 *
 * @author manoj
 *
 * created on 06-07-2017
 */
public class ProjectDaoImpl implements ProjectDao { 
    private final String EMP_ID = "employee_id";
    private final String CLIENT_ID = "client_id";
    private final String EMP_NAME = "employee_name";
    private final String EMP_MAIL_ID = "employee_mail_id";
    private final String EMP_DESIGNATION = "employee_designation";
    private final String EMP_DOB = "employee_dob";
    private final String EMP_SALARY = "employee_salary";   
    private final String PROJ_ID = "project_id";
    private final String PROJ_TITLE = "project_title";
    private final String PROJ_START_DATE = "project_start_date";
    private final String PROJ_END_DATE = "project_end_date"; 
    private final String IS_DELETED =  "isDeleted";
    private final String DELETE_FILTER = "isDeletedFilter";
    private final String STATUS = "status";
    private final String ID = "id";
    private static final String UNASSIGNED_EMPLOYEE_QUERY = "from Employee e "
                                              + "where size(e.projects) = 0";
	
	/**
     * Get a connection to database
     * @return Connection object
     */
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

    /**
     * @see com.ideas2it.dao.Projectdao #method insertProject(Project)
     */ 
    public boolean insertProject(Project project) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(project);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class,
                                         Constant.INSERT_EXCEPTION 
                                          + project.getId(), exception);
            throw new AppException(Constant.INSERT_EXCEPTION 
                                           + project.getId(), exception);
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao #method updateProject(Project)
     */ 
    public boolean updateProject(Project project) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(project);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class,
                                         Constant.INSERT_EXCEPTION 
                                          + project.getId(), exception);
            throw new AppException(Constant.INSERT_EXCEPTION 
                                           + project.getId(), exception);
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao #method retrieveAllProjects()
     */ 
    public List<Project> retrieveAllProjects() throws AppException {
        List<Project> projects = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();                         
            Criteria crit = session.createCriteria(Project.class).
                                add(Restrictions.eq(IS_DELETED, false));
            projects = crit.list();
        }
        catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);            
        } finally {
            session.close();
        }
        return projects;
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao #method retrieveProject(String)
     */ 
    public Project retrieveProject(String projectId) throws AppException {
        Project project = null;
        Session session = null;
        try { 
            session = sessionFactory.openSession();
            Filter filter = session.enableFilter(DELETE_FILTER);
            filter.setParameter(STATUS, false);   
            project = (Project)session.get(Project.class, projectId);
        }
        catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);          
        } finally {
            session.close();
        }
        return project;
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao #method deleteProjectById(String)
     */ 
    public boolean deleteProjectById(Project project) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            project.setIsDeleted(true);
            project.setEmployees(null);
            session.update(project);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ClientDaoImpl.class,Constant.
                                        DELETE_EXCEPTION + project.getId(),
                                        exception);
            throw new AppException(Constant.DELETE_EXCEPTION + project.getId(),
                                                                  exception);                  
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao #method insertEmployeeToProject(String, 
     *                                                               String)
     */
    public void insertEmployeeToProject(Project project) throws
                                               AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(project);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class, Constant.
                                        EMPLOYEE_RECORD_NOT_FOUND_EXCEPTION 
                                        + project.getId(), exception);
            throw new AppException(Constant.EMPLOYEE_RECORD_NOT_FOUND_EXCEPTION 
                                      + project.getId(), exception);
        } finally {
            session.close();
        }
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao #method insertClientToProject(Project)                                                               String)
     */
    public void insertClientToProject(Project project) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(project);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class,
                                        Constant.INSERT_EXCEPTION 
                                        + project.getId(), exception);
            throw new AppException(Constant.INSERT_EXCEPTION
                                        + project.getId(), exception);
        } finally {
            session.close();
        }
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao #method deleteEmployeeFromProject 
     *                                       (String, String)
     */
    public boolean deleteEmployeeFromProject(Employee employee) 
                                                throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction(); 
            session.update(employee);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class,
                                        Constant.DELETE_EXCEPTION 
                                         + employee.getId(), exception);
            throw new AppException(Constant.DELETE_EXCEPTION 
                                          + employee.getId(), exception);
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao #method isProjectRecordExists(String)                                                                 
     */
    public boolean isProjectRecordExists(String projectId) throws 
                                                 AppException {
        Session session = null;
        boolean recordFound = false;
        try {      
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Project.class);
            criteria.add(Restrictions.eq(ID, projectId));
            criteria.setProjection(Projections.rowCount());
            long count = (Long) criteria.uniqueResult();
            if (count != 0) {
               recordFound = true;
            }                
        } catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class, Constant.
                                        PROJECT_RECORD_NOT_FOUND_EXCEPTION
                                        + projectId, exception);
            throw new AppException(Constant.PROJECT_RECORD_NOT_FOUND_EXCEPTION 
                                       + projectId, exception);
        } finally {
            session.close();
        }
        return recordFound;
    }   
    
    /**
     * @see com.ideas2it.dao.Projectdao #method isEmployeeRecordExists(String)                                                                 
     */
    public boolean isEmployeeRecordExists(String employeeId) throws 
                                                 AppException {
        Session session = null;
        boolean recordFound =  false;
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
          
    /**
     * @see com.ideas2it.dao.Projectdao 
     *                    #method retrieveEmployeesNotAssignedToProjects()                                                     
     */
    public List<Employee> retrieveEmployeesNotAssignedToProjects() throws 
                            AppException {
        Session session = null;                                         
        List<Employee> employees = new ArrayList<Employee>();
        try {  
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq(IS_DELETED, false));
            criteria.add(Restrictions.isNull("project"));
            employees = (List<Employee>)criteria.list();      
        } catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION, exception);
        } finally {
            session.close();
        }
        return employees;
    } 
}
