package com.ideas2it.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ideas2it.common.Constant;
import com.ideas2it.exception.AppException;
import com.ideas2it.logger.LoggerManager;

/**
 * Get a connection to database
 * @return Connection object
 */
public class ConnectionFactory {
	private String driverClassName = "com.mysql.jdbc.Driver";
	private final String connectionUrl = "jdbc:mysql://localhost:3306/Smartsheet"
	                            + "?autoReconnect=true&useSSL=false";
	private final String dbUser = "root";
	private final String dbPwd = "root";

	private static ConnectionFactory connectionFactory = null;
	private static Connection connection = null;
    
    /**
     * constructor to initialize and load the driver 
     */
	private ConnectionFactory() throws AppException {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException exception) {
		    LoggerManager.error(ConnectionFactory.class, Constant.
		                            CLASS_NOT_FOUND_EXCEPTION, exception);
            throw new AppException(Constant.
		                            CLASS_NOT_FOUND_EXCEPTION, exception);
		} 
	}
    
    /**
     * Get a connection to database
     * @return Connection object
     */
	public Connection getConnection() throws AppException {
	    try { 
		    connection = DriverManager.getConnection(connectionUrl, dbUser, 
		                                                               dbPwd);
	    } catch (SQLException exception) {
	        LoggerManager.error(ConnectionFactory.class, Constant.
                                    CONNECTION_NOT_FOUND_EXCEPTION, exception);
            throw new AppException(Constant.
		                            CONNECTION_NOT_FOUND_EXCEPTION, exception);
        }
    	return connection;
	}
    
    /**
     * Create a singleton instance to instantiate ConnectionFactory
     * @return instance of the class
     */
	public static ConnectionFactory getInstance() {
		if (null == connectionFactory) {
			connectionFactory = new ConnectionFactory();
		}
		return connectionFactory;
	}
	
	/**
     * Close the connection to database
     */
	public static void closeConnection() throws AppException {
	    try {
	        connection.close();
        } catch (SQLException exception) {
            LoggerManager.error(ConnectionFactory.class, Constant.
                                    CONNECTION_CLOSE_EXCEPTION, exception);
            throw new AppException(Constant.
		                            CONNECTION_CLOSE_EXCEPTION, exception);
		}
	}   
}
