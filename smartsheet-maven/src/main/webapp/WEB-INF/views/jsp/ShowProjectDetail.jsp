<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
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
        <legend><span class="number">1</span> Project Edit Form</legend> 
        <form method="GET" action="${pageContext.request.contextPath}/ProjectController">
            <table>
                  
                 <tr>
                    <td> <label for="projectId">Id</label> </td>
                    <td><br><input type="text" name="projectId" readonly="readonly" 
            value="<c:out value="${project.id}"/>" /></td>
                </tr>
         </tr>
                 
                <tr>
                    <td> <label for="title">First Name</label> </td>
                    <td><br><input type="text" name="title" readonly="readonly"  value="<c:out value="${project.title}"/>" /></td>
                </tr>
               
                <tr>
                    <td><label for="startDate">DOB(YYYY-MM-DD): </label></td>
                    <td><br><input type="date" name="startDate" readonly="readonly" value="<c:out value="${project.startDate}"/>" /></td>
                </tr>
 
                    <td> <label for="endDate">End Date::</label> </td>
                    <td><br><input type="date" name="endDate" readonly="readonly"  value="<c:out value="${project.endDate}"/>" /></td>
                </tr>
              <tr>
                    <td> Gender: </td>
                 <td> <br><input type="radio" name="gender" readonly="readonly"  value="male" checked> Male &nbsp; 
  <input type="radio" name="gender" value="female"> Female<br><br>
                </td></tr>
                </table>
                              <c:choose>
<c:when test="${not empty project.client}">
<legend><span class="number">2</span> Projects of Client</legend>
                  <table id="table" class="responstable">
          <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Mail Id</th>
    <th>Designation</th>

  </tr>

                    <td>${project.client.id}</td>
                    <td>${project.client.name}</td>
                    <td>${project.client.emailId}</td>
                    <td>${project.client.designation}</td>
               </c:when>
                 </c:choose>
</table>   

   
              &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" value="ViewProject" name="action"> Back</button>
                 
                 

        </form>
        </div>
    </body>
</html>
