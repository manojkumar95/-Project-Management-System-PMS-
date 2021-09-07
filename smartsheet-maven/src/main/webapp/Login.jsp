<!DOCTYPE html>
<html>
    <head>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
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
<div id="wrapper">

	<form name="login-form" class="login-form" action="${pageContext.request.contextPath}/LoginController" method="POST">
		<input type="hidden" value="username" name="Username"/>
		<div class="header">
		<h1>Login Form</h1>
		<span>Fill out the form below</span>
		</div>
	
		<div class="content">
		<input name="username" type="text" class="input username" placeholder="Username" />
		<div class="user-icon"></div>
		<input name="password" type="password" class="input password" placeholder="Password" />
		<div class="pass-icon"></div>		
		</div>

		<div class="footer">
		<input type="submit" name="action" value="Login" class="login" />
		<input type="submit" name="action" value="Register" class="register" />
		</div>
	
	</form>
	  <script type="text/javascript"> window.onload = alertName; </script> 

</div>
<div class="gradient"></div>
</body>
</html>
