<!DOCTYPE html>
<html>
<head>
<link href="webjars/bootstrap/4.6.0/css/bootstrap.min.css"
	rel="stylesheet">
<style>
.center {
  margin-left: auto;
  margin-right: auto;
}
.button {
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

.button1 {
	background-color: #4CAF50;
} /* Green */
.button2 {
	background-color: #008CBA;
} /* Blue */
</style>
</head>
<body>
	<div class="container text-center">

		<h1>Welcome to Hospital Management System</h1><br><br>

		<table class="center">
			<tr>
				<td><a href="login"><button class="button button1">
							Login</button></a></td>


				<td><a href="register_selection"><button
							class="button button2">Signup</button></a></td>
			</tr>
		</table>
	</div>
	<script src="webjars/jquery/3.5.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>