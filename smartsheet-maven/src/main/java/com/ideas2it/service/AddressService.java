package com.ideas2it.service;

import java.util.List;

import com.ideas2it.model.Address;
import com.ideas2it.model.Employee;
import com.ideas2it.exception.AppException;

public interface AddressService {
    
    /**
     * <p>
     * Adding details of a employee using the direct access object
     * </p>
     * @param id                
     *                            unique id to find, search and update the 
     *                            address details of the user
     * @param addressType
     *                            addressType to differentiate the type of 
     *                            address example: office/home)
     * @param userType
     *                            userType to identify the type of user
     *                            (example: client/employee)
     * @param doorNumber              
     *                            doorNumber to store in corresponding userId
     * @param street1            
     *                            street1 to store in corresponding userId
     * @param street2               
     *                            street2 to store in corresponding userId
     * @param landmark               
     *                            landmark to store in corresponding userId
     * @param city               
     *                            city to store in corresponding userId
     * @param state               
     *                            state to to store in corresponding userId
     * @param country               
     *                            country to to store in corresponding userId
     * @param zipcode               
     *                            zipcode to to store in corresponding userId
     * @return true or false
     *                            if address details are valid the details are
     *                            added to list and returns true otherwise false
     * @throws AppException if insert query fails to find address record
     */
    boolean addAddress(String id, String addressType, String userType,
                                  String doorNumber, String street1, 
                                  String street2,String landmark, String city, 
                                  String state, String country, 
                                  String zipcode) throws AppException;
                                  
    /**
     * <p>
     * Getting ID details isValidEmployeeDetailof employee
     * Removing the employee details from the list
     * </p>
     *
     * @param userType                
     *                        display all address records based on userType
     *                        (example: displays all the employee records if 
     *                        usertype is employee)
     * return List            
     *                        returns list of addresses for a particular 
     *                        userType, if no details are present then return 
     *                        null
     * @throws AppException if select query fails to find address record
     */  
    List<Address> getAllAddresses(String userType) throws AppException;
    
    /**
     * <p>
     * Getting ID details isValidEmployeeDetailof employee
     * Removing the employee details from the list
     * </p>
     *
     * @param userType                
     *                           delete the address record for the particular Id
     * @param addressType
     *                           addressType to differentiate the type of 
     *                           address example: (office/home)
     * return boolean
     *                           returns true if address record is deleted,
     *                           otherwise false
     * @throws AppException if delete query fails to find address record
     */  
    boolean deleteAddressById(String id, String userType, 
                                         int addressId) 
                                         throws AppException;
    
    /**
     * <p>
     * Searching details of employee using the Employee Id
     * </p>
     * @param userType                
     *                        display the address record based on userType
     *                        (example: displays the employee record if 
     *                        usertype is employee)
     * @param addressType
     *                        addressType to differentiate the type of 
     *                        address example: (office/home)
     * return Address            
     *                        returns addresse object for a particular 
     *                        userType, if no details are present then return 
     *                        null
     * @throws AppException if search query fails to find address record
     */
    Address searchAddressById(String id, String userType, 
                                         String addressType) 
                                         throws AppException;
     
    /**
     * <p>
     * Searching details of employee using the Employee Id
     * </p>
     * @param userType                
     *                        display the address record based on userType
     *                        (example: displays the employee record if 
     *                        usertype is employee)
     * @param addressType
     *                        addressType to differentiate the type of 
     *                        address example: (office/home)
     * return Address            
     *                        returns addresse object for a particular 
     *                        userType, if no details are present then return 
     *                        null
     * @throws AppException if search query fails to find address record
     */                                     
    Address getAddressById(int addressId, String id, String userType) throws 
                                         AppException;
    
    /**
     * <p>
     * Updating details of a employee using the direct access object
     * </p>
     *
     * @param id                
     *                            unique id to find, search and update the 
     *                            address details of the user
     * @param addressType
     *                            addressType to differentiate the type of 
     *                            address example: office/home)
     * @param userType
     *                            userType to identify the type of user
     *                            (example: client/employee)
     * @param doorNumber              
     *                            doorNumber to store in corresponding userId
     * @param street1            
     *                            street1 to store in corresponding userId
     * @param street2               
     *                            street2 to store in corresponding userId
     * @param landmark               
     *                            landmark to store in corresponding userId
     * @param city               
     *                            city to store in corresponding userId
     * @param state               
     *                            state to to store in corresponding userId
     * @param country               
     *                            country to to store in corresponding userId
     * @param zipcode               
     *                            zipcode to to store in corresponding userId
     * @return true or false
     *                            if address details are valid the details are
     *                            added to list and returns true otherwise false
     * @throws AppException if update query fails to find address record
     */
    boolean updateAddressById(int addressId, String id, String addressType,  
                                  String userType, String doorNumber, 
                                  String street1, String street2, 
                                  String landmark,String city, 
                                  String state, String country, 
                                  String zipcode) throws 
                                  AppException;                           
}  

