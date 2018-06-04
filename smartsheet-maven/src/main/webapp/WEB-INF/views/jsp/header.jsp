<!DOCTYPE html>
<html>
    <head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
        <title>Employee</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styleform.css">
<style>
label {
	font-size: 20px;
	text-decoration: none;
	font-family: gothic;
	}
	.dropbtn {
    background-color: #666;
    color: white;
    padding: 16px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
    position: relative;
    display: inline-block;
    
}

.dropdown:hover .dropdown-content {
    display: block;
}
/* Dropdown Content (Hidden by Default) */
.dropdown-content {
    display: none;
    position: absolute;
    background-color: #666;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    padding: 12px 16px;
    z-index: 100;
}


/* Links inside the dropdown */
.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {background-color: #666;}

/* Show the dropdown menu on hover */

.dropdown:hover .dropdown-content {
    display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
    background-color: #666;
}   

.dropdown ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #666;
}

.dropbtn
{
    position: relative;
    display: block;
    padding: 19px 39px 18px 39px;
    color: #FFF;
    margin: 0 auto;
    background: #666;
    font-size: 16px;
    text-align: center;
    font-style: normal;
    width: 100%;
    border-width: 1px 1px 3px;
}

.dropdown li {
    float: left;
}

.dropdown li a, .dropbtn {
    display: inline-block;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.dropdown li a:hover, .dropdown:hover .dropbtn {
    background-color: #5aada0;
}

li.dropdown {
    display: inline-block;
}

.dropdown-content {
    display: none;
    position: absolute;
    background-color: #666;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}

.dropdown-content a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    text-align: left;
}

.dropdown-content a:hover {background-color: #666}

.dropdown:hover .dropdown-content {
    display: block;
}
	</style>
    </head>
    <body>
    <header>

<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			
			<ul>
                <li><a href="${pageContext.request.contextPath}/LoginController?action=dashboard"">Home</a></li>

 <li><a href="${pageContext.request.contextPath}/EmployeeController?action=showEmployee">Employee</a></li>
      <li><a href="${pageContext.request.contextPath}/ClientController?action=ViewClient">  Client</a></li>
      <li><a href="${pageContext.request.contextPath}/ProjectController?action=ViewProject"> Project</a></li>


         <li><a href="${pageContext.request.contextPath}/LogoutController?action=logout">Logout</a></li>
            </ul>
		</div>
	</div>
	</header>
</nav>
</body>
</html>
