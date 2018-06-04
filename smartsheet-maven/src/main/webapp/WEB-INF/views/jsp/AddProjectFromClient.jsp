<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Project</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
            <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
         <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/Validation.js"></script>
  <script>
     function alertName() {
         var Msg ='${errorMessage}';
            if (Msg) {
         alert(Msg);
         } 
     }
  </script>
    </head>
    <body>
 
 <%@ include file = "header.jsp"%>
    <c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "Login.jsp"/>
            </c:if>        


        <div class="form-style-5">
        <legend><span class="number">1</span> Project Info Form</legend> 
        <form action="${pageContext.request.contextPath}/ProjectController" method="POST">
        <input type="hidden" value="<%=request.getParameter("clientId")%>" name="clientId">
                    <table>
                <tr>
                    <td> <label for="projectId">*Id</label> </td>
                    <td><br><input type="text" pattern="[0-9]{4}" placeholder="Enter a 4 digit number" title="Id should be a 4 digit number" name="projectId" required></td>
                </tr>
                <tr>
                    <td> <label for="title">Title</label> </td>
                    <td><br><input type="text" name="title" pattern="[a-zA-Z\s]*" title="Enter only characters" placeholder="Enter only characters" required></td>
                </tr>
                <tr>
                    <td><label for="startDate">Start Date </label></td>
                    <td><br><input type="text" id="datepicker" placeholder="yyyy-dd-mm format" name="startDate" required></td>
                </tr>
                <tr>
                    <td><label for="endDate">End Date </label></td>
                    <td><br><input type="text" id="datepicker1" placeholder="yyyy-dd-mm format" name="endDate" required></td>
                </tr>
                <tr>
                    <td> <label for="designation">Organisation: </label></td>
                    <td><br><select id="designation" name="designation">
      <option value="ResearchFirm">Research Firm</option>
      <option value="Health-Firm">Health Firm</option>
    </select></td></tr>
                </table>
              &nbsp;&nbsp;&nbsp;&nbsp;
              <button type="submit" name="action" value="addProjectfromClient">Add Project</button>
                  <input type="reset" name="reset" value="Reset"> 

        </form>
             <script type="text/javascript"> window.onload = alertName; </script>
        </div>
    </body>
</html>
