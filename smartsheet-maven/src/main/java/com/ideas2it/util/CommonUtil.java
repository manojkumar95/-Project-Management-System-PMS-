package com.ideas2it.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * contains the methods for string, character and number validation
 * created on 10/07/2017
 */
public class CommonUtil {
	 private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
     private static final String NUMBER_PATTERN = "^[0-9]+";
     private static final String WORD_PATTERN = "^[a-zA-Z]+";
	 private static final String DATE_FORMAT = "(19[0-9][0-9]|20[0-9][0-9])"
	                                          + "(0[1-9]|1[012])+-"
	                                          + "(0[1-9]|[12][0-9]|3[01])+-";                                             
	
	/**
	 * <p>
	 * Validating the mail id
	 * </p>
	 *
	 * @params matchfinder
     *                      gets the mailid from the user and validates mail
	 *                       format
	 * @returns the boolean value true if given value consists of only 
	 *                          numerical characters else returns value is false
	 */
	public static boolean isValidMailFormat(String matchfinder) {
		return isValidFormat(EMAIL_PATTERN, matchfinder);
    }
    
    /**
     * <p>
	 * Validating the character fields
	 * </p>
	 *
	 * @params matchfinder
	 *                       gets the string from the user and checks if string
	 *                       contains only characters
	 * @returns the boolean value true if given value consists of only 
	 *                                   characters else returns value is false
	 */
    public static boolean isString(String matchfinder) {
       return isValidFormat(WORD_PATTERN, matchfinder);
    }
    
    /**
     * <p>
	 * Validating the numerical characters
	 * </p>
	 *
	 * @params matchfinder
     *                      gets the string from the user and checks if
	 *                      input consists only digits
	 * @returns the boolean value true if given value consists of only 
	 *                          numerical characters else returns value is false
	 */
    public static boolean isNumerical(String matchfinder) {
        return isValidFormat(NUMBER_PATTERN, matchfinder);
    }
    
    /**
	 * Validating the date format
	 * @params matchfinder
	 *                      gets the date from the user and validates date
	 *                      format
	 * @returns the boolean value true if given date is in yyyy-mm-dd format 
	 *                          then returns true else return value is false
	 */
    public static boolean isValidDateFormat(String matchfinder) {
        return isValidFormat(DATE_FORMAT, matchfinder);
    }
    
    /**
     * <p>
	 * Validating the format
	 * </p>
	 *
	 * @params format
	 *                      gets the format that needs to be matched with the
	 *                      given string (ex: [A-Z] checks for letters between 
	 *                      A-Z in uppercase)
	 * @params matchfinder
	 *                      gets the string from the user and validates with the
	 *                      format
	 * @returns the boolean value true if given string is in correct format 
	 *                       then returns true else return value is false
	 */
    public static boolean isValidFormat(String format, String matchfinder) {
        Pattern pattern;
	    Matcher matcher; 
        if ((null != format) && (null != matchfinder)) {
            pattern = Pattern.compile(format);
		    matcher = pattern.matcher(matchfinder);
		    return matcher.matches();
		}
		return false;
    }
}    
