<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <style><%@include file="/WEB-INF/css/login.css"%></style>
<!DOCTYPE html>
<html>
<head>
	<title></title>
</head>
<body>
	<div class="first">
		
		<div class="logoplace">
			<a href="" style="text-decoration: none;">
			<div class="logoinsidename">
				H
			</div>
			</a>

		</div>		
			<div class="AboutUs"><a href="" style="text-decoration: none; color: black;">About Us</a> </div>
	</div>
	<center><div class="second">
		<form action="/homepage" method="POST" modelAttribute="loginModel">
		<h3>Login</h3>
		<input type="text" name="username" style="width: 100%; height: 30px; padding-left: 15px;" placeholder="Username" required="required" 
		/><br><br>
		<input type="password" name="password" style="width: 100%; height: 30px; padding-left: 15px;" placeholder="Password" required="required" /><br>
		<a href="#" style="float: right;  text-decoration: none; font-size: 14px; margin-top: 5px;">Forget Password?</a><br><br>
		<input type="submit" name="Login" style="background-color: #0048D9; width: 100%; color: white; border-radius: 5px; padding-top: 5px; padding-bottom: 5px; font-weight: bold;" value="Login" />
		</form>
	</div>
	<h4 style="color: #FF0000">${message}</h4>
	</center>
</body>
</html>