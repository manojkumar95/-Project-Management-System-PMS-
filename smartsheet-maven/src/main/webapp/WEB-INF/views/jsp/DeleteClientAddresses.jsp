<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css"">
              <script>
         function alertName(){
 var Msg ='${errorMessage}';
    if (Msg) {
 alert(Msg);
 } 
  
 }
 function myfunction() {
alert('No address exists in client');
window.location.href="${pageContext.request.contextPath}/resources/css/styleform.css";
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
        <legend><span class="number">1</span> Delete Client Addresses</legend> 


 <form method="POST" action="${pageContext.request.contextPath}/AddressController" >
<table class="responstable">
<input type="hidden" value="${client.id}" name="id">
<input type="hidden" value="${address.userType}" name="userType">
<input type="hidden" value="${address.id}" name="addressId">
  <tr>
   <th>Checkbox</th>
    <th>AddressType</th>    
    <th>DoorNumber</th>
    <th>Street1</th>
    <th>Street2</th>
    <th>City</th>
    <th>State</th>
    <th>Country</th>
    <th>Zipcode</th>
  </tr>
  <c:choose>
   <c:when test="${empty client.addresses}">
    <script type="text/javascript">
            myfunction();
        </script>
    </c:when>
    <c:otherwise>
             <c:forEach items="${client.addresses}" var="address">  
                <tr>
                    <td><input type="checkbox" id="${address.addressId}" name="addressType" value="${address.addressId}"></td>
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
              &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" name="action" value="deleteClientAddresses">Delete Addresses</button>
            </c:otherwise>
  </c:choose>     

        </form>
             <script type="text/javascript"> window.onload = alertName; </script>
        </div>
    </body>
</html>
