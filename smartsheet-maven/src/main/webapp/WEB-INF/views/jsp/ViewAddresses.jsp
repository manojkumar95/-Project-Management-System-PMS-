<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
            <script>
     function myfunction() {
alert('No addresses exist in employee');
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
             <c:choose>
             <c:when test="${empty employee.addresses}">
    <script type="text/javascript">
            myfunction();
        </script>
    </c:when>
    <c:otherwise> 
           
    

<div class="form-style-5">
        <legend><span class="number">1</span> View Addresses Of Employees</legend> 


 <form method="GET" action="${pageContext.request.contextPath}/EmployeeController" >
<table class="responstable">

  <tr>
    <th>Edit</th>
    <th>AddressType</th>    
    <th>DoorNumber</th>
    <th>Street1</th>
    <th>Street2</th>
    <th>City</th>
    <th>State</th>
    <th>Country</th>
    <th>Zipcode</th>
  </tr>
 
             <c:forEach items="${employee.addresses}" var="address">  
                <tr>
                    <td><a href="${pageContext.request.contextPath}/AddressController?action=updateAddress&addressId=${address.addressId}&userType=${address.userType}&id=${employee.id}"/>Update</a></td>
                    <td>${address.addressType}</td>
                    <td>${address.doorNumber}</td>
                    <td>${address.street1}</td>
                    <td>${address.street2}</td>
                     <td>${address.city}</td>
                    <td>${address.state}</td>
                    <td>${address.country}</td>
                    <td>${address.zipcode}</td>
                </tr>
            </c:forEach> 
                </table>
              &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" value="showEmployee" name="action"> Back</button>
                 
            </c:otherwise>
  </c:choose>          

        </form>
       
        
        </div>
    </body>
</html>
