<%@page import="com.example.Project.Model.RegisterDoctorModel"%>
<%@page import="java.util.List"%>
<%@ include file="Patient/header.jspf" %>
<%@ include file="Patient/navigation.jspf" %>
<%@ include file="Patient/ViewHospital.jspf"%>
	<center><h2>Doctor Details</h2></center>
 <table class="table table-bordered table-hover">
			<%
			int i = 1;
					List<RegisterDoctorModel> s = (List) request.getAttribute("DoctorDetails");
			%>
			<%
				for(int j=0;j<s.size();j++){
			%>
		
		<tr>
		<td>Name</td><td><%=s.get(j).getFirst_Name()+" "+s.get(j).getLast_Name()%></td>
		</tr>
		<tr>
		<td>DOB</td><td><%=s.get(j).getDOB()%></td>
		</tr>
		<tr>
		<td>Contact Number</td><td><%=s.get(j).getContact_Number()%></td>
		</tr>
		<tr>
		<td>Qualification</td><td><%=s.get(j).getQualification()%></td>
		</tr>
		<tr>
		<td>Speciality</td><td><%=s.get(j).getSpeciality()%></td>
		</tr>
		<tr>
		<td>Experience</td><td><%=s.get(j).getExperience()%></td>
		</tr>
		<tr>
		<td>Hospital Name</td><td><%=s.get(j).getHospital_Name()%></td>
		</tr>
		<tr>
		<td>Day of Availability</td><td><%=s.get(j).getDAY()%></td>
		</tr>
		<tr>
		<td>Time of Availability</td><td><%=s.get(j).getAvailable_From()%>  -  <%=s.get(j).getAvailable_From()%></td>
		</tr>
		
		<%} %>
	</table>
	
	
	
	</div>
<%@ include file="Patient/footer.jspf" %>