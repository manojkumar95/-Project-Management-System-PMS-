<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
    <script>
     function myfunction() {
alert('No projects exist in client');
window.location.href="${pageContext.request.contextPath}/ClientController?action=ViewClient";
}
</script>
    </head>
    
    <body>
 
 <%@ include file = "header.jsp"%>
 <%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

  <c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "Login.jsp"/>
            </c:if>         
           
    

<div class="form-style-5">
        <legend><span class="number">1</span> View Projects Of Client</legend> 


  <c:choose>
   <c:when test="${empty client.projects}">
    <script type="text/javascript">
            myfunction();
        </script>
    </c:when>
    <c:otherwise>    
 <form method="GET" action="${pageContext.request.contextPath}/ClientController" >
<table class="responstable">

  <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Start Date</th>
    <th>End Date</th>
  </tr>
             <c:forEach items="${client.projects}" var="project">  
                <tr>
                    <td>${project.id}</td>
                    <td>${project.title}</td>
                    <td>${project.startDate}</td>
                    <td>${project.endDate}</td>
                </tr>
            </c:forEach> 
                </table>
              &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" name="action" value="ViewClient" > Back</button>
                </c:otherwise>
  </c:choose>     
  
                 

        </form>
        </div>
    </body>
</html>
