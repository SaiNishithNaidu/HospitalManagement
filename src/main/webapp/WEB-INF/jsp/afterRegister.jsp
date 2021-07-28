<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<style><%@include file="/WEB-INF/css/login.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body class="main-bg">
<div class="wrapper fadeInDown">
<div id="formContent">
<!-- Tabs Titles -->


<form action="loginafterregister" method="GET" modelAttribute="afterRegister">

<center><h3>Register</h3></center>
<label>User Id*</label><br>
<input class="inputs" type="text" name="userid" disabled value="${firstname} "/><br><br>

<label>Password</label><br>
<input class="inputs" type="password" name="password" placeholder="Password" required="required" minlength="8" maxlength="20"/><br></br>

<label>Confirm Password*</label><br>
<input class="inputs" type="password" name="confirmpassword" placeholder="Confirm Password" required="required" minlength="0" maxlength="20" /><br></br>

<input type="hidden" name="Security_Question" value="${Security_Question}"/>
<input type="hidden" name="Answer" value="${Answer}"/>
<input type="hidden" name="Contact_Number" value="${Contact_Number}"/>

<input type="submit" name="Register" value="Register"/>

</form>
<h4 style="color: #FF0000">${message}</h4>
</div>


</div>


</body>

</html>