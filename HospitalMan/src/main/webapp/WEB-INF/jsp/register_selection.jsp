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
.col {
  float: left;
  width: 50%;
  margin: auto;
  padding: 0 50px;
  margin-top: 6px;
}
.fb {
  background-color: #3B5998;
  color: white;
}

.twitter {
  background-color: #55ACEE;
  color: white;
}

.google {
  background-color: #dd4b39;
  color: white;
}
/* Two-column layout */
.col {
  float: left;
  width: 50%;
  margin: auto;
  padding: 0 50px;
  margin-top: 6px;
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
<h1>Select your role:</h1><br><br>
 <div class="col">
        <a href="/register_patient" class="fb btn">
          <i class="fa fa-facebook fa-fw"></i> Sign Up as Patient 
         </a><br><br>
        <a href="/register_doctor" class="twitter btn">
          <i class="fa fa-twitter fa-fw"></i>Sign Up as Doctor
        </a><br><br>
        <a href="/register_hospital_admin" class="google btn"><i class="fa fa-google fa-fw">
          </i> Sign Up as Hospital Admin
        </a><br><br>
        </div>
      
<!--  <div class="col"> -->
<!-- 	<label>Patient</label> -->
	
<!-- 	<input type="radio" name="radio" required="required" id="Patient" /> -->
<!-- 	<br> -->
<!-- 	<br> -->
<!-- 	<label>Doctor</label> -->
<!-- 	<input type="radio" name="radio" required="required" id="Doctor" /> -->
<!-- 	<br> -->
<!-- 	<br> -->
<!-- 	<label>Hospital Admin</label> -->
<!-- 	<input type="radio" name="radio" required="required" -->
<!-- 		id="Hospital Admin" /> -->
<!-- 	<br> -->
<!-- 	<br> -->
	<script src="webjars/jquery/3.5.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>