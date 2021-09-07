package com.ideas2it.model;

import com.ideas2it.model.Client;
import com.ideas2it.model.Employee;

import com.ideas2it.util.DateUtil;

/** pojo method to initialize and assign values to the Address table by
 *  using getters and setters
 */
public class Address {
    private String id;
    private String doorNumber;
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String country;
    private String zipcode;
    private String addressType;
    private String userType;
    private String landmark;
    private boolean isDeleted = false;;
    private int addressId;
    private Employee employee;
    private Client client;
        
    public Address() {
    }
    
    public Address(String id, String addressType, String userType, 
                       String doorNumber, String street1, String street2,
                       String landmark, String city, String state,
                       String country, String zipcode) {
        this.id = id;
        this.addressType = addressType;
        this.userType = userType;
        this.doorNumber = doorNumber;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
        this.landmark = landmark;
    }
        
    /*
     * getters and setters
     */
     
    public boolean getIsDeleted() {
        return isDeleted;
    }
    
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted; 
    }
     
    public String getId() {
        return this.id;
    }
    
    public int getAddressId() {
        return this.addressId;
    }
    
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    
    public String getAddressType() {
        return this.addressType;
    }
    
    public String getUserType() {
        return this.userType;
    }
    
    public String getDoorNumber() {
        return this.doorNumber;
    }
    
    public String getStreet1() {
        return street1;
    }
     
    public String getStreet2() {
        return this.street2;
    }
    
    public String getCity() {
        return this.city;
    }
    
    public String getState() {
        return this.state;
    }
    
    public String getCountry() {
        return this.country;
    }
    
    public String getZipcode() {
        return this.zipcode;
    }
    
    public String getLandmark() {
        return this.landmark;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }
    
    public void setUserType(String userType) {
        this.userType = userType;
    }
   
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }
    
    public void setStreet1(String street1) {
        this.street1 = street1;
    }
   
    public void setStreet2(String street2) {
        this.street2 = street2;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public void setState(String state) {
        this.state = state;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    
    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public Client getClient() {
        return this.client;
    }
    
    public String toString()
    {
      return " \nAddress DoorNumber = " + doorNumber 
                 + " \n AddressType = " + addressType 
                 + " \n UserType = " + userType 
                 + " \n street2 = " + street2 
                 + " \n landmark = " + landmark
                 + " \n city = " + city  
                 + " \n state = " + state
                 + " \n country = " + country
                 + " \n zipcode = " + zipcode
                 + " \n";
    }
}
