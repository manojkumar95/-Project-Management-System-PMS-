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
<script type="text/javascript">
    function confirmSubmit(id) {
        if (confirm("Are you sure you want to delete?")) {
            window.location.href="${pageContext.request.contextPath}/ProjectController?action=DeleteProject&projectId=${project.id}" + id;
            return true;
        } else {
            return false;
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
     <%@ include file = "header.jsp"%>
  <c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "Login.jsp"/>
            </c:if>      

<h1><b><center>Project Details</center><br></b></h1>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<div class="box head-box">
<button class="add-btn" onclick="window.location.href='${pageContext.request.contextPath}/ProjectController?action=addProject'">Add Project</button></div>
  <div class="container-4">
    <input type="search" id="search" onkeyup="myFunction()" placeholder="Enter id here..." />
    <button class="icon"><i class="fa fa-search"></i></button>
  </div>
</div>
<form action="ProjectController" method="GET">
<table id="table" class="responstable">
  
  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Start Date</th>
    <th>End Date</th>
    <th>Edit/View</th>
    <th>Assign Employees</th>
  </tr>

            <c:forEach items="${projects}" var="project">
                    <td>${project.id}</td>
                    <td>${project.title}</td>
                    <td>${project.startDate}</td>
                    <td>${project.endDate}</td>
                    <td><a href="${pageContext.request.contextPath}/ProjectController?action=UpdateProject&projectId=${project.id}"/>Update</a> | 
                    <a href="#" onclick="confirmSubmit(${project.id});"/>Delete</a> |
                        <a href="${pageContext.request.contextPath}/ProjectController?action=ViewProjectAllDetail&projectId=${project.id}"/> View</a></td>
                    <td><a href="${pageContext.request.contextPath}/ProjectController?action=AssignEmployees&projectId=${project.id}"/> Assign</a> |
                    <a href="${pageContext.request.contextPath}/ProjectController?action=UnassignEmployees&projectId=${project.id}"/> Unassign</a> |
                    <a href="${pageContext.request.contextPath}/ProjectController?action=ViewEmployeesInTheProject&projectId=${project.id}"/>ViewEmployees</td>
                </tr>
            </c:forEach>
</table>
            
    </form>   
    <form action="ProjectController">
    <div class="form-style-5">
    <button type="submit" name="action" value="ViewProject" >Scroll Up</button>
    </div>
    </form>     
     <script type="text/javascript"> window.onload = alertName; </script>
    </body>
</html>
