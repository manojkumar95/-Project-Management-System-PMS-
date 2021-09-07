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
 function myfunction() {
alert('No employees exist in project');
window.location.href="${pageContext.request.contextPath}/ProjectController?action=ViewProject";
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
        <legend><span class="number">1</span> View Employees In Project</legend> 
<c:choose>

    <c:when test="${empty project.employees}">
    <script type="text/javascript">
            myfunction();
        </script>
    </c:when>
    <c:otherwise>

 <form method="GET" action="${pageContext.request.contextPath}/ProjectController" >
<table class="responstable">

  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>DOB</th>
    <th>Designation</th>
    <th>MailId</th>
  </tr>
  
  <c:forEach items="${project.employees}" var="employee">  
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.dateOfBirth}</td>
                    <td>${employee.designation}</td>
                    <td>${employee.emailId}</td>
                </tr>
            </c:forEach> 

  
</table>
&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" name="action" value="ViewProject"> Back</button>
</form>
        </c:otherwise>
        </c:choose>              

    </body>
</html>
