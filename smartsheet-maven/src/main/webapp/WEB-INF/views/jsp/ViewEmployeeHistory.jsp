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
    </head>
    <body>
     <%@ include file = "header.jsp"%>
<%@ include file = "Footer.jsp"%> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "Login.jsp"/>
            </c:if>               
           
    


<div class="form-style-5">
        <legend><span class="number">1</span>Employee History of previous projects</legend>
 <form method="GET" action="${pageContext.request.contextPath}/EmployeeController">
<table class="responstable">

  <tr>
    <th>Employee Id</th>
    <th>Project Id</th>
  </tr>
  <c:forEach items="${employee.employeeHistories}" var="employeeHistory">  
                <tr>
                    <td>${employeeHistory.employee.id}</td>
                    <td>${employeeHistory.project.id}</td>                   
                </tr>

 </c:forEach>
  
</table>
&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" name="action" value="showEmployee">Back</button>
</form>
                      

    </body>
</html>
