package com.ideas2it.model;

import java.util.List;
import java.util.Date;

import com.ideas2it.model.Employee;
import com.ideas2it.model.Project;

/** pojo method to initialize and assign values to the employee table by
 *  using getters and setters
 */
public class EmployeeHistory {
    private int id;
    private Date createdDate; 
    private Date lastUpdated;
    private Employee employee;
    private Project project;
    
    public EmployeeHistory() {
    }
    
    public EmployeeHistory(Employee employee, Project project,
                                                   Date createdDate) { 
        this.createdDate = createdDate;
        this.lastUpdated = lastUpdated;
        this.employee = employee;
        this.project = project;
    } 
    
    public void setCreatedDate(Date startDate) {
        this.createdDate = createdDate;
    }
    
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public void setProject(Project project) {
        this.project = project;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return this.id;
    }
    
    public Date getCreatedDate() {
        return this.createdDate;
    }
     
    public Date getLastUpdated() {
        return this.lastUpdated;
    }
    
    public Employee getEmployee() {
        return this.employee;
    }
    
    public Project getProject() {
        return this.project;
    }
    
    public String toString()
    {
      return "Employee Id = " + employee.getId()
                 + " \nProject Id = " + project.getId();
    }
}       
