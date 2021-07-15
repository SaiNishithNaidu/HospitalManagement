<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <style><%@include file="/WEB-INF/css/patientRegister.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<div class="first">
		<div class="logoplace">
			<a href="" style="text-decoration: none;">
			<div class="logoinsidename">
				
			</div>
			</a>

		</div>		
			<div class="AboutUs"><a href="" style="text-decoration: none; color: black;">About Us</a> </div>
	</div>

	<div class="second">
		<div class="child">			
			<form action="loginafterregister" method="GET" modelAttribute="afterRegister">
		
		<center><h3>Register</h3></center>
		<label>User Id*</label><br>
		<input class="inputs" type="text" name="userid" disabled value="${firstname} "/><br><br>



		<label>Password</label><br>
		<input class="inputs" type="password" name="password"  placeholder="Password"  required="required" minlength="8" maxlength="20"/><br></br>

		
		<label>Confirm Password*</label><br>
		<input class="inputs" type="password" name="confirmpassword"  placeholder="Confirm Password" required="required" minlength="0" maxlength="20" /><br></br>


		

		<input type="submit" name="Register" style="background-color: #0048D9; width: 100%; color: white; border-radius: 5px; padding-top: 5px; padding-bottom: 5px; font-weight: bold;" value="Register"/>
		</form>
		<h4 style="color: #FF0000">${message}</h4>
		</div>
		
		
	</div>
	
	


</body>

</html>



