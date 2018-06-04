/*
 * Copyrights reserved
 * Demonstrate employee operations using a sample program
 */
package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ideas2it.common.Constant;
import com.ideas2it.dao.AddressDao;
import com.ideas2it.dao.EmployeeDao;
import com.ideas2it.dao.impl.AddressDaoImpl;
import com.ideas2it.dao.impl.EmployeeDaoImpl;
import com.ideas2it.exception.AppException;
import com.ideas2it.model.Address;
import com.ideas2it.model.Client;
import com.ideas2it.model.Employee;
import com.ideas2it.service.AddressService;
import com.ideas2it.service.ClientService;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.service.impl.AddressServiceImpl;
import com.ideas2it.service.impl.EmployeeServiceImpl;
import com.ideas2it.service.impl.ClientServiceImpl;
import com.ideas2it.util.CommonUtil;
import com.ideas2it.util.DateUtil;

/**
 * Implementing the basic operations performed on an employee table by using
 * direct access object, all validations and operations are 
 * performed in the service class and returned to controller. 
 *
 * @author manoj
 *
 * created on 06-07-2017
 */

public class AddressServiceImpl implements AddressService {
    private AddressDao addressDao;
    private EmployeeService employeeService;
    private ClientService clientService;
    
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    } 
    
    public void setAddressDao(AddressDao addressDao) {
        this.addressDao = addressDao;
    } 
    
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }    
   
    /*
     * @see com.ideas2it.service.AddressService #method addAddress
     *                                               (String, String, String, 
     *                                                String, String, String, 
     *                                                String, String, String, 
     *                                                String, String)
     */
    public boolean addAddress(String id, String addressType, String userType,
                                  String doorNumber, String street1, 
                                  String street2, String landmark, String city, 
                                  String state, String country, 
                                  String zipcode) throws AppException { 
        Address address = new Address(id, addressType, userType, doorNumber,
                                 street1, street2, landmark, city, state, 
                                 country, zipcode);
        if (userType.equals("client")) {
            Client client = clientService.searchClientById(id);
            address.setClient(client);
            return addressDao.insertAddressToClient(address);
        }
        Employee employee = employeeService.searchEmployeeById(id);
        address.setEmployee(employee);
        return addressDao.insertAddressToEmployee(address);
    }
    
    /*
     * @see com.ideas2it.service.AddressService #method getAllAddresses(String)
     * 
     */
    public List<Address> getAllAddresses(String userType)
                                             throws AppException {  
        if (userType == Constant.USER_TYPE_CLIENT) {
            return addressDao.retrieveAllClientAddresses();
        }
        return addressDao.retrieveAllEmployeeAddresses();
    }
   
    /*
     * @see com.ideas2it.service.AddressService #method deleteAddressById
     *                                              (String, String, String)
     * 
     */
    public boolean deleteAddressById(String id, String userType, 
                                         int addressId) throws 
                                         AppException {  
        if (userType == Constant.USER_TYPE_CLIENT) {
            Client client = clientService.searchClientById(id);
            if (client.getAddresses() != null) {
                for (Address address : client.getAddresses()) { 
                    if (address.getAddressId() == addressId) {
                        address.setClient(null);
                        address.setIsDeleted(true);
                    }
                }
            }
            return addressDao.deleteClientAddressById(client);
        }
        Employee employee = employeeService.searchEmployeeById(id);
        if (employee.getAddresses() != null) {
            for (Address address : employee.getAddresses()) { 
                if (address.getAddressId() == addressId) {
                    address.setEmployee(null);
                    address.setIsDeleted(true);
                }
            }
        }
        return addressDao.deleteEmployeeAddressById(employee);
    }
    
    /*
     * @see com.ideas2it.service.AddressService #method searchAddressById
     *                                              (String, String, String)
     * 
     */
    public Address searchAddressById(String id, String userType, 
                                         String addressType) throws 
                                         AppException {     
        if (userType.equals("client")) {
            return addressDao.retrieveClientAddressById(id,userType,
                                                            addressType);
        }
        Employee employee = employeeService.searchEmployeeById(id);
        return addressDao.retrieveEmployeeAddressById(employee, userType,
                                                              addressType);
    }
    
     public Address getAddressById(int addressId, String id, String userType) 
                                        throws AppException {     
        if (userType.equals("employee")) {
            Employee employee = employeeService.searchEmployeeById(id);
            for (Address address : employee.getAddresses()) {
                if (address.getAddressId() == addressId) {                                    
                    return address;
                }
            }
        }
        Client client = clientService.searchClientById(id);
        for (Address address : client.getAddresses()) {
            if (address.getAddressId() == addressId) {                                    
                return address;
            }
        }
        return null;
    }

    /*
     * @see com.ideas2it.service.AddressService #method updateAddressById
     *                                               (String, String, String, 
     *                                                String, String, String, 
     *                                                String, String, String, 
     *                                                String, String)
     */
    public boolean updateAddressById(int addressId, String id, String addressType,  
                                  String userType, String doorNumber, 
                                  String street1, String street2, 
                                  String landmark,String city, 
                                  String state, String country, 
                                  String zipcode) throws AppException {                           
        Address address = getAddressById(addressId, id, userType);
        if (null != address) {
            address.setAddressId(addressId);
            address.setDoorNumber(doorNumber);
            address.setStreet1(street1);
            address.setStreet2(street2);
            address.setLandmark(landmark);
            address.setCity(city);
            address.setState(state);
            address.setCountry(country);
            address.setZipcode(zipcode);  
        }                    
        if (userType.equals("client")) {
            return addressDao.updateClientAddressById(address);
        }
        return addressDao.updateEmployeeAddressById(address);
    }
}
