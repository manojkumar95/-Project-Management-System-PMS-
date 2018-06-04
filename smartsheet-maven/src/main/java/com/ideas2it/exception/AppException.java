package com.ideas2it.exception;

import java.lang.Exception;

/**
 * Customize the exceptions occuring in db connection as a user defined 
 * AppException
 */
public class AppException extends RuntimeException {
    private String message = null;
    
    public AppException(String message) {
        super(message);
    }
    
    public AppException(String message, Throwable cause) {
        super(message, cause);
    }
    
    
    public AppException (Throwable cause) {
        super (cause);
    }
    
    public String toString() {
        return message;
    }
    
    public String getMessage() {
        return message;
    }
}
