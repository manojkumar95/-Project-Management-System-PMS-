package com.ideas2it.connection;
 
import org.hibernate.cfg.Configuration;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ideas2it.common.Constant;
import com.ideas2it.exception.AppException;
import com.ideas2it.logger.LoggerManager;

/**
 * <p>
 * Get a connection to hibernate
 * </p>
 */
public class HibernateSessionFactory {
    private static HibernateSessionFactory instance = null;
    private static SessionFactory sessionFactory;
    
    /**
     * <p>
     * constructor to initialize and configure the sessionFactory 
     * </p>
     */
    private HibernateSessionFactory() {
        try {     
            sessionFactory = new Configuration()
                                .configure("res/properties/hibernate.cfg.xml")
                                .buildSessionFactory();
        } catch (HibernateException exception) {
	        LoggerManager.error(ConnectionFactory.class, Constant.
                                    CONNECTION_NOT_FOUND_EXCEPTION, exception);
            throw new AppException(Constant.
		                            CONNECTION_NOT_FOUND_EXCEPTION, exception);
        }
    }
    
    /**
     * <p>
     * Get a connection to HibernateSessionFactory
     * </p>
     * @return instance object
     */
    public static HibernateSessionFactory getInstance() {
        if (instance == null) {
            instance  = new HibernateSessionFactory();
        }
        return instance;
   }
    
    /**
     * <p>
     * Get a connection to HibernateSessionFactory
     * </p>
     * @return sessionFactory 
     */
   public static SessionFactory getSessionFactory() { 
       return sessionFactory;
   }
 
    /**
     * Close the connection to database
     */
	public static void closeSessionFactory() throws AppException {
	    try {
	        if (sessionFactory != null) {  
	            sessionFactory.close();
	        }
        } catch (HibernateException exception) {
            LoggerManager.error(ConnectionFactory.class, Constant.
                                    CONNECTION_CLOSE_EXCEPTION, exception);
            throw new AppException(Constant.
		                            CONNECTION_CLOSE_EXCEPTION, exception);
		}
	} 
}   
