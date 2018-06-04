<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
              <script>
         function alertName(){
 var Msg ='${errorMessage}';
    if (Msg) {
 alert(Msg);
 } 
  
 }
 </script>
    </head>
    <body>
 <%@ include file = "header.jsp"%>
<%@ include file = "Footer.jsp"%>

  


        <div class="form-style-5">
        <legend><span class="number">2</span> Address Info Form</legend> 
        <form action="${pageContext.request.contextPath}/EmployeeController" method="GET">
            <table>
                <tr>
                    <td> <label for="doornumber">Door Number</label> </td>
                    <td><input type="text" name="doornumber" required></td>
                </tr>
                <tr>
                    <td> <label for="street1">Apartment/Street1</label> </td>
                    <td><input type="text" name="street1" required></td>
                </tr>
                <tr>
                    <td><label for="street2">Street2 </label></td>
                    <td><input type="text" name="street1" required></td>
                </tr>
                <tr>
                    <td> <label for="addresstype">Address Type </label></td>
                    <td><select id="addresstype" name="addresstype" required>
      <option value="primary">Primary</option>
      <option value="secondary">Secondary</option>
    </select></td></tr>
                </tr>
                <tr>
                    <td> <label for="city">City</label> </td>
                    <td><input type="text" name="city" required></td>
                </tr>
                <tr>
                    <td> <label for="zipcode">Zipcode:</label> </td>
                    <td><input type="text" name="zipcode" required></td>
                </tr>
                <tr>
                    <td> <label for="country">Country</label></td>
    <td><select id="country" name="country" required>
      <option value="india">India</option>
      <option value="australia">Australia</option>
      <option value="canada">Canada</option>
      <option value="usa">USA</option>
    </select></td></tr>
                </table>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <button type="submit" name="action" value="addAddress">Add Address</button>
              &nbsp;&nbsp;&nbsp;&nbsp;<input type="reset" name="reset" value="Reset"> 
                    

        </form>
