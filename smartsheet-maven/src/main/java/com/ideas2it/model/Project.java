package com.ideas2it.model;

import java.util.List;

import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeHistory;
import com.ideas2it.model.Client;

/** pojo method to initialize and assign values to the employee table by
 *  using getters and setters
 */
public class Project {
    private String id;
    private String title; 
    private String startDate;
    private String endDate;
    private boolean isDeleted = false;
    private Client client;
    private List<Employee> employees;
    private List<EmployeeHistory> employeeHistories;
    
    public Project() {
    }
    
    public Project(String id, String title, String startDate, String endDate, 
                       Client client) { 
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
        this.client = client;
    } 
    
    public Project(String id, String title, String startDate, String endDate) { 
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    } 
    
    /*
     * getters and setters
     */
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
    
    public Client getClient() {
        return this.client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getStartDate() {
        return this.startDate;
    }
     
    public String getEndDate() {
        return this.endDate;
    }
    
    public List<Employee> getEmployees() {
        return this.employees;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
    
    public void addEmployeeHistory(EmployeeHistory employeeHistory) {
        employeeHistories.add(employeeHistory);
    }
    
    public String toString()
    {
      return "Project Id = " + id 
                 + " \nProject name = " + title 
                 + " \nProject start date = " + startDate 
                 + " \nProject end date = " + endDate;
    }
}
