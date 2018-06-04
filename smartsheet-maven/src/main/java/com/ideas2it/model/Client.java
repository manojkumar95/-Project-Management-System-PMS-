package com.ideas2it.model;

import java.util.List;

import com.ideas2it.model.Address;
import com.ideas2it.model.Project;

/** pojo method to initialize and assign values to the Client table by
 *  using getters and setters
 */
public class Client {
    private String id;
    private String emailId; 
    private String name;
    private String designation;
    private boolean isDeleted = false;
    private List<Address> addresses;
    private List<Project> projects;
    
    public Client () {
    }
    
    public Client(String id, String emailId, String name, String designation) {
        this.id = id;
        this.emailId = emailId;
        this.name = name;
        this.designation = designation;
    }
    
    /*
     * getters and setters
     */
    public String getId() {
        return this.id;
    }
    
    public String getEmailId() {
        return this.emailId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDesignation() {
        return this.designation;
    }
    
    public boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted; 
    }
    
    public List<Address> getAddresses() {
        return this.addresses;
    }
    
    public List<Project> getProjects() {
        return this.projects;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public void setId(String id) {
        this.id=id;
    }
 
    public void setEmailId(String emailId) {
        this.emailId =emailId;
    }
    
    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
    
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    
    public void addAddress(Address address) {
        addresses.add(address);
    }
    
    public void addProject(Project project) {
        projects.add(project);
    }
    
    public String toString()
    {
      return "Client Id = " + id 
                 + " \nClient name = " + name 
                 + " \nClient mail id = " + emailId 
                 + " \nClient designation = " + designation;
    }
}
