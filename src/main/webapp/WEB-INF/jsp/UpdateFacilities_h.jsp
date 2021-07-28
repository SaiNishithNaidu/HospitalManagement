<%@page import="com.example.Project.Model.AddFacilitiesModel"%>
<%@page import="java.util.List"%>
<%@ include file="HospitalAdmin/header.jspf"%>
<%@ include file="HospitalAdmin/navigation.jspf"%>
<%@ include file="HospitalAdmin/UpdateFacilities.jspf"%>


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

		<center><h1>Availiable Facilities</h1></center>

		<table class="table table-bordered table-hover">
			<tr>
				<th>Facilities</th>
				<th>Description</th>
				<th>Remarks</th>
				<th>Remove</th>
			</tr>
			<%
			List<AddFacilitiesModel> s = (List) request.getAttribute("facilities");
			%>
			<%
			for (int j = 0; j < s.size(); j++) {
			%>
			<tr>
				<td><%=s.get(j).getFacility()%></td>
				<td><%=s.get(j).getDescription_of_Facilities()%></td>
				<td><%=s.get(j).getRemarks_of_Facilities()%></td>
				<td><button onclick="al()" class="btn btn-success">Delete</button></td>
			</tr>
			<script type="text/javascript">
			function al(){
				  if (confirm("Do you want to delete")) {
					  window.open('/updateFacilitiesDelete?facility=<%=s.get(j).getFacility()%>','_self');
					}
				}
			</script>
			<%
			}
			%>




		</table>
		<br>
		<br>

		<center><h1>Update Facilities</h1></center>
		<h3 style="color: red;">${error}</h3>
		
		
		
		
			<form action="/updateFacilities" method="GET" modelAttribute="addFacilitiesModel" onsubmit="required()" name="form1">
		<table>
		<tr>
		<td>
		
		<label for="Facility">Add Facility <span>*</span></label><br> 
		<select name="Facility" id="Facility">
				<option value="OPD">OPD</option>
				<option value="Dental Facility">Dental Facility</option>
				<option value="Ward Indoor Facility">Ward Indoor Facility</option>
				<option value="Minor OT/Dressing room">Minor OT/Dressing
					room</option>
				<option value="Physiotherapy">Physiotherapy</option>
				<option value="Laboratory Services">Laboratory Services</option>
				<option value="ECG Services">ECG Services</option>
				<option value="Pharmacy">Pharmacy</option>
				<option value="Radiology/X-Ray Facility">Radiology/X-Ray
					Facility</option>
				<option value="Ambulance Services">Ambulance Services</option>
			</select>
		</td>
		</tr>

		<tr>
		<td colspan="2"> <label class="form-label">Description</label>
		<div class="form-floating">
		<textarea name="Description_of_Facilities" class="form-control" placeholder="enter your Description" id="floatingTextarea2" style="height: 100px"></textarea>
		</div>
		</td>
		
		</tr>

		<tr>
		<td colspan="2"> <label class="form-label">Remarks</label>
			<div class="form-floating">
			<textarea name="Remarks_of_Facilities" class="form-control" placeholder="enter your remarks" id="floatingTextarea2" style="height: 100px"></textarea>
		</div>
		
		</td>
		</tr>
		
		<tr>
		<td colspan="2">
			<center> <input class="btn btn-primary" type="submit" name="Submit" value="Submit" /> </center>
			</td>
		
		</tr>

		</table>
		</form>
		
		
		
		
		
	
			

	</div>

	<%@ include file="HospitalAdmin/footer.jspf"%>