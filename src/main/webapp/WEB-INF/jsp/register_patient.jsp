<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<style><%@include file="/WEB-INF/css/patientRegister.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Patient RegistrationPage</title>

</head>

<script type="text/javascript">


function required(){
	
	
	var empt = document.forms["form1"]["First_Name"].value;
	if (empt == "")
	{
	alert("Please update the highlighted mandatory field(s).");
	return true;
	}
	
	
	
}

</script>

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

	<div class="second">
		<div class="child">			
			<form action="/afterRegister" method="GET" modelAttribute="registerPatientModel" onsubmit="required()" name="form1">
		
		<h3>Register</h3>
		<label>First Name*</label><br>
		<input class="inputs" type="text" name="First_Name" placeholder="First Name" required="required" minlength="4" maxlength="50" /><br><br>



		<label>Last Name</label><br>
		<input class="inputs" type="text" name="Last_Name"  placeholder="lastname" minlength="0" maxlength="20"/><br></br>


		<label>Date of Birth*</label><br>
		<input class="inputs" type="date" name="DOB" required="required" /><br></br>


		<div style="float: left;">
		<label>Gender*</label><br>
		<input type="radio" name="Gender" value="Male" id="Gender" required="required" />Male
		<input type="radio" name="Gender" value="Female" id="Gender" required="required" />Female
		<input type="radio" name="Gender" value="Other" id="Gender" required="required" />Others	
		</div><br><br><br>
		
		<label>Contact*</label><br>
		<input class="inputs" type="text" name="Contact_Number"  placeholder="Contact" required="required" pattern="[6-9]{1}[0-9]{9}"/><br></br>


		<label>Email*</label><br>
		<input class="inputs" type="email" name="Email"  placeholder="Email" required="required" /><br></br>


		<input type="submit" name="Register" style="background-color: #0048D9; width: 100%; color: white; border-radius: 5px; padding-top: 5px; padding-bottom: 5px; font-weight: bold;" value="Register"/>
		</form>

		</div>
		
		
	</div>
	<script src="webjars/jquery/3.5.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>

</html>



