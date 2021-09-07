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
      <script>
         function alertName(){
 var Msg ='${errorMessage}';
    if (Msg) {
 alert(Msg);
 } 
  
 }
 </script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
     function myfunction() {
alert('No projects exist in client');
window.location.href="${pageContext.request.contextPath}/ClientController?action=ViewClient";
}
</script>
    </head>
    <body>
     <%@ include file = "header.jsp"%>
<%@ include file = "Footer.jsp"%> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  <c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "Login.jsp"/>
            </c:if>      
           
           
    


<div class="form-style-5">
        <legend><span class="number">1</span> Tick Projects To Delete</legend> 
         <c:choose>
   <c:when test="${empty client.projects}">
    <script type="text/javascript">
            myfunction();
        </script>
    </c:when>
    <c:otherwise> 
 <form method="POST" action="${pageContext.request.contextPath}/ProjectController" >
<table class="responstable">

  <tr>
    <th>Tick</th>
    <th>Id</th>
    <th>Title</th>
    <th>Start Date</th>
    <th>End Date</th>
  </tr>
  <c:forEach items="${client.projects}" var="project">
                <tr>
                    <td><input type="checkbox" id="${project.id}" name="projectId" value="${project.id}"></td>
                    <td>${project.id}</td>
                    <td>${project.title}</td>
                    <td>${project.startDate}</td>
                    <td>${project.endDate}</td>
                </tr>
            </c:forEach> 

  
</table>
&nbsp;&nbsp;&nbsp;&nbsp;
<button type="submit" name="action" name="action" value="deleteProject">Delete Project</button>
</form>
           </c:otherwise>
  </c:choose>  
       <script type="text/javascript"> window.onload = alertName; </script>

    </body>
</html>
