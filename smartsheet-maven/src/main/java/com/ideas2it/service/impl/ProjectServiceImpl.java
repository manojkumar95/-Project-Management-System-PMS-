/*
 * Copyrights reserved
 * Demonstrate project operations using a sample program
 */
package com.ideas2it.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ideas2it.dao.ProjectDao;
import com.ideas2it.dao.impl.ProjectDaoImpl;
import com.ideas2it.exception.AppException;
import com.ideas2it.model.Employee;
import com.ideas2it.model.EmployeeHistory;
import com.ideas2it.model.Client;
import com.ideas2it.model.Project;
import com.ideas2it.service.ClientService;
import com.ideas2it.service.EmployeeService;
import com.ideas2it.service.EmployeeHistoryService;
import com.ideas2it.service.impl.EmployeeHistoryServiceImpl;
import com.ideas2it.service.impl.EmployeeServiceImpl;
import com.ideas2it.service.impl.ClientServiceImpl;
import com.ideas2it.service.ProjectService;
import com.ideas2it.util.CommonUtil;
import com.ideas2it.util.DateUtil;

/**
 * Implementing the basic operations performed on an project table by using
 * direct access object, all validations and operations are 
 * performed in the service class and returned to controller. 
 *
 * @author manoj
 *
 * created on 06-07-2017
 */
