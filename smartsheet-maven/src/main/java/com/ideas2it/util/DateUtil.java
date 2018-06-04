package com.ideas2it.util;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import com.ideas2it.common.Constant;
import com.ideas2it.exception.AppException;
import com.ideas2it.logger.LoggerManager;

/**
 * Utility to calculate the age of the person after getting the dob from user
 */
public class DateUtil {

    /**
     * <p>
     * calculating the age of the employee from the date of birth
     * </p>
     *
     * @param   dateOfBirth
     *                       gets the dob of employee
     * @return  age
     *              converts the dob and returns the age of employee
     *
     */ 
    public static int calculateTimePeriod(String dateOfBirth) throws AppException
    {       
        Period period;
        int periodDuration = 0;
        LocalDate birthDate = LocalDate.parse(dateOfBirth);
        LocalDate currentDate = LocalDate.now();
        if ((birthDate != null) && (currentDate != null)) {
            periodDuration = (int) Period.between(birthDate, currentDate)
                                                                .getYears(); 
        }
        return periodDuration;
    }
    
    /**
     * <p>
     * calculating the sanity and validation of the date
     * </p>
     *
     * @param date
     *              gets the dob of employee
     * @return boolean
     *              if the date is valid, returns true else false 
     *
     */ 
    public static boolean isValidDate(String date) throws AppException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.
                                                                  DATE_FORMAT);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date.trim());
        } catch (ParseException exception) {
            LoggerManager.error(DateUtil.class, exception);
            throw new AppException(Constant.VALIDATE_DATE_EXCEPTION, exception);   
        }
        return true;
  }
  
    public static Date getCurrentDate() {
        Date todayDate = new Date();
        return todayDate;
    }
}    
