<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<style><%@include file="/WEB-INF/css/doctorRegister.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor RegistrationPage</title>
</head>

<script>
function myFunction() {
	alert("sucess");
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
			<form action="/afterRegister1" method="GET" modelAttribute="registerDoctorModel" onsubmit="required()" name="form1">
		
		<h3>Register</h3>
		<label>First Name*</label><br>
		<input class="inputs" type="text" name="First_Name" placeholder="First Name" required="required" minlength="0" maxlength="20" /><br><br>



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
		<input class="inputs" type="number" name="Contact_Number"  placeholder="Contact" required="required" minlength="10" maxlength="10"/><br></br>


		<label>Email*</label><br>
		<input class="inputs" type="email" name="Email"  placeholder="Email" required="required" /><br></br>

		
		<h2>Please Fill Previous Work Experience</h2>
				
		<label>Qualification</label><br>
		<input class="inputs" type="text" name="Qualification"  placeholder="Qualification" required="required" /><br></br>
		
		<label>Speciality</label><br>
		<input class="inputs" type="text" name="Speciality"  placeholder="Speciality" required="required" /><br></br>
		
		<label>Experience</label><br>
		<input class="inputs" type="text" name="Experience"  placeholder="Experience" required="required" /><br></br>
		
		<label>Hospital Name</label><br>
		<input class="inputs" type="text" name="Hospital_Name"  placeholder="Hospital Name" required="required" /><br></br>
		
		<label>Day of Availability</label><br>
		<input class="inputs" type="date" name="Day_of_Availability"  placeholder="Day of Availability" required="required" /><br></br>
		
		<label>Time of Availability</label><br>
		<input class="inputs" type="time" name="Time_of_Availability"  placeholder="Time of Availability" required="required" /><br></br>
		
		<input type="submit" name="Register" style="background-color: #0048D9; width: 100%; color: white; border-radius: 5px; padding-top: 5px; padding-bottom: 5px; font-weight: bold;" value="Register"/>
		</form>

		</div>
		
		
	</div>

	<script src="webjars/jquery/3.5.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>

