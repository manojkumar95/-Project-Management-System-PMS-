<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <style>
    h1 {
  font-family: Verdana;
  font-weight: normal;
  color: #024457;
}
h1 span {
  color: #167F92;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
    function confirmSubmit(id) {
        if (confirm("Are you sure you want to delete?")) {
            window.location.href="${pageContext.request.contextPath}/EmployeeController?action=deleteEmployee&employeeId=" + id;
            return true;
        } else {
            return false;
        }
    }

function myFunction() {
  // Declare variables
  var input, filter, table, tr, td, i;
  input = document.getElementById("search");
  filter = input.value.toUpperCase();
  table = document.getElementById("table");
  tr = table.getElementsByTagName("tr");

  // Loop through all table rows, and hide those who don't match the search query
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[0];
    if (td) {
      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }
  }
}

 function alertName(){
 var Msg ='${errorMessage}';
    if (Msg) {
 alert(Msg);
 } 
  
 }

 </script> 
    </head>
    <body>
      <c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "Login.jsp"/>
            </c:if>      
     <%@ include file = "header.jsp"%>
<h1><b><center>Employee Details</center><br></b></h1>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="box head-box">
<button class="add-btn" onclick="window.location.href='${pageContext.request.contextPath}/EmployeeController?action=createEmployee'">Add Employee</button></div>
  <div class="container-4">
    <input type="search" id="search" onkeyup="myFunction()" placeholder="Enter id here..." />
    <button class="icon"><i class="fa fa-search"></i></button>
  </div>
</div>

<table id="table" class="responstable">

  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>DOB</th>
    <th>Designation</th>
    <th>MailId</th>
    <th>Employee Actions</th>
    <th>Address Actions</th>
    <th>History</th>
  </tr>
            <c:forEach items="${employees}" var="employee"> 
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.dateOfBirth}</td>
                    <td>${employee.designation}</td>
                    <td>${employee.emailId}</td>
                    <td><a href="${pageContext.request.contextPath}/EmployeeController?action=updateEmployee&employeeId=${employee.id}"/>Update</a> | 
                    <a href="#" onclick="confirmSubmit(${employee.id});"/>Delete</a> |
                        <a href="${pageContext.request.contextPath}/EmployeeController?action=ViewEmployeeAllDetail&employeeId=${employee.id}"/> View</a>
                    </td>
                     <td> <a href="${pageContext.request.contextPath}/AddressController?action=addNewAddress&employeeId=${employee.id}&userType=employee"> Add</a> | 
                     <a href="${pageContext.request.contextPath}/AddressController?action=viewAddress&employeeId=${employee.id}">View</a> |
                     <a href="${pageContext.request.contextPath}/AddressController?action=deleteAddress&id=${employee.id}">Delete</a></td>
                    <td> <a href="${pageContext.request.contextPath}/EmployeeController?action=viewEmployeeHistory&employeeId=${employee.id}"> View</td>
                </tr>
            </c:forEach>

  
</table>
<script type="text/javascript"> window.onload = alertName; </script>
                      

    </body>
</html>
