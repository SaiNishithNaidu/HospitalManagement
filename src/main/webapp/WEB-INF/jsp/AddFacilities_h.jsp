<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ include file="HospitalAdmin/header.jspf"%>
<%@ include file="HospitalAdmin/navigation.jspf"%>
<%@ include file="HospitalAdmin/AddFacilities.jspf"%>

		<center><h1>Add Facility</h1></center>
		<h3 style="color: red;">${error}</h3>
		
<style>

td{
	padding-left: 20px;
	padding-right: 20px;
	padding-top: 5px;
	padding-bottom: 5px;
}
span{
	color: red;
}

</style>		


<form action="/afterAddFacilities" method="GET" modelAttribute="AddFacilitiesModel" onsubmit="required()" name="form1">
		
		<table>
			<tr>
			<td>
				<label>Hospital ID</label>
				<input  class="form-control" type="text" name="Hospital_ID" disabled value="${hospitalid}" /><br>
			</td>
			<td>
			<label>Hospital Name</label>
			 	<input class="form-control" type="text" name="Hospital_Name" disabled value="${hospitalname}" /><br>
			</td>
			</tr>
			<tr>
			<td colspan="2">
				<label for="Facility">Add Facility <span>*</span> </label> <br>
				<select name="Facility" id="Facility">
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
			</select></td>
			
			</tr>

			
			<tr>
			<td colspan="2"> <label class="form-label">Description <span>*</span></label>
				<div class="form-floating">
				<textarea name="Description_of_Facilities" class="form-control" placeholder="enter your Description" id="floatingTextarea2" style="height: 100px"></textarea>
				</div>
			
			</tr>
			
			
			<tr>
			<td colspan="2"> <label class="form-label">Remarks <span>*</span></label>
				<div class="form-floating">
				<textarea name="Remarks_of_Facilities" class="form-control" placeholder="enter your remarks" id="floatingTextarea2" style="height: 100px"></textarea>
				</div>
			
			</tr>
			<tr>
			<td colspan="2">
			<center> <input class="btn btn-primary" type="submit" name="Submit" value="Submit" /> </center>
			
			</td>
			
			
			</tr>
			

		
		</table>
			
	
</div>

	<%@ include file="HospitalAdmin/footer.jspf"%>
