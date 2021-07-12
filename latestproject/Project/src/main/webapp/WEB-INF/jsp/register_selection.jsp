<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="webjars/bootstrap/4.6.0/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.button {
	background-color: #0000FF;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
</style>
</head>
<script>
	function myFunction() {
		if (document.getElementById('Patient').checked == true) {
			window.open('register_patient', '_self');
		}
		if (document.getElementById('Doctor').checked == true) {
			window.open('register_doctor', '_self');
		}
		if (document.getElementById('Hospital Admin').checked == true) {
			window.open('register_hospital_admin', '_self');
		}
	}
</script>
<body>
<h1>Select your role:</h1>
	<label>Patient</label>
	<input type="radio" name="radio" required="required" id="Patient" />
	<br>
	<br>
	<label>Doctor</label>
	<input type="radio" name="radio" required="required" id="Doctor" />
	<br>
	<br>
	<label>Hospital Admin</label>
	<input type="radio" name="radio" required="required"
		id="Hospital Admin" />
	<br>
	<br>
	<input type="submit" class="button" name="submit"
		onclick="myFunction()">
	<script src="webjars/jquery/3.5.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>