package com.ideas2it.common;

/**
 * contains the methods for storing string patterns and constants which can be 
 * reused in different user views 
 * created on 10/07/2017
 */
 public class Constant {
    public static final String YES = "y";
    public static final String DISPLAY_ID = "ProjectID = ";
    public static final String DISPLAY_TITLE = "ProjectTitle = ";
    public static final String DISPLAY_START_DATE = "Project Start Date = ";
    public static final String DISPLAY_END_DATE = "Project End Date = ";
    public static final String DISPLAY_EMPLOYEE_ID = "Employee ID = ";
    public static final String DISPLAY_EMPLOYEE_NAME = "Employee Name = ";
    
    public static final String GET_TITLE = "Enter project title:";   
    public static final String GET_ID = "Enter project id:";
    public static final String GET_START_DATE = "Enter project start date"
                                                     + "in yyyy-MM-dd";
    public static final String GET_END_DATE = "Enter project end date:"
                                                     + "in yyyy-MM-dd:";
    public static final String REMOVE_BY_ID = "Enter id to remove:";
    public static final String SEARCH_BY_ID = "Enter id to search";
    public static final String UPDATE_BY_ID = "Enter id to be updated";
    
    public static final String UPDATE_NEW_DOB = "Enter new project title:";
    public static final String UPDATE_NEW_ID = "Enter new project id:";
    public static final String UPDATE_NEW_NAME = "Enter new project start " 
                                                    + "date in yyyy-MM-dd:";
    public static final String UPDATE_NEW_EMPLOYEE_DOB = "Enter new employee "
                                                            + "dob in "
                                                            + "yyyy-MM-dd:";
    public static final String UPDATE_NEW_EMPLOYEE_ID = "Enter new employee "
                                                            + "id:";
    public static final String UPDATE_NEW_EMPLOYEE_NAME = "Enter new employee "
                                                            + "name:";
    public static final String UPDATE_NEW_EMPLOYEE_DESIGNATION = "Enter new "
                                                    + "employee designation";
    public static final String UPDATE_NEW_EMPLOYEE_MAILID = "Enter new employee"
                                                            + "mailId:";
    public static final String UPDATE_NEW_CLIENT_ID = "Enter new employee "
                                                            + "id:";
    public static final String UPDATE_NEW_CLIENT_NAME = "Enter new employee "
                                                            + "name:";
    public static final String UPDATE_NEW_CLIENT_DESIGNATION = "Enter new "
                                                    + "employee designation";
    public static final String UPDATE_NEW_CLIENT_MAILID = "Enter new employee"
                                                            + "mailId:";
    public static final String UPDATE_NEW_CLIENT_SALARY = "Enter new employee"
                                                            + " salary:";
    public static final String UPDATE_NEW_DESIGNATION = "Enter new project end "
                                                           + "date:"; 
    public static final String FAIL_EMPLOYEE_STATUS = "Failed to add employees";   
    public static final String ADD_EMPLOYEE = "Enter employee to add in" 
                                                 + "project:";
    public static final String REMOVE_EMPLOYEE = "Enter employee to remove from"
                                                 + "project:";    
    public static final String LISTOFCHOICES = "1.Add projects\n"
                                   + "2.Display All Projects \n"
                                   + "3.Delete projects \n"
                                   + "4.View project Details\n"
                                   + "5.Modify project Details\n"
                                   + "6.Add Employee to Project\n"
                                   + "7.Remove Employee from Project\n"
                                   + "8.View all employees in project\n"
                                   + "9.View employees assigned in projects\n"
                                   + "10.View employees not assigned in" 
                                   + " projects\n"
                                   + "11.Create Employee and add to projects\n"
                                   + "12.Exit";
    public static final String EMPLOYEE_LISTOFCHOICES = 
                                            "1.Add Employee Details \n"
                                          + "2.Display Employee Details\n"
                                          + "3.Delete Employee Details\n"
                                          + "4.Search Employee Details\n"
                                          + "5.Update Employee Details\n"
                                          + "6.View All Employees History\n"
                                          + "7.View particular Employee "
                                          + "History\n"
                                          + "8.Exit";
    public static final String CLIENT_LISTOFCHOICES = 
                                            "1.Add CLIENT Details \n"
                                          + "2.Display CLIENT Details\n"
                                          + "3.Delete CLIENT Details\n"
                                          + "4.Search CLIENT Details\n"
                                          + "5.Update CLIENT Details\n"
                                          + "6.Create project to client\n"
                                          + "7.View Project By client\n"
                                          + "8.Delete Project By client\n"
                                          + "9.Exit";                                          
    public static final String ADDRESS_LISTOFCHOICES_ADD = "enter your choice:"
                               + "\n 1. Add the basic employee information:"
                               + "\n 2. Add the address details:"
                               + "\n 3. Go to main menu";                               
    public static final String ADDRESS_LISTOFCHOICES_UPDATE = "enter your "
                               + "choice"
                               + "\n 1. Update the basic employee information:"
                               + "\n 2. Update the address details:"
                               + "\n 3. Go to main menu";   
    public static final String LIST_OF_MODULES = "enter your choice"
                               + "\n 1.Project Management"
                               + "\n 2.Employee Management"
                               + "\n 3.Client Management"
                               + "\n 4.Exit"; 
    public static final String WISH_TO_CONTINUE = "do u want to continue y/n";
    public static final String NO_EMPLOYEES_ASSIGNED = "No employees are "
                                                          + "assigned";       
    public static final String SUCCESS_CREATE = "Successfully created";                                 
    public static final String SUCCESS_UPDATE = "Successfully updated";
    public static final String SUCCESS_DELETE = "Successfully deleted";
    public static final String SUCCESS_EMPLOYEE = "Successfully added employees" 
                                                     + " to project";
    public static final String SUCCESS_REMOVE = "Successfully removed employees"
                                                   + " from project";
    public static final String INVALID_CREATE = "---Invalid details---or" 
                                                   + " Id already exists";
    public static final String INVALID_EMPLOYEE_CREATE = "---Invalid details---"
                                                            + "or Employee Id"
                                                            + " already exists";
    public static final String INVALID_STATUS = "---Invalid details---";
    public static final String INVALID_OPTION = "---Invalid option---";
    public static final String INVALID_ID = "---Invalid project id--";
    public static final String INVALID_NAME = "---Invalid name---";
    public static final String INVALID_REMOVE = "Failed to remove employees";
    public static final String INVALID_EMPLOYEE_ID = "---Invalid employee id--";
    public static final String INVALID_MAILID = "---Invalid employee mail id--";
    public static final String INVALID_AGE = "---Invalid age---";
    public static final String INVALID_SALARY = "---Invalid salary---";
    public static final String INVALID_DESIGNATION = "---Invalid designation--";
    
    public static final String REQUEST_NOT_PROCESSED = "User Request cannot be"
                                                        + "processed-Something"
                                                        + "went wrong!! Please"
                                                        + "try again";
    public static final String NO_MATCH_DELETE_STATUS = "No matching project id" 
                                                             + "Deletion"
                                                             + " Unsuccessful";
    public static final String NO_MATCH_UPDATE_STATUS = "No matching project id" 
                                                    + "Updation Unsuccessful";
    public static final String NO_MATCH_SEARCH_STATUS = "No matching project id" 
                                                    + "-Search Unsuccessful";
    public static final String NO_MATCH_DELETE_EMPLOYEE = "No matching employee" 
                                                  + " id-Deletion Unsuccessful";
    public static final String NO_MATCH_UPDATE_EMPLOYEE = "No matching employee" 
                                                   + "id-Updation Unsuccessful";
    public static final String NO_MATCH_SEARCH_EMPLOYEE = "No matching " 
                                                    + "employee id-Search "
                                                    + "Unsuccessful";
    public static final String NO_MATCH_DELETE_CLIENT = "No matching employee" 
                                                  + " id-Deletion Unsuccessful";
    public static final String NO_MATCH_UPDATE_CLIENT = "No matching employee" 
                                                   + "id-Updation Unsuccessful";
    public static final String NO_MATCH_SEARCH_CLIENT = "No matching " 
                                                    + "employee id-Search "
                                                    + "Unsuccessful";                                                        
    public static final String GET_EMPLOYEE_DOB = "Enter employee dob:"
                                                     + "in dd-mm-yyyy:";   
    public static final String GET_EMPLOYEE_ID = "Enter employee id:";
    public static final String GET_CLIENT_ID = "Enter Client id:";
    public static final String GET_EMPLOYEE_NAME = "Enter employee name:";
    public static final String GET_EMPLOYEE_DESIGNATION = "Enter employee "
                                                            + "designation:";
    public static final String GET_EMPLOYEE_MAILID = "Enter employee mailId:";
    public static final String GET_EMPLOYEE_SALARY = "Enter employee salary:";
    public static final String GET_CLIENT_NAME = "Enter client name:";
    public static final String GET_CLIENT_DESIGNATION = "Enter client "
                                                            + "designation:";
    public static final String GET_CLIENT_MAILID = "Enter client mailId:";
    public static final String NULL_POINTER = "No values are identified";
    public static final String INPUT_MISMATCH = "Input should be only of " 
                                                   + "integer type";
    public static final String NO_CONNECTION = "Connection not found";
    public static final String INSERT_EXCEPTION = "Error occured while "
                                                    + "performing insertion"
                                                    + " in id = ";
    public static final String UPDATE_EXCEPTION = "Error occured while "
                                                    + "performing updation"
                                                    + " in id = ";
    public static final String DISPLAY_EXCEPTION = "Error occured while "
                                                    + "performing display";
    public static final String DELETE_EXCEPTION = "Error occured while "
                                                    + "performing delete"
                                                    + " in id = ";
    public static final String SEARCH_EXCEPTION = "Error occured while "
                                                    + "performing search"
                                                    + " in id = ";
    public static final String DISPLAY_BY_ID_EXCEPTION = "Error occured while "
                                                    + "displaying a single "
                                                    + " employee record"
                                                    + " in id = ";
    public static final String EMPLOYEE_RECORD_NOT_FOUND_EXCEPTION = "Error "
                                                    + "occured while "
                                                    + "trying to find "
                                                    + "employee record"
                                                    + " in id = ";
    public static final String PROJECT_RECORD_NOT_FOUND_EXCEPTION = "Error "
                                                    + "occured while "
                                                    + "trying to find "
                                                    + "project record"
                                                    + " in id = ";
    public static final String CLASS_NOT_FOUND_EXCEPTION = "class not found "
                                                              + "exception "
                                                              + " occured";     
    public static final String CONNECTION_CLOSE_EXCEPTION = "exception "
                                                              + " occured"
                                                              + "while"
                                                              + "closing"
                                                              + "connection"; 
    public static final String CONNECTION_NOT_FOUND_EXCEPTION = "connection "
                                                            + "not found "
                                                            + "exception "
                                                            + "occured"; 
    public static final String CALCULATE_DATE_EXCEPTION = "connection "
                                                            + "not found "
                                                            + "exception "
                                                            + "occured"; 
    public static final String IO_EXCEPTION = "file not found exception "; 
    public static final String VALIDATE_DATE_EXCEPTION = "connection "
                                                            + "not found "
                                                            + "exception "
                                                            + "occured";  
    public static final String INVALID_CHOICE_VIEW_EXCEPTION = "Exception "
                                                            + "for invalid "
                                                            + "user choice";
                                                                                                                              
    public static final String GET_DOOR_NUMBER = "Enter the door number:";
    public static final String GET_STREET1 = "Enter the street1:";
    public static final String GET_STREET2 = "Enter the street2:";
    public static final String GET_CITY = "Enter the city:";
    public static final String GET_STATE = "Enter the state:";
    public static final String GET_COUNTRY = "Enter the country:";
    public static final String GET_ZIPCODE = "Enter the zipcode:";  
    public static final String GET_LANDMARK = "Enter the landmark:";   
    public static final String ADDRESS_TYPE = "Enter the address_type:"
                                                 + "\nenter o for office"
                                                 + "\nenter h for home";
    public static final String USER_TYPE_EMPLOYEE = "employee";  
    public static final String USER_TYPE_CLIENT = "client";
    public static final String DATE_FORMAT = "yyyy-MM-dd";  
    public static final String WISH_TO_ADD = "Do u want to add another address"
                                               + " y/n"; 
    public static final String WISH_TO_ADD_PROJECT = "Do u want to add another" 
                                               + " PROJECT y/n";                                 
}    
