/*
 * Copyrights reserved
 * Demonstrate address operations using a sample program
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
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ideas2it.common.Constant;
import com.ideas2it.connection.ConnectionFactory;
import com.ideas2it.connection.HibernateSessionFactory;
import com.ideas2it.dao.AddressDao;
import com.ideas2it.exception.AppException;
import com.ideas2it.logger.LoggerManager;
import com.ideas2it.model.Employee;
import com.ideas2it.model.Address;
import com.ideas2it.model.Client;

/**
 * Implementing the basic operations performed on an address table by using
 * direct access object to link model class with the database, all validations 
 * and operations are performed in the service class and returned to 
 * controller. 
 *
 * @author manoj
 *
 * created on 06-07-2017
 */
public class AddressDaoImpl implements AddressDao {  
    private final String DOOR_NUMBER = "door_number";
    private final String ADDRESS_TYPE = "address_type";
    private final String USER_TYPE = "user_type";
    private final String STREET1 = "street_1";
    private final String STREET2 = "street_2";
    private final String LANDMARK = "landmark";
    private final String STATE = "state";
    private final String COUNTRY = "country";
    private final String CITY = "city"; 
    private final String ZIPCODE = "zipcode";
    private final String EMPLOYEE_ID = "employee_id";
    private final String CLIENT_ID = "client_id";
    private final String IS_DELETED =  "isDeleted";
    private final String DELETE_FILTER = "isDeletedFilter";
    private final String STATUS = "status";
    private final String ID = "id";
    private final String FROM_ADDRESS = "FROM Address";
    
    /**
     * Get a connection to database
     * @return Connection object
     */
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
    /**
     * @see package com.ideas2it.dao.impl #method insertEmployee(Address)
     */
    public boolean insertAddressToEmployee(Address address) 
                                                    throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.INSERT_EXCEPTION
                                        + address.getId(), exception);
            throw new AppException(Constant.INSERT_EXCEPTION
                                      + address.getId(), exception);
        } finally {
            session.close();
        }
        return true;
   }
    
    
    /**
     * @see package com.ideas2it.dao.impl #method insertAddressToClient(Address)
     */
    public boolean insertAddressToClient(Address address)
                                             throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(address);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.INSERT_EXCEPTION
                                        + address.getId(), exception);
            throw new AppException(Constant.INSERT_EXCEPTION
                                      + address.getId(), exception);
        } finally {
            session.close();
        }
        return true;
   }
    /**
     * @see package com.ideas2it.dao.impl #method updateClientAddressById
     *                                        (Address, String, String, String, 
     *                                         String)
     */
    public boolean updateClientAddressById(Address address) 
                                               throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(address);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.UPDATE_EXCEPTION
                                        + address.getId(), exception);
            throw new AppException(Constant.UPDATE_EXCEPTION
                                      + address.getId(), exception);
        } finally {
            session.close();
        }
        return true;
   }
 
    /**
     * @see package com.ideas2it.dao.impl #method updateEmployeeAddressById
     *                                        (Address, String, String, String)
     */
    public boolean updateEmployeeAddressById(Address address) 
                                                  throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Filter filter = session.enableFilter(DELETE_FILTER);
            filter.setParameter(STATUS, false);
            Transaction transaction = session.beginTransaction();
            session.update(address);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(AddressDaoImpl.class,
                                       Constant.UPDATE_EXCEPTION 
                                       + address.getId(), exception);
            throw new AppException(Constant.UPDATE_EXCEPTION + address.getId(),
                                                                  exception);
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see package com.ideas2it.dao.impl #method retrieveAllEmployeeAddresses()
     */
    public List<Address> retrieveAllEmployeeAddresses() 
                                                        throws AppException { 
        Address address = null;
        List<Address> addresses = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Filter filter = session.enableFilter(DELETE_FILTER);
            filter.setParameter(STATUS, false);                       
            String SQL_Query = FROM_ADDRESS;
            addresses = (List<Address>) session.createQuery(SQL_Query).list();
        }
        catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);            
        } finally {
            session.close();
        }
        return addresses;
    }
    
    /**
     * @see package com.ideas2it.dao.impl #method retrieveAllClientAddresses()
     */
    public List<Address> retrieveAllClientAddresses()
                                     throws AppException { 
        Address address = null;
        List<Address> addresses = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Filter filter = session.enableFilter(DELETE_FILTER);
            filter.setParameter(STATUS, false);                        
            String SQL_Query = FROM_ADDRESS;
            addresses = (List<Address>) session.createQuery(SQL_Query).list();
        }
        catch (HibernateException exception) {
            LoggerManager.error(EmployeeDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);            
        } finally {
            session.close();
        }
        return addresses;
    }
        
    /**
     * @see package com.ideas2it.dao.impl #method retrieveEmployeeAddressById
     *                                         (String, String, String)
     */
    public Address retrieveEmployeeAddressById(Employee employee,
                                                   String userType,
                                                   String addressType) 
                                                   throws AppException {
        Session session = null;
        Address address = null;
        List<Address> addresses = new ArrayList<Address>();
        try {
            session = sessionFactory.openSession();
            Filter filter = session.enableFilter(DELETE_FILTER);
            filter.setParameter(STATUS, false);
            Criteria crit = session.createCriteria(Address.class);
            crit.add(Restrictions.eq("userType", userType));
            crit.add(Restrictions.eq("employee", employee));
            crit.add(Restrictions.eq("addressType", addressType));
            addresses = crit.list();
            address = addresses.get(0);
        }
        catch (HibernateException exception) {
            LoggerManager.error(AddressDaoImpl.class,
                                        Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);          
        } finally {
            session.close();
        }
        return address;
    }
   
    
    /**
     * @see package com.ideas2it.dao.impl #method retrieveClientAddressById
     *                                         (String, String, String)
     */
    public Address retrieveClientAddressById(String id, String userType,
                                                 String addressType) throws
                                                 AppException {
        Session session = null;
        Address address = null;
        try {
            session = sessionFactory.openSession();
            Filter filter = session.enableFilter(DELETE_FILTER);
            filter.setParameter(STATUS, false);
            address = (Address)session.get(Address.class, id);
        }
        catch (HibernateException exception) {
            LoggerManager.error(AddressDaoImpl.class,
                                    Constant.DISPLAY_EXCEPTION, exception);
            throw new AppException(Constant.DISPLAY_EXCEPTION , exception);          
        } finally {
            session.close();
        }
        return address;
    }
      
    /**
     * @see package com.ideas2it.dao.impl #method deleteEmployeeAddressById
     *                                         (String, String, String)
     */
    public boolean deleteEmployeeAddressById(Employee employee) 
                                                 throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();                                                                
            session.update(employee);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(AddressDaoImpl.class,
                                       Constant.DELETE_EXCEPTION,
                                       exception);
            throw new AppException(Constant.DELETE_EXCEPTION , exception);            
        } finally {
            session.close();
        }
        return true;
    }
    
    /**
     * @see package com.ideas2it.dao.impl #method deleteClientAddressById
     *                                         (String, String, String)
     */
    public boolean deleteClientAddressById(Client client) 
                                               throws AppException {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        } catch (HibernateException exception) {
            LoggerManager.error(AddressDaoImpl.class,
                                    Constant.INSERT_EXCEPTION,
                                    exception);
            throw new AppException(Constant.INSERT_EXCEPTION, exception);            
        } finally {
            session.close();
        }
        return true;
    }
}
