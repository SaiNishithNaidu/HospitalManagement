<%@ include file="Patient/header.jspf"%>
<%@ include file="Patient/navigation.jspf"%>
<%@ include file="Patient/BookAppointment.jspf"%>
		<h1>Facilities Appointment</h1>
		<h3>Book an Appointment</h3>
<style>
table, th, td {
  padding-left: 50px;
  padding-right: 50px;
  padding-top: 20px;
  padding-top: 20px;
}


</style>
		
		
		<form action="/afterAppointment1" method="GET" modelAttribute="FacilityAppointmentModel" onsubmit="required()" name="form1">
		<table>
		 	<tr>
    			<td>
    				<label class="form-label">Choose a Facility:</label>
			    	<select name="Facility" id="Facility" class="form-control is-valid" style="height: 40px;">
						<option value="OPD">OPD</option>
						<option value="Dental Facility">Dental Facility</option>
						<option value="Ward Indoor Facility">Ward Indoor Facility</option>
						<option value="Minor OT/Dressing room">Minor OT/Dressing room</option>
						<option value="Physiotherapy">Physiotherapy</option>
						<option value="Laboratory Services">Laboratory Services</option>
						<option value="ECG Services">ECG Services</option>
						<option value="Pharmacy">Pharmacy</option>
						<option value="Radiology/X-Ray Facility">Radiology/X-Ray Facility</option>
						<option value="Ambulance Services">Ambulance Services</option>
					</select>
				</td>
    			<td>
    				<label class="form-label">Hospital Name*</label>
    				<input class="form-control is-valid"  type="text" name="Hospital_Name" placeholder="enter hospital name" required="required" minlength="0" maxlength="20" style="height: 40px; width: 200px;" />
					<p style="color: red;">${error}</p>
				</td>
  			</tr>
  			<tr>
    			<td> 
    				<label class="form-label">Date of Appointment</label>
    				<input class="form-control is-valid" type="date" name="Date_of_Appointment" required="required" />
    			</td>
    			<td> 
    				<label class="form-label">Time of Appointment</label>
					<input class="form-control is-valid" type="time" name="Time_of_Appointment" required="required" />
				</td>
  			</tr>
  			<tr>
    			<td colspan="2"> <label class="form-label">Remarks</label>
    			<div class="form-floating">
  				<textarea name="Remarks_of_Facility_Appointment" class="form-control" placeholder="enter your remarks" id="floatingTextarea2" style="height: 100px"></textarea>
				</div>
    			 </td>
  			</tr>
  			<tr>
  			 <td colspan="2">
    			 <center> <input class="btn btn-primary" type="submit" name="Submit" value="Submit" /></center>
    			 </td>
  			</tr>
		</table>
			</form>
		</div>
			<div class="six">
<%@include file="Patient/footer.jspf"%>












