<%@ include file="Patient/header.jspf" %>
<%@ include file="Patient/navigation.jspf" %>
<%@ include file="Patient/ViewHospital.jspf"%>
		<center><h2>Hospital Details</h2></center>
		 <table class="table table-bordered">
		<tr>
		<td> <h4>Hospital Name :</h4></td><td><h4> ${HospitalName}</h4></td>
		</tr>
		<tr>
		<td> <h4>Hospital Contact Number :</h4></td><td><h4> ${HospitalContactNumber}</h4></td>
		</tr>
		<tr>
		<td> <h4>Hospital Fax Number :</h4></td><td><h4> ${HospitalFaxNumber}</h4></td>
		</tr>
		<tr>
		<td> <h4>Hospital Website :</h4></td><td><h4> ${HospitalWebsite}</h4></td>
		</tr>
		<tr>
		<td><a href="/ViewHospitalFacilities?HospitalID=${HospitalID}"><button  class="btn btn-success">Facilities</button></a></td>
		<td><a href="/ViewHospitalDoctor?HospitalID=${HospitalID}"><button  class="btn btn-success">Doctors</button></a></td>
	</table></div>
	</div>
	</div>
<%@ include file="Patient/footer.jspf" %>