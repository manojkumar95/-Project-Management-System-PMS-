<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
           
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
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
<script type="text/javascript">
    function confirmSubmit(id) {
    
        if (confirm("Are you sure you want to delete? Client may contain projects")) {
            window.location.href="${pageContext.request.contextPath}/ClientController?action=DeleteClient&clientId=${client.id}" + id;
            return true;
        } else {
            return false;
        }
    }
         function alertName() {
 var Msg ='${errorMessage}';
    if (Msg) {
 alert(Msg);
 } 
  
 }
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
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
</script>
    </head>
    <body>
     <%@ include file = "header.jsp"%>
<%@ include file = "Footer.jsp"%>
  <c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "Login.jsp"/>
            </c:if>      

<h1><b><center>Client Details</center></b><br></h1>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="box head-box">
<button class="add-btn" onclick="window.location.href='${pageContext.request.contextPath}/ClientController?action=createClient'">Add Client</button></div>
  <div class="container-4">
    <input type="search" id="search" onkeyup="myFunction()" placeholder="Enter id here..." />
    <button class="icon"><i class="fa fa-search"></i></button>
  </div>
</div>

<form action="${pageContext.request.contextPath}/ClientController" method="GET">
<table id="table" class="responstable">  
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Organisation</th>
    <th>MailId</th>
    <th>Project Actions</th>
   
    <th>Address Actions</th>
     <th>Client Actions</th>
  </tr>
            <c:forEach items="${clients}" var="client"> 
                <tr>
                    <td>${client.id} </td>
                    <td>${client.name}</td>
                    <td>${client.designation}</td>
                    <td>${client.emailId}</td>
                    <td><a href="ClientController?action=addProject&clientId=${client.id}"/>Add</a> | 
                        <a href="ClientController?action=viewProject&clientId=${client.id}"/>View</a> |
                        <a href="ClientController?action=deleteProject&clientId=${client.id}"/>Delete</a></td>
                         <td> <a href="AddressController?action=addNewAddress&employeeId=${client.id}&userType=client"> Add</a> | 
                     <a href="AddressController?action=viewClientAddress&employeeId=${client.id}">View</a> |
                     <a href="AddressController?action=deleteClientAddress&id=${client.id}">Delete</a></td>
                    <td><a href="ClientController?action=UpdateClient&clientId=${client.id}"/>Update</a> |
                        <a href="#" onclick="confirmSubmit(${client.id});"/>Delete</a> |
                        <a href="ClientController?action=ViewClientAllDetail&clientId=${client.id}"/> View</a></td>
                </tr>
             </c:forEach>
</table>
<div class="form-style-5">
    </form>         
         <script type="text/javascript"> window.onload = alertName; </script>   
</div>
    </body>
</html>
