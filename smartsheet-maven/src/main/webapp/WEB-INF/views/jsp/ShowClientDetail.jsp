<!DOCTYPE html>
<html>
    <head>
      <%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
    </head>
    <body>
 
   <c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "Login.jsp"/>
            </c:if>      
 
 <%@ include file = "header.jsp"%>

       <div class="form-style-5">
        <legend><span class="number">1</span> Client Info Form</legend> 
        <c:forEach items="${client.addresses}" var="address">  
            <c:choose>  
            <c:when test="${address.addressType eq 'primary'}">  
            <c:set var="homeAddress" value="${address}" />
            </c:when>
            <c:when test="${address.addressType eq 'secondary'}">
            <c:set var="workAddress" value="${address}" />
            </c:when>
            </c:choose>
        </c:forEach> 
        <form action="${pageContext.request.contextPath}/ClientController" method="GET">
            <table>
                  
                 <tr>
                    <td> <label for="id">Id</label> </td>
                    <td><br><input type="text" name="id" readonly="readonly" 
            value="<c:out value="${client.id}"/>" /></td>
                </tr>
         </tr>
                 
                <tr>
                    <td> <label for="name">First Name</label> </td>
                    <td><br><input type="text" name="name" readonly="readonly" value="<c:out value="${client.name}"/>" /></td>
                </tr>
                    <td> <label for="email">MailId</label> </td>
                    <td><br><input type="email" name="emailId" readonly="readonly" value="<c:out value="${client.emailId}"/>" /></td>
                </tr>
                <tr>
                    <td> <label for="designation">Organisation: </label></td>
                    <td><br><select id="designation" readonly="readonly" name="designation"value="<c:out value="${client.designation}"/>" />
      <option value="ResearchFirm">Research Firm</option>
      <option value="Health-Firm">Health Firm</option>
    </select></td></tr>
                </tr>
                
                              <tr>
                    <td> Gender: </td>
                 <td> <br><input type="radio" readonly="readonly" name="gender" value="male" checked> Male &nbsp; 
  <input type="radio" name="gender" value="female"> Female<br><br>
                </td></tr>
                                <tr>
                    <td> <label for="addresstype">Address Type </label></td>
                    <td><br><select id="addresstype" readonly="readonly" name="addresstype" value="<c:out value="${homeAddress.addressType}"/>" /> 
      <option value="primary">Primary</option>
      <option value="secondary">Secondary</option>
    </select></td></tr>
                </tr>
                    <tr><td><label for="doornumber">Door Number</label> </td>
                    <td><br><input type="text" readonly="readonly" name="doornumber" value="<c:out value="${homeAddress.doorNumber}"/>" /></td>
                </tr>
                <tr>
                    <td> <label for="street1">Apartment/Street1</label> </td>
                    <td><br><input type="text" readonly="readonly" name="street1" value="<c:out value="${homeAddress.street1}"/>" /></td>
                </tr>
                <tr>
                    <td><label for="street2">Street2 </label></td>
                    <td><br><input type="text" readonly="readonly" name="street2" value="<c:out value="${homeAddress.street2}"/>" /></td>
                </tr>
                <tr>
                    <td> <label for="city">City</label> </td>
                    <td><br><input type="text" readonly="readonly" name="city" value="<c:out value="${homeAddress.city}"/>" /></td>
                </tr>
                <tr>
                    <td> <label for="state">State</label> </td>
                    <td><br><input type="text" readonly="readonly" name="state" value="<c:out value="${homeAddress.state}"/>" /></td>
                </tr>
                <tr>
                    <td> <label for="zipcode">Zipcode</label> </td>
                    <td><br><input type="text" readonly="readonly" name="zipcode" value="<c:out value="${homeAddress.zipcode}"/>" /></td>
                </tr>
                <tr>
                    <td> <label for="country">Country</label></td>
    <td><br><select id="country" name="country" readonly="readonly" value="<c:out value="${homeAddress.country}"/>" />
      <option value="india">India</option>
      <option value="australia">Australia</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
    </select></td></tr>
                </table>
              &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" value="ViewClient" name="action"> Back</button> 
                       
        </form>
        </div>
    </body>
</html>
