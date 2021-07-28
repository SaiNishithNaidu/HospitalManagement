<%@page import="com.example.Project.Model.RegisterDoctorModel"%>
<%@page import="java.util.List"%>
<%@ include file="Patient/header.jspf" %>
<%@ include file="Patient/navigation.jspf" %>
<%@ include file="Patient/ViewHospital.jspf"%>
	
	<center><h2>Doctors</h2></center>
 <table class="table table-bordered table-hover">
		<thead>
			<tr>
					<th>DoctorIDs</th>
					<th>Doctor Name</th>
					<th>Specialty</th>
					<th>Experience</th>
			</tr>
		</thead>
		<tbody>
			<%
			int i = 1;
					List<String> s = (List) request.getAttribute("doctorID");
					List<RegisterDoctorModel> s1 = (List) request.getAttribute("DoctorDetails");
			%>
			<%
				for(int j=0;j<s.size();j++){
			%>
			<tr>
			<td><a href="/ViewHospitalDoctorID?DoctorID=<%=s.get(j)%>&HospitalName=${HospitalName}"><%="DOC"+ s.get(j)%></td>
			<td><%=s1.get(j).getFirst_Name()+" "+s1.get(j).getLast_Name()%></td>
			<td><%=s1.get(j).getSpeciality()%></td>
			<td><%=s1.get(j).getExperience()%></td>
			</tr>
			<%} %>
		</tbody>
	</table>
	
	
	
	</div>

<%@ include file="Patient/footer.jspf" %>