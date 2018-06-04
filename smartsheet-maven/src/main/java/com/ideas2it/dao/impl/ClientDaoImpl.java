/*
 * Copyrights reserved
 * Demonstrate employee operations using a sample program
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
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.ClientDao;
import com.ideas2it.exception.AppException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Client;
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
public class ClientDaoImpl implements ClientDao {   
    private final String CLIENT_ID = "client_id";
    private final String CLIENT_NAME = "client_name";
    private final String CLIENT_MAIL_ID = "client_mail_id";
    private final String CLIENT_DESIGNATION = "client_designation";
    private final String IS_DELETED =  "isDeleted"; 
    private final String DELETE_FILTER = "isDeletedFilter";
    private final String STATUS = "status";
    private final String ID = "id";
    private final String WHERE = " WHERE "; 
    
    /**
     * Get a connection to database
     * @return Connection object
     */
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
    /**
     * @see package com.ideas2it.dao.impl #insertEmployee(Employee)
     */
    public boolean insertClient(Client client) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ClientDaoImpl.class,
                Constant.INSERT_EXCEPTION + client.getId(), exception);
            throw new AppException(Constant.INSERT_EXCEPTION
                                       + client.getId(), exception);
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see package com.ideas2it.dao.impl #updateEmployee(Employee)
     */
    public boolean updateClientById(Client client) throws AppException {
         Session session = null;
         try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ClientDaoImpl.class,
                Constant.INSERT_EXCEPTION + client.getId(), exception);
            throw new AppException(Constant.INSERT_EXCEPTION
                                       + client.getId(), exception);
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see package com.ideas2it.dao.impl #retrieveAllEmployees()
     */
    public List<Client> retrieveAllClients() throws AppException { 
         Session session = null;
         List<Client> clients = null;
         try {
            session = sessionFactory.openSession();                         
            Criteria crit = session.createCriteria(Client.class).
                               add(Restrictions.eq(IS_DELETED, false));
            clients = crit.list();
        }
        catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);            
        } finally {
            session.close();
        }
        return clients;
    }
    
    /**
     * @see package com.ideas2it.dao.impl #retrieveEmployee()
     */
    public Client retrieveClientById(String clientId) throws AppException {
        Session session = null;
        Client client = null;
        try {
            session = sessionFactory.openSession();
            Criteria crit = session.createCriteria(Client.class);
			crit.add(Restrictions.eq(ID, clientId));
			client = (Client) crit.uniqueResult();
        }
        catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);          
        } 
        return client;
    }
      
    /**
     * @see package com.ideas2it.dao.impl #deleteEmployeeById(String)
     */
    public boolean deleteClientById(String clientId) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Client client = (Client) session.get(Client.class, clientId);
            client.setIsDeleted(true);
            session.update(client);
            transaction.commit();      
        } catch (HibernateException exception) {
            LoggerManager.error(ClientDaoImpl.class,Constant.
                                        DELETE_EXCEPTION + clientId,
                                        exception);
            throw new AppException(Constant.DELETE_EXCEPTION + clientId
                                                , exception);                  
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao 
     *                    #method insertProjectByClient(String, Project)                                                     
     */
    public boolean insertProjectToClient(Client client) throws AppException {                                 
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class,
                                        Constant.INSERT_EXCEPTION 
                                        + client.getId(), exception);
            throw new AppException(Constant.INSERT_EXCEPTION
                                        + client.getId(), exception);
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see com.ideas2it.dao.Projectdao 
     *                    #method deleteProjectByClient(String, String)                                                     
     */
    public boolean deleteProjectByClient(Client client) throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction(); 
            session.update(client);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(ProjectDaoImpl.class,
                                        Constant.DELETE_EXCEPTION 
                                        + client.getId(), exception);
            throw new AppException(Constant.DELETE_EXCEPTION 
                                       + client.getId(), exception);
        } finally {
            session.close();
        }
        return true;                                         
    }
    
    /**
     * @see package com.ideas2it.dao.impl #isRecordExists(String)
     */
    public boolean isRecordExists(String clientId) throws AppException {
         Session session = null;
         boolean recordFound =  false;
         try {           
            session = sessionFactory.openSession();
            Criteria criteria = session.createCriteria(Client.class);
            criteria.add(Restrictions.eq(ID, clientId));
            criteria.setProjection(Projections.rowCount());
            long count = (Long) criteria.uniqueResult(); 
            if (count != 0) {
                recordFound = true;
            }                
        } catch (HibernateException exception) {
            LoggerManager.error(ClientDaoImpl.class,Constant.
                                       EMPLOYEE_RECORD_NOT_FOUND_EXCEPTION 
                                       + clientId, exception);
            throw new AppException(Constant.EMPLOYEE_RECORD_NOT_FOUND_EXCEPTION 
                                       + clientId, exception); 
        } finally {
            session.close();
        }
        return recordFound;
    }              
}
