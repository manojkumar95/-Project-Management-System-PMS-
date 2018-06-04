package com.ideas2it.logger;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
* This is a Helper class that creates a logger for application logging
*/
public class LoggerManager {
   private static Logger logger;
   private static final String XMLFILE = "/log4j.xml";
   private static final String CURRENT_DIR = "user.dir";
   private static final String MESSAGE = "\nMessage        :";
   private static final String CLASSNAME = "\nClass Name     :";
      
   /**
    * <p>
    * Returns the Logger with the class Name appended
    * </p>
    * @param obj
    *                          the .class file for implementing logger is passed
    *                          as an parameter 
    * @return logger           Logger created for particular class
    */
    public static Logger getLogger(Class obj) {        
        logger = Logger.getLogger(obj.getClass());
        DOMConfigurator.configure(System.getProperty(CURRENT_DIR)
                                    + XMLFILE);    
        return logger;        
    }

   /**
    * <p>
    * Appends a debug message into the log file
    * </p>
    *
    * @param obj
    *                          the .class file for implementing logger is passed
    *                          as an parameter 
    * @param message            
    *                          appends the user message into the log file
    * @return logger           Logger created for particular class
    */
    public static void debug(Class obj, String message) {
        getLogger(obj).debug(message);
    }

   /**
    * <p>
    * Appends a info message into the log file
    * </p>
    *
    * @param obj
    *                          the .class file for implementing logger is passed
    *                          as an parameter 
    * @param message            
    *                          appends the user message into the log file
    * @param cause 
    *                          appends the cause of the exception               
    */
    public static void info(Class obj, String message, Throwable cause) {
       getLogger(obj).info(message, cause);
    }
    
  /**
    * <p>
    * Appends a error message into the log file
    * </p>
    *
    * @param obj
    *                          the .class file for implementing logger is passed
    *                          as an parameter 
    * @param message            
    *                          appends the user message into the log file
    * @param cause 
    *                          appends the cause of the exception             
    */
    public static void error(Class obj, String message, Throwable cause) {
       getLogger(obj).error(MESSAGE + message + CLASSNAME + obj);
    }
    
   /**
    * <p>
    * Appends a error message into the log file
    * </p>
    *
    * @param obj
    *                          the .class file for implementing logger is passed
    *                          as an parameter 
    * @param message            
    *                          appends the user message into the log file
    * @param cause 
    *                          appends the cause of the exception             
    */
    public static void error(Class obj,Throwable cause) {
        getLogger(obj).error(MESSAGE + cause + CLASSNAME + obj);
    }    
}