public class ProjectServiceImpl implements ProjectService {
    private ProjectDao projectDao; 
    private EmployeeService employeeService;
    private ClientService clientService;
    private EmployeeHistoryService employeeHistoryService;
    
    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    } 
    
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    } 
    
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    } 
    
    public void setEmployeeHistoryService(EmployeeHistoryService 
                                             employeeHistoryService) {
        this.employeeHistoryService = employeeHistoryService;
    } 
    
    
    
    /*
     * @see com.ideas2it.service.ProjectService #method addProject(String,
     *                                              (String, String, String)
     */
    public boolean addProject(String projectId, String projectTitle, 
                              String projectStartDate, String projectEndDate) 
                              throws AppException {                                                  
        if (!isProjectIdExists(projectId)) {   
            Project project = new Project(projectId, projectTitle, 
                                    projectStartDate, projectEndDate);
            projectDao.insertProject(project);
            return true;
        }          
        return false;
    }   
    
    /*
     * @see com.ideas2it.service.ProjectService #method getAllProjects()
     */       
    public List<Project> getAllProjects() throws AppException {
       return projectDao.retrieveAllProjects();
    }
    
    /*
     * @see com.ideas2it.service.ProjectService #method deleteProjectById
     *                                                                  (String)
     */ 
    public boolean deleteProjectById(String projectId) throws AppException {
        Project project = searchProjectById(projectId);      
        project.setEmployees(new ArrayList<Employee>());
        project.setClient(null);
        List<EmployeeHistory> histories = project.getEmployeeHistories();
        for (EmployeeHistory history : histories) {
            if (null == history.getLastUpdated()) {
                history.setLastUpdated(DateUtil.getCurrentDate());
            }
        }
        return projectDao.deleteProjectById(project);  
    }
    
    /*
     * @see com.ideas2it.service.ProjectService #method searchProjectById
     *                                                                  (String)
     */ 
    public Project searchProjectById(String projectId) throws AppException {
        return projectDao.retrieveProject(projectId);
    }
    
    /*
     * @see com.ideas2it.service.ProjectService #method updateProjectById
     *                                              (String, String, String,
     *                                               String)
     */
    public boolean updateProjectById(String projectId, String projectTitle, 
                              String projectStartDate, String projectEndDate) 
                              throws AppException {                                                  
        Project project = searchProjectById(projectId);
        if (null != project) {
            project.setTitle(projectTitle); 
            project.setStartDate(projectStartDate); 
            project.setEndDate(projectEndDate);
            return projectDao.updateProject(project);
        }
        return false;
    }
    
     /*
     * @see com.ideas2it.service.ProjectService 
     *                                       #method addEmployeeFromProject
     *                                                         (String, String)
     */
    public boolean addEmployeeToProject(String projectId, String employeeId) 
                                            throws AppException {
        Project project = searchProjectById(projectId);
        Employee employee = employeeService.searchEmployeeById(employeeId);
        List<Employee> employees = project.getEmployees(); 
        employees.add(employee);
        project.setEmployees(employees);
        project.addEmployeeHistory(new EmployeeHistory
                             (employee, project, DateUtil.getCurrentDate()));                                                    
        projectDao.insertEmployeeToProject(project);
        return true;
    }
                             
    public boolean addClientToProject(String projectId, String clientId) 
                                            throws AppException {
        List<Project> projects = null;
        if (isProjectIdExists(projectId)) {
            Project project = searchProjectById(projectId);
            Client client = clientService.searchClientById(clientId);
            project.setClient(client);                         
            projectDao.insertClientToProject(project);
            return true;
        }                                  
        return false;
    }        
     
    /*
     * @see com.ideas2it.service.ProjectService 
     *                                       #method removeEmployeeFromProject
     *                                                         (String, String)
     */
    public boolean removeEmployeeFromProject(String projectId, 
                                                  String employeeId) 
                                                  throws AppException {
        Project project = searchProjectById(projectId);
        Employee employee = employeeService.searchEmployeeById(employeeId);
        employee.setProject(null);        
        if (employee.getEmployeeHistories() != null) {
            List<EmployeeHistory> employeeHistories = 
                                        employee.getEmployeeHistories();
            for (EmployeeHistory employeeHistory : 
                                employee.getEmployeeHistories()) {
                employeeHistory.setCreatedDate(DateUtil.getCurrentDate()); 
                employeeHistory.setLastUpdated(DateUtil.getCurrentDate()); 
                employeeHistoryService.updateEmployeeHistory(employeeHistory); 
            }
            employee.setEmployeeHistories(employeeHistories);
        }
        return projectDao.deleteEmployeeFromProject(employee);
    }
        
    /*
     * @see com.ideas2it.service.ProjectService 
     *                             #method getEmployeesNotAssignedToProjects ()
     */
    public List<Employee> getEmployeesNotAssignedToProjects() throws
                                            AppException {
        return projectDao.retrieveEmployeesNotAssignedToProjects();      
    }  
        
    /**
     * Checking whether the project id already exists 
     *
     * @param projectId  
     *                        checks if project id already exists
     * @return true or false
     *                        if project id already exists, returns 
     *                        true otherwise false
     */ 
    public boolean isProjectIdExists(String projectId) throws
                                            AppException {        
        return projectDao.isProjectRecordExists(projectId);
    }
    
    /**
     * Checking whether the project id already exists 
     *
     * @param employeeId 
     *                        checks if project id already exists
     * @return true or false
     *                        if project id already exists, returns 
     *                        true otherwise false
     */ 
    public boolean isEmployeeIdExists(String employeeId) throws
                                            AppException {        
        return projectDao.isEmployeeRecordExists(employeeId); 
    }    
    
    /**
     * Checks whether all the details are entered in valid format
     * 
     * @params projectId
     *                        checks for only numbers in project id
     * @param projectTitle
     *                        check for only characters in project 
     *                        title
     * @param projectStartDate        
     *                        checks for valid date format in project 
     * @param projectEndDate        
     *                        checks for valid date format in project
     * @return true or false
     *                        if all project details are valid, returns 
     *                        true otherwise false
     */ 
    private boolean isValidProjectDetail(String projectId, 
                                            String projectTitle, 
                                            String projectStartDate, 
                                            String projectEndDate) {
        boolean validEntryChecked = true;
        StringBuilder builder = new StringBuilder();
        String statusMessage;
        if (!isValidProjectTitle(projectTitle)) {
            validEntryChecked = false;
        }
        if (!isValidProjectId(projectId)) {
            validEntryChecked = false;
        }
        if ((!isValidProjectStartDate(projectStartDate)) && 
                                    (!isValidStartDate(projectStartDate))) {
            validEntryChecked = false;
        }
        if ((!isValidProjectEndDate(projectEndDate)) && 
                                    (!isValidStartDate(projectStartDate))) {
            validEntryChecked = false;
        } 
        return validEntryChecked;
    }
           
    /**
     * Checking whether the project's title is entered in correct format
     * @params title
     *                        checks for valid title in project 
     * @return true or false
     *                        if project title contains only characters,  
     *                             returns true otherwise false
     */
    private boolean isValidProjectTitle(String projectTitle) {
        return CommonUtil.isString(projectTitle);
    }
    
    /**
     * Checking whether all the project's id is entered in correct format
     * @params id
     *                        check for only numbers in project id
     * @return true or false
     *                        if project id contains only numbers,  
     *                        returns true otherwise false
     */
    private boolean isValidProjectId(String id) {
        return CommonUtil.isNumerical(id);
    }    
    
    /**
     * Checking whether project's start date is entered in correct format
     *                                                   
     * @params startDate
     *                        checks if project start date is in dd-mm-yyyy 
     *                         format
     * @return true or false
     *                        if project date is in dd-mm-yyyy format,  
     *                             returns true otherwise false
     */   
    private boolean isValidProjectStartDate(String startDate) {
        return CommonUtil.isValidDateFormat(startDate);
    } 
    
    /**
     * Checking whether project's start date is entered in correct format
     *                                                   
     * @params startDate
     *                        checks if project start date is in dd-mm-yyyy 
     *                         format
     * @return true or false
     *                        if project date is in dd-mm-yyyy format,  
     *                             returns true otherwise false
     */   
    private boolean isValidStartDate(String startDate) {
        return DateUtil.isValidDate(startDate);
    }     
    
    /**
     * Checking whether project's end date is entered in correct format
     *                                                   
     * @params endDate
     *                        checks if project date is in dd-mm-yyyy format
     * @return true or false
     *                        if project date is in dd-mm-yyyy format,  
     *                             returns true otherwise false
     */   
    private boolean isValidProjectEndDate(String endDate) {
        return CommonUtil.isValidDateFormat(endDate);
    }  
    
    /**
     * Checking whether project's start date is entered in correct format
     *                                                   
     * @params startDate
     *                        checks if project start date is in dd-mm-yyyy 
     *                         format
     * @return true or false
     *                        if project date is in dd-mm-yyyy format,  
     *                             returns true otherwise false
     */   
    private boolean isValidEndDate(String endDate) {
        return DateUtil.isValidDate(endDate);
    }       
}  
