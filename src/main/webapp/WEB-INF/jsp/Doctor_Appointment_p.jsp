<%@ include file="Patient/header.jspf"%>
<%@ include file="Patient/navigation.jspf"%>
<%@ include file="Patient/BookAppointment.jspf"%>
<center><h1>Doctor Appointment</h1></center>

<h3>Book an Appointment</h3>
<h3 style="color: red;">${Success}</h3>


<style>

td{
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 5px;
	padding-bottom: 5px;
}

</style>
<form action="/afterAppointment" method="GET"
			modelAttribute="DoctorAppointmentModel" onsubmit="required()"
			name="form1">
<table>
  <tr>
  	<td>
  		<label>Hospital Name*</label><br>
  		 <input class="form-control" type="text" name="Hospital_Name" placeholder="enter hospital name"
				required="required" minlength="0" maxlength="20"/>
				<p style="color: red;">${errorHospitalName}</p>
  	
  	
  	</td>
  	<td>
  		<label>Doctor First Name*</label><br>
  		 <input class="form-control" type="text" name="Doctor_Name" placeholder="enter Doctor First name" required="required"
				minlength="0" maxlength="20" />
			<p style="color: red;">${errorDoctorName}</p>
  		
  	</td>
  </tr>
  <tr>
    <td>
    	 <label>Date of Appointment</label><br>
    	  <input class="form-control" type="date" name="Date_of_Appointment" required="required" /><br>
  	</td>
  	<td>
  		<label>Time of Appointment</label><br>
		<input class="form-control" type="time" name="Time_of_Appointment" required="required" /><br>
  	</td>
  </tr>
  
  
  <tr>
    <td colspan="2">
    	   <label class="form-label">Remarks</label>
    	  	<div class="form-floating">
    	  	<textarea name="Remarks_of_Doctor_Appointment" class="form-control" placeholder="enter your remarks" id="floatingTextarea2" style="height: 100px"></textarea>
			</div>
  	</td>
  	
  </tr>
   <tr>
    <td colspan="2">
    	<center><input type="submit" value="Submit" class="btn btn-primary"/></center>
  	</td>
  	
  </tr>
  
  
  
</table>
		</form>

	</div>
	<div class="six">

<%@ include file="Patient/footer.jspf" %>