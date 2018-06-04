
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
        <legend><span class="number">1</span> Employee Edit Form</legend>  
        <c:forEach items="${employee.addresses}" var="address">  
            <c:choose>  
            <c:when test="${address.addressType eq 'primary'}">  
            <c:set var="homeAddress" value="${address}" />
            </c:when>
            <c:when test="${address.addressType eq 'secondary'}">
            <c:set var="workAddress" value="${address}" />
            </c:when>
            </c:choose>
        </c:forEach>
        <form method="GET" action="${pageContext.request.contextPath}/EmployeeController" >
            <table>
                  
                 <tr>
                    <td> <label for="enumber">Id</label> </td>
                    <td><br><input type="text" name="enumber" readonly="readonly" 
            value="<c:out value="${employee.id}"/>" /></td>
                </tr>
         </tr>
                 
                <tr>
                    <td> <label for="ename">First Name</label> </td>
                    <td><br><input type="text" readonly="readonly" name="ename" value="<c:out value="${employee.name}"/>" /></td>
                </tr>
               
                <tr>
                    <td><label for="edate">DOB(YYYY-MM-DD) </label></td>
                    <td><br><input type="text" readonly="readonly" name="edate" value="<c:out value="${employee.dateOfBirth}"/>" /></td>
                </tr>
                <tr>
                    <td> <label for="designation">Designation </label></td>
                    <td><br><select id="designation" readonly="readonly" name="designation"value="<c:out value="${employee.designation}"/>" />
      <option value="developer">Developer</option>
      <option value="trainee">Trainee</option>
      <option value="human resource">HR</option>
      <option value="manager">Manager</option>
    </select></td></tr>
                <tr>
                    <td> <label for="email">MailId</label> </td>
                    <td><br><input type="email" name="email" readonly="readonly" value="<c:out value="${employee.emailId}"/>" /></td>
                </tr>
              <tr>
                    <td> Gender: </td>
                 <td> <br><input type="radio" name="gender" value="male" checked> Male &nbsp; 
  <input type="radio" name="gender" readonly="readonly" value="female"> Female<br><br>
                </td>
                </tr>
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
               
                  <c:choose>
<c:when test="${not empty employee.project}">
 <legend><span class="number">2</span> Projects Of Employee</legend>  
                  <table id="table" class="responstable">
          <tr>
    <th>Id</th>
    <th>Title</th>
    <th>Start Date</th>
    <th>End Date</th>
  </tr>

                    <td>${employee.project.id}</td>
                    <td>${employee.project.title}</td>
                    <td>${employee.project.startDate}</td>
                    <td>${employee.project.endDate}</td>
               </c:when>
                 </c:choose>
</table>
                          &nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" value="showEmployee" name="action"> Back</button>  
        </form>
    
        </div>
    </body>
</html>
