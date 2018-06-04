<!DOCTYPE html>
<html>
    <head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
     <%@ include file = "Footer.jsp"%> 
      <c:if test ="${sessionScope['username'] == null}">
              <c:redirect url = "/Login.jsp"/>
            </c:if>   
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
   <style>
   .image
{
    position:absolute;
    width:592px; /*image width */
    height:412px; /*image height */
    left:50%; 
    top: 502%;
    margin-left:-296px; /*image width/2 */
    margin-top:-141px; /*image height/2 */
    
}

</style>
 </head>
 <body>

<section id="sidebar"> 
  <div class="white-label">
  </div> 

  <div id="sidebar-nav">   
    <ul>
      <li class="fa fa-desktop"><a href="${pageContext.request.contextPath}/LoginController?action=dashboard"><i class="fa fa-dashboard"></i> Home</a></li>
      <li><a href="${pageContext.request.contextPath}/EmployeeController?action=showEmployee"><i class="fa fa-desktop"></i> Employee</a></li>
      <li><a href="${pageContext.request.contextPath}/ClientController?action=ViewClient"> <i class="fa fa-usd"></i> Client</a></li>
      <li><a href="${pageContext.request.contextPath}/ProjectController?action=ViewProject"><i class="fa fa-pencil-square-o"></i> Project</a></li>

    </ul>
  </div>
</section>
<section id="content">
  <div id="header">
    <div class="header-nav">
      <div class="menu-button">
        <!--<i class="fa fa-navicon"></i>-->
      </div>
      
      <div class="nav">
        <ul>
<img class="image" src="${pageContext.request.contextPath}/resources/images/images.jpeg" style="center">


          <li class="nav-profile">
            <div class="nav-profile-image">
              <div class="nav-profile-name"><a href="${pageContext.request.contextPath}/LogoutController?action=logout">Log Out</a><i class="fa fa-caret-down"></i></div>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
   <div class="content">
    <div class="content-header">
      <h1 style="text-align:center">Welcome to Smartsheet</h1>
      <p style="text-align:center">Project Management System</p>
    </div>

    </div>  
  </div>
</section>
</body>
</html>
