
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<style><%@include file="/WEB-INF/css/doctorRegister.css"%></style>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hospital Admin RegistrationPage</title>
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
			<form action="/afterRegister2" method="GET" modelAttribute="registerHospitalAdminModel" onsubmit="required()" name="form1">
		
		<h3>Register</h3>
		<label>Hospital Name</label><br>
		<input class="inputs" type="text" name="Hospital_Name"  placeholder="Hospital Name" required="required" /><br></br>
		
				
		<label>Address Lane 1</label><br>
		<input class="inputs" type="text" name="Address_Lane1"  placeholder="enter address" required="required" /><br></br>
		
		<label>Address Lane 2</label><br>
		<input class="inputs" type="text" name="Address_Lane2"  placeholder="enter address" required="required" /><br></br>
		
		<label>Address Lane 3</label><br>
		<input class="inputs" type="text" name="Address_Lane3"  placeholder="enter address" required="required" /><br></br>
		
	
		<label>City*</label><br>
		<input class="inputs" type="text" name="City"  placeholder="enter city" required="required" /><br></br>
		
		<label>State*</label><br>
		<input class="inputs" type="text" name="State"  placeholder="enter state" required="required" /><br></br>
		
		<label>Zip*</label><br>
		<input class="inputs" type="number" name="Zip"  placeholder="enter zip code" required="required" /><br></br>
		
		<label>Hospital Mobile Number</label><br>
		<input class="inputs" type="text" name="Hospital_Contact_Number"  placeholder="enter hospital mobile number " required="required" pattern="[6-9]{1}[0-9]{9}" /><br></br>
		
		<label>Hospital Fax Number</label><br>
		<input class="inputs" type="number" name="Hospital_Fax_Number"  placeholder="enter hospital fax number " required="required" /><br></br>
		
		<label>Hospital Website URL</label><br>
		<input class="inputs" type="text" name="Hospital_Website"  placeholder="enterwWebsite url " required="required" /><br></br>
		
		<input type="submit" name="Register" style="background-color: #0048D9; width: 100%; color: white; border-radius: 5px; padding-top: 5px; padding-bottom: 5px; font-weight: bold;" value="Register"/>
		</form>

		</div>
		
		
	</div>

	<script src="webjars/jquery/3.5.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>




