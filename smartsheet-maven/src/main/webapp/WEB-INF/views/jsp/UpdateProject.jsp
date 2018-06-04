<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
      <script>
         function alertName(){
 var Msg ='${errorMessage}';
    if (Msg) {
 alert(Msg);
 } 
  
 }
 </script>
</head>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
    <script>$('#invokesToastMessage').click(function () { toastr.success('message', 'title'); });</script> 
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
        <form method="POST" action="${pageContext.request.contextPath}/ProjectController">
        <input type="hidden" value="Update" name="action">
            <table>
                  
                 <tr>
                    <td> <label for="projectId">Id</label> </td>
                    <td><br><input type="text" name="projectId" readonly="readonly" 
            value="<c:out value="${project.id}"/>" /></td>
                </tr>
         </tr>
                 
                <tr>
                    <td> <label for="title">*First Name</label> </td>
                    <td><br><input type="text" name="title" value="<c:out value="${project.title}"/>" required/></td>
                </tr>
               
                <tr>
                    <td><label for="startDate">DOB(YYYY-MM-DD): </label></td>
                    <td><br><input type="date" name="startDate" value="<c:out value="${project.startDate}"/>" /></td>
                </tr>
 
                    <td> <label for="endDate">End Date</label> </td>
                    <td><br><input type="date" name="endDate" value="<c:out value="${project.endDate}"/>" /></td>
                </tr>
              <tr>
                    <td><label for="gender"> Gender </label> </td>
                 <td> <br><input type="radio" name="gender" value="male" checked> Male &nbsp; 
  <input type="radio" name="gender" value="female"> Female<br><br>
                </td></tr>
                </table>
                
              &nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="Update" name="action"> 
                 

         <input type="reset" value="Reset" > 
                 

        </form>
             <script type="text/javascript"> window.onload = alertName; </script>
        </div>
    </body>
</html>
