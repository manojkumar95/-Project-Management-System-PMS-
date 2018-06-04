
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
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
        <legend><span class="number">1</span> Address Edit Form</legend>  
        <form method="POST" action="${pageContext.request.contextPath}/AddressController" >
<input type="hidden" value="${address.addressId}" name="addressId">
<input type="hidden" value="${address.userType}" name="userType">
<input type="hidden" value="${client.id}" name="id">
            <table>

                <tr>
                    <td> <label for="addresstype">*Address Type </label></td>
                    <td><br><select id="addresstype" readonly="readonly" name="addresstype" value="<c:out value="${address.addressType}" />" /> 
      <option value="primary">Primary</option>
    </select></td></tr>
                </tr>
                    <tr><td><label for="doornumber">*Door Number</label> </td>
                    <td><br><input type="text" name="doornumber" value="<c:out value="${address.doorNumber}"/>" required/></td>
                </tr>
                <tr>
                    <td> <label for="street1">*Apartment/Street1</label> </td>
                    <td><br><input type="text" name="street1" value="<c:out value="${address.street1}"/>" required/></td>
                </tr>
                <tr>
                    <td><label for="street2">Street2 </label></td>
                    <td><br><input type="text" name="street2" value="<c:out value="${address.street2}"/>" /></td>
                </tr>
                <tr>
                    <td> <label for="city">City</label> </td>
                    <td><br><input type="text" name="city" value="<c:out value="${address.city}"/>"/></td>
                </tr>
                <tr>
                    <td> <label for="state">State</label> </td>
                    <td><br><input type="text" name="state" value="<c:out value="${address.state}"/>" required/></td>
                </tr>
                <tr>
                    <td> <label for="zipcode">*Zipcode:</label> </td>
                    <td><br><input type="text" name="zipcode" value="<c:out value="${address.zipcode}"/>" required/></td>
                </tr>
                <tr>
                    <td> <label for="country">*Country</label></td>
    <td><br><select id="country" name="country" value="<c:out value="${address.country}"/>" />
      <option value="india">India</option>
      <option value="usa">USA</option>
    </select></td></tr>
    
                </table>
              &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" value="updateIndvidualAddress" name="action"> Update Address</button>                
        </form>
        </div>
    </body>
</html>
