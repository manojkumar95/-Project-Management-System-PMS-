package com.ideas2it.model;

import java.util.List;

import com.ideas2it.model.Address;
import com.ideas2it.model.EmployeeHistory;
import com.ideas2it.model.Project;
import com.ideas2it.util.DateUtil;

/** pojo method to initialize and assign values to the employee table by
 *  using getters and setters
 */
public class Employee {
    private String id;
    private String emailId; 
    private String name;
    private String dateOfBirth;
    private String designation;
    private boolean isDeleted = false;
    private int age;
    private List<Address> addresses;
    private Project project;
    private List<EmployeeHistory> employeeHistories;
    
    public Employee() {
    }
    
    public Employee(String id, String emailId, String name, String dateOfBirth, 
                        String designation) {
        this.id = id;
        this.emailId = emailId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.designation = designation;
    } 
    
    /*
     * getters and setters
     */
    public String getId() {
        return this.id;
    }
    
    public List<EmployeeHistory> getEmployeeHistories() {
        return this.employeeHistories;
    }
    
    public void setEmployeeHistories(List<EmployeeHistory> employeeHistories) {
        this.employeeHistories = employeeHistories; 
    }
    
    public boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted; 
    }
    
    public String getEmailId() {
        return this.emailId;
    }
    
    public String getName() {
        return this.name;
    }
     
    public int getAge() {
        return this.age;
    }
    
    public String getDesignation() {
        return this.designation;
    }
    
     public String getDateOfBirth() {
        return this.dateOfBirth;
     }
    
    public List<Address> getAddresses() {
        return this.addresses;
    }
    
     public Project getProject() {
        return this.project;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }    
 
    public void setAge(String dateOfBirth) {
        this.age = DateUtil.calculateTimePeriod(dateOfBirth);
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.setAge(dateOfBirth);
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }  

    public void setEmailId(String emailId) {
        this.emailId =emailId;
    }
    
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    
    public void addAddress(Address address) {
        addresses.add(address);
    }
     
    public String toString()
    {
      return "Employee Id = " + id 
                 + " \nEmployee name = " + this.name 
                 + " \nEmployee mail id = " + this.emailId 
                 + " \nEmployee age = " + this.age
                 + " \nEmployee designation = " + this.designation   
                 + " \nEmployee Dob = " + this.dateOfBirth;
    }
}
