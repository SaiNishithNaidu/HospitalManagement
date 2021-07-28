<%@ include file="HospitalAdmin/header.jspf"%>
<%@ include file="HospitalAdmin/navigation.jspf"%>
<%@ include file="HospitalAdmin/Billing.jspf"%>

<style>

span{
	color: red;
}

</style>

	<center><h2>Billing</h2></center>
	
	<form action="/BillingValue_h" method="get" modelAttribute="InPatientModel">
	
	<table>
		<tr>
		<td>
			<label>Patient Id <span>*</span></label>
			<input type="text" name="PATID" required="required" class="form-control" placeholder="PatientId" pattern="[A-Z]{3}[0-9]{6}"/>
			<p style="color: red; font-size: 14px;">&emsp;${PatientNotAvailiable }</p>
		</td>
		</tr>
		<tr>
		<td>
		 <input class="btn btn-primary" type="submit" name="Submit" value="Submit" />
		</td>
		</tr>
	</table>
	
	
	
	
	
	</form>
	
	
	
</div>
</div>
	<%@ include file="HospitalAdmin/footer.jspf"%>